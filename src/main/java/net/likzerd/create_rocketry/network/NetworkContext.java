package net.likzerd.create_rocketry.network;

import org.jetbrains.annotations.NotNull;

public interface NetworkContext {
    void enqueueWork(@NotNull Runnable var1);

    default void handled(){
        setPacketHandled(true);
    }

    void setPacketHandled(boolean var1);
}
