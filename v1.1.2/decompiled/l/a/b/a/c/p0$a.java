package l.a.b.a.c;

import java.util.Date;

public class p0$a
  extends z<Date>
{
  public p0$a(p0 paramp0, x paramx, r paramr)
  {
    super(paramx, paramr);
  }
  
  public boolean a(r0<Date> paramr0)
  {
    boolean bool;
    if (c == paramr0.getType()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void b(Object paramObject)
  {
    paramObject = (Date)paramObject;
    x localx = a;
    long l = ((Date)paramObject).getTime();
    a.a(l);
  }
  
  public byte f()
  {
    return -125;
  }
  
  public a getType()
  {
    return c;
  }
  
  public i0 getType()
  {
    return c;
  }
  
  public Object i()
  {
    return new Date(b.g());
  }
  
  public int k()
  {
    return 8;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.p0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */