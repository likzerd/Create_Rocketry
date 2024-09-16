package net.likzerd.create_rocketry.items;

import net.likzerd.create_rocketry.CreateRocketry;
import net.likzerd.create_rocketry.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.likzerd.create_rocketry.CreateRocketry.MOD_ID;
import static net.likzerd.create_rocketry.CreateRocketry.REGISTRATE;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateRocketry.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CREATE_ROCKETRY_TAB = CREATIVE_MODE_TABS.register(MOD_ID,
            () -> CreativeModeTab.builder().icon(() -> ModItems.BAUXITE_DUST.get().getDefaultInstance())
                    .title(Component.translatable("itemGroup.create_rocketry_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.BAUXITE_ROCK);
                        pOutput.accept(ModItems.CRUSHED_BAUXITE);
                        pOutput.accept(ModItems.BAUXITE_DUST);
                        pOutput.accept(ModItems.ALUMINIUM_INGOT);
                        pOutput.accept(ModItems.ALUMINIUM_NUGGET);
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
        REGISTRATE.setCreativeTab(CREATE_ROCKETRY_TAB);
    }
}
