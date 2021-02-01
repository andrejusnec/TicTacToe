package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello Dear User! Lets play TicTacToe!");
        System.out.println("Enter the amount of squares you want to play on");
        System.out.println("*Notice: Possible amounts are from 3 to 9");
        int fieldNumbers = 0;
        while (fieldNumbers == 0) {
            try {
                fieldNumbers = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException smth) {
                System.out.print("You have entered not a number. Try again: ");
            }

            if (fieldNumbers < 3 || fieldNumbers > 9) {
                System.out.println("");
                System.out.println("Please enter numbers from 3 to 9");
                fieldNumbers = 0;

            }
        }
        /**
         * ***************************************************************
         */
        char[][] field = new char[fieldNumbers][fieldNumbers];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = '_';
            }
        }
        //Spausdinu tuscia fielda
        printAll(field);

        boolean endGame = true;
        boolean endGame2 = true;
        boolean endGame3 = true;
        boolean endGame4 = true;
        int turns = 0;
        int maxTurns = fieldNumbers * fieldNumbers;
        double random = Math.random();
        int xMove = 0;
        int yMove = 0;
        // Kas pirmas pradeda
        if (random <= 0.5) {
            System.out.println("Player starts first!");
            while (turns < maxTurns && endGame && endGame2 && endGame3 && endGame4) {
                System.out.println("Your move");
                //priskiriu reiksmes
                xMove = playerMoveX(fieldNumbers);
                yMove = playerMoveY(fieldNumbers);
                //
                char freeSpace = '_';
                boolean repeat = true;
                while (repeat) {
                    if (field[xMove - 1][yMove - 1] == freeSpace) {
                        field[xMove - 1][yMove - 1] = 'X';
                        repeat = false;
                        break;

                    } else {
                        System.out.println("That spot is taken, choose another coordinates");
                        xMove = playerMoveX(fieldNumbers);
                        yMove = playerMoveY(fieldNumbers);
                    }
                }
                turns++; // paejo zaidejas
                //tikrinu ar yra laimetojas 
                endGame = arLaimejoH(field);
                endGame2 = arLaimejoV(field);
                endGame3 = arLaimejoIst(field);
                endGame4 = arLaimejoIsl(field);

                if (endGame && endGame2 && endGame3 && endGame4) {
                    PCmove(field);
                    turns++; // paejo pc
                    endGame = arLaimejoH(field);
                    endGame2 = arLaimejoV(field);
                    endGame3 = arLaimejoIst(field);
                    endGame4 = arLaimejoIsl(field);
                }
                printAll(field);
                System.out.println("*************************");

            }
            //printAll(field);
        } else {
            System.out.println("PC starts first!");
            while (turns < maxTurns && endGame && endGame2 && endGame3 && endGame4) {
                PCmove(field);
                turns++; // paejo pc
                endGame = arLaimejoH(field);
                endGame2 = arLaimejoV(field);
                endGame3 = arLaimejoIst(field);
                endGame4 = arLaimejoIsl(field);
                printAll(field);
                System.out.println("*************************");
                if (endGame && endGame2 && endGame3 && endGame4) {
                    System.out.println("Your move");
                    //priskiriu reiksmes
                    xMove = playerMoveX(fieldNumbers);
                    yMove = playerMoveY(fieldNumbers);
                    //
                    char freeSpace = '_';
                    boolean repeat = true;
                    while (repeat) {
                        if (field[xMove - 1][yMove - 1] == freeSpace) {
                            field[xMove - 1][yMove - 1] = 'X';
                            repeat = false;
                            break;

                        } else {
                            System.out.println("That spot is taken, choose another coordinates");
                            xMove = playerMoveX(fieldNumbers);
                            yMove = playerMoveY(fieldNumbers);
                        }
                    }
                    turns++; // paejo zaidejas
                    //tikrinu ar yra laimetojas 
                    endGame = arLaimejoH(field);
                    endGame2 = arLaimejoV(field);
                    endGame3 = arLaimejoIst(field);
                    endGame4 = arLaimejoIsl(field);
                }
                printAll(field);
                System.out.println("*************************");

            }
        }
    }

    /**
     * ***************************METODAI*****************************
     */
    public static boolean arLaimejoV(char[][] field) {
        char player = 'X';
        char pc = 'O';
        for (int i = 0; i < field.length - 2; i++) { // field[0] = 3
            for (int a = 0; a < field.length; a++) {
                if (field[i][a] == player && field[i + 1][a] == player && field[i + 2][a] == player) {
                    System.out.println("Laimejo zmogutis");
                    return false;
                }
                if (field[i][a] == pc && field[i + 1][a] == pc && field[i + 2][a] == pc) {
                    System.out.println("Laimejo kompukteris");
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean arLaimejoH(char[][] field) {
        char player = 'X';
        char pc = 'O';
        for (int i = 0; i < field.length; i++) { // field[0] = 3
            for (int a = 0; a < field.length - 2; a++) {
                if (field[i][a] == player && field[i][a + 1] == player && field[i][a + 2] == player) {
                    System.out.println("Laimejo zmogutis");
                    return false;
                }
                if (field[i][a] == pc && field[i][a + 1] == pc && field[i][a + 2] == pc) {
                    System.out.println("Laimejo kompukteris");
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean arLaimejoIst(char[][] field) {
        char player = 'X';
        char pc = 'O';
        for (int i = 0; i < field.length - 2; i++) {
            for (int a = 0; a < field.length - 2; a++) {
                if (field[i][a] == player && field[i + 1][a + 1] == player && field[i + 2][a + 2] == player) {
                    System.out.println("Laimejo Human");
                    return false;
                }
                if (field[i][a] == pc && field[i + 1][a + 1] == pc && field[i + 2][a + 2] == pc) {
                    System.out.println("Hale before mighty kompukter");
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean arLaimejoIsl(char[][] field) {
        char player = 'X';
        char pc = 'O';
        for (int i = 0; i < field.length - 2; i++) {
            for (int a = 2; a < field.length ; a++) {
                if (field[i][a] == player && field[i + 1][a - 1] == player && field[i + 2][a - 2] == player) {
                    System.out.println("Laimejo Human");
                    return false;
                }
                if (field[i][a] == pc && field[i+1][a + 1] == pc && field[i+2][a + 2] == pc) {
                    System.out.println("Hale before mighty kompukter");
                    return false;
                } 
            }
        }
        return true;
    }

    public static void PCmove(char[][] field) {
        boolean flag2 = true;
        char empty = '_';
        int pcmoveX = Math.round((int) (Math.random() * 3 + 1));
        int pcmoveY = Math.round((int) (Math.random() * 3 + 1));
        while (flag2) {
            if (field[pcmoveX - 1][pcmoveY - 1] == empty) {
                field[pcmoveX - 1][pcmoveY - 1] = 'O';
                flag2 = false;
            } else {
                pcmoveX = Math.round((int) (Math.random() * 3 + 1));
                pcmoveY = Math.round((int) (Math.random() * 3 + 1));
            }

        }

    }

    public static void printAll(char[][] masyvas) {
        for (int i = 0; i < masyvas.length; i++) {
            for (int j = 0; j < masyvas.length; j++) {
                System.out.print("|");
                System.out.print(masyvas[i][j]);
                System.out.print("|");
            }
            System.out.println("");
        }
    }

    public static int check(int fieldNumbers) {
        Scanner sc = new Scanner(System.in);
        int xMove = 0;
        while (xMove == 0) {
            try {
                xMove = Integer.parseInt(sc.nextLine());

            } catch (Exception e) {
                System.out.print("Try again: ");
            }
            if (xMove <= 0 || xMove > fieldNumbers) {
                System.out.println("");
                System.out.println("Enter numbers from " + 1 + " to " + fieldNumbers
                        + " and try again!");
                System.out.println("");
                xMove = 0;
            }
        }
        return xMove;
    }

    public static int playerMoveX(int fieldNumbers) {
        System.out.println("Enter coordinate of X: ");
        int xMove = check(fieldNumbers);
        return xMove;
    }

    public static int playerMoveY(int fieldNumbers) {
        System.out.println("Enter coordinate of Y: ");
        int yMove = check(fieldNumbers);
        return yMove;
    }

}
