public class Dealership {
    
    public MakeTree makes;
    
    public Dealership(){
        this.makes = new MakeTree();
    }
    
    class DuplicateMakeName extends Exception{}
    class DuplicateCarRegistrationException extends Exception{}
    class MakeNotFoundException extends Exception{}
    class CarNotFoundException extends Exception{}
    
    public Boolean addMake(String newName) throws DuplicateMakeName{
        Make newMake = new Make(newName);
        Boolean addCheck = false;
        Boolean checker = this.makes.insert(newMake);
        if(checker == false){
            throw new DuplicateMakeName();
        }
        return checker;
  
    }
    
    public void addCar(String make) throws MakeNotFoundException, DuplicateCarRegistrationException{
        Boolean stringCheck = false;
        Make checkMake = this.makes.findMake(make);
        
        if(checkMake == null){
            throw new MakeNotFoundException();
        }
        
        String model = Input.getString("Please enter the model of the car to be added > ");
        String colour = Input.getString("Please enter the colour of the car to be added > ");
        String registration = Input.getString("Please enter the registration of the car to be added > ");
        
        stringCheck = DealershipTest.stringEmpty(model);
        if(stringCheck != true){
            stringCheck = DealershipTest.stringEmpty(colour);
            if(stringCheck != true){
                DealershipTest.stringEmpty(registration);
            }
        }
        
        if(stringCheck){
            System.out.println("Error - One of your inputs for car attributes was left empty");
        }else{
            Car newCar = new Car(model, colour, registration);

            Car checkRegistration = this.makes.findCar(newCar);

            if(checkRegistration != null){
               throw new DuplicateCarRegistrationException();
            }

            checkMake.addCar(newCar);
        }
    
    }
    
    public void removeCar(String make) throws MakeNotFoundException, CarNotFoundException{
        Make removeItem = this.makes.findMake(make);
        
        if(removeItem == null){
            throw new MakeNotFoundException();
        }
        
        String removeRegi = Input.getString("Plase enter the registration of the car you intend to remove > ");
        
        Car removeCar = new Car("testModel", "testColour", removeRegi);
        
        Car checkCar = removeItem.findCar(removeCar);
        
        if (checkCar == null){
            throw new CarNotFoundException();
        }
        
        removeItem.removeCar(checkCar);
        }
    
    public void removeMake(String make) throws MakeNotFoundException{
        Make removeItem = this.makes.findMake(make);
        
        if(removeItem == null){
            throw new MakeNotFoundException();
        }
        
        this.makes.delete(removeItem);
    }
    
    public void countMakeModel(String make) throws MakeNotFoundException{
        Make countMake = this.makes.findMake(make);
        
        if(countMake == null){
            throw new MakeNotFoundException();
        }
        
        String findModel = Input.getString("Please enter the model of car you intend to count with > ");
        
        int countModel = countMake.countModel(findModel);
        
        System.out.println("Number of " + make + " " + findModel + " cars: " + countModel);
    }
    
    public void displayMake(String make) throws MakeNotFoundException{
        Make checkMake = this.makes.findMake(make);
        
        if(checkMake == null){
            throw new MakeNotFoundException();
        }
        
        System.out.print(checkMake);
        
    }
    public String toString(){
        String result = "";
        
        result += this.makes.printInorder();
        
        if(result.equals("")){
            result += "The dealership system currently has no makes or cars. \n";
        }
        
        return result;
    
    }
}
