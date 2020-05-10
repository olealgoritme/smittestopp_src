package com.microsoft.appcenter.crashes;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

public class Crashes$5
  implements ComponentCallbacks2
{
  public Crashes$5(Crashes paramCrashes) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory()
  {
    Crashes.access$400(80);
  }
  
  public void onTrimMemory(int paramInt)
  {
    Crashes.access$400(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.crashes.Crashes.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */