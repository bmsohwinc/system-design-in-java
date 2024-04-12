import java.util.ArrayList;
import java.util.List;

class Player {
    int id;
    // char pawn;
    Player(int id) {
        this.id = id;
    }
}

enum GameStatus {
    TO_START,
    RUNNING,
    ENDED;
}


class Move {

    int playerId;
    List<Integer> coordinates;
    public List<Integer> getCoordinates() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCoordinates'");
    }
    public int getPlayerId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlayerId'");
    }
}

interface Board {
    int getWinner(Move move);
    void setCell(Move move);
}


class TwoDimBoard implements Board {

    private final int[][] board;

    int nRows;

    int mCols;

    public TwoDimBoard(int n, int m) {
        board = new int[n][m];
        nRows = n;
        mCols = m;
    }   

    @Override
    public int getWinner(Move move) {
        // TODO
        return 0;
    }

    @Override
    public void setCell(Move move) {
        List<Integer> coordinates = move.getCoordinates();
        if (board[coordinates.get(0)][coordinates.get(1)] != 0) {
            throw new IllegalStateException("Cell is already filled!");
        }
        board[coordinates.get(0)][coordinates.get(1)] = move.getPlayerId();
    }
}

class Game {
    Board board;
    
    List<Player> players;

    GameStatus gameStatus;

    Player nextPlayer;

    public Game(Board board, int numPlayers) {
        this.board = board;
        players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player(i));
        }
        gameStatus = GameStatus.TO_START;
    }

    void start() {
        nextPlayer = getNextPlayer();
        gameStatus = GameStatus.RUNNING;

    }

    Player getNextPlayer() {
        return players.get(0);
    }

    void makeMove(Move move) {
        board.setCell(move);
        if (board.getWinner(move) != 0) {
            // declare winner
            gameStatus = GameStatus.ENDED;
        }
    }


}


public class TicTacToe {
    Game game;
    public TicTacToe() {
        game = new Game(null, 0);
    }

    public void run() {
        game.start();
    }
}
