package com.microsoft.azure.sdk.iot.device.DeviceTwin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class Device
  implements PropertyCallBack<String, Object>
{
  public HashMap<Property, Pair<PropertyCallBack<String, Object>, Object>> desiredProp = new HashMap();
  public HashSet<Property> reportedProp = new HashSet();
  
  public void clean()
  {
    Object localObject = reportedProp;
    if (localObject != null)
    {
      localObject = ((HashSet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ((Iterator)localObject).next();
        ((Iterator)localObject).remove();
      }
    }
    localObject = desiredProp;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ((Iterator)localObject).next();
        ((Iterator)localObject).remove();
      }
    }
  }
  
  public HashMap<Property, Pair<PropertyCallBack<String, Object>, Object>> getDesiredProp()
  {
    return desiredProp;
  }
  
  public HashSet<Property> getReportedProp()
  {
    return reportedProp;
  }
  
  public void setDesiredPropertyCallback(Property paramProperty, PropertyCallBack<String, Object> paramPropertyCallBack, Object paramObject)
  {
    if (paramProperty != null)
    {
      desiredProp.put(paramProperty, new Pair(paramPropertyCallBack, paramObject));
      return;
    }
    throw new IllegalArgumentException("desired property cannot be null");
  }
  
  public void setReportedProp(Property paramProperty)
  {
    if (paramProperty != null)
    {
      Object localObject = null;
      Iterator localIterator = reportedProp.iterator();
      while (localIterator.hasNext())
      {
        Property localProperty = (Property)localIterator.next();
        if (localProperty.getKey().equalsIgnoreCase(paramProperty.getKey())) {
          localObject = localProperty;
        }
      }
      if (localObject != null) {
        reportedProp.remove(localObject);
      }
      reportedProp.add(paramProperty);
      return;
    }
    throw new IllegalArgumentException("Reported property cannot be null");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.DeviceTwin.Device
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */