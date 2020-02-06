package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateWindow {

    public static boolean display(String title)
    {
        Stage window = new Stage();
        String message="Ім'я солдата";
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Label label1=new Label(message);
        label1.setFont(new Font(35));
        TextField textField = new TextField();


        Label labe2 = new Label("Введіть ранг: 1 - Солдат 2 - Капітан 3 - Генерал");
        labe2.setFont(new Font(35));
        TextField textField1 = new TextField();

        Label label3 = new Label("Введіть потужність солдата");
        label3.setFont(new Font(35));
        label3.setTextFill(Color.BLUE);
        Spinner<Integer> ppowerfull = new Spinner<>(0,10000,0);


        Button noButton = new Button("Створити Солдата");
        noButton.setFont(new Font(33));
        noButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str = textField1.getText();

                int a;
                a = Integer.parseInt(str.trim());
                if(a==1) {
                    Program.NewSold(textField.getText(),ppowerfull.getValue());
                    window.close();
                }
                if(a==2){
                    Program.NewCap(textField.getText(),ppowerfull.getValue());
                    window.close();
                }
                if(a==3){
                    Program.NewGen(textField.getText(),ppowerfull.getValue());
                    window.close();
                }
            }
        });

        VBox layout = new VBox(5);
        layout.getChildren().addAll(label1,textField,labe2,textField1,label3,ppowerfull,noButton);

        Scene scene = new Scene(layout, 777,400);
        window.setScene(scene);

        window.showAndWait();

        return true;
    }
}