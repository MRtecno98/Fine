package it.mcdev.fine.bootstrap;

import ch.jalu.injector.Injector;
import ch.jalu.injector.InjectorBuilder;
import it.mcdev.fine.commons.modules.ModuleManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;

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
		//moduleManager.registerModule(injector.getSingleton(AwesomeModule.class));
	}

	@Override
	public void onDisable() {
	}
}
