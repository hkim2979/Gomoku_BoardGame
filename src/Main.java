import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] board = new int[21][21];

        boolean gameStart = true;

        while(gameStart) {
            Scanner menuNum = new Scanner(System.in);
            System.out.println("┌───────────────────────────┐");
            System.out.println("│        Play Gomoku        │");
            System.out.println("└───────────────────────────┘");
            System.out.println();
            System.out.println("1 - GAME START");
            System.out.println("2 - RULES");
            System.out.println("3 - QUIT");
            System.out.println();
            System.out.print("ENTER: ");
            int select = menuNum.nextInt();

            switch (select) {
                //Game Play
                case 1: {
                    int gameState = 0;
                    int playerNum = 0;


                    while(gameState == 0) {
                        gameBoard(board);

                        System.out.println();

                        if (playerNum == 1) {
                            playerNum = 2;
                        } else {
                            playerNum = 1; //player turn will start from 1
                        }
                        gameState = gamePlay(playerNum, board);
                    }

                    System.out.println();
                    System.out.println("GAME RESULT");
                    System.out.println();
                    gameBoard(board);
                    System.out.println();
                    System.out.println("─────────────────────────────");
                    System.out.println();
                } break;
                //RULES
                case 2: {
                    System.out.println("Input numbers on the 19x19 game board at positions X and Y");
                    System.out.println("Your goal is to connect 5 in any direction");
                    System.out.println("Connection of 6 is not possible");
                    break;
                }
                //QUIT
                case 3: {
                    System.out.println("GOOD BYE");
                    System.out.println();
                    gameStart = false;
                    break;
                }
            }
        }

    }
    public static int gamePlay(int playerNum, int[][] board) {
        Scanner input = new Scanner(System.in);

        int x;
        int y;

        System.out.println("Player " + playerNum);

        System.out.print("X input: ");
        x = input.nextInt();
        System.out.print("Y input: ");
        y = input.nextInt();

        if(x >= board.length || y >= board.length) {
            System.out.println("Out of bound, re-enter");
            return gamePlay(playerNum, board);
        }

        int checkX = x;
        int checkY = y;

        //Duplicate Check
        if(board[checkX][checkY] != 0) {
            System.out.println("Already placed, re-enter");
            return gamePlay(playerNum, board);
        } else {
            board[checkX][checkY] = playerNum;
        }

        for(int i = 0; i < board.length; i++) {
            int wh_col_cnt = 0;
            int bl_col_cnt = 0;
            int wh_row_cnt = 0;
            int bl_row_cnt = 0;

            for(int j = 0; j < board.length; j++) {
                //Check left to Right
                if(board[i][j] == 1) {
                    if(wh_col_cnt == 5) {
                        System.out.println("winner is player 2");
                        System.out.println("CONGRATULATION");
                        System.out.println();
                        return 1;
                    }
                    wh_col_cnt = 0;
                    bl_col_cnt++;
                } else if(board[i][j] == 2) {
                    if(bl_col_cnt == 5) {
                        System.out.println("winner is player 1");
                        System.out.println("CONGRATULATION");
                        System.out.println();
                        return 1;
                    }
                    wh_col_cnt++;
                    bl_col_cnt = 0;
                } else {
                    if(wh_col_cnt == 5) {
                        System.out.println("winner is player 2");
                        System.out.println("CONGRATULATION");
                        System.out.println();
                        return 1;
                    }
                    if(bl_col_cnt == 5) {
                        System.out.println("winner is player 1");
                        System.out.println("CONGRATULATION");
                        System.out.println();
                        return 1;
                    }
                    wh_col_cnt = 0;
                    bl_col_cnt = 0;
                }
                //Check up to down
                if(board[j][i] == 1) {
                    if(wh_row_cnt == 5) {
                        System.out.println("winner is player 2");
                        System.out.println("CONGRATULATION");
                        System.out.println();
                        return 1;
                    }
                    wh_row_cnt = 0;
                    bl_row_cnt++;
                } else if(board[j][i] == 2) {
                    if(bl_row_cnt == 5) {
                        System.out.println("winner is player 1");
                        System.out.println("CONGRATULATION");
                        System.out.println();
                        return 1;
                    }
                    wh_row_cnt++;
                    bl_row_cnt = 0;
                } else {
                    if(wh_row_cnt == 5) {
                        System.out.println("winner is player 2");
                        System.out.println("CONGRATULATION");
                        System.out.println();
                        return 1;
                    }
                    if(bl_row_cnt == 5) {
                        System.out.println("winner is player 1");
                        System.out.println("CONGRATULATION");
                        System.out.println();
                        return 1;
                    }
                    wh_row_cnt = 0;
                    bl_row_cnt = 0;
                }
            }
        }

        //Diagonal - left bottom to up right
        for(int i = 0, j = 0; j < board.length; ) {
            int wh_right_diag_cnt = 0;
            int bl_right_diag_cnt = 0;
            int xx = i, yy = j;
            while(xx >= 0 && yy < board.length) {
                if(board[xx][yy] == 1) {
                    if(wh_right_diag_cnt == 5) {
                        System.out.println("winner is player 2");
                        System.out.println("CONGRATULATION");
                        System.out.println();
                        return 1;
                    }
                    wh_right_diag_cnt = 0;
                    bl_right_diag_cnt ++;

                } else if(board[xx][yy] == 2) {
                    if(bl_right_diag_cnt == 5) {
                        System.out.println("winner is player 1");
                        System.out.println("CONGRATULATION");
                        System.out.println();
                        return 1;
                    }
                    wh_right_diag_cnt++;
                    bl_right_diag_cnt = 0;

                } else {
                    if(wh_right_diag_cnt == 5) {
                        System.out.println("winner is player 2");
                        System.out.println("CONGRATULATION");
                        System.out.println();
                        return 1;
                    }
                    if(bl_right_diag_cnt == 5) {
                        System.out.println("winner is player 1");
                        System.out.println("CONGRATULATION");
                        System.out.println();
                        return 1;
                    }
                    wh_right_diag_cnt = 0;
                    bl_right_diag_cnt = 0;
                }
                xx--;
                yy++;
            }
            if(i == board.length - 1) {
                j++;
            } else {
                i++;
            }
        }
        //Diagonal - bottomRight to leftTop
        for(int i = 0, j = board.length - 1; j >= 0; ) {
            int wh_left_diag_cnt = 0;
            int bl_left_diag_cnt = 0;
            int xx = i, yy = j;
            while(xx >= 0 && yy >= 0) {
                if(board[xx][yy] == 1) {
                    if(wh_left_diag_cnt == 5) {
                        System.out.println("winner is player 2");
                        System.out.println("CONGRATULATION");
                        System.out.println();
                        return 1;
                    }
                    wh_left_diag_cnt = 0;
                    bl_left_diag_cnt ++;

                } else if(board[xx][yy] == 2) {
                    if(bl_left_diag_cnt == 5) {
                        System.out.println("winner is player 1");
                        System.out.println("CONGRATULATION");
                        System.out.println();
                        return 1;
                    }
                    wh_left_diag_cnt++;
                    bl_left_diag_cnt = 0;

                } else {
                    if(wh_left_diag_cnt == 5) {
                        System.out.println("winner is player 2");
                        System.out.println("CONGRATULATION");
                        System.out.println();
                        return 1;
                    }
                    if(bl_left_diag_cnt == 5) {
                        System.out.println("winner is player 1");
                        System.out.println("CONGRATULATION");
                        System.out.println();
                        return 1;
                    }
                    wh_left_diag_cnt = 0;
                    bl_left_diag_cnt = 0;
                }
                xx--;
                yy--;
            }
            if(i == board.length - 1) {
                j--;
            } else {
                i++;
            }
        }

        return 0;
    }
    public static void gameBoard(int[][] board) {
        System.out.print("   ");
        for(int row = 0; row < 20; row++) {
            if(row > 0) {
                if(row < 10) {
                    System.out.print(row + "  ");
                } else {
                    System.out.print(row + " ");
                }
            }
            for(int col = 1; col < 20; col++) {
                if(row == 0) {
                    if(col < 10) {
                        System.out.print(col + "  ");
                    } else {
                        System.out.print(col + " ");
                    }
                } else {
                    System.out.print(board[row][col] + "  ");
                }
            }
            System.out.println();
        }
    }
}