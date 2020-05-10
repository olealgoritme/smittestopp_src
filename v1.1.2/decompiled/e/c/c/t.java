package e.c.c;

public enum t
{
  static
  {
    b localb = new b("STRING", 1);
    STRING = localb;
    $VALUES = new t[] { DEFAULT, localb };
  }
  
  public t() {}
  
  public abstract j serialize(Long paramLong);
  
  public static enum a
  {
    public a()
    {
      super(paramInt, null);
    }
    
    public j serialize(Long paramLong)
    {
      return new p(paramLong);
    }
  }
  
  public static enum b
  {
    public b()
    {
      super(paramInt, null);
    }
    
    public j serialize(Long paramLong)
    {
      return new p(String.valueOf(paramLong));
    }
  }
}

/* Location:
 * Qualified Name:     e.c.c.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */