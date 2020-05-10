package com.microsoft.azure.storage.table;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public enum EdmType
{
  public static final Set<EdmType> UNANNOTATED;
  
  static
  {
    BINARY = new EdmType("BINARY", 1);
    BOOLEAN = new EdmType("BOOLEAN", 2);
    BYTE = new EdmType("BYTE", 3);
    DATE_TIME = new EdmType("DATE_TIME", 4);
    DATE_TIME_OFFSET = new EdmType("DATE_TIME_OFFSET", 5);
    DECIMAL = new EdmType("DECIMAL", 6);
    DOUBLE = new EdmType("DOUBLE", 7);
    SINGLE = new EdmType("SINGLE", 8);
    GUID = new EdmType("GUID", 9);
    INT16 = new EdmType("INT16", 10);
    INT32 = new EdmType("INT32", 11);
    INT64 = new EdmType("INT64", 12);
    SBYTE = new EdmType("SBYTE", 13);
    STRING = new EdmType("STRING", 14);
    EdmType localEdmType1 = new EdmType("TIME", 15);
    TIME = localEdmType1;
    EdmType localEdmType2 = NULL;
    EdmType localEdmType3 = BINARY;
    EdmType localEdmType4 = BOOLEAN;
    EdmType localEdmType5 = BYTE;
    EdmType localEdmType6 = DATE_TIME;
    EdmType localEdmType7 = DATE_TIME_OFFSET;
    EdmType localEdmType8 = DECIMAL;
    EdmType localEdmType9 = DOUBLE;
    EdmType localEdmType10 = SINGLE;
    EdmType localEdmType11 = GUID;
    EdmType localEdmType12 = INT16;
    EdmType localEdmType13 = INT32;
    EdmType localEdmType14 = INT64;
    EdmType localEdmType15 = SBYTE;
    EdmType localEdmType16 = STRING;
    $VALUES = new EdmType[] { localEdmType2, localEdmType3, localEdmType4, localEdmType5, localEdmType6, localEdmType7, localEdmType8, localEdmType9, localEdmType10, localEdmType11, localEdmType12, localEdmType13, localEdmType14, localEdmType15, localEdmType16, localEdmType1 };
    UNANNOTATED = Collections.unmodifiableSet(EnumSet.of(localEdmType4, localEdmType9, localEdmType13, localEdmType16));
  }
  
  public EdmType() {}
  
  public static EdmType parse(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramString.equals("Edm.DateTime")) {
        return DATE_TIME;
      }
      if (paramString.equals("Edm.Int32")) {
        return INT32;
      }
      if (paramString.equals("Edm.Boolean")) {
        return BOOLEAN;
      }
      if (paramString.equals("Edm.Double")) {
        return DOUBLE;
      }
      if (paramString.equals("Edm.Int64")) {
        return INT64;
      }
      if (paramString.equals("Edm.Guid")) {
        return GUID;
      }
      if (paramString.equals("Edm.Binary")) {
        return BINARY;
      }
      throw new IllegalArgumentException(String.format("Invalid value '%s' for EdmType.", new Object[] { paramString }));
    }
    return STRING;
  }
  
  public final boolean mustAnnotateType()
  {
    return UNANNOTATED.contains(this) ^ true;
  }
  
  public String toString()
  {
    if (this == BINARY) {
      return "Edm.Binary";
    }
    if (this == STRING) {
      return "Edm.String";
    }
    if (this == BOOLEAN) {
      return "Edm.Boolean";
    }
    if (this == DOUBLE) {
      return "Edm.Double";
    }
    if (this == GUID) {
      return "Edm.Guid";
    }
    if (this == INT32) {
      return "Edm.Int32";
    }
    if (this == INT64) {
      return "Edm.Int64";
    }
    if (this == DATE_TIME) {
      return "Edm.DateTime";
    }
    return "";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.table.EdmType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */