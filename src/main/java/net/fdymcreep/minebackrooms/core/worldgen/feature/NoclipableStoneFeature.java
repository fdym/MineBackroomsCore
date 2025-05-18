package net.fdymcreep.minebackrooms.core.worldgen.feature;

import net.fdymcreep.minebackrooms.core.CoreConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

import static net.fdymcreep.minebackrooms.core.block.BlockRegistryHandler.NOCLIPABLE_STONE;

public class NoclipableStoneFeature implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator iChunkGenerator, IChunkProvider iChunkProvider) {
        if (world.provider.getDimension() == 0) {
            for (int i = 0; i < CoreConfig.FEATURE_CONFIG.noclipableStoneGenProbability; i++) {
                BlockPos pos = new BlockPos(
                        chunkX * 16 + random.nextInt(16),
                        CoreConfig.FEATURE_CONFIG.noclipableStoneMinY + random.nextInt(CoreConfig.FEATURE_CONFIG.noclipableStoneMaxY - CoreConfig.FEATURE_CONFIG.noclipableStoneMinY),
                        chunkZ * 16 + random.nextInt(16)
                );
                WorldGenMinable generator = new WorldGenMinable(NOCLIPABLE_STONE.getDefaultState(), CoreConfig.FEATURE_CONFIG.noclipableStoneGenSize);
                generator.generate(world, random, pos);
            }
        }
    }
}
