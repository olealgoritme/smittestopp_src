package l.d.b.j;

import java.util.List;

public abstract class i$a
  implements i
{
  public final boolean a;
  public final Object b;
  public final Object[] c;
  
  public i$a(Object paramObject)
  {
    b = paramObject;
    a = true;
    c = null;
  }
  
  public i$a(Object[] paramArrayOfObject)
  {
    b = null;
    a = false;
    c = paramArrayOfObject;
  }
  
  public void a(List<Object> paramList)
  {
    if (a)
    {
      paramList.add(b);
    }
    else
    {
      Object[] arrayOfObject = c;
      if (arrayOfObject != null)
      {
        int i = arrayOfObject.length;
        for (int j = 0; j < i; j++) {
          paramList.add(arrayOfObject[j]);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     l.d.b.j.i.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */