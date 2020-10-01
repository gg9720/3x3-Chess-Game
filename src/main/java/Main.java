import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Tile[][] desk = new Tile[4][4];
        Board board = new Board(desk);
        Game tryOne = new Game(board);
        tryOne.startTheGame(n, m);
    }
}
