package net.fdymcreep.minebackrooms.core.util;

import net.minecraft.util.math.BlockPos;

public class Level0Teleporter extends MineBackroomsTeleporter{
    @Override
    public BlockPos defaultRetryHandler(BlockPos pos, int radius) {
        BlockPos origin = super.defaultRetryHandler(pos, radius);
        return new BlockPos(origin.getX(), 5, origin.getZ());
    }
}
