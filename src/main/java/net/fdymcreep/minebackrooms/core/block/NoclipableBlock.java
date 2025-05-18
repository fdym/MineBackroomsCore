package net.fdymcreep.minebackrooms.core.block;

import net.fdymcreep.minebackrooms.core.event.NoclipEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class NoclipableBlock extends Block {
    public NoclipableBlock(Material p_i45394_1_) {
        super(p_i45394_1_);
    }

    public NoclipableBlock(Material p_i46399_1_, MapColor p_i46399_2_) {
        super(p_i46399_1_, p_i46399_2_);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> p_getDrops_1_, IBlockAccess p_getDrops_2_, BlockPos p_getDrops_3_, IBlockState p_getDrops_4_, int p_getDrops_5_) {
        p_getDrops_1_.add(ItemStack.EMPTY);
    }

    @Override
    public boolean canSilkHarvest(World p_canSilkHarvest_1_, BlockPos p_canSilkHarvest_2_, IBlockState p_canSilkHarvest_3_, EntityPlayer p_canSilkHarvest_4_) {
        return false;
    }

    public void setHarvestLevel(String p_setHarvestLevel_1_) {
        super.setHarvestLevel(p_setHarvestLevel_1_, 3);
    }

    @Override
    public boolean onBlockActivated(
            World p_180639_1_,
            BlockPos p_180639_2_,
            IBlockState p_180639_3_,
            EntityPlayer p_180639_4_,
            EnumHand p_180639_5_,
            EnumFacing p_180639_6_,
            float p_180639_7_,
            float p_180639_8_,
            float p_180639_9_
    ) {
        MinecraftForge.EVENT_BUS.post(new NoclipEvent(this.getRegistryName(), p_180639_4_, !p_180639_1_.isRemote));
        return true;
    }
}
