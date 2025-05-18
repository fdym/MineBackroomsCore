package net.fdymcreep.minebackrooms.core.block;

import net.fdymcreep.minebackrooms.core.MineBackroomsCore;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;

public class NoclipableStone extends NoclipableBlock{
    public NoclipableStone(Material p_i45394_1_) {
        super(p_i45394_1_);
        init();
    }

    public NoclipableStone(Material p_i46399_1_, MapColor p_i46399_2_) {
        super(p_i46399_1_, p_i46399_2_);
        init();
    }

    private void init() {
        this.setRegistryName(MineBackroomsCore.MODID, "noclipable_stone");
        this.setUnlocalizedName(MineBackroomsCore.MODID + ".noclipableStone");
        this.setCreativeTab(MineBackroomsCore.NOCLIPABLE);
        this.setCreativeTab(MineBackroomsCore.NOCLIPABLE);
        this.setHarvestLevel("pickaxe");
        this.setHardness(1.5F * 8);
        this.setResistance(6F * 8);
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
