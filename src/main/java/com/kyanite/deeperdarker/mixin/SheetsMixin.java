package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.DeeperDarkerClient;
import com.kyanite.deeperdarker.content.entities.blocks.DeadMansChestBlockEntity;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Consumer;

@Mixin(Sheets.class)
public abstract class SheetsMixin {
    @Shadow
    private static Material chooseMaterial(ChestType chestType, Material material, Material material2, Material material3) {
        return null;
    }

    @Inject(method = "getAllMaterials", at = @At("TAIL"))
    private static void deeperdarker$addDeadMansChestLocations(Consumer<Material> consumer, CallbackInfo ci) {
        consumer.accept(DeeperDarkerClient.DEAD_MANS_CHEST_LOCATION);
        consumer.accept(DeeperDarkerClient.DEAD_MANS_CHEST_LOCATION_LEFT);
        consumer.accept(DeeperDarkerClient.DEAD_MANS_CHEST_LOCATION_RIGHT);
    }

    @Inject(method = "chooseMaterial(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/level/block/state/properties/ChestType;Z)Lnet/minecraft/client/resources/model/Material;", at = @At("HEAD"), cancellable = true)
    private static void deeperdarker$chooseDeadMansChestMaterial(BlockEntity blockEntity, ChestType chestType, boolean bl, CallbackInfoReturnable<Material> cir) {
        if (blockEntity instanceof DeadMansChestBlockEntity) {
            cir.setReturnValue(chooseMaterial(chestType, DeeperDarkerClient.DEAD_MANS_CHEST_LOCATION, DeeperDarkerClient.DEAD_MANS_CHEST_LOCATION_LEFT, DeeperDarkerClient.DEAD_MANS_CHEST_LOCATION_RIGHT));
        }
    }
}
