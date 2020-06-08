package pers.ap.sample.homework;


import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;


class TextT{
    static Label textField=new Label();
     volatile static Text[] texts=new Text[4];
     static {
         textField.setWrapText(false);
         textField.setAlignment(Pos.CENTER);
         textField.setMaxWidth(80);
         textField.setMinWidth(80);

         for (int i=0;i<4;i++) {
             texts[i] = new Text("____");
             texts[i].setWrappingWidth(100);
//             texts[i].setFont();
             texts[i].setTextAlignment(TextAlignment.CENTER);
         }
     }
}
public class Player {
    //锚面板
    private AnchorPane ap = new AnchorPane();
    static Button bu_start=new Button("start");
    static Button bu_clear=new Button("clear");
    private static Map<Integer, String> obj=new HashMap<>();
    static int index=0;
    static int boundWayNUm=1;
    static Slider sl=new Slider();

    static {
        obj.put(0,"Original");
        obj.put(1,"Latchdown");
        obj.put(2,"Semaphore");
        obj.put(3,"ReentrantLock");
        obj.put(4,"Barrier");
        obj.put(5,"Phaser");

        boundWayNUm=obj.size();

//        sl.setOrientation(Orientation.VERTICAL);
        sl.setShowTickLabels(true);
        sl.setMinWidth(300);
        sl.setMaxWidth(300);
        sl.setMajorTickUnit((int)(sl.getMax())/boundWayNUm);
    }
    /**
     * 故事的开始
     *
     * @param stage 主舞台
     */
    Pane theStoryBegins(Stage stage) {


        /**
         * 根布局
         */
        HBox hB0=new HBox(20);
        hB0.setAlignment(Pos.CENTER);
        hB0.setPrefHeight(80);
        hB0.getChildren().addAll(TextT.textField,sl,bu_start,bu_clear);


//        VBox vB=new VBox();
//        vB.setAlignment(Pos.CENTER);
////        vB.setPrefHeight(180);
//        vB.getChildren().addAll(sl);


        HBox hB1=new HBox(50);
        hB1.setAlignment(Pos.CENTER);
        hB1.setPrefHeight(180);
        hB1.getChildren().addAll(TextT.texts[0],TextT.texts[1], TextT.texts[2]);

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

        sl.valueProperty().addListener(e->{
            double value=sl.getValue();
            index=(int)(value/(sl.getMax()/boundWayNUm));
            TextT.textField.setText(obj.get(new Integer(index)));
        });
        bu_start.setOnAction(e->{
            bu_start.setDisable(true);
            switch (index){
                case 0:   new WNMain().vm();
                            break;
                case 1:   new LatchMain().la();
                            break;
                case 2:   new SemaphoreMain().se();
                            break;
                case 3:    LockProcess.printStringWord();
                            break;
                case 4:     Barrier.ba();   break;

                case 5:    PhaserProcess.ph();   break;

                default: System.out.println("mistake");
            }
            System.out.println(index);
//           bu_start1.setDisable(true);
       });

        bu_clear.setOnAction(e->{
            for (int i=0;i<TextT.texts.length;i++)
                TextT.texts[i].setText("____");
            bu_start.setDisable(false);
        });

        return rootBP;
    }
}

