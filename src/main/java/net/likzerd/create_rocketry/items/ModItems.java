package net.likzerd.create_rocketry.items;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.likzerd.create_rocketry.CreateRocketry;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.likzerd.create_rocketry.CreateRocketry.REGISTRATE;

public class ModItems {

    public static final ItemEntry<Item> CRUSHED_BAUXITE = REGISTRATE
            .item("crushed_bauxite", Item::new)
            .register();
    public static final ItemEntry<Item> BAUXITE_DUST = REGISTRATE
            .item("bauxite_dust", Item::new)
            .register();
    public static final ItemEntry<Item> ALUMINIUM_NUGGET = REGISTRATE
            .item("aluminium_nugget", Item::new)
            .register();
    public static final ItemEntry<Item> ALUMINIUM_INGOT = REGISTRATE
            .item("aluminium_ingot",Item::new)
            .register();





    public static void register() {}

}
