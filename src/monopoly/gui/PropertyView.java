
package monopoly.gui;
import javax.swing.*;
import java.awt.*;
import monopoly.model.*;

/** A view for a property model.
@author Byron Weber Becker */
/* package */ class PropertyView extends JPanel implements MonopolyListener
{
   private Property model;
   private JTextArea tArea = new JTextArea();
   private static final Font defFont = new Font("SansSerif", Font.PLAIN, 9);
   private static final int TOKEN_DIA = 20;

   /** Construct a new view.
   @param aProperty the model for this view */
   /* package */ PropertyView(Property aProperty)
   {  super();
      this.setLayout(new GridLayout());
      this.model = aProperty;
      this.add(tArea);
      this.tArea.setFont(this.defFont);
      this.tArea.setOpaque(false);
      this.tArea.setEditable(false);
      this.updateView(this.model);
      this.model.addMonopolyListener(this);
   }

   /** Update the information shown by this view.
   @param changedModel the model that changed */
   public void updateView(Object changedModel)
   {  if (changedModel == this.model)
      {  this.tArea.setText(((Property)changedModel).getDescription());
         this.repaint();
      }
   }

   /** Paint the view. */
   public void paintComponent(Graphics g)
   {
      g.setColor(this.getBackground());
      g.fillRect(0,0,this.getWidth(),this.getHeight());
      Player[] playersHere = this.model.getPlayers();
      for(int i=0; i<playersHere.length; i++)
      {  int pID = playersHere[i].getID();
         g.setColor(MonopolyGUI.PLAYER_COLORS[pID]);
         g.fillOval(i*TOKEN_DIA, 0, TOKEN_DIA, TOKEN_DIA);
      }
   }
}
