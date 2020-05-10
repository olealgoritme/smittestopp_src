package com.microsoft.azure.storage.core;

import java.net.HttpURLConnection;
import java.security.InvalidParameterException;

public final class TableCanonicalizer
  extends Canonicalizer
{
  public String canonicalize(HttpURLConnection paramHttpURLConnection, String paramString, Long paramLong)
  {
    if (paramLong.longValue() >= -1L) {
      return Canonicalizer.canonicalizeTableHttpRequest(paramHttpURLConnection.getURL(), paramString, paramHttpURLConnection.getRequestMethod(), Utility.getStandardHeaderValue(paramHttpURLConnection, "Content-Type"), paramLong.longValue(), null, paramHttpURLConnection);
    }
    throw new InvalidParameterException("ContentLength must be set to -1 or positive Long value.");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.core.TableCanonicalizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */