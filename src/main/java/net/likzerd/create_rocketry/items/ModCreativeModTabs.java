package net.likzerd.create_rocketry.items;

import net.likzerd.create_rocketry.CreateRocketry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateRocketry.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CREATE_ROCKETRY_TAB = CREATIVE_MODE_TABS.register("create_rocketry_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_BAUXITE.get()))
                    .title(Component.translatable("creativetab.create_rocketry_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BAUXITE.get());
                        pOutput.accept(ModItems.RAW_BAUXITE.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
