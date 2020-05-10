package l.e.a;

public final class b$a
{
  public int a;
  public b[] b = new b[6];
  
  public void a(b paramb)
  {
    while (paramb != null)
    {
      for (int i = 0; i < a; i++) {
        if (b[i].a.equals(a))
        {
          i = 1;
          break label46;
        }
      }
      i = 0;
      label46:
      if (i == 0)
      {
        i = a;
        b[] arrayOfb1 = b;
        if (i >= arrayOfb1.length)
        {
          arrayOfb2 = new b[arrayOfb1.length + 6];
          System.arraycopy(arrayOfb1, 0, arrayOfb2, 0, i);
          b = arrayOfb2;
        }
        b[] arrayOfb2 = b;
        i = a;
        a = (i + 1);
        arrayOfb2[i] = paramb;
      }
      paramb = c;
    }
  }
}

/* Location:
 * Qualified Name:     l.e.a.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */