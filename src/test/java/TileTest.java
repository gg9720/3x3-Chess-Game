import org.junit.Test;

import static org.junit.Assert.*;

public class TileTest {

    @Test
    public void canTileMove() {
        int x = 2;
        int y = 2;
        Tile temp = new Tile(x,y,false);
        assertFalse(temp.canTileMove());
    }


}