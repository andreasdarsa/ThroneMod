package net.andreasdarsa.throne_mod.block.custom;

import com.mojang.serialization.MapCodec;
import net.andreasdarsa.throne_mod.entity.ModEntity;
import net.andreasdarsa.throne_mod.entity.custom.ThroneEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ThroneBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<ThroneBlock> CODEC = simpleCodec(ThroneBlock::new);
    /** may change according to the design of the block */
    public static final VoxelShape SHAPE = Block.box(3.0,0.0,3.0,13.0,16.0,13.0);

    public ThroneBlock(Properties pProperties){
        super(pProperties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide()){
            Entity entity = null;
            List<ThroneEntity> entities = level.getEntities(ModEntity.THRONE.get(), new AABB(pos), throne -> true);
            if (entities.isEmpty()){
                entity = ModEntity.THRONE.get().spawn((ServerLevel) level, pos, MobSpawnType.TRIGGERED);
            }
            else{
                entity = entities.get(0);
            }
            player.startRiding(entity);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
}
