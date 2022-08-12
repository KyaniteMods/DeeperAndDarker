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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class ENLanguageProvider extends LanguageProvider {
    private static final String NORMAL_CHARS = "abcdefghijklmn\u00F1opqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "_,;.?!/\\'";
    private static final String UPSIDE_DOWN_CHARS =
            "\u0250q\u0254p\u01DD\u025Fb\u0265\u0131\u0638\u029E\u05DF\u026Fuuodb\u0279s\u0287n\u028C\u028Dx\u028Ez" +
            "\u2C6F\u15FA\u0186\u15E1\u018E\u2132\u2141HI\u017F\u029E\uA780WNO\u0500\u1F49\u1D1AS\u27D8\u2229\u039BMX\u028EZ" +
            "0\u0196\u1105\u0190\u3123\u03DB9\u312586" + "\u203E'\u061B\u02D9\u00BF\u00A1/\\,";

    boolean upsideDown;

    public ENLanguageProvider(DataGenerator pGenerator, String locale, boolean upsideDown) {
        super(pGenerator, DeeperAndDarker.MOD_ID, locale);
        this.upsideDown = upsideDown;
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.deeperdarker", "Deeper And Darker");

        DDBlocks.BLOCKS.getEntries().forEach(this::addBlock);
        DDEntities.ENTITY_TYPES.getEntries().forEach(this::addEntity);
        OthersideBiomes.BIOMES.getEntries().forEach(this::addBiome);
        DDItems.ITEMS.getEntries().stream().filter(item -> item.get() instanceof BlockItem == (item.get() == DDItems.GLOOM_BERRIES.get())).forEach(this::addItem);
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
        add("advancements.deeperdarker.reinforce_shard.title", "Sculk Engineer");
        add("advancements.deeperdarker.reinforce_shard.description", "Reinforce an Echo Shard");
        add("subtitles.ambience.portal.groan", "The Otherside forebodes");
        add("subtitles.entity.snapper.ambient", "Sculk Snapper breathes");
        add("subtitles.entity.snapper.bite", "Sculk Snapper bites");
        add("subtitles.entity.snapper.hurt", "Sculk Snapper hurts");
        add("subtitles.entity.snapper.sniff", "Sculk Snapper sniffs");
        add("item.minecraft.potion.effect.sculk_affinity_potion", "Sculk Affinity Potion");
        add("item.minecraft.splash_potion.effect.sculk_affinity_potion", "Splash Potion of Sculk Affinity");
        add("item.minecraft.lingering_potion.effect.sculk_affinity_potion", "Lingering Potion of Sculk Affinity");
        add("effect.deeperdarker.sculk_affinity", "Sculk Affinity");
        add("item.minecraft.tipped_arrow.effect.sculk_affinity_potion", "Arrow of Sculk Affinity");
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

        return upsideDown ? toUpsideDown(builder.toString()) : builder.toString();
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
