package e.c.c.y;

public enum b
{
  static
  {
    BEGIN_OBJECT = new b("BEGIN_OBJECT", 2);
    END_OBJECT = new b("END_OBJECT", 3);
    NAME = new b("NAME", 4);
    STRING = new b("STRING", 5);
    NUMBER = new b("NUMBER", 6);
    BOOLEAN = new b("BOOLEAN", 7);
    NULL = new b("NULL", 8);
    b localb = new b("END_DOCUMENT", 9);
    END_DOCUMENT = localb;
    $VALUES = new b[] { BEGIN_ARRAY, END_ARRAY, BEGIN_OBJECT, END_OBJECT, NAME, STRING, NUMBER, BOOLEAN, NULL, localb };
  }
  
  public b() {}
}

/* Location:
 * Qualified Name:     e.c.c.y.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */