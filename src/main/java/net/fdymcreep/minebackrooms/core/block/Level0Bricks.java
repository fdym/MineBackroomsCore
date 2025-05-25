package net.fdymcreep.minebackrooms.core.block;

import net.fdymcreep.minebackrooms.core.MineBackroomsCore;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;

public class Level0Bricks extends Block {
    public Level0Bricks(Material p_i46399_1_, MapColor p_i46399_2_) {
        super(p_i46399_1_, p_i46399_2_);
        init();
    }

    public Level0Bricks(Material p_i45394_1_) {
        super(p_i45394_1_);
        init();
    }

    private void init() {
        this.setRegistryName(MineBackroomsCore.MODID, "level0_bricks");
        this.setUnlocalizedName(MineBackroomsCore.MODID + ".level0Bricks");
        this.setCreativeTab(MineBackroomsCore.BUILDING_BLOCKS);
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(1.5F);
        this.setResistance(6F);
        this.setLightLevel(0.25F);
        this.setSoundType(new SoundType(
                1F,
                1F,
                SoundEvents.BLOCK_STONE_BREAK,
                SoundEvents.BLOCK_STONE_STEP,
                SoundEvents.BLOCK_STONE_PLACE,
                SoundEvents.BLOCK_STONE_HIT,
                SoundEvents.BLOCK_STONE_FALL
        ));
    }
}
