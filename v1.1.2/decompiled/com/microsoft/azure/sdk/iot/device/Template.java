package com.microsoft.azure.sdk.iot.device;

import java.util.HashSet;
import java.util.Set;

public class Template
{
  public Object templateTestPrivate;
  public Object templateTestPublic;
  public Set unionSet;
  
  public Template(Object paramObject)
  {
    if (paramObject != null)
    {
      templateTestPrivate = paramObject;
      templateTestPublic = new Object();
      return;
    }
    throw new IllegalArgumentException("Tag cannot be null");
  }
  
  public void addToSet(Set<?> paramSet)
  {
    if ((paramSet != null) && (paramSet.size() != 0))
    {
      Set localSet = unionSet;
      if (localSet != null)
      {
        localSet.addAll(paramSet);
        return;
      }
      throw new IllegalStateException("Please open before use");
    }
    throw new IllegalArgumentException("New set cannot be null or empty");
  }
  
  public void close()
  {
    Set localSet = unionSet;
    if (localSet == null) {
      return;
    }
    localSet.clear();
    unionSet = null;
    templateTestPublic = null;
    templateTestPrivate = null;
  }
  
  public Object getTemplateTestPrivate()
  {
    return templateTestPrivate;
  }
  
  public Set<?> getUnionSet()
  {
    return unionSet;
  }
  
  public void open()
  {
    if (unionSet == null) {
      unionSet = new HashSet();
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.Template
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */