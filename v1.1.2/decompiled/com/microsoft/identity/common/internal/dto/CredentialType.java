package com.microsoft.identity.common.internal.dto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum CredentialType
{
  public static final CredentialType[] ID_TOKEN_TYPES;
  
  static
  {
    AccessToken = new CredentialType("AccessToken", 1);
    IdToken = new CredentialType("IdToken", 2);
    V1IdToken = new CredentialType("V1IdToken", 3);
    Password = new CredentialType("Password", 4);
    Cookie = new CredentialType("Cookie", 5);
    Certificate = new CredentialType("Certificate", 6);
    CredentialType localCredentialType1 = new CredentialType("AccessToken_With_AuthScheme", 7);
    AccessToken_With_AuthScheme = localCredentialType1;
    CredentialType localCredentialType2 = RefreshToken;
    CredentialType localCredentialType3 = AccessToken;
    CredentialType localCredentialType4 = IdToken;
    CredentialType localCredentialType5 = V1IdToken;
    $VALUES = new CredentialType[] { localCredentialType2, localCredentialType3, localCredentialType4, localCredentialType5, Password, Cookie, Certificate, localCredentialType1 };
    ID_TOKEN_TYPES = new CredentialType[] { localCredentialType4, localCredentialType5 };
  }
  
  public CredentialType() {}
  
  public static CredentialType fromString(String paramString)
  {
    for (CredentialType localCredentialType : ) {
      if (localCredentialType.name().equalsIgnoreCase(paramString)) {
        return localCredentialType;
      }
    }
    return null;
  }
  
  public static Set<String> valueSet()
  {
    HashSet localHashSet = new HashSet();
    CredentialType[] arrayOfCredentialType = values();
    int i = arrayOfCredentialType.length;
    for (int j = 0; j < i; j++) {
      localHashSet.add(arrayOfCredentialType[j].name());
    }
    return Collections.unmodifiableSet(localHashSet);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.dto.CredentialType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */