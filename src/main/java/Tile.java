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

    public boolean canTileMove(){
        if(this.getX() == 2 && this.getY() == 2){
            return false;
        }
        return true;
    }
}