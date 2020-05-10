package k.a.b.a.d;

public enum v$a
{
  public final byte _code;
  
  static
  {
    PN_SASL_AUTH = new a("PN_SASL_AUTH", 2, (byte)1);
    PN_SASL_SYS = new a("PN_SASL_SYS", 3, (byte)2);
    PN_SASL_PERM = new a("PN_SASL_PERM", 4, (byte)3);
    PN_SASL_TEMP = new a("PN_SASL_TEMP", 5, (byte)4);
    a locala = new a("PN_SASL_SKIPPED", 6, (byte)5);
    PN_SASL_SKIPPED = locala;
    $VALUES = new a[] { PN_SASL_NONE, PN_SASL_OK, PN_SASL_AUTH, PN_SASL_SYS, PN_SASL_PERM, PN_SASL_TEMP, locala };
  }
  
  public v$a(byte paramByte)
  {
    _code = ((byte)paramByte);
  }
  
  public byte getCode()
  {
    return _code;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.v.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */