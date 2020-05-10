package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.core.EncryptionAgent;
import com.microsoft.azure.storage.core.EncryptionData;
import com.microsoft.azure.storage.core.JsonUtilities;
import com.microsoft.azure.storage.core.Utility;
import com.microsoft.azure.storage.core.WrappedContentKey;
import e.b.a.a.f;
import e.b.a.a.i;
import e.b.a.a.l;
import java.io.StringWriter;

public class BlobEncryptionData
  extends EncryptionData
{
  public String encryptionMode;
  
  public static BlobEncryptionData deserialize(String paramString)
  {
    paramString = Utility.getJsonParser(paramString);
    BlobEncryptionData localBlobEncryptionData = new BlobEncryptionData();
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
        if (str.equals("EncryptionMode")) {
          localBlobEncryptionData.setEncryptionMode(paramString.d());
        } else if (str.equals("WrappedContentKey")) {
          localBlobEncryptionData.setWrappedContentKey(WrappedContentKey.deserialize(paramString));
        } else if (str.equals("EncryptionAgent")) {
          localBlobEncryptionData.setEncryptionAgent(EncryptionAgent.deserialize(paramString));
        } else if (str.equals("ContentEncryptionIV")) {
          localBlobEncryptionData.setContentEncryptionIV(paramString.a());
        } else if (str.equals("KeyWrappingMetadata")) {
          localBlobEncryptionData.setKeyWrappingMetadata(EncryptionData.deserializeKeyWrappingMetadata(paramString));
        } else {
          EncryptionData.consumeJsonObject(paramString);
        }
        paramString.f();
      }
      JsonUtilities.assertIsEndObjectJsonToken(paramString);
      return localBlobEncryptionData;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public String getEncryptionMode()
  {
    return encryptionMode;
  }
  
  public String serialize()
  {
    StringWriter localStringWriter = new StringWriter();
    f localf = Utility.getJsonGenerator(localStringWriter);
    try
    {
      localf.c();
      e.b.a.a.q.c localc = (e.b.a.a.q.c)localf;
      localc.a("EncryptionMode");
      localc.b("FullBlob");
      serialize(localf);
      localf.a();
      return localStringWriter.toString();
    }
    finally
    {
      localf.close();
    }
  }
  
  public void setEncryptionMode(String paramString)
  {
    encryptionMode = paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlobEncryptionData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */