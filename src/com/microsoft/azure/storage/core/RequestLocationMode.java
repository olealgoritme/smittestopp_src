package com.microsoft.azure.storage.core;

public enum RequestLocationMode
{
  static
  {
    RequestLocationMode localRequestLocationMode = new RequestLocationMode("PRIMARY_OR_SECONDARY", 2);
    PRIMARY_OR_SECONDARY = localRequestLocationMode;
    $VALUES = new RequestLocationMode[] { PRIMARY_ONLY, SECONDARY_ONLY, localRequestLocationMode };
  }
  
  public RequestLocationMode() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.RequestLocationMode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */