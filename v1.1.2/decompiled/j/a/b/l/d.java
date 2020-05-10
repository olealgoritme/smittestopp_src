package j.a.b.l;

public class d
  extends c
{
  public String x;
  
  public d(int paramInt)
  {
    super(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i;
    for (;;)
    {
      i = paramInt2;
      if (paramInt1 >= paramInt2 - 1) {
        break;
      }
      if (!Character.isWhitespace(x.charAt(paramInt1)))
      {
        i = paramInt2;
        break;
      }
      paramInt1++;
    }
    for (;;)
    {
      paramInt2 = i - 1;
      if ((paramInt2 <= paramInt1) || (!Character.isWhitespace(x.charAt(paramInt2)))) {
        break;
      }
      i = paramInt2;
    }
    e = x.substring(paramInt1, i);
  }
  
  public void c()
  {
    int i = f + 1;
    f = i;
    if (i >= w) {
      a = ((char)26);
    } else {
      a = x.charAt(i);
    }
  }
  
  public void d()
  {
    int i = f + 1;
    f = i;
    if (i >= w) {
      a = ((char)26);
    } else {
      a = x.charAt(i);
    }
  }
}

/* Location:
 * Qualified Name:     j.a.b.l.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */