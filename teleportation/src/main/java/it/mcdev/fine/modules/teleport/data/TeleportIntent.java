package it.mcdev.fine.modules.teleport.data;

import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class TeleportIntent {

    @NotNull
    private final Entity teleporter;
    @NotNull
    private final TeleportTarget target;

    public TeleportIntent(@NotNull Entity teleporter, @NotNull TeleportTarget target) {
        this.teleporter = Objects.requireNonNull(teleporter, "teleporter");
        this.target = Objects.requireNonNull(target, "target");
    }

    public Entity getTeleporter() {
        return teleporter;
    }

    public TeleportTarget getTarget() {
        return target;
    }
}
