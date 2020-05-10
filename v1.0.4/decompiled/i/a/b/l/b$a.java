package i.a.b.l;

public class b$a
{
  public char[] a;
  public int b;
  
  public b$a(int paramInt)
  {
    a = new char[paramInt];
    b = -1;
  }
  
  public void a(char paramChar)
  {
    int i = b + 1;
    b = i;
    char[] arrayOfChar1 = a;
    if (arrayOfChar1.length <= i)
    {
      char[] arrayOfChar2 = new char[arrayOfChar1.length * 2 + 1];
      System.arraycopy(arrayOfChar1, 0, arrayOfChar2, 0, arrayOfChar1.length);
      a = arrayOfChar2;
    }
    a[b] = ((char)paramChar);
  }
  
  public String toString()
  {
    return new String(a, 0, b + 1);
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.l.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */