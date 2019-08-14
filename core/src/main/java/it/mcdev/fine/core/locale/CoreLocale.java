package it.mcdev.fine.core.locale;

import it.mcdev.fine.commons.messages.AbstractLocale;
import it.mcdev.fine.commons.messages.LocaleKey;
import it.mcdev.fine.core.CoreLogger;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;

public class CoreLocale extends AbstractLocale {

    private static final Set<LocaleKey> KEYS = new LinkedHashSet<>();

    public static final LocaleKey PREFIX = key("prefix");
    public static final LocaleKey COMMAND_ABOUT = key("command.about", "version");

    @Inject
    CoreLocale(@CoreLogger Logger logger, @CoreLocaleFolder File localeFolder) {
        super(logger, KEYS, localeFolder);
    }

    private static LocaleKey key(@NotNull String path, String... placeholders) {
        LocaleKey key = new LocaleKey(path, placeholders);
        KEYS.add(key);
        return key;
    }
}
