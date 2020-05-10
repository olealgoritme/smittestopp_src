package com.microsoft.identity.common.adal.internal.tokensharing;

import com.google.gson.Gson;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.cache.ADALTokenCacheItem;
import e.c.c.e;
import e.c.c.n;
import e.c.c.v.c;
import e.c.c.w.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class SSOStateSerializer
{
  public static final Gson GSON;
  @c("tokenCacheItems")
  public final List<ADALTokenCacheItem> mTokenCacheItems;
  @c("version")
  public final int version = 1;
  
  static
  {
    e locale = new e();
    locale.a(ADALTokenCacheItem.class, new TokenCacheItemSerializationAdapater());
    GSON = locale.a();
  }
  
  public SSOStateSerializer()
  {
    mTokenCacheItems = new ArrayList();
  }
  
  public SSOStateSerializer(ADALTokenCacheItem paramADALTokenCacheItem)
  {
    ArrayList localArrayList = new ArrayList();
    mTokenCacheItems = localArrayList;
    if (paramADALTokenCacheItem != null)
    {
      localArrayList.add(paramADALTokenCacheItem);
      return;
    }
    throw new IllegalArgumentException("tokenItem is null");
  }
  
  public static ADALTokenCacheItem deserialize(String paramString)
  {
    return new SSOStateSerializer().internalDeserialize(paramString);
  }
  
  private ADALTokenCacheItem getTokenItem()
  {
    List localList = mTokenCacheItems;
    if ((localList != null) && (!localList.isEmpty())) {
      return (ADALTokenCacheItem)mTokenCacheItems.get(0);
    }
    throw new ClientException("token_cache_item_not_found", "There is no token cache item in the SSOStateContainer.");
  }
  
  private int getVersion()
  {
    return 1;
  }
  
  private ADALTokenCacheItem internalDeserialize(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString);
      if (localJSONObject.getInt("version") == getVersion())
      {
        paramString = GSON.a(paramString, SSOStateSerializer.class);
        return ((SSOStateSerializer)t.a(SSOStateSerializer.class).cast(paramString)).getTokenItem();
      }
      paramString = new com/microsoft/identity/common/exception/ClientException;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("Fail to deserialize because the blob version is incompatible. The version of the serializedBlob is ");
      localStringBuilder.append(localJSONObject.getInt("version"));
      localStringBuilder.append(". And the target class version is ");
      localStringBuilder.append(getVersion());
      paramString.<init>("token_sharing_deserialization_error", localStringBuilder.toString());
      throw paramString;
    }
    catch (JSONException paramString) {}catch (n paramString) {}
    throw new ClientException("token_sharing_deserialization_error", paramString.getMessage());
  }
  
  private String internalSerialize()
  {
    return GSON.a(this);
  }
  
  public static String serialize(ADALTokenCacheItem paramADALTokenCacheItem)
  {
    return new SSOStateSerializer(paramADALTokenCacheItem).internalSerialize();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.adal.internal.tokensharing.SSOStateSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */