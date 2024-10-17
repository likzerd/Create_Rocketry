package net.likzerd.create_rocketry.datagen;

import net.likzerd.create_rocketry.CreateRocketry;
import net.likzerd.create_rocketry.worldgen.CRBiomeModifiers;
import net.likzerd.create_rocketry.worldgen.CRConfiguredFeatures;
import net.likzerd.create_rocketry.worldgen.CRPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, CRConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, CRPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, CRBiomeModifiers::bootstrap);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(CreateRocketry.MOD_ID));
    }
}