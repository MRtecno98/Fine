package it.mcdev.fine.commons.data.location;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@SuppressWarnings({"unused", "WeakerAccess"})
public class FineEntityLocation extends FineLocation {

    private final float yaw;
    private final float pitch;

    public FineEntityLocation(@NotNull String worldName, double x, double y, double z, float yaw, float pitch) {
        super(worldName, x, y, z);
        this.yaw = Location.normalizeYaw(yaw);
        this.pitch = Location.normalizePitch(pitch);
    }

    public FineEntityLocation(@NotNull FineLocation location, float yaw, float pitch) {
        this(Objects.requireNonNull(location, "location").getWorldName(),
                location.getX(), location.getY(), location.getZ(), yaw, pitch);
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }

    @NotNull
    public FineEntityLocation setYaw(float yaw) {
        return new FineEntityLocation(this, yaw, this.pitch);
    }

    @NotNull
    public FineEntityLocation addYaw(float yaw) {
        return setYaw(this.yaw + yaw);
    }

    @NotNull
    public FineEntityLocation subtractYaw(float yaw) {
        return setYaw(this.yaw - yaw);
    }

    @NotNull
    public FineEntityLocation setPitch(float pitch) {
        return new FineEntityLocation(this, this.yaw, pitch);
    }

    @NotNull
    public FineEntityLocation addPitch(float pitch) {
        return setPitch(this.pitch + pitch);
    }

    @NotNull
    public FineEntityLocation subtractPitch(float pitch) {
        return setPitch(this.pitch - pitch);
    }

    @NotNull
    public static FineEntityLocation fromLocationWithDirection(@NotNull Location location) {
        Objects.requireNonNull(location, "location");
        return new FineEntityLocation(location.getWorld().getName(),
                location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    }

    @NotNull
    public static FineEntityLocation fromEntity(@NotNull Entity entity) {
        Objects.requireNonNull(entity, "entity");
        return fromLocationWithDirection(entity.getLocation());
    }
}
