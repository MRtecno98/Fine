package it.mcdev.fine.modules.teleport;

import it.mcdev.fine.commons.modules.FineModule;
import org.slf4j.Logger;

public class FineTeleport extends FineModule {

    private Logger logger;

    @Override
    public void enable() {
        logger = getModuleLogger();
    }

    @Override
    public void disable() {
    }
}
