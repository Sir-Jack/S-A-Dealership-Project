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
