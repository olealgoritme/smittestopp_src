package com.microsoft.azure.sdk.iot.deps.twin;

import e.c.c.j;
import e.c.c.m;
import e.c.c.v.a;
import e.c.c.v.c;

public class TwinProperties
{
  public static final String DESIRED_PROPERTIES_TAG = "desired";
  public static final String REPORTED_PROPERTIES_TAG = "reported";
  @a(deserialize=true, serialize=true)
  @c("desired")
  public TwinCollection desired;
  @a(deserialize=true, serialize=true)
  @c("reported")
  public TwinCollection reported;
  
  public TwinProperties() {}
  
  public TwinProperties(TwinCollection paramTwinCollection1, TwinCollection paramTwinCollection2)
  {
    if ((paramTwinCollection1 == null) && (paramTwinCollection2 == null)) {
      throw new IllegalArgumentException("Desired property cannot be null.");
    }
    if (paramTwinCollection1 != null) {
      desired = TwinCollection.createFromRawCollection(paramTwinCollection1);
    }
    if (paramTwinCollection2 != null) {
      reported = TwinCollection.createFromRawCollection(paramTwinCollection2);
    }
  }
  
  public TwinCollection getDesired()
  {
    if (desired == null) {
      return null;
    }
    return new TwinCollection(desired);
  }
  
  public TwinCollection getReported()
  {
    if (reported == null) {
      return null;
    }
    return new TwinCollection(reported);
  }
  
  public j toJsonElement()
  {
    m localm = new m();
    TwinCollection localTwinCollection = desired;
    if (localTwinCollection != null) {
      localm.a("desired", localTwinCollection.toJsonElement());
    }
    localTwinCollection = reported;
    if (localTwinCollection != null) {
      localm.a("reported", localTwinCollection.toJsonElement());
    }
    return localm;
  }
  
  public j toJsonElementWithMetadata()
  {
    m localm = new m();
    TwinCollection localTwinCollection = desired;
    if (localTwinCollection != null) {
      localm.a("desired", localTwinCollection.toJsonElementWithMetadata());
    }
    localTwinCollection = reported;
    if (localTwinCollection != null) {
      localm.a("reported", localTwinCollection.toJsonElementWithMetadata());
    }
    return localm;
  }
  
  public String toString()
  {
    return toJsonElementWithMetadata().toString();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.twin.TwinProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */