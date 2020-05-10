package com.android.volley;

import android.text.TextUtils;
import e.a.a.a.a;

public final class Header
{
  public final String mName;
  public final String mValue;
  
  public Header(String paramString1, String paramString2)
  {
    mName = paramString1;
    mValue = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (Header.class == paramObject.getClass()))
    {
      paramObject = (Header)paramObject;
      if ((!TextUtils.equals(mName, mName)) || (!TextUtils.equals(mValue, mValue))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public final String getName()
  {
    return mName;
  }
  
  public final String getValue()
  {
    return mValue;
  }
  
  public int hashCode()
  {
    int i = mName.hashCode();
    return mValue.hashCode() + i * 31;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("Header[name=");
    localStringBuilder.append(mName);
    localStringBuilder.append(",value=");
    return a.a(localStringBuilder, mValue, "]");
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.Header
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */