
public class SolveSudoku{

    private static final int GRID_SIZE = 9;
    private String input;
    private String output = "";
    private int[][] board;

    public SolveSudoku(String input){
        this.input = input;
        System.out.println(this.input);
        board = new int[9][9];
        board = makeBoard(this.input);

        if(solveBoard(board)){
            System.out.println("Solved");
        }
        else{
            System.out.println("Unsolvable");
        }
        printBoard(board);
        new SolutionFrame(output);
    }

    public int[][] makeBoard(String input) {
        int x = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(input.charAt(x) <= 48){
                    board[i][j] = 0;
                }
                else {
                    board[i][j] = (input.charAt(x) - 48);
                }
                x++;
            }
        }
        return board;
    }

    private String printBoard(int[][] board){
        for(int row = 0; row < GRID_SIZE; row++){
            if(row % 3 == 0 && row != 0){
                System.out.println("-----------");
            }
            for(int column = 0; column < GRID_SIZE; column++){
                if(column % 3 == 0 && column != 0){
                    System.out.print("|");
                }
                System.out.print(board[row][column]);
                output += board[row][column];
            }
            System.out.println();
        }
        return output;
    }

    private final boolean isNumberInRow(int[][] board, int number, int row){
        for(int i = 0; i<GRID_SIZE;i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private final boolean isNumberInColumn(int[][] board, int number, int column){
        for(int i = 0; i<GRID_SIZE;i++) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private final boolean isNumberInBox(int[][] board, int number, int row, int column){
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;

        for(int i = localBoxRow; i < localBoxRow + 3; i++){
            for(int j = localBoxColumn; j < localBoxColumn + 3; j++){
                if(board[i][j] == number){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidPlacement(int[][] board, int number, int row, int column){
        return !isNumberInRow(board, number, row) &&
                !isNumberInColumn(board, number, column) &&
                !isNumberInBox(board, number, row, column);
    }

    private boolean solveBoard(int[][] board){
        for(int row = 0; row < GRID_SIZE; row++){
            for(int column = 0; column < GRID_SIZE; column++){
                if(board[row][column] == 0){
                    for(int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++){
                        if(isValidPlacement(board, numberToTry, row, column)){
                            board[row][column] = numberToTry;

                            if(solveBoard(board)) {
                                return true;
                            }
                            else{
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
