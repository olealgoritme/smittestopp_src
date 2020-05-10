package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.Utility;
import java.net.Inet4Address;

public final class IPRange
{
  public String ipMax;
  public String ipMin;
  
  public IPRange(String paramString)
  {
    Utility.assertNotNull("ip", paramString);
    validateIPAddress(paramString);
    ipMin = paramString;
    ipMax = paramString;
  }
  
  public IPRange(String paramString1, String paramString2)
  {
    Utility.assertNotNull("mininimumIP", paramString1);
    Utility.assertNotNull("maximumIP", paramString2);
    validateIPAddress(paramString1);
    validateIPAddress(paramString2);
    ipMin = paramString1;
    ipMax = paramString2;
  }
  
  public static void validateIPAddress(String paramString)
  {
    try
    {
      Inet4Address localInet4Address = (Inet4Address)Inet4Address.getByName(paramString);
      return;
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException(String.format("Error when parsing IPv4 address: IP address '%s' is invalid.", new Object[] { paramString }), localException);
    }
  }
  
  public String getIpMax()
  {
    return ipMax;
  }
  
  public String getIpMin()
  {
    return ipMin;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(ipMin);
    if (!ipMin.equals(ipMax))
    {
      localStringBuilder.append("-");
      localStringBuilder.append(ipMax);
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.IPRange
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */