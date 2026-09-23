package me.ashy146.DataGen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup.Provider;

public class JRBSEnglishLangProvider extends FabricLanguageProvider{

	protected JRBSEnglishLangProvider(FabricDataOutput dataOutput,CompletableFuture<Provider> registryLookup) {
		super(dataOutput, "en_us", registryLookup);
	}

	@Override
	public void generateTranslations(Provider registryLookup, TranslationBuilder translationBuilder) {
		translationBuilder.add("key.category.jrbs.parkour", "JRBS Movement");
		translationBuilder.add("key.jrbs.dash_key", "Dash");
	}

}
