package it.mcdev.fine.commons.data.location;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@SuppressWarnings({"unused", "WeakerAccess"})
public class FineBlockLocation {

    @NotNull
    private final String worldName;
    private final int x;
    private final int y;
    private final int z;

    public FineBlockLocation(@NotNull String worldName, int x, int y, int z) {
        this.worldName = Objects.requireNonNull(worldName, "worldName");
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @NotNull
    public String getWorldName() {
        return worldName;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @NotNull
    public FineBlockLocation setX(int x) {
        return new FineBlockLocation(this.worldName, x, this.y, this.z);
    }

    @NotNull
    public FineBlockLocation addX(int x) {
        return setX(this.x + x);
    }

    @NotNull
    public FineBlockLocation subtractX(int x) {
        return setX(this.x - x);
    }

    @NotNull
    public FineBlockLocation setY(int y) {
        return new FineBlockLocation(this.worldName, this.x, y, this.z);
    }

    @NotNull
    public FineBlockLocation addY(int y) {
        return setX(this.y + y);
    }

    @NotNull
    public FineBlockLocation subtractY(int y) {
        return setX(this.y - y);
    }

    @NotNull
    public FineBlockLocation setZ(int z) {
        return new FineBlockLocation(this.worldName, this.x, this.y, z);
    }

    @NotNull
    public FineBlockLocation addZ(int z) {
        return setX(this.z + z);
    }

    @NotNull
    public FineBlockLocation subtractZ(int z) {
        return setX(this.z - z);
    }

    @NotNull
    public FineBlockLocation add(int x, int y, int z) {
        return new FineBlockLocation(this.worldName, this.x + x, this.y + y, this.z + z);
    }

    @NotNull
    public FineBlockLocation add(@NotNull FineBlockLocation location) {
        Objects.requireNonNull(location, "location");
        if (!location.worldName.equals(this.worldName)) {
            throw new IllegalArgumentException("Can't sum locations from different worlds!");
        }
        return add(location.x, location.y, location.z);
    }

    @NotNull
    public FineBlockLocation subtract(int x, int y, int z) {
        return new FineBlockLocation(this.worldName, this.x - x, this.y - y, this.z - z);
    }

    @NotNull
    public FineBlockLocation subtract(@NotNull FineBlockLocation location) {
        Objects.requireNonNull(location, "location");
        if (!location.worldName.equals(this.worldName)) {
            throw new IllegalArgumentException("Can't subtract locations from different worlds!");
        }
        return subtract(location.x, location.y, location.z);
    }

    @NotNull
    public FineLocation toFineLocation() {
        return new FineLocation(worldName, x, y, z);
    }

    @NotNull
    public static FineBlockLocation fromFineLocation(@NotNull FineLocation location) {
        return Objects.requireNonNull(location, "location").toFineBlockLocation();
    }

    @NotNull
    public static FineBlockLocation fromLocation(@NotNull Location location) {
        Objects.requireNonNull(location, "location");
        return new FineBlockLocation(location.getWorld().getName(),
                location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }
}
