package it.mcdev.fine.commons.utilities;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class FormatUtilities {

    public static final int LINE_LENGTH = 53;

    private FormatUtilities() {
    }

    @NotNull
    public static String format(@NotNull String message) {
        Objects.requireNonNull(message, "message");
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
