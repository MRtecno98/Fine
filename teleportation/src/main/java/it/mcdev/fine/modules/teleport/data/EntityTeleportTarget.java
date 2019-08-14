package it.mcdev.fine.modules.teleport.data;

import it.mcdev.fine.commons.data.location.FineEntityLocation;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class EntityTeleportTarget implements TeleportTarget {

    @NotNull
    private final Entity entity;

    EntityTeleportTarget(@NotNull Entity entity) {
        this.entity = entity;
    }

    @Override
    @NotNull
    public FineEntityLocation getLocation(@NotNull Entity teleporter) {
        Objects.requireNonNull(teleporter, "teleporter");
        return FineEntityLocation.fromEntity(this.entity);
    }
}
