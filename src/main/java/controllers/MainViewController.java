package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import repositories.FunctionRepository;

public class MainViewController {

   private FunctionRepository functionRepository = new FunctionRepository();

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

    public void initialize() {
        cbFunction.getItems().addAll(functionRepository.getFunctionsNamesSet());
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