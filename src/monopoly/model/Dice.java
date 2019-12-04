package monopoly.model;
import java.util.concurrent.ThreadLocalRandom;

/** An class to be inherited from to create various kinds of dice.
@author Byron Weber Becker */
public class Dice extends Object
{
   public Dice()
   {  super();
   }

   /** Get a roll of the "dice"
   @return a random number */
   public int getRoll()
   {
      int randomNum = ThreadLocalRandom.current().nextInt(1, 7);
      return randomNum;
   }
   
}
