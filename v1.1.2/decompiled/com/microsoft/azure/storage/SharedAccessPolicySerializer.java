package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.Utility;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.xml.stream.XMLStreamWriter;

public final class SharedAccessPolicySerializer
{
  public static <T extends SharedAccessPolicy> void writeSharedAccessIdentifiersToStream(HashMap<String, T> paramHashMap, StringWriter paramStringWriter)
  {
    Utility.assertNotNull("sharedAccessPolicies", paramHashMap);
    Utility.assertNotNull("outWriter", paramStringWriter);
    paramStringWriter = Utility.createXMLStreamWriter(paramStringWriter);
    if (paramHashMap.keySet().size() <= 5)
    {
      paramStringWriter.writeStartDocument();
      paramStringWriter.writeStartElement("SignedIdentifiers");
      Iterator localIterator = paramHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramHashMap = (Map.Entry)localIterator.next();
        SharedAccessPolicy localSharedAccessPolicy = (SharedAccessPolicy)paramHashMap.getValue();
        paramStringWriter.writeStartElement("SignedIdentifier");
        paramStringWriter.writeStartElement("Id");
        paramStringWriter.writeCharacters((String)paramHashMap.getKey());
        paramStringWriter.writeEndElement();
        paramStringWriter.writeStartElement("AccessPolicy");
        paramStringWriter.writeStartElement("Start");
        paramStringWriter.writeCharacters(Utility.getUTCTimeOrEmpty(localSharedAccessPolicy.getSharedAccessStartTime()));
        paramStringWriter.writeEndElement();
        paramStringWriter.writeStartElement("Expiry");
        paramStringWriter.writeCharacters(Utility.getUTCTimeOrEmpty(localSharedAccessPolicy.getSharedAccessExpiryTime()));
        paramStringWriter.writeEndElement();
        paramStringWriter.writeStartElement("Permission");
        paramStringWriter.writeCharacters(localSharedAccessPolicy.permissionsToString());
        paramStringWriter.writeEndElement();
        paramStringWriter.writeEndElement();
        paramStringWriter.writeEndElement();
      }
      paramStringWriter.writeEndElement();
      paramStringWriter.writeEndDocument();
      return;
    }
    throw new IllegalArgumentException(String.format("Too many %d shared access policy identifiers provided. Server does not support setting more than %d on a single container, queue, or table.", new Object[] { Integer.valueOf(paramHashMap.keySet().size()), Integer.valueOf(5) }));
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.SharedAccessPolicySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */