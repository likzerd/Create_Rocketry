package net.likzerd.create_rocketry.dimension;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class VoidChunkGenerator {

    public VoidChunkGenerator(Registry<StructureSet> structureSets, Holder<LevelStem> levelStem) {
        super();
    }

    public void applyCarvers(WorldGenRegion region, long seed, RandomState randomState, BiomeManager biomeManager, StructureTemplateManager structureManager, ChunkAccess chunkAccess, GenerationStep.Carving carvingStep) {
        // No carvers in a void world
    }

    public CompletableFuture<ChunkAccess> fillFromNoise(Executor executor, Blender blender, RandomState randomState, StructureTemplateManager structureManager, ChunkAccess chunkAccess) {
        return CompletableFuture.completedFuture(chunkAccess);
    }

    public void buildSurface(WorldGenRegion region, StructureTemplateManager structureManager, RandomState randomState, ChunkAccess chunkAccess) {
        // No surface in a void world
    }

    public void spawnOriginalMobs(WorldGenRegion region) {
        // No mobs in a void world
    }
}
