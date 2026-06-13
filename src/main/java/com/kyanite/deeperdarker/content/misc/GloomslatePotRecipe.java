package com.kyanite.deeperdarker.content.misc;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.PotDecorations;

@SuppressWarnings("NullableProblems")
public class GloomslatePotRecipe extends CustomRecipe {
    public static final MapCodec<GloomslatePotRecipe> MAP_CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
            Ingredient.CODEC.fieldOf("back").forGetter(o -> o.backPattern),
            Ingredient.CODEC.fieldOf("left").forGetter(o -> o.leftPattern),
            Ingredient.CODEC.fieldOf("right").forGetter(o -> o.rightPattern),
            Ingredient.CODEC.fieldOf("front").forGetter(o -> o.frontPattern),
            ItemStackTemplate.CODEC.fieldOf("result").forGetter(o -> o.result)
    ).apply(i, GloomslatePotRecipe::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, GloomslatePotRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, i -> i.backPattern,
            Ingredient.CONTENTS_STREAM_CODEC, i -> i.leftPattern,
            Ingredient.CONTENTS_STREAM_CODEC, i -> i.rightPattern,
            Ingredient.CONTENTS_STREAM_CODEC, i -> i.frontPattern,
            ItemStackTemplate.STREAM_CODEC, i -> i.result,
            GloomslatePotRecipe::new
    );
    public static final RecipeSerializer<GloomslatePotRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);
    private final Ingredient backPattern;
    private final Ingredient leftPattern;
    private final Ingredient rightPattern;
    private final Ingredient frontPattern;
    private final ItemStackTemplate result;

    public GloomslatePotRecipe(Ingredient pattern, ItemStackTemplate result) {
        this(pattern, pattern, pattern, pattern, result);
    }

    public GloomslatePotRecipe(Ingredient backPattern, Ingredient leftPattern, Ingredient rightPattern, Ingredient frontPattern, ItemStackTemplate result) {
        this.backPattern = backPattern;
        this.leftPattern = leftPattern;
        this.rightPattern = rightPattern;
        this.frontPattern = frontPattern;
        this.result = result;
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {
        return input.width() == 3 && input.height() == 3 && input.ingredientCount() == 4
                && this.backPattern.test(back(input))
                && this.leftPattern.test(left(input))
                && this.rightPattern.test(right(input))
                && this.frontPattern.test(front(input));
    }

    @Override
    public ItemStack assemble(CraftingInput input) {
        PotDecorations decorations = new PotDecorations(input.getItem(1).getItem(), input.getItem(3).getItem(), input.getItem(5).getItem(), input.getItem(7).getItem());
        ItemStack stack = DDBlocks.GLOOMSLATE_POT.toStack();
        stack.set(DataComponents.POT_DECORATIONS, decorations);
        return stack;
    }

    private static ItemStack back(CraftingInput input) {
        return input.getItem(1, 0);
    }

    private static ItemStack left(CraftingInput input) {
        return input.getItem(0, 1);
    }

    private static ItemStack right(CraftingInput input) {
        return input.getItem(2, 1);
    }

    private static ItemStack front(CraftingInput input) {
        return input.getItem(1, 2);
    }

    @Override
    public RecipeSerializer<? extends CustomRecipe> getSerializer() {
        return SERIALIZER;
    }
}
