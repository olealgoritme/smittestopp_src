package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.core.UriQueryBuilder;
import com.microsoft.azure.storage.core.Utility;
import java.util.Date;
import java.util.Formatter;
import java.util.UUID;

public class TableQuery<T extends TableEntity>
{
  public Class<T> clazzType = null;
  public String[] columns = null;
  public String filterString = null;
  public String sourceTableName = null;
  public Integer takeCount;
  
  public TableQuery() {}
  
  public TableQuery(Class<T> paramClass)
  {
    setClazzType(paramClass);
  }
  
  public static String combineFilters(String paramString1, String paramString2, String paramString3)
  {
    return String.format("(%s) %s (%s)", new Object[] { paramString1, paramString2, paramString3 });
  }
  
  public static <T extends TableEntity> TableQuery<T> from(Class<T> paramClass)
  {
    return new TableQuery(paramClass);
  }
  
  public static String generateFilterCondition(String paramString1, String paramString2, double paramDouble)
  {
    return generateFilterCondition(paramString1, paramString2, Double.toString(paramDouble), EdmType.DOUBLE);
  }
  
  public static String generateFilterCondition(String paramString1, String paramString2, int paramInt)
  {
    return generateFilterCondition(paramString1, paramString2, Integer.toString(paramInt), EdmType.INT32);
  }
  
  public static String generateFilterCondition(String paramString1, String paramString2, long paramLong)
  {
    return generateFilterCondition(paramString1, paramString2, Long.toString(paramLong), EdmType.INT64);
  }
  
  public static String generateFilterCondition(String paramString1, String paramString2, String paramString3)
  {
    return generateFilterCondition(paramString1, paramString2, paramString3, EdmType.STRING);
  }
  
  public static String generateFilterCondition(String paramString1, String paramString2, String paramString3, EdmType paramEdmType)
  {
    String str = paramString3;
    if (paramEdmType != EdmType.BOOLEAN)
    {
      str = paramString3;
      if (paramEdmType != EdmType.DOUBLE) {
        if (paramEdmType == EdmType.INT32) {
          str = paramString3;
        } else if (paramEdmType == EdmType.INT64) {
          str = String.format("%sL", new Object[] { paramString3 });
        } else if (paramEdmType == EdmType.DATE_TIME) {
          str = String.format("datetime'%s'", new Object[] { paramString3 });
        } else if (paramEdmType == EdmType.GUID) {
          str = String.format("guid'%s'", new Object[] { paramString3 });
        } else if (paramEdmType == EdmType.BINARY) {
          str = String.format("X'%s'", new Object[] { paramString3 });
        } else {
          str = String.format("'%s'", new Object[] { paramString3.replace("'", "''") });
        }
      }
    }
    return String.format("%s %s %s", new Object[] { paramString1, paramString2, str });
  }
  
  public static String generateFilterCondition(String paramString1, String paramString2, Date paramDate)
  {
    return generateFilterCondition(paramString1, paramString2, Utility.getJavaISO8601Time(paramDate), EdmType.DATE_TIME);
  }
  
  public static String generateFilterCondition(String paramString1, String paramString2, UUID paramUUID)
  {
    return generateFilterCondition(paramString1, paramString2, paramUUID.toString(), EdmType.GUID);
  }
  
  public static String generateFilterCondition(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "true";
    } else {
      str = "false";
    }
    return generateFilterCondition(paramString1, paramString2, str, EdmType.BOOLEAN);
  }
  
  public static String generateFilterCondition(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Formatter localFormatter = new Formatter(localStringBuilder);
    int i = paramArrayOfByte.length;
    for (int j = 0; j < i; j++) {
      localFormatter.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[j]) });
    }
    localFormatter.flush();
    localFormatter.close();
    return generateFilterCondition(paramString1, paramString2, localStringBuilder.toString(), EdmType.BINARY);
  }
  
  public static String generateFilterCondition(String paramString1, String paramString2, Byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Formatter localFormatter = new Formatter(localStringBuilder);
    int i = paramArrayOfByte.length;
    for (int j = 0; j < i; j++) {
      localFormatter.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[j].byteValue()) });
    }
    localFormatter.flush();
    localFormatter.close();
    return generateFilterCondition(paramString1, paramString2, localStringBuilder.toString(), EdmType.BINARY);
  }
  
  public UriQueryBuilder generateQueryBuilder()
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    if (!Utility.isNullOrEmpty(filterString)) {
      localUriQueryBuilder.add("$filter", filterString);
    }
    Object localObject = takeCount;
    if (localObject != null) {
      localUriQueryBuilder.add("$top", ((Integer)localObject).toString());
    }
    localObject = columns;
    if ((localObject != null) && (localObject.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      int j = 0;
      int k = 0;
      int m = 0;
      for (;;)
      {
        localObject = columns;
        if (i >= localObject.length) {
          break;
        }
        int n;
        int i1;
        if ("RowKey".equals(localObject[i]))
        {
          n = 1;
          i1 = j;
        }
        else if ("PartitionKey".equals(columns[i]))
        {
          i1 = 1;
          n = k;
        }
        else
        {
          i1 = j;
          n = k;
          if ("Timestamp".equals(columns[i]))
          {
            m = 1;
            n = k;
            i1 = j;
          }
        }
        localStringBuilder.append(columns[i]);
        if (i < columns.length - 1) {
          localStringBuilder.append(",");
        }
        i++;
        j = i1;
        k = n;
      }
      if (j == 0)
      {
        localStringBuilder.append(",");
        localStringBuilder.append("PartitionKey");
      }
      if (k == 0)
      {
        localStringBuilder.append(",");
        localStringBuilder.append("RowKey");
      }
      if (m == 0)
      {
        localStringBuilder.append(",");
        localStringBuilder.append("Timestamp");
      }
      localUriQueryBuilder.add("$select", localStringBuilder.toString());
    }
    return localUriQueryBuilder;
  }
  
  public Class<T> getClazzType()
  {
    return clazzType;
  }
  
  public String[] getColumns()
  {
    return columns;
  }
  
  public String getFilterString()
  {
    return filterString;
  }
  
  public String getSourceTableName()
  {
    return sourceTableName;
  }
  
  public Integer getTakeCount()
  {
    return takeCount;
  }
  
  public TableQuery<T> select(String[] paramArrayOfString)
  {
    setColumns(paramArrayOfString);
    return this;
  }
  
  public void setClazzType(Class<T> paramClass)
  {
    Utility.assertNotNull("class type", paramClass);
    Utility.checkNullaryCtor(paramClass);
    clazzType = paramClass;
  }
  
  public void setColumns(String[] paramArrayOfString)
  {
    columns = paramArrayOfString;
  }
  
  public void setFilterString(String paramString)
  {
    Utility.assertNotNullOrEmpty("filterString", paramString);
    filterString = paramString;
  }
  
  public void setSourceTableName(String paramString)
  {
    Utility.assertNotNullOrEmpty("tableName", paramString);
    sourceTableName = paramString;
  }
  
  public void setTakeCount(Integer paramInteger)
  {
    if ((paramInteger != null) && (paramInteger.intValue() <= 0)) {
      throw new IllegalArgumentException("Take count must be positive and greater than 0.");
    }
    takeCount = paramInteger;
  }
  
  public TableQuery<T> take(Integer paramInteger)
  {
    if (paramInteger != null) {
      setTakeCount(paramInteger);
    }
    return this;
  }
  
  public TableQuery<T> where(String paramString)
  {
    setFilterString(paramString);
    return this;
  }
  
  public static class Operators
  {
    public static final String AND = "and";
    public static final String NOT = "not";
    public static final String OR = "or";
  }
  
  public static class QueryComparisons
  {
    public static final String EQUAL = "eq";
    public static final String GREATER_THAN = "gt";
    public static final String GREATER_THAN_OR_EQUAL = "ge";
    public static final String LESS_THAN = "lt";
    public static final String LESS_THAN_OR_EQUAL = "le";
    public static final String NOT_EQUAL = "ne";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.table.TableQuery
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */