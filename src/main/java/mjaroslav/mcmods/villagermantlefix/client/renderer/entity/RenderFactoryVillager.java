package mjaroslav.mcmods.villagermantlefix.client.renderer.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFactoryVillager implements IRenderFactory<EntityVillager> {
	@Override
	public Render<? super EntityVillager> createRenderFor(RenderManager manager) {
		return new RenderVillagerAlt(manager);
	}
}
