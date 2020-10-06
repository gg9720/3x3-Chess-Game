import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the coordinates: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        while(n<1 || n>3 || m<1 || m>3){
            System.out.println("Invalid input, try again: ");
            n = sc.nextInt();
            m = sc.nextInt();
        }

        Tile[][] desk = new Tile[4][4];
        Board board = new Board(desk);
        Game tryOne = new Game(board);
        tryOne.startTheGame(n, m);
    }
}
