package net.likzerd.create_rocketry.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;


public class ClientWorldChangingManager {
    public static final Minecraft client = Minecraft.getInstance();
    public static void manageTeleport(ResourceKey<Level> dimension, ResourceKey<DimensionType> dimensionType) {
        ClientLevel fromLevel = client.level;
        ResourceKey<Level> fromDimension = fromLevel.dimension();
        /*TODO change to space dimension when it is made,
        *  and set height for escaping the atmosphere to the planet's max height*/

        ResourceKey<Level> toDimension = dimension;
        if (client.player.position().y>100 && (fromDimension != toDimension)) {
            changeDimension(fromDimension,toDimension,dimensionType);
        }
    }
    private static void changeDimension(ResourceKey<Level> fromDimension, ResourceKey<Level> toDimension, ResourceKey<DimensionType> toDimensionType) {

//        if (tickTimeForTeleportation <= teleportTickTimeLimit) {
//            Helper.log("Client player teleportation rejected");
//            return;
//        }
//
//        lastTeleportGameTime = tickTimeForTeleportation;
//
//        LocalPlayer player = client.player;
//        Validate.isTrue(player != null);
//
//        float tickDelta = RenderStates.getPartialTick();
//
//
//        ClientLevel fromWorld = client.level;
//
//        if (fromDimension != toDimension) {
//            ClientLevel toWorld = ClientWorldLoader.getWorld(toDimension);
//
//            changePlayerDimension(player, fromWorld, toWorld);
//        }
//
//        McHelper.updateBoundingBox(player);
//
//        McHelper.adjustVehicle(player);
//
//        //because the teleportation may happen before rendering
//        //but after pre render info being updated
//        RenderStates.updatePreRenderInfo(tickDelta);
//        //placeholder
////        System.out.println("Y>100");
//        client.se
    }
}
