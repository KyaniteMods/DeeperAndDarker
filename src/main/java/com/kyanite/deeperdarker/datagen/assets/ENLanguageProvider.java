package com.kyanite.deeperdarker.datagen.assets;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.content.entities.DDBoat;
import com.kyanite.deeperdarker.content.entities.DDChestBoat;
import com.kyanite.deeperdarker.util.DDDamageTypes;
import com.kyanite.deeperdarker.world.otherside.OthersideBiomes;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ENLanguageProvider extends LanguageProvider {
    public ENLanguageProvider(PackOutput output) {
        super(output, DeeperDarker.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("item.minecraft.tipped_arrow.effect.sculk_affinity", "Arrow of Sculk Affinity");
        add("item.minecraft.tipped_arrow.effect.long_sculk_affinity", "Arrow of Sculk Affinity");
        add("item.minecraft.potion.effect.sculk_affinity", "Potion of Sculk Affinity");
        add("item.minecraft.potion.effect.long_sculk_affinity", "Potion of Sculk Affinity");
        add("item.minecraft.splash_potion.effect.sculk_affinity", "Splash Potion of Sculk Affinity");
        add("item.minecraft.splash_potion.effect.long_sculk_affinity", "Splash Potion of Sculk Affinity");
        add("item.minecraft.lingering_potion.effect.sculk_affinity", "Lingering Potion of Sculk Affinity");
        add("item.minecraft.lingering_potion.effect.long_sculk_affinity", "Lingering Potion of Sculk Affinity");

        add("advancements." + DeeperDarker.MOD_ID + ".root.title", "Sculk Story");
        add("advancements." + DeeperDarker.MOD_ID + ".root.description", "You feel something pulling you towards the source...");
        add("advancements." + DeeperDarker.MOD_ID + ".find_ancient_city.title", "A Metropolis of Restless Souls");
        add("advancements." + DeeperDarker.MOD_ID + ".find_ancient_city.description", "Find an Ancient City");
        add("advancements." + DeeperDarker.MOD_ID + ".kill_warden.title", "Phantom Thief");
        add("advancements." + DeeperDarker.MOD_ID + ".kill_warden.description", "Slay the Warden and take its heart");
        add("advancements." + DeeperDarker.MOD_ID + ".enter_otherside.title", "Below the Bedrock");
        add("advancements." + DeeperDarker.MOD_ID + ".enter_otherside.description", "Deep below the bedrock, the darkness awaits");
        add("advancements." + DeeperDarker.MOD_ID + ".find_ancient_temple.title", "Abyssal Descent");
        add("advancements." + DeeperDarker.MOD_ID + ".find_ancient_temple.description", "Explore the depths for a temple");
        add("advancements." + DeeperDarker.MOD_ID + ".obtain_sculk_transmitter.title", "Remote Storage");
        add("advancements." + DeeperDarker.MOD_ID + ".obtain_sculk_transmitter.description", "Acquire a Sculk Transmitter");
        add("advancements." + DeeperDarker.MOD_ID + ".obtain_sonorous_staff.title", "Noise Complaint");
        add("advancements." + DeeperDarker.MOD_ID + ".obtain_sonorous_staff.description", "Acquire a Sonorous Staff");
        add("advancements." + DeeperDarker.MOD_ID + ".explore_otherside.title", "Echolocation");
        add("advancements." + DeeperDarker.MOD_ID + ".explore_otherside.description", "Explore all Otherside biomes");
        add("advancements." + DeeperDarker.MOD_ID + ".kill_all_sculk_mobs.title", "Sculk Slayer");
        add("advancements." + DeeperDarker.MOD_ID + ".kill_all_sculk_mobs.description", "Kill one of every Sculk monster");
        add("advancements." + DeeperDarker.MOD_ID + ".obtain_reinforced_echo_shard.title", "Sculk Engineer");
        add("advancements." + DeeperDarker.MOD_ID + ".obtain_reinforced_echo_shard.description", "Reinforce an Echo Shard");
        add("advancements." + DeeperDarker.MOD_ID + ".warden_armor.title", "Cover Me with Sculk");
        add("advancements." + DeeperDarker.MOD_ID + ".warden_armor.description", "Protect yourself with a full set of Warden Armor");

        add("block." + DeeperDarker.MOD_ID + ".linked", "Linked transmitter");
        add("block." + DeeperDarker.MOD_ID + ".unlinked", "Unlinked transmitter");
        add("block." + DeeperDarker.MOD_ID + ".not_transmittable", "Cannot link to block");
        add("block." + DeeperDarker.MOD_ID + ".not_found", "The linked block is missing or unloaded");
        add("block." + DeeperDarker.MOD_ID + ".flowerless_ice_lily", "Flowerless Ice Lily");

        add("tooltips." + DeeperDarker.MOD_ID + ".crystallized_amber.item", "Contains %s");
        add("tooltips." + DeeperDarker.MOD_ID + ".crystallized_amber.leech", "Contains Sculk Leech");
        add("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.linked", "Linked to %s");
        add("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.location", "Located at %s, %s, %s");
        add("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.not_linked", "Unlinked");

        add("itemGroup." + DeeperDarker.MOD_ID, "Deeper and Darker");
        add("item." + DeeperDarker.MOD_ID + ".dampens_vibrations", "Dampens Vibrations");
        add("item." + DeeperDarker.MOD_ID + ".soul_elytra.equipped", "Press %s to boost");
        add("item." + DeeperDarker.MOD_ID + ".soul_elytra.cooldown", "Boost available in %s");
        add("item." + DeeperDarker.MOD_ID + ".soul_elytra.no_cooldown", "Boost disabled");
        add("item." + DeeperDarker.MOD_ID + ".smithing_template.warden_upgrade.applies_to", "Netherite Equipment");
        add("item." + DeeperDarker.MOD_ID + ".smithing_template.warden_upgrade.ingredients", "Reinforced Echo Shard");
        add("item." + DeeperDarker.MOD_ID + ".smithing_template.warden_upgrade.base_slot_description", "Add netherite armor, weapon, or tool");
        add("item." + DeeperDarker.MOD_ID + ".smithing_template.warden_upgrade.additions_slot_description", "Add Reinforced Echo Shard");
        add("upgrade." + DeeperDarker.MOD_ID + ".warden_upgrade", "Warden Upgrade");

        add("key.categories." + DeeperDarker.MOD_ID, "Deeper and Darker");
        add("key." + DeeperDarker.MOD_ID + ".boost", "Boost Soul Elytra");
        add("key." + DeeperDarker.MOD_ID + ".transmit", "Use Sculk Transmitter");

        add("biome." + DeeperDarker.MOD_ID + "." + OthersideBiomes.DEEPLANDS.location().getPath(), convertToName(OthersideBiomes.DEEPLANDS.location().getPath()));
        add("biome." + DeeperDarker.MOD_ID + "." + OthersideBiomes.ECHOING_FOREST.location().getPath(), convertToName(OthersideBiomes.ECHOING_FOREST.location().getPath()));
        add("biome." + DeeperDarker.MOD_ID + "." + OthersideBiomes.BLOOMING_CAVERNS.location().getPath(), convertToName(OthersideBiomes.BLOOMING_CAVERNS.location().getPath()));
        add("biome." + DeeperDarker.MOD_ID + "." + OthersideBiomes.OVERCAST_COLUMNS.location().getPath(), convertToName(OthersideBiomes.OVERCAST_COLUMNS.location().getPath()));
        add("death.attack." + DeeperDarker.MOD_ID + "." + DDDamageTypes.BITE.location().getPath(), "%s was devoured");
        add("death.attack." + DeeperDarker.MOD_ID + "." + DDDamageTypes.RING.location().getPath(), "%s was given a deadly case of tinnitus by %s");

        add("enchantment." + DeeperDarker.MOD_ID + "." + DDEnchantments.CATALYSIS.location().getPath(), convertToName(DDEnchantments.CATALYSIS.location().getPath()));
        add("enchantment." + DeeperDarker.MOD_ID + "." + DDEnchantments.CATALYSIS.location().getPath() + ".desc", "Spreads sculk when mobs are killed.");
        add("enchantment." + DeeperDarker.MOD_ID + "." + DDEnchantments.SCULK_SMITE.location().getPath(), convertToName(DDEnchantments.SCULK_SMITE.location().getPath()));
        add("enchantment." + DeeperDarker.MOD_ID + "." + DDEnchantments.SCULK_SMITE.location().getPath() + ".desc", "Increases damage against sculk mobs such as Shattered and the Warden.");

        add("painting." + DeeperDarker.MOD_ID + ".abstraction.title", "Abstraction");
        add("painting." + DeeperDarker.MOD_ID + ".abstraction.author", "Pedro Ricardo");
        add("painting." + DeeperDarker.MOD_ID + ".adventure.title", "Adventure");
        add("painting." + DeeperDarker.MOD_ID + ".adventure.author", "Pedro Ricardo");
        add("painting." + DeeperDarker.MOD_ID + ".carrot.title", "Back to Your Roots");
        add("painting." + DeeperDarker.MOD_ID + ".carrot.author", "Pedro Ricardo");
        add("painting." + DeeperDarker.MOD_ID + ".clouds.title", "Clouds");
        add("painting." + DeeperDarker.MOD_ID + ".clouds.author", "Pedro Ricardo");
        add("painting." + DeeperDarker.MOD_ID + ".echoer.title", "Echoer");
        add("painting." + DeeperDarker.MOD_ID + ".echoer.author", "Pedro Ricardo");
        add("painting." + DeeperDarker.MOD_ID + ".millipede.title", "Millipede");
        add("painting." + DeeperDarker.MOD_ID + ".millipede.author", "Pedro Ricardo");
        add("painting." + DeeperDarker.MOD_ID + ".ooze.title", "Ooze");
        add("painting." + DeeperDarker.MOD_ID + ".ooze.author", "Pedro Ricardo");

        add("subtitles.ambient.otherside.additions", "Warden dreams");
        add("subtitles.ambient.portal.groan", "The Otherside forebodes");
        add("subtitles.entity.angler_fish.death", "Angler Fish dies");
        add("subtitles.entity.angler_fish.flop", "Angler Fish flops");
        add("subtitles.entity.angler_fish.hurt", "Angler Fish hurts");
        add("subtitles.entity.leech.hurt", "Sculk Leech hurts");
        add("subtitles.entity.snapper.ambient", "Sculk Snapper breathes");
        add("subtitles.entity.snapper.bite", "Sculk Snapper bites");
        add("subtitles.entity.snapper.hurt", "Sculk Snapper hurts");
        add("subtitles.entity.snapper.sniff", "Sculk Snapper sniffs");
        add("subtitles.entity.shattered.ambient", "Shattered growls");
        add("subtitles.entity.shattered.death", "Shattered dies");
        add("subtitles.entity.shattered.hurt", "Shattered hurts");
        add("subtitles.entity.shattered.notice", "Shattered takes notice");
        add("subtitles.entity.shriek_worm.ambient", "Shriek Worm cries");
        add("subtitles.entity.shriek_worm.death", "Shriek Worm dies");
        add("subtitles.entity.shriek_worm.hurt", "Shriek Worm hurts");
        add("subtitles.entity.stalker.ambient", "Stalker chirps");
        add("subtitles.entity.stalker.death", "Stalker dies");
        add("subtitles.entity.stalker.hurt", "Stalker hurts");
        add("subtitles.entity.stalker.notice", "Stalker takes notice");
        add("subtitles.item.transmitter.error", "Transmitter fails");
        add("subtitles.item.transmitter.link", "Transmitter links");
        add("subtitles.item.transmitter.open", "Transmitter transmits");
        add("subtitles.item.transmitter.unlink", "Transmitter unlinks");

        add("tag.item." + DeeperDarker.MOD_ID + ".bloom_stems", "Blooming Stems");
        add("tag.item." + DeeperDarker.MOD_ID + ".echo_logs", "Echo Logs");
        add("tag.item." + DeeperDarker.MOD_ID + ".resonarium_armor", "Resonarium Armor");
        add("tag.item." + DeeperDarker.MOD_ID + ".dampens_vibrations", "Dampens Vibrations");
        add("tag.item." + DeeperDarker.MOD_ID + ".scutes", "Scutes");

        DDBlocks.BLOCKS.getEntries().forEach(block -> add(block, "block"));
        DDItems.ITEMS.getEntries().forEach(item -> add(item, "item"));
        DDEntities.ENTITIES.getEntries().forEach(entity -> add(entity, "entity"));
        DDEffects.EFFECTS.getEntries().forEach(effect -> add(effect, "effect"));
    }

    private void add(DeferredHolder<?, ?> entry, String prefix) {
        if(filter(entry)) return;
        String key = entry.getId().getPath();
        add(prefix + "." + DeeperDarker.MOD_ID + "." + key, convertToName(key));
    }

    private boolean filter(DeferredHolder<?, ?> entry) {
        if(entry.get() instanceof ItemNameBlockItem) return false;
        return entry.get() instanceof BlockItem || entry.get() instanceof WallSignBlock || entry.get() instanceof WallHangingSignBlock || entry.get() instanceof DDBoat || entry.get() instanceof DDChestBoat;
    }

    private String convertToName(String key) {
        StringBuilder builder = new StringBuilder(key.substring(0, 1).toUpperCase() + key.substring(1));
        for(int i = 1; i < builder.length(); i++) {
            if(builder.charAt(i) == '_') {
                builder.replace(i, i + 2, " " + Character.toUpperCase(builder.charAt(i + 1)));
            }
        }

        String name = builder.toString();
        if(name.contains("Chest ")) name = name.replace("Chest ", "") + " With Chest";
        if(name.contains("Lapis")) name = name.replace("Lapis", "Lapis Lazuli");
        if(name.contains("Of The")) name = name.replace("Of The", "of the");
        if(name.contains("Smithing")) name = "Smithing Template";
        if(name.contains("With")) name = name.replace("With", "with");

        return name;
    }
}
