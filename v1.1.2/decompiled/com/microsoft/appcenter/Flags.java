package com.microsoft.appcenter;

import com.microsoft.appcenter.utils.AppCenterLog;

public final class Flags
{
  public static final int CRITICAL = 2;
  public static final int DEFAULTS = 1;
  public static final int NORMAL = 1;
  @Deprecated
  public static final int PERSISTENCE_CRITICAL = 2;
  public static final int PERSISTENCE_MASK = 255;
  @Deprecated
  public static final int PERSISTENCE_NORMAL = 1;
  
  public static int getPersistenceFlag(int paramInt, boolean paramBoolean)
  {
    int i = paramInt & 0xFF;
    paramInt = i;
    if (i != 1)
    {
      paramInt = i;
      if (i != 2)
      {
        if ((i != 0) && (paramBoolean))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Invalid value=");
          localStringBuilder.append(i);
          localStringBuilder.append(" for persistence flag, using NORMAL as a default.");
          AppCenterLog.warn("AppCenter", localStringBuilder.toString());
        }
        paramInt = 1;
      }
    }
    return paramInt;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.Flags
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */