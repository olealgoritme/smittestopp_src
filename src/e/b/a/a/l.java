package e.b.a.a;

public enum l
{
  public final int _id;
  public final boolean _isBoolean;
  public final boolean _isNumber;
  public final boolean _isScalar;
  public final boolean _isStructEnd;
  public final boolean _isStructStart;
  public final String _serialized;
  public final byte[] _serializedBytes;
  public final char[] _serializedChars;
  
  static
  {
    END_OBJECT = new l("END_OBJECT", 2, "}", 2);
    START_ARRAY = new l("START_ARRAY", 3, "[", 3);
    END_ARRAY = new l("END_ARRAY", 4, "]", 4);
    FIELD_NAME = new l("FIELD_NAME", 5, null, 5);
    VALUE_EMBEDDED_OBJECT = new l("VALUE_EMBEDDED_OBJECT", 6, null, 12);
    VALUE_STRING = new l("VALUE_STRING", 7, null, 6);
    VALUE_NUMBER_INT = new l("VALUE_NUMBER_INT", 8, null, 7);
    VALUE_NUMBER_FLOAT = new l("VALUE_NUMBER_FLOAT", 9, null, 8);
    VALUE_TRUE = new l("VALUE_TRUE", 10, "true", 9);
    VALUE_FALSE = new l("VALUE_FALSE", 11, "false", 10);
    l locall = new l("VALUE_NULL", 12, "null", 11);
    VALUE_NULL = locall;
    $VALUES = new l[] { NOT_AVAILABLE, START_OBJECT, END_OBJECT, START_ARRAY, END_ARRAY, FIELD_NAME, VALUE_EMBEDDED_OBJECT, VALUE_STRING, VALUE_NUMBER_INT, VALUE_NUMBER_FLOAT, VALUE_TRUE, VALUE_FALSE, locall };
  }
  
  public l(String paramString, int paramInt)
  {
    boolean bool1 = false;
    if (paramString == null)
    {
      _serialized = null;
      _serializedChars = null;
      _serializedBytes = null;
    }
    else
    {
      _serialized = paramString;
      ??? = paramString.toCharArray();
      _serializedChars = ((char[])???);
      int i = ???.length;
      _serializedBytes = new byte[i];
      for (??? = 0; ??? < i; ???++) {
        _serializedBytes[???] = ((byte)(byte)_serializedChars[???]);
      }
    }
    _id = paramInt;
    boolean bool2;
    if ((paramInt != 10) && (paramInt != 9)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    _isBoolean = bool2;
    if ((paramInt != 7) && (paramInt != 8)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    _isNumber = bool2;
    if ((paramInt != 1) && (paramInt != 3)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    _isStructStart = bool2;
    if ((paramInt != 2) && (paramInt != 4)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    _isStructEnd = bool2;
    boolean bool3 = bool1;
    if (!_isStructStart)
    {
      bool3 = bool1;
      if (!bool2)
      {
        bool3 = bool1;
        if (paramInt != 5)
        {
          bool3 = bool1;
          if (paramInt != -1) {
            bool3 = true;
          }
        }
      }
    }
    _isScalar = bool3;
  }
  
  public final byte[] asByteArray()
  {
    return _serializedBytes;
  }
  
  public final char[] asCharArray()
  {
    return _serializedChars;
  }
  
  public final String asString()
  {
    return _serialized;
  }
  
  public final int id()
  {
    return _id;
  }
  
  public final boolean isBoolean()
  {
    return _isBoolean;
  }
  
  public final boolean isNumeric()
  {
    return _isNumber;
  }
  
  public final boolean isScalarValue()
  {
    return _isScalar;
  }
  
  public final boolean isStructEnd()
  {
    return _isStructEnd;
  }
  
  public final boolean isStructStart()
  {
    return _isStructStart;
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */