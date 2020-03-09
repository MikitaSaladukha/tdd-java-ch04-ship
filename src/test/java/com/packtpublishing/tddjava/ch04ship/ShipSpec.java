package com.packtpublishing.tddjava.ch04ship;

import org.testng.annotations.*;

import static org.testng.Assert.*;

@Test
public class ShipSpec {
    private Ship ship;
    private Location location;
    private Planet planet;

    @BeforeMethod
    public void beforeTest() {
       // location = new Location(
       //         new Point(21, 13), Direction.NORTH);
        //ship = new Ship(location);

        Point max = new Point(50, 50);
        location = new Location(new Point(21, 13), Direction.NORTH);
        planet = new Planet(max);
        //ship = new Ship(location);
        ship = new Ship(location, planet);
    }

    public void whenInstantiatedThenLocationIsSet() {
       // Location location = new Location(
       //         new Point(21, 13), Direction.NORTH);
        //Ship ship = new Ship(location);
        assertEquals(ship.getLocation(), location);

    }

    public void givenNorthWhenMoveForwardThenYDecreases() {
        ship.moveForward();
        assertEquals(ship.getLocation().getPoint().getY(), 12);
    }
    public void givenEastWhenMoveForwardThenXIncreases() {
        ship.getLocation().setDirection(Direction.EAST);
        ship.moveForward();
        assertEquals(ship.getLocation().getPoint().getX(), 22);
    }

    public void givenWestWhenMoveForwardThenXDecrease() {
        ship.getLocation().setDirection(Direction.WEST);
        ship.moveForward();
        assertEquals(ship.getLocation().getPoint().getX(), 20);
    }

    public void givenSouthWhenMoveForwardThenYIncreases() {
        ship.getLocation().setDirection(Direction.SOUTH);
        ship.moveForward();
        assertEquals(ship.getLocation().getPoint().getY(), 14);
    }

    /////////////////
    public void givenNorthWhenMoveBackwardThenYIncrease() {
        ship.moveBackward();
        assertEquals(ship.getLocation().getPoint().getY(), 14);
    }
    public void givenEastWhenMoveBackwardThenXDecrease() {
        ship.getLocation().setDirection(Direction.EAST);
        ship.moveBackward();
        assertEquals(ship.getLocation().getPoint().getX(), 20);
    }

    public void givenWestWhenMoveBackwardThenXIncrease() {
        ship.getLocation().setDirection(Direction.WEST);
        ship.moveBackward();
        assertEquals(ship.getLocation().getPoint().getX(), 22);
    }

    public void givenSouthWhenMoveBackwardThenYDecrease() {
        ship.getLocation().setDirection(Direction.SOUTH);
        ship.moveBackward();
        assertEquals(ship.getLocation().getPoint().getY(), 12);
    }
////////////////////

    public void whenMoveForwardThenForward() {
        Location expected = location.copy();
        expected.forward();
        ship.moveForward();
        assertEquals(ship.getLocation(), expected);
    }

    public void whenTurnLeftThenLeft() {
        Location expected = location.copy();
        expected.turnLeft();
        ship.turnLeft();
        assertEquals(ship.getLocation(), expected);
    }

    public void whenTurnRightThenRight() {
        Location expected = location.copy();
        expected.turnRight();
        ship.turnRight();
        assertEquals(ship.getLocation(), expected);
    }

    public void whenReceiveCommandsFThenForward() {
        Location expected = location.copy();
        expected.forward();
        ship.receiveCommands("f");
        assertEquals(ship.getLocation(), expected);
    }

    public void whenReceiveCommandsThenAllAreExecuted() {
        Location expected = location.copy();
        expected.turnRight();
        expected.forward();
        expected.turnLeft();
        expected.backward();
        ship.receiveCommands("rflb");
        assertEquals(ship.getLocation(), expected);
    }

    public void whenInstantiatedThenPlanetIsStored() {
        //Point max = new Point(50, 50);
        ///Planet planet = new Planet(max);
        //ship = new Ship(location, planet);
        assertEquals(ship.getPlanet(), planet);
    }

    public void whenInstantiatedThenPlanetIsStoredMax() {
        //Point max = new Point(50, 50);
        ///Planet planet = new Planet(max);
        //ship = new Ship(location, planet);
        assertEquals(ship.getPlanet().getMax().getX(), 50);
    }

    public void overpassEastBoundary() {
        location.setDirection(Direction.EAST);
        location.getPoint().setX(planet.getMax().getX());
        ship.receiveCommands("f");
        assertEquals(location.getX(), 1);
    }

    public void overpassSouthBoundary() {
        location.setDirection(Direction.SOUTH);
        location.getPoint().setY(planet.getMax().getY());
        ship.receiveCommands("f");
        assertEquals(location.getY(), 1);
    }

}
