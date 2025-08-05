package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.misc.PortalData;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class DDDataAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, DeeperDarker.MOD_ID);
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<PortalData>> PORTAL_DATA = ATTACHMENTS.register("portal_data", () -> AttachmentType.builder(PortalData::new).build());
}
