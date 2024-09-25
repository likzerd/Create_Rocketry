package net.likzerd.create_rocketry;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.Create;
import com.simibubi.create.content.kinetics.mixer.MechanicalMixerBlockEntity;
import com.simibubi.create.content.kinetics.mixer.MechanicalMixerRenderer;
import com.simibubi.create.content.kinetics.mixer.MixerInstance;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.likzerd.create_rocketry.Electrolyzer.ElectrolyzerBlock;
import net.likzerd.create_rocketry.Electrolyzer.ElectrolyzerBlockEntity;
import net.likzerd.create_rocketry.Electrolyzer.ElectrolyzerInstance;
import net.likzerd.create_rocketry.Electrolyzer.ElectrolyzerRenderer;
import net.likzerd.create_rocketry.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class CRBlockEntities {
    private static final BlockEntityType<ElectrolyzerBlockEntity>

        ELECTROLYZER = CreateRocketry.REGISTRATE.blockEntity("electrolyzer", ElectrolyzerBlockEntity::new).instance(() -> {
            return ElectrolyzerInstance::new;
        }).validBlocks(new NonNullSupplier[]{ModBlocks.ELECTROLYZER}).renderer(() -> {
            return ElectrolyzerRenderer::new;
        }).register();


}
