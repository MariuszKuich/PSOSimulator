package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import models.CalculationData;
import org.jzy3d.chart.AWTChart;
import org.jzy3d.javafx.JavaFXChartFactory;
import repositories.FunctionRepository;

public class MainViewController {

   private FunctionRepository functionRepository = new FunctionRepository();

   private ChartController chartController = new ChartController();

   private ParticlesController particlesController = new ParticlesController();

    @FXML
    private Button btnStartStop;

    @FXML
    private Button btnNextStep;

    @FXML
    private Button btnRestart;

    @FXML
    private ChoiceBox<String> cbFunction;

    @FXML
    private TextArea taFunctionFormula;

    @FXML
    private TextField tfVariablesRange;

    @FXML
    private Button btnUpdateFunction;

    @FXML
    private Spinner<Integer> spinnerNumberOfParticles;

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
        particlesController.setParticlesNumber(spinnerNumberOfParticles.getValue());
        CalculationData.setSpeed(sliderSpeed.getValue());
        CalculationData.setInertia(sliderInertia.getValue());
        CalculationData.setAspirationLocalOptimum(sliderLocalOptimum.getValue());
        CalculationData.setAspirationGlobalOptimum(sliderGlobalOptimum.getValue());
        
//        JavaFXChartFactory factory = new JavaFXChartFactory();
//        AWTChart chart  = chartController.getDemoChart(factory, "offscreen");
//        ImageView imageView = factory.bindImageView(chart);
//        imageView.setFitHeight(671.0);
//        imageView.setFitWidth(990.0);
//        pnChart.getChildren().add(imageView);

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

    }

    @FXML
    void cbFunction_selectedItemChanged(ActionEvent event) {
        String selectedKey = (String)((ChoiceBox)event.getSource()).getSelectionModel().getSelectedItem();
        taFunctionFormula.setText(functionRepository.getFormulaByFunctionName(selectedKey));
    }
}