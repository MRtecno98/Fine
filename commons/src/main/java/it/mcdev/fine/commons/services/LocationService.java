package it.mcdev.fine.commons.services;

import it.mcdev.fine.commons.data.location.FineBlockLocation;
import it.mcdev.fine.commons.data.location.FineEntityLocation;
import it.mcdev.fine.commons.data.location.FineLocation;
import org.bukkit.Location;
import org.bukkit.Server;

import javax.inject.Inject;
import java.util.Optional;

public class LocationService {

    @Inject
    private Server server;

    public Optional<Location> queryFineBlockLocation(FineBlockLocation location) {
        return Optional.ofNullable(server.getWorld(location.getWorldName()))
                .map(world -> new Location(world, location.getX(), location.getY(), location.getZ()));
    }

    public Optional<Location> queryFineLocation(FineLocation location) {
        return Optional.ofNullable(server.getWorld(location.getWorldName()))
                .map(world -> new Location(world, location.getX(), location.getY(), location.getZ()));
    }

    public Optional<Location> queryFineEntityLocation(FineEntityLocation location) {
        return Optional.ofNullable(server.getWorld(location.getWorldName()))
                .map(world -> new Location(world, location.getX(), location.getY(), location.getZ(),
                        location.getYaw(), location.getPitch()));
    }
}
