package sample.Model;

public class Game {

    private static Game game = null;
    public static final String CERCHIO = "O";
    public static final String CROCE = "X";
    public int numeroMosse = 0;
    public String turno = CERCHIO;
    public String [][] tris = new String[3][3];



    //initializza
    public static Game getGame(){
        if ( game == null)
            game = new Game();
        return game;
    }



    public String getTurno(){
        return turno;
    }

    public void changeTurno(){
        if (turno.equals("O"))
            turno = CROCE;
        else if (turno.equals("X"))
            turno = CERCHIO;

    }

    public boolean end(){
        if (tris[0][0].equals(turno) && tris[0][1].equals(turno) && tris[0][2].equals(turno) )
            return true;
        if (tris[0][0].equals(turno) && tris[1][0].equals(turno) && tris[2][0].equals(turno) )
            return true;
        if (tris[1][0].equals(turno) && tris[1][1].equals(turno) && tris[1][2].equals(turno) )
            return true;
        if (tris[0][1].equals(turno) && tris[1][1].equals(turno) && tris[2][1].equals(turno) )
            return true;
        if (tris[2][0].equals(turno) && tris[2][1].equals(turno) && tris[2][2].equals(turno) )
            return true;
        if (tris[0][2].equals(turno) && tris[1][2].equals(turno) && tris[2][2].equals(turno) )
            return true;
        if (tris[0][0].equals(turno) && tris[1][1].equals(turno) && tris[2][2].equals(turno) )
            return true;
        if (tris[2][0].equals(turno) && tris[1][1].equals(turno) && tris[0][2].equals(turno) )
            return true;

        return false;
    }

    public void initMatrix(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tris[i][j] = "-";
            }
        }
    }
    public void stampaMatrice(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tris[i][j]);
            }
            System.out.println();
        }
    }

    public boolean maxMosse(){
        if (numeroMosse == 9)
            return true;
        return false;
    }

}
