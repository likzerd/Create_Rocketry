package net.likzerd.create_rocketry.blocks.electrolyzer;

import com.jozufozu.flywheel.api.Instancer;
import com.jozufozu.flywheel.api.MaterialManager;
import com.jozufozu.flywheel.api.instance.DynamicInstance;
import com.jozufozu.flywheel.core.materials.FlatLit;
import com.jozufozu.flywheel.core.materials.oriented.OrientedData;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.base.flwdata.RotatingData;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogInstance;
import com.simibubi.create.foundation.render.AllMaterialSpecs;
import com.simibubi.create.foundation.utility.AnimationTickHolder;
import net.minecraft.core.Direction;

public class ElectrolyzerInstance extends EncasedCogInstance implements DynamicInstance {
    private final RotatingData mixerHead;
    private final OrientedData mixerPole;
    private final ElectrolyzerBlockEntity mixer;

    public ElectrolyzerInstance(MaterialManager materialManager, ElectrolyzerBlockEntity blockEntity) {
        super(materialManager, blockEntity, false);
        this.mixer = blockEntity;
        this.mixerHead = (RotatingData)materialManager.defaultCutout().material(AllMaterialSpecs.ROTATING).getModel(AllPartialModels.MECHANICAL_MIXER_HEAD, this.blockState).createInstance();
        this.mixerHead.setRotationAxis(Direction.Axis.Y);
        this.mixerPole = (OrientedData)this.getOrientedMaterial().getModel(AllPartialModels.MECHANICAL_MIXER_POLE, this.blockState).createInstance();
        float renderedHeadOffset = this.getRenderedHeadOffset();
        this.transformPole(renderedHeadOffset);
        this.transformHead(renderedHeadOffset);
    }

    protected Instancer<RotatingData> getCogModel() {
        return this.materialManager.defaultSolid().material(AllMaterialSpecs.ROTATING).getModel(AllPartialModels.SHAFTLESS_COGWHEEL, this.blockEntity.getBlockState());
    }

    public void beginFrame() {
        float renderedHeadOffset = this.getRenderedHeadOffset();
        this.transformPole(renderedHeadOffset);
        this.transformHead(renderedHeadOffset);
    }

    private void transformHead(float renderedHeadOffset) {
        float speed = this.mixer.getRenderedHeadRotationSpeed(AnimationTickHolder.getPartialTicks());
        this.mixerHead.setPosition(this.getInstancePosition()).nudge(0.0F, -renderedHeadOffset, 0.0F).setRotationalSpeed(speed * 2.0F);
    }

    private void transformPole(float renderedHeadOffset) {
        this.mixerPole.setPosition(this.getInstancePosition()).nudge(0.0F, -renderedHeadOffset, 0.0F);
    }

    private float getRenderedHeadOffset() {
        return this.mixer.getRenderedHeadOffset(AnimationTickHolder.getPartialTicks());
    }

    public void updateLight() {
        super.updateLight();
        this.relight(this.pos.below(), new FlatLit[]{this.mixerHead});
        this.relight(this.pos, new FlatLit[]{this.mixerPole});
    }

    public void remove() {
        super.remove();
        this.mixerHead.delete();
        this.mixerPole.delete();
    }
}
