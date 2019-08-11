package it.mcdev.fine.bootstrap;

import ch.jalu.injector.Injector;
import ch.jalu.injector.InjectorBuilder;
import it.mcdev.fine.commons.modules.Module;
import it.mcdev.fine.commons.modules.ModuleManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;
import org.slf4j.Logger;

import java.util.Collection;

public final class Fine extends JavaPlugin {

    private Logger logger;
    private Injector injector;
    private ModuleManager moduleManager;

    @Override
    public void onEnable() {
        logger = getSLF4JLogger();
        injector = new InjectorBuilder().addDefaultHandlers("it.mcdev.fine").create();
        injector.register(Logger.class, logger);
        this.moduleManager = injector.getSingleton(ModuleManager.class);
        getBuiltInModuleClasses().stream()
                .map(injector::newInstance)
                .forEach(moduleManager::registerModule);
    }

    @Override
    public void onDisable() {
    }

    private Collection<Class<? extends Module>> getBuiltInModuleClasses() {
        Reflections commandsReflection = new Reflections(getClass().getPackage().getName() + ".modules");
        return commandsReflection.getSubTypesOf(Module.class);
    }
}
