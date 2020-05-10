package com.microsoft.azure.storage;

public enum SharedAccessProtocols
{
  public final String protocols;
  
  static
  {
    SharedAccessProtocols localSharedAccessProtocols = new SharedAccessProtocols("HTTPS_HTTP", 1, "https,http");
    HTTPS_HTTP = localSharedAccessProtocols;
    $VALUES = new SharedAccessProtocols[] { HTTPS_ONLY, localSharedAccessProtocols };
  }
  
  public SharedAccessProtocols(String paramString)
  {
    protocols = paramString;
  }
  
  public String toString()
  {
    return protocols;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.SharedAccessProtocols
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */