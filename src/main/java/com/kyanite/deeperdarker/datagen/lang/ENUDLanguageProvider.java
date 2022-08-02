package com.kyanite.deeperdarker.datagen.lang;

import com.google.common.hash.Hashing;
import com.google.common.hash.HashingOutputStream;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import org.apache.commons.lang3.text.translate.JavaUnicodeEscaper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

// Taken (with permission!) from a commit provided by Matyrobbrt: https://github.com/Matyrobbrt
public class ENUDLanguageProvider implements DataProvider {
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
    private final DataGenerator generator;
    private final Map<String, String> data = new HashMap<>();
    public ENUDLanguageProvider(DataGenerator pGenerator) {
        this.generator = pGenerator;
    }

    protected void addTranslations() {

        // noinspection ConstantConditions

        try (final var is = new InputStreamReader(DeeperAndDarker.class.getResourceAsStream("/assets/deeperdarker/lang/en_us.json"))) {

            final var json = new Gson().fromJson(is, JsonObject.class);

            json.entrySet().forEach(entry -> data.put(entry.getKey(), toUpsideDown(entry.getValue().getAsString())));

        } catch (IOException e) {

            DeeperAndDarker.LOGGER.warn("Failed to generate en_ud translations: ", e);

        }

    }

    @Override
    public void run(@NotNull CachedOutput cache) throws IOException {
        addTranslations();
        JsonObject json = new JsonObject();
        for (Map.Entry<String, String> pair : data.entrySet()) {
            json.addProperty(pair.getKey(), pair.getValue());
        }
        final var data = escape(GSON.toJson(json));
        saveStable(cache, data, generator.getOutputFolder().resolve("assets/" + DeeperAndDarker.MOD_ID + "/lang/en_ud.json"));
    }

    @SuppressWarnings({"UnstableApiUsage", "deprecation"})
    private static void saveStable(CachedOutput p_236073_, String p_236074_, Path p_236075_) throws IOException {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        HashingOutputStream hashingoutputstream = new HashingOutputStream(Hashing.sha1(), bytearrayoutputstream);
        hashingoutputstream.write(p_236074_.getBytes(StandardCharsets.UTF_8));
        p_236073_.writeIfNeeded(p_236075_, bytearrayoutputstream.toByteArray(), hashingoutputstream.hash());
    }

    @Override
    public @NotNull String getName() {
        return "Languages: en_ud";
    }

    // Automatic en_ud generation

    private static final String NORMAL_CHARS =
            /* lowercase */ "abcdefghijklmn\u00F1opqrstuvwxyz" +
            /* uppercase */ "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            /*  numbers  */ "0123456789" +
            /*  special  */ "_,;.?!/\\'";

    private static final String UPSIDE_DOWN_CHARS =
            /* lowercase */ "\u0250q\u0254p\u01DD\u025Fb\u0265\u0131\u0638\u029E\u05DF\u026Fuuodb\u0279s\u0287n\u028C\u028Dx\u028Ez" +
            /* uppercase */ "\u2C6F\u15FA\u0186\u15E1\u018E\u2132\u2141HI\u017F\u029E\uA780WNO\u0500\u1F49\u1D1AS\u27D8\u2229\u039BMX\u028EZ" +
            /*  numbers  */ "0\u0196\u1105\u0190\u3123\u03DB9\u312586" +
            /*  special  */ "\u203E'\u061B\u02D9\u00BF\u00A1/\\,";

    @SuppressWarnings("deprecation")
    public static String escape(String data) {
        return JavaUnicodeEscaper.outsideOf(0, 0x7f).translate(data);
    }

    public static String toUpsideDown(@Nullable String normal) {
        if (normal == null)
            return null;
        char[] ud = new char[normal.length()];
        for (int i = 0; i < normal.length(); i++) {
            char c = normal.charAt(i);
            if (c == '%') {
                StringBuilder fmtArg = new StringBuilder();
                while (Character.isDigit(c) || c == '%' || c == '$' || c == 's' || c == 'd') {
                    fmtArg.append(c);
                    i++;
                    c = i == normal.length() ? 0 : normal.charAt(i);
                }
                i--;
                for (int j = 0; j < fmtArg.length(); j++) {
                    ud[normal.length() - 1 - i + j] = fmtArg.charAt(j);
                }
                continue;
            }
            int lookup = NORMAL_CHARS.indexOf(c);
            if (lookup >= 0) {
                c = UPSIDE_DOWN_CHARS.charAt(lookup);
            }
            ud[normal.length() - 1 - i] = c;
        }
        return new String(ud);
    }
}