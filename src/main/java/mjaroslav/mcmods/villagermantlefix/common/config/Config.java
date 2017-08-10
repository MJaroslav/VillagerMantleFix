package mjaroslav.mcmods.villagermantlefix.common.config;

import java.io.File;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mjaroslav.mcmods.villagermantlefix.VillagerMantleFix;
import net.minecraftforge.common.config.Configuration;

public class Config {
	public static Configuration config;

	public static int[] idBlackList = new int[] {};
	public static boolean logRegistredIds = false;

	private static Config instance = new Config();

	public static Config getInstance() {
		return instance;
	}

	public static void init() {
		if (config == null) {
			config = new Configuration(new File(VillagerMantleFix.configFilePath));
		}
		try {
			config.load();
		} catch (Exception e) {
			VillagerMantleFix.log.error("Unable to load configuration!");
		} finally {
			if (config.hasChanged()) {
				config.save();
			}
		}
		sync();
		FMLCommonHandler.instance().bus().register(instance);
	}

	public static void sync() {
		idBlackList = config
				.get(Configuration.CATEGORY_GENERAL, "id_blacklist", new int[] {}, "Black list of professions ids")
				.getIntList();
		logRegistredIds = config.getBoolean("log_registered_ids", Configuration.CATEGORY_GENERAL, false,
				"Log registered villagers ids when starting");

		if (config.hasChanged()) {
			config.save();
			VillagerMantleFix.log.info("Configuration saved");
		}
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent event) {
		if (event.modID.equals(VillagerMantleFix.MODID))
			Config.sync();
	}
}
