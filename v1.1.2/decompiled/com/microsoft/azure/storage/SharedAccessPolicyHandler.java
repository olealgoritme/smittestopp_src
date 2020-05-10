package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.Utility;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SharedAccessPolicyHandler<T extends SharedAccessPolicy>
  extends DefaultHandler
{
  public StringBuilder bld = new StringBuilder();
  public final Stack<String> elementStack = new Stack();
  public String id;
  public final HashMap<String, T> policies = new HashMap();
  public T policy;
  public final Class<T> policyClassType;
  
  public SharedAccessPolicyHandler(Class<T> paramClass)
  {
    policyClassType = paramClass;
  }
  
  public static <T extends SharedAccessPolicy> HashMap<String, T> getAccessIdentifiers(InputStream paramInputStream, Class<T> paramClass)
  {
    SAXParser localSAXParser = Utility.getSAXParser();
    paramClass = new SharedAccessPolicyHandler(paramClass);
    localSAXParser.parse(paramInputStream, paramClass);
    return policies;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    bld.append(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = (String)elementStack.pop();
    if (paramString2.equals(paramString3))
    {
      paramString2 = bld.toString();
      paramString1 = paramString2;
      if (paramString2.isEmpty()) {
        paramString1 = null;
      }
      if ("SignedIdentifier".equals(paramString3)) {
        policies.put(id, policy);
      } else if ("Id".equals(paramString3)) {
        id = paramString1;
      } else if ("Start".equals(paramString3)) {
        try
        {
          policy.setSharedAccessStartTime(Utility.parseDate(paramString1));
        }
        catch (IllegalArgumentException paramString1)
        {
          throw new SAXException(paramString1);
        }
      } else if ("Expiry".equals(paramString3)) {
        try
        {
          policy.setSharedAccessExpiryTime(Utility.parseDate(paramString1));
        }
        catch (IllegalArgumentException paramString1)
        {
          throw new SAXException(paramString1);
        }
      } else if ("Permission".equals(paramString3)) {
        policy.setPermissionsFromString(paramString1);
      }
      bld = new StringBuilder();
      return;
    }
    throw new SAXException("The response received is invalid or improperly formatted.");
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    elementStack.push(paramString2);
    if ("SignedIdentifier".equals(paramString2))
    {
      id = null;
      try
      {
        policy = ((SharedAccessPolicy)policyClassType.newInstance());
      }
      catch (Exception paramString1)
      {
        throw new SAXException(paramString1);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.SharedAccessPolicyHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */