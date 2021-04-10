package controllers;

import javafx.scene.transform.Scale;
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
import org.jzy3d.plot3d.primitives.ScatterMultiColor;
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.rendering.canvas.Quality;

public class ChartController {

    public AWTChart getDemoChart(JavaFXChartFactory factory, String toolkit, Mapper mapper) {

        // Define range and precision for the function to plot
        Range xRange = new Range(CalculationData.getMinX(), CalculationData.getMaxX());
        Range yRange = new Range(CalculationData.getMinY(), CalculationData.getMaxY());
        int steps = 50;

        // Create the object to represent the function over the given range.
        final Shape surface = Builder.buildOrthonormal(new OrthonormalGrid(xRange, steps, yRange, steps), mapper);
        surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZmin(), surface.getBounds().getZmax(), new Color(1, 1, 1, 0.5f)));
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
        // Create scatter points
        for(Particle particle : CalculationData.getParticlesList()) {
            points[i] = particle.getPosition();
            i++;
        }
        // Create a drawable scatter with a colormap
        ScatterMultiColor scatter = new ScatterMultiColor(points, new ColorMapper( new ColorMapRainbow(), -1f, 1f ) );
        scatter.setWidth(4);
        chart.getScene().add(scatter);

        return chart;
    }
}
