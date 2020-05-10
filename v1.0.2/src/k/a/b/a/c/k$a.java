package k.a.b.a.c;

public class k$a
  extends z<Character>
{
  public k$a(k paramk, x paramx, r paramr)
  {
    super(paramx, paramr);
  }
  
  public void a(Object paramObject)
  {
    Character localCharacter = (Character)paramObject;
    paramObject = a;
    int i = localCharacter.charValue();
    a.b(i & 0xFFFF);
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
  
  public boolean e()
  {
    return true;
  }
  
  public byte g()
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
  
  public int i()
  {
    return 4;
  }
  
  public Object k()
  {
    return Character.valueOf((char)(b.f() & 0xFFFF));
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.k.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */