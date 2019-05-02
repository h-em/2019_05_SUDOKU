import java.sql.SQLOutput;
import java.util.Scanner;

public class Sudoku {
    final static int SIZE = 3;

    char mat[][] = new char[SIZE][SIZE];

    public void initBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mat[i][j] = '*';
            }
        }
    }

    public void draw_game() {

        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + "-");
        }

        System.out.print("\n");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i+"|" + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Move readMove( ){

        //pentru pozitie
        Scanner scanner = new Scanner(System.in);
        System.out.println("introduceti pozitia: ");
        String poz = scanner.nextLine();
        String [] pozitii = poz.split("-");

        //pentru simbol
        System.out.println("introduceti numarul:");
        String simbol = scanner.nextLine();

        Move move = new Move(Integer.parseInt(pozitii[0]),Integer.parseInt(pozitii[1]),simbol.charAt(0));

        return move;
    }



    public void makeMove(int l, int c,char simbol){
        mat[l][c] = simbol;
    }

    public boolean validareLinieColoana(Move move,char simbol){
        boolean simbolNeexistent = true;
        for(int i =0; i<SIZE; i++){
            if(mat[move.line][i]==simbol){
                simbolNeexistent = false;
                break;
            }
        }
        if(simbolNeexistent==true) {
            for (int i = 0; i < SIZE; i++) {
                if (mat[i][move.column] == simbol) {
                    simbolNeexistent = false;
                    break;
                }
            }
        }
        return simbolNeexistent;
    }

    public boolean validareSuprapunere(){
        boolean isFull = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(mat[i][j] == '*'){
                    isFull = false;
                    break;
                }
            }
        }
        return isFull;
    }



    public void play(){
        initBoard();
        boolean finalOfTheGame = false;
        System.out.println("incepe jocul");
        draw_game();


        while (!finalOfTheGame){

            Move move = readMove();
            if(validareLinieColoana(move,move.simbol)) {
                makeMove(move.line, move.column, move.simbol);
                draw_game();

                if(validareSuprapunere()){
                    System.out.println("End of the game!!");
                    finalOfTheGame = true;
                }

            }else{
                System.out.println("Simbolul exista deja sau este invlid.\n Incercati din nou!");
            }
        }
    }
}
