package net.likzerd.create_rocketry;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.likzerd.create_rocketry.dimensions.CRDimensions;
import net.likzerd.create_rocketry.items.CRCreativeModTabs;
import net.likzerd.create_rocketry.items.CRItems;
import net.likzerd.create_rocketry.network.CRPackets;
import net.likzerd.create_rocketry.network.PacketChannel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CreateRocketry.MOD_ID)
public class CreateRocketry {

    public static final ResourceLocation NETWORK_CHANNEL = asResource("main");

    public static final PacketChannel PACKET_CHANNEL = new PacketChannel();

    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "create_rocketry";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    /**REGISTRATE.
     * Use basically anywhere a {@link DeferredRegister} would be used.
     */
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    public CreateRocketry () {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        REGISTRATE.registerEventListeners(modEventBus);

        CRBlocks.register();
        CRBlockEntities.register();
        CRItems.register();
        CRPackets.register();
        CRCreativeModTabs.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        CRDimensions.register();
    }

    @NotNull
    public static ResourceLocation asResource(@NotNull String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey () == CreativeModeTabs.INGREDIENTS) {

        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
