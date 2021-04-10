package models;

import org.jzy3d.maths.Coord3d;

public class Particle {

    private double velocity;

    private Coord3d position;

    private Coord3d localOptimumPosition;

    public Particle(Coord3d position) {
        velocity = 0;
        this.position = position;
        localOptimumPosition = position;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public Coord3d getPosition() {
        return position;
    }

    public void setPosition(Coord3d position) {
        this.position = position;
    }

    public Coord3d localOptimumPosition() {
        return localOptimumPosition;
    }

    public void localOptimumPosition(Coord3d localOptimumPosition) {
        this.localOptimumPosition = localOptimumPosition;
    }
}
