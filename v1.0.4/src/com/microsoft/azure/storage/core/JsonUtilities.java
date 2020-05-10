package com.microsoft.azure.storage.core;

import e.b.a.a.h;
import e.b.a.a.i;
import e.b.a.a.l;
import e.b.a.a.o.c;

public final class JsonUtilities
{
  public static void assertIsEndArrayJsonToken(i parami)
  {
    if (y == l.END_ARRAY) {
      return;
    }
    throw new h("Expected the end of a JSON Array.", parami.b());
  }
  
  public static void assertIsEndObjectJsonToken(i parami)
  {
    if (y == l.END_OBJECT) {
      return;
    }
    throw new h("Expected the end of a JSON Object.", parami.b());
  }
  
  public static void assertIsExpectedFieldName(i parami, String paramString)
  {
    String str = parami.c();
    if (paramString == null)
    {
      if (str != null) {
        throw new h(String.format("Unexpected field name. Expected: '%s'. Actual: '%s'.", new Object[] { paramString, str }), parami.b());
      }
    }
    else {
      if (!paramString.equals(str)) {
        break label54;
      }
    }
    return;
    label54:
    throw new h(String.format("Unexpected field name. Expected: '%s'. Actual: '%s'.", new Object[] { paramString, str }), parami.b());
  }
  
  public static void assertIsFieldNameJsonToken(i parami)
  {
    if (y == l.FIELD_NAME) {
      return;
    }
    throw new h("Expected a field name.", parami.b());
  }
  
  public static void assertIsStartArrayJsonToken(i parami)
  {
    if (y == l.START_ARRAY) {
      return;
    }
    throw new h("Expected the start of a JSON Array.", parami.b());
  }
  
  public static void assertIsStartObjectJsonToken(i parami)
  {
    if (y == l.START_OBJECT) {
      return;
    }
    throw new h("Expected the start of a JSON Object.", parami.b());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.JsonUtilities
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */