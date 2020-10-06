import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class Tile {

    private int x;
    private int y;
    private boolean visited;

    /**
     * @return if the selected tile can even move or not
     */
    public boolean canTileMove() {
        return this.getX() != 2 || this.getY() != 2;
    }
}