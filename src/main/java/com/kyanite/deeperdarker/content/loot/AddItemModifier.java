package com.kyanite.deeperdarker.content.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

@SuppressWarnings("NullableProblems")
public class AddItemModifier extends LootModifier {
    public static final MapCodec<AddItemModifier> CODEC = RecordCodecBuilder.mapCodec(instance -> codecStart(instance).and(instance.group(
            ItemStack.ITEM_NON_AIR_CODEC.fieldOf("item").forGetter(modifier -> Holder.direct(modifier.item)),
            Codec.INT.fieldOf("min").forGetter(modifier -> modifier.min),
            Codec.INT.fieldOf("max").forGetter(modifier -> modifier.max)
    )).apply(instance, AddItemModifier::new));

    private final Item item;
    private final int min;
    private final int max;

    public AddItemModifier(LootItemCondition[] conditionsIn, Item item) {
        this(conditionsIn, Holder.direct(item), 1, 1);
    }

    public AddItemModifier(LootItemCondition[] conditionsIn, Item item, int max) {
        this(conditionsIn, Holder.direct(item), 1, max);
    }

    public AddItemModifier(LootItemCondition[] conditionsIn, Holder<Item> item, int min, int max) {
        super(conditionsIn);
        this.item = item.value();
        this.min = min;
        this.max = max;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        for(LootItemCondition condition : conditions) {
            if(!condition.test(context)) return generatedLoot;
        }
        RandomSource random = context.getRandom();
        generatedLoot.add(new ItemStack(item, random.nextInt(min, max + 1)));
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
