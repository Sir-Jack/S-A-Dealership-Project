import java.util.ArrayList;

public class Make implements Comparable<Make>{
    
    private String title;
    private ArrayList<Car> cars;
    
    class DuplicateMakeException extends Exception{}
    
    public Make(String make){
        this.title = make;
        this.cars = new ArrayList<Car>();
    }
    
    @Override
    public int compareTo(Make m){
        
        int returnValue = 0;
        if(this.title.equals(m.title)){
            returnValue = 0;
        }else if(this.title.compareToIgnoreCase(m.title) < 0){
            returnValue = -1;
        }else{
            returnValue = 1;
        }
        
        return returnValue;
    }
    
    public void addCar(Car newCar){
        this.cars.add(newCar);
    }
    
    public Car findCar(Car newCar){
        Car checker = null;
        
        for(int i = 0; i < this.cars.size(); i++){
            if(this.cars.get(i).compareTo(newCar) == 0){
                checker = this.cars.get(i);
            }
        }
    
        return checker;
    }
    
    public void removeCar(Car removeItem){
        
        for(int i = 0; i < this.cars.size(); i++){
            if(this.cars.get(i).compareTo(removeItem) == 0){
                this.cars.remove(i);
            }
        }
        this.cars.remove(removeItem);
    }
    
    public String toString(){
        String result = "";
        String carsString = "";
        
        result = String.format("Make/Manufacturer: " + this.title + "\n");
        for(int i = 0; i < this.cars.size(); i++){
            carsString += this.cars.get(i).toString();
        }
        
        if(carsString.equals("")){
            result += "This Make has no cars associated with it. \n";
        }else{
            result += carsString;
        }
        
        return result;
    }
}
