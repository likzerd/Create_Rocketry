package net.likzerd.create_rocketry.mixin.minecraft;

import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.blaze3d.platform.WindowEventHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.LevelLoadingScreen;
import net.minecraft.client.gui.screens.ProgressScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.server.Services;
import net.minecraft.server.players.GameProfileCache;
import net.minecraft.util.thread.ReentrantBlockableEventLoop;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraftforge.client.extensions.IForgeMinecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.LevelEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import javax.annotation.Nullable;
import java.io.File;
import java.util.concurrent.Executor;

import static net.minecraft.world.level.Level.NETHER;
import static net.minecraft.world.level.Level.OVERWORLD;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin extends ReentrantBlockableEventLoop<Runnable> implements WindowEventHandler, IForgeMinecraft {
    @Shadow @Nullable public ClientLevel level;

    public MinecraftMixin(String p_18765_) {
        super(p_18765_);
    }

    @Shadow protected abstract void updateLevelInEngines(@org.jetbrains.annotations.Nullable ClientLevel pLevel);

    @Shadow public abstract boolean isLocalServer();

    @Shadow @Final private YggdrasilAuthenticationService authenticationService;

    @Shadow @Final public File gameDirectory;

    @Shadow protected abstract void updateScreenAndTick(Screen pScreen);

    /**
     * @author GuyApooye
     * @reason remove the mf loading screen
     */
    @Overwrite
    public void setLevel(ClientLevel pLevelClient) {
        if (level != null) {
            MinecraftForge.EVENT_BUS.post(new LevelEvent.Unload(this.level));
        }
        System.out.println("did the mixin even fk load?");
        if (pLevelClient == null || !(pLevelClient.dimension().equals(NETHER) || pLevelClient.dimension().equals(OVERWORLD))) {
            ProgressScreen progressscreen = new ProgressScreen(true);
            progressscreen.progressStartNoAbort(Component.translatable("connect.joining"));
            this.updateScreenAndTick(progressscreen);
        }

        this.level = pLevelClient;
        this.updateLevelInEngines(pLevelClient);
        if (!this.isLocalServer()) {
            Services services = Services.create(this.authenticationService, this.gameDirectory);
            services.profileCache().setExecutor(this);
            SkullBlockEntity.setup(services, this);
            GameProfileCache.setUsesAuthentication(false);
        }

    }
}
