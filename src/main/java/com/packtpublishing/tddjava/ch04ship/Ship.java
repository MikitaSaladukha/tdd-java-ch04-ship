package com.packtpublishing.tddjava.ch04ship;

public class Ship {
    private final Location location;
    public Location getLocation() {
        return location;
    }
    //public Ship(Location location) {
    //    this.location = location;
    //}

    public boolean moveForward() {
        return location.forward(planet.getMax());
    }

    public boolean moveBackward() {
        return location.backward(planet.getMax());
    }
    public void turnLeft() {
        location.turnLeft();
    }

    public void turnRight() {
        location.turnRight();
    }

    public void receiveCommands(String commands) {
        for (char command : commands.toCharArray()) {
            switch(command) {
                case 'f':
                    moveForward();
                    break;
                case 'b':
                    moveBackward();
                    break;
                case 'l':
                    turnLeft();
                    break;
                case 'r':
                    turnRight();
                    break;
            }
        }
    }

    private Planet planet;
    public Planet getPlanet() {
        return planet;
    }

    public Ship(Location location, Planet planet) {
        this.location = location;
        this.planet = planet;
    }
}

