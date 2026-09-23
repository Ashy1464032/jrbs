package me.ashy146.Utils;

import com.mojang.blaze3d.platform.InputConstants;

import me.ashy146.JRBS;
import me.ashy146.Networking.Payloads.PlayerDashServerboundPayload;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public class KeyMappings implements ClientModInitializer {
	KeyMapping.Category CATEGORY = KeyMapping.Category.register(
			Identifier.fromNamespaceAndPath(JRBS.MOD_ID, "parkour")
	);
	
	KeyMapping dashKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
		"key.jrbs.dash_key",
		InputConstants.Type.KEYSYM,
		InputConstants.KEY_R,
		CATEGORY
	));

	@Override
	public void onInitializeClient() {
		JRBS.LOGGER.info("[JRBS] Initialised Client");
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while(dashKey.consumeClick()) {
				if(client.player != null) {
					PlayerDashServerboundPayload payload = new PlayerDashServerboundPayload(client.player.getId());
					if(client.player.onGround()) {
						ClientPlayNetworking.send(payload);
					}
				}
			}
		});
	}
	
}
