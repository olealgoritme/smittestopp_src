package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.core.Utility;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public final class FileRangeHandler
  extends DefaultHandler
{
  public StringBuilder bld = new StringBuilder();
  public final Stack<String> elementStack = new Stack();
  public long endOffset;
  public final ArrayList<FileRange> fileRanges = new ArrayList();
  public long startOffset;
  
  public static ArrayList<FileRange> getFileRanges(InputStream paramInputStream)
  {
    SAXParser localSAXParser = Utility.getSAXParser();
    FileRangeHandler localFileRangeHandler = new FileRangeHandler();
    localSAXParser.parse(paramInputStream, localFileRangeHandler);
    return fileRanges;
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
      if ("Range".equals(paramString3))
      {
        paramString1 = new FileRange(startOffset, endOffset);
        fileRanges.add(paramString1);
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
 * Qualified Name:     base.com.microsoft.azure.storage.file.FileRangeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */