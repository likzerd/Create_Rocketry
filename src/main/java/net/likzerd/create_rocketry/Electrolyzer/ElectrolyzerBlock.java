package net.likzerd.create_rocketry.Electrolyzer;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllShapes;
import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.content.kinetics.mixer.MechanicalMixerBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

    public class ElectrolyzerBlock extends KineticBlock implements IBE<MechanicalMixerBlockEntity>, ICogWheel {
        public ElectrolyzerBlock(BlockBehaviour.Properties properties) {
            super(properties);
        }

        public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
            return !AllBlocks.BASIN.has(worldIn.getBlockState(pos.below()));
        }

        public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
            return context instanceof EntityCollisionContext && ((EntityCollisionContext)context).getEntity() instanceof Player ? AllShapes.CASING_14PX.get(Direction.DOWN) : AllShapes.MECHANICAL_PROCESSOR_SHAPE;
        }

        public Direction.Axis getRotationAxis(BlockState state) {
            return Direction.Axis.Y;
        }

        public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
            return false;
        }

        public float getParticleTargetRadius() {
            return 0.85F;
        }

        public float getParticleInitialRadius() {
            return 0.75F;
        }

        public IRotate.SpeedLevel getMinimumRequiredSpeedLevel() {
            return SpeedLevel.MEDIUM;
        }

        public Class<MechanicalMixerBlockEntity> getBlockEntityClass() {
            return MechanicalMixerBlockEntity.class;
        }

        public BlockEntityType<? extends MechanicalMixerBlockEntity> getBlockEntityType() {
            return (BlockEntityType) AllBlockEntityTypes.ELECTROLYZER.get();
        }

        public boolean isPathfindable(BlockState state, BlockGetter reader, BlockPos pos, PathComputationType type) {
            return false;
        }
    }

