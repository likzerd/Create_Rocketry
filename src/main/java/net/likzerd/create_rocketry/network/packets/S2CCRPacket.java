package net.likzerd.create_rocketry.network.packets;

import net.likzerd.create_rocketry.network.ClientNetworkContext;
import org.jetbrains.annotations.NotNull;

public interface S2CCRPacket extends CRPacket {
    void handle(@NotNull ClientNetworkContext var1);
}
