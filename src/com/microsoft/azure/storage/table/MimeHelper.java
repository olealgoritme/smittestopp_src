package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.core.PathUtility;
import com.microsoft.azure.storage.core.UriQueryBuilder;
import com.microsoft.azure.storage.core.Utility;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class MimeHelper
{
  public static String generateAcceptHeaderValue(TablePayloadFormat paramTablePayloadFormat)
  {
    if (paramTablePayloadFormat == TablePayloadFormat.JsonFullMetadata) {
      return "application/json;odata=fullmetadata";
    }
    if (paramTablePayloadFormat == TablePayloadFormat.Json) {
      return "application/json;odata=minimalmetadata";
    }
    return "application/json;odata=nometadata";
  }
  
  public static StorageException generateMimeParseException()
  {
    return new StorageException("OutOfRangeInput", "Invalid MIME response received.", 306, null, null);
  }
  
  public static String getNextLineSkippingBlankLines(BufferedReader paramBufferedReader)
  {
    String str;
    do
    {
      str = paramBufferedReader.readLine();
    } while ((str != null) && (str.length() == 0));
    return str;
  }
  
  public static ArrayList<MimePart> readBatchResponseStream(InputStream paramInputStream, String paramString, OperationContext paramOperationContext, TablePayloadFormat paramTablePayloadFormat)
  {
    paramTablePayloadFormat = new ArrayList();
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
    String str = "--".concat(paramString);
    MimeHeader localMimeHeader = readMimeHeader(paramInputStream, paramOperationContext);
    paramString = boundary;
    if ((paramString != null) && (paramString.equals(str)))
    {
      if (subBoundary == null)
      {
        do
        {
          paramTablePayloadFormat.add(readMimePart(paramInputStream, boundary, paramOperationContext));
        } while (readMimeHeader(paramInputStream, paramOperationContext) != null);
      }
      else
      {
        if (readMimeHeader(paramInputStream, paramOperationContext) == null) {
          break label127;
        }
        do
        {
          paramTablePayloadFormat.add(readMimePart(paramInputStream, subBoundary, paramOperationContext));
        } while (readMimeHeader(paramInputStream, paramOperationContext) != null);
      }
      return paramTablePayloadFormat;
      label127:
      throw generateMimeParseException();
    }
    throw generateMimeParseException();
  }
  
  public static MimeHeader readMimeHeader(BufferedReader paramBufferedReader, OperationContext paramOperationContext)
  {
    paramOperationContext = new MimeHeader();
    paramBufferedReader.mark(1048576);
    Object localObject = getNextLineSkippingBlankLines(paramBufferedReader);
    boundary = ((String)localObject);
    if (((String)localObject).endsWith("--")) {
      return null;
    }
    if (!boundary.startsWith("--"))
    {
      paramBufferedReader.reset();
      return null;
    }
    int i = 0;
    while (i < 2)
    {
      localObject = paramBufferedReader.readLine();
      if ((localObject != null) && (((String)localObject).length() != 0))
      {
        if (((String)localObject).startsWith("Content-Type:"))
        {
          localObject = ((String)localObject).split("Content-Type: ");
          if ((localObject != null) && (localObject.length == 2)) {
            contentType = localObject[1];
          } else {
            throw generateMimeParseException();
          }
        }
        else
        {
          if (!((String)localObject).startsWith("Content-Transfer-Encoding:")) {
            break label162;
          }
          localObject = ((String)localObject).split("Content-Transfer-Encoding: ");
          if ((localObject == null) || (localObject.length != 2)) {
            break label158;
          }
          contentTransferEncoding = localObject[1];
        }
        i++;
        continue;
        label158:
        throw generateMimeParseException();
        label162:
        throw generateMimeParseException();
      }
    }
    if (!Utility.isNullOrEmpty(boundary))
    {
      paramBufferedReader = contentType;
      if (paramBufferedReader != null)
      {
        if (paramBufferedReader.startsWith("multipart/mixed; boundary="))
        {
          paramBufferedReader = contentType.split("multipart/mixed; boundary=");
          if ((paramBufferedReader != null) && (paramBufferedReader.length == 2)) {
            subBoundary = "--".concat(paramBufferedReader[1]);
          } else {
            throw generateMimeParseException();
          }
        }
        else
        {
          if (!contentType.equals("application/http")) {
            break label272;
          }
        }
        paramBufferedReader = contentTransferEncoding;
        if ((paramBufferedReader != null) && (!paramBufferedReader.equals("binary"))) {
          throw generateMimeParseException();
        }
        return paramOperationContext;
        label272:
        throw generateMimeParseException();
      }
    }
    throw generateMimeParseException();
  }
  
  public static MimePart readMimePart(BufferedReader paramBufferedReader, String paramString, OperationContext paramOperationContext)
  {
    MimePart localMimePart = new MimePart();
    Object localObject = getNextLineSkippingBlankLines(paramBufferedReader);
    if (((String)localObject).startsWith("HTTP/1.1 "))
    {
      paramOperationContext = ((String)localObject).split(" ");
      if (paramOperationContext.length >= 3)
      {
        httpStatusCode = Integer.parseInt(paramOperationContext[1]);
        httpStatusMessage = ((String)localObject).substring(13);
        paramOperationContext = paramBufferedReader.readLine();
        while ((paramOperationContext != null) && (paramOperationContext.length() > 0))
        {
          paramOperationContext = paramOperationContext.split(": ");
          if (paramOperationContext.length >= 2)
          {
            headers.put(paramOperationContext[0], paramOperationContext[1]);
            paramOperationContext = paramBufferedReader.readLine();
          }
          else
          {
            throw generateMimeParseException();
          }
        }
        paramBufferedReader.mark(1048576);
        paramOperationContext = getNextLineSkippingBlankLines(paramBufferedReader);
        if (paramOperationContext != null)
        {
          if (paramOperationContext.startsWith(paramString))
          {
            paramBufferedReader.reset();
            payload = "";
            return localMimePart;
          }
          localObject = new StringBuilder();
          while (!paramOperationContext.startsWith(paramString))
          {
            ((StringBuilder)localObject).append(paramOperationContext);
            paramBufferedReader.mark(1048576);
            paramOperationContext = getNextLineSkippingBlankLines(paramBufferedReader);
            if (paramOperationContext == null) {
              throw generateMimeParseException();
            }
          }
          paramBufferedReader.reset();
          payload = ((StringBuilder)localObject).toString();
          return localMimePart;
        }
        throw generateMimeParseException();
      }
      throw generateMimeParseException();
    }
    throw generateMimeParseException();
  }
  
  public static void writeBatchToStream(OutputStream paramOutputStream, TableRequestOptions paramTableRequestOptions, String paramString1, URI paramURI, TableBatchOperation paramTableBatchOperation, String paramString2, String paramString3, OperationContext paramOperationContext)
  {
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramOutputStream, "UTF-8");
    int i = paramTableBatchOperation.size();
    int j = 1;
    int k = 0;
    if ((i != 1) || (((TableOperation)paramTableBatchOperation.get(0)).getOperationType() != TableOperationType.RETRIEVE)) {
      j = 0;
    }
    if (j != 0)
    {
      paramOutputStream = (QueryTableOperation)paramTableBatchOperation.get(0);
      writeMIMEBoundary(localOutputStreamWriter, paramString2);
      paramTableBatchOperation = new MimePart();
      op = paramOutputStream.getOperationType();
      requestIdentity = new UriQueryBuilder().addToURI(PathUtility.appendPathToSingleUri(paramURI, paramOutputStream.generateRequestIdentityWithTable(paramString1)));
      headers.put("Accept", generateAcceptHeaderValue(paramTableRequestOptions.getTablePayloadFormat()));
      headers.put("MaxDataServiceVersion", "3.0");
      localOutputStreamWriter.write(paramTableBatchOperation.toRequestString());
    }
    else
    {
      writeMIMEBoundary(localOutputStreamWriter, paramString2);
      writeMIMEContentType(localOutputStreamWriter, paramString3);
      localOutputStreamWriter.write("\r\n");
      paramTableBatchOperation = paramTableBatchOperation.iterator();
      while (paramTableBatchOperation.hasNext())
      {
        TableOperation localTableOperation = (TableOperation)paramTableBatchOperation.next();
        writeMIMEBoundary(localOutputStreamWriter, paramString3);
        MimePart localMimePart = new MimePart();
        op = localTableOperation.getOperationType();
        requestIdentity = new UriQueryBuilder().addToURI(PathUtility.appendPathToSingleUri(paramURI, localTableOperation.generateRequestIdentityWithTable(paramString1)));
        headers.put("Content-ID", Integer.toString(k));
        headers.put("Accept", generateAcceptHeaderValue(paramTableRequestOptions.getTablePayloadFormat()));
        headers.put("MaxDataServiceVersion", "3.0");
        Object localObject;
        if ((localTableOperation.getOperationType() == TableOperationType.INSERT_OR_MERGE) || (localTableOperation.getOperationType() == TableOperationType.MERGE))
        {
          paramTableRequestOptions.assertNoEncryptionPolicyOrStrictMode();
          paramOutputStream = headers;
          localObject = TableOperationType.MERGE;
          paramOutputStream.put("X-HTTP-Method", "MERGE");
        }
        if (((localTableOperation.getOperationType() == TableOperationType.DELETE) || (localTableOperation.getOperationType() == TableOperationType.REPLACE) || (localTableOperation.getOperationType() == TableOperationType.MERGE)) && (localTableOperation.getEntity() != null) && (localTableOperation.getEntity().getEtag() != null)) {
          headers.put("If-Match", localTableOperation.getEntity().getEtag());
        }
        if (localTableOperation.getOperationType() == TableOperationType.INSERT)
        {
          localObject = headers;
          if (localTableOperation.getEchoContent()) {
            paramOutputStream = "return-content";
          } else {
            paramOutputStream = "return-no-content";
          }
          ((HashMap)localObject).put("Prefer", paramOutputStream);
        }
        if (localTableOperation.getOperationType() != TableOperationType.DELETE)
        {
          headers.put("Content-Type", "application/json");
          paramOutputStream = writeStringForOperation(localTableOperation, paramTableRequestOptions, paramOperationContext);
          payload = paramOutputStream;
          headers.put("Content-Length", Integer.toString(paramOutputStream.getBytes("UTF-8").length));
        }
        localOutputStreamWriter.write(localMimePart.toRequestString());
        k++;
      }
    }
    if (j == 0) {
      writeMIMEBoundaryClosure(localOutputStreamWriter, paramString3);
    }
    writeMIMEBoundaryClosure(localOutputStreamWriter, paramString2);
    localOutputStreamWriter.flush();
  }
  
  public static void writeMIMEBoundary(OutputStreamWriter paramOutputStreamWriter, String paramString)
  {
    paramOutputStreamWriter.write(String.format("--%s\r\n", new Object[] { paramString }));
  }
  
  public static void writeMIMEBoundaryClosure(OutputStreamWriter paramOutputStreamWriter, String paramString)
  {
    paramOutputStreamWriter.write(String.format("--%s--\r\n", new Object[] { paramString }));
  }
  
  public static void writeMIMEContentType(OutputStreamWriter paramOutputStreamWriter, String paramString)
  {
    paramOutputStreamWriter.write(String.format("Content-Type: multipart/mixed; boundary=%s\r\n", new Object[] { paramString }));
  }
  
  public static String writeStringForOperation(TableOperation paramTableOperation, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("entity", paramTableOperation.getEntity());
    StringWriter localStringWriter = new StringWriter();
    TableEntitySerializer.writeSingleEntityToString(localStringWriter, paramTableRequestOptions, paramTableOperation.getEntity(), false, paramOperationContext);
    localStringWriter.write("\r\n");
    return localStringWriter.toString();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.MimeHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */