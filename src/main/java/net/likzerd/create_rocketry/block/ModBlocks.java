package net.likzerd.create_rocketry.block;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.Create;
import com.simibubi.create.content.kinetics.mixer.MechanicalMixerBlockEntity;
import com.simibubi.create.content.kinetics.mixer.MechanicalMixerRenderer;
import com.simibubi.create.content.kinetics.mixer.MixerInstance;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.likzerd.create_rocketry.CreateRocketry;
import net.likzerd.create_rocketry.items.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static net.likzerd.create_rocketry.CreateRocketry.REGISTRATE;

public class ModBlocks {

    public static final BlockEntry<Block> BAUXITE_ROCK = REGISTRATE
            .block("bauxite_rock", Block::new)
            .initialProperties(() -> Blocks.ANDESITE)
            .transform(pickaxeOnly())
            .tag(BlockTags.NEEDS_STONE_TOOL)
            .defaultLoot()
            .simpleItem()
            .register();
    public static final BlockEntry<Block> ELECTROLYZER = REGISTRATE
            .block("bauxite_rock", Block::new)
            .initialProperties(() -> Blocks.ANDESITE)
            .transform(pickaxeOnly())
            .tag(BlockTags.NEEDS_STONE_TOOL)
            .defaultLoot()
            .simpleItem()
            .register();



    public static void register() {}

}
