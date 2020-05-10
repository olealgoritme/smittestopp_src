package com.microsoft.azure.storage;

public enum LocationMode
{
  static
  {
    LocationMode localLocationMode = new LocationMode("SECONDARY_THEN_PRIMARY", 3);
    SECONDARY_THEN_PRIMARY = localLocationMode;
    $VALUES = new LocationMode[] { PRIMARY_ONLY, PRIMARY_THEN_SECONDARY, SECONDARY_ONLY, localLocationMode };
  }
  
  public LocationMode() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.LocationMode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */