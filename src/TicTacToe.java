import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[][] board={{' ',' ',' '},
                        {' ',' ',' '},
                        {' ',' ',' '}} ;
        printBoard(board);

        while (true) {

            playerTurn(board, sc);
            if(isGameFinished(board)){
                break;
            }
            printBoard(board);

            computerTurn(board);
            if(isGameFinished(board)){
                break;
            }
            printBoard(board);
        }
        sc.close();
    }
    private static boolean isGameFinished(char[][] board){
        if(hasContestantWon(board,'X')){
            printBoard(board);
            System.out.println("Player win!");
            return true;
        }
        if(hasContestantWon(board,'O')){
            printBoard(board);
            System.out.println("Computer win!");
            return true;
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j]==' '){
                    return  false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended with a tie!");
        return true;
    }
    private static boolean hasContestantWon(char[][] board, char symbol){
        if(board[0][0]==symbol && board[0][1] ==symbol && board[0][2]==symbol
                ||board[1][0]==symbol && board[1][1]==symbol && board[1][2]==symbol
                ||board[2][0]==symbol && board[2][1]==symbol && board[2][2]==symbol
                ||board[0][0]==symbol && board[1][0]==symbol && board[2][0]==symbol
                ||board[0][1]==symbol && board[1][1]==symbol && board[2][1]==symbol
                ||board[0][2]==symbol && board[1][2]==symbol && board[2][2]==symbol
                ||board[0][0]==symbol && board[1][1]==symbol && board[2][2]==symbol
                ||board[0][2]==symbol && board[1][1] ==symbol && board[2][2]==symbol){
            return true;
        }
        return false;
    }
    private static void computerTurn(char[][] board) {
        Random random = new Random();
        int computerMove;
        while (true) {

           computerMove = random.nextInt(9) + 1;
            if(isValidMove(board,computerMove)){
                break;
            }
        }
        System.out.println("Computer choose"+computerMove);
        placeMove(board,Integer.toString(computerMove),'O');

    }

    private static void placeMove(char[][] board, String position,char symbol) {

        switch(position){
            case "1":
                board[0][0]=symbol;
                break;
            case "2":
                board[0][1]=symbol;
                break;
            case "3":
                board[0][2]=symbol;
                break;
            case "4":
                board[1][0]=symbol;
                break;
            case "5":
                board[1][1]=symbol;
                break;
            case "6":
                board[1][2]=symbol;
                break;
            case "7":
                board[2][0]=symbol;
                break;
            case "8":
                board[2][1]=symbol;
                break;
            case "9":
                board[2][2]=symbol;
                break;
            default:
                System.out.println(":(");

        }
    }
    private static boolean isValidMove(char[][] board, int position){
        switch(position){
            case 1:
              return (board[0][0]==' ');

            case 2:
                return (board[0][1]==' ');
            case 3:
                return (board[0][2]==' ');

            case 4:
                return (board[1][0]==' ');
            case 5:
                return (board[1][1]==' ');
            case 6:
                return (board[1][2]==' ');
            case 7:
                return (board[2][0]==' ');
            case 8:
                return (board[2][1]==' ');
            case 9:
                return (board[2][2]==' ');
            default:
                return false;
        }

    }

    private static void playerTurn(char[][] board, Scanner sc) {
        String userInput;
        while(true) {
            System.out.println("Let's Play the TIC TAC TOE! Enter a number in between(1-9).");
            userInput = sc.nextLine();
            if(isValidMove(board,Integer.parseInt(userInput))){
                break;
            }else{
                System.out.println(userInput+"not a valid move");
            }

        }
        placeMove(board, userInput, 'X');
    }


    private static void printBoard(char[][] board) {
        System.out.println(board[0][0]+"|"+ board[0][1]+"|"+ board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0]+"|"+ board[1][1]+"|"+ board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0]+"|"+ board[2][1]+"|"+ board[2][2]);
        System.out.println("-+-+-");
    }
}