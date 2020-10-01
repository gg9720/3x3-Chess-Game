import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Game {

    private Board board;

    public void startTheGame(int x, int y) {
        this.board.filltheBoard();
        this.board.findTheWay(x, y);

    }
}
