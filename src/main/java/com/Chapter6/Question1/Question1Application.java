package com.Chapter6.Question1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Question1Application extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/StudentTableView.fxml"));
        loader.setControllerFactory(SpringApplication.run(Question1Application.class)::getBean);
        Pane pane = loader.load();
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Chapte 6 Assignment");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
