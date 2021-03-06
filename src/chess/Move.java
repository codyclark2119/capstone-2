package chess;

public class Move {
    private Player player;
    private Space start;
    private Space end;
    private Piece pieceMoved;
    private Piece pieceEnd;
    private boolean castlingMove = false;

    public Move(Player player, Space start, Space end)
    {
        this.player = player;
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
        this.pieceEnd = end.getPiece();
    }

    public boolean isCastlingMove()
    {
        return this.castlingMove == true;
    }

    public void setCastlingMove(boolean castlingMove)
    {
        this.castlingMove = castlingMove;
    }

    public Piece getPieceMoved() {
        return pieceMoved;
    }

    public Piece getPieceEnd() {
        return pieceEnd;
    }

    public Space getStart() {
        return start;
    }

    public Space getEnd() {
        return end;
    }

    @Override
    public String toString(){
        String moveString = "";
        if(this.pieceMoved.isWhite()){
            moveString += "White " + this.pieceMoved.getName();
        } else {
            moveString += "Black " + this.pieceMoved.getName();
        }
        moveString += " moves from (" + start.getX() +","+ start.getY() + ")" + " to (" + end.getX() +","+ end.getY() + ")";
        return moveString;
    }
}
