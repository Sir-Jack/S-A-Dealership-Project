
public class DealershipTest {
    
    class FalseUserInputException extends Exception{}
    
    public static void main(String[] args) {
        Dealership dealer = new Dealership();
        Integer menuOption = 0;
        Boolean leaveSystem = false;
        
        do{
            System.out.println("------------------------------");
            System.out.println("Dealership Management System");
            System.out.println("1. Add Make/Manufacturer");
            System.out.println("2. Remove Make/Manufacturer");
            System.out.println("3. Add Car to System");
            System.out.println("4. Remove Car from System");
            System.out.println("5. Display number of Car Model & Make combination");
            System.out.println("6. Diplay a Makes details(including cars)");
            System.out.println("7. Diplay the entire Dealership system");
            System.out.println("0. Close System");
            System.out.println("------------------------------");
            
            menuOption = Input.getInteger("Please enter your menu option (0 - 7)> ");
            Boolean stringCheck = false;
            
            switch(menuOption){
                case 1:
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
                case 2:
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
                case 3:
                    String addPoint = Input.getString("Please enter the make of the car you intend to add to the system > ");
                    stringCheck = stringEmpty(addPoint);
                    if(stringCheck){
                        System.out.println("Error - User input cannot be blank.");
                    }else{
                        try{
                            dealer.addCar(addPoint);
                            System.out.println("Car was successfully added.");
                        }catch(Dealership.MakeNotFoundException e){
                            System.out.println("Error - Make selected was not found in system.");
                        }catch(Dealership.DuplicateCarRegistrationException e){
                            System.out.println("Error - The registration selected is already in use.");
                        }
                    }
                    break;
                case 4:
                    String removeCar = Input.getString("Please enter the make/manufacturer you would like to remove from > ");
                    try{
                        dealer.removeCar(removeCar);
                        System.out.println("Car was successfully removed.");
                    }catch(Dealership.MakeNotFoundException e){
                        System.out.println("Error - The Make you attempted to remove from does not exist in the system.");
                    }catch(Dealership.CarNotFoundException e){
                        System.out.println("Error - The Car you attempted to remove does not exist in the system.");
                    }
                    break;
                case 5:
                    String findMake = Input.getString("Please enter the make that you will be counting the number of > ");
                    try{
                        dealer.countMakeModel(findMake);
                    }catch(Dealership.MakeNotFoundException e){
                        System.out.println("Error - The Make you attempted to count with does not exist in the system.");
                    }
                    break;
                case 6:
                    String checkMake = Input.getString("Please enter the make that you wish to view the details of > ");
                    try{
                        dealer.displayMake(checkMake);
                    }catch(Dealership.MakeNotFoundException e){
                        System.out.println("Error - The Make you attempted to display does not exist in the system.");
                    }
                    break;
                case 7:
                    System.out.print(dealer);
                    break;
                case 0:
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
