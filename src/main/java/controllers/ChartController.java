package controllers;

import models.CalculationData;
import models.Particle;
import org.jzy3d.chart.AWTChart;
import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.javafx.JavaFXChartFactory;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.maths.Range;
import org.jzy3d.plot3d.builder.Builder;
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.rendering.canvas.Quality;
import java.util.stream.Collectors;

public class ChartController {

    private AWTChart chart;
    private Scatter scatter;

    public AWTChart getChart() {
        return chart;
    }

    public void redrawChart() {
        JavaFXChartFactory factory = new JavaFXChartFactory();
        String toolkit = "offscreen";
        Range xRange = new Range(CalculationData.getMinX(), CalculationData.getMaxX());
        Range yRange = new Range(CalculationData.getMinY(), CalculationData.getMaxY());
        int steps = 50;

        Shape surface = Builder.buildOrthonormal(
                new OrthonormalGrid(xRange, steps, yRange, steps),
                CalculationData.getFunctionFormula());
        setSurfaceProperties(surface);

        Quality quality = Quality.Intermediate;
        setQualityProperties(quality);

        chart = (AWTChart) factory.newChart(quality, toolkit);
        chart.getScene().getGraph().add(surface);
        redrawParticlesPositions();
    }

    private void setSurfaceProperties(Shape surface) {
        surface.setColorMapper(
                new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZmin(), surface.getBounds().getZmax(),
                new Color(1, 1, 1, 0.4f)));
        surface.setFaceDisplayed(true);
        surface.setWireframeDisplayed(false);
    }

    private void setQualityProperties(Quality quality) {
        quality.setSmoothPolygon(true);
        quality.setAnimated(true);
        quality.setAlphaActivated(true);
        quality.setAutoSwapBuffer(false);
        quality.setSmoothEdge(true);
        quality.setSmoothPoint(true);
        quality.setDepthActivated(false);
        quality.setPreserveViewportSize(true);
    }

    public void redrawParticlesPositions() {
        int size = CalculationData.getParticlesList().size();
        Coord3d[] points = new Coord3d[size];
        Color[] colors = new Color[size];
        Color globalBestColor = new Color(255, 0, 0);
        Color normalColor = new Color(0, 0, 255);

        int index = 0;
        for (Particle particle : CalculationData.getParticlesList().stream()
                .sorted((p1, p2) -> Float.compare(p2.getPosition().z, p1.getPosition().z)).collect(Collectors.toList())) {
            points[index] = particle.getPosition();
            colors[index] = normalColor;
            index++;
        }

        colors[0] = globalBestColor;

        chart.getScene().remove(scatter);
        scatter = new Scatter(points, colors);
        scatter.setWidth(5);
        chart.getScene().add(scatter);
    }
}
