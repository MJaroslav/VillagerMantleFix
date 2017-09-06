package mjaroslav.mcmods.villagermantlefix.common.event;

import mjaroslav.mcmods.villagermantlefix.client.renderer.entity.RenderVillagerAlt;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Events {
	@SubscribeEvent
	public void preRenderLivingEventPre(RenderLivingEvent.Pre event) {
		if (event.entity instanceof EntityVillager && !(event.renderer instanceof RenderVillagerAlt)) {
			event.setCanceled(true);
		}
	}
}
