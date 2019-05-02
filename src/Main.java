import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int x;

        do {

            Sudoku sudoku = new Sudoku();
            sudoku.play();
            System.out.println("vrei sa joci din nou? DA-> 1  NU-> 0");
            x = scanner.nextInt();

        }while(x==1);
    }
}
