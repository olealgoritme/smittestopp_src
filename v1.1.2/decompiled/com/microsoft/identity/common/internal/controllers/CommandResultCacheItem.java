package com.microsoft.identity.common.internal.controllers;

import java.util.Calendar;
import java.util.Date;

public class CommandResultCacheItem
{
  public static final int VALIDITY_DURATION = 30;
  public Date mExpiresOn;
  public CommandResult mValue;
  
  public CommandResultCacheItem(CommandResult paramCommandResult)
  {
    mValue = paramCommandResult;
    mExpiresOn = getExpiresOn();
  }
  
  private Date getExpiresOn()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(13, 30);
    return localCalendar.getTime();
  }
  
  public CommandResult getValue()
  {
    return mValue;
  }
  
  public boolean isExpired()
  {
    return Calendar.getInstance().getTime().after(mExpiresOn);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.controllers.CommandResultCacheItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */