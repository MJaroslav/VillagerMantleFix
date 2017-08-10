package mjaroslav.mcmods.villagermantlefix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.VillagerRegistry;
import mjaroslav.mcmods.villagermantlefix.client.renderer.entity.RenderVillagerAlt;
import mjaroslav.mcmods.villagermantlefix.common.config.Config;
import mjaroslav.mcmods.villagermantlefix.common.event.Events;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = VillagerMantleFix.MODID, name = VillagerMantleFix.NAME, version = VillagerMantleFix.VERSION, guiFactory = VillagerMantleFix.GUIFACTORY)
public class VillagerMantleFix {
	public static final String MODID = "villagermantlefix";
	public static final String NAME = "Villager Matnle Fix";
	public static final String VERSION = "1.7.10-2";
	public static final String GUIFACTORY = "mjaroslav.mcmods.villagermantlefix.client.GuiFactory";

	public static Logger log = LogManager.getLogger(NAME);

	public static String configFilePath;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		configFilePath = event.getModConfigurationDirectory().toString() + "/" + MODID + ".cfg";
		Config.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new Events());
		RenderingRegistry.registerEntityRenderingHandler(EntityVillager.class, new RenderVillagerAlt());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (Config.logRegistredIds) {
			String line = "=====================";
			log.info(line);
			log.info("Registered villagers ids:");
			String ids = "";
			boolean flag = false;
			for (Integer id : VillagerRegistry.getRegisteredVillagers()) {
				ids += (flag ? ", " : "") + id;
				if (!flag)
					flag = true;
			}
			log.info(ids);
			log.info(line);
		}
	}

	public static boolean villagerInBlackList(int villagerId) {
		for (int id : Config.idBlackList)
			if (id == villagerId)
				return true;
		return false;
	}
}
