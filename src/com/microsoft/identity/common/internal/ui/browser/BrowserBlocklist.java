package com.microsoft.identity.common.internal.ui.browser;

import com.microsoft.identity.common.internal.logging.Logger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BrowserBlocklist
{
  public static final String TAG = "BrowserBlocklist";
  public List<Browser> mBrowsers;
  
  public BrowserBlocklist(Browser... paramVarArgs)
  {
    mBrowsers = Arrays.asList(paramVarArgs);
  }
  
  public boolean matches(Browser paramBrowser)
  {
    Iterator localIterator = mBrowsers.iterator();
    while (localIterator.hasNext()) {
      if (((Browser)localIterator.next()).equals(paramBrowser))
      {
        Logger.verbose(TAG, "The target browser is in the block list.");
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.browser.BrowserBlocklist
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */