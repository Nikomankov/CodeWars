package org.example;

import java.util.Arrays;

public class PawnMoveTracker {

    static String[][] field;
    private static final String columns = "abcdefgh";
    private static final String lines = "87654321";
    private static final String white = "W";
    private static final String black = "B";

    public static String[][] movePawns(String[] moves) {
        //create field
        createField();
        System.out.println("moves = " + Arrays.toString(moves));

        for(int i = 0; i< moves.length; i++){
            String move = moves[i];
            System.out.println("\n move = " + move);
            //checking format
            if(!move.matches("[a-h]{1}\\d{1}") && !move.matches("[a-h]{1}x[a-h]{1}\\d{1}")){
                throw new IllegalArgumentException(move + " is invalid");
            }
            boolean movesSequence = i%2==0;     //true = white, false = black
            checkMove(movesSequence,move);
            printField();
        }
        return field;
    }

    private static boolean checkMove(boolean movesSequence, String move){
        boolean result = false;
        boolean capture = move.contains("x");
        int line = decodeMove(move)[1];
        int column = decodeMove(move)[0];
        //White
        //forward movement
        if(movesSequence){
            if(!capture && field[line][column] != black){
                System.out.println(1);
                for(int i = line+1; i <= (line == 4 ? line+2 : line+1); i++){
                    result = field[i][column] == white;
                    if(result) {
                        field[i][column] = ".";
                        break;
                    }
                }
            } else
                //capture
                if(capture && field[line][column] == black){
                    System.out.println(2);
                    int x = columns.indexOf(move.charAt(0));    //column where the pawn moves from
                    result = field[line+1][x] == white;
                    if(result) {
                        field[line+1][x] = ".";
                    }
                }

        } else
            //Black
            //forward movement
            if(!capture && field[line][column] != white){
                System.out.println(3);
                for(int i = line-1; i >= (line == 3 ? line-2 : line-1); i--){
                    result = field[i][column] == black;
                    System.out.println("line = " + i + ", column = " + column);
                    System.out.println("field[i][column] = " + field[i][column]);
                    if(result) {
                        field[i][column] = ".";
                        break;
                    }
                }
            } else
                //capture
                if(capture && field[line][column] == white){
                    System.out.println(4);
                    int x = columns.indexOf(move.charAt(0));    //column where the pawn moves from
                    result = field[line-1][x] == black;
                    if(result) {
                        field[line-1][x] = ".";
                    }
                }
        if(result){
            field[line][column] = !movesSequence ? black : white;
        } else
            throw new IllegalArgumentException("It is impossible to make this move");

        return result;
    }

    private static int[] decodeMove(String move){
        if(move.length()>2){
            move = move.substring(2);
        }
        return new int[]{columns.indexOf(move.charAt(0)), lines.indexOf(move.charAt(1))};
    }



    public static void printField(){
        System.out.println("   _A_B_C_D_E_F_G_H_");
        for(int i = 0; i<8; i++){
            for(int j = 0; j < 8; j++){
                System.out.print((j == 0 ? (" " + lines.charAt(i) + "| ") : "") +
                        field[i][j] + (j==7 ? "\n" : " "));
            }
        }
    }

    private static void createField(){
        field = new String[8][8];
        for(int i = 0; i<8; i++){
            for (int j = 0; j<8; j++){
                field[i][j] = i == 1 ? black: i == 6 ? white : ".";
            }
        }
    }
}
