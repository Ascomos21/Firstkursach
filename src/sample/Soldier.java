package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Soldier {
    Image image =new Image("soldier.png",44,82,true,true);
    Image image1 = new Image("soldier_active.png");

    Label Name;
    Label Powerfull;
    ImageView sold ;
    Ellipse ellipse;
    Soldier soldier;

    protected double pow;
    protected double timeA;
    protected int way;

    boolean isActive;

    public void delete(){
        Program.main.root.getChildren().removeAll(Name,sold,Powerfull);

        System.gc();
    }


    public Soldier(String name,boolean ia,double pow){
        soldier=this;
        sold= new ImageView(image);
        Name= new Label();
        Name.setText(name);
        this.pow = pow;

        isActive = ia;
        ia = false;

        int min =1;
        int max =4;
        int diff = max-min;
        Random random = new Random();
        int way = random.nextInt(diff+1);
        way+=min;
        this.way = way;

        double minT=0;
        double maxT =4;
        double timec =  ThreadLocalRandom.current().nextDouble(minT, maxT);
        this.timeA = timec;
        ellipse = new Ellipse(20, 10);
        ellipse.setFill(Color.rgb(0, 0, 0, 0.5d));

        Name.setTextFill(Color.web("Red"));
        Name.setFont(Font.font("Tahoma", 14));

        Powerfull = new Label();
        Powerfull.setText(Double.toString(pow));
        Powerfull.setTextFill(Color.BLUE);
        Powerfull.setFont(Font.font("Tahoma",14));

        if(ia){
            sold.setImage(image1);
        }
        else {
            sold.setImage(image);
        }

        Program.main.root.getChildren().addAll(sold,Name,ellipse,Powerfull);
        sold.setTranslateX(0);
        sold.setTranslateY(0);
        sold.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){

               for( Soldier mr:Program.soldiers)
                    mr.MouseClick(event.getX(),event.getY());
            }
        });

    }
    public void MouseClick(double x, double y)
    {
        Point2D m = new Point2D(x,y);

        if( sold.contains(m) )
        {
            isActive= !isActive;

            if (isActive) {
                MakeHighlight();
                Program.choosed.add(soldier);
            }
            else {
                Unhightlight();
                Program.choosed.remove(soldier);
            }
        }
    }
   public void Left(){
        if (!isActive) return;
        double x = sold.getX()-10;
        sold.setX(x);
        Name.relocate(sold.getX(),sold.getY());
       ellipse.setCenterX(sold.getX()+36);
       ellipse.setCenterY(sold.getY()+75);
       Powerfull.relocate(sold.getX(),sold.getY()+70);
       if (sold.getX() <= 0)
           sold.setX(0);
       if (sold.getX() > 4000 && sold.getX() < 4020 )
           sold.setX(4020);
    }
    public void Up(){
        if (!isActive) return;
        double y = sold.getY()-10;
        sold.setY(y);
        Name.relocate(sold.getX(),sold.getY());
        ellipse.setCenterX(sold.getX()+36);
        ellipse.setCenterY(sold.getY()+75);
        Powerfull.relocate(sold.getX(),sold.getY()+70);
        if (sold.getY() <= 0)
            sold.setY(0);
    }
    public void Right (){
        if (!isActive)return;
        double x = sold.getX()+10;
        sold.setX(x);
        Name.relocate(sold.getX(),sold.getY());
        ellipse.setCenterX(sold.getX()+36);
        ellipse.setCenterY(sold.getY()+75);
        Powerfull.relocate(sold.getX(),sold.getY()+70);
        if (sold.getX() <= 0)
            sold.setX(0);
        if (sold.getX() > 4000 && sold.getX() < 4020 )
            sold.setX(4020);
    }
    public void Down(){
        if (!isActive)return;
        double y = sold.getY()+10;
        sold.setY(y);
        Name.relocate(sold.getX(),sold.getY());
        ellipse.setCenterX(sold.getX()+36);
        ellipse.setCenterY(sold.getY()+75);
        Powerfull.relocate(sold.getX(),sold.getY()+70);
        if (sold.getY() > 2350)
            sold.setY(2350);
    }

    public void MakeHighlight(){
       sold.setImage(image1);

    }
    public void setPowerfull(double pow){
        this.pow = pow;
    }
    public double getPowwerfull(){
        return pow;
    }

    public void setTimeA(double timeA){
        this.timeA = timeA;
    }
    public double getTimeA (){
        return timeA;
    }

    public void setWay(int way){
        this.way = way;
    }
    public int getWay(){
        return way;
    }

    public void Unhightlight(){
        sold.setImage(image);
    }

    public void training(){
        if(sold.getX()>600 && sold.getY()<1150 && sold.getY()>550&&sold.getX()<1100){
            this.soldier.setPowerfull(this.soldier.getPowwerfull()+10);
            Powerfull.setText(Double.toString(pow));
        }
    }
    public  void  move(int cor){
        switch (cor){
            case 1:
                double x = sold.getX()-3;
                sold.setX(x);
                Name.relocate(sold.getX(), sold.getY());
                Powerfull.relocate(sold.getX(), sold.getY() + 70);
                ellipse.relocate(sold.getX()+36, sold.getY()+70);
                soldier.timeA -= 0.016666d;
                if (sold.getX() <= 0)
                    sold.setX(0);
                if (sold.getX() > 4000 && sold.getX() < 4020 )
                    sold.setX(4020);
                break;
                case 2:
                    double y = sold.getY()-3;
                    sold.setY(y);
                    Name.relocate(sold.getX(), sold.getY());
                    Powerfull.relocate(sold.getX(), sold.getY() + 70);
                    ellipse.relocate(sold.getX()+36, sold.getY()+70);

                    soldier.timeA -= 0.016666d;
                    if (sold.getY() <= 0)
                        sold.setY(0);
                    break;
                case 3:
                    double x1 = sold.getX()+3;
                    sold.setX(x1);
                    Name.relocate(sold.getX(), sold.getY());
                    Powerfull.relocate(sold.getX(),sold.getY() + 70);
                    ellipse.relocate(sold.getX()+36, sold.getY()+70);

                    soldier.timeA -= 0.016666d;
                    if (sold.getX() < 4000 && sold.getX() > 3930 )
                        sold.setX(3930);
                    if (sold.getX() > 7940 && sold.getX() < 8000 )
                        sold.setX(7940);
                    break;
                case 4:
                    double y1 = sold.getY()+3;
                    sold.setY(y1);
                    Name.relocate(sold.getX(), sold.getY());
                    Powerfull.relocate(sold.getX(), sold.getY() + 70);
                    ellipse.relocate(sold.getX()+36, sold.getY()+70);

                    soldier.timeA -= 0.016666d;
                    if (sold.getY() > 2350)
                        sold.setY(2350);
                    break;
        }
    }
    public void alert(){

        double y = sold.getY();

        while (y!=2000) {
            soldier.timeA -= 0.016666d;
            sold.setY(y);
            Name.relocate(sold.getX(), sold.getY());
            Powerfull.relocate(sold.getX(), sold.getY() + 70);
            ellipse.relocate(sold.getX() + 36, sold.getY() + 70);
            y+=5;
        }
    }

}
