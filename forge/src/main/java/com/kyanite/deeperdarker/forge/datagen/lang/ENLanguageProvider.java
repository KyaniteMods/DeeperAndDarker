package com.kyanite.deeperdarker.forge.datagen.lang;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.platform.forge.RegistryHelperImpl;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.effect.MobEffect;
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
        RegistryHelperImpl.BLOCKS.getEntries().forEach(this::addBlock);
        RegistryHelperImpl.MOB_EFFECTS.getEntries().forEach(this::addEffect);
        RegistryHelperImpl.ENTITY_TYPES.getEntries().forEach(this::addEntity);
        RegistryHelperImpl.BIOMES.getEntries().forEach(this::addBiome);
        RegistryHelperImpl.ITEMS.getEntries().stream().filter(item -> !(item.get() instanceof BlockItem)).forEach(this::addItem);
        RegistryHelperImpl.ENCHANTMENTS.getEntries().forEach(this::addEnchantment);

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

        add("death.attack.jaw", "%1$s was devoured by a Sculk Jaw");
        add("death.attack.ring", "%1$s heard the Stalker's ring");

        add("item.minecraft.potion.effect.sculk_affinity", "Potion of Sculk Affinity");
        add("item.minecraft.splash_potion.effect.sculk_affinity", "Splash Potion of Sculk Affinity");
        add("item.minecraft.lingering_potion.effect.sculk_affinity", "Lingering Potion of Sculk Affinity");
        add("item.minecraft.tipped_arrow.effect.sculk_affinity", "Arrow of Sculk Affinity");
        add("item.deeperdarker.sculk_transmitter.linked", "Linked");
        add("item.deeperdarker.sculk_transmitter.not_container", "Cannot link to block");
        add("item.deeperdarker.sculk_transmitter.not_found", "The linked block is missing or obstructed");
        add("item.deeperdarker.sculk_transmitter.not_linked", "Unlinked");

        add("itemGroup.deeperdarker.deeperdarker", "Deeper And Darker");
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
        super.add("block.deeperdarker." + key, convertToName(key));
    }

    private void addEffect(RegistryObject<MobEffect> effect) {
        String key = effect.getId().getPath();
        super.add("effect.deeperdarker." + key, convertToName(key));
    }

    private void addEntity(RegistryObject<EntityType<?>> item) {
        String key = item.getId().getPath();
        super.add("entity.deeperdarker." + key, convertToName(key));
    }

    private void addBiome(RegistryObject<Biome> item) {
        String key = item.getId().getPath();
        super.add("biome.deeperdarker." + key, convertToName(key));
    }

    private void addItem(RegistryObject<Item> item) {
        String key = item.getId().getPath();
        super.add("item.deeperdarker." + key, convertToName(key));
    }

    private void addEnchantment(RegistryObject<Enchantment> item) {
        String key = item.getId().getPath();
        super.add("enchantment.deeperdarker." + key, convertToName(key));
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
        if(name.equals("Sculk Stone Lapis Ore")) name = "Sculk Stone Lapis Lazuli Ore";

        return upsideDown ? toUpsideDown(name) : name;
    }

    private static String toUpsideDown(String name) {
        StringBuilder builder = new StringBuilder();

        for(int i = name.length() - 1; i >= 0; i--) {
            if(i > 2 && name.substring(i - 3, i + 1).equals("%1$s")) {
                builder.append(name, i - 3, i + 1);
                i -= 4;
                continue;
            }

            char upsideDown = UPSIDE_DOWN_CHARS.charAt(NORMAL_CHARS.indexOf(name.charAt(i)));
            builder.append(upsideDown);
        }

        return builder.toString();
    }
}
