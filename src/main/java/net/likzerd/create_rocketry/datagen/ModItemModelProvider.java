package net.likzerd.create_rocketry.datagen;

import net.likzerd.create_rocketry.CreateRocketry;
import net.likzerd.create_rocketry.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

@Deprecated(forRemoval = true)
public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CreateRocketry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
//        simpleItem(ModItems.ALUMINIUM_INGOT);
//        simpleItem(ModItems.ALUMINIUM_NUGGET);
//        simpleItem(ModItems.BAUXITE_DUST);
//        simpleItem(ModItems.CRUSHED_BAUXITE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CreateRocketry.MOD_ID, "item/" + item.getId().getPath()));
    }
}
