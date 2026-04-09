package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.level.chunk.LevelChunk;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LevelChunk.class)
public class DummyBlockEntityWarningMixin {
    @WrapOperation(method = "promotePendingBlockEntity", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", ordinal = 0))
    private void deeperdarker$cancelWarning(Logger instance, String string, Object o, Object p, Operation<Void> original) {
        if (!((LevelChunk) (Object) this).getLevel().dimension().equals(OthersideDimension.OTHERSIDE_LEVEL) || !DeeperDarker.CONFIG.server.cancelDummyBlockEntityWarning()) {
            original.call(instance, string, o, p);
        }
    }
}
