package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.core.Utility;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BlockListHandler
  extends DefaultHandler
{
  public StringBuilder bld = new StringBuilder();
  public String blockName;
  public Long blockSize;
  public final ArrayList<BlockEntry> blocks = new ArrayList();
  public final Stack<String> elementStack = new Stack();
  public BlockSearchMode searchMode;
  
  public static ArrayList<BlockEntry> getBlockList(InputStream paramInputStream)
  {
    SAXParser localSAXParser = Utility.getSAXParser();
    BlockListHandler localBlockListHandler = new BlockListHandler();
    localSAXParser.parse(paramInputStream, localBlockListHandler);
    return blocks;
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
      if ("Block".equals(paramString3))
      {
        paramString1 = new BlockEntry(blockName, searchMode);
        paramString1.setSize(blockSize.longValue());
        blocks.add(paramString1);
      }
      else if ("Name".equals(paramString3))
      {
        blockName = paramString1;
      }
      else if ("Size".equals(paramString3))
      {
        blockSize = Long.valueOf(Long.parseLong(paramString1));
      }
      bld = new StringBuilder();
      return;
    }
    throw new SAXException("The response received is invalid or improperly formatted.");
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    elementStack.push(paramString2);
    if ("UncommittedBlocks".equals(paramString2)) {
      searchMode = BlockSearchMode.UNCOMMITTED;
    } else if ("CommittedBlocks".equals(paramString2)) {
      searchMode = BlockSearchMode.COMMITTED;
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.BlockListHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */