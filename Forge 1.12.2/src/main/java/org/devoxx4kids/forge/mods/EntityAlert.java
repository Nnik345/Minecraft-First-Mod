package org.devoxx4kids.forge.mods;

import java.util.List;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityAlert {

	@SubscribeEvent
	public void sendAlert(EntityJoinWorldEvent event) {
		List players = event.getEntity().world.playerEntities;
		if ((event.getEntity() instanceof EntityCreeper)) {
			return;
		}


		for (int i = 0; i < players.size(); i++) {
			EntityPlayer player = (EntityPlayer) players.get(i);
			if (event.getWorld().isRemote) {
				player.sendStatusMessage(new TextComponentString(TextFormatting.GREEN + "A creeper has spawned!"), false);
			}
		}
		if ((event.getEntity() instanceof EntityZombie)) {
			return;
		}


		for (int i = 0; i < players.size(); i++) {
			EntityPlayer player = (EntityPlayer) players.get(i);
			if (event.getWorld().isRemote) {
				player.sendStatusMessage(new TextComponentString(TextFormatting.DARK_GREEN + "A zombie has spawned!"), false);
			}
		}
	}
}