package net.fdymcreep.minebackrooms.core.util;

import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nullable;

public class NoclipInfo {
    public int dimID;
    @Nullable
    public Double probability;
    public ITeleporter teleporter;

    public NoclipInfo(int dimID, @Nullable Double probability) {
        this.dimID = dimID;
        this.probability = probability;
        this.teleporter = new MineBackroomsTeleporter();
    }

    public NoclipInfo(int dimID, @Nullable Double probability, ITeleporter teleporter) {
        this.dimID = dimID;
        this.probability = probability;
        this.teleporter = teleporter;
    }
}
