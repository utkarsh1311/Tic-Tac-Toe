package tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class TicTacToeApplication extends Application {
 
    private boolean xTurn;
    private Button[][] buttons;
    private Label turn;
    private boolean finish;
 
    public TicTacToeApplication() {
        buttons = new Button[3][3];
        xTurn = true;
        turn = new Label("Turn: X");
        turn.setFont(new Font("Monospace", 40));
        finish = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = makeButton();
            }
        }
    }
 
    public Button makeButton() {
        Button button = new Button(" ");
        button.setPrefHeight(90);
        button.setPrefWidth(90);
        button.setFont(new Font("Monospace", 40));
 
        button.setOnAction(event -> {
            if (finish)
                return;
            if (!button.getText().equals(" ")) {
                return;
            }
 
            if (xTurn) {
                button.setText("X");
                xTurn = false;
                turn.setText("Turn: O");
            } else {
                button.setText("O");
                xTurn = true;
                turn.setText("Turn: X");
            }
 
            if (finished() || gameEnd()) {
                turn.setText("The end!");
                finish = true;
            }
        });
        return button;
    }
 
    public boolean gameEnd() {
        return (!buttons[0][0].getText().equals(" ") && !buttons[0][1].getText().equals(" ")
                && !buttons[0][2].getText().equals(" ") && !buttons[1][0].getText().equals(" ")
                && !buttons[1][1].getText().equals(" ") && !buttons[1][2].getText().equals(" ")
                && !buttons[2][0].getText().equals(" ") && !buttons[2][1].getText().equals(" ")
                && !buttons[2][2].getText().equals(" "));
    }
 
    public boolean finished() {
        // testing row
        if (!buttons[0][0].getText().equals(" ")) {
            if (buttons[0][0].getText().equals(buttons[0][1].getText())
                    && buttons[0][0].getText().equals(buttons[0][2].getText())) {
                return true;
            }
        }
 
        // testing row
        if (!buttons[1][0].getText().equals(" ")) {
            if (buttons[1][0].getText().equals(buttons[1][1].getText())
                    && buttons[1][0].getText().equals(buttons[1][2].getText())) {
                return true;
            }
        }
 
        // testing row
        if (!buttons[2][0].getText().equals(" ")) {
            if (buttons[2][0].getText().equals(buttons[2][1].getText())
                    && buttons[2][0].getText().equals(buttons[2][2].getText())) {
                return true;
            }
        }
 
        // test columns
        if (!buttons[0][0].getText().equals(" ")) {
            if (buttons[0][0].getText().equals(buttons[1][0].getText())
                    && buttons[0][0].getText().equals(buttons[2][0].getText())) {
                return true;
            }
        }
 
        // testing columns
        if (!buttons[0][1].getText().equals(" ")) {
            if (buttons[0][1].getText().equals(buttons[1][1].getText())
                    && buttons[0][1].getText().equals(buttons[2][1].getText())) {
                return true;
            }
        }
 
        // testing columns
        if (!buttons[0][2].getText().equals(" ")) {
            if (buttons[0][2].getText().equals(buttons[1][2].getText())
                    && buttons[0][2].getText().equals(buttons[2][2].getText())) {
                return true;
            }
        }
 
        // testing diagonals
        if (!buttons[0][0].getText().equals(" ")) {
            if (buttons[0][0].getText().equals(buttons[1][1].getText())
                    && buttons[0][0].getText().equals(buttons[2][2].getText())) {
                return true;
            }
        }
 
        // testing diagonal
        if (!buttons[0][2].getText().equals(" ")) {
            if (buttons[0][2].getText().equals(buttons[1][1].getText())
                    && buttons[0][2].getText().equals(buttons[2][0].getText())) {
                return true;
            }
        }
        return false;
    }
 
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));
 
        layout.setTop(turn);
        GridPane board = new GridPane();
        board.setHgap(10);
        board.setVgap(10);
        board.setPrefSize(300, 300);
        layout.setCenter(board);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.add(buttons[i][j], i, j);
            }
        }
 
        Scene scene = new Scene(layout);
        stage.setTitle("Tic tac toe");
        stage.setScene(scene);
        stage.show();
 
    }
 
    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
 
}