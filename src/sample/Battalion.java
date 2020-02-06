package sample;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;


public class Battalion {
    Image image3 = new Image("Батальйон.png");

    ImageView batt;
    Label batalionname;
    Battalion battalion;

    Ellipse ellipse;


    public Battalion(String name){
        battalion = this;
        batt = new ImageView(image3);

        batalionname = new Label();
        batalionname.setText(name);
        batalionname.setTextFill(Color.web("BLUE"));
        batalionname.setFont(Font.font("Tahoma",18));

        ellipse = new Ellipse(90, 20);
        ellipse.setFill(Color.rgb(0, 0, 0, 0.5d));

        Program.main.root.getChildren().addAll(batt,batalionname,ellipse);
        batt.setImage(image3);



    }
}
