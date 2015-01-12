import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game 
{
    private ArrayList<Avionase> avionase = new ArrayList<Avionase>();
    int numGuess = 0;
    
    public static void main(String[] args)
    {
        Game game = new Game();
        game.setUp();
    }
    
       private void setUp()
    {
        avionase.add(new Avionase("Fighter", 3));
        avionase.add(new Avionase("Bomber", 3));
        avionase.add(new Avionase("Attack",3));
        setLocation();
        
        System.out.println("Welcome to the Avionase game /nyour goal is to kill all of the planes as fast as possible /ngood luck");
        play();
    }
    
    private void play()
    {
        String guess, result;
        Scanner input = new Scanner(System.in);
        while (!avionase.isEmpty())
        {
            result="miss";
            numGuess++;
            System.out.println("Enter a guess");
            guess = input.nextLine();
            guess = guess.toUpperCase();
            for (int i = 0; i<avionase.size(); i++)
            {
                result = avionase.get(i).check(guess);
                if (result.equals("kill"))
                {
                    result = ("You killed "+avionase.get(i).getName());
                    avionase.remove(i);
                    break;
                }
                else if (result.equals("hit"))
                {
                    break;
                }
            }
            System.out.println(result);
        }
        input.close();//close scanner
        finish();
    }
    
    private void finish()
    {
        if(numGuess == 9)
        {
            System.out.println("Congratulations! You got a perfect score!");
        }
        else if (numGuess < 20)
        {
            System.out.println("Congratulations! You did it great! It took you "+numGuess+" guesses.");
            
        }
        else if (numGuess < 30)
        {
            System.out.println("You did so so, it took you "+numGuess+" guesses. Maybe you will do better next time");
        }
        else
        {
            System.out.println("It took you "+numGuess+" guesses");
        }
    }
    
    private void setLocation()
    {
        Random rand = new Random();
        ArrayList<String> locationToSet = new ArrayList<String>();
        ArrayList<String> temp = null;
        int letter,number, incLetter, incNumber;
        String alpha = "ABCDEFG";
        boolean worked;
        for (int i = 0; i< avionase.size(); i++)
        {
            worked = false;
            start:
            while(!worked)
            {
                locationToSet.clear();//clear the location setter
                worked = true;
                letter = rand.nextInt(5);
                number = 1 + rand.nextInt(5);
                //this code will figure out wheter to put the avionase, vertical or horizontal
                if (number % 2 == 0)
                {
                    incLetter = 1; //vertical;
                    incNumber = 0; 
                }
                else 
                {
                    incLetter = 0;
                    incNumber = 1; //horizontal
                } //close if
                
                for (int j = 0; j < avionase.get(i).getSize(); j++)
                {
                    String loc = "" + alpha.charAt(letter) + number;
                    letter += incLetter;
                    number += incNumber;
                    
                    for (int t = 0; t < avionase.size(); t++)
                    {
                        if (t != i)
                        {
                            temp = avionase.get(t).getLocations();
                            if (temp.contains(loc))
                            {
                                worked = false;
                                continue start; //we failed start over
                            }
                        } //close if
                    }//close t for we passed if we get here
                    locationToSet.add(loc);
                }//close for j
                avionase.get(i).setLocation(locationToSet);
            }//close while
        }//close i for
    }//close location to set
}
