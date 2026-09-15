package me.ashy146;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JRBS implements ModInitializer {
	//Mod ID
	public static final String MOD_ID = "jrbs";
	//Logger
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
	//Init Method
	@Override
	public void onInitialize() {
		//Print Init Message
		LOGGER.info("[JRBS] Initialised");
	}
	
	
}
