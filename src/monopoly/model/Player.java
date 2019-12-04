package monopoly.model;
import becker.util.IView;
import becker.io.TextInput;
import java.util.ArrayList;
//import karel.util.Utilities;



/** A class representing one monopoly player.
@author Byron Weber Becker */
public abstract class Player extends Object
{
private ArrayList listeners = new ArrayList();
   private IView[] views = new IView[1];
   private int numViews = 0;
   private static Dice dice;
    private ArrayList<String> Properties;
    private String Name;
    private int ID;
    private int Balance;
    private int NetWorth;
    private int Position;
   

   
   /* Used to determine if we are debugging or not.   Once this is determined,
    * set the appropriate type of dice. */
   private void determineDiceType()
   {
      /* Only needs to be called if we have not initialized dice. */
      if(Player.dice == null)
      {  TextInput in = new TextInput();

         System.out.print("Do you want to debug? ");
         /* Get input from the user to determine whether debugging or not. */
         if (in.readLine().trim().equalsIgnoreCase("y"))
         {
             dice = new UserInputDice();
         }
         else
         {
             dice = new RandomDice(6);
         }
         in.close();
      }

   }

   /** Get a list naming the properties this player has bought.
   @return a full array giving the names of the properties owned by this player. */
   public ArrayList<String> getOwnedPropertyNames()
   {
       ArrayList<String> properties = this.Properties;
       return properties;
   }

   /** Get the name of this player.
   @return the name of this player */
   public String getName()
   {
       String name = this.Name;
       return name;
   }

   /** Get the id of this player.
   @return the id of this player */
   public int getID()
   {
       int id = this.ID;
       return id;
   }

   /** Get the bank balance of this player.
   @return this player's bank balance */
   public int getBalance()
   {
       int balance = this.Balance;
       return balance;
   }

   /** Get the net worth of this player.
   @return this player's net worth */
   public int getNetWorth()
   {
       int networth = this.NetWorth;
       return networth;
   }

   /** Indicate whether or not this player can buy the Square it most
   recently landed on.
   @return true if the player can buy the Square; false otherwise */
   public boolean canBuyOccupiedSquare()
   {  
    return false;
   }

   

   /** Instruct this player to buy a house.
   @param //propertyName the name of the square for which the player wants to
   purchase a house*/
   public void buyHouse(String propName)
   {  
   }

   /** Buy the Square most recently landed on by this player. */
   public void buyOccupiedSquare()
   {
       int bal;
       int networth;
       String propName="";
       this.Properties.add(propName);
       bal = getBalance();
       networth = getNetWorth();
       //bal-prop_val
       //networth should stay same
       this.Balance=bal;
   }

   /** Roll the dice and advance the token. */
   protected void advanceToken()
   {
       int dices;
       int pos;
       dices=dice.getRoll();
       pos=getBoardPosition();
       if(pos+dices>39){
           //Went through go square give 200 dollars
       }
       pos=((pos+dices)%40);
       UpdateBoardPosition(pos);
   }

   /** Advance the token the given number of properties.
   @param howFar how many properties to advance  */
   protected void advanceToken(int howFar)
   {  
   }
      /** Get the id of the property most recently landed on
   @returns the id of the currently occupied property */
   /* package */ int getOccupiedPropertyID()
   {  return 0;
   }
   
     /** Add a listener for changes to this player model.
   @param ml the monopoly listener to add */
   public void addMonopolyListener(MonopolyListener ml)
   {  this.listeners.add(ml);
   }

   /** Make a move for this player -- find out how far to advance
   the token, advance it, complete any resulting business such as
   paying rent or buying properties/houses. Must be overridden in
   subclasses. */
   protected abstract void makeMove();

   /** Get the player's current position on the board.
   @return 0 for "Go, 1 for "Mediterrainean Ave", etc. */
   public int getBoardPosition()
   {
       int position = this.Position;
        return position;
   }

    public void UpdateBoardPosition(int n_position)
    {
        this.Position=n_position;
    }

   /** Add another view to be notified whenever this part of the model changes.
   @param //view the view to add */
   public void addView(IView aView)
   {  
   }
   
   /** Update the views that are listening to this model for changes
   @param changedModel the model object that actually changed (usually 'this') */
   protected void updateAllViews(Object changedModel)
   {  for(int i=0; i<this.listeners.size(); i++)
      {  MonopolyListener ml = (MonopolyListener)this.listeners.get(i);
         ml.updateView(changedModel);
      }
   }

   /** Represent this object as a String.  Useful for debugging. */
   public String toString()
   {  return null;
   }
   
}
