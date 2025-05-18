package net.fdymcreep.minebackrooms.core.worldgen.dim;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class Level0WorldProvider extends WorldProvider {
    @Override
    public DimensionType getDimensionType() {
        return null;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new Level0ChunkGenerator(world);
    }

    @Override
    public boolean hasSkyLight() {
        return false;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }
}
