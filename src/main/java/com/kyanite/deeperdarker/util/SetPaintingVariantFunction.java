package com.kyanite.deeperdarker.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.kyanite.deeperdarker.DeeperDarker;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public class SetPaintingVariantFunction extends LootItemConditionalFunction {
    private final Optional<TagKey<PaintingVariant>> validPaintings;

    protected SetPaintingVariantFunction(LootItemCondition[] list, Optional<TagKey<PaintingVariant>> validPaintings) {
        super(list);
        this.validPaintings = validPaintings;
    }

    @Override
    protected @NotNull ItemStack run(ItemStack itemStack, LootContext lootContext) {
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
    public @NotNull LootItemFunctionType getType() {
        return DDLootItemFunctions.SET_PAINTING_VARIANT;
    }

    public static class Serializer
            extends LootItemConditionalFunction.Serializer<SetPaintingVariantFunction> {
        @Override
        public void serialize(JsonObject jsonObject, SetPaintingVariantFunction copyNameFunction, JsonSerializationContext jsonSerializationContext) {
            super.serialize(jsonObject, copyNameFunction, jsonSerializationContext);
            copyNameFunction.validPaintings.ifPresent(paintingVariantTagKey -> jsonObject.addProperty("tag", paintingVariantTagKey.location().toString()));
        }

        @Override
        public @NotNull SetPaintingVariantFunction deserialize(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext, LootItemCondition[] lootItemConditions) {
            Optional<TagKey<PaintingVariant>> optional = jsonObject.has("tag") ? TagKey.codec(Registries.PAINTING_VARIANT).parse(JsonOps.INSTANCE, jsonObject.get("tag")).result() : Optional.empty();
            return new SetPaintingVariantFunction(lootItemConditions, optional);
        }
    }
}
