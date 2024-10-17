package net.likzerd.create_rocketry.network;

import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

public interface ServerNetworkContext extends NetworkContext {
    @NotNull
    ServerPlayer getSender();
}
