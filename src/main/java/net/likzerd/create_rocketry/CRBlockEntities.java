package net.likzerd.create_rocketry;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.likzerd.create_rocketry.blocks.electrolyzer.ElectrolyzerBlockEntity;
import net.likzerd.create_rocketry.blocks.electrolyzer.ElectrolyzerInstance;
import net.likzerd.create_rocketry.blocks.electrolyzer.ElectrolyzerRenderer;

import static net.likzerd.create_rocketry.CreateRocketry.REGISTRATE;

public class CRBlockEntities {
    public static final BlockEntityEntry<ElectrolyzerBlockEntity> ELECTROLYZER =
            REGISTRATE.blockEntity("electrolyzer", ElectrolyzerBlockEntity::new)
            .instance(() -> ElectrolyzerInstance::new)
            .validBlocks(CRBlocks.ELECTROLYZER)
            .renderer(() -> ElectrolyzerRenderer::new)
            .register();

    public static void register() {}
}
