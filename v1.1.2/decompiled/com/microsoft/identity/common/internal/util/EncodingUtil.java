package com.microsoft.identity.common.internal.util;

import android.util.Base64;
import java.nio.charset.Charset;

public final class EncodingUtil
{
  public static String base64UrlEncodeToString(String paramString)
  {
    return Base64.encodeToString(paramString.getBytes(Charset.forName("UTF-8")), 10);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.util.EncodingUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */