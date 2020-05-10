package e.b.a.a;

public enum c
{
  public final boolean _bigEndian;
  public final int _bits;
  public final String _javaName;
  
  static
  {
    UTF16_BE = new c("UTF16_BE", 1, "UTF-16BE", true, 16);
    UTF16_LE = new c("UTF16_LE", 2, "UTF-16LE", false, 16);
    UTF32_BE = new c("UTF32_BE", 3, "UTF-32BE", true, 32);
    c localc = new c("UTF32_LE", 4, "UTF-32LE", false, 32);
    UTF32_LE = localc;
    $VALUES = new c[] { UTF8, UTF16_BE, UTF16_LE, UTF32_BE, localc };
  }
  
  public c(String paramString, boolean paramBoolean, int paramInt)
  {
    _javaName = paramString;
    _bigEndian = paramBoolean;
    _bits = paramInt;
  }
  
  public int bits()
  {
    return _bits;
  }
  
  public String getJavaName()
  {
    return _javaName;
  }
  
  public boolean isBigEndian()
  {
    return _bigEndian;
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */