package sample.Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URISyntaxException;

public class Main extends Application {

    private static MediaPlayer mediaPlayer;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/sample.fxml"));
        primaryStage.setTitle("TRIS");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        loadMedia();
    }

    private void loadMedia() {
        String file = getClass().getClassLoader().getResource("sample/View/peppe.mp3").toString();
        try {
            Media media = new Media(file);
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setVolume(0.2);
            mediaPlayer.play();
        }
        catch (Exception e){
            System.out.println("mi dispaice");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
