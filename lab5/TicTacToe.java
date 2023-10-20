package lab5;

public class TicTacToe {
    private static final char EMPTY = ' ';
    private char[][] board;

    public TicTacToe(char[][] board) {
        this.board = board;
    }

    public boolean checkColumns() {
        int length = board.length;
        int resulta = 0;
        int resultb = 0;
        int column = 0;
        orther: for (int i = 0; i < 2 ; i +=2 ) {
            while (board[column][i] == 'x') {
                resulta++;
                if (resulta == length) {
                    return true;
                } else {
                    column++;
                    i = 0;
                }
            }
            while (resultb < 2) {
                 if (board[column][i] == '0' && board[column][i+1] == '0') {
                    resultb++;
                    continue orther;
                }else{

                }
            }
            while ( length - i == 0){
                if (board[column][i] == '0'
            }
        }
        return false;
    }

    public boolean checkRows() {
        return false;
    }

    public static void main(String[] args) {
        char[][] testColumns = {{'0', 'x', ' '}, {'x', 'x', ' '}, {'0', 'x', ' '}};
        TicTacToe test = new TicTacToe(testColumns);
        System.out.println(test.checkColumns());
    }

}
