package src;

import java.util.ArrayList;

public class Registry {

  ArrayList<Suspect> suspects = new ArrayList<Suspect>();
  ArrayList<SMS> messages = new ArrayList<SMS>();
  ArrayList<PhoneCall> calls = new ArrayList<PhoneCall>();

  
  public void addSuspect(Suspect suspect){
    if(suspectExistsInList(suspect, this.suspects)){
      Util.println("Suspect already exists in registry");
      return;
    }
    suspect.setRegistry(this);
    suspects.add(suspect);
  }

  public void addCommunication(Communication comm){
    if (comm instanceof PhoneCall) {
      calls.add((PhoneCall) comm);
    }else if(comm instanceof SMS){
      messages.add((SMS) comm);
    }
  }


  boolean suspectExistsInList(Suspect susp, ArrayList<Suspect> list){
    for(Suspect suspect : list){
      if(suspect.equals(susp)){
        return true;
      }
    }
    return false;
  }

  public int getTotalPartners(Suspect suspect){
    int total = 0;

    // iterate through messages
    for(SMS message : this.messages){
      if(suspect.hasPartnerInCommunication(message)){
        total++;
      }
    }

    // iterate through phone calls
    for(PhoneCall call : this.calls){
      if(suspect.hasPartnerInCommunication(call)){
        total++;
      }
    }

    return total;
  }

  public Suspect getSuspectWithMostPartners(){
    Suspect topSuspect = suspects.get(0);
    int maxPartners = 0;
    for(Suspect suspect : this.suspects){
      int partnerCount = getTotalPartners(suspect);
      if(partnerCount >= maxPartners ){
        maxPartners = partnerCount;
        topSuspect = suspect;
      }
    }

    return topSuspect;

  }  

  public PhoneCall getLongestPhoneCallBetween(String numberA , String numberB){
    PhoneCall longestCall = calls.get(0);

    for(PhoneCall call : this.calls){
      if(call.numbersMatch(numberA, numberB) && call.getCallDuration() >= longestCall.getCallDuration()){
        longestCall = call;
      }
    } 

    return longestCall;
  }


  public ArrayList<SMS> getMessagesBetween(String numberA , String numberB){
    ArrayList<SMS> commonMessages = new ArrayList<SMS>();

    for(SMS msg : this.messages){
      if(msg.numbersMatch(numberA, numberB)){
        commonMessages.add(msg);
      }
    } 

    return commonMessages;
  }

  public boolean suspectsConnected(Suspect s1, Suspect s2){
    for(PhoneCall call : this.calls){
      if((s1.ownsNumber(call.getNumberA()) && s2.ownsNumber(call.getNumberB())) || (s2.ownsNumber(call.getNumberA()) && s1.ownsNumber(call.getNumberB()))){
        return true;
      } 
    } 
    for(SMS msg : this.messages){
      if((s1.ownsNumber(msg.getNumberA()) && s2.ownsNumber(msg.getNumberA())) || (s2.ownsNumber(msg.getNumberA()) && s1.ownsNumber(msg.getNumberA()))){
        return true;
      } 
    } 
    
    return false;
  }


}
