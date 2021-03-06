package org.fis.student.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.fis.student.exceptions.DestinationAndDateUsedException;
import org.fis.student.exceptions.EmptyTextfieldsException;
import org.fis.student.services.AdminTripService;

import java.awt.*;

public class AddTripController {

    @FXML
    private TextField destinationField;
    @FXML
    private TextField departure_dateField;
    @FXML
    private TextField return_dateField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField number_of_free_spotsField;
    @FXML
    private Text add_tripMessage;

    @FXML
    public void handleAddTripAction() {
        try {
            AdminTripService.addTrip(destinationField.getText(), departure_dateField.getText(), return_dateField.getText(), descriptionField.getText(), priceField.getText(), number_of_free_spotsField.getText());
            add_tripMessage.setText("Trip added successfully !");
        } catch (EmptyTextfieldsException e) {
            add_tripMessage.setText(e.getMessage());
        } catch (DestinationAndDateUsedException e) {
            add_tripMessage.setText(e.getMessage());
        }
    }

    @FXML
    public void goBackToTripPageAction(javafx.event.ActionEvent addTrip) throws Exception{
        Parent adminTripPageInterface = FXMLLoader.load(getClass().getClassLoader().getResource("admin_trip_page.fxml"));
        Stage window = (Stage) ((Node) addTrip.getSource()).getScene().getWindow();
        window.setTitle("Trips");
        window.setScene(new Scene(adminTripPageInterface, 600, 460));
        window.show();
    }
}
