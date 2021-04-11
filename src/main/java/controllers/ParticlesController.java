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
            updateGlobalOptimumIfNecessary(particle.localOptimumPosition());
            particlesList.add(particle);
        }
        CalculationData.setParticlesList(particlesList);
    }

    private void setInitialVelocities(Particle particle) {
        particle.setVelocityX(getRandomVelocity(CalculationData.getMinX(), CalculationData.getMaxX()));
        particle.setVelocityY(getRandomVelocity(CalculationData.getMinY(), CalculationData.getMaxY()));
    }

    private double getRandomVelocity(int minCoord, int maxCoord) {
        return (Math.random() - 0.5) * (maxCoord - minCoord) * 2;
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

    private void updateGlobalOptimumIfNecessary(Coord3d localOptimum) {
        if(CalculationData.getGlobalOptimumPosition() == null
                || localOptimum.z > CalculationData.getGlobalOptimumPosition().z) {
            CalculationData.setGlobalOptimumPosition(localOptimum);
        }
    }
}
