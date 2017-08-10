package mjaroslav.mcmods.villagermantlefix;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import mjaroslav.mcmods.villagermantlefix.client.renderer.entity.RenderVillagerAlt;
import mjaroslav.mcmods.villagermantlefix.common.event.Events;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = VillagerMantleFix.MODID, name = VillagerMantleFix.NAME, version = VillagerMantleFix.VERSION)
public class VillagerMantleFix {
	public static final String MODID = "villagermantlefix";
	public static final String NAME = "Villager Matnle Fix";
	public static final String VERSION = "1.7.10-1";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new Events());
		RenderingRegistry.registerEntityRenderingHandler(EntityVillager.class, new RenderVillagerAlt());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}
