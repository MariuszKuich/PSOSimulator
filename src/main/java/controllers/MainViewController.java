package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import models.CalculationData;
import models.FunctionData;
import org.jzy3d.chart.AWTChart;
import org.jzy3d.javafx.JavaFXChartFactory;
import org.jzy3d.maths.Coord3d;
import repositories.FunctionRepository;

public class MainViewController {

   private FunctionRepository functionRepository = new FunctionRepository();

   private ChartController chartController = new ChartController();

   private ParticlesController particlesController = new ParticlesController();

    @FXML
    private ChoiceBox<String> cbFunction;

    @FXML
    private TextArea taFunctionFormula;

    @FXML
    private Spinner<Integer> spinnerNumberOfParticles;

    @FXML
    private Spinner<Integer> spinnerMinX;

    @FXML
    private Spinner<Integer> spinnerMaxX;

    @FXML
    private Spinner<Integer> spinnerMinY;

    @FXML
    private Spinner<Integer> spinnerMaxY;

    @FXML
    private Slider sliderSpeed;

    @FXML
    private Slider sliderInertia;

    @FXML
    private Slider sliderLocalOptimum;

    @FXML
    private Slider sliderGlobalOptimum;

    @FXML
    private Pane pnChart;

    public void initialize() {
        cbFunction.getItems().addAll(functionRepository.getFunctionsNamesSet());
        addSlidersEventListeners();
        setDefaultCalculationData();
        setDefaultChartData();
    }

    private void addSlidersEventListeners() {
        sliderSpeed.valueProperty().addListener((observable, oldValue, newValue) ->
                CalculationData.setSpeed(newValue.doubleValue())
        );
        sliderInertia.valueProperty().addListener((observable, oldValue, newValue) ->
                CalculationData.setInertia(newValue.doubleValue())
        );
        sliderLocalOptimum.valueProperty().addListener((observable, oldValue, newValue) ->
                CalculationData.setAspirationLocalOptimum(newValue.doubleValue())
        );
        sliderGlobalOptimum.valueProperty().addListener((observable, oldValue, newValue) ->
                CalculationData.setAspirationGlobalOptimum(newValue.doubleValue())
        );
    }

    private void setDefaultCalculationData() {
        CalculationData.setSpeed(sliderSpeed.getValue());
        CalculationData.setInertia(sliderInertia.getValue());
        CalculationData.setAspirationLocalOptimum(sliderLocalOptimum.getValue());
        CalculationData.setAspirationGlobalOptimum(sliderGlobalOptimum.getValue());
    }

    private void setDefaultChartData() {
        cbFunction.getSelectionModel().select(0);
        String firstCbFunctionElement = cbFunction.getItems().get(0);
        updateFunctionDataControls(firstCbFunctionElement);
        btnUpdateFunction_clicked(new ActionEvent());
    }

    private void updateFunctionDataControls(String functionName) {
        FunctionData function = functionRepository.getFunctionDataByFunctionName(functionName);

        taFunctionFormula.setText(function.getFormulaString());
        spinnerMinX.getValueFactory().setValue(function.getDefaultMinX());
        spinnerMaxX.getValueFactory().setValue(function.getDefaultMaxX());
        spinnerMinY.getValueFactory().setValue(function.getDefaultMinY());
        spinnerMaxY.getValueFactory().setValue(function.getDefaultMaxY());
    }

    private void redrawChart() {
        pnChart.getChildren().clear();
        JavaFXChartFactory factory = new JavaFXChartFactory();
        AWTChart chart  = chartController.getDemoChart(factory, "offscreen", CalculationData.getFunctionFormula());
        ImageView imageView = factory.bindImageView(chart);
        imageView.setFitHeight(500.0);
        imageView.setFitWidth(500.0);
        pnChart.getChildren().add(imageView);
    }

    @FXML
    void btnNextStep_clicked(ActionEvent event) {
        particlesController.updateParticlesVelocitiesAndCoordinates();
        redrawChart();
    }

    @FXML
    void btnRestart_clicked(ActionEvent event) {

    }

    @FXML
    void btnStartStop_clicked(ActionEvent event) {

    }

    @FXML
    void btnUpdateFunction_clicked(ActionEvent event) {
        variablesRangesGetValues();
        String selectedFunction = cbFunction.getSelectionModel().getSelectedItem();
        CalculationData.setFunctionFormula(functionRepository.getFunctionDataByFunctionName(selectedFunction).getFormulaMapper());
        particlesController.setParticlesNumber(spinnerNumberOfParticles.getValue());
        CalculationData.setGlobalOptimumPosition(null);
        particlesController.initializeParticlesWithRandomLocations();

        redrawChart();
    }

    private void variablesRangesGetValues() {
        CalculationData.setMinX(spinnerMinX.getValue());
        CalculationData.setMaxX(spinnerMaxX.getValue());
        CalculationData.setMinY(spinnerMinY.getValue());
        CalculationData.setMaxY(spinnerMaxY.getValue());
    }

    @FXML
    void cbFunction_selectedItemChanged(ActionEvent event) {
        String selectedKey = (String)((ChoiceBox)event.getSource()).getSelectionModel().getSelectedItem();
        updateFunctionDataControls(selectedKey);
    }
}