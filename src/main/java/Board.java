import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;

@AllArgsConstructor
@Getter
@Setter
public class Board {
    private static final int ALLX[] = {-2, -1, 1, 2, -2, -1, 1, 2};
    private static final int ALLY[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static final int MAX = 3;
    private static final int MIN = 1;
    private Tile[][] cells;

    private static boolean isInside(int x, int y) {
        return x >= MIN && x <= MAX && y >= MIN && y <= MAX;
    }

    /**
     * void method to fill the board with Tile objects
     */
    public void fillTheBoard() {
        for (int i = MIN; i <= MAX; i++) {
            for (int j = MIN; j <= MAX; j++) {
                this.getCells()[i][j] = new Tile(i, j, false);
            }
        }
    }

    /**
     * This method uses two coordinates of a Tile to start searching for a path to get to the
     * final point. The parameters are the coordinates of the Tile. We can reach the final point
     * from every selected Tile which can move ofcourse.
     *
     * @param x first coordinate of the starting point which we will use to get to the final cell
     * @param y second coordinate of the starting point which we will use to get to the final cell
     */
    public void findTheWay(int x, int y) {

        Queue<Tile> elements = new LinkedList<Tile>();

        if (!getTile(x, y).canTileMove()) {
            System.out.println("Impossible to move");
            return;
        }

        elements.add(getTile(x, y));
        getTile(x, y).setVisited(true);

        System.out.println("The starting tile is " + getTile(x, y).getX() + " " + getTile(x, y).getY());

        while (!elements.isEmpty()) {
            Tile current = elements.poll();
            System.out.println("Current tile " + current.getX() + " " + current.getY() + " from the queue");
            if (current.getX() == MAX && current.getY() == MAX) {
                System.out.println("Reached bottom right corner");
                return;
            }

            for (int i = 0; i < ALLX.length; i++) {
                int newX = current.getX() + ALLX[i];
                int newY = current.getY() + ALLY[i];

                if (isInside(newX, newY)) {
                    if (!getTile(newX, newY).isVisited()) {

                        getTile(newX, newY).setVisited(true);
                        System.out.println("Next added tile to the queue is " + newX + " " + newY);

                        elements.add(getTile(newX, newY));
                    }
                }
            }
        }

    }

    /**
     * @param x first coordinate of the wanted tile
     * @param y second coordinate of the wanted tile
     * @return the tile we wanted to get
     */
    public Tile getTile(int x, int y) {
        return getCells()[x][y];
    }

}
