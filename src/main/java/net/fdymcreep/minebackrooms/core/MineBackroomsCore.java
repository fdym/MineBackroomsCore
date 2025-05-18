package net.fdymcreep.minebackrooms.core;

import net.fdymcreep.minebackrooms.core.block.BlockRegistryHandler;
import net.fdymcreep.minebackrooms.core.worldgen.feature.NoclipableDirtFeature;
import net.fdymcreep.minebackrooms.core.worldgen.feature.NoclipableStoneFeature;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
        modid = MineBackroomsCore.MODID,
        name = MineBackroomsCore.NAME,
        version = MineBackroomsCore.VERSION,
        guiFactory = "net.fdymcreep.minebackrooms.core.CoreGuiFactory",
        useMetadata = true
)
public class MineBackroomsCore {
    public static final String MODID = "minebackroomscore";
    public static final String NAME = "MineBackrooms Core";
    public static final String VERSION = "12.0.1.a0";

    // Creative tab
    public static final CreativeTabs NOCLIPABLE = new CreativeTabs("minebackroomscoreNoclipable") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(BlockRegistryHandler.NOCLIPABLE_ICON);
        }
    };

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new NoclipableDirtFeature(), 3);
        GameRegistry.registerWorldGenerator(new NoclipableStoneFeature(), 3);
    }
}
