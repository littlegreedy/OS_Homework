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
    static TextField[] inpuTextField= {new TextField(),new TextField(),new TextField()};
    static String[] getStrings=new String[3];
     volatile static Text[] texts=new Text[4];
     static {
         textField.setWrapText(false);
         textField.setAlignment(Pos.CENTER);
         textField.setMaxWidth(80);
         textField.setMinWidth(80);

         for(int i=0;i<3;i++){
             inpuTextField[i].setPrefSize(150, 50);
         }

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
        hB0.setPrefHeight(120);
        hB0.getChildren().addAll(TextT.inpuTextField[0],TextT.inpuTextField[1],TextT.inpuTextField[2]);

        HBox hB1=new HBox(20);
        hB1.setAlignment(Pos.CENTER);
        hB1.setPrefHeight(80);
        hB1.getChildren().addAll(TextT.textField,sl,bu_start,bu_clear);


//        VBox vB=new VBox();
//        vB.setAlignment(Pos.CENTER);
////        vB.setPrefHeight(180);
//        vB.getChildren().addAll(sl);


        HBox hB2=new HBox(50);
        hB2.setAlignment(Pos.CENTER);
        hB2.setPrefHeight(140);
        hB2.getChildren().addAll(TextT.texts[0],TextT.texts[1], TextT.texts[2]);

        HBox hB3=new HBox();
        hB3.setAlignment(Pos.CENTER);
        hB3.setPrefHeight(140);
        hB3.getChildren().add(TextT.texts[3]);


        //把输出结果放到另一个面板中
        BorderPane outputBP=new BorderPane();
        outputBP.setCenter(hB2);
        outputBP.setBottom(hB3);

        BorderPane rootBP = new BorderPane();
        rootBP.setTop(hB0);
        rootBP.setCenter(hB1);
        rootBP.setBottom(outputBP);

        rootBP.setBackground(new Background(new BackgroundFill(Color.color(0.5, 0.5, 0.5, 0.1),
                new CornerRadii(0.2), null)));//Color.valueOf("#696961")

        sl.valueProperty().addListener(e->{
            double value=sl.getValue();
            index=(int)(value/(sl.getMax()/boundWayNUm));
            TextT.textField.setText(obj.get(new Integer(index)));
        });
        bu_start.setOnAction(e->{
            bu_start.setDisable(true);

            //读取文本框内容
            for(int i=0;i<TextT.inpuTextField.length;i++) {
                obj.put(i+6, TextT.inpuTextField[i].getText());
                TextT.getStrings[i]=obj.get(new Integer(i+6));
//            	TextT.getStrings[i]=TextT.inpuTextField[i].getText();
                TextT.inpuTextField[i].setEditable(false);
            }

            switch (index){
                case 0:   new WNMain().vm(TextT.getStrings);
                            break;
                case 1:   new LatchMain().la(TextT.getStrings);
                            break;
                case 2:   new SemaphoreMain().se(TextT.getStrings);
                            break;
                case 3:    LockProcess.printStringWord(TextT.getStrings);
                            break;
                case 4:     Barrier.ba(TextT.getStrings);   break;

                case 5:    PhaserProcess.ph(TextT.getStrings);   break;

                default: System.out.println("mistake");
            }
            System.out.println(index);
//           bu_start1.setDisable(true);
       });

        bu_clear.setOnAction(e->{

            for(int i=0;i<TextT.inpuTextField.length;i++) {
                TextT.inpuTextField[i].setText("");
                TextT.inpuTextField[i].setEditable(true);
            }

            for (int i=0;i<TextT.texts.length;i++)
                TextT.texts[i].setText("____");
            bu_start.setDisable(false);
        });

        return rootBP;
    }
}

