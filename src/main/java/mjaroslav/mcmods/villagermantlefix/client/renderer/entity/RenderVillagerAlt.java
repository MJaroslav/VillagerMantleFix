package mjaroslav.mcmods.villagermantlefix.client.renderer.entity;

import mjaroslav.mcmods.villagermantlefix.client.model.ModelVillagerAlt;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderVillagerAlt extends RenderVillager {
	public RenderVillagerAlt(RenderManager renderManagerIn) {
		super(renderManagerIn);
		this.mainModel = new ModelVillagerAlt(0.0F);
	}
}
