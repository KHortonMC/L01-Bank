package cs113.bank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    static Bank bank;
    public static Bank bankSingleton() { return bank; }

    @Override
    public void start(Stage stage) throws IOException {
        bank = new Bank();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("bank.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Bank Name");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}