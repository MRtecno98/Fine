package it.mcdev.fine.commons.messages;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class LocaleKey {

    @NotNull
    private final String path;
    private final String[] placeholders;

    public LocaleKey(@NotNull String path, String[] placeholders) {
        Objects.requireNonNull(path, "path");
        this.path = path;
        this.placeholders = placeholders;
    }

    @NotNull
    public String getPath() {
        return path;
    }

    @NotNull
    public String[] getPlaceholders() {
        return placeholders;
    }
}
