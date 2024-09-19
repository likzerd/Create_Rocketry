package net.likzerd.create_rocketry.mixin.minecraft;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import static net.minecraft.world.level.Level.NETHER;
import static net.minecraft.world.level.Level.OVERWORLD;

@Mixin(ClientPacketListener.class)
public class ClientPacketListenerMixin {

    @Shadow private ClientLevel level;

    @WrapOperation(method = "handleRespawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;setScreen(Lnet/minecraft/client/gui/screens/Screen;)V"))
    public void removeLoadScreen(Minecraft instance, Screen screen, Operation<Void> original) {
        if (level != null && (level.dimension().equals(NETHER) || level.dimension().equals(OVERWORLD))) return;
        original.call(instance,screen);
    }
}
