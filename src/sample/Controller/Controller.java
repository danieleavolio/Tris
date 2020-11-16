package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import sample.Model.Game;

import java.net.URI;
import java.net.URISyntaxException;

public class Controller {

    @FXML
    public Label winner;
    public Button playAgain;

    @FXML
    private Label ZZ;

    @FXML
    private Label OO;

    @FXML
    private Label TT;

    @FXML
    private Label ZO;

    @FXML
    private Label OT;

    @FXML
    private Label TZ;

    @FXML
    private Text turnoAttuale;

    @FXML
    private Label ZT;

    @FXML
    private Label OZ;

    @FXML
    private Label TO;



    @FXML
    void OZClicked(MouseEvent event) {
        canSign(OZ,1,0);
    }

    @FXML
    void TZClicked(MouseEvent event) {
        canSign(TZ,2,0);
    }

    @FXML
    void ZZClicked(MouseEvent event) {
        canSign(ZZ,0,0);
    }

    @FXML
    void OOClicked(MouseEvent event) {
        canSign(OO,1,1);
    }

    @FXML
    void ZOClicked(MouseEvent event) {
        canSign(ZO,0,1);
    }

    @FXML
    void TOClicked(MouseEvent event) {
        canSign(TO,2,1);
    }

    @FXML
    void OTClicked(MouseEvent event) {
        canSign(OT,1,2);
    }

    @FXML
    void ZTClicked(MouseEvent event) {
        canSign(ZT,0,2);
    }

    @FXML
    void TTClicked(MouseEvent event) {
        canSign(TT,2,2);
    }

    public void cambiaTurnoAttuale(){
        turnoAttuale.setText(Game.getGame().getTurno());
    }

    public void canSign (Label label, int x, int y){
        if (label.getText().equals("   ") && winner.getOpacity() == 0){
            changeColor(label);
            label.setText(Game.getGame().getTurno());
            Game.getGame().tris[x][y] = Game.getGame().getTurno();
            //CONTROLLO SE IL GIOCO E' FINITO
            if (Game.getGame().end()) {
                winner.setText("Winner: " + Game.getGame().getTurno());
                winner.setTextFill(Color.TURQUOISE);
                winner.setTranslateX(0);
                winner.setOpacity(1);
                playAgain.setFocusTraversable(true);
                playAgain.setVisible(true);
            }
            Game.getGame().numeroMosse++; // AUMENTO IL NUMERO DELLE MOSSE
            //SE SONO A 9 MOSSE E  NESSUNO HA VINTO ALLORA POSSIAMO PROVARE A RICOMINCIARE
            if (!Game.getGame().end() && Game.getGame().maxMosse()){
                winner.setText("TIE");
                winner.setTranslateX(100);
                winner.setTextFill(Color.PURPLE);
                winner.setOpacity(1);
                playAgain.setFocusTraversable(true);
                playAgain.setVisible(true);
            }

            Game.getGame().changeTurno();
            cambiaTurnoAttuale();
            Game.getGame().stampaMatrice();
            System.out.println();

        }

    }
    public void changeColor(Label label){
        if (Game.getGame().getTurno().equals(Game.CERCHIO))
            label.setTextFill(Color.RED);
        else if (Game.getGame().getTurno().equals(Game.CROCE))
            label.setTextFill(Color.BLUE);
    }

    public void initialize(){
        Game.getGame().initMatrix();
        Game.getGame().stampaMatrice();
        loadMedia();
    }
    private void loadMedia() {
        String file = getClass().getResource("../View/peppe.mp3").toString();
        System.out.println(file);
        try {
            Media media = new Media(file);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        }
        catch (Exception e){
            System.out.println("mi dispaice");
        }

    }


    public void restartGame(ActionEvent actionEvent) {
        TO.setText("   ");
        ZZ.setText("   ");
        OO.setText("   ");
        TT.setText("   ");
        ZO.setText("   ");
        OT.setText("   ");
        TZ.setText("   ");
        ZT.setText("   ");
        OZ.setText("   ");
        playAgain.setVisible(false);
        playAgain.setFocusTraversable(false);
        Game.getGame().numeroMosse = 0;
        winner.setOpacity(0);
        initialize();
    }
}


