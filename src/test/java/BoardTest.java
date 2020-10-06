import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void fillTheBoard() {
        Tile[][] temp = new Tile[4][4];
        Board desk = new Board(temp);
        desk.fillTheBoard();
        assertNotNull(temp);
    }

    @Test
    public void findTheWay() {
        int x = 1;
        int y = 1;
        Tile[][] temp = new Tile[4][4];
        Board desk = new Board(temp);
        desk.fillTheBoard();
        desk.findTheWay(x,y);
        assertTrue(desk.getTile(3, 3).isVisited());
    }

    @Test
    public void testgetTile() {
        int x = 2;
        int y = 2;
        Tile[][] desk = new Tile[4][4];
        Board board = new Board(desk);
        board.fillTheBoard();
        assertNotNull(board.getTile(x,y));
    }
}