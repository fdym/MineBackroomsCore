package net.fdymcreep.minebackrooms.core;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;

import java.util.Collections;
import java.util.Set;

public class CoreGuiFactory implements IModGuiFactory {
    @Override
    public void initialize(Minecraft mc) {}

    @Override
    public boolean hasConfigGui() {
        return true;
    }

    @Override
    public GuiScreen createConfigGui(GuiScreen parent) {
        return new GuiConfig(parent, ConfigElement.from(CoreConfig.class).getChildElements(), "my_mod_id", false, false, I18n.format("gui.minebackroomscore.guiConfig.FirstLine"), I18n.format("gui.minebackroomscore.guiConfig.SecondLine"));
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return Collections.emptySet();
    }

}
