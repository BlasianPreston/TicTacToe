import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    System.out.println("You are playing TicTacToe!");
    System.out.println("Player 1 will be using X and Player 2 will be using O");
    char[][] board = new char[3][3];
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = ' ';
      }
    }
    char player1 = 'X';
    char player2 = 'O';
    boolean checkWin = false;
    boolean checkDraw = false;
    int x = 0;
    int y = 0;
    boolean invalid = false;
    while (!checkWin && !checkDraw) {
      display(board);
      System.out.println("Player 1, please enter the x coordinate: ");
      x = sc.nextInt();
      System.out.println("Player 1, please enter the y coordinate: ");
      y = sc.nextInt();
      if (available(board, x, y)) {
        place(board, x, y, player1);
      }
      else {
        invalid = true;
        while (invalid == true) {
          System.out.println("Invalid Input");
          System.out.println("Player 1, please enter the x coordinate: ");
          x = sc.nextInt();
          System.out.println("Player 1, please enter the y coordinate: ");
          y = sc.nextInt();
          invalid = available(board, x, y);
        }
      }
      
      checkWin = win(board, player1);
      checkDraw = draw(board);
      if (checkWin == true) {
        display(board);
        System.out.println("Player 1 has won! Congrats!");
        break;
      }
      if (checkDraw == true) {
        display(board);
        System.out.println("The game has ended in a draw");
        break;
      }

      display(board);
      System.out.println("Player 2, please enter the x coordinate: ");
      x = sc.nextInt();
      System.out.println("Player 2, please enter the y coordinate: ");
      y = sc.nextInt();
      if (available(board, x, y)) {
        place(board, x, y, player2);
      }
      else {
        invalid = true;
        while (invalid == true) {
          System.out.println("Invalid Input");
          System.out.println("Player 2, please enter the x coordinate: ");
          x = sc.nextInt();
          System.out.println("Player 2, please enter the y coordinate: ");
          y = sc.nextInt();
          invalid = available(board, x, y);
        }
      }

      checkWin = win(board, player2);
      checkDraw = draw(board);
      if (checkWin == true) {
        display(board);
        System.out.println("Player 2 has won! Congrats!");
        break;
      }
      if (checkDraw == true) {
        display(board);
        System.out.println("The game has ended in a draw");
        break;
      }
    }
  }
  public static void display(char[][] arr) {
    System.out.print("- ");
      for (int i = 0; i < 3; i++) {
        System.out.print(i + " ");
      }
      System.out.println("-");
      for (int i = 0; i < 3; i ++) {
        System.out.print("-|");
        for (int j = 0; j < 3; j++) {
          System.out.print(arr[i][j] + "|");
        }
      System.out.println("-");
    }
    for (int i = 0; i < 5; i++) {
      System.out.print("- ");
    }
    System.out.println();
  }
  public static boolean win(char[][] arr, char symbol) {
    for (int i = 0; i < 3; i++) {
      if (arr[i][0] == symbol && arr[i][1] == symbol && arr[i][2] == symbol)
        return true;
    }
    for (int i = 0; i < 3; i++) {
      if (arr[0][i] == symbol && arr[1][i] == symbol && arr[2][i] == symbol)
        return true;
    }
    if (arr[0][0] == symbol && arr[1][1] == symbol && arr[2][2] == symbol)
      return true;
    if (arr[0][2] == symbol && arr[1][1] == symbol && arr[2][0] == symbol)
      return true;
    return false;
  }
  public static boolean available(char[][] arr, int xpos, int ypos) {
    if (arr[xpos][ypos] != ' ')
      return false;
    return true;
  }
  public static boolean draw(char[][] arr) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (arr[i][j] != ' ')
          return false;
      }
    }
    return true;
  }
  public static void place(char[][] arr, int xpos, int ypos, char symbol) {
    if (available(arr, xpos, ypos)) {
      arr[xpos][ypos] = symbol;
    }
    else {
      System.out.println("That space is not available");
    }
  }
}