package src;

public class Util {

  interface ConstraintsFunctions {
    interface stringConstraint {
      public boolean constraint(String input);
    }

    interface intConstraint {
      public boolean constraint(int input);
    }
  }

  public static int stringToInt(String number) {
    return Integer.parseInt(number);
  }

  public static void println(String message) {
    System.out.println(message);
  }

  public static void print(String message) {
    System.out.print(message);
  }

}