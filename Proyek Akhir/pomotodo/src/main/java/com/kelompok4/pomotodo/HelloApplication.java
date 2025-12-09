package com.kelompok4.pomotodo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        // Instansiasi View
        PixelView appView = new PixelView();

        // Load View ke dalam Scene
        Scene scene = new Scene(appView.getView(), 360, 600);

        stage.setTitle("Pomotodo Pixel");
        stage.setScene(scene);
        stage.setResizable(false); // Biar layout gak hancur ditarik-tarik
        stage.show();
    }

    public static void main(String[]args) {
        launch();
    }
}
