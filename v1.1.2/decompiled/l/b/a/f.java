package l.b.a;

public class f
{
  public static final e[] d = new e[0];
  public e[] a;
  public int b;
  public boolean c;
  
  public f(int paramInt)
  {
    if (paramInt >= 0)
    {
      e[] arrayOfe;
      if (paramInt == 0) {
        arrayOfe = d;
      } else {
        arrayOfe = new e[paramInt];
      }
      a = arrayOfe;
      b = 0;
      c = false;
      return;
    }
    throw new IllegalArgumentException("'initialCapacity' must not be negative");
  }
  
  public static e[] a(e[] paramArrayOfe)
  {
    if (paramArrayOfe.length < 1) {
      paramArrayOfe = d;
    } else {
      paramArrayOfe = (e[])paramArrayOfe.clone();
    }
    return paramArrayOfe;
  }
  
  public e a(int paramInt)
  {
    if (paramInt < b) {
      return a[paramInt];
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" >= ");
    localStringBuilder.append(b);
    throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public void a(e parame)
  {
    if (parame != null)
    {
      int i = a.length;
      int j = b;
      int k = 1;
      j++;
      if (j <= i) {
        k = 0;
      }
      if ((c | k))
      {
        e[] arrayOfe = new e[Math.max(a.length, (j >> 1) + j)];
        System.arraycopy(a, 0, arrayOfe, 0, b);
        a = arrayOfe;
        c = false;
      }
      a[b] = parame;
      b = j;
      return;
    }
    throw new NullPointerException("'element' cannot be null");
  }
  
  public e[] a()
  {
    int i = b;
    if (i == 0) {
      return d;
    }
    e[] arrayOfe1 = a;
    if (arrayOfe1.length == i)
    {
      c = true;
      return arrayOfe1;
    }
    e[] arrayOfe2 = new e[i];
    System.arraycopy(arrayOfe1, 0, arrayOfe2, 0, i);
    return arrayOfe2;
  }
}

/* Location:
 * Qualified Name:     l.b.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */