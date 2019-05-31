package mjaroslav.mcmods.villagermantlefix.client.event;

import mjaroslav.mcmods.villagermantlefix.client.renderer.entity.RenderVillagerAlt;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Events {
    @SubscribeEvent
    public void preRenderLivingEventPre(RenderLivingEvent.Pre event) {
        if (event.getEntity() instanceof EntityVillager && !(event.getRenderer() instanceof RenderVillagerAlt))
            event.setCanceled(true);
    }
}
