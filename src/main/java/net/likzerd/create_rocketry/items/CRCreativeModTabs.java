package net.likzerd.create_rocketry.items;

import net.likzerd.create_rocketry.CreateRocketry;
import net.likzerd.create_rocketry.CRBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.likzerd.create_rocketry.CreateRocketry.MOD_ID;
import static net.likzerd.create_rocketry.CreateRocketry.REGISTRATE;

public class CRCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateRocketry.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CREATE_ROCKETRY_TAB = CREATIVE_MODE_TABS.register(MOD_ID,
            () -> CreativeModeTab.builder().icon(() -> CRItems.BAUXITE_DUST.get().getDefaultInstance())
                    .title(Component.translatable("itemGroup.create_rocketry_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(CRBlocks.BAUXITE_ROCK);
                        pOutput.accept(CRItems.CRUSHED_BAUXITE);
                        pOutput.accept(CRItems.BAUXITE_DUST);
                        pOutput.accept(CRItems.ALUMINIUM_INGOT);
                        pOutput.accept(CRItems.ALUMINIUM_NUGGET);
                        pOutput.accept((CRBlocks.ELECTROLYZER));
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
        REGISTRATE.setCreativeTab(CREATE_ROCKETRY_TAB);
    }
}
