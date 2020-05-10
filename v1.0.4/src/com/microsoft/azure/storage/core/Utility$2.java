package com.microsoft.azure.storage.core;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public final class Utility$2
  extends ThreadLocal<SAXParser>
{
  public SAXParserFactory factory;
  
  public SAXParser initialValue()
  {
    Object localObject = SAXParserFactory.newInstance();
    factory = ((SAXParserFactory)localObject);
    ((SAXParserFactory)localObject).setNamespaceAware(true);
    try
    {
      localObject = factory.newSAXParser();
      return (SAXParser)localObject;
    }
    catch (ParserConfigurationException localParserConfigurationException)
    {
      throw new RuntimeException("Check parser configuration", localParserConfigurationException);
    }
    catch (SAXException localSAXException)
    {
      throw new RuntimeException("Unable to create SAXParser", localSAXException);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.Utility.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */