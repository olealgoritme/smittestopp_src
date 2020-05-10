package com.microsoft.identity.client.claims;

public class WWWAuthenticateHeader
{
  public static final String CLAIMS_DIRECTIVE = "claims=";
  public static final char COMMA = ',';
  public static final char DOUBLE_QUOTE = '"';
  public static final char SINGLE_QUOTE = '\'';
  public static final char SPACE = ' ';
  
  public static ClaimsRequest getClaimsRequestFromWWWAuthenticateHeaderValue(String paramString)
  {
    int i = paramString.indexOf("claims=");
    if (i == -1) {
      return null;
    }
    i += 7;
    int j = i + 1;
    int k = paramString.substring(i, j).charAt(0);
    if (k == 39)
    {
      paramString = paramString.substring(j, paramString.indexOf('\'', j));
    }
    else if (k == 34)
    {
      paramString = paramString.substring(j, paramString.indexOf("}\"", j) + 1);
    }
    else
    {
      k = paramString.indexOf(',', i);
      j = paramString.indexOf(' ', i);
      if ((k == -1) && (j == -1)) {
        paramString = paramString.substring(i);
      } else if (k != -1) {
        paramString = paramString.substring(i, k);
      } else {
        paramString = paramString.substring(i, j);
      }
    }
    return ClaimsRequest.getClaimsRequestFromJsonString(paramString);
  }
  
  public static Boolean hasClaimsDirective(String paramString)
  {
    if (paramString.indexOf("claims=") == -1) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.claims.WWWAuthenticateHeader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */