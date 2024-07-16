package net.likzerd.create_rocketry.items;

import net.likzerd.create_rocketry.CreateRocketry;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreateRocketry.MOD_ID);

    public static final RegistryObject<Item> BAUXITE = ITEMS.register("bauxite",
            () -> new Item(new Item.Properties ()));
    public static final RegistryObject<Item> RAW_BAUXITE = ITEMS.register ("raw_bauxite",
            () -> new Item(new Item.Properties ()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
