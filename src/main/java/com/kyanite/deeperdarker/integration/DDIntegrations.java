package com.kyanite.deeperdarker.integration;

import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;


public class DDIntegrations {
    public static boolean TOPLoaded;
    public static final String TOP_MOD_ID = "theoneprobe";

    public static void commonSetup() {
        ModList modList = ModList.get();
        TOPLoaded = modList.isLoaded(TOP_MOD_ID);
    }

    public static void sendIMCs(final InterModEnqueueEvent event) {
        if (TOPLoaded) {
            InterModComms.sendTo(TOP_MOD_ID, "getTheOneProbe", DDOneProbe::new);
        }
    }
}
