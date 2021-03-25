package models;

import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.builder.Mapper;

public abstract class CalculationData {

    private static Mapper functionFormula;

    private static double inertia;

    private static double aspirationLocalOptimum;

    private static double aspirationGlobalOptimum;

    private static Coord3d globalOptimumPosition;

    private static double localRandom;

    private static double globalRandom;

    private static int minX;

    private static int maxX;

    private static int minY;

    private static int maxY;

    private static double speed;

    public static Mapper getFunctionFormula() {
        return functionFormula;
    }

    public static void setFunctionFormula(Mapper functionFormula) {
        CalculationData.functionFormula = functionFormula;
    }

    public static double getInertia() {
        return inertia;
    }

    public static void setInertia(double inertia) {
        CalculationData.inertia = inertia;
    }

    public static double getAspirationLocalOptimum() {
        return aspirationLocalOptimum;
    }

    public static void setAspirationLocalOptimum(double aspirationLocalOptimum) {
        CalculationData.aspirationLocalOptimum = aspirationLocalOptimum;
    }

    public static double getAspirationGlobalOptimum() {
        return aspirationGlobalOptimum;
    }

    public static void setAspirationGlobalOptimum(double aspirationGlobalOptimum) {
        CalculationData.aspirationGlobalOptimum = aspirationGlobalOptimum;
    }

    public static double aspirationGlobalOptimum() {
        return aspirationGlobalOptimum;
    }

    public static void aspirationGlobalOptimum(double aspirationGlobalOptimum) {
        CalculationData.aspirationGlobalOptimum = aspirationGlobalOptimum;
    }

    public static Coord3d getGlobalOptimumPosition() {
        return globalOptimumPosition;
    }

    public static void setGlobalOptimumPosition(Coord3d globalOptimumPosition) {
        CalculationData.globalOptimumPosition = globalOptimumPosition;
    }

    public static double getLocalRandom() {
        return localRandom;
    }

    public static void setLocalRandom(double localRandom) {
        CalculationData.localRandom = localRandom;
    }

    public static double getGlobalRandom() {
        return globalRandom;
    }

    public static void setGlobalRandom(double globalRandom) {
        CalculationData.globalRandom = globalRandom;
    }

    public static int getMinX() {
        return minX;
    }

    public static void setMinX(int minX) {
        CalculationData.minX = minX;
    }

    public static int getMaxX() {
        return maxX;
    }

    public static void setMaxX(int maxX) {
        CalculationData.maxX = maxX;
    }

    public static int getMinY() {
        return minY;
    }

    public static void setMinY(int minY) {
        CalculationData.minY = minY;
    }

    public static int getMaxY() {
        return maxY;
    }

    public static void setMaxY(int maxY) {
        CalculationData.maxY = maxY;
    }

    public static double getSpeed() {
        return speed;
    }

    public static void setSpeed(double speed) {
        CalculationData.speed = speed;
    }
}
