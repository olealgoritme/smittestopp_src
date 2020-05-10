package com.microsoft.azure.storage.analytics;

import com.microsoft.azure.storage.core.Utility;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

public class LogRecordStreamReader
  extends InputStreamReader
{
  public static final char FIELD_DELIMITER = ';';
  public static final char QUOTE_CHAR = '"';
  public static final char RECORD_DELIMITER = '\n';
  public boolean isFirstFieldInRecord = true;
  public Integer peekedCharacter = null;
  
  public LogRecordStreamReader(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  private void readDelimiter(char paramChar)
  {
    if (!isEndOfFile())
    {
      int i = read();
      if ((i != -1) && ((char)i == paramChar)) {
        return;
      }
      throw new IllegalStateException("Error parsing log record: unexpected delimiter encountered.");
    }
    throw new EOFException("Error parsing log record: unexpected end of stream.");
  }
  
  private String readField(boolean paramBoolean)
  {
    boolean bool = isFirstFieldInRecord;
    int i = 0;
    if (!bool) {
      readDelimiter(';');
    } else {
      isFirstFieldInRecord = false;
    }
    Object localObject = new StringBuilder();
    int j = 0;
    while (!isEndOfFile())
    {
      char c = (char)peek();
      if (((paramBoolean) && (i == 0) && (((StringBuilder)localObject).length() != 0)) || ((c != ';') && (c != '\n')))
      {
        if (i == 0)
        {
          read();
          ((StringBuilder)localObject).append(c);
          if (c == '"') {
            if (paramBoolean)
            {
              if (((StringBuilder)localObject).length() == 1) {
                j = 1;
              } else if (j != 0) {
                i = 1;
              } else {
                throw new IllegalStateException("Error parsing log record: unexpected quote character encountered.");
              }
            }
            else {
              throw new IllegalStateException("Error parsing log record: unexpected quote character encountered.");
            }
          }
        }
        else
        {
          throw new IllegalStateException("Error parsing log record: unexpected quote character encountered.");
        }
      }
      else
      {
        if ((paramBoolean) && (((StringBuilder)localObject).length() != 0)) {
          localObject = ((StringBuilder)localObject).substring(1, ((StringBuilder)localObject).length() - 1);
        } else {
          localObject = ((StringBuilder)localObject).toString();
        }
        return (String)localObject;
      }
    }
    throw new EOFException("Error parsing log record: unexpected end of stream.");
  }
  
  private boolean tryPeekDelimiter(char paramChar)
  {
    if (!isEndOfFile()) {
      return (char)peek() == paramChar;
    }
    throw new EOFException("Error parsing log record: unexpected end of stream.");
  }
  
  public void endCurrentRecord()
  {
    readDelimiter('\n');
    isFirstFieldInRecord = true;
  }
  
  public boolean hasMoreFieldsInRecord()
  {
    return tryPeekDelimiter(';');
  }
  
  public boolean isEndOfFile()
  {
    boolean bool;
    if (peek() == -1) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int peek()
  {
    Integer localInteger = peekedCharacter;
    if (localInteger != null) {
      return localInteger.intValue();
    }
    localInteger = Integer.valueOf(super.read());
    peekedCharacter = localInteger;
    return localInteger.intValue();
  }
  
  public int read()
  {
    Integer localInteger = peekedCharacter;
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      peekedCharacter = null;
      return i;
    }
    return super.read();
  }
  
  public Boolean readBoolean()
  {
    String str = readField(false);
    if (Utility.isNullOrEmpty(str)) {
      return null;
    }
    return Boolean.valueOf(Boolean.parseBoolean(str));
  }
  
  public Date readDate(DateFormat paramDateFormat)
  {
    String str = readField(false);
    if (Utility.isNullOrEmpty(str)) {
      return null;
    }
    return paramDateFormat.parse(str);
  }
  
  public Double readDouble()
  {
    String str = readField(false);
    if (Utility.isNullOrEmpty(str)) {
      return null;
    }
    return Double.valueOf(Double.parseDouble(str));
  }
  
  public Integer readInteger()
  {
    String str = readField(false);
    if (Utility.isNullOrEmpty(str)) {
      return null;
    }
    return Integer.valueOf(Integer.parseInt(str));
  }
  
  public Long readLong()
  {
    String str = readField(false);
    if (Utility.isNullOrEmpty(str)) {
      return null;
    }
    return Long.valueOf(Long.parseLong(str));
  }
  
  public String readQuotedString()
  {
    String str1 = readField(true);
    String str2 = str1;
    if (Utility.isNullOrEmpty(str1)) {
      str2 = null;
    }
    return str2;
  }
  
  public String readString()
  {
    String str1 = readField(false);
    String str2 = str1;
    if (Utility.isNullOrEmpty(str1)) {
      str2 = null;
    }
    return str2;
  }
  
  public URI readUri()
  {
    String str = readField(true);
    boolean bool = Utility.isNullOrEmpty(str);
    Object localObject = null;
    if (bool) {
      return null;
    }
    l.a.a.b.d.a.b localb = l.a.a.b.b.b;
    if (localb != null)
    {
      if (str != null) {}
      try
      {
        localObject = new java/io/StringWriter;
        ((StringWriter)localObject).<init>(str.length() * 2);
        int i = str.length();
        int j = 0;
        while (j < i)
        {
          int k = localb.a(str, j, (Writer)localObject);
          int m;
          if (k == 0)
          {
            char c = str.charAt(j);
            ((Writer)localObject).write(c);
            m = j + 1;
            j = m;
            if (Character.isHighSurrogate(c))
            {
              j = m;
              if (m < i)
              {
                c = str.charAt(m);
                j = m;
                if (Character.isLowSurrogate(c))
                {
                  ((Writer)localObject).write(c);
                  j = m + 1;
                }
              }
            }
          }
          else
          {
            m = 0;
            int n = j;
            for (;;)
            {
              j = n;
              if (m >= k) {
                break;
              }
              n += Character.charCount(Character.codePointAt(str, n));
              m++;
            }
          }
        }
        localObject = ((StringWriter)localObject).toString();
        return new URI((String)localObject);
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException(localIOException);
      }
    }
    throw null;
  }
  
  public UUID readUuid()
  {
    String str = readField(false);
    if (Utility.isNullOrEmpty(str)) {
      return null;
    }
    return UUID.fromString(str);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.analytics.LogRecordStreamReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */