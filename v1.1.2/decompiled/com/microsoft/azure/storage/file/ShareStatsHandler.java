package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.core.Utility;
import java.io.InputStream;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public final class ShareStatsHandler
  extends DefaultHandler
{
  public static final String USAGE_NAME = "ShareUsage";
  public StringBuilder builder = new StringBuilder();
  public final Stack<String> elementStack = new Stack();
  public final ShareStats stats = new ShareStats();
  
  public static ShareStats readShareStatsFromStream(InputStream paramInputStream)
  {
    SAXParser localSAXParser = Utility.getSAXParser();
    ShareStatsHandler localShareStatsHandler = new ShareStatsHandler();
    localSAXParser.parse(paramInputStream, localShareStatsHandler);
    return stats;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    builder.append(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = (String)elementStack.pop();
    if (paramString2.equals(paramString1))
    {
      if ("ShareUsage".equals(paramString1)) {
        stats.setUsage(Integer.parseInt(builder.toString()));
      }
      builder = new StringBuilder();
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
 * Qualified Name:     com.microsoft.azure.storage.file.ShareStatsHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */