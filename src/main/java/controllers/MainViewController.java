package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import models.CalculationData;
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
        String defaultFunctionName = functionRepository.getFunctionsNamesSet().iterator().next();
        cbFunction.setValue(defaultFunctionName);
        taFunctionFormula.setText(functionRepository.getFormulaByFunctionName(defaultFunctionName));
        btnUpdateFunction_clicked(new ActionEvent());
    }

    @FXML
    void btnNextStep_clicked(ActionEvent event) {

    }

    @FXML
    void btnRestart_clicked(ActionEvent event) {

    }

    @FXML
    void btnStartStop_clicked(ActionEvent event) {

    }

    @FXML
    void btnUpdateFunction_clicked(ActionEvent event) {
        particlesController.setParticlesNumber(spinnerNumberOfParticles.getValue());
        variablesRangesGetValues();
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
        taFunctionFormula.setText(functionRepository.getFormulaByFunctionName(selectedKey));
    }
}