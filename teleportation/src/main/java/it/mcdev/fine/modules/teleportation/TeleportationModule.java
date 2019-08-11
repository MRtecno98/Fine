package it.mcdev.fine.modules.teleportation;

import ch.jalu.injector.factory.Factory;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.PaperCommandManager;
import it.mcdev.fine.commons.modules.CommandModule;

import javax.inject.Inject;

public class TeleportationModule extends CommandModule {

	@Inject
	TeleportationModule(Factory<BaseCommand> commandFactory, PaperCommandManager commandManager) {
		super(commandFactory, commandManager);
	}

	@Override
	protected void onEnable() {
	}

	@Override
	protected void onDisable() {
	}
}
