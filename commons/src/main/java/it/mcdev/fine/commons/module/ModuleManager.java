package it.mcdev.fine.commons.module;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

public class ModuleManager {

	private Map<String, Module> modules;

	@Inject
	ModuleManager() {
		modules = new LinkedHashMap<>();
	}

	public void registerModule(@NotNull Module module) {
		Objects.requireNonNull(module, "module");
		modules.put(module.getName(), module);
	}

	public Optional<Module> getModule(@NotNull String name) {
		Objects.requireNonNull(name, "name");
		return Optional.ofNullable(modules.get(name));
	}

	@NotNull
	public Collection<Module> getModules() {
		return Collections.unmodifiableCollection(modules.values());
	}

	@NotNull
	public Collection<Module> getEnabledModules() {
		return Collections.unmodifiableCollection(
				getModules().stream()
						.filter(Module::isEnabled)
						.collect(Collectors.toList())
		);
	}

	public void enableModule(Module module) {
		module.enable();
	}

	public void disableModule(Module module) {
		module.disable();
	}
}
