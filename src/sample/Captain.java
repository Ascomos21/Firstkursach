package sample;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Captain extends  Soldier {
    public Captain(String name,boolean ia,double pow){
        super(name,ia,pow);
        //ellipse = new Ellipse(25, 13);
      //  ellipse.setFill(Color.rgb(0, 0, 0, 0.6d));
        soldier.ellipse.setRadiusX(26);
        soldier.ellipse.setRadiusY(13);
        soldier.ellipse.setFill(Color.rgb(0, 0, 0, 0.6d));
        image = new Image ("Captain.png");
        image1 = new Image("Captain_active.png");
        if (isActive) {
            sold.setImage(image1);
        }
        else {
            sold.setImage(image);
        }


    }
}
