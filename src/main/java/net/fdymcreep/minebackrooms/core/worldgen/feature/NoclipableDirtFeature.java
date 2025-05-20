package net.fdymcreep.minebackrooms.core.worldgen.feature;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

import static net.fdymcreep.minebackrooms.core.block.BlockRegistryHandler.NOCLIPABLE_DIRT;

public class NoclipableDirtFeature implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator iChunkGenerator, IChunkProvider iChunkProvider) {
        if (world.provider.getDimension() == 0) {
            if (random.nextInt(10000) < 5) {
                BlockPos blockPos = new BlockPos(chunkX * 16 + 8, 255 - 1, chunkZ * 16 + 8);
                while (world.getBlockState(blockPos).getBlock().equals(Blocks.AIR)) {
                    if (blockPos.getY() == 0) return;
                    blockPos = blockPos.down();
                }
                world.setBlockState(blockPos.up(), NOCLIPABLE_DIRT.getDefaultState());
            }
        }
    }
}
