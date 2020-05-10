package e.b.a.a;

import java.io.IOException;

public class j
  extends IOException
{
  public g x;
  
  public j(String paramString, g paramg)
  {
    super(paramString);
    x = paramg;
  }
  
  public String getMessage()
  {
    Object localObject1 = super.getMessage();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "N/A";
    }
    localObject1 = x;
    if (localObject1 != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append((String)localObject2);
      if (localObject1 != null)
      {
        localStringBuilder.append('\n');
        localStringBuilder.append(" at ");
        localStringBuilder.append(((g)localObject1).toString());
      }
      localObject2 = localStringBuilder.toString();
    }
    return (String)localObject2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(": ");
    localStringBuilder.append(getMessage());
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */