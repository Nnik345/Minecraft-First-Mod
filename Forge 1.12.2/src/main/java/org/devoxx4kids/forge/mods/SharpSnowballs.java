package org.devoxx4kids.forge.mods;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SharpSnowballs {

	@SubscribeEvent
	public void replaceSnowballWithArrow(EntityJoinWorldEvent event) {
		Entity snowball = event.getEntity();
		World world = snowball.world;

		if (!(snowball instanceof EntitySnowball)) {
			return;
		}

		if (!world.isRemote) {
			EntityTNTPrimed arrow = new EntityTNTPrimed(world);
			arrow.setFuse(100);
			arrow.setLocationAndAngles(snowball.posX, snowball.posY, snowball.posZ,
					0, 0);
			arrow.motionX = snowball.motionX;
			arrow.motionY = snowball.motionY;
			arrow.motionZ = snowball.motionZ;

			arrow.posX += arrow.motionX;
			arrow.posY += arrow.motionY;
			arrow.posZ += arrow.motionZ;

			world.spawnEntity(arrow);
			snowball.setDead();
		}
	}
}
