
package monopoly.model;
import becker.util.IView;

import java.util.*;

/** A class representing one monopoly property.  A property can be a
building lot such as "Vermont Ave" or "Park Place".  It can also be a
railroad, "Go", Chance, the jail, and so on.
@author Byron Weber Becker */
public abstract class Property extends Object
{
   private ArrayList listeners = new ArrayList();
   private IView[] views = new IView[1];
   private int numViews = 0;
   private String Name;
   private String Description;
   private String Owner;


   /** Get a description of this property
   @returns a description of this property */
   public String getDescription()
   {
      String description=this.Description;
      return description;
   }


   /** Get a list of the players currently occupying this property.
   @returns a full array with the 0 or more players who have most recently
   landed on this property */
   public Player[] getPlayers()
   {
      return new Player[0];
   }

   /** Get the name of this property.
   @returns this property's name */
   /* package */
   public String getName()
   {
      String name = this.Name;
      return  name;
   }

   /** Add a listener for changes to this property model.
   @param ml the monopoly listener to add */
   public void addMonopolyListener(MonopolyListener ml)
   {
      this.listeners.add(ml);
   }

   /** Add another view to be notified whenever this part of the model changes.
    @param //view the view to add */
   public void addView(IView aView)
   {
   }

   /** Update the views that are listening to this model for changes
   @param changedModel the model object that actually changed (usually 'this') */
   protected synchronized void updateViews(Object changedModel)
   {
      for(int i=0; i<this.listeners.size(); i++)
      {  MonopolyListener ml = (MonopolyListener)this.listeners.get(i);
         ml.updateView(changedModel);
      }
   }

}
