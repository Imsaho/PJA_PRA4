/**
 *
 *  @author Bednarczyk Joanna PD2598
 *
 */

package zad2;


import java.beans.*;

public class Purchase {

  private String prod;

  private String data;

  private double price;

  private VetoableChangeSupport vceListeners = new VetoableChangeSupport(this);
  private PropertyChangeSupport propertyChange = new PropertyChangeSupport(this);

  public Purchase(String prod, String data, double price) {
    this.prod = prod;
    this.data = data;
    this.price = price;
  }

  public void setData(String newData) throws PropertyVetoException {
    String oldData = data;

    data = newData;

    propertyChange.firePropertyChange("data", (oldData), (newData));
  }

  public String getData() {
    return data;
  }


  public void setPrice(double newPrice) throws PropertyVetoException {
    double oldPrice = price;

      vceListeners.fireVetoableChange("price", (oldPrice), (newPrice));
      price = newPrice;

      propertyChange.firePropertyChange("price", (oldPrice), (newPrice));
  }

  public double getPrice() {
    return price;
  }


  public synchronized void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
    propertyChange.addPropertyChangeListener(propertyName, listener);
  }

  public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
    propertyChange.removePropertyChangeListener(listener);
  }


  public synchronized void addVetoableChangeListener(VetoableChangeListener listener) {
    vceListeners.addVetoableChangeListener(listener);
  }

  public synchronized void removeVetoableChangeListener(VetoableChangeListener listener) {
    vceListeners.removeVetoableChangeListener(listener);
  }


  @Override
  public String toString() {
    return "Purchase [prod=" + prod + ", data=" + data + ", price=" + price + "]";
  }
}
