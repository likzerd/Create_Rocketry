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

    public static final RegistryObject<Item> BAUXITE_ROCK = ITEMS.register ("bauxite_rock",
            () -> new Item(new Item.Properties ()));
    public static final RegistryObject<Item> CRUSHED_BAUXITE = ITEMS.register ("crushed_bauxite",
            () -> new Item(new Item.Properties ()));
    public static final RegistryObject<Item> BAUXITE_DUST = ITEMS.register ("bauxite_dust",
            () -> new Item(new Item.Properties ()));
    public static final RegistryObject<Item> ALUMINIUM_NUGGET = ITEMS.register ("aluminium_nugget",
            () -> new Item(new Item.Properties ()));
    public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register ("aluminium_ingot",
            () -> new Item(new Item.Properties ()));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
