package net.fdymcreep.minebackrooms.core.worldgen.dim;

import net.fdymcreep.minebackrooms.core.block.BlockRegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;

import javax.annotation.Nullable;
import java.util.*;

import static net.minecraft.init.Blocks.AIR;
import static net.minecraft.init.Blocks.BEDROCK;

public class Level0ChunkGenerator implements IChunkGenerator {
    protected final World world;
    protected final Random random;

    public static final int OPEN = 0;
    public static final int DOOR = 1;
    public static final int WALL = 2;

    protected static final Block BRICKS = BlockRegistryHandler.LEVEL0_BRICKS;
    protected static final Block LIGHT = BlockRegistryHandler.LEVEL0_LIGHT;

    public Level0ChunkGenerator(World world) {
        this.world = world;
        this.random = new Random(world.getSeed());
    }

    public Level0ChunkGenerator(World world, Random random) {
        this.world = world;
        this.random = random;
    }

    @Override
    public Chunk generateChunk(int chunkX, int chunkZ) {
        ChunkPrimer primer = new ChunkPrimer();

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                primer.setBlockState(x, 0, z, BEDROCK.getDefaultState());

                for (int y = 1; y < 5; y++) {
                    primer.setBlockState(x, y, z, BRICKS.getDefaultState());
                }

                for (int y = 5; y < 9; y++) {
                    if (Arrays.asList(0, 7, 8, 15).contains(x) && Arrays.asList(0, 7, 8, 15).contains(y)) {
                        primer.setBlockState(x, y, z, BRICKS.getDefaultState());
                    }
                }

                for (int y = 9; y < 14; y++) {
                    if (((x + 4) % 8 <= 1) && ((z + 4) % 8 <= 0) && (y == 9)) {
                        primer.setBlockState(x, y, z, LIGHT.getDefaultState());
                    } else {
                        primer.setBlockState(x, y, z, BRICKS.getDefaultState());
                    }
                }
                primer.setBlockState(x, 14, z, BEDROCK.getDefaultState());
            }
        }

        for (int x : new int[] {0, 8}) {
            for (int z : new int[] {0, 8}) {
                List<Integer> wallTypes = CheckWallType(
                        world,
                        toAbsolutePos(chunkX, chunkZ, x, 5, z),
                        random
                );
                for (int facing = 0; facing < 4; facing++) {
                    primer = buildWall(primer, facing, wallTypes.get(facing), new BlockPos(x, 5, z));
                }
            }
        }

        Chunk chunk = new Chunk(this.world, primer, chunkX, chunkZ);
        chunk.generateSkylightMap();
        return chunk;
    }

    public static final Vec3i[][] CHECK_POS = {
            {new Vec3i(2, 0, -1), new Vec3i(3, 5, -1)}, // north
            {new Vec3i(8, 0, 2), new Vec3i(8, 0, 3)}, // east
            {new Vec3i(5, 0, 8), new Vec3i(4, 0, 8)}, // south
            {new Vec3i(-1, 0, 5), new Vec3i(-1, 0, 4)} // west
    };

    public static BlockPos toAbsolutePos(int chunkX, int chunkZ, int x, int y, int z) {
        return new BlockPos(chunkX * 16 + x, y, chunkZ * 16 + z);
    }
    
    public List<Integer> CheckWallType(World world, BlockPos originPos, Random random) {
        List<Integer> result = new ArrayList<>();
        BlockPos pos = originPos;
        for (int facing = 0; facing < 4; facing++) {
            for (int i = 0; i < 2; i++) {
                pos = pos.add(CHECK_POS[facing][i]);
                if (!world.isBlockLoaded(pos)) {
                    if ((!result.contains(OPEN)) && (!result.contains(DOOR))) {
                        result.add(random.nextInt(2));
                    } else {
                        result.add(random.nextInt(3));
                    }
                    break;
                } else {
                    if ((i == 0) && world.getBlockState(pos).getBlock().equals(AIR)) {
                        result.add(OPEN);
                    } else {
                        result.add(world.getBlockState(pos).getBlock().equals(AIR) ? DOOR : WALL);
                    }
                }
                pos = originPos;
            }
        }
        return result;
    }

    public static final Vec3i[] POS_OFFSET = {
            new Vec3i(1, 0, 0), new Vec3i(7, 0, 1), new Vec3i(6, 0, 7), new Vec3i(0, 0, 6)
    };
    public static final Vec3i[] STEP = {
            new Vec3i(1, 0, 0), new Vec3i(0, 0, 1), new Vec3i(-1, 0, 0), new Vec3i(0, 0, -1)
    };

    public ChunkPrimer buildWall(ChunkPrimer origin, int facing, int wallType, BlockPos originPos) {
        if (wallType == OPEN) return origin;
        BlockPos pos = originPos.add(POS_OFFSET[facing]);
        for (int i = 0; i < 6; i++) {
            if (((i == 2) || (i == 3)) && wallType == DOOR) {
                origin.setBlockState(pos.getX(), pos.up(3).getY(), pos.getZ(), BRICKS.getDefaultState());
            } else {
                for (int y = 0; y < 4; y++) {
                    origin.setBlockState(
                            pos.getX(), pos.up(y).getY(), pos.getZ(), BRICKS.getDefaultState()
                    );
                }
            }
            pos = pos.add(STEP[facing]);
        }
        return origin;
    }

    @Override
    public void populate(int i, int i1) {}

    @Override
    public boolean generateStructures(Chunk chunk, int i, int i1) {
        return false;
    }

    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType enumCreatureType, BlockPos blockPos) {
        return Collections.emptyList();
    }

    @Nullable
    @Override
    public BlockPos getNearestStructurePos(World world, String s, BlockPos blockPos, boolean b) {
        return null;
    }

    @Override
    public void recreateStructures(Chunk chunk, int i, int i1) {}

    @Override
    public boolean isInsideStructure(World world, String s, BlockPos blockPos) {
        return false;
    }
}
