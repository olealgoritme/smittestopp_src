package com.microsoft.identity.client;

import java.util.ArrayList;

public class TokenParameters$Builder$1
  extends ArrayList<String>
{
  public TokenParameters$Builder$1(TokenParameters.Builder paramBuilder, String paramString)
  {
    paramBuilder = new StringBuilder();
    paramBuilder.append(val$resource.toLowerCase().trim());
    paramBuilder.append("/.default");
    add(paramBuilder.toString());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.TokenParameters.Builder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */