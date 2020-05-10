package d.u;

import java.util.Arrays;
import java.util.Set;

public abstract class e$c
{
  public final String[] a;
  
  public e$c(String[] paramArrayOfString)
  {
    a = ((String[])Arrays.copyOf(paramArrayOfString, paramArrayOfString.length));
  }
  
  public abstract void a(Set<String> paramSet);
}

/* Location:
 * Qualified Name:     base.d.u.e.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */