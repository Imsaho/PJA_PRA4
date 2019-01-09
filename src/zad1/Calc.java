/**
 * @author Bednarczyk Joanna PD2598
 */

package zad1;

import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.net.URL;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

public class Calc {

  public String doCalc(String cmd) {

    BigDecimal a;
    BigDecimal b;
    String operand;

    try {
      String[] args = cmd.split("\\s+");

      a = new BigDecimal(args[0]);
      b = new BigDecimal(args[2]);
      operand = args[1];

      ScriptEngineManager engineManager = new ScriptEngineManager();
      ScriptEngine engine = engineManager.getEngineByName("JavaScript");

      engine.put("a", a);
      engine.put("b", b);
      engine.put("operand", operand);

      URL path = Calc.class.getResource("calc.js");
      File scriptFile = new File(path.getFile());

      engine.eval(new FileReader(scriptFile));
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Invalid command to calc");
    }
    return "";
  }
}  
