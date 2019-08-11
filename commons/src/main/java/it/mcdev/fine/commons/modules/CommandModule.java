package it.mcdev.fine.commons.modules;

import ch.jalu.injector.factory.Factory;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.PaperCommandManager;
import org.reflections.Reflections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class CommandModule extends Module {

	private final Factory<BaseCommand> commandFactory;
	private final PaperCommandManager commandManager;

	private Set<BaseCommand> commands;

	protected CommandModule(Factory<BaseCommand> commandFactory, PaperCommandManager commandManager) {
		this.commandFactory = commandFactory;
		this.commandManager = commandManager;
		commands = new HashSet<>();
	}

	@Override
	public void enable() {
		onEnable();
		commands.addAll(getModuleCommandClasses().stream()
				.map(commandFactory::newInstance)
				.peek(commandManager::registerCommand)
				.collect(Collectors.toSet()));
	}

	@Override
	public void disable() {
		commands.forEach(commandManager::unregisterCommand);
		onDisable();
	}

	protected Collection<Class<? extends BaseCommand>> getModuleCommandClasses() {
		Reflections commandsReflection = new Reflections(getClass().getPackage().getName() + ".commands");
		return commandsReflection.getSubTypesOf(BaseCommand.class);
	}
}
