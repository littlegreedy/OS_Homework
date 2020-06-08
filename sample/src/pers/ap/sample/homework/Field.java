package pers.ap.sample.homework;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Field extends Application {

    //屏幕宽长
    private final int PLAYERWIDTH = 600;
    private final int PLAYERHEIGHT =500;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Scene scene = new Scene(new Player().theStoryBegins(primaryStage), PLAYERWIDTH, PLAYERHEIGHT);
        primaryStage.setScene(scene);

        //场景透明
        scene.setFill(Color.TRANSPARENT);
        //css引入
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.getIcons().add(new Image("https://cdn.jsdelivr.net/gh/littlegreedy/littlegreedy.github.io@v1.30/img/head.jpg"));
        primaryStage.setTitle("hibernate");
        primaryStage.setOnCloseRequest(event -> {
            primaryStage.setIconified(true);
        });
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
