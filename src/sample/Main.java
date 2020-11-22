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

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Registration Form");

        GridPane gridPane = createRegistrationFormPane();
        addUIControls(gridPane);

        Scene scene = new Scene(gridPane, 800, 500);
        // Set the scene in primary stage
        primaryStage.setScene(scene);
        
        gridPane.setStyle("-fx-background-color: #d7f5aa;");

        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
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
        Label headerLabel1 = new Label("Registration Form");
        headerLabel1.setStyle("-fx-font: normal bold 25px 'serif' ");
        gridPane.add(headerLabel1, 0,0,2,1);
        GridPane.setHalignment(headerLabel1, HPos.CENTER);
        GridPane.setMargin(headerLabel1, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("Full Name : ");
        nameLabel.setId("name-label");
        gridPane.add(nameLabel, 0,1);

        nameLabel.setStyle("-fx-font: normal bold 16px 'serif' ");


        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);


        // Add Email Label
        Label emailLabel = new Label("Email : ");
        emailLabel.setId("email");
        gridPane.add(emailLabel, 0, 2);

        emailLabel.setStyle("-fx-font: normal bold 16px 'serif' ");

        // Add Email Text Field
        TextField emailField = new TextField();
        emailField.setPrefHeight(40);
        gridPane.add(emailField, 1, 2);


        // Add Password Label
        Label passwordLabel = new Label("Password : ");
        passwordLabel.setId("password");
        gridPane.add(passwordLabel, 0, 3);

        passwordLabel.setStyle("-fx-font: normal bold 16px 'serif' ");

        // Add Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 3);

        // Add Submit Button
        Button submitButton = new Button("Sign up");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setStyle("-fx-background-color: #309d06; -fx-text-fill: white;");


        var tooltip = new Tooltip("Click to register");
        Tooltip.install(submitButton, tooltip);

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your name");
                    return;
                }
                if(emailField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your email id");
                    return;
                }
                if(passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a password");
                    return;
                }

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + nameField.getText());
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
