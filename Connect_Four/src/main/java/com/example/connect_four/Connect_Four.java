package com.example.connect_four;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Connect_Four extends Application {
    private Controller controller;


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameLayout.FXML"));
        GridPane rootGridPane = loader.load();

        controller = loader.getController();
        controller.createPlayground();

        MenuBar menuBar = creatMenu();
        menuBar.prefWidthProperty().bind(stage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);
        stage.setScene(scene);
        stage.setTitle("Connect Four");
        stage.setResizable(false);
        stage.show();
    }

    private MenuBar creatMenu() {

        Menu fileMenu = new Menu("File");

        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(actionEvent -> controller.resetGame());

        MenuItem restGame = new MenuItem("Rest Game");
        restGame.setOnAction(actionEvent -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

        MenuItem exitGame = new MenuItem("Exit Game");
        exitGame.setOnAction(actionEvent -> exitGame());

        fileMenu.getItems().addAll(newGame, restGame, separatorMenuItem, exitGame);

        Menu helpMenu = new Menu("Help");

        MenuItem aboutGame = new MenuItem("About Connect 4");
        aboutGame.setOnAction(actionEvent -> aboutGame());

        SeparatorMenuItem separator = new SeparatorMenuItem();

        MenuItem aboutMe = new MenuItem("About Developer");
        aboutMe.setOnAction(actionEvent -> aboutDeveloper());

        helpMenu.getItems().addAll(aboutGame, separator, aboutMe);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;

    }

    private void aboutDeveloper() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Developer");
        alert.setHeaderText("Ashu Sah");
        alert.setContentText("I love to play around with code and create games.\n"+
                "connect 4 is one of them. in free time \n"+
                "I like to spend time with nears and dears");
        alert.show();
    }

    private void aboutGame() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect 4 Game");
        alert.setHeaderText("How To Play?");
        alert.setContentText("Connect Four is a two-player connection game in which the\n" +
                "players first choose a color and then take turns dropping\n" +
                "colored discs from the top into a seven-column, six-row\n "+
                "vertically suspended grid. The pieces fall straight down,\n " +
                "occupying the next available space within the column.The\n " +
                "objective of the game is to be the first to form a horizontal\n" +
                ",vertical, or diagonal line of four of one's own discs.\n " +
                "Connect Four is a solved game. The first player can always\n" +
                "win by playing the right moves.");
        alert.show();

    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}