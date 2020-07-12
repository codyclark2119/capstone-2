package chess.pieces;

import chess.Board;
import chess.Piece;
import chess.Space;

public class Pawn extends Piece {

    public Pawn(boolean white, int x, int y){
        super(white, x, y);
        this.setName("Pawn");
    }

    @Override
    public boolean canMove(Board board, Space start, Space end){
        //Getting the difference between coordinates passed to check if
        //movement amount is valid
        int x = end.getX() - start.getX();
        int y = end.getY() - start.getY();
        //Prevents a piece from moving across the y axis
        //and there is no enemy piece
        if (Math.abs(y) > 0) {
            if (!this.diagonalMoveCheck(board, start, end)) {
                return false;
            }
        }
        //Checking for valid first pawn two space movement
        if(Math.abs(x) == 2){
            //White
            if(start.getX() == 1 && this.isWhite()){
                return this.verticalMoveCheck(board, start, end);
            }
            //Black
            else if(start.getX() == 6 && this.isWhite() == false){
                return this.verticalMoveCheck(board, start, end);
            }
        }
        if(Math.abs(x) < 2){
            return this.verticalMoveCheck(board, start, end);
        }
        //Prevents white backwards moving
        if(this.getName() == "White" && x == 1){
            System.out.println("Pawn fail 2");
            return false;
        }
        //Prevents black backwards moving
        if(this.getName() == "Black" && x == -1){
            System.out.println("Pawn fail 3");
            return false;
        }
        //Successful check
        return false;
    }
}
