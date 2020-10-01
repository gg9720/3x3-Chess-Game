import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;


@AllArgsConstructor
public class Board {
    private static final int MAX=3;
    private Tile[][] cells;

    static boolean isInside(int x, int y){
        if(x>=1 && x<=MAX && y>=1 && y<=MAX){
            return true;
        }
        return false;
    }
    public static int getMAX() {
        return MAX;
    }

    public void filltheBoard(){
        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j <= MAX; j++) {
                cells[i][j] = new Tile(i,j,false);
            }
        }
    }

    public void findTheWay(int x, int y){

        int allX[]={ -2, -1, 1, 2, -2, -1, 1, 2 };
        int allY[]={-1, -2, -2, -1, 1, 2, 2, 1 };

        Queue<Tile> elements = new LinkedList<Tile>();

        if(getTile(x,y).canTileMove()){
            elements.add(getTile(x, y));
            getTile(x, y).setVisited(true);
        }
        else {
            System.out.println("Impossible to move");
            return;
        }

        System.out.println("The starting tile is " + getTile(x,y).getX() + " " + getTile(x,y).getY());
        Tile current;
        int newX;
        int newY;
        while(!elements.isEmpty()){
            current = elements.poll();
            System.out.println("Current tile " + current.getX() + " " + current.getY() + " from the queue");
            if(current.getX()==getMAX() && current.getY()==getMAX()){
                System.out.println("Reached bottom right corner");
                return;
            }

            for (int i = 0; i < allX.length; i++) {
                newX= current.getX()+allX[i];
                newY= current.getY()+allY[i];

                if(isInside(newX,newY)) {
                    if(!getTile(newX,newY).isVisited()){

                        getTile(newX,newY).setVisited(true);
                        System.out.println("Next added tile to the queue is " + newX + " " + newY);

                        elements.add(getTile(newX,newY));
                    }
                }
            }
        }
        System.out.println("Cannot be reached");
    }

    public Tile getTile(int x, int y){
        return cells[x][y];
    }

}
