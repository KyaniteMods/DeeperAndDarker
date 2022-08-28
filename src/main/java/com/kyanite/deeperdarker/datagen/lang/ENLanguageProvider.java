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
    private static final String NORMAL_CHARS = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_,;.?!/\\'";
    private static final String UPSIDE_DOWN_CHARS = " ɐqɔpǝɟbɥıظʞןɯuodbɹsʇnʌʍxʎzⱯᗺƆᗡƎℲ⅁HIſʞꞀWNOԀὉᴚS⟘∩ΛMXʎZ0ƖᄅƐㄣϛ9ㄥ86‾'؛˙¿¡/\\,";
    private final boolean upsideDown;

    public ENLanguageProvider(DataGenerator pGenerator, String locale, boolean upsideDown) {
        super(pGenerator, DeeperAndDarker.MOD_ID, locale);
        this.upsideDown = upsideDown;
    }

    @Override
    protected void addTranslations() {
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
        add("advancements.deeperdarker.kill_warden.title", "Phantom Thief");
        add("advancements.deeperdarker.kill_warden.description", "Slay the Warden and take its heart... ew");
        add("advancements.deeperdarker.enter_otherside.title", "Below the Bedrock");
        add("advancements.deeperdarker.enter_otherside.description", "Deep below the bedrock... the darkness awaits");
        add("advancements.deeperdarker.explore_otherside.title", "Echolocation");
        add("advancements.deeperdarker.explore_otherside.description", "Explore all Otherside biomes");
        add("advancements.deeperdarker.reinforce_shard.title", "Sculk Engineer");
        add("advancements.deeperdarker.reinforce_shard.description", "Reinforce an Echo Shard");
        add("advancements.deeperdarker.obtain_transmitter.title", "Remote Storage");
        add("advancements.deeperdarker.obtain_transmitter.description", "Acquire a Sculk Transmitter");

        add("sculk_diary.name", "Sculk Diary");
        add("sculk_diary.landing_text", "May this guide serve you well in the depths of the Otherside");

        add("sculk_diary.category.blocks.name", "Blocks");
        add("sculk_diary.category.blocks.description", "Blocks Description");
        add("sculk_diary.category.items.name", "Items");
        add("sculk_diary.category.items.description", "Items Description");
        add("sculk_diary.category.mobs.name", "Mobs");
        add("sculk_diary.category.mobs.description", "Mobs Description");

        add("sculk_diary.entry.blocks.echo_wood.name", "Echo Wood");
        add("sculk_diary.entry.blocks.echo_wood.description", "Echo Wood Description");
        add("sculk_diary.entry.blocks.sculk_stone.name", "Sculk Stone");
        add("sculk_diary.entry.blocks.sculk_stone.description", "Sculk Stone Description");

        add("sculk_diary.entry.items.warden_upgrading.name", "Warden Upgrading");
        add("sculk_diary.entry.items.warden_upgrading.description", "Warden Upgrading Description");

        add("sculk_diary.entry.mobs.sculk_leech.description", "Sculk Leech Description");
        add("sculk_diary.entry.mobs.sculk_snapper.description", "Sculk Snapper Description");
        add("sculk_diary.entry.mobs.shattered.description", "Shattered Description");
        add("sculk_diary.entry.mobs.shriek_worm.description", "Shriek Worm Description");
        add("sculk_diary.entry.mobs.stalker.description", "Stalker Description");

        add("death.attack.jaw", "%1$s was devoured by a Sculk Jaw");
        add("death.attack.ring", "%1$s heard the Stalker's ring");

        add("effect.deeperdarker.sculk_affinity", "Sculk Affinity");
        add("effect.deeperdarker.sculk_affinity.description", "Prevents the player from causing any vibrations.");

        add("item.minecraft.potion.effect.sculk_affinity", "Potion of Sculk Affinity");
        add("item.minecraft.splash_potion.effect.sculk_affinity", "Splash Potion of Sculk Affinity");
        add("item.minecraft.lingering_potion.effect.sculk_affinity", "Lingering Potion of Sculk Affinity");
        add("item.minecraft.tipped_arrow.effect.sculk_affinity", "Arrow of Sculk Affinity");
        add("item.deeperdarker.sculk_transmitter.linked", "Linked");
        add("item.deeperdarker.sculk_transmitter.not_container", "Cannot link to block");
        add("item.deeperdarker.sculk_transmitter.not_found", "The linked block is missing or obstructed");
        add("item.deeperdarker.sculk_transmitter.not_linked", "Unlinked");
        add("itemGroup.deeperdarker", "Deeper And Darker");

        add("subtitles.ambience.portal.groan", "The Otherside forebodes");
        add("subtitles.entity.snapper.ambient", "Sculk Snapper breathes");
        add("subtitles.entity.snapper.bite", "Sculk Snapper bites");
        add("subtitles.entity.snapper.hurt", "Sculk Snapper hurts");
        add("subtitles.entity.snapper.sniff", "Sculk Snapper sniffs");
        add("subtitles.item.transmitter.link", "Transmitter links");
        add("subtitles.item.transmitter.transmit", "Transmitter transmits");
        add("subtitles.entity.stalker.ring", "Stalker rings");
    }

    @Override
    public void add(String key, String value) {
        if(upsideDown) super.add(key, toUpsideDown(value));
        else super.add(key, value);
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

        String name = builder.toString();
        if(name.contains("Chest Boat")) name = name.substring(0, name.indexOf("Chest")) + "Boat with Chest";
        if(name.equals("Heart Of The Deep")) name = "Heart of the Deep";

        return upsideDown ? toUpsideDown(name) : name;
    }

    private static String toUpsideDown(String value) {
        char[] valueUD = new char[value.length()];

        for(int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if(c == '%') {
                StringBuilder builder = new StringBuilder();
                while (Character.isDigit(c) || c == '%' || c == '$' || c == 's' || c == 'd') {
                    builder.append(c);
                    i++;
                    c = i == value.length() ? 0 : value.charAt(i);
                }
                i--;

                for(int j = 0; j < builder.length(); j++) {
                    valueUD[value.length() - 1 - i + j] = builder.charAt(j);
                }

                continue;
            }

            int lookup = NORMAL_CHARS.indexOf(c);
            if(lookup >= 0) {
                c = UPSIDE_DOWN_CHARS.charAt(lookup);
            }

            valueUD[value.length() - 1 - i] = c;
        }
        return new String(valueUD);
    }
}
