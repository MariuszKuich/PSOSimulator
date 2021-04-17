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
import org.jzy3d.plot3d.builder.Mapper;
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.rendering.canvas.Quality;
import java.util.stream.Collectors;

public class ChartController {

    public AWTChart getDemoChart(JavaFXChartFactory factory, String toolkit, Mapper mapper) {

        // Define range and precision for the function to plot
        Range xRange = new Range(CalculationData.getMinX(), CalculationData.getMaxX());
        Range yRange = new Range(CalculationData.getMinY(), CalculationData.getMaxY());
        int steps = 50;

        // Create the object to represent the function over the given range.
        final Shape surface = Builder.buildOrthonormal(new OrthonormalGrid(xRange, steps, yRange, steps), mapper);
        surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZmin(), surface.getBounds().getZmax(), new Color(1, 1, 1, 0.4f)));
        surface.setFaceDisplayed(true);
        surface.setWireframeDisplayed(false);

        // -------------------------------
        // Create a chart
        Quality quality = Quality.Intermediate;
        quality.setSmoothPolygon(true);
        quality.setAnimated(true);
        quality.setAlphaActivated(true);
        quality.setAutoSwapBuffer(false);
        quality.setSmoothEdge(true);
        quality.setSmoothPoint(true);
        quality.setDepthActivated(false);
        quality.setPreserveViewportSize(true);

        // let factory bind mouse and keyboard controllers to JavaFX node
        AWTChart chart = (AWTChart) factory.newChart(quality, toolkit);

        chart.getScene().getGraph().add(surface);

        int size = CalculationData.getParticlesList().size();
        int i = 0;
        Coord3d[] points = new Coord3d[size];
        Color[] colors = new Color[size];
        Color globalBestColor = new Color(255, 0, 0);
        Color normalColor = new Color(0, 0, 255);
        // Create scatter points
        for(Particle particle : CalculationData.getParticlesList().stream()
                .sorted((p1, p2) -> Float.compare(p2.getPosition().z, p1.getPosition().z)).collect(Collectors.toList())) {
            points[i] = particle.getPosition();
            colors[i] = normalColor;
            i++;
        }
        colors[0] = globalBestColor;
        // Create a drawable scatter with a colormap
        Scatter scatter = new Scatter(points, colors);
        scatter.setWidth(5);
        chart.getScene().add(scatter);

        return chart;
    }
}
