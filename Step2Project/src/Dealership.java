import java.util.ArrayList;

public class Dealership {
    
    public ArrayList<Make> makes;
    
    public Dealership(){
        this.makes = new ArrayList<Make>();
    }
    
    class DuplicateMakeName extends Exception{}
    class DuplicateCarRegistrationException extends Exception{}
    class MakeNotFoundException extends Exception{}
    class CarNotFoundException extends Exception{}
    
    public void addMake(String newName) throws DuplicateMakeName{
        Make newMake = new Make(newName);
        Boolean addCheck = true;
        
        for (int i = 0; i < this.makes.size(); i++) {
            if(this.makes.get(i).compareTo(newMake) == 0){
                addCheck = false;
            }
        }
        
        if(addCheck == false){
            throw new DuplicateMakeName();
        }
        
        this.makes.add(newMake);
  
    }
    
    public void addCar(String make) throws MakeNotFoundException, DuplicateCarRegistrationException{
        Boolean stringCheck = false;
        Make checkMake = new Make(make);
        Boolean addCheck = false;
        
        for (int i = 0; i < this.makes.size(); i++) {
            if(this.makes.get(i).compareTo(checkMake) == 0){
                addCheck = true;
                checkMake = this.makes.get(i);
            }
        }
        
        if(addCheck == false){
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
            Boolean checkRegi = true;
            for(int i = 0; i < this.makes.size(); i++){
                if(this.makes.get(i).findCar(newCar) != null){
                    checkRegi = false;
                }
            }
            if(checkRegi == false){
               throw new DuplicateCarRegistrationException();
            }

            checkMake.addCar(newCar);
        }
    
    }
    
    public void removeCar(String make) throws MakeNotFoundException, CarNotFoundException{
        Make removeMake = new Make(make);
        Boolean removeCheck = false;
        int removePos = 0;
        
        for (int i = 0; i < this.makes.size(); i++) {
            if(this.makes.get(i).compareTo(removeMake) == 0){
                removeCheck = true;
                removeMake = this.makes.get(i);
            }
        }
        if(removeCheck == false){
            throw new MakeNotFoundException();
        }
        
        String removeRegi = Input.getString("Plase enter the registration of the car you intend to remove > ");
        
        Car removeCar = new Car("testModel", "testColour", removeRegi);
        
        Car checkCar = removeMake.findCar(removeCar);
        
        if (checkCar == null){
            throw new CarNotFoundException();
        }
        
        removeMake.removeCar(checkCar);
        }
    
    public void removeMake(String make) throws MakeNotFoundException{
        Make removeMake = new Make(make);
        Boolean removeCheck = false;
        int removePos = 0;
        
        for (int i = 0; i < this.makes.size(); i++) {
            if(this.makes.get(i).compareTo(removeMake) == 0){
                removeCheck = true;
                removePos = i;
            }
        }
        
        if(removeCheck == false){
            throw new MakeNotFoundException();
        }
        
        this.makes.remove(removePos);
    }
    
    public void displayMake(String make) throws MakeNotFoundException{
        Boolean checkMake = false;
        Make testMake = new Make(make);
        
        for(int i = 0; i < this.makes.size(); i++){
            if(this.makes.get(i).compareTo(testMake) == 0){
                checkMake = true;
                testMake = this.makes.get(i);
            }
        }
        
        if(checkMake == false){
            throw new MakeNotFoundException();
        }
        
        System.out.print(testMake);
        
    }
    public String toString(){
        String result = "";
        
        for(int i = 0; i < this.makes.size(); i++){
            result += this.makes.get(i).toString(); 
        }
        
        if(result.equals("")){
            result += "The dealership system currently has no makes or cars. \n";
        }
        
        return result;
    
    }
}
