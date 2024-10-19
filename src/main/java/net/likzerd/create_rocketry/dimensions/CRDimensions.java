package net.likzerd.create_rocketry.dimensions;

import net.likzerd.create_rocketry.CreateRocketry;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import org.jetbrains.annotations.NotNull;

import java.util.OptionalLong;


public class CRDimensions {
    public static final ResourceKey<Level> SPACEDIM_KEY = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(CreateRocketry.MOD_ID, "spacedim"));
    public static final ResourceKey<DimensionType> SPACEDIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(CreateRocketry.MOD_ID, "spacedimtype"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(SPACEDIM_TYPE, new DimensionType(
                OptionalLong.of(6000),
                false,
                false,
                false,
                true,
                1,
                false,
                false,
                0,
                1000,
                1000,
                BlockTags.INFINIBURN_END,
                BuiltinDimensionTypes.OVERWORLD_EFFECTS,
                1.0f,
                new DimensionType.MonsterSettings(true, false, ConstantInt.of(0), 0)));
    }

    private static void bootstrapRegistries(@NotNull BootstapContext<LevelStem> context) {
        HolderGetter<DimensionType> typeLookUp = context.lookup(Registries.DIMENSION_TYPE);
    }

    public static void register() {
        System.out.println("Registering dimensions for " + CreateRocketry.MOD_ID);
    }

}
