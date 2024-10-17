package net.likzerd.create_rocketry.network;

import net.likzerd.create_rocketry.CreateRocketry;
import net.likzerd.create_rocketry.network.packets.CRPacket;
import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Function;

public class CRPackets {

    private record PacketEntry<T extends CRPacket>(Class<T> type, Function<FriendlyByteBuf, T> factory) {

        private static <R extends CRPacket> PacketEntry<R> register(Class<R> type, Function<FriendlyByteBuf, R> factory) {
            PacketEntry<R> entry = new PacketEntry<>(type, factory);
            PacketChannel packetChannel = CreateRocketry.PACKET_CHANNEL;
            Class<R> clazz = entry.type;
            Function<FriendlyByteBuf, R> packetFactory = entry.factory;
            packetChannel.registerPacket(clazz, packetFactory);
            return entry;

        }
    }
    public static void register() {
    }
}
