package net.fdymcreep.minebackrooms.core.item;

import net.fdymcreep.minebackrooms.core.MineBackroomsCore;
import net.fdymcreep.minebackrooms.core.block.BlockRegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = MineBackroomsCore.MODID)
public class ItemRegistryHandler {
    public static final Item NOCLIPABLE_ICON = createItemBlock(BlockRegistryHandler.NOCLIPABLE_ICON);
    public static final Item NOCLIPABLE_DIRT = createItemBlock(BlockRegistryHandler.NOCLIPABLE_DIRT);
    public static final Item NOCLIPABLE_STONE = createItemBlock(BlockRegistryHandler.NOCLIPABLE_STONE);

    public static final Item LEVEL0_BRICKS = createItemBlock(BlockRegistryHandler.LEVEL0_BRICKS);
    public static final Item LEVEL0_LIGHT = createItemBlock(BlockRegistryHandler.LEVEL0_LIGHT);

    public static Item createItemBlock(Block block) {
        return new ItemBlock(block).setRegistryName(block.getRegistryName());
    }

    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(NOCLIPABLE_ICON);
        registry.register(NOCLIPABLE_DIRT);
        registry.register(NOCLIPABLE_STONE);

        registry.register(LEVEL0_BRICKS);
        registry.register(LEVEL0_LIGHT);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegistry(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(
                NOCLIPABLE_ICON,
                0,
                new ModelResourceLocation(
                        BlockRegistryHandler.NOCLIPABLE_DIRT.getRegistryName(),
                        "inventory"
                )
        );
        ModelLoader.setCustomModelResourceLocation(
                NOCLIPABLE_DIRT,
                0,
                new ModelResourceLocation(
                        BlockRegistryHandler.NOCLIPABLE_DIRT.getRegistryName(),
                        "inventory"
                )
        );
        ModelLoader.setCustomModelResourceLocation(
                NOCLIPABLE_STONE,
                0,
                new ModelResourceLocation(
                        BlockRegistryHandler.NOCLIPABLE_STONE.getRegistryName(),
                        "inventory"
                )
        );

        ModelLoader.setCustomModelResourceLocation(
                LEVEL0_BRICKS,
                0,
                new ModelResourceLocation(
                        BlockRegistryHandler.LEVEL0_BRICKS.getRegistryName(),
                        "inventory"
                )
        );
        ModelLoader.setCustomModelResourceLocation(
                LEVEL0_LIGHT,
                0,
                new ModelResourceLocation(
                        BlockRegistryHandler.LEVEL0_LIGHT.getRegistryName(),
                        "inventory"
                )
        );
    }
}
