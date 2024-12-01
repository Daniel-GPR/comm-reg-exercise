package src;

import java.util.ArrayList;
import java.util.UUID;


public class Suspect {
  public UUID id;
  private String name;
  private String codeName;
  private String location;
  private Registry reg;

  private ArrayList<String> phoneNumbers = new ArrayList<String>();


  public Suspect(String name, String codeName, String location) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.codeName = codeName;
    this.location = location;
  }

  public void setRegistry(Registry reg){
    this.reg = reg;
  }

  public void addNumber(String number){
    phoneNumbers.add(number);
  }

  public boolean equals(Suspect suspect){
    return this.id.equals(suspect.id);
  }

  public boolean ownsNumber(String number){
    return this.phoneNumbers.contains(number);
  }

  public boolean hasPartnerInCommunication(Communication comm){
    return (this.ownsNumber(comm.getNumberA()) && !this.ownsNumber(comm.getNumberB())) // owns number A and doesn't own B
      || (this.ownsNumber(comm.getNumberB()) && !this.ownsNumber(comm.getNumberA())); // owns number B and doesn't own A
  }

  public String getName(){
    return this.name;
  }

  public String getCodeName(){
    return this.codeName;
  }

  public boolean isConnectedTo(Suspect sus){
    return reg.suspectsConnected(this, sus);
  }

  
}
