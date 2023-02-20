package com.kyanite.deeperdarker.forge.datagen.lang;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.platform.forge.RegistryHelperImpl;
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
import org.jetbrains.annotations.NotNull;

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
        add("advancements.deeperdarker.warden_armor.title", "Cover Me with Sculk");
        add("advancements.deeperdarker.warden_armor.description", "Protect yourself with a full set of Warden Armor");
        add("advancements.deeperdarker.obtain_transmitter.title", "Noise Complaint");
        add("advancements.deeperdarker.obtain_transmitter.description", "Acquire a Sculk Transmitter");
        add("advancements.deeperdarker.obtain_soul_elytra.title", "Wings of the Broken Souls");
        add("advancements.deeperdarker.obtain_soul_elytra.description", "Craft Soul Elytra");

        add("death.attack.jaw", "%1$s was devoured by a Sculk Jaw");
        add("death.attack.ring", "%1$s heard the Stalker's ring");

        add("effect.deeperdarker.sculk_affinity.description", "Prevents you from causing vibrations.");
        add("enchantment.deeperdarker.sculk_smite.description", "Increases damage against Sculk mobs including Phantoms and the Warden.");
        add("enchantment.deeperdarker.catalysis.description", "Spreads Sculk upon killing entities.");

        add("item.minecraft.potion.effect.sculk_affinity", "Potion of Sculk Affinity");
        add("item.minecraft.splash_potion.effect.sculk_affinity", "Splash Potion of Sculk Affinity");
        add("item.minecraft.lingering_potion.effect.sculk_affinity", "Lingering Potion of Sculk Affinity");
        add("item.minecraft.tipped_arrow.effect.sculk_affinity", "Arrow of Sculk Affinity");

        add("itemGroup.deeperdarker.deeperdarker", "Deeper and Darker");
        add("itemGroup.deeperdarker", "Deeper and Darker");

        add("subtitles.ambience.portal.groan", "The Otherside forebodes");
        add("subtitles.ambience.warden_dreaming", "Warden dreams");

        add("subtitles.block.jaw.close", "Sculk Jaw bites");
        add("subtitles.block.jaw.retract", "Sculk Jaw retracts");

        add("subtitles.entity.shattered.ambient", "Shattered growls");
        add("subtitles.entity.shattered.death", "Shattered dies");
        add("subtitles.entity.shattered.hurt", "Shattered hurts");

        add("subtitles.entity.shriek_worm.ambient", "Shriek Worm cries");
        add("subtitles.entity.shriek_worm.attack", "Shriek Worm attacks");
        add("subtitles.entity.shriek_worm.death", "Shriek Worm dies");
        add("subtitles.entity.shriek_worm.hurt", "Shriek Worm hurts");

        add("subtitles.entity.centipede.ambient", "Sculk Centipede ambience");
        add("subtitles.entity.centipede.death", "Sculk Centipede dies");
        add("subtitles.entity.centipede.hurt", "Sculk Centipede hurts");

        add("subtitles.entity.leech.ambient", "Sculk Leech ambience");
        add("subtitles.entity.leech.death", "Sculk Leech dies");
        add("subtitles.entity.leech.hurt", "Sculk Leech hurts");

        add("subtitles.entity.snapper.ambient", "Sculk Snapper breathes");
        add("subtitles.entity.snapper.bite", "Sculk Snapper bites");
        add("subtitles.entity.snapper.death", "Sculk Snapper dies");
        add("subtitles.entity.snapper.hurt", "Sculk Snapper hurts");
        add("subtitles.entity.snapper.sniff", "Sculk Snapper sniffs");

        add("subtitles.entity.stalker.ambient", "Stalker chirps");
        add("subtitles.entity.stalker.death", "Stalker dies");
        add("subtitles.entity.stalker.hurt", "Stalker hurts");
        add("subtitles.entity.stalker.ring", "Stalker rings");

        add("subtitles.item.sculk_meal.use", "Sculk Meal crinkles");
    }

    @Override
    public void add(@NotNull String key, @NotNull String value) {
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
