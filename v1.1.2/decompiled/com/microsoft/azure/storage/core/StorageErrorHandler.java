package com.microsoft.azure.storage.core;

import com.microsoft.azure.storage.StorageExtendedErrorInformation;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public final class StorageErrorHandler
  extends DefaultHandler
{
  public StringBuilder bld = new StringBuilder();
  public final Stack<String> elementStack = new Stack();
  public final StorageExtendedErrorInformation errorInfo = new StorageExtendedErrorInformation();
  
  public static StorageExtendedErrorInformation getExtendedErrorInformation(InputStream paramInputStream)
  {
    SAXParser localSAXParser = Utility.getSAXParser();
    StorageErrorHandler localStorageErrorHandler = new StorageErrorHandler();
    localSAXParser.parse(paramInputStream, localStorageErrorHandler);
    return errorInfo;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    bld.append(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    String str = (String)elementStack.pop();
    if (paramString2.equals(str))
    {
      boolean bool = elementStack.isEmpty();
      paramString2 = null;
      if (!bool) {
        paramString1 = (String)elementStack.peek();
      } else {
        paramString1 = null;
      }
      paramString3 = bld.toString();
      if (!paramString3.isEmpty()) {
        paramString2 = paramString3;
      }
      if ("Error".equals(paramString1))
      {
        if ("Code".equals(str)) {
          errorInfo.setErrorCode(paramString2);
        } else if ("Message".equals(str)) {
          errorInfo.setErrorMessage(paramString2);
        } else {
          errorInfo.getAdditionalDetails().put(str, new String[] { paramString2 });
        }
      }
      else if ("ExceptionDetails".equals(paramString1)) {
        errorInfo.getAdditionalDetails().put(str, new String[] { paramString2 });
      }
      bld = new StringBuilder();
      return;
    }
    throw new SAXException("The response received is invalid or improperly formatted.");
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    elementStack.push(paramString2);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.core.StorageErrorHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */