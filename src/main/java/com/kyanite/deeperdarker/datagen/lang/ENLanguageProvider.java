package com.kyanite.deeperdarker.datagen.lang;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.enchantments.DDEnchantments;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.world.biomes.OthersideBiomes;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class ENLanguageProvider extends LanguageProvider {
    public ENLanguageProvider(DataGenerator pGenerator) {
        super(pGenerator, DeeperAndDarker.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.deeperdarker", "Deeper And Darker");

        DDBlocks.BLOCKS.getEntries().forEach(this::addBlock);
        DDEntities.ENTITY_TYPES.getEntries().forEach(this::addEntity);
        OthersideBiomes.BIOMES.getEntries().forEach(this::addBiome);
        DDItems.ITEMS.getEntries().stream().filter(item -> !(item.get() instanceof BlockItem)).forEach(this::addItem);
        DDEnchantments.ENCHANTMENTS.getEntries().forEach(this::addEnchantment);

        add("advancements.deeperdarker.root.title", "Sculk Story");
        add("advancements.deeperdarker.root.description", "You feel something pulling you toward the underground...");
        add("advancements.deeperdarker.obtain_membrane.title", "Sleepless Nights");
        add("advancements.deeperdarker.obtain_membrane.description", "Slay a monster of the night sky");
        add("advancements.deeperdarker.locate_ancient_city.title", "A Metropolis of Restless Souls");
        add("advancements.deeperdarker.locate_ancient_city.description", "Find an Ancient City");
        add("advancements.deeperdarker.obtain_echo_shard.title", "Echoes of the Past");
        add("advancements.deeperdarker.obtain_echo_shard.description", "Collect some Echo Shards from an Ancient City");
        add("advancements.deeperdarker.kill_warden.title", "Phantom Thief");
        add("advancements.deeperdarker.kill_warden.description", "Slay the Warden and take its heart... ew");
        add("advancements.deeperdarker.enter_otherside.title", "Enter the Otherside");
        add("advancements.deeperdarker.enter_otherside.description", "Deep below the Bedrock... the darkness");

        add("subtitles.ambience.portal.groan", "The Otherside forebodes");
        add("subtitles.entity.snapper.ambient", "Sculk Snapper breathes");
        add("subtitles.entity.snapper.bite", "Sculk Snapper bites");
        add("subtitles.entity.snapper.hurt", "Sculk Snapper hurts");
        add("subtitles.entity.snapper.sniff", "Sculk Snapper sniffs");
    }

    private void addBlock(RegistryObject<Block> block) {
        String key = block.getId().getPath();
        add("block.deeperdarker." + key, convertToName(key));
    }

    private void addEntity(RegistryObject<EntityType<?>> item) {
        String key = item.getId().getPath();
        add("entity.deeperdarker." + key, convertToName(key));
    }

    private void addBiome(RegistryObject<Biome> item) {
        String key = item.getId().getPath();
        add("biome.deeperdarker." + key, convertToName(key));
    }

    private void addItem(RegistryObject<Item> item) {
        String key = item.getId().getPath();
        add("item.deeperdarker." + key, convertToName(key));
    }

    private void addEnchantment(RegistryObject<Enchantment> item) {
        String key = item.getId().getPath();
        add("enchantment.deeperdarker." + key, convertToName(key));
    }

    private String convertToName(String key) {
        StringBuilder builder = new StringBuilder(key.substring(0, 1).toUpperCase() + key.substring(1));
        for(int i = 1; i < builder.length(); i++) {
            if(builder.charAt(i) == '_') {
                builder.deleteCharAt(i);
                builder.replace(i, i + 1, " " + Character.toUpperCase(builder.charAt(i)));
            }
        }

        return builder.toString();
    }
}