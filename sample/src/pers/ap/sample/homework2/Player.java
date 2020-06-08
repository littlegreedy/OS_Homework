package pers.ap.sample.homework2;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


class TextT{
     static Text[] texts=new Text[4];
     static {
         for (int i=0;i<4;i++) {
             texts[i] = new Text(i + " ");
             texts[i].setWrappingWidth(100);
             texts[i].setTextAlignment(TextAlignment.CENTER);
         }
     }
}

public class Player {
    //锚面板
    private AnchorPane ap = new AnchorPane();
    static Button bu_start1=new Button("start1");
    static Button bu_start2=new Button("start2");
    static Button bu_start3=new Button("star3");

    /**
     * 故事的开始
     *
     * @param stage 主舞台
     */
    Pane theStoryBegins(Stage stage) {
        /**
         * 根布局
         */
        HBox hB0=new HBox();
        hB0.setAlignment(Pos.CENTER);
        hB0.setPrefHeight(80);
        hB0.getChildren().addAll(bu_start1,bu_start2,bu_start3);

        HBox hB1=new HBox(50);
        hB1.setAlignment(Pos.CENTER);
        hB1.setPrefHeight(180);
        hB1.getChildren().addAll(TextT.texts[0], TextT.texts[1], TextT.texts[2]);

        HBox hB2=new HBox();
        hB2.setAlignment(Pos.CENTER);
        hB2.setPrefHeight(180);
        hB2.getChildren().add(TextT.texts[3]);

        BorderPane rootBP = new BorderPane();
        rootBP.setTop(hB0);
        rootBP.setCenter(hB1);
        rootBP.setBottom(hB2);
        rootBP.setBackground(new Background(new BackgroundFill(Color.color(0.5, 0.5, 0.5, 0.1),
                new CornerRadii(0.2), null)));//Color.valueOf("#696961")


       bu_start1.setOnAction(e->{
//           bu_start1.setDisable(true);
           for (int i = 0; i< TextT.texts.length; i++)
               TextT.texts[i].setText(" ");
           WNMain wnMain = new WNMain();
           wnMain.vm();
//           bu_start1.setDisable(true);
       });

        bu_start2.setOnAction(e->{
//            bu_start2.setDisable(true);
            for (Text tt: TextT.texts)
                tt.setText(" ");
            LatchMain latchMain = new LatchMain();
            latchMain.la();

        });


       bu_start3.setOnAction(e->{
//           bu_start3.setDisable(true);
           for (int i = 0; i< TextT.texts.length; i++)
               TextT.texts[i].setText(" ");
            SemaphoreMain semaphoreMain = new SemaphoreMain();
            semaphoreMain.se();

        });

        return rootBP;
    }
}

