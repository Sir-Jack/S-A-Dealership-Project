
public class DealershipTest {
    
    class FalseUserInputException extends Exception{}
    
    public static void main(String[] args) {
        Dealership dealer = new Dealership();
        String menuOption = "0";
        Boolean leaveSystem = false;
        
        do{
            System.out.println("------------------------------");
            System.out.println("Dealership Management System");
            System.out.println("1. Add Make/Manufacturer");
            System.out.println("2. Remove Make/Manufacturer");
            System.out.println("3. Diplay the entire Dealership system");
            System.out.println("0. Close System");
            System.out.println("------------------------------");
            
            menuOption = Input.getString("Please enter your menu option (0 - 3)> ");
            Boolean stringCheck = false;
            
            switch(menuOption){
                case "1":
                    String newMake = Input.getString("Please enter the make/manufacturer you intend to add > ");
                    newMake = newMake.trim();
                    stringCheck = stringEmpty(newMake);
                    if(stringCheck){
                        System.out.println("Error - User input cannot be blank.");
                    }else{
                        try{
                            dealer.addMake(newMake);
                            System.out.println("The make " + newMake + " has been successfully added.");
                        }catch(Dealership.DuplicateMakeName e){
                            System.out.println("Error - The make already exists inside the system.");
                        }
                    }
                    break;
                case "2":
                    String removeMake = Input.getString("Please enter the make/manufacturer you would like to remove > ");
                    stringCheck = stringEmpty(removeMake);
                    if(stringCheck){
                        System.out.println("Error - User input cannot be blank.");
                    }else{
                        try{
                            dealer.removeMake(removeMake);
                            System.out.println("Make "+removeMake+" was successfully removed.");
                        }catch(Dealership.MakeNotFoundException e){
                            System.out.println("Error - The make you attempted to remove does not exist in the system.");
                        }
                    }
                    break;
                case "3":
                    System.out.print(dealer);
                    break;
                case "0":
                    String leaveConfirm = Input.getString("Are you sure you want to leave the system? (Y/N) > ");
                    stringCheck = stringEmpty(leaveConfirm);
                    if(leaveConfirm.equalsIgnoreCase("y")){
                        leaveSystem = true;
                    }else if(leaveConfirm.equalsIgnoreCase("n") != true){
                        System.out.println("Error - This is not valid user input.");
                    }
                    break;
                default :
                    System.out.println("Error - A valid menu option was not entered.");
                    break;
            }
        
        }while(leaveSystem != true);
        
    }
    
    public static Boolean stringEmpty(String string){
        Boolean stringCheck = false;
        
        if(string.equals("")){
            stringCheck = true;
        }
        
        return stringCheck;
    }
}
