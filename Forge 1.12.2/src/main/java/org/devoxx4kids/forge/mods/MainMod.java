package org.devoxx4kids.forge.mods;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = MainMod.MODID, version = MainMod.VERSION)
public class MainMod {
	public static final String MODID = "mymods";
	public static final String VERSION = "1.0";

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new ChatItems());
		MinecraftForge.EVENT_BUS.register(new MobSpawner());
		MinecraftForge.EVENT_BUS.register(new EntityAlert());
		MinecraftForge.EVENT_BUS.register(new SharpSnowballs());
		MinecraftForge.EVENT_BUS.register(new OverpoweredIronGolems());
		MinecraftForge.EVENT_BUS.register(new RainWater());
		MinecraftForge.EVENT_BUS.register(new SkeletonWar());
		
	}
}