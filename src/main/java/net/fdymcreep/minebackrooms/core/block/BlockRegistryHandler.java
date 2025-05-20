package net.fdymcreep.minebackrooms.core.block;

import net.fdymcreep.minebackrooms.core.MineBackroomsCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = MineBackroomsCore.MODID)
public class BlockRegistryHandler {
    public static final Block NOCLIPABLE_ICON = new Block(Material.GROUND).setRegistryName(MineBackroomsCore.MODID, "noclipable_icon");
    public static final NoclipableDirt NOCLIPABLE_DIRT = new NoclipableDirt(Material.GROUND, MapColor.DIRT);
    public static final NoclipableStone NOCLIPABLE_STONE = new NoclipableStone(Material.ROCK, MapColor.STONE);

    public static final Level0Bricks LEVEL0_BRICKS = new Level0Bricks(Material.ROCK, MapColor.YELLOW);
    public static final Level0Light LEVEL0_LIGHT = new Level0Light(Material.ROCK, MapColor.YELLOW);

    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();

        registry.register(NOCLIPABLE_ICON);
        registry.register(NOCLIPABLE_DIRT);
        registry.register(NOCLIPABLE_STONE);

        registry.register(LEVEL0_BRICKS);
        registry.register(LEVEL0_LIGHT);
    }
}
