package net.likzerd.create_rocketry.datagen;

import net.likzerd.create_rocketry.CreateRocketry;
import net.likzerd.create_rocketry.CRBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

@Deprecated(forRemoval = true)
public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CreateRocketry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider gProvider) {
//        this.tag(ModTags.Blocks.TAG_NAME)
//                .add(ModBlocks.BAUXITE_ROCK.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(CRBlocks.BAUXITE_ROCK.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(CRBlocks.BAUXITE_ROCK.get());
    }
}
