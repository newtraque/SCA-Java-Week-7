package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ContactUs extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Inquiry");

        GridPane gridPane = createContactPane();
        addUIControls(gridPane);

        Scene scene = new Scene(gridPane, 800, 500);
        // Set the scene in primary stage
        primaryStage.setScene(scene);

        gridPane.setStyle("-fx-background-color: #d7f5aa;");


        primaryStage.show();
    }


    private GridPane createContactPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel3 = new Label("Contact Us");
        gridPane.add(headerLabel3, 0,0,2,1);
        GridPane.setHalignment(headerLabel3, HPos.CENTER);
        headerLabel3.setStyle("-fx-font: normal bold 25px 'serif' ");
        GridPane.setMargin(headerLabel3, new Insets(20, 0,20,0));

        // Add Email Label
        Label emailLabel = new Label("Email : ");
        gridPane.add(emailLabel, 0, 2);

        emailLabel.setStyle("-fx-font: normal bold 16px 'serif' ");

        // Add Email Text Field
        TextField emailField = new TextField();
        emailField.setPrefHeight(40);
        gridPane.add(emailField, 1, 2);

        // Add Message Label
        Label inquiryLabel = new Label("Message : ");
        gridPane.add(inquiryLabel, 0, 3);

        inquiryLabel.setStyle("-fx-font: normal bold 16px 'serif' ");


        // Add Inquiry Text Field
        TextField inquiryField = new TextField();
        inquiryField.setPrefHeight(100);
        gridPane.add(inquiryField, 1, 3);

        // Add Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setStyle("-fx-background-color: #309d06; -fx-text-fill: white;");

        var tooltip = new Tooltip("click to submit");
        Tooltip.install(submitButton, tooltip);

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(emailField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your email address");
                    return;
                }
                if(inquiryField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a message");
                    return;
                }
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
