public class Make implements Comparable<Make>{
    
    private String title;
    private CarTree cars;
    
    class DuplicateMakeException extends Exception{}
    
    public Make(String make){
        this.title = make;
        this.cars = new CarTree();
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
    
    public Boolean addCar(Car newCar){
        Boolean checker = this.cars.insert(newCar);
        
        return checker;
    }
    
    public Car findCar(Car newCar){
        Car checker = this.cars.findCar(newCar);
    
        return checker;
    }
    
    public void removeCar(Car removeItem){
        this.cars.delete(removeItem);
    }
    
    public int countModel(String model){
        int modelCount = 0;
        
        modelCount = this.cars.countModel(model);
        
        return modelCount;
    }
    public String toString(){
        String result = "";
        String carsString = "";
        
        result = String.format("Make/Manufacturer: " + this.title + "\n");
        carsString += this.cars.printInorder();
        
        if(carsString.equals("")){
            result += "This Make has no cars associated with it. \n";
        }else{
            result += carsString;
        }
        
        return result;
    }
}
