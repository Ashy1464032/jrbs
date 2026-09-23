package me.ashy146.Networking.Payloads;

import me.ashy146.JRBS;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record PlayerDashServerboundPayload(int playerId) implements CustomPacketPayload{
	public static final Identifier PLAYER_DASH_PAYLOAD_ID = Identifier.fromNamespaceAndPath(JRBS.MOD_ID, "player_dash");
	public static final CustomPacketPayload.Type<PlayerDashServerboundPayload> TYPE = new CustomPacketPayload.Type<>(PLAYER_DASH_PAYLOAD_ID);
	public static final StreamCodec<RegistryFriendlyByteBuf, PlayerDashServerboundPayload> CODEC =
			StreamCodec.composite(ByteBufCodecs.INT, PlayerDashServerboundPayload::playerId, PlayerDashServerboundPayload::new);
	
	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}

}
