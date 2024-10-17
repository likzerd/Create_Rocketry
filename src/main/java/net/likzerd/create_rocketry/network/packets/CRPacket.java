package net.likzerd.create_rocketry.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

public interface CRPacket {
    void write(@NotNull FriendlyByteBuf var1);
}
