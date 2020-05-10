package k.f.e;

import java.io.Serializable;
import k.f.b;

public abstract class a
  implements b, Serializable
{
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append("(");
    localStringBuilder.append("NOP");
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.f.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */