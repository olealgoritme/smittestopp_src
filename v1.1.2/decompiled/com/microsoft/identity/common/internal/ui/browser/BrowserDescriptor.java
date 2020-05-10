package com.microsoft.identity.common.internal.ui.browser;

import com.microsoft.identity.common.internal.util.StringUtil;
import e.c.c.v.c;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

public class BrowserDescriptor
  implements Serializable
{
  @c("browser_package_name")
  public String mPackageName;
  @c("browser_signature_hashes")
  public Set<String> mSignatureHashes;
  @c("browser_version_lower_bound")
  public String mVersionLowerBound;
  @c("browser_version_upper_bound")
  public String mVersionUpperBound;
  
  public BrowserDescriptor(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    mPackageName = paramString1;
    mSignatureHashes = Collections.singleton(paramString2);
    mVersionLowerBound = paramString3;
    mVersionUpperBound = paramString4;
  }
  
  public BrowserDescriptor(String paramString1, Set<String> paramSet, String paramString2, String paramString3)
  {
    mPackageName = paramString1;
    mSignatureHashes = paramSet;
    mVersionLowerBound = paramString2;
    mVersionUpperBound = paramString3;
  }
  
  public boolean matches(Browser paramBrowser)
  {
    if (!mPackageName.equalsIgnoreCase(paramBrowser.getPackageName())) {
      return false;
    }
    if (!mSignatureHashes.equals(paramBrowser.getSignatureHashes())) {
      return false;
    }
    if ((!StringUtil.isEmpty(mVersionLowerBound)) && (StringUtil.compareSemanticVersion(paramBrowser.getVersion(), mVersionLowerBound) == -1)) {
      return false;
    }
    return (StringUtil.isEmpty(mVersionUpperBound)) || (StringUtil.compareSemanticVersion(paramBrowser.getVersion(), mVersionUpperBound) != 1);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.ui.browser.BrowserDescriptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */