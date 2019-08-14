package it.mcdev.fine.modules.teleport.data;

import it.mcdev.fine.commons.data.location.FineEntityLocation;
import it.mcdev.fine.commons.data.location.FineLocation;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class FineLocationTarget implements TeleportTarget {

    @NotNull
    private final FineLocation location;

    FineLocationTarget(@NotNull FineLocation location) {
        this.location = Objects.requireNonNull(location, "location");
    }

    @Override
    @NotNull
    public FineEntityLocation getLocation(@NotNull Entity teleporter) {
        Objects.requireNonNull(teleporter, "teleporter");
        return new FineEntityLocation(location, teleporter.getLocation().getYaw(), teleporter.getLocation().getPitch());
    }
}
