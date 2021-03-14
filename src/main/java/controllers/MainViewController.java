package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import java.util.HashMap;
import java.util.Map;

public class MainViewController {

    private Map<String, String> testMap = new HashMap<>();

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

    public void initialize() {
        testMap.put("Sphere function", "-(x * x + y * y)");
        testMap.put("Himmelblau function", "-(Math.pow(x * x + y - 11, 2) + Math.pow(x + y * y - 7, 2))");
        testMap.put("Beale function", "-(Math.pow(1.5 - x + x * y, 2) + Math.pow(2.25 - x + x * y * y, 2) + Math.pow(2.625 - x + x * y * y * y, 2))");

        cbFunction.getItems().addAll(testMap.keySet());
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
    void cbFunction_selectedItemChanged(ActionEvent event) {
        String selectedKey = (String)((ChoiceBox)event.getSource()).getSelectionModel().getSelectedItem();
        taFunctionFormula.setText(testMap.get(selectedKey));
    }

}