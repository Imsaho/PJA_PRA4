/**
 *
 *  @author Bednarczyk Joanna PD2598
 *
 */

package zad2;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class Main {
  public static void main(String[] args) {

    Purchase purch = new Purchase("komputer", "nie ma promocji", 3000.00);
    System.out.println(purch);

    // --- tu należy dodać odpowiedni kod

    purch.addVetoableChangeListener(new MyVetoableChangeListener());
    purch.addPropertyChangeListener("price", new PriceChangeListener());
    purch.addPropertyChangeListener("data", new DataChangeListener());

    // ----------------------------------

    try {
      purch.setData("w promocji");
      purch.setPrice(2000.00);
      System.out.println(purch);

      purch.setPrice(500.00);

    } catch (PropertyVetoException exc) {
      System.out.println(exc.getMessage());
    }
    System.out.println(purch);

  }
}

class MyVetoableChangeListener implements VetoableChangeListener {

  @Override
  public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
    double newValue = (double) evt.getNewValue();

    boolean veto = false;

    if (newValue < 1000) {
      veto = true;
    }

    if (veto) {
      throw new PropertyVetoException("Price change to: " + newValue + " not allowed", evt);
    }
  }
}

class PriceChangeListener implements PropertyChangeListener {

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    double oldVal = (double) evt.getOldValue(),
            newVal = (double) evt.getNewValue();
    System.out.println("Change value of: price from: " + oldVal + " to: " + newVal);
  }
}

class DataChangeListener implements PropertyChangeListener {

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    String oldVal = (String) evt.getOldValue(),
            newVal = (String) evt.getNewValue();
    System.out.println("Change value of: data from: " + oldVal + " to: " + newVal);
  }
}
