package net.likzerd.create_rocketry;

import com.simibubi.create.AllBlocks;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.likzerd.create_rocketry.blocks.electrolyzer.ElectrolyzerBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static net.likzerd.create_rocketry.CreateRocketry.REGISTRATE;

public class CRBlocks {

    public static final BlockEntry<Block> BAUXITE_ROCK = REGISTRATE
            .block("bauxite_rock", Block::new)
            .initialProperties(() -> Blocks.ANDESITE)
            .transform(pickaxeOnly())
            .tag(BlockTags.NEEDS_STONE_TOOL)
            .defaultLoot()
            .simpleItem()
            .register();
    public static final BlockEntry<ElectrolyzerBlock> ELECTROLYZER = REGISTRATE
            .block("electrolyzer", ElectrolyzerBlock::new)
            .initialProperties(AllBlocks.MECHANICAL_MIXER)
            .transform(pickaxeOnly())
            .tag(BlockTags.NEEDS_STONE_TOOL)
            .defaultLoot()
            .simpleItem()
            .register();



    public static void register() {}

}
