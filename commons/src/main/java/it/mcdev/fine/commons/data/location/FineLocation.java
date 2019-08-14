package it.mcdev.fine.commons.data.location;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@SuppressWarnings({"unused", "WeakerAccess"})
public class FineLocation {

    @NotNull
    private final String worldName;
    private final double x;
    private final double y;
    private final double z;

    public FineLocation(@NotNull String worldName, double x, double y, double z) {
        this.worldName = Objects.requireNonNull(worldName, "worldName");
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @NotNull
    public String getWorldName() {
        return worldName;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @NotNull
    public FineLocation setX(double x) {
        return new FineLocation(this.worldName, x, this.y, this.z);
    }

    @NotNull
    public FineLocation addX(double x) {
        return setX(this.x + x);
    }

    @NotNull
    public FineLocation subtractX(double x) {
        return setX(this.x - x);
    }

    @NotNull
    public FineLocation setY(double y) {
        return new FineLocation(this.worldName, this.x, y, this.z);
    }

    @NotNull
    public FineLocation addY(double y) {
        return setX(this.y + y);
    }

    @NotNull
    public FineLocation subtractY(double y) {
        return setX(this.y - y);
    }

    @NotNull
    public FineLocation setZ(double z) {
        return new FineLocation(this.worldName, this.x, this.y, z);
    }

    @NotNull
    public FineLocation addZ(double z) {
        return setX(this.z + z);
    }

    @NotNull
    public FineLocation subtractZ(double z) {
        return setX(this.z - z);
    }

    @NotNull
    public FineLocation add(double x, double y, double z) {
        return new FineLocation(this.worldName, this.x + x, this.y + y, this.z + z);
    }

    @NotNull
    public FineLocation add(@NotNull FineLocation location) {
        Objects.requireNonNull(location, "location");
        if (!location.worldName.equals(this.worldName)) {
            throw new IllegalArgumentException("Can't sum locations from different worlds!");
        }
        return add(location.x, location.y, location.z);
    }

    @NotNull
    public FineLocation subtract(double x, double y, double z) {
        return new FineLocation(this.worldName, this.x - x, this.y - y, this.z - z);
    }

    @NotNull
    public FineLocation subtract(@NotNull FineLocation location) {
        Objects.requireNonNull(location, "location");
        if (!location.worldName.equals(this.worldName)) {
            throw new IllegalArgumentException("Can't subtract locations from different worlds!");
        }
        return subtract(location.x, location.y, location.z);
    }

    @NotNull
    public FineBlockLocation toFineBlockLocation() {
        return new FineBlockLocation(worldName, (int) x, (int) y, (int) z);
    }

    @NotNull
    public static FineLocation fromFineBlockLocation(@NotNull FineBlockLocation location) {
        return Objects.requireNonNull(location, "location").toFineLocation();
    }

    @NotNull
    public static FineLocation fromLocation(@NotNull Location location) {
        Objects.requireNonNull(location, "location");
        return new FineLocation(location.getWorld().getName(),
                location.getX(), location.getY(), location.getZ());
    }
}
