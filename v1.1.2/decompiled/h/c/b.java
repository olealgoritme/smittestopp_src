package h.c;

public enum b
{
  static
  {
    IgnoreError = new b("IgnoreError", 1);
    TypeMapper = new b("TypeMapper", 2);
    FunctionMapper = new b("FunctionMapper", 3);
    CallingConvention = new b("CallingConvention", 4);
    b localb = new b("LoadNow", 5);
    LoadNow = localb;
    $VALUES = new b[] { SaveError, IgnoreError, TypeMapper, FunctionMapper, CallingConvention, localb };
  }
  
  public b() {}
}

/* Location:
 * Qualified Name:     h.c.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */