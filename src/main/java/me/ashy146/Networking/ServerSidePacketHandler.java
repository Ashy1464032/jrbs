package me.ashy146.Networking;

import me.ashy146.JRBS;
import me.ashy146.Networking.Payloads.PlayerDashServerboundPayload;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;

public class ServerSidePacketHandler implements ModInitializer {

	@Override
	public void onInitialize() {
		JRBS.LOGGER.info("Server Side Packet Handler Initialised");
		
		ServerPlayNetworking.registerGlobalReceiver(PlayerDashServerboundPayload.TYPE, (payload ,context) -> {
			context.server().execute(() -> {
				ServerPlayer player = context.player();
				Vec3 facingDirection = player.getLookAngle();
				Vec3 dashDirection = facingDirection.multiply(2.5, 1.0, 2.5);
				if(player.getFoodData().getFoodLevel() > 6) {
					player.addDeltaMovement(dashDirection);
					player.getFoodData().addExhaustion(3f);
					player.hurtMarked = true;
				}
				
			});
		});
	}

}
