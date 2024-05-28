import java.util.List;

class ChessBoard {
    Spot[][] spots;
}


abstract class Piece {
    boolean white;
    boolean killed;

    abstract void move(ChessBoard chessBoard, Spot start, Spot end) throws Exception;
}


class Spot {
    int row;
    int col;
    Piece piece;
}


class Rook extends Piece {
    @Override
    void move(ChessBoard chessBoard, Spot start, Spot end) throws Exception {

        if (end.piece != null && end.piece.white == this.white) {
            throw new Exception("Move not allowed!");
        }

        end.piece = this;
        start.piece = null;
    }
}

/**
 * ......... Implement other Pieces .........
 */

class CPlayer {
    boolean white;
}


class CMove {
    CPlayer cPlayer;
    Spot start;
    Spot end;

}

enum CGameStatus {
    RUNNING,
    BLACK_WIN,
    WHITE_WIN,
    DRAW
}


class CGame {
    ChessBoard chessBoard;
    CPlayer[] players;
    CPlayer currentPlayer;
    List<Move> moves;
    CGameStatus gameStatus;

    void initialize() {}

    void makeMove(int startR, int startC, int endR, int endC) {}

    void resign() {}

    void displayBoard() {}

}


public class ChessGame {

    public static void main(String[] args) {
        CGame game = new CGame();
        game.initialize();
        game.makeMove(1, 1, 3, 4);
        game.displayBoard();
    }
}
