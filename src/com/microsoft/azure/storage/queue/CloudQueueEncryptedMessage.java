package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.core.EncryptionData;
import com.microsoft.azure.storage.core.JsonUtilities;
import com.microsoft.azure.storage.core.Utility;
import e.b.a.a.f;
import e.b.a.a.i;
import e.b.a.a.l;
import java.io.StringWriter;

public class CloudQueueEncryptedMessage
{
  public String encryptedMessageContents;
  public EncryptionData encryptionData;
  
  public static CloudQueueEncryptedMessage deserialize(String paramString)
  {
    paramString = Utility.getJsonParser(paramString);
    CloudQueueEncryptedMessage localCloudQueueEncryptedMessage = new CloudQueueEncryptedMessage();
    try
    {
      if (!paramString.e()) {
        paramString.f();
      }
      JsonUtilities.assertIsStartObjectJsonToken(paramString);
      paramString.f();
      while (y != l.END_OBJECT)
      {
        String str = paramString.c();
        paramString.f();
        if (str.equals("EncryptedMessageContents")) {
          localCloudQueueEncryptedMessage.setEncryptedMessageContents(paramString.d());
        } else if (str.equals("EncryptionData")) {
          localCloudQueueEncryptedMessage.setEncryptionData(EncryptionData.deserialize(paramString));
        }
        paramString.f();
      }
      JsonUtilities.assertIsEndObjectJsonToken(paramString);
      return localCloudQueueEncryptedMessage;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public String getEncryptedMessageContents()
  {
    return encryptedMessageContents;
  }
  
  public EncryptionData getEncryptionData()
  {
    return encryptionData;
  }
  
  public String serialize()
  {
    StringWriter localStringWriter = new StringWriter();
    f localf = Utility.getJsonGenerator(localStringWriter);
    try
    {
      localf.c();
      String str = getEncryptedMessageContents();
      e.b.a.a.q.c localc = (e.b.a.a.q.c)localf;
      localc.a("EncryptedMessageContents");
      localc.b(str);
      localf.a("EncryptionData");
      localf.c();
      getEncryptionData().serialize(localf);
      localf.a();
      localf.a();
      return localStringWriter.toString();
    }
    finally
    {
      localf.close();
    }
  }
  
  public void setEncryptedMessageContents(String paramString)
  {
    encryptedMessageContents = paramString;
  }
  
  public void setEncryptionData(EncryptionData paramEncryptionData)
  {
    encryptionData = paramEncryptionData;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.queue.CloudQueueEncryptedMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */