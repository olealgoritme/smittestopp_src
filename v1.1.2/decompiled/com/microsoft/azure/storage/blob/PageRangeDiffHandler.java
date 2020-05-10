package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.core.Utility;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public final class PageRangeDiffHandler
  extends DefaultHandler
{
  public StringBuilder bld = new StringBuilder();
  public final Stack<String> elementStack = new Stack();
  public long endOffset;
  public final List<PageRangeDiff> pages = new ArrayList();
  public long startOffset;
  
  public static List<PageRangeDiff> getPageRangesDiff(InputStream paramInputStream)
  {
    SAXParser localSAXParser = Utility.getSAXParser();
    PageRangeDiffHandler localPageRangeDiffHandler = new PageRangeDiffHandler();
    localSAXParser.parse(paramInputStream, localPageRangeDiffHandler);
    return pages;
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
      if ("ClearRange".equals(paramString3))
      {
        paramString1 = new PageRangeDiff(startOffset, endOffset, true);
        pages.add(paramString1);
      }
      else if ("PageRange".equals(paramString3))
      {
        paramString1 = new PageRangeDiff(startOffset, endOffset, false);
        pages.add(paramString1);
      }
      else if ("Start".equals(paramString3))
      {
        startOffset = Long.parseLong(paramString1);
      }
      else if ("End".equals(paramString3))
      {
        endOffset = Long.parseLong(paramString1);
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
 * Qualified Name:     com.microsoft.azure.storage.blob.PageRangeDiffHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */