package io.github.rysefoxx.document;

import io.github.cdimascio.dotenv.Dotenv;
import org.jetbrains.annotations.NotNull;

/**
 * @author Rysefoxx | Rysefoxx#6772
 * @since 6/18/2022
 */
public class Document {

    private static final Dotenv dotenv = Dotenv.load();

    public static String get(@NotNull String key) {
        return dotenv.get(key);
    }

}
