package src;

public class SMS extends Communication {

  private String message;

  SMS(String numberA, String numberB, int day, int month, int year, String message){

    super(numberA, numberB, day, month, year);
    
    this.message = message;
  }

  public String getMessage(){
    return this.message;
  }

  public void printInfo(){
    Util.println("This SMS has the following info");
    Util.println(String.format("Between %s --- %s", this.getNumberA(), this.getNumberB()));
    Util.println(String.format("on %d/%d/%d", this.year, this.month, this.day));
    Util.println(String.format("Text: %s", this.message));
  }
  
}
