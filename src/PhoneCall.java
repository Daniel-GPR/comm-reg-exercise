package src;

public class PhoneCall extends Communication {

  private int callDuration;

  PhoneCall(String numberA, String numberB, int day, int month, int year, int callDuration){

    super(numberA, numberB, day, month, year);
    
    this.callDuration = callDuration;
  }

  public int getCallDuration(){
    return this.callDuration;
  }

  public void printInfo() {
    Util.println("This phone call has the following info");
    Util.println(String.format("Between %s --- %s", this.getNumberA(), this.getNumberB()));
    Util.println(String.format("on %d/%d/%d", this.year, this.month, this.day));
    Util.println(String.format("Duration: %d", this.callDuration));
  }
  
}
