public class Car implements Comparable<Car>{
    
    private String model;
    private String colour;
    private String registration;
    
    public Car(String model, String colour, String registration){
        this.model = model;
        this.colour = colour;
        this.registration = registration;
    }
    
    public Boolean compareModels(String model){
        Boolean check = false;
        
        if(model.equalsIgnoreCase(this.model)){
            check = true;
        }
        
        return check;
    }
    
    @Override
    public int compareTo(Car c){
        
        int returnValue = 0;
        
        if(this.registration.equals(c.registration)){
            returnValue = 0;
        }else if(this.registration.compareTo(c.registration) > 0){
            returnValue = 1;
        }else if(this.registration.compareTo(c.registration) < 0){
            returnValue = -1;
        }
        
        return returnValue;
    }
    
    public String toString(){
        String result = "";
        
        result = String.format("\t Model: %s, Colour: %s, Registration: %s \n", this.model, this.colour, this.registration);
        
        return result;
    }
}
