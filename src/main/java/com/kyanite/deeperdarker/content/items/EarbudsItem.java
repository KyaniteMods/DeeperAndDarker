package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.content.DDSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EarbudsItem extends Item implements Equipable {
    public EarbudsItem(Properties properties) {
        super(properties);
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }

    @Override
    public SoundEvent getEquipSound() {
        return DDSounds.STALKER_AMBIENT;
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int slotIndex, boolean selected) {
        super.inventoryTick(itemStack, level, entity, slotIndex, selected);
        if (slotIndex == EquipmentSlot.HEAD.getIndex() && entity.level().isClientSide()) {
            Minecraft.getInstance().options.getSoundSourceOptionInstance(SoundSource.MASTER).set(1.0);
            Minecraft.getInstance().options.getSoundSourceOptionInstance(SoundSource.AMBIENT).set(1.0);
            Minecraft.getInstance().options.getSoundSourceOptionInstance(SoundSource.BLOCKS).set(1.0);
            Minecraft.getInstance().options.getSoundSourceOptionInstance(SoundSource.HOSTILE).set(1.0);
            Minecraft.getInstance().options.getSoundSourceOptionInstance(SoundSource.MUSIC).set(1.0);
            Minecraft.getInstance().options.getSoundSourceOptionInstance(SoundSource.NEUTRAL).set(1.0);
            Minecraft.getInstance().options.getSoundSourceOptionInstance(SoundSource.PLAYERS).set(1.0);
            Minecraft.getInstance().options.getSoundSourceOptionInstance(SoundSource.RECORDS).set(1.0);
            Minecraft.getInstance().options.getSoundSourceOptionInstance(SoundSource.VOICE).set(1.0);
            Minecraft.getInstance().options.getSoundSourceOptionInstance(SoundSource.WEATHER).set(1.0);
            Minecraft.getInstance().options.save();
        }
    }
}
