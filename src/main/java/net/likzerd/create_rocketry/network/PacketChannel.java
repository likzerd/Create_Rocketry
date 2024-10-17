package net.likzerd.create_rocketry.network;

import net.likzerd.create_rocketry.CreateRocketry;
import net.likzerd.create_rocketry.network.packets.C2SCRPacket;
import net.likzerd.create_rocketry.network.packets.CRPacket;
import net.likzerd.create_rocketry.network.packets.S2CCRPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class PacketChannel {
    private final SimpleChannel channel;
    private int id;

    public PacketChannel() {
        this.channel = NetworkRegistry.newSimpleChannel(CreateRocketry.NETWORK_CHANNEL, () -> "1", "1"::equals, "1"::equals);
        this.id = 0;
    }

    public <T extends CRPacket> void registerPacket(Class<T> clazz, Function<FriendlyByteBuf, T> decode) {
        this.channel.registerMessage(this.id++, clazz, CRPacket::write, decode, (packet, ctx) -> {
            if (ctx.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
                ((C2SCRPacket)packet).handle(this.serverContext(ctx.get()));
            } else {
                ((S2CCRPacket)packet).handle(this.clientContext(ctx.get()));
            }

        });
    }

    private ClientNetworkContext clientContext(final NetworkEvent.Context ctx) {
        return new ClientNetworkContext() {
            public void handled() {
            }

            public void enqueueWork(Runnable runnable) {
                ctx.enqueueWork(runnable);
            }

            public void setPacketHandled(boolean value) {
                ctx.setPacketHandled(value);
            }
        };
    }

    private ServerNetworkContext serverContext(final NetworkEvent.Context ctx) {
        return new ServerNetworkContext() {
            public void handled() {
            }

            public ServerPlayer getSender() {
                return ctx.getSender();
            }

            public void enqueueWork(Runnable runnable) {
                ctx.enqueueWork(runnable);
            }

            public void setPacketHandled(boolean value) {
                ctx.setPacketHandled(value);
            }
        };
    }

    public void sendToNear(Level world, BlockPos pos, int range, S2CCRPacket message) {
        this.channel.send(PacketDistributor.NEAR.with(PacketDistributor.TargetPoint.p(pos.getX(), pos.getY(), pos.getZ(), range, world.dimension())), message);
    }

    public void sendToServer(C2SCRPacket packet) {
        this.channel.send(PacketDistributor.SERVER.noArg(), packet);
    }

    public void sendToClientsTracking(S2CCRPacket packet, Entity entity) {
        this.channel.send(PacketDistributor.TRACKING_ENTITY.with(() -> entity), packet);
    }

    public void sendToClientsTrackingAndSelf(S2CCRPacket packet, ServerPlayer player) {
        this.channel.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> player), packet);
    }

    public void sendTo(@NotNull S2CCRPacket packet, @NotNull ServerPlayer player) {
        this.channel.send(PacketDistributor.PLAYER.with(() -> player), packet);
    }
}
