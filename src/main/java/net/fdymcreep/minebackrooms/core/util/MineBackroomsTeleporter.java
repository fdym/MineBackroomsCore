package net.fdymcreep.minebackrooms.core.util;

import net.fdymcreep.minebackrooms.core.CoreConfig;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.fluids.IFluidBlock;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static net.minecraft.init.Blocks.AIR;
import static net.minecraft.init.Blocks.BEDROCK;
import static net.minecraft.init.Blocks.STONE;

public class  MineBackroomsTeleporter implements ITeleporter {
    public BlockPos defaultRetryHandler(BlockPos pos, int radius) {
        Random random = new Random();
        return pos.add(random.nextInt(256) + 2 * radius, 0, random.nextInt(256) + 2 * radius);
    }

    @Override
    public void placeEntity(
            World world,
            Entity entity,
            float v) {
        BlockPos initialPos = entity.getPosition();
        for (int r = 0; r < CoreConfig.TELEPORTER_CONFIG.retryCount; r++) { // retry
            List<BlockPos> candidates = generateCandidates(initialPos, CoreConfig.TELEPORTER_CONFIG.radius);
            for (BlockPos pos : candidates) {
                if (isSafe(pos, world)) {
                    entity.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
                    return;
                }
            }
            initialPos = this.defaultRetryHandler(initialPos, CoreConfig.TELEPORTER_CONFIG.radius);
        }
        for (int dx = -CoreConfig.TELEPORTER_CONFIG.westOffset; dx <= CoreConfig.TELEPORTER_CONFIG.eastOffset; dx++) {
            for (int dy = -CoreConfig.TELEPORTER_CONFIG.belowOffset; dy <= CoreConfig.TELEPORTER_CONFIG.aboveOffset; dy++) {
                for (int dz = -CoreConfig.TELEPORTER_CONFIG.northOffset; dz <= CoreConfig.TELEPORTER_CONFIG.southOffset; dz++) {
                    world.setBlockState(entity.getPosition().add(dx, dy, dz), AIR.getDefaultState());
                }
            }
        }
        if (!world.getBlockState(entity.getPosition().down()).isOpaqueCube()) {
            world.setBlockState(entity.getPosition().down(), STONE.getDefaultState());
        }
    }

    protected static List<BlockPos> generateCandidates(BlockPos center, int radius) {
        List<BlockPos> candidates = new ArrayList<>();
        for (int dx = -radius; dx <= radius; dx++) {
            int lower_limit = (center.getY() - radius) < 0 ? center.getY() : radius;
            int high_limit = (center.getY() + radius) > 255 ? 255 - center.getY() : radius;
            for (int dy = -lower_limit; dy <= high_limit; dy++) {
                for (int dz = -radius; dz <= -radius; dz++) {
                    candidates.add(center.add(dx, dy, dz));
                }
            }
        }
        candidates.sort(Comparator.comparingDouble(pos -> pos.distanceSq(center)));
        return candidates;
    }

    protected static boolean isSafe(BlockPos pos, World world) {
        if (!world.isAirBlock(pos) || !world.isAirBlock(pos.up())) return false;
        if (!world.getBlockState(pos.down()).isFullCube() || world.getBlockState(pos.down()).getBlock().equals(BEDROCK)) return false;
        for (int dx = -CoreConfig.TELEPORTER_CONFIG.westOffset; dx <= CoreConfig.TELEPORTER_CONFIG.eastOffset; dx++) {
            for (int dy = -CoreConfig.TELEPORTER_CONFIG.belowOffset; dy <= CoreConfig.TELEPORTER_CONFIG.aboveOffset; dy++) {
                for (int dz = -CoreConfig.TELEPORTER_CONFIG.northOffset; dz <= CoreConfig.TELEPORTER_CONFIG.southOffset; dz++) {
                    if (IFluidBlock.class.isAssignableFrom(world.getBlockState(pos.add(dx, dy, dz)).getBlock().getClass())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
