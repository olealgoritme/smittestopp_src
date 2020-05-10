package com.microsoft.identity.common.internal.cache.registry;

import android.content.Context;
import com.microsoft.identity.common.internal.cache.AbstractApplicationMetadata;
import com.microsoft.identity.common.internal.cache.SharedPreferencesSimpleCacheImpl;
import com.microsoft.identity.common.internal.logging.Logger;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public class DefaultBrokerApplicationRegistry
  extends SharedPreferencesSimpleCacheImpl<BrokerApplicationRegistryData>
  implements IBrokerApplicationRegistry
{
  public static final String DEFAULT_APP_REGISTRY_CACHE_NAME = "com.microsoft.identity.app-registry";
  public static final String KEY_APP_REGISTRY = "app-registry";
  public static final String TAG = "DefaultBrokerApplicationRegistry";
  
  public DefaultBrokerApplicationRegistry(Context paramContext)
  {
    super(paramContext, "com.microsoft.identity.app-registry", "app-registry");
  }
  
  public Type getListTypeToken()
  {
    new e.c.c.x.a() {}.getType();
  }
  
  public BrokerApplicationRegistryData getMetadata(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = getAll().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localBrokerApplicationRegistryData = (BrokerApplicationRegistryData)((Iterator)localObject).next();
      if ((paramString1.equals(localBrokerApplicationRegistryData.getClientId())) && (paramInt == localBrokerApplicationRegistryData.getUid()) && ((paramString2 == null) || (paramString2.equals(localBrokerApplicationRegistryData.getEnvironment()))))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(TAG);
        ((StringBuilder)localObject).append(localBrokerApplicationRegistryData);
        Logger.verbose(((StringBuilder)localObject).toString(), "Metadata located.");
        break label112;
      }
    }
    BrokerApplicationRegistryData localBrokerApplicationRegistryData = null;
    label112:
    if (localBrokerApplicationRegistryData == null)
    {
      localObject = e.a.a.a.a.a(new StringBuilder(), TAG, ":getMetadata");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Metadata could not be found for clientId, environment: [");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("]");
      Logger.warn((String)localObject, localStringBuilder.toString());
    }
    return localBrokerApplicationRegistryData;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.registry.DefaultBrokerApplicationRegistry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */