package mjaroslav.mcmods.villagermantlefix.common.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mjaroslav.mcmods.villagermantlefix.client.renderer.entity.RenderVillagerAlt;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.client.event.RenderLivingEvent;

public class Events {
	@SubscribeEvent
	public void preRenderLivingEventPre(RenderLivingEvent.Pre event) {
		if (event.entity instanceof EntityVillager && !(event.renderer instanceof RenderVillagerAlt)) {
			event.setCanceled(true);
		}
	}
}
