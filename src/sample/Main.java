package sample;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public  class Main extends Application {

    Stage window;
    public Pane root;
    Scene scene;
    Soldier soldier;

    Captain captain;

    General general;

    public static String style;

    ImageView imageView;
    ImageView barrack;
    ImageView barrackfon;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Хутора");
        Program.main=this;
        Program.MainWindow=window;
        window = primaryStage;
        Image background = new Image("фон.png",4000,4000,true,true);

        imageView = new ImageView(background);

        Image barracks = new Image("Barrack.png",450,454,true,true);

        barrack = new ImageView(barracks);
        barrack.setY(600);
        barrack.setX(600);
        Image fon = new Image("background.jpg",500,500,true,true);
        barrackfon = new ImageView(fon);
        barrackfon.setX(600);
        barrackfon.setY(550);
        /*Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.ORANGE);
        rectangle.setWidth(500);
        rectangle.setHeight(500);
        rectangle.setY(550);
        rectangle.setX(600);*/

        root = new Pane();
        root.setMinWidth(4000);
        root.setMinHeight(4000);

        ScrollPane scrollPane = new ScrollPane(root);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToWidth(true);

        root.getChildren().addAll(imageView,barrackfon,barrack);

        root.setId("pane");
        scene = new Scene(scrollPane,1080, 950);


        style = getClass().getResource("style.css").toExternalForm();
       scene.getStylesheets().add(style);



        soldier = (new Soldier("Vovanchik",false,111));
        Program.soldiers.add(soldier);
        Random random = new Random();
        soldier.sold.setX(random.nextInt(1080));
        soldier.sold.setY(random.nextInt(700));
        soldier.Name.setLayoutX(soldier.sold.getX());
        soldier.Name.setLayoutY(soldier.sold.getY());
        soldier.ellipse.setCenterX(soldier.sold.getX()+36);
        soldier.ellipse.setCenterY(soldier.sold.getY()+75);
        soldier.Powerfull.setLayoutY(soldier.sold.getY()+80);
        soldier.Powerfull.setLayoutX(soldier.sold.getX()+40);

        captain = (new Captain("Yurka",false,333));
        Program.soldiers.add(captain);
        captain.sold.setX(random.nextInt(1080));
        captain.sold.setY(random.nextInt(700));
        captain.Name.setLayoutX(captain.sold.getX());
        captain.Name.setLayoutY(captain.sold.getY());
        captain.ellipse.setCenterX(captain.sold.getX()+36);
        captain.ellipse.setCenterY(captain.sold.getY()+75);


        general = (new General("Ihor",false,444));
        Program.soldiers.add(general);
        general.sold.setX(random.nextInt(1080));
        general.sold.setY(random.nextInt(700));
        general.Name.setLayoutY(general.sold.getY());
        general.Name.setLayoutX(general.sold.getX());
        general.ellipse.setCenterX(general.sold.getX()+36);
        general.ellipse.setCenterY(general.sold.getY()+75);

        scene.setOnKeyPressed(new KeyPressedHandler());
        scene.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){

            }
        });

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                for (Soldier s : Program.soldiers) {
                    s.training();
                    // s.port(iv5.getX(), iv5.getY());
                    /*if (iv6.getX() < 8000 ){
                        iv6.setX(iv6.getX()+1);
                    }else {iv6.setX(20);}
                    if (iv61.getX() < 8000 ){
                        iv61.setX(iv61.getX()+1);
                    }else {iv61.setX(20);}*/

//                    if (r.heroee.getX() > iv6.getX() && r.heroee.getX() < (iv6.getX() + 900)){
//                        r.setHp(r.getHp()-100);
//                    }
                    if (s.isActive == false) {

                        if (s.getTimeA() > 0)
                            s.move(s.getWay());
                        else {
                            int min = 1;
                            int max = 4;
                            int diffD = max - min;
                            Random random = new Random();
                            int way = random.nextInt(diffD + 1);
                            way += min;
                            s.setWay(way);

                            double min1 = 0;
                            double max1 = 4;
                            double timec = ThreadLocalRandom.current().nextDouble(min1, max1);
                            s.setTimeA(timec);
                        }
                    }
                }
            }
        };


        timer.start();

       // group = new Group();

        window.setResizable(true);
        window.setScene(scene);
        window.show();
    }



  private class KeyPressedHandler implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent event) {
            if (event.getCode()== KeyCode.INSERT){
                CreateWindow.display("Вікно створення");
            }

            if (event.getCode()==KeyCode.ESCAPE){

                Program.ClearChoosed();
            }
            if (event.getCode()==KeyCode.DELETE){
                Program.delete();
            }
            if (event.getCode().equals(KeyCode.W)) {
                for( Soldier r :Program.soldiers)
                    r.Up();
            }
            if (event.getCode().equals(KeyCode.D)) {
                for( Soldier r :Program.soldiers)
                    r.Right();
            }
            if (event.getCode().equals(KeyCode.S)) {
                for( Soldier r :Program.soldiers)
                    r.Down();
            }
            if (event.getCode().equals(KeyCode.A)) {
                for( Soldier r :Program.soldiers)
                    r.Left();
            }
            if (event.getCode().equals(KeyCode.T)){
                    AnimationTimer timer1 = new AnimationTimer() {
                        @Override
                        public void handle(long now) {
                            for ( Soldier s: Program.soldiers){
                                if(s.isActive= true){
                                    s.alert();
                                }
                            }
                        }
                    };
                    timer1.start();
            }
           /* if (event.getCode().equals(KeyCode.UP)){
                    double win = Main.root.getLayoutY() +20;
                    Main.root.setLayoutY(win);
            }
            if (event.getCode().equals(KeyCode.DOWN)){
                double win = Main.root.getLayoutY() -20;
                Main.root.setLayoutY(win);
            }
            if (event.getCode().equals(KeyCode.LEFT)){
                double win = Main.root.getLayoutX() -20;
                Main.root.setLayoutX(win);
            }
            if (event.getCode().equals(KeyCode.RIGHT)){
                double win = Main.root.getLayoutX() +20;
                Main.root.setLayoutX(win);
            }*/
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
