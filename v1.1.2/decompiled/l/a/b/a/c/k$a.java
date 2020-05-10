package l.a.b.a.c;

public class k$a
  extends z<Character>
{
  public k$a(k paramk, x paramx, r paramr)
  {
    super(paramx, paramr);
  }
  
  public boolean a(r0<Character> paramr0)
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
    paramObject = (Character)paramObject;
    x localx = a;
    int i = ((Character)paramObject).charValue();
    a.c(i & 0xFFFF);
  }
  
  public byte f()
  {
    return 115;
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
    return Character.valueOf((char)(b.f() & 0xFFFF));
  }
  
  public boolean j()
  {
    return true;
  }
  
  public int k()
  {
    return 4;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.k.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */