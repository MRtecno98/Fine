package it.mcdev.fine.commons.modules;

import co.aikar.commands.BaseCommand;
import org.reflections.Reflections;

import java.util.Collection;

public abstract class Module {

    private boolean enabled;

    public String getName() {
        return getClass().getSimpleName();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void enable() {
        onEnable();
        enabled = true;
    }

    public void disable() {
        onDisable();
        enabled = false;
    }

    protected abstract void onEnable();

    protected abstract void onDisable();

    protected Collection<Class<? extends BaseCommand>> getModuleCommandClasses() {
        Reflections commandsReflection = new Reflections(getClass().getPackage().getName() + ".commands");
        return commandsReflection.getSubTypesOf(BaseCommand.class);
    }
}
