package com.trish.factory;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class BuildingCoreBlock extends BaseEntityBlock {
    private final BuildingType type;

    public BuildingCoreBlock(BuildingType type, Properties properties) {
        super(properties);
        this.type = type;
    }

    public BuildingType getBuildingType() {
        return type;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            if (level.getBlockEntity(pos) instanceof FactoryCoreBlockEntity core) {
                if (!core.isBuilt()) {
                    BlockPos chestPos = BuildingStructures.build(level, pos, type, player.getDirection());
                    core.activate(type, chestPos);
                    player.displayClientMessage(Component.literal(type.displayName + " построен. Доход идет в сундук внутри здания."), true);
                } else {
                    player.displayClientMessage(Component.literal(type.displayName + " уже работает. Сломай главный блок, чтобы доход прекратился."), true);
                }
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FactoryCoreBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null : createTickerHelper(type, ModBlockEntities.FACTORY_CORE.get(), FactoryCoreBlockEntity::serverTick);
    }
}
