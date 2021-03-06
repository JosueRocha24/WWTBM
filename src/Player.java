public class Player {

    private String name;
    private Pawn[] pawns;
    private int playerNumber;
    private Grid grid;
    private boolean[][] possibleSquares;
    private Game game;

    public Player(String name, Grid grid, int playerNumber, Game game){
        this.playerNumber = playerNumber;
        this.grid = grid;
        this.name = name;
        pawns = new Pawn[8];
        createPawns();
        possibleSquares = new boolean[grid.getCols()][grid.getRows()];
        this.game = game;
    }

    public boolean firstMove(int col1, int row1, int col2, int row2){

        pawnPossibleSquares(pawns[col1]);

        if(row2 < 7 && possibleSquares[col2][row2]){
            pawns[col1].getPosition().setCol(col2);
            pawns[col1].getPosition().setRow(row2);
            game.

        }
        return true;

    }

    public void move(int col, int row){
        if(playerNumber == 1){

        }else{

        }
    }

    private void createPawns(){
        for(int i = 0; i < Color.values().length; i++){
            int col = i;
            int row;
            if(playerNumber == 1){
                row = 0;
                pawns[i] = new Pawn(Color.values()[i], col, row);
            }else{
                row = grid.getRows() - 1;
                pawns[i] = new Pawn(Color.values()[Color.values().length - 1 - i], col, row);
            }

        }
    }

    public void pawnPossibleSquares( Pawn pawn){
        int jAbs;
        boolean iTest;
        boolean jTest;

        int pRow = pawn.getPosition().getRow();
        int pCol = pawn.getPosition().getCol();

        for(int i = 0; i < grid.getRows(); i++){
            for(int j = 0; j < grid.getCols(); j++){
                jAbs = Math.abs(j - pCol);
                iTest = i > pRow;
                jTest = (j == pCol || jAbs == i - pRow);
                if(iTest && jTest && !grid.getSquares()[j][i].isOccupied()){
                    possibleSquares[j][i] = true;
                }else{
                    possibleSquares[j][i] = false;
                }
            }
        }

    }

}
