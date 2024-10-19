package net.likzerd.create_rocketry.client;

import net.likzerd.create_rocketry.mixin.accessors.minecraft.ClientLevelAccessor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class ClientWorldLoader {
    private static final Map<ResourceKey<Level>, ClientLevel> clientWorldMap = new HashMap<>();
    public static final Map<ResourceKey<Level>, LevelRenderer> worldRendererMap = new HashMap<>();
    @Nullable
    public static LevelRenderer currentSecondRenderer;
    private static final Minecraft client = Minecraft.getInstance();
    private static boolean isCreatingClientWorld = false;
    private static ClientLevel createClientWorld(ResourceKey<Level> dimension, ResourceKey<DimensionType> dimensionType) {
        Validate.notNull(client.player);
        Validate.isTrue(client.isSameThread());


        client.getProfiler().push("create_world");

        int chunkLoadDistance = 3;// my own chunk manager doesn't need it

        LevelRenderer worldRenderer = new LevelRenderer(
                client,
                client.getEntityRenderDispatcher(),
                client.getBlockEntityRenderDispatcher(),
                client.renderBuffers()
        );

        ClientLevel newWorld;
        try {
            ClientPacketListener mainNetHandler = client.player.connection;
            Map<String, MapItemSavedData> mapData = ((ClientLevelAccessor) client.level).invokeGetAllMapData();

            ResourceKey<DimensionType> dimensionTypeKey = dimensionType;

            ClientLevel.ClientLevelData currentProperty =
                    client.level.getLevelData();
            RegistryAccess registryManager = mainNetHandler.registryAccess();
            int simulationDistance = client.level.getServerSimulationDistance();

            Holder<DimensionType> dimensionTypeHolder = registryManager
                    .registryOrThrow(Registries.DIMENSION_TYPE)
                    .getHolderOrThrow(dimensionTypeKey);

            ClientLevel.ClientLevelData properties = new ClientLevel.ClientLevelData(
                    currentProperty.getDifficulty(),
                    currentProperty.isHardcore(),
                    currentProperty.isFlat
            );
            newWorld = new ClientLevel(
                    mainNetHandler,
                    properties,
                    dimension,
                    dimensionTypeHolder,
                    chunkLoadDistance,
                    simulationDistance,// seems that client world does not use this
                    client::getProfiler,
                    worldRenderer,
                    client.level.isDebug(),
                    client.level.getBiomeManager().biomeZoomSeed
            );

            // all worlds share the same map data map
            ((ClientLevelAccessor) newWorld).invokeAddMapData(mapData);
        }
        catch (Exception e) {
            throw new IllegalStateException(
                    "Creating Client World " + dimension + " " + clientWorldMap.keySet(),
                    e
            );
        }

        worldRenderer.setLevel(newWorld);

        // there are two "reload" methods
        worldRenderer.onResourceManagerReload(client.getResourceManager());

        clientWorldMap.put(dimension, newWorld);
        worldRendererMap.put(dimension, worldRenderer);

        isCreatingClientWorld = false;

        client.getProfiler().pop();

        return newWorld;
    }
}