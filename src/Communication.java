package src;
import java.util.UUID;


public class Communication {
  private UUID id;
  private String numberA;
  private String numberB;
  public int day;
  public int month;
  public int year;


  Communication(String numberA, String numberB, int day, int month, int year) {
    this.id = UUID.randomUUID();

    this.numberA = numberA;
    this.numberB = numberB;
    this.day = day;
    this.month = month;
    this.year = year;
 }

 public String getNumberA(){
  return this.numberA;
 }

 public String getNumberB(){
  return this.numberB;
 }

 public boolean numbersMatch(String numberA, String numberB){
  return (numberA.equals(this.numberA) && numberB.equals(this.numberB)) || (numberB.equals(this.numberA) && numberA.equals(this.numberB));
 }

}
