package it.mcdev.fine.commons.messages;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public abstract class AbstractLocale {

    @NotNull
    protected final Logger logger;
    @NotNull
    private final File localeFolder;

    private final Table<String, LocaleKey, String> localeTable;

    protected AbstractLocale(@NotNull Logger logger, @NotNull Set<LocaleKey> keys, @NotNull File localeFolder) {
        Objects.requireNonNull(logger, "logger");
        Objects.requireNonNull(keys, "keys");
        Objects.requireNonNull(localeFolder, "localeFolder");
        this.logger = logger;
        this.localeFolder = localeFolder;
        localeTable = HashBasedTable.create();
        localeTable.columnKeySet().addAll(keys);
        reload();
    }

    public void reload() {
        logger.debug("Loading locales...");
        localeTable.columnKeySet().clear();
        if (!localeFolder.exists()) {
            localeFolder.mkdirs();
        }
        // TODO: copy defaults
        for (File file : localeFolder.listFiles()) {
            String lowerName = file.getName().toLowerCase();
            if (!lowerName.endsWith(".yml")) {
                continue;
            }
            String localeName = lowerName.split(".yml")[0];
            logger.debug("Loading locale " + localeName + "...");
            YamlConfiguration localeSource = YamlConfiguration.loadConfiguration(file);
            Map<LocaleKey, String> entries = new LinkedHashMap<>();
            for (LocaleKey key : getKeys()) {
                String message = localeSource.getString(key.getPath());
                if (message == null) {
                    // TODO: read the dafault language from the jar and copy value, throw exception if still missing
                    throw new IllegalStateException("Missing locale key in " + lowerName + "! " + key.getPath());
                }
                entries.put(key, message);
            }
            entries.forEach((key, message) -> localeTable.put(localeName, key, message));
            logger.debug("Loaded locale " + localeName);
        }
        logger.debug("Loaded locales");
    }

    public String getMessage(@NotNull String locale, @NotNull LocaleKey key) {
        Objects.requireNonNull(locale, "locale");
        Objects.requireNonNull(key, "key");
        return localeTable.get(locale, key);
    }

    public Set<String> getLocales() {
        return localeTable.rowKeySet();
    }

    public Set<LocaleKey> getKeys() {
        return localeTable.columnKeySet();
    }
}
