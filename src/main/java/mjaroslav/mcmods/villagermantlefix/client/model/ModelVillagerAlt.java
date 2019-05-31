package mjaroslav.mcmods.villagermantlefix.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelVillagerAlt extends ModelVillager {
    private ModelRenderer villagerMantle;

    public ModelVillagerAlt(float f) {
        this(f, 0F, 64, 64);
    }

    private ModelVillagerAlt(float f, float f1, int i, int i1) {
        super(f, f1, i, i1);
        villagerMantle = new ModelRenderer(this).setTextureSize(i, i1);
        villagerMantle.setTextureOffset(32, 0).addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, f + 0.5F);
        villagerMantle.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
        villagerMantle.rotateAngleY = villagerHead.rotateAngleY;
        villagerMantle.rotateAngleX = villagerHead.rotateAngleX;
    }

    @Override
    public void render(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(e, f, f1, f2, f3, f4, f5);
        villagerMantle.render(f5);
    }
}
