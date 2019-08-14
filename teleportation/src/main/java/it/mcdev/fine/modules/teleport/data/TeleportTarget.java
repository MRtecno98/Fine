package it.mcdev.fine.modules.teleport.data;

import it.mcdev.fine.commons.data.location.FineEntityLocation;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

public interface TeleportTarget {

    @NotNull
    FineEntityLocation getLocation(@NotNull Entity teleporter);
}
