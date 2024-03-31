package actors;

import abstractions.Location;

public abstract class Character {
    protected String name;
    protected Location location;

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
}

