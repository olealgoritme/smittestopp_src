package com.microsoft.identity.common.internal.cache;

import com.google.gson.Gson;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.dto.AccessTokenRecord;
import com.microsoft.identity.common.internal.dto.AccountCredentialBase;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.dto.IdTokenRecord;
import com.microsoft.identity.common.internal.dto.RefreshTokenRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;
import e.c.c.j;
import e.c.c.m;
import e.c.c.o;
import e.c.c.s;
import e.c.c.v.c;
import e.c.c.w.r;
import e.c.c.w.t;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class CacheKeyValueDelegate
  implements ICacheKeyValueDelegate
{
  public static final String CACHE_VALUE_SEPARATOR = "-";
  public static final String FOCI_PREFIX = "foci-";
  public static final String TAG = "CacheKeyValueDelegate";
  public final Gson mGson = new Gson();
  
  public CacheKeyValueDelegate()
  {
    String str = TAG;
    StringBuilder localStringBuilder = a.a("Init: ");
    localStringBuilder.append(TAG);
    Logger.verbose(str, localStringBuilder.toString());
  }
  
  private String generateCacheValueInternal(Object paramObject)
  {
    m localm = mGson.b(paramObject).c();
    if ((paramObject instanceof AccountCredentialBase))
    {
      AccountCredentialBase localAccountCredentialBase = (AccountCredentialBase)paramObject;
      paramObject = localAccountCredentialBase.getAdditionalFields().keySet().iterator();
      while (((Iterator)paramObject).hasNext())
      {
        String str = (String)((Iterator)paramObject).next();
        localm.a(str, (j)localAccountCredentialBase.getAdditionalFields().get(str));
      }
    }
    return mGson.a(localm);
  }
  
  public static Set<String> getExpectedJsonFields(Class<? extends AccountCredentialBase> paramClass)
  {
    HashSet localHashSet = new HashSet();
    paramClass = getSerializedNameAnnotatedFields(getFieldsUpTo(paramClass, AccountCredentialBase.class)).iterator();
    while (paramClass.hasNext()) {
      localHashSet.add(((c)((Field)paramClass.next()).getAnnotation(c.class)).value());
    }
    return localHashSet;
  }
  
  public static List<Field> getFieldsUpTo(Class<?> paramClass1, Class<?> paramClass2)
  {
    ArrayList localArrayList = new ArrayList(Arrays.asList(paramClass1.getDeclaredFields()));
    paramClass1 = paramClass1.getSuperclass();
    if ((paramClass1 != null) && ((paramClass2 == null) || (!paramClass1.equals(paramClass2)))) {
      localArrayList.addAll(getFieldsUpTo(paramClass1, paramClass2));
    }
    return localArrayList;
  }
  
  public static List<Field> getSerializedNameAnnotatedFields(List<Field> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Field localField = (Field)paramList.next();
      if ((c)localField.getAnnotation(c.class) != null) {
        localArrayList.add(localField);
      }
    }
    return localArrayList;
  }
  
  public static String sanitizeNull(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    } else {
      paramString = paramString.toLowerCase(Locale.US).trim();
    }
    return paramString;
  }
  
  public <T extends AccountCredentialBase> T fromCacheValue(String paramString, Class<? extends AccountCredentialBase> paramClass)
  {
    try
    {
      Object localObject1 = mGson.a(paramString, paramClass);
      localObject1 = (AccountCredentialBase)t.a(paramClass).cast(localObject1);
      if (!StringExtensions.isNullOrBlank(paramString))
      {
        Object localObject2 = new e/c/c/o;
        ((o)localObject2).<init>();
        paramString = ((o)localObject2).a(paramString).c();
        paramClass = getExpectedJsonFields(paramClass).iterator();
        while (paramClass.hasNext())
        {
          localObject2 = (String)paramClass.next();
          localObject2 = (j)a.remove(localObject2);
        }
        localObject2 = new java/util/HashMap;
        ((HashMap)localObject2).<init>();
        Iterator localIterator = a.keySet().iterator();
        while (localIterator.hasNext())
        {
          paramClass = (String)localIterator.next();
          ((HashMap)localObject2).put(paramClass, paramString.a(paramClass));
        }
        ((AccountCredentialBase)localObject1).setAdditionalFields((Map)localObject2);
      }
      return (T)localObject1;
    }
    catch (s paramString)
    {
      Logger.error(a.a(new StringBuilder(), TAG, ":", "fromCacheValue"), "Failed to parse cache value.", null);
    }
    return null;
  }
  
  public String generateCacheKey(AccountRecord paramAccountRecord)
  {
    return "<home_account_id>-<environment>-<realm>".replace("<home_account_id>", sanitizeNull(paramAccountRecord.getHomeAccountId())).replace("<environment>", sanitizeNull(paramAccountRecord.getEnvironment())).replace("<realm>", sanitizeNull(paramAccountRecord.getRealm()));
  }
  
  public String generateCacheKey(Credential paramCredential)
  {
    Object localObject1 = "<home_account_id>-<environment>-<credential_type>-<client_id>-<realm>-<target>".replace("<home_account_id>", sanitizeNull(paramCredential.getHomeAccountId())).replace("<environment>", sanitizeNull(paramCredential.getEnvironment())).replace("<credential_type>", sanitizeNull(paramCredential.getCredentialType()));
    boolean bool = paramCredential instanceof RefreshTokenRecord;
    Object localObject2;
    if (bool)
    {
      localObject2 = (RefreshTokenRecord)paramCredential;
      if (!StringExtensions.isNullOrBlank(((RefreshTokenRecord)localObject2).getFamilyId()))
      {
        str = ((RefreshTokenRecord)localObject2).getFamilyId();
        localObject2 = str;
        if (str.startsWith("foci-")) {
          localObject2 = str.replace("foci-", "");
        }
        str = ((String)localObject1).replace("<client_id>", (CharSequence)localObject2);
        break label131;
      }
    }
    String str = ((String)localObject1).replace("<client_id>", sanitizeNull(paramCredential.getClientId()));
    label131:
    if ((paramCredential instanceof AccessTokenRecord))
    {
      localObject1 = (AccessTokenRecord)paramCredential;
      paramCredential = str.replace("<realm>", sanitizeNull(((AccessTokenRecord)localObject1).getRealm())).replace("<target>", sanitizeNull(((AccessTokenRecord)localObject1).getTarget()));
      localObject2 = paramCredential;
      if ("pop".equalsIgnoreCase(((AccessTokenRecord)localObject1).getAccessTokenType())) {
        localObject2 = a.b(paramCredential, "-<auth_scheme>").replace("<auth_scheme>", sanitizeNull(((AccessTokenRecord)localObject1).getAccessTokenType()));
      }
    }
    else if (bool)
    {
      paramCredential = (RefreshTokenRecord)paramCredential;
      localObject2 = str.replace("<realm>", "").replace("<target>", sanitizeNull(paramCredential.getTarget()));
    }
    else
    {
      localObject2 = str;
      if ((paramCredential instanceof IdTokenRecord)) {
        localObject2 = str.replace("<realm>", sanitizeNull(((IdTokenRecord)paramCredential).getRealm())).replace("<target>", "");
      }
    }
    return (String)localObject2;
  }
  
  public String generateCacheValue(AccountRecord paramAccountRecord)
  {
    return generateCacheValueInternal(paramAccountRecord);
  }
  
  public String generateCacheValue(Credential paramCredential)
  {
    return generateCacheValueInternal(paramCredential);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.cache.CacheKeyValueDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */