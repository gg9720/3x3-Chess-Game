import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Game {

    private Board board;

    /**
     * @param x first coordinate selected from user
     * @param y second coordinate selected from user
     */
    public void startTheGame(int x, int y) {
        this.board.fillTheBoard();
        this.board.findTheWay(x, y);

    }
}
