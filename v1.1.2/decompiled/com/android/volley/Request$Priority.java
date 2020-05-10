package com.android.volley;

public enum Request$Priority
{
  static
  {
    HIGH = new Priority("HIGH", 2);
    Priority localPriority = new Priority("IMMEDIATE", 3);
    IMMEDIATE = localPriority;
    $VALUES = new Priority[] { LOW, NORMAL, HIGH, localPriority };
  }
  
  public Request$Priority() {}
}

/* Location:
 * Qualified Name:     com.android.volley.Request.Priority
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */