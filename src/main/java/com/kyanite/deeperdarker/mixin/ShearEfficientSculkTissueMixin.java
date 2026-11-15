package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.component.Tool;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.ArrayList;
import java.util.List;

@Mixin(ShearsItem.class)
public abstract class ShearEfficientSculkTissueMixin {
    @WrapOperation(method = "createToolProperties", at = @At(value = "INVOKE", target = "Ljava/util/List;of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/List;"))
    private static <E> List<E> deeperdarker$shearEfficientSculkTissue(E e1, E e2, E e3, E e4, Operation<List<E>> original) {
        List<E> originalList = original.call(e1, e2, e3, e4);
        ArrayList<E> arrayList = new ArrayList<>(originalList);
        arrayList.add((E) Tool.Rule.minesAndDrops(List.of(DDBlocks.SCULK_TISSUE), 5.0f));
        return List.copyOf(arrayList);
    }
}
