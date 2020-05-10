package g.c;

public enum c
{
  static
  {
    SCHAR = new c("SCHAR", 1);
    UCHAR = new c("UCHAR", 2);
    SSHORT = new c("SSHORT", 3);
    USHORT = new c("USHORT", 4);
    SINT = new c("SINT", 5);
    UINT = new c("UINT", 6);
    SLONG = new c("SLONG", 7);
    ULONG = new c("ULONG", 8);
    SLONGLONG = new c("SLONGLONG", 9);
    ULONGLONG = new c("ULONGLONG", 10);
    FLOAT = new c("FLOAT", 11);
    DOUBLE = new c("DOUBLE", 12);
    STRUCT = new c("STRUCT", 13);
    c localc = new c("ADDRESS", 14);
    ADDRESS = localc;
    $VALUES = new c[] { VOID, SCHAR, UCHAR, SSHORT, USHORT, SINT, UINT, SLONG, ULONG, SLONGLONG, ULONGLONG, FLOAT, DOUBLE, STRUCT, localc };
  }
  
  public c() {}
}

/* Location:
 * Qualified Name:     base.g.c.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */