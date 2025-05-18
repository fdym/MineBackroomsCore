package net.fdymcreep.minebackrooms.core.block;

import net.fdymcreep.minebackrooms.core.MineBackroomsCore;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;

public class NoclipableDirt extends NoclipableBlock{
    public NoclipableDirt(Material p_i45394_1_) {
        super(p_i45394_1_);
        init();
    }

    public NoclipableDirt(Material p_i46399_1_, MapColor p_i46399_2_) {
        super(p_i46399_1_, p_i46399_2_);
        init();
    }

    private void init() {
        this.setRegistryName(MineBackroomsCore.MODID, "noclipable_dirt");
        this.setUnlocalizedName(MineBackroomsCore.MODID + ".noclipableDirt");
        this.setCreativeTab(MineBackroomsCore.NOCLIPABLE);
        this.setHarvestLevel("shovel");
        this.setHardness(0.5F * 8);
        this.setResistance(0.5F * 8);
        this.setSoundType(new SoundType(
                1F,
                1F,
                SoundEvents.BLOCK_GRAVEL_BREAK,
                SoundEvents.BLOCK_GRAVEL_STEP,
                SoundEvents.BLOCK_GRAVEL_PLACE,
                SoundEvents.BLOCK_GRAVEL_HIT,
                SoundEvents.BLOCK_GRAVEL_FALL
        ));
    }
}
