package monopoly.model;


/** Roll a pair of random dice.
@author Byron Weber Becker */
public class RandomDice extends Dice
{
	private int sides;
	
      /** Construct a new RandomDice object.
   @param numSides the number of sides on each of the two dice. */
   public RandomDice(int numSides)
   {  super();
      this.sides = numSides;
   }

   /** Return a roll of the pair of dice.
   @returns a number between 2 and 2*numSides */
   public int getRoll()
   {  int roll = 0;
      roll=getRoll()+getRoll();
      if (roll < 2 || roll > 2*sides)
      {  throw new Error("getRoll returning " + roll +
                         "; should be between 2 and " + 2*this.sides + ".");

      }
      return roll;
   }
   
}
