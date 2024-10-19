package net.likzerd.create_rocketry.dimension;


import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraftforge.event.server.ServerLifecycleEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.OptionalLong;

@Mod.EventBusSubscriber(modid = "create_rocketry")
public class DimRegistry {
    public static final ResourceKey<LevelStem> VOID_DIMENSION = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation("create_rocketry", "void_dimension"));

    public static final DeferredRegister<DimensionType> DIMENSION_TYPES = DeferredRegister.create(ForgeRegistries.Keys.DIMENSION_TYPES, "create_rocketry");

    public static final RegistryObject<DimensionType> VOID_DIMENSION_TYPE = DIMENSION_TYPES.register("void_dimension",
            () -> DimensionType.create(
                    OptionalLong.empty(),
                    false,
                    false,
                    false,
                    false,
                    1.0,
                    false,
                    false,
                    false,
                    256,
                    new ResourceLocation("minecraft:infiniburn_overworld"),
                    DimensionType.MIN_Y,
                    0.0f
            ));

    @SubscribeEvent
    public static void onServerStarting(ServerLifecycleEvent event) {
        event.getServer().registryAccess().registryOrThrow(Registries.LEVEL_STEM).register(VOID_DIMENSION, createVoidDimension(event.getServer().registryAccess().registryOrThrow(Registries.STRUCTURE_SET)));
    }

    private static LevelStem createVoidDimension(Registry<StructureSet> structureSets) {
        return new LevelStem(VOID_DIMENSION_TYPE.getHolder().orElseThrow(), new VoidChunkGenerator(structureSets, VOID_DIMENSION_TYPE.getHolder().orElseThrow()));
    }
}


