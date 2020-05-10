package l.a.b.a.d;

public abstract interface v
{
  public static final a a;
  
  static
  {
    a locala = a.PN_SASL_NONE;
    a = a.PN_SASL_OK;
    locala = a.PN_SASL_AUTH;
    locala = a.PN_SASL_SYS;
    locala = a.PN_SASL_PERM;
    locala = a.PN_SASL_TEMP;
    locala = a.PN_SASL_SKIPPED;
  }
  
  public static enum a
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
    
    public a(byte paramByte)
    {
      _code = ((byte)paramByte);
    }
    
    public byte getCode()
    {
      return _code;
    }
  }
  
  public static enum b
  {
    static
    {
      PN_SASL_PASS = new b("PN_SASL_PASS", 3);
      b localb = new b("PN_SASL_FAIL", 4);
      PN_SASL_FAIL = localb;
      $VALUES = new b[] { PN_SASL_CONF, PN_SASL_IDLE, PN_SASL_STEP, PN_SASL_PASS, localb };
    }
    
    public b() {}
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.d.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */