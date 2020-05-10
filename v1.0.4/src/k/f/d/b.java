package k.f.d;

public enum b
{
  public int levelInt;
  public String levelStr;
  
  static
  {
    INFO = new b("INFO", 2, 20, "INFO");
    DEBUG = new b("DEBUG", 3, 10, "DEBUG");
    b localb = new b("TRACE", 4, 0, "TRACE");
    TRACE = localb;
    $VALUES = new b[] { ERROR, WARN, INFO, DEBUG, localb };
  }
  
  public b(int paramInt, String paramString)
  {
    levelInt = paramInt;
    levelStr = paramString;
  }
  
  public int toInt()
  {
    return levelInt;
  }
  
  public String toString()
  {
    return levelStr;
  }
}

/* Location:
 * Qualified Name:     base.k.f.d.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */