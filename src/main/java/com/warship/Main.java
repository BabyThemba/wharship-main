package com.warship;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
       String style = getClass().getResource("/style.css").toExternalForm();
        Label over = new Label();

        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(style);

        //Circle enemy = createEnemy(scene);
        int X=0;
        int Y=1;
        Label score = new Label("SCORE:");
        score.setLayoutX(0);
        score.setLayoutY(0);

        Label scoredis = new Label();
        scoredis.setLayoutY(0);
        scoredis.setLayoutX(40);


        ImageView ship = createShip(scene);
        ship.setX(750);
        ship.setY(200);

        ImageView cloud = Clouds(scene);
        cloud.setX(50);
        cloud.setY(0);


        ImageView cloud2 = Clouds2(scene);
        cloud2.setX(150);
        cloud2.setY(50+10);


        ImageView cloud3 = Clouds3(scene);
        cloud3.setX(250);
        cloud3.setY(200);



        ImageView cloud4 = Clouds(scene);
        cloud4.setX(0);
        cloud4.setY(200+10);

        //Dsplaying coins

        ImageView coin1 = coin(scene);
        coin1.setX(100);
        coin1.setY(200);

        ImageView coin2 = coin(scene);
        coin2.setX(50);
        coin2.setY(0);

        ImageView coin3 = coin3(scene);
        coin3.setX(300);
        coin3.setY(250);




        root.getChildren().addAll(ship,cloud,cloud2,cloud3,cloud4,coin1,coin2,coin3,score,scoredis,over);





        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            int X2=0;
            double y = ship.getY();

            switch (event.getCode()){
                case UP -> ship.setY(y - 10);
                case DOWN -> ship.setY(y + 10);
            }




            if (ship.getBoundsInParent().intersects(cloud.getBoundsInParent()) || ship.getBoundsInParent().intersects(cloud2.getBoundsInParent()) || ship.getBoundsInParent().intersects(cloud3.getBoundsInParent()) || ship.getBoundsInParent().intersects(cloud3.getBoundsInParent()) || ship.getBoundsInParent().intersects(cloud4.getBoundsInParent()))   {

                System.out.println("game over");
                ship.setImage(new Image("f.png"));

                scene.addEventFilter(KeyEvent.KEY_PRESSED, event1 -> {
                    double x1 = ship.getX();
                    double y1 = ship.getY();

                    switch (event.getCode()) {
                        case UP -> ship.setY(y - 0);
                        case DOWN -> ship.setY(y + 0);
                        case LEFT -> ship.setX(y -0);
                        case RIGHT -> ship.setX(y +0);

                    }
                });

            }




            //calculating score

            else if( ship.getBoundsInParent().intersects(coin2.getBoundsInParent())){
                X2++;
                scoredis.setText("M" +X2);
                coin2.setVisible(false);
                X2=X2;
            }
            else if( ship.getBoundsInParent().intersects(coin1.getBoundsInParent())){
                X2++;
                scoredis.setText("M" +X2);
                coin1.setVisible(false);
                X2 = X2;
            }

            else if( ship.getBoundsInParent().intersects(coin3.getBoundsInParent())){
                X2++;
                scoredis.setText("M" +X2);
                coin3.setVisible(false);
                X2=X2;
            }

        });

        stage.setTitle("Game design");
        stage.setScene(scene);
        stage.show();
    }
    private ImageView createShip(Scene scene) {
        ImageView image = new ImageView(new Image("ship.png"));
        image.setFitWidth(50);
        image.setFitHeight(50);
        image.setY(scene.getHeight() - image.getFitHeight());


        return image;
    }

    // Adding of clouds

    private ImageView Clouds(Scene scene) {
        ImageView image = new ImageView(new Image("Clu.png"));
        image.setFitWidth(100);
        image.setFitHeight(100);
        image.setY(scene.getHeight() - image.getFitHeight());

        int radius = 40;
        TranslateTransition tt = new TranslateTransition(Duration.millis(6000), image);
        tt.setByX(scene.getWidth() - (radius * 2));
        tt.setCycleCount(Integer.MAX_VALUE);
        //tt.setAutoReverse(true);

        tt.play();
        return image;
    }

    private ImageView Clouds2(Scene scene) {
        ImageView image = new ImageView(new Image("Clu.png"));
        image.setFitWidth(100);
        image.setFitHeight(100);
        image.setY(scene.getHeight() - image.getFitHeight());


        int radius = 40;
        TranslateTransition tt = new TranslateTransition(Duration.millis(10000), image);
        tt.setByX(scene.getWidth() - (radius * 2));
        tt.setCycleCount(Integer.MAX_VALUE);
        //tt.setAutoReverse(true);

        tt.play();
        return image;
    }

    private ImageView Clouds3(Scene scene) {
        ImageView image = new ImageView(new Image("Clu.png"));
        image.setFitWidth(100);
        image.setFitHeight(100);
        image.setY(scene.getHeight() - image.getFitHeight());


        int radius = 40;
        TranslateTransition tt = new TranslateTransition(Duration.millis(30000), image);
        tt.setByX(scene.getWidth() - (radius * 2));
        tt.setCycleCount(Integer.MAX_VALUE);
        //tt.setAutoReverse(true);

        tt.play();
        return image;
    }

    //Adding coins

    private ImageView coin(Scene scene) {
        ImageView image = new ImageView(new Image("C.png"));
        image.setFitWidth(40);
        image.setFitHeight(40);
        image.setY(scene.getHeight() - image.getFitHeight());


        int radius = 40;
        TranslateTransition tt = new TranslateTransition(Duration.millis(10000), image);
        tt.setByX(scene.getWidth() - (radius * 2));
        tt.setCycleCount(Integer.MAX_VALUE);
        //tt.setAutoReverse(true);

        tt.play();
        return image;
    }

    private ImageView coin3(Scene scene) {
        ImageView image = new ImageView(new Image("C.png"));
        image.setFitWidth(40);
        image.setFitHeight(40);
        image.setY(scene.getHeight() - image.getFitHeight());


        int radius = 40;
        TranslateTransition tt = new TranslateTransition(Duration.millis(6000), image);
        tt.setByX(scene.getWidth() - (radius * 2));
        tt.setCycleCount(Integer.MAX_VALUE);
        //tt.setAutoReverse(true);

        tt.play();
        return image;
    }


    public static void main(String[] args) {
        launch();
    }
}