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
