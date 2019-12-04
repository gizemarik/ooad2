
package monopoly.model;

/** All objects that want to listen for changes in the monopoly model
must implement this interface.
@author Byron Weber Becker */
public interface MonopolyListener
{
   /** Update a view if it is concerned about the given model.
   @param changedModel a model that changed */
   public void updateView(Object changedModel);
}