package net.likzerd.create_rocketry.mixin.accessors.minecraft;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Map;

@Mixin(ClientLevel.class)
public interface ClientLevelAccessor {
    @Invoker("getAllMapData")
    Map<String, MapItemSavedData> invokeGetAllMapData();
    @Invoker("addMapData")
    void invokeAddMapData(Map<String, MapItemSavedData> mapData);
}
