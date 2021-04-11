package models;

import org.jzy3d.maths.Coord3d;

public class Particle {

    private double velocityX;

    private double velocityY;

    private Coord3d position;

    private Coord3d localOptimumPosition;

    public Particle(Coord3d position) {
        velocityX = 0;
        velocityY = 0;
        this.position = position;
        localOptimumPosition = position;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
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
