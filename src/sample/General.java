package sample;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class General extends  Captain {
    public General(String name, boolean ia, double pow){
        super(name, ia,pow);
        soldier.ellipse.setRadiusX(30);
        soldier.ellipse.setRadiusY(17);
        soldier.ellipse.setFill(Color.rgb(0, 0, 0, 0.7d));
        image = new Image("General.png");
        image1 = new Image("General_active.png");
        if (isActive) {
            sold.setImage(image1);
        }
        else {
            sold.setImage(image);
        }
    }
}
