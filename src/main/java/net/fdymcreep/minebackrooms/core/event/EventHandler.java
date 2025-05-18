package net.fdymcreep.minebackrooms.core.event;

import net.fdymcreep.minebackrooms.core.util.NoclipInfo;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber
public class EventHandler {
//    @SubscribeEvent
//    public static void onNoclip(NoclipEvent event) {
//        event.noclipInfoList.add(new NoclipInfo(-1, 1.0));
//    }

    @SubscribeEvent(priority = EventPriority.LOWEST, receiveCanceled = true)
    public static void noclip(NoclipEvent event) {
        if (event.noclipInfoList.isEmpty()) {
            return;
        }
        Random random = new Random();
        double randomNumber = random.nextGaussian();
        Double num = 0.0;
        List<NoclipInfo> nullProbabilityList = new ArrayList<>();
        int dimID;
        for (;;) { // retry
            if (event.isNotRemote && !event.player.isDead) {
                for (NoclipInfo info : event.noclipInfoList) {
                    num += info.probability;
                    if (info.probability == null) {
                        nullProbabilityList.add(info);
                    } else if (randomNumber < num) {
                        dimID = info.dimID;
                        if (DimensionManager.getWorld(dimID) == null) {
                            DimensionManager.initDimension(dimID);
                        }
                        event.player.changeDimension(dimID, info.teleporter);
                        return;
                    }
                }
                if (!nullProbabilityList.isEmpty()) {
                    NoclipInfo info = nullProbabilityList.get(random.nextInt(nullProbabilityList.size() * 128) % nullProbabilityList.size());
                    if (DimensionManager.getWorld(info.dimID) == null) {
                        DimensionManager.initDimension(info.dimID);
                    }
                    event.player.changeDimension(info.dimID, info.teleporter);
                    return;
                }
            } else {
                break; // client or dead
            }
        }
    }
}
