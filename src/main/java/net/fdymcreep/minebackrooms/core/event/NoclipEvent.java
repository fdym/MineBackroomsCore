package net.fdymcreep.minebackrooms.core.event;

import net.fdymcreep.minebackrooms.core.util.NoclipInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.ArrayList;
import java.util.List;

public class NoclipEvent extends Event {
    public List<NoclipInfo> noclipInfoList;
    public ResourceLocation location;
    public EntityPlayer player;
    public boolean isNotRemote;

    public NoclipEvent(ResourceLocation location, EntityPlayer player, boolean isNotRemote) {
        this.noclipInfoList = new ArrayList<>();
        this.location = location;
        this.player = player;
        this.isNotRemote = isNotRemote;
    }
}
