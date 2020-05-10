package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.core.Utility;
import e.a.a.a.a;
import e.b.a.a.f;
import e.b.a.a.q.c;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class TableEntitySerializer
{
  public static Map<String, EntityProperty> getPropertiesFromDictionary(TableEntity paramTableEntity, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    Object localObject = paramTableEntity.writeEntity(paramOperationContext);
    paramOperationContext = (OperationContext)localObject;
    if (localObject == null) {
      paramOperationContext = new HashMap();
    }
    paramTableRequestOptions.assertPolicyIfRequired();
    localObject = paramOperationContext;
    if (paramTableRequestOptions.getEncryptionPolicy() != null) {
      localObject = paramTableRequestOptions.getEncryptionPolicy().encryptEntity(paramOperationContext, paramTableEntity.getPartitionKey(), paramTableEntity.getRowKey(), paramTableRequestOptions.getEncryptionResolver());
    }
    return (Map<String, EntityProperty>)localObject;
  }
  
  public static void writeJsonEntity(f paramf, TableRequestOptions paramTableRequestOptions, TableEntity paramTableEntity, boolean paramBoolean, OperationContext paramOperationContext)
  {
    paramTableRequestOptions = getPropertiesFromDictionary(paramTableEntity, paramTableRequestOptions, paramOperationContext);
    paramf.c();
    Object localObject;
    if (!paramBoolean)
    {
      Utility.assertNotNull("PartitionKey", paramTableEntity.getPartitionKey());
      Utility.assertNotNull("RowKey", paramTableEntity.getRowKey());
      Utility.assertNotNull("Timestamp", paramTableEntity.getTimestamp());
      localObject = paramTableEntity.getPartitionKey();
      paramOperationContext = (c)paramf;
      paramOperationContext.a("PartitionKey");
      paramOperationContext.b((String)localObject);
      localObject = paramTableEntity.getRowKey();
      paramOperationContext.a("RowKey");
      paramOperationContext.b((String)localObject);
      paramTableEntity = Utility.getJavaISO8601Time(paramTableEntity.getTimestamp());
      paramOperationContext.a("Timestamp");
      paramOperationContext.b(paramTableEntity);
    }
    paramTableRequestOptions = paramTableRequestOptions.entrySet().iterator();
    while (paramTableRequestOptions.hasNext())
    {
      paramTableEntity = (Map.Entry)paramTableRequestOptions.next();
      if ((!((String)paramTableEntity.getKey()).equals("PartitionKey")) && (!((String)paramTableEntity.getKey()).equals("RowKey")) && (!((String)paramTableEntity.getKey()).equals("Timestamp")) && (!((String)paramTableEntity.getKey()).equals("Etag")))
      {
        localObject = (EntityProperty)paramTableEntity.getValue();
        String str;
        if (((EntityProperty)localObject).getEdmType().mustAnnotateType())
        {
          str = ((EntityProperty)localObject).getEdmType().toString();
          localObject = a.a(new StringBuilder(), (String)paramTableEntity.getKey(), "@odata.type");
          paramOperationContext = (c)paramf;
          paramOperationContext.a((String)localObject);
          paramOperationContext.b(str);
          localObject = (String)paramTableEntity.getKey();
          paramTableEntity = ((EntityProperty)paramTableEntity.getValue()).getValueAsString();
          paramOperationContext.a((String)localObject);
          paramOperationContext.b(paramTableEntity);
        }
        else if ((((EntityProperty)localObject).getEdmType() == EdmType.DOUBLE) && (!((EntityProperty)localObject).getIsNull()))
        {
          paramOperationContext = ((EntityProperty)localObject).getEdmType().toString();
          localObject = Double.valueOf(((EntityProperty)localObject).getValueAsDouble());
          if ((!((Double)localObject).equals(Double.valueOf(Double.POSITIVE_INFINITY))) && (!((Double)localObject).equals(Double.valueOf(Double.NEGATIVE_INFINITY))) && (!((Double)localObject).equals(Double.valueOf(NaN.0D))))
          {
            writeJsonProperty(paramf, paramTableEntity);
          }
          else
          {
            str = a.a(new StringBuilder(), (String)paramTableEntity.getKey(), "@odata.type");
            localObject = (c)paramf;
            ((f)localObject).a(str);
            ((f)localObject).b(paramOperationContext);
            paramOperationContext = (String)paramTableEntity.getKey();
            paramTableEntity = ((EntityProperty)paramTableEntity.getValue()).getValueAsString();
            ((f)localObject).a(paramOperationContext);
            ((f)localObject).b(paramTableEntity);
          }
        }
        else
        {
          writeJsonProperty(paramf, paramTableEntity);
        }
      }
    }
    paramf.a();
  }
  
  public static void writeJsonProperty(f paramf, Map.Entry<String, EntityProperty> paramEntry)
  {
    Object localObject = ((EntityProperty)paramEntry.getValue()).getEdmType();
    if (((EntityProperty)paramEntry.getValue()).getIsNull())
    {
      paramf.a((String)paramEntry.getKey());
      paramf.b();
    }
    else if (localObject == EdmType.BOOLEAN)
    {
      localObject = (String)paramEntry.getKey();
      boolean bool = ((EntityProperty)paramEntry.getValue()).getValueAsBoolean();
      paramf.a((String)localObject);
      paramf.a(bool);
    }
    else if (localObject == EdmType.DOUBLE)
    {
      localObject = (String)paramEntry.getKey();
      double d = ((EntityProperty)paramEntry.getValue()).getValueAsDouble();
      paramf.a((String)localObject);
      paramf.a(d);
    }
    else if (localObject == EdmType.INT32)
    {
      localObject = (String)paramEntry.getKey();
      int i = ((EntityProperty)paramEntry.getValue()).getValueAsInteger();
      paramf.a((String)localObject);
      paramf.a(i);
    }
    else
    {
      localObject = (String)paramEntry.getKey();
      paramEntry = ((EntityProperty)paramEntry.getValue()).getValueAsString();
      paramf = (c)paramf;
      paramf.a((String)localObject);
      paramf.b(paramEntry);
    }
  }
  
  public static void writeSingleEntityToStream(OutputStream paramOutputStream, TableRequestOptions paramTableRequestOptions, TableEntity paramTableEntity, boolean paramBoolean, OperationContext paramOperationContext)
  {
    paramOutputStream = Utility.getJsonGenerator(paramOutputStream);
    try
    {
      writeJsonEntity(paramOutputStream, paramTableRequestOptions, paramTableEntity, paramBoolean, paramOperationContext);
      return;
    }
    finally
    {
      paramOutputStream.close();
    }
  }
  
  public static void writeSingleEntityToString(StringWriter paramStringWriter, TableRequestOptions paramTableRequestOptions, TableEntity paramTableEntity, boolean paramBoolean, OperationContext paramOperationContext)
  {
    paramStringWriter = Utility.getJsonGenerator(paramStringWriter);
    try
    {
      writeJsonEntity(paramStringWriter, paramTableRequestOptions, paramTableEntity, paramBoolean, paramOperationContext);
      return;
    }
    finally
    {
      paramStringWriter.close();
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.TableEntitySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */