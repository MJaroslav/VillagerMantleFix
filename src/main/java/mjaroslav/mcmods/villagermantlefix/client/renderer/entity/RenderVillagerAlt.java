package mjaroslav.mcmods.villagermantlefix.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mjaroslav.mcmods.villagermantlefix.client.model.ModelVillagerAlt;
import net.minecraft.client.renderer.entity.RenderVillager;

@SideOnly(Side.CLIENT)
public class RenderVillagerAlt extends RenderVillager {
	public RenderVillagerAlt() {
		this.mainModel = new ModelVillagerAlt(0.0F);
		this.villagerModel = (ModelVillagerAlt) this.mainModel;
	}
}
