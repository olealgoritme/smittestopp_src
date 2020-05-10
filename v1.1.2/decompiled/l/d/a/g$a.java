package l.d.a;

import java.io.PrintStream;
import java.util.logging.Level;

public class g$a
  implements g
{
  public void a(Level paramLevel, String paramString)
  {
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramLevel);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString);
    localPrintStream.println(localStringBuilder.toString());
  }
  
  public void a(Level paramLevel, String paramString, Throwable paramThrowable)
  {
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramLevel);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString);
    localPrintStream.println(localStringBuilder.toString());
    paramThrowable.printStackTrace(System.out);
  }
}

/* Location:
 * Qualified Name:     l.d.a.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */