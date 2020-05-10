package com.microsoft.identity.common.internal.cache;

import android.content.Context;
import android.text.TextUtils;
import com.microsoft.identity.common.internal.logging.Logger;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SharedPreferencesBrokerApplicationMetadataCache
  extends SharedPreferencesSimpleCacheImpl<BrokerApplicationMetadata>
  implements IBrokerApplicationMetadataCache
{
  public static final String DEFAULT_APP_METADATA_CACHE_NAME = "com.microsoft.identity.app-meta-cache";
  public static final String KEY_CACHE_LIST = "app-meta-cache";
  public static final String TAG = "SharedPreferencesBrokerApplicationMetadataCache";
  
  public SharedPreferencesBrokerApplicationMetadataCache(Context paramContext)
  {
    super(paramContext, "com.microsoft.identity.app-meta-cache", "app-meta-cache");
  }
  
  private Set<String> getAllFociClientIds(boolean paramBoolean)
  {
    HashSet localHashSet = new HashSet();
    Object localObject1 = getAll().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BrokerApplicationMetadata)((Iterator)localObject1).next();
      if (!paramBoolean)
      {
        if (!TextUtils.isEmpty(((BrokerApplicationMetadata)localObject2).getFoci())) {
          localHashSet.add(((AbstractApplicationMetadata)localObject2).getClientId());
        }
      }
      else if (TextUtils.isEmpty(((BrokerApplicationMetadata)localObject2).getFoci())) {
        localHashSet.add(((AbstractApplicationMetadata)localObject2).getClientId());
      }
    }
    localObject1 = e.a.a.a.a.a(new StringBuilder(), TAG, ":getAllFociClientIds");
    Object localObject2 = e.a.a.a.a.a("Found [");
    ((StringBuilder)localObject2).append(localHashSet.size());
    ((StringBuilder)localObject2).append("] client ids.");
    Logger.verbose((String)localObject1, ((StringBuilder)localObject2).toString());
    return localHashSet;
  }
  
  public Set<String> getAllClientIds()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = getAll().iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashSet.add(((BrokerApplicationMetadata)((Iterator)localObject).next()).getClientId());
    }
    localObject = e.a.a.a.a.a(new StringBuilder(), TAG, ":getAllClientIds");
    StringBuilder localStringBuilder = e.a.a.a.a.a("Found [");
    localStringBuilder.append(localHashSet.size());
    localStringBuilder.append("] client ids.");
    Logger.verbose((String)localObject, localStringBuilder.toString());
    return localHashSet;
  }
  
  public List<BrokerApplicationMetadata> getAllFociApplicationMetadata()
  {
    Set localSet = getAllFociClientIds();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getAll().iterator();
    while (localIterator.hasNext())
    {
      BrokerApplicationMetadata localBrokerApplicationMetadata = (BrokerApplicationMetadata)localIterator.next();
      if (localSet.contains(localBrokerApplicationMetadata.getClientId())) {
        localArrayList.add(localBrokerApplicationMetadata);
      }
    }
    return localArrayList;
  }
  
  public Set<String> getAllFociClientIds()
  {
    return getAllFociClientIds(false);
  }
  
  public Set<String> getAllNonFociClientIds()
  {
    return getAllFociClientIds(true);
  }
  
  public Type getListTypeToken()
  {
    new e.c.c.x.a() {}.getType();
  }
  
  public BrokerApplicationMetadata getMetadata(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = getAll().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localBrokerApplicationMetadata = (BrokerApplicationMetadata)((Iterator)localObject).next();
      if ((paramString1.equals(localBrokerApplicationMetadata.getClientId())) && (paramString2.equals(localBrokerApplicationMetadata.getEnvironment())) && (paramInt == localBrokerApplicationMetadata.getUid()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(TAG);
        ((StringBuilder)localObject).append(localBrokerApplicationMetadata);
        Logger.verbose(((StringBuilder)localObject).toString(), "Metadata located.");
        break label108;
      }
    }
    BrokerApplicationMetadata localBrokerApplicationMetadata = null;
    label108:
    if (localBrokerApplicationMetadata == null)
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
    return localBrokerApplicationMetadata;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.SharedPreferencesBrokerApplicationMetadataCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */