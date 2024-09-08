package com.kyanite.deeperdarker.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.List;
import java.util.Optional;

public class SetPaintingVariantFunction extends LootItemConditionalFunction {
    public static final Codec<SetPaintingVariantFunction> CODEC = RecordCodecBuilder.create(instance -> SetPaintingVariantFunction.commonFields(instance).and(TagKey.codec(Registries.PAINTING_VARIANT).optionalFieldOf("tag").forGetter(function -> function.validPaintings)).apply(instance, SetPaintingVariantFunction::new));
    private final Optional<TagKey<PaintingVariant>> validPaintings;

    protected SetPaintingVariantFunction(List<LootItemCondition> list, Optional<TagKey<PaintingVariant>> validPaintings) {
        super(list);
        this.validPaintings = validPaintings;
    }

    @Override
    protected ItemStack run(ItemStack itemStack, LootContext lootContext) {
        if (!itemStack.is(DDTags.Items.PAINTINGS)) return itemStack;
        Optional<HolderLookup.RegistryLookup<PaintingVariant>> lookup = lootContext.getLevel().registryAccess().lookup(Registries.PAINTING_VARIANT);
        if (lookup.isEmpty()) return itemStack;
        List<Holder.Reference<PaintingVariant>> variants = lookup.get().listElements().filter(holder -> validPaintings.isEmpty() || holder.is(validPaintings.get())).toList();
        Holder.Reference<PaintingVariant> variant = Util.getRandom(variants, lootContext.getRandom());
        CompoundTag compoundTag = itemStack.getOrCreateTagElement("EntityTag");
        Painting.storeVariant(compoundTag, variant);
        return itemStack;
    }

    public static LootItemConditionalFunction.Builder<?> withTag(TagKey<PaintingVariant> tag) {
        if (tag == null) throw new IllegalArgumentException("Tag cannot be null");
        return SetPaintingVariantFunction.simpleBuilder(list -> new SetPaintingVariantFunction(list, Optional.of(tag)));
    }

    public static LootItemConditionalFunction.Builder<?> random() {
        return SetPaintingVariantFunction.simpleBuilder(list -> new SetPaintingVariantFunction(list, Optional.empty()));
    }

    @Override
    public LootItemFunctionType getType() {
        return DDLootItemFunctions.SET_PAINTING_VARIANT;
    }
}
