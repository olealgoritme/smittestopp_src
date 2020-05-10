package h.k.b;

import java.io.Serializable;

public abstract class h<R>
  implements Object<R>, Serializable
{
  public h(int paramInt) {}
  
  public String toString()
  {
    if (l.a != null)
    {
      String str1 = getClass().getGenericInterfaces()[0].toString();
      String str2 = str1;
      if (str1.startsWith("kotlin.jvm.functions.")) {
        str2 = str1.substring(21);
      }
      g.a(str2, "Reflection.renderLambdaToString(this)");
      return str2;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.h.k.b.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */