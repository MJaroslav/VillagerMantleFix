package mjaroslav.mcmods.villagermantlefix.client.config;

import cpw.mods.fml.client.config.GuiConfig;
import mjaroslav.mcmods.villagermantlefix.VillagerMantleFix;
import mjaroslav.mcmods.villagermantlefix.common.config.Config;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class ModGuiConfig extends GuiConfig {
	public ModGuiConfig(GuiScreen parentScreen) {
		super(parentScreen,
				new ConfigElement(Config.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
				VillagerMantleFix.MODID, false, false, VillagerMantleFix.NAME);
	}
}
