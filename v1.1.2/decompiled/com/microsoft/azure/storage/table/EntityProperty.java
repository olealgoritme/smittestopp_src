package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.core.Base64;
import com.microsoft.azure.storage.core.Utility;
import java.util.Date;
import java.util.UUID;

public final class EntityProperty
{
  public boolean dateBackwardCompatibility = false;
  public EdmType edmType = EdmType.NULL;
  public boolean isEncrypted = false;
  public Class<?> type;
  public String value;
  
  public EntityProperty(double paramDouble)
  {
    setValue(paramDouble);
  }
  
  public EntityProperty(int paramInt)
  {
    setValue(paramInt);
  }
  
  public EntityProperty(long paramLong)
  {
    setValue(paramLong);
  }
  
  public EntityProperty(Boolean paramBoolean)
  {
    setValue(paramBoolean);
  }
  
  public EntityProperty(Double paramDouble)
  {
    setValue(paramDouble);
  }
  
  public EntityProperty(Integer paramInteger)
  {
    setValue(paramInteger);
  }
  
  public EntityProperty(Long paramLong)
  {
    setValue(paramLong);
  }
  
  public EntityProperty(Object paramObject, Class<?> paramClass)
  {
    if (paramClass.equals(byte[].class))
    {
      setValue((byte[])paramObject);
      type = paramClass;
    }
    else if (paramClass.equals(Byte[].class))
    {
      setValue((Byte[])paramObject);
      type = paramClass;
    }
    else if (paramClass.equals(String.class))
    {
      setValue((String)paramObject);
      type = paramClass;
    }
    else if (paramClass.equals(Boolean.TYPE))
    {
      setValue(((Boolean)paramObject).booleanValue());
      type = paramClass;
    }
    else if (paramClass.equals(Boolean.class))
    {
      setValue((Boolean)paramObject);
      type = paramClass;
    }
    else if (paramClass.equals(Double.TYPE))
    {
      setValue(((Double)paramObject).doubleValue());
      type = paramClass;
    }
    else if (paramClass.equals(Double.class))
    {
      setValue((Double)paramObject);
      type = paramClass;
    }
    else if (paramClass.equals(UUID.class))
    {
      setValue((UUID)paramObject);
      type = paramClass;
    }
    else if (paramClass.equals(Integer.TYPE))
    {
      setValue(((Integer)paramObject).intValue());
      type = paramClass;
    }
    else if (paramClass.equals(Integer.class))
    {
      setValue((Integer)paramObject);
      type = paramClass;
    }
    else if (paramClass.equals(Long.TYPE))
    {
      setValue(((Long)paramObject).longValue());
      type = paramClass;
    }
    else if (paramClass.equals(Long.class))
    {
      setValue((Long)paramObject);
      type = paramClass;
    }
    else
    {
      if (!paramClass.equals(Date.class)) {
        break label360;
      }
      setValue((Date)paramObject);
      type = paramClass;
    }
    return;
    label360:
    throw new IllegalArgumentException(String.format("Type %s is not supported.", new Object[] { paramClass.toString() }));
  }
  
  public EntityProperty(String paramString)
  {
    setValue(paramString);
  }
  
  public EntityProperty(String paramString, EdmType paramEdmType)
  {
    edmType = paramEdmType;
    value = paramString;
    if (paramEdmType == EdmType.STRING)
    {
      type = String.class;
      return;
    }
    if (paramEdmType == EdmType.BINARY)
    {
      getValueAsByteArray();
      type = Byte[].class;
    }
    else if (paramEdmType == EdmType.BOOLEAN)
    {
      getValueAsBoolean();
      type = Boolean.class;
    }
    else if (paramEdmType == EdmType.DOUBLE)
    {
      getValueAsDouble();
      type = Double.class;
    }
    else if (paramEdmType == EdmType.GUID)
    {
      getValueAsUUID();
      type = UUID.class;
    }
    else if (paramEdmType == EdmType.INT32)
    {
      getValueAsInteger();
      type = Integer.class;
    }
    else if (paramEdmType == EdmType.INT64)
    {
      getValueAsLong();
      type = Long.class;
    }
    else
    {
      if (paramEdmType != EdmType.DATE_TIME) {
        break label190;
      }
      getValueAsDate();
      type = Date.class;
    }
    return;
    label190:
    if (paramEdmType == null) {
      throw new IllegalArgumentException("EdmType cannot be null.");
    }
    throw new IllegalArgumentException(String.format("Invalid value '%s' for EdmType.", new Object[] { paramEdmType.toString() }));
  }
  
  public EntityProperty(String paramString, Class<?> paramClass)
  {
    type = paramClass;
    value = paramString;
    if (paramClass.equals(byte[].class))
    {
      getValueAsByteArray();
      edmType = EdmType.BINARY;
    }
    else if (paramClass.equals(Byte[].class))
    {
      getValueAsByteObjectArray();
      edmType = EdmType.BINARY;
    }
    else if (paramClass.equals(String.class))
    {
      edmType = EdmType.STRING;
    }
    else if (paramClass.equals(Boolean.TYPE))
    {
      getValueAsBoolean();
      edmType = EdmType.BOOLEAN;
    }
    else if (paramClass.equals(Boolean.class))
    {
      getValueAsBooleanObject();
      edmType = EdmType.BOOLEAN;
    }
    else if (paramClass.equals(Date.class))
    {
      getValueAsDate();
      edmType = EdmType.DATE_TIME;
    }
    else if (paramClass.equals(Double.TYPE))
    {
      getValueAsDouble();
      edmType = EdmType.DOUBLE;
    }
    else if (paramClass.equals(Double.class))
    {
      getValueAsDoubleObject();
      edmType = EdmType.DOUBLE;
    }
    else if (paramClass.equals(UUID.class))
    {
      getValueAsUUID();
      edmType = EdmType.GUID;
    }
    else if (paramClass.equals(Integer.TYPE))
    {
      getValueAsInteger();
      edmType = EdmType.INT32;
    }
    else if (paramClass.equals(Integer.class))
    {
      getValueAsIntegerObject();
      edmType = EdmType.INT32;
    }
    else if (paramClass.equals(Long.TYPE))
    {
      getValueAsLong();
      edmType = EdmType.INT64;
    }
    else
    {
      if (!paramClass.equals(Long.class)) {
        break label340;
      }
      getValueAsLongObject();
      edmType = EdmType.INT64;
    }
    return;
    label340:
    throw new IllegalArgumentException(String.format("Type %s is not supported.", new Object[] { paramClass.toString() }));
  }
  
  public EntityProperty(Date paramDate)
  {
    setValue(paramDate);
  }
  
  public EntityProperty(UUID paramUUID)
  {
    setValue(paramUUID);
  }
  
  public EntityProperty(boolean paramBoolean)
  {
    setValue(paramBoolean);
  }
  
  public EntityProperty(byte[] paramArrayOfByte)
  {
    setValue(paramArrayOfByte);
  }
  
  public EntityProperty(Byte[] paramArrayOfByte)
  {
    setValue(paramArrayOfByte);
  }
  
  public EdmType getEdmType()
  {
    return edmType;
  }
  
  public boolean getIsNull()
  {
    boolean bool;
    if (value == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Class<?> getType()
  {
    return type;
  }
  
  public boolean getValueAsBoolean()
  {
    if (!getIsNull()) {
      return Boolean.parseBoolean(value);
    }
    throw new IllegalArgumentException("EntityProperty cannot be set to null for primitive value types.");
  }
  
  public Boolean getValueAsBooleanObject()
  {
    if (getIsNull()) {
      return null;
    }
    return Boolean.valueOf(Boolean.parseBoolean(value));
  }
  
  public byte[] getValueAsByteArray()
  {
    byte[] arrayOfByte;
    if (getIsNull()) {
      arrayOfByte = null;
    } else {
      arrayOfByte = Base64.decode(value);
    }
    return arrayOfByte;
  }
  
  public Byte[] getValueAsByteObjectArray()
  {
    Byte[] arrayOfByte;
    if (getIsNull()) {
      arrayOfByte = null;
    } else {
      arrayOfByte = Base64.decodeAsByteObjectArray(value);
    }
    return arrayOfByte;
  }
  
  public Date getValueAsDate()
  {
    Date localDate;
    if (getIsNull()) {
      localDate = null;
    } else {
      localDate = Utility.parseDate(value, dateBackwardCompatibility);
    }
    return localDate;
  }
  
  public double getValueAsDouble()
  {
    if (!getIsNull())
    {
      if ((!value.equals("Infinity")) && (!value.equals("INF")))
      {
        if ((!value.equals("-Infinity")) && (!value.equals("-INF")))
        {
          if (value.equals("NaN")) {
            return NaN.0D;
          }
          return Double.parseDouble(value);
        }
        return Double.NEGATIVE_INFINITY;
      }
      return Double.POSITIVE_INFINITY;
    }
    throw new IllegalArgumentException("EntityProperty cannot be set to null for primitive value types.");
  }
  
  public Double getValueAsDoubleObject()
  {
    if (getIsNull()) {
      return null;
    }
    if ((!value.equals("Infinity")) && (!value.equals("INF")))
    {
      if ((!value.equals("-Infinity")) && (!value.equals("-INF")))
      {
        if (value.equals("NaN")) {
          return Double.valueOf(NaN.0D);
        }
        return Double.valueOf(Double.parseDouble(value));
      }
      return Double.valueOf(Double.NEGATIVE_INFINITY);
    }
    return Double.valueOf(Double.POSITIVE_INFINITY);
  }
  
  public int getValueAsInteger()
  {
    if (!getIsNull()) {
      return Integer.parseInt(value);
    }
    throw new IllegalArgumentException("EntityProperty cannot be set to null for primitive value types.");
  }
  
  public Integer getValueAsIntegerObject()
  {
    Integer localInteger;
    if (getIsNull()) {
      localInteger = null;
    } else {
      localInteger = Integer.valueOf(Integer.parseInt(value));
    }
    return localInteger;
  }
  
  public long getValueAsLong()
  {
    if (!getIsNull()) {
      return Long.parseLong(value);
    }
    throw new IllegalArgumentException("EntityProperty cannot be set to null for primitive value types.");
  }
  
  public Long getValueAsLongObject()
  {
    Long localLong;
    if (getIsNull()) {
      localLong = null;
    } else {
      localLong = Long.valueOf(Long.parseLong(value));
    }
    return localLong;
  }
  
  public String getValueAsString()
  {
    String str;
    if (getIsNull()) {
      str = null;
    } else {
      str = value;
    }
    return str;
  }
  
  public UUID getValueAsUUID()
  {
    UUID localUUID;
    if (getIsNull()) {
      localUUID = null;
    } else {
      localUUID = UUID.fromString(value);
    }
    return localUUID;
  }
  
  public boolean isEncrypted()
  {
    return isEncrypted;
  }
  
  public void setDateBackwardCompatibility(boolean paramBoolean)
  {
    dateBackwardCompatibility = paramBoolean;
  }
  
  public void setIsEncrypted(boolean paramBoolean)
  {
    isEncrypted = paramBoolean;
  }
  
  public final void setValue(double paramDouble)
  {
    try
    {
      edmType = EdmType.DOUBLE;
      type = Double.TYPE;
      value = Double.toString(paramDouble);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void setValue(int paramInt)
  {
    try
    {
      edmType = EdmType.INT32;
      type = Integer.TYPE;
      value = Integer.toString(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void setValue(long paramLong)
  {
    try
    {
      edmType = EdmType.INT64;
      type = Long.TYPE;
      value = Long.toString(paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void setValue(Boolean paramBoolean)
  {
    try
    {
      edmType = EdmType.BOOLEAN;
      type = Boolean.class;
      if (paramBoolean == null)
      {
        value = null;
      }
      else
      {
        if (paramBoolean.booleanValue()) {
          paramBoolean = "true";
        } else {
          paramBoolean = "false";
        }
        value = paramBoolean;
      }
      return;
    }
    finally {}
  }
  
  public final void setValue(Double paramDouble)
  {
    try
    {
      edmType = EdmType.DOUBLE;
      type = Double.class;
      if (paramDouble == null) {
        paramDouble = null;
      } else {
        paramDouble = Double.toString(paramDouble.doubleValue());
      }
      value = paramDouble;
      return;
    }
    finally {}
  }
  
  public final void setValue(Integer paramInteger)
  {
    try
    {
      edmType = EdmType.INT32;
      type = Integer.class;
      if (paramInteger == null) {
        paramInteger = null;
      } else {
        paramInteger = Integer.toString(paramInteger.intValue());
      }
      value = paramInteger;
      return;
    }
    finally {}
  }
  
  public final void setValue(Long paramLong)
  {
    try
    {
      edmType = EdmType.INT64;
      type = Long.class;
      if (paramLong == null) {
        paramLong = null;
      } else {
        paramLong = Long.toString(paramLong.longValue());
      }
      value = paramLong;
      return;
    }
    finally {}
  }
  
  public final void setValue(String paramString)
  {
    try
    {
      edmType = EdmType.STRING;
      type = String.class;
      value = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void setValue(Date paramDate)
  {
    try
    {
      edmType = EdmType.DATE_TIME;
      type = Date.class;
      if (paramDate == null) {
        paramDate = null;
      } else {
        paramDate = Utility.getJavaISO8601Time(paramDate);
      }
      value = paramDate;
      return;
    }
    finally {}
  }
  
  public final void setValue(UUID paramUUID)
  {
    try
    {
      edmType = EdmType.GUID;
      type = UUID.class;
      if (paramUUID == null) {
        paramUUID = null;
      } else {
        paramUUID = paramUUID.toString();
      }
      value = paramUUID;
      return;
    }
    finally {}
  }
  
  public final void setValue(boolean paramBoolean)
  {
    try
    {
      edmType = EdmType.BOOLEAN;
      type = Boolean.TYPE;
      String str;
      if (paramBoolean) {
        str = "true";
      } else {
        str = "false";
      }
      value = str;
      return;
    }
    finally {}
  }
  
  public final void setValue(byte[] paramArrayOfByte)
  {
    try
    {
      edmType = EdmType.BINARY;
      type = byte[].class;
      if (paramArrayOfByte == null) {
        paramArrayOfByte = null;
      } else {
        paramArrayOfByte = Base64.encode(paramArrayOfByte);
      }
      value = paramArrayOfByte;
      return;
    }
    finally {}
  }
  
  public final void setValue(Byte[] paramArrayOfByte)
  {
    try
    {
      edmType = EdmType.BINARY;
      type = Byte[].class;
      if (paramArrayOfByte == null) {
        paramArrayOfByte = null;
      } else {
        paramArrayOfByte = Base64.encode(paramArrayOfByte);
      }
      value = paramArrayOfByte;
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.table.EntityProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */