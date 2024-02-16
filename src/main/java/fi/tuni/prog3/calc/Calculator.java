package fi.tuni.prog3.calc;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Calculator extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        stage.setTitle("Calculator");

        // Create a GridPane for the layout
        GridPane grid = new GridPane();
        //grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        // Labels for operands
        Label labelOp1 = new Label("First operand:");
        labelOp1.setId("labelOp1");

        Label labelOp2 = new Label("Second operand:");
        labelOp2.setId("labelOp2");

        // TextFields for operands
        TextField fieldOp1 = new TextField();
        fieldOp1.setId("fieldOp1");

        TextField fieldOp2 = new TextField();
        fieldOp2.setId("fieldOp2");

        // Buttons for operations
        Button btnAdd = new Button("Add");
        grid.add(btnAdd, 0, 2);
        btnAdd.setId("btnAdd");
        HBox hbBtn = new HBox(10);
        hbBtn.setPrefWidth(300);
        hbBtn.getChildren().add(btnAdd);

        Button btnSub = new Button("Subtract");
        grid.add(btnSub, 1, 2);
        btnSub.setId("btnSub");
        hbBtn.getChildren().add(btnSub);

        Button btnMul = new Button("Multiply");
        grid.add(btnMul, 2, 2);
        btnMul.setId("btnMul");
        hbBtn.getChildren().add(btnMul);

        Button btnDiv = new Button("Divide");
        grid.add(btnDiv, 3, 2);
        btnDiv.setId("btnDiv");
        hbBtn.getChildren().add(btnDiv);
        

        // Label for result
        Label labelRes = new Label("Result:");
        labelRes.setId("labelRes");

        // Label for displaying result
        Label fieldRes = new Label("");
        fieldRes.setId("fieldRes");
        fieldRes.setBackground(javafx.scene.layout.Background.EMPTY); // Set background to white

        // Add components to the grid
        grid.add(labelOp1, 0, 0);
        grid.add(fieldOp1, 1, 0);
        grid.add(labelOp2, 0, 1);
        grid.add(fieldOp2, 1, 1);
        grid.add(labelRes, 0, 3);
        grid.add(fieldRes, 1, 3);
        grid.add(hbBtn,0,2);

        // Set actions for the buttons
        btnAdd.setOnAction(e -> performOperation(fieldOp1, fieldOp2, fieldRes, "Add"));
        btnSub.setOnAction(e -> performOperation(fieldOp1, fieldOp2, fieldRes, "Subtract"));
        btnMul.setOnAction(e -> performOperation(fieldOp1, fieldOp2, fieldRes, "Multiply"));
        btnDiv.setOnAction(e -> performOperation(fieldOp1, fieldOp2, fieldRes, "Divide"));

        // Create a scene and set it to the stage
        Scene scene = new Scene(grid, 350, 275);
        stage.setScene(scene);

        // Show the stage
        stage.show();
    }

    private void performOperation(TextField fieldOp1, TextField fieldOp2, Label fieldRes, String operation) {
        try {
            double operand1 = Double.parseDouble(fieldOp1.getText());
            double operand2 = Double.parseDouble(fieldOp2.getText());
            double result = 0;

            switch (operation) {
                case "Add":
                    result = operand1 + operand2;
                    break;
                case "Subtract":
                    result = operand1 - operand2;
                    break;
                case "Multiply":
                    result = operand1 * operand2;
                    break;
                case "Divide":
                    result = operand1 / operand2;
                    break;
            }

            fieldRes.setText(String.valueOf(result));
        } catch (NumberFormatException | ArithmeticException ex) {
            fieldRes.setText("Error");
        }
    }
    
    public static void main(String[] args) {
        launch();
    }
   }
