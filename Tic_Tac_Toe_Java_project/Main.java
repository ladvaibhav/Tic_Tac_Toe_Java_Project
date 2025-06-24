import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char[][] board = new char[3][3]; // 2D Array for board

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.print("Player " + player + " Enter: ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (row <0 ||row >= 3 ||col <0 ||col>=3) {
                System.out.println("This move is Out of Bound. \n Try Again");
                continue;
            }

            if (board[row][col] == ' ') {
                board[row][col] = player; // Place the Element
                gameOver = haveWon(board, player);
                if (gameOver) {
                    System.out.println("Player " + player + " Has Won ");
                }else if (isBoardFull(board)) {
                    printBoard(board);
                    printResultBox("The game is draw!");
                    gameOver= true;
                } else {
                    // if (player == 'X') {
                    // player = 'O';
                    // }else{
                    // player = 'X';
                    // }
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid Try Again ");
            }
        }
        sc.close();
    }

    public static boolean haveWon(char[][] board, char player) {
        // Check win Condition for row
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1]== player && board[row][2]== player) {
                printBoard(board);
                return true;
            }
        }
        // Check win Condition for col
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col]== player) {
                printBoard(board);
                return true;
            }
        }
        // Check for diagonal
        if (board[0][0]== player && board[1][1]== player && board[2][2]== player ) {
            printBoard(board);
            return true;
        }
        if (board[0][2]== player && board[1][1]== player && board[2][0]== player ) {
            printBoard(board);
            return true;
        }
        return false;
    }

    public static boolean isBoardFull(char[][] board){
        for(int row = 0; row < board.length ; row++){
            for(int col = 0; col < board[row].length ; col++){
                if (board[row][col] == ' '){
                    return false;
                }
        }
    }
    return true;
}

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            if (row < board.length -1) {
                System.out.println("--------------");
            }
        }
    }
    public static void printResultBox(String message) {
        int length = message.length();
        String border = "+";
        for (int i = 0; i < length + 2; i++) {
            border += "-";
        }
        border += "+";

        System.out.println(border);
        System.out.println("| " + message + " |");
        System.out.println(border);
    }
}