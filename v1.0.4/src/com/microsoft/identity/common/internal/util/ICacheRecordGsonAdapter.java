package com.microsoft.identity.common.internal.util;

import com.google.gson.internal.bind.TreeTypeAdapter.b;
import com.microsoft.identity.common.internal.cache.CacheRecord;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import e.c.c.h;
import e.c.c.i;
import e.c.c.j;
import java.lang.reflect.Type;

public class ICacheRecordGsonAdapter
  implements i<ICacheRecord>
{
  public ICacheRecord deserialize(j paramj, Type paramType, h paramh)
  {
    return (ICacheRecord)((TreeTypeAdapter.b)paramh).a(paramj, CacheRecord.class);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.util.ICacheRecordGsonAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */