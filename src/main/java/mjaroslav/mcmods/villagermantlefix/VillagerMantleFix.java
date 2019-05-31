package mjaroslav.mcmods.villagermantlefix;

import mjaroslav.mcmods.villagermantlefix.client.renderer.entity.RenderFactoryVillager;
import mjaroslav.mcmods.villagermantlefix.client.event.Events;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = VillagerMantleFix.MODID, name = VillagerMantleFix.NAME, version = VillagerMantleFix.VERSION, clientSideOnly = true)
public class VillagerMantleFix {
    public static final String MODID = "villagermantlefix";
    public static final String NAME = "Villager Matnle Fix";
    public static final String VERSION = "1.12.2-1";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityVillager.class, new RenderFactoryVillager());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new Events());
    }
}
