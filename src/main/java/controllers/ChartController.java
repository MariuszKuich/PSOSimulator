package controllers;

import javafx.scene.transform.Scale;
import org.jzy3d.chart.AWTChart;
import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.javafx.JavaFXChartFactory;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.maths.Range;
import org.jzy3d.plot3d.builder.Builder;
import org.jzy3d.plot3d.builder.Mapper;
import org.jzy3d.plot3d.primitives.ScatterMultiColor;
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.rendering.canvas.Quality;

public class ChartController {

    public AWTChart getDemoChart(JavaFXChartFactory factory, String toolkit, Mapper mapper) {

        // Define range and precision for the function to plot
        Range range = new Range(-3, 3);
        int steps = 50;

        // Create the object to represent the function over the given range.
        final Shape surface = Builder.buildOrthonormal(mapper, range, steps);
        surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZmin(), surface.getBounds().getZmax(), new Color(1, 1, 1, .5f)));
        surface.setFaceDisplayed(true);
        surface.setWireframeDisplayed(false);

        // -------------------------------
        // Create a chart
        Quality quality = Quality.Fastest;
        quality.setSmoothPolygon(false);
        quality.setAnimated(false);
        quality.setAlphaActivated(false);
        quality.setAutoSwapBuffer(true);
        quality.setSmoothEdge(false);
        quality.setSmoothPoint(false);

        // let factory bind mouse and keyboard controllers to JavaFX node
        AWTChart chart = (AWTChart) factory.newChart(quality, toolkit);

        chart.getScene().getGraph().add(surface);

//        int size = 1000;
//        float x;
//        float y;
//        float z;
//        Coord3d[] points = new Coord3d[size];
//
//        // Create scatter points
//        for(int i=0; i<size; i++){
//
//
//            x = (float) (-2.5 + Math.random() * (5));
//            y = (float) (-2.5 + Math.random() * (5));
//            z = (float) (-2.5 + Math.random() * (5));
//            points[i] = new Coord3d(x, y, z);
//        }
//
//        // Create a drawable scatter with a colormap
//        ScatterMultiColor scatter = new ScatterMultiColor( points, new ColorMapper( new ColorMapRainbow(), -0.5f, 0.5f ) );
//        scatter.setWidth(2);
//        chart.getScene().add(scatter);

        return chart;
    }
}
