package com.kyanite.deeperdarker.client;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class Keybinds {
    public static final KeyMapping BOOST = new KeyMapping("key." + DeeperDarker.MOD_ID + ".boost", GLFW.GLFW_KEY_B, "key.categories." + DeeperDarker.MOD_ID);
}
