package com.microsoft.appcenter.utils;

import java.util.HashMap;
import java.util.Map;

public class TicketCache
{
  public static final Map<String, String> sTickets = new HashMap();
  
  public static void clear()
  {
    sTickets.clear();
  }
  
  public static String getTicket(String paramString)
  {
    return (String)sTickets.get(paramString);
  }
  
  public static void putTicket(String paramString1, String paramString2)
  {
    sTickets.put(paramString1, paramString2);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.TicketCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */