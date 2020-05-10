package g.a;

public abstract interface e
{
  public static final e b = new a();
  
  public abstract b a();
  
  public static final class a
    implements e
  {
    public e.b a()
    {
      return e.b.NULL;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof e)) {
        return e.b.NULL.equals(((e)paramObject).a());
      }
      return false;
    }
    
    public int hashCode()
    {
      return e.b.NULL.hashCode();
    }
    
    public String toString()
    {
      return "null";
    }
  }
  
  public static enum b
  {
    static
    {
      NUMBER = new b("NUMBER", 3);
      TRUE = new b("TRUE", 4);
      FALSE = new b("FALSE", 5);
      b localb = new b("NULL", 6);
      NULL = localb;
      $VALUES = new b[] { ARRAY, OBJECT, STRING, NUMBER, TRUE, FALSE, localb };
    }
    
    public b() {}
  }
}

/* Location:
 * Qualified Name:     g.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */