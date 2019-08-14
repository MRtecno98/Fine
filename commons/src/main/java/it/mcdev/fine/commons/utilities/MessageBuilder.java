package it.mcdev.fine.commons.utilities;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.*;

@SuppressWarnings({"unused", "WeakerAccess"})
public class MessageBuilder {

    @NotNull
    private final String message;
    private Map<String, String> placeholders;
    private boolean centered;
    private String boxing;

    public MessageBuilder(@NotNull String message) {
        Objects.requireNonNull(message, "message");
        this.message = message;
    }

    @NotNull
    public MessageBuilder placeholder(@NotNull String key, @NotNull String value) {
        Objects.requireNonNull(key, "key");
        Objects.requireNonNull(value, "value");
        if (placeholders == null) {
            placeholders = new HashMap<>();
        }
        placeholders.put(key, value);
        return this;
    }

    @NotNull
    public MessageBuilder centered() {
        this.centered = true;
        return this;
    }

    @NotNull
    public MessageBuilder boxing(@NotNull String pattern) {
        Objects.requireNonNull(pattern, "pattern");
        this.boxing = pattern;
        return this;
    }

    @NotNull
    public String[] render() {
        String message = this.message;
        // Apply placeholders
        if (placeholders != null) {
            for (Map.Entry<String, String> entry : placeholders.entrySet()) {
                message = message.replace("%" + entry.getKey() + "%", entry.getValue());
            }
        }
        // Apply format
        message = FormatUtilities.format(message);
        // Split lines
        int longest = 0;
        List<String> lines = new ArrayList<>();
        for (String line : message.split("\n")) {
            // Apply centered alignment
            int rawLength = ChatColor.stripColor(line).length();
            int available = FormatUtilities.LINE_LENGTH - rawLength;
            int lineLength = rawLength;
            if (centered) {
                if (available > 1) {
                    int pre = available / 2;
                    int post = available - pre;
                    line = StringUtils.repeat(" ", post) + line + StringUtils.repeat(" ", post);
                }
                lineLength += available;
            }
            if (longest < lineLength) {
                longest = lineLength;
            }
            lines.add(line);
        }
        // Apply boxing pattern
        if (boxing != null) {
            String boxing = FormatUtilities.format(this.boxing);
            int boxingLength = ChatColor.stripColor(boxing).length();
            boxing = StringUtils.repeat(boxing, (int) Math.ceil(longest / boxingLength));
            lines.add(0, boxing);
            lines.add(boxing);
        }
        return lines.toArray(new String[0]);
    }

    public void sendMessage(@NotNull CommandSender sender) {
        Objects.requireNonNull(sender, "sender");
        sender.sendMessage(render());
    }
}
