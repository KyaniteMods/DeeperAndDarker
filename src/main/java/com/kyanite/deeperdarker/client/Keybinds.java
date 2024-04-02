package com.kyanite.deeperdarker.client;

import com.kyanite.deeperdarker.DeeperDarker;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class Keybinds {
    public static final KeyMapping BOOST = register("boost", GLFW.GLFW_KEY_B);
    public static final KeyMapping TRANSMIT = register("transmit", GLFW.GLFW_KEY_V);

    private static KeyMapping register(String id, int key) {
        return KeyBindingHelper.registerKeyBinding(new KeyMapping("key." + DeeperDarker.MOD_ID + "." + id, key, "key.categories." + DeeperDarker.MOD_ID));
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering key bindings");
    }
}