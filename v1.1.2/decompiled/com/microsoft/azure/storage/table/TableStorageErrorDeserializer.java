package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.StorageExtendedErrorInformation;
import com.microsoft.azure.storage.core.JsonUtilities;
import com.microsoft.azure.storage.core.StorageRequest;
import e.b.a.a.d;
import e.b.a.a.i;
import e.b.a.a.l;
import e.b.a.a.o.c;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.util.HashMap;

public final class TableStorageErrorDeserializer
{
  public static StorageExtendedErrorInformation getExtendedErrorInformation(Reader paramReader, TablePayloadFormat paramTablePayloadFormat)
  {
    paramReader = new d().a(paramReader);
    try
    {
      paramTablePayloadFormat = new com/microsoft/azure/storage/StorageExtendedErrorInformation;
      paramTablePayloadFormat.<init>();
      if (!paramReader.e()) {
        paramReader.f();
      }
      JsonUtilities.assertIsStartObjectJsonToken(paramReader);
      paramReader.f();
      JsonUtilities.assertIsFieldNameJsonToken(paramReader);
      JsonUtilities.assertIsExpectedFieldName(paramReader, "odata.error");
      paramReader.f();
      JsonUtilities.assertIsStartObjectJsonToken(paramReader);
      paramReader.g();
      JsonUtilities.assertIsExpectedFieldName(paramReader, "code");
      paramTablePayloadFormat.setErrorCode(paramReader.d());
      paramReader.f();
      JsonUtilities.assertIsFieldNameJsonToken(paramReader);
      JsonUtilities.assertIsExpectedFieldName(paramReader, "message");
      paramReader.f();
      JsonUtilities.assertIsStartObjectJsonToken(paramReader);
      paramReader.g();
      JsonUtilities.assertIsExpectedFieldName(paramReader, "lang");
      paramReader.g();
      JsonUtilities.assertIsExpectedFieldName(paramReader, "value");
      paramTablePayloadFormat.setErrorMessage(paramReader.d());
      paramReader.f();
      JsonUtilities.assertIsEndObjectJsonToken(paramReader);
      paramReader.f();
      if (y == l.FIELD_NAME)
      {
        JsonUtilities.assertIsExpectedFieldName(paramReader, "innererror");
        paramTablePayloadFormat.getAdditionalDetails().putAll(parseJsonErrorException(paramReader));
        paramReader.f();
      }
      JsonUtilities.assertIsEndObjectJsonToken(paramReader);
      paramReader.f();
      JsonUtilities.assertIsEndObjectJsonToken(paramReader);
      return paramTablePayloadFormat;
    }
    finally
    {
      paramReader.close();
    }
  }
  
  public static StorageExtendedErrorInformation parseErrorDetails(StorageRequest<CloudTableClient, ?, ?> paramStorageRequest)
  {
    if (paramStorageRequest != null) {}
    try
    {
      if (paramStorageRequest.getConnection().getErrorStream() != null)
      {
        InputStreamReader localInputStreamReader = new java/io/InputStreamReader;
        localInputStreamReader.<init>(paramStorageRequest.getConnection().getErrorStream());
        paramStorageRequest = getExtendedErrorInformation(localInputStreamReader, TablePayloadFormat.Json);
        return paramStorageRequest;
      }
    }
    catch (Exception paramStorageRequest)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static HashMap<String, String[]> parseJsonErrorException(i parami)
  {
    HashMap localHashMap = new HashMap();
    parami.f();
    JsonUtilities.assertIsStartObjectJsonToken(parami);
    parami.f();
    JsonUtilities.assertIsFieldNameJsonToken(parami);
    while (y != l.END_OBJECT)
    {
      if (parami.c().equals("message"))
      {
        parami.f();
        localHashMap.put("message", new String[] { parami.d() });
      }
      else if (parami.c().equals("type"))
      {
        parami.f();
        localHashMap.put("type", new String[] { parami.d() });
      }
      else if (parami.c().equals("stacktrace"))
      {
        parami.f();
        localHashMap.put("StackTrace", new String[] { parami.d() });
      }
      parami.f();
    }
    return localHashMap;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.table.TableStorageErrorDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */