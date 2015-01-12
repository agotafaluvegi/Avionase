import java.util.ArrayList;

/**
 * Write a description of class Avionase here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Avionase 
{
    
    private ArrayList<String> location = new ArrayList<String>();
    private String name;
    private int size;
    
    public Avionase(String name, int size)
    {
        this.name = name;
        this.size = size;
    }
    
    public ArrayList<String> getLocations()
    {
        return location;
    }
    
    public int getSize()
    {
        return size;
    }
    
    public void setLocation(ArrayList<String> locationToSet)
    {
        this.location.addAll(locationToSet);
    }
    
    public String check(String guess)
    {
        String result = "miss";
        if (location.contains(guess))
        {
            location.remove(guess);
            result = location.isEmpty() ? "kill" : "hit";
        }
        return result;
    }
    
    public String getName()
    {
        return name;
    }
}