package lab5;

public class TicTacToe {
    private static final char EMPTY = ' ';
    private char[][] board;

    public TicTacToe(char[][] board) {
        this.board = board;
    }


    // 3 X 3
//    public boolean checkColumns() {
//        int colum = 0;
//        while (colum < 3) {
//            if (board[0][colum] == board[1][colum] && board[1][colum] == board[2][colum]) {
//                return true;
//            } else {
//                colum++;
//            }
//        }
//        return false;
//    }
//    public boolean checkRows() {
//        int row = 0;
//        while (row < 3) {
//            if (board[0][row] == board[1][row] && board[1][row] == board[2][row]) {
//                return true;
//            } else {
//                row++;
//            }
//        }
//        return false;
//    }
//
//    public boolean checkDiagonal(){
//            return (board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
//                    (board[0][2] == board[1][1] && board[1][1] == board[2][0] );
//    }
//
//    public boolean checkWin() {
//        return checkColumns()|| checkRows() || checkDiagonal();
//    }

    // n X n
    public boolean checkColumns() {
        if (board.length <= 2 && board.length == board[0].length) return false;
        int length = board.length;
        int temp = 0;
        int column = 0;
        outer:
        while (temp < length - 1) {
            for (int i = 0; i < length - 2; i++) {
                if (board[i][column] == board[i + 1][column] && board[i + 1][column] == board[i + 2][column]) {
                    return true;
                } else {
                    temp += 1;
                    continue outer;
                }
            }
        }
        return false;
    }

    public boolean checkRows() {
        return false;
    }

    public static void main(String[] args) {
        char[][] testColumns = {
                {'0', 'x', '0', 'x', '0', 'x'},
                {'x', '0', 'x', 'x', '0', 'x'},
                {'0', 'x', 'x', '0', '0', 'x'},
                {'0', '0', '0', 'x', '0', 'x'},
                {'x', '0', 'x', '0', '0', 'x'},
                {'0', '0', '0', 'x', '0', 'x'}};
        TicTacToe test = new TicTacToe(testColumns);
        System.out.println(test.checkColumns());
    }

}
