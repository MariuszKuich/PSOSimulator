package controllers;

import models.CalculationData;
import models.Particle;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.builder.Mapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParticlesController {

    private int particlesNumber;

    public void setParticlesNumber(int numberOfParticles) {
        particlesNumber = numberOfParticles;
    }

    public void initializeParticlesWithRandomLocations() {
        List<Particle> particlesList = new ArrayList<>();
        for(int i = 0 ; i < particlesNumber ; i++) {
            Particle particle = new Particle(getRandomPosition());
            setInitialVelocities(particle);
            updateGlobalOptimumIfNecessary(particle.getPosition());
            particlesList.add(particle);
        }
        CalculationData.setParticlesList(particlesList);
    }

    private Coord3d getRandomPosition() {
        double randomX = getRandomFromRange(CalculationData.getMinX(), CalculationData.getMaxX());
        double randomY = getRandomFromRange(CalculationData.getMinY(), CalculationData.getMaxY());
        double calculatedZ = calculateZCoord(randomX, randomY);

        return new Coord3d(randomX, randomY, calculatedZ);
    }

    private double getRandomFromRange(double minValue, double maxValue) {
        Random random = new Random();
        return minValue + (maxValue - minValue) * random.nextDouble();
    }

    private double calculateZCoord(double xCoord, double yCoord) {
        Mapper function = CalculationData.getFunctionFormula();
        return function.f(xCoord, yCoord);
    }

    private void setInitialVelocities(Particle particle) {
        particle.setVelocityX(getRandomVelocity(CalculationData.getMinX(), CalculationData.getMaxX()));
        particle.setVelocityY(getRandomVelocity(CalculationData.getMinY(), CalculationData.getMaxY()));
    }

    private double getRandomVelocity(int minCoord, int maxCoord) {
        return (Math.random() - 0.5) * (maxCoord - minCoord) * 2;
    }

    private void updateGlobalOptimumIfNecessary(Coord3d position) {
        if(CalculationData.getGlobalOptimumPosition() == null
                || position.z > CalculationData.getGlobalOptimumPosition().z) {
            CalculationData.setGlobalOptimumPosition(position);
        }
    }

    public void updateParticlesVelocitiesAndCoordinates() {
        for(Particle particle : CalculationData.getParticlesList()) {
            updateParticleVelocity(particle);
            updateParticleCoordinates(particle);
            updateGlobalOptimumIfNecessary(particle.getPosition());
        }
    }

    private void updateParticleVelocity(Particle particle) {
        particle.setVelocityX(calculateVelocityForCoord(particle.getVelocityX(), particle.getPosition().x,
                particle.getLocalOptimumPosition().x, CalculationData.getGlobalOptimumPosition().x));
        particle.setVelocityY(calculateVelocityForCoord(particle.getVelocityY(), particle.getPosition().y,
                particle.getLocalOptimumPosition().y, CalculationData.getGlobalOptimumPosition().y));
    }

    private double calculateVelocityForCoord(double particleVelocity, double particleCoord, double localOptimumCoord, double globalOptimumCoord) {
        double rl = getRandomFromRange(0, 1);
        double rg = getRandomFromRange(0, 1);
        return CalculationData.getInertia() * particleVelocity
                + CalculationData.getAspirationLocalOptimum() * rl * (localOptimumCoord - particleCoord)
                + CalculationData.getAspirationGlobalOptimum() * rg * (globalOptimumCoord - particleCoord);
    }

    private void updateParticleCoordinates(Particle particle) {
        Coord3d newPosition = new Coord3d();
        Coord3d currentPosition = particle.getPosition();
        newPosition.x = (float) (currentPosition.x + particle.getVelocityX());
        newPosition.y = (float) (currentPosition.y + particle.getVelocityY());
        newPosition.z = (float) calculateZCoord(newPosition.x, newPosition.y);

        updateLocalOptimumIfNecessary(particle, newPosition);

        particle.setPosition(newPosition);
    }

    private void updateLocalOptimumIfNecessary(Particle particle, Coord3d newPosition) {
        if(newPosition.z > particle.getLocalOptimumPosition().z) {
            particle.setLocalOptimumPosition(newPosition);
        }
    }
}
