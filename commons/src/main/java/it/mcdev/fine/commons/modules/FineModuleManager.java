package it.mcdev.fine.commons.modules;

import ch.jalu.injector.Injector;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

public class FineModuleManager {

    @Inject
    private Injector injector;

    @NotNull
    private final Set<FineModule> loadedModules = new HashSet<>();

    @NotNull
    public Injector getCoreInjector() {
        return injector;
    }

    protected void registerModule(FineModule module) {
        if (loadedModules.contains(module)) {
            throw new IllegalStateException("Module " + module.getName() + " is already registered!");
        }
        loadedModules.add(module);
    }

    protected void unregisterModule(FineModule module) {
        loadedModules.remove(module);
    }

    @NotNull
    public Set<FineModule> getLoadedModules() {
        return loadedModules;
    }
}
