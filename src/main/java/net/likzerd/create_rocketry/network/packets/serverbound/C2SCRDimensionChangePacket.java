package net.likzerd.create_rocketry.network.packets.serverbound;

import net.likzerd.create_rocketry.network.ServerNetworkContext;
import net.likzerd.create_rocketry.network.packets.C2SCRPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class C2SCRDimensionChangePacket implements C2SCRPacket {

    private final ResourceKey<Level> toDimension;

    public C2SCRDimensionChangePacket(ResourceKey<Level> toDimension) {
        this.toDimension = toDimension;
    }

    @Override
    public void handle(@NotNull ServerNetworkContext var1) {

    }

    @Override
    public void write(@NotNull FriendlyByteBuf var1) {
    }
}
