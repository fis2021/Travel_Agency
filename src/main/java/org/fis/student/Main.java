package org.fis.student;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.fis.student.services.AdminTripService;
import org.fis.student.services.CustomerBookingService;
import org.fis.student.services.FileSystemService;
import org.fis.student.services.UserService;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        UserService.initDatabase();
        AdminTripService.initDatabase();
        CustomerBookingService.initDatabase();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 460));
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
