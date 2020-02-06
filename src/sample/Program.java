package sample;

import javafx.stage.Stage;

import java.util.ArrayList;


public class Program {
    public static Main main;
    public static  Stage MainWindow ;
    public static ArrayList<Soldier> soldiers= new ArrayList<>();

    public static void NewSold(String name, double pow){

        soldiers.add( new Soldier(name,false,pow));

    }

    public static  void NewCap(String name, double pow){

        soldiers.add(new Captain(name,false, pow));
    }
    public static void NewGen(String name, double pow){

        soldiers.add(new General(name,false, pow ));
    }
    public static void ClearChoosed(){
        for (Soldier b:choosed
        ) {
            b.isActive = false;
            b.Unhightlight();
        }
        choosed.clear();
        System.gc();

    }

    public static  void delete(){
        for (Soldier b:choosed
        ) {
            soldiers.remove(b);
            b.delete();
        }

        ClearChoosed();
    }
    public static ArrayList<Soldier> choosed= new ArrayList<>();
}
