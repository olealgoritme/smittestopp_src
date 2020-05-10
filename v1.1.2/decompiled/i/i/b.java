package i.i;

import i.k.b.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b
{
  public static final <T> int a(List<? extends T> paramList)
  {
    if (paramList != null) {
      return paramList.size() - 1;
    }
    g.a("$this$lastIndex");
    throw null;
  }
  
  public static final <T> List<T> a(T... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length > 0)
      {
        paramVarArgs = Arrays.asList(paramVarArgs);
        g.a(paramVarArgs, "ArraysUtilJVM.asList(this)");
      }
      else
      {
        paramVarArgs = d.x;
      }
      return paramVarArgs;
    }
    g.a("elements");
    throw null;
  }
  
  public static final <T> List<T> b(T... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        paramVarArgs = new ArrayList();
      } else {
        paramVarArgs = new ArrayList(new a(paramVarArgs, true));
      }
      return paramVarArgs;
    }
    g.a("elements");
    throw null;
  }
}

/* Location:
 * Qualified Name:     i.i.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */