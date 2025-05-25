package net.fdymcreep.minebackrooms.core.worldgen.dim;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;

public abstract class Level0WorldProvider extends WorldProvider {
    @MethodsReturnNonnullByDefault
    @Override
    public abstract DimensionType getDimensionType();

    @MethodsReturnNonnullByDefault
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
