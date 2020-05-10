package l.b.a;

public class c2
{
  public String a;
  public int b;
  
  public c2(String paramString)
  {
    a = paramString;
    b = 0;
  }
  
  public String a()
  {
    int i = b;
    if (i == -1) {
      return null;
    }
    i = a.indexOf('.', i);
    if (i == -1)
    {
      str = a.substring(b);
      b = -1;
      return str;
    }
    String str = a.substring(b, i);
    b = (i + 1);
    return str;
  }
}

/* Location:
 * Qualified Name:     l.b.a.c2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */