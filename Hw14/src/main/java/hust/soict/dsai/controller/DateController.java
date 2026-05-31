package hust.soict.dsai.controller;

import hust.soict.dsai.model.*;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class DateController {

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<String> formatBox;

    @FXML
    private ComboBox<Direction> directionBox;

    @FXML
    private ComboBox<TimeUnit> unitBox;

    @FXML
    private TextField amountField;

    @FXML
    private Button applyButton;

    @FXML
    private Label selectedDateLabel;

    @FXML
    private Label resultDateLabel;

    @FXML
    private Label errorLabel;

    private final DateModel model = new DateModel();

    @FXML
    public void initialize() {

        formatBox.getItems().addAll(
                "dd/MM/yyyy",
                "MM/dd/yyyy",
                "dd.MM.yyyy",
                "yyyy-MM-dd"
        );

        formatBox.setValue("dd/MM/yyyy");

        directionBox.getItems().addAll(Direction.values());
        directionBox.setValue(Direction.AFTER);

        unitBox.getItems().addAll(TimeUnit.values());
        unitBox.setValue(TimeUnit.DAYS);

        datePicker.valueProperty()
                .bindBidirectional(
                        model.selectedDateProperty());

        model.dateFormatProperty()
                .bind(
                        formatBox.valueProperty());

        selectedDateLabel.textProperty().bind(
                Bindings.createStringBinding(
                        model::getFormattedSelectedDate,
                        model.selectedDateProperty(),
                        model.dateFormatProperty()
                )
        );

        resultDateLabel.textProperty().bind(
                Bindings.createStringBinding(
                        model::getFormattedResultDate,
                        model.resultDateProperty(),
                        model.dateFormatProperty()
                )
        );

        applyButton.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> {

                            try {
                                Integer.parseInt(
                                        amountField.getText());
                                return false;
                            } catch(Exception e) {
                                return true;
                            }

                        },
                        amountField.textProperty()
                )
        );

    }

    @FXML
    private void handleApply() {

        try {

            int amount =
                    Integer.parseInt(
                            amountField.getText());

            model.calculate(
                    amount,
                    directionBox.getValue(),
                    unitBox.getValue());

            errorLabel.setText("");

        } catch(Exception e) {

            errorLabel.setText(
                    "Please enter a valid integer.");
        }
    }
}