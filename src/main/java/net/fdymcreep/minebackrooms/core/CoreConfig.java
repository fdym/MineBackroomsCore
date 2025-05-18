package net.fdymcreep.minebackrooms.core;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.RangeInt;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = MineBackroomsCore.MODID)
@LangKey("config.minebackroomscore.general")
public class CoreConfig {
    @Mod.EventBusSubscriber(modid = MineBackroomsCore.MODID)
    public static class ConfigSyncHandler {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(MineBackroomsCore.MODID)) {
                ConfigManager.sync(MineBackroomsCore.MODID, Config.Type.INSTANCE);
            }
        }
    }

    @LangKey("config.minebackroomscore.teleporter")
    @Comment("These settings are used to implement secure noclipping.")
    public static final TeleporterConfig TELEPORTER_CONFIG = new TeleporterConfig();

    public static class TeleporterConfig {
        @LangKey("config.minebackroomscore.teleporter.retryCount")
        @Comment("The number of retries when searching for a safe place during noclip.")
        @RangeInt(min = 2, max = 16)
        public int retryCount = 5;

        @LangKey("config.minebackroomscore.teleporter.radius")
        @Comment("The search radius for safe places during noclip.")
        @RangeInt(min = 4, max = 16)
        public int radius = 8;

        @LangKey("config.minebackroomscore.fluidDetect.offset.west")
        @Comment("Detect fluid within a fixed distance west of the player.")
        @RangeInt(min = 0, max = 16)
        public int westOffset = 1;

        @LangKey("config.minebackroomscore.fluidDetect.offset.east")
        @Comment("Detect fluid within a fixed distance east of the player.")
        @RangeInt(min = 0, max = 16)
        public int eastOffset = 1;

        @LangKey("config.minebackroomscore.fluidDetect.offset.north")
        @Comment("Detect fluid within a fixed distance north of the player.")
        @RangeInt(min = 0, max = 16)
        public int northOffset = 1;

        @LangKey("config.minebackroomscore.fluidDetect.offset.south")
        @Comment("Detect fluid within a fixed distance south of the player.")
        @RangeInt(min = 0, max = 16)
        public int southOffset = 1;

        @LangKey("config.minebackroomscore.fluidDetect.offset.below")
        @Comment("Detect fluid within a fixed distance below of the player.")
        @RangeInt(min = 0, max = 16)
        public int belowOffset = 0;

        @LangKey("config.minebackroomscore.fluidDetect.offset.above")
        @Comment("Detect fluid within a fixed distance above of the player.")
        @RangeInt(min = 0, max = 16)
        public int aboveOffset = 2;
    }

    @LangKey("config.minebackroomscore.feature")
    @Comment("Feature configuration.")
    public static final FeatureConfig FEATURE_CONFIG = new FeatureConfig();

    public static class FeatureConfig {
        @LangKey("config.minebackroomscore.feature.noclipableStone.genProbability")
        @Comment("The probability of generating Noclipable Stone.")
        @RangeInt(min = 0, max = 32)
        public int noclipableStoneGenProbability = 10;

        @LangKey("config.minebackroomscore.feature.noclipableStone.genSize")
        @Comment("The size of generating Noclipable Stone.")
        @RangeInt(min = 2, max = 8)
        public int noclipableStoneGenSize = 4;

        @LangKey("config.minebackroomscore.feature.noclipableStone.minY")
        @Comment("The minimum height for generating Noclipable Stone.")
        @RangeInt(min = 4, max = 255)
        public int noclipableStoneMinY = 4;

        @LangKey("config.minebackroomscore.feature.noclipableStone.maxY")
        @Comment("The maximum height for generating Noclipable Stone.")
        @RangeInt(min = 4, max = 255)
        public int noclipableStoneMaxY = 54;
    }
}
