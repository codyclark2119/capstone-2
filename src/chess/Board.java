package chess;

import chess.pieces.Pawn;

public class Board {
    Space[][] spaces = new Space[8][8];

    public void resetBoard(){
        //Set Major characters

        //Empty Spaces for tests
        for (int wt = 0; wt < 8; wt++) {
            spaces[0][wt] = new Space(0, wt, null);
        }

        for (int bt = 0; bt < 8; bt++) {
            spaces[7][bt] = new Space(8, bt, null);
        }

        //Set Pawns
        //White side
        for (int w = 0; w < 8; w++) {
            spaces[1][w] = new Space(1, w, new Pawn(true));
        }
        //Black side
        for (int b = 0; b < 8; b++) {
            spaces[6][b] = new Space(6, b, new Pawn(false));
        }
        //Set Empty spaces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                spaces[i][j] = new Space(i, j, null);
            }
        }
    }

    public Space getBox(int x, int y) {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            System.out.println("Index out of bounds");
            return null;
        }

        return spaces[x][y];
    }
}
