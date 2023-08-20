package com.kyanite.deeperdarker.content.blocks;

import net.kyrptonaught.customportalapi.portal.frame.VanillaPortalAreaHelper;

public class OthersidePortalFrameTester extends VanillaPortalAreaHelper {
    @Override
    public boolean isRequestedSize(int attemptWidth, int attemptHeight) {
        return (width >= 8) && (this.height >= 5);
    }
}
