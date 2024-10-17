package net.likzerd.create_rocketry.network.packets;

import net.likzerd.create_rocketry.network.ServerNetworkContext;
import org.jetbrains.annotations.NotNull;

public interface C2SCRPacket extends CRPacket {
    void handle(@NotNull ServerNetworkContext var1);
}
