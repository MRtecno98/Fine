package it.mcdev.fine.commons.module;

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
}
