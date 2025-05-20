package net.fdymcreep.minebackrooms.core.block;

import net.fdymcreep.minebackrooms.core.MineBackroomsCore;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;

public class Level0Light extends Block {
    public Level0Light(Material p_i46399_1_, MapColor p_i46399_2_) {
        super(p_i46399_1_, p_i46399_2_);
        init();
    }

    public Level0Light(Material p_i45394_1_) {
        super(p_i45394_1_);
        init();
    }

    private void init() {
        this.setRegistryName(MineBackroomsCore.MODID, "level0_light");
        this.setUnlocalizedName(MineBackroomsCore.MODID + ".level0Light");
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(1.5F);
        this.setResistance(6F);
        this.setLightLevel(15F);
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
