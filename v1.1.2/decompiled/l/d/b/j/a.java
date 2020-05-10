package l.d.b.j;

import l.d.b.e;

public abstract class a<T>
{
  public final l.d.b.a<T, ?> a;
  public final e<T> b;
  public final String c;
  public final String[] d;
  public final Thread e;
  
  public a(l.d.b.a<T, ?> parama, String paramString, String[] paramArrayOfString)
  {
    a = parama;
    b = new e(parama);
    c = paramString;
    d = paramArrayOfString;
    e = Thread.currentThread();
  }
  
  public static String[] a(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    String[] arrayOfString = new String[i];
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramArrayOfObject[j];
      if (localObject != null) {
        arrayOfString[j] = localObject.toString();
      } else {
        arrayOfString[j] = null;
      }
    }
    return arrayOfString;
  }
}

/* Location:
 * Qualified Name:     l.d.b.j.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */