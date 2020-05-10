package com.microsoft.azure.storage.blob;

public enum LeaseAction
{
  static
  {
    RELEASE = new LeaseAction("RELEASE", 2);
    BREAK = new LeaseAction("BREAK", 3);
    LeaseAction localLeaseAction = new LeaseAction("CHANGE", 4);
    CHANGE = localLeaseAction;
    $VALUES = new LeaseAction[] { ACQUIRE, RENEW, RELEASE, BREAK, localLeaseAction };
  }
  
  public LeaseAction() {}
  
  public String toString()
  {
    int i = ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return "";
            }
            return "Change";
          }
          return "Break";
        }
        return "Release";
      }
      return "Renew";
    }
    return "Acquire";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.LeaseAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */