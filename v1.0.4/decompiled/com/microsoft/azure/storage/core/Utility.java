package com.microsoft.azure.storage.core;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.ResultContinuation;
import com.microsoft.azure.storage.ResultContinuationType;
import com.microsoft.azure.storage.StorageErrorCode;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageExtendedErrorInformation;
import e.b.a.a.d.a;
import e.b.a.a.i.a;
import e.b.a.a.n;
import e.b.a.a.p.e;
import e.b.a.a.q.g;
import e.b.a.a.r.a.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

public final class Utility
{
  public static final TimeZone GMT_ZONE;
  public static final String ISO8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
  public static final String ISO8601_PATTERN_NO_SECONDS = "yyyy-MM-dd'T'HH:mm'Z'";
  public static final String JAVA_ISO8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  public static final Locale LOCALE_US;
  public static final int MAX_PRECISION_DATESTRING_LENGTH = "yyyy-MM-dd'T'HH:mm:ss.SSS".replaceAll("'", "").length();
  public static final String MAX_PRECISION_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS";
  public static ThreadLocal<DateFormat> RFC1123_GMT_DATE_TIME_FORMATTER = new Utility.1();
  public static final String RFC1123_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";
  public static final TimeZone UTC_ZONE;
  public static final e.b.a.a.d jsonFactory;
  public static final List<Integer> pathStylePorts;
  public static final ThreadLocal<SAXParser> saxParserThreadLocal;
  public static final XMLOutputFactory xmlOutputFactory;
  
  static
  {
    GMT_ZONE = TimeZone.getTimeZone("GMT");
    UTC_ZONE = TimeZone.getTimeZone("UTC");
    LOCALE_US = Locale.US;
    pathStylePorts = Arrays.asList(new Integer[] { Integer.valueOf(10000), Integer.valueOf(10001), Integer.valueOf(10002), Integer.valueOf(10003), Integer.valueOf(10004), Integer.valueOf(10100), Integer.valueOf(10101), Integer.valueOf(10102), Integer.valueOf(10103), Integer.valueOf(10104), Integer.valueOf(11000), Integer.valueOf(11001), Integer.valueOf(11002), Integer.valueOf(11003), Integer.valueOf(11004), Integer.valueOf(11100), Integer.valueOf(11101), Integer.valueOf(11102), Integer.valueOf(11103), Integer.valueOf(11104) });
    jsonFactory = new e.b.a.a.d();
    saxParserThreadLocal = new Utility.2();
    xmlOutputFactory = XMLOutputFactory.newInstance();
  }
  
  public static StreamMd5AndLength analyzeStream(InputStream paramInputStream, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = Long.MAX_VALUE;
    if (paramLong2 < 0L) {
      paramLong2 = Long.MAX_VALUE;
    }
    if (paramBoolean1) {
      if (paramInputStream.markSupported()) {
        paramInputStream.mark(268435456);
      } else {
        throw new IllegalArgumentException("Input stream must be markable.");
      }
    }
    MessageDigest localMessageDigest;
    if (paramBoolean2) {
      try
      {
        localMessageDigest = MessageDigest.getInstance("MD5");
      }
      catch (NoSuchAlgorithmException paramInputStream)
      {
        throw generateNewUnexpectedStorageException(paramInputStream);
      }
    } else {
      localMessageDigest = null;
    }
    if (paramLong1 < 0L) {
      paramLong1 = l1;
    }
    StreamMd5AndLength localStreamMd5AndLength = new StreamMd5AndLength();
    byte[] arrayOfByte = new byte[' '];
    l1 = ' ';
    int i = (int)Math.min(l1, paramLong1 - localStreamMd5AndLength.getLength());
    for (int j = paramInputStream.read(arrayOfByte, 0, i); (i > 0) && (j != -1); j = paramInputStream.read(arrayOfByte, 0, i))
    {
      if (paramBoolean2) {
        localMessageDigest.update(arrayOfByte, 0, j);
      }
      long l2 = localStreamMd5AndLength.getLength();
      localStreamMd5AndLength.setLength(j + l2);
      if (localStreamMd5AndLength.getLength() > paramLong2)
      {
        localStreamMd5AndLength.setLength(-1L);
        localStreamMd5AndLength.setMd5(null);
        break;
      }
      i = (int)Math.min(l1, paramLong1 - localStreamMd5AndLength.getLength());
    }
    if ((localStreamMd5AndLength.getLength() != -1L) && (paramBoolean2)) {
      localStreamMd5AndLength.setMd5(Base64.encode(localMessageDigest.digest()));
    }
    if ((localStreamMd5AndLength.getLength() != -1L) && (paramLong1 > 0L)) {
      localStreamMd5AndLength.setLength(Math.min(localStreamMd5AndLength.getLength(), paramLong1));
    }
    if (paramBoolean1)
    {
      paramInputStream.reset();
      paramInputStream.mark(268435456);
    }
    return localStreamMd5AndLength;
  }
  
  public static void assertContinuationType(ResultContinuation paramResultContinuation, ResultContinuationType paramResultContinuationType)
  {
    if ((paramResultContinuation != null) && (paramResultContinuation.getContinuationType() != ResultContinuationType.NONE) && (paramResultContinuation.getContinuationType() != paramResultContinuationType)) {
      throw new IllegalArgumentException(String.format(LOCALE_US, "The continuation type passed in is unexpected. Please verify that the correct continuation type is passed in. Expected {%s}, found {%s}.", new Object[] { paramResultContinuationType, paramResultContinuation.getContinuationType() }));
    }
  }
  
  public static void assertGreaterThanOrEqual(String paramString, long paramLong1, long paramLong2)
  {
    if (paramLong1 >= paramLong2) {
      return;
    }
    throw new IllegalArgumentException(String.format("The value of the parameter '%s' should be greater than or equal to %s.", new Object[] { paramString, Long.valueOf(paramLong2) }));
  }
  
  public static void assertInBounds(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong1 >= paramLong2) && (paramLong1 <= paramLong3)) {
      return;
    }
    throw new IllegalArgumentException(String.format("The value of the parameter '%s' should be between %s and %s.", new Object[] { paramString, Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
  }
  
  public static void assertNotNull(String paramString, Object paramObject)
  {
    if (paramObject != null) {
      return;
    }
    throw new IllegalArgumentException(String.format(LOCALE_US, "The argument must not be null. Argument name: %s.", new Object[] { paramString }));
  }
  
  public static void assertNotNullOrEmpty(String paramString1, String paramString2)
  {
    assertNotNull(paramString1, paramString2);
    if (!isNullOrEmpty(paramString2)) {
      return;
    }
    throw new IllegalArgumentException(String.format(LOCALE_US, "The argument must not be null or an empty string. Argument name: %s.", new Object[] { paramString1 }));
  }
  
  public static byte[] binaryAppend(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  public static void checkNullaryCtor(Class<?> paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredConstructor(null);
      if (paramClass != null) {
        return;
      }
      throw new IllegalArgumentException("Class type must contain contain a nullary constructor.");
    }
    catch (Exception paramClass)
    {
      throw new IllegalArgumentException("Class type must contain contain a nullary constructor.");
    }
  }
  
  public static XMLStreamWriter createXMLStreamWriter(StringWriter paramStringWriter)
  {
    return xmlOutputFactory.createXMLStreamWriter(paramStringWriter);
  }
  
  public static boolean determinePathStyleFromUri(URI paramURI)
  {
    String str1 = paramURI.getPath();
    boolean bool1 = true;
    String str2 = str1;
    if (str1 != null)
    {
      str2 = str1;
      if (str1.startsWith("/")) {
        str2 = str1.substring(1);
      }
    }
    if (isNullOrEmpty(str2)) {
      return false;
    }
    boolean bool2 = bool1;
    if (!pathStylePorts.contains(Integer.valueOf(paramURI.getPort()))) {
      if (!isHostDnsName(paramURI)) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public static long encryptStreamIfUnderThreshold(InputStream paramInputStream, ByteArrayOutputStream paramByteArrayOutputStream, Cipher paramCipher, long paramLong1, long paramLong2)
  {
    long l1 = paramLong2;
    if (paramLong2 < 0L) {
      l1 = Long.MAX_VALUE;
    }
    if (paramInputStream.markSupported())
    {
      paramInputStream.mark(268435456);
      paramLong2 = paramLong1;
      if (paramLong1 < 0L) {
        paramLong2 = Long.MAX_VALUE;
      }
      paramCipher = new CipherOutputStream(paramByteArrayOutputStream, paramCipher);
      long l2 = paramByteArrayOutputStream.size();
      byte[] arrayOfByte = new byte[' '];
      paramLong1 = ' ';
      int i = (int)Math.min(paramLong1, paramLong2 - l2);
      for (int j = paramInputStream.read(arrayOfByte, 0, i); (i > 0) && (j != -1); j = paramInputStream.read(arrayOfByte, 0, i))
      {
        paramCipher.write(arrayOfByte, 0, j);
        paramCipher.flush();
        l2 = paramByteArrayOutputStream.size();
        if (l2 > l1) {
          break;
        }
        i = (int)Math.min(paramLong1, paramLong2 - l2);
      }
      paramInputStream.reset();
      paramInputStream.mark(268435456);
      paramCipher.close();
      paramLong2 = paramByteArrayOutputStream.size();
      paramLong1 = paramLong2;
      if (paramLong2 > l1) {
        paramLong1 = -1L;
      }
      return paramLong1;
    }
    throw new IllegalArgumentException("Input stream must be markable.");
  }
  
  public static String formatETag(String paramString)
  {
    if ((paramString.startsWith("\"")) && (paramString.endsWith("\""))) {
      return paramString;
    }
    return String.format("\"%s\"", new Object[] { paramString });
  }
  
  public static StorageException generateNewUnexpectedStorageException(Exception paramException)
  {
    Object localObject = StorageErrorCode.NONE;
    localObject = new StorageException("NONE", "Unexpected internal storage client error.", 306, null, null);
    ((Exception)localObject).initCause(paramException);
    return (StorageException)localObject;
  }
  
  public static String getGMTTime()
  {
    return getGMTTime(new Date());
  }
  
  public static String getGMTTime(Date paramDate)
  {
    return ((DateFormat)RFC1123_GMT_DATE_TIME_FORMATTER.get()).format(paramDate);
  }
  
  public static String getJavaISO8601Time(Date paramDate)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", LOCALE_US);
    localSimpleDateFormat.setTimeZone(UTC_ZONE);
    return localSimpleDateFormat.format(paramDate);
  }
  
  public static e.b.a.a.f getJsonGenerator(OutputStream paramOutputStream)
  {
    Object localObject1 = jsonFactory;
    if (localObject1 != null)
    {
      e.b.a.a.c localc1 = e.b.a.a.c.UTF8;
      Object localObject2 = ((e.b.a.a.d)localObject1).a(paramOutputStream, false);
      b = localc1;
      e.b.a.a.c localc2 = e.b.a.a.c.UTF8;
      if (localc1 == localc2)
      {
        localObject2 = new g((e.b.a.a.p.b)localObject2, C, paramOutputStream);
        localObject1 = D;
        paramOutputStream = (OutputStream)localObject2;
        if (localObject1 != e.b.a.a.d.H)
        {
          D = ((n)localObject1);
          paramOutputStream = (OutputStream)localObject2;
        }
      }
      else
      {
        if (localc1 == localc2) {
          paramOutputStream = new e.b.a.a.p.i((e.b.a.a.p.b)localObject2, paramOutputStream);
        } else {
          paramOutputStream = new OutputStreamWriter(paramOutputStream, localc1.getJavaName());
        }
        paramOutputStream = new e.b.a.a.q.i((e.b.a.a.p.b)localObject2, C, paramOutputStream);
        localObject2 = D;
        if (localObject2 != e.b.a.a.d.H) {
          D = ((n)localObject2);
        }
      }
      return paramOutputStream;
    }
    throw null;
  }
  
  public static e.b.a.a.f getJsonGenerator(StringWriter paramStringWriter)
  {
    Object localObject = jsonFactory;
    paramStringWriter = new e.b.a.a.q.i(((e.b.a.a.d)localObject).a(paramStringWriter, false), C, paramStringWriter);
    localObject = D;
    if (localObject != e.b.a.a.d.H) {
      D = ((n)localObject);
    }
    return paramStringWriter;
  }
  
  public static e.b.a.a.i getJsonParser(InputStream paramInputStream)
  {
    Object localObject1 = jsonFactory;
    int i = 0;
    e.b.a.a.q.a locala = new e.b.a.a.q.a(((e.b.a.a.d)localObject1).a(paramInputStream, false), paramInputStream);
    int j = B;
    Object localObject2 = y;
    e.b.a.a.r.b localb = x;
    int k = A;
    int i3;
    int i4;
    if (locala.b(4))
    {
      paramInputStream = c;
      int m = d;
      int n = paramInputStream[m];
      int i1 = paramInputStream[(m + 1)];
      i2 = m + 2;
      i3 = paramInputStream[i2];
      i4 = m + 3;
      i3 = paramInputStream[i4] & 0xFF | (i3 & 0xFF) << 8 | n << 24 | (i1 & 0xFF) << 16;
      if (i3 != -16842752)
      {
        if (i3 != -131072)
        {
          if (i3 != 65279)
          {
            if (i3 != 65534)
            {
              m = i3 >>> 16;
              if (m == 65279)
              {
                d = i2;
                h = 2;
                g = true;
              }
              else if (m == 65534)
              {
                d = i2;
                h = 2;
                g = false;
              }
              else if (i3 >>> 8 == 15711167)
              {
                d = i4;
                h = 1;
                g = true;
              }
              else
              {
                i2 = 0;
                break label312;
              }
            }
            else
            {
              locala.a("2143");
              throw null;
            }
          }
          else
          {
            g = true;
            d = (m + 4);
            h = 4;
          }
        }
        else
        {
          d = (m + 4);
          h = 4;
          g = false;
        }
        i2 = 1;
        label312:
        if (i2 == 0)
        {
          if (i3 >> 8 == 0) {}
          for (g = true;; g = false)
          {
            break;
            if ((0xFFFFFF & i3) != 0) {
              break label364;
            }
          }
          h = 4;
          i2 = 1;
          label364:
          if ((0xFF00FFFF & i3) != 0)
          {
            if ((0xFFFF00FF & i3) != 0)
            {
              i2 = 0;
              if (i2 == 0)
              {
                i2 = i;
                if (!locala.a(i3 >>> 16)) {
                  break label499;
                }
              }
            }
            else
            {
              locala.a("2143");
              throw null;
            }
          }
          else
          {
            locala.a("3412");
            throw null;
          }
        }
      }
      else
      {
        locala.a("3412");
        throw null;
      }
    }
    else
    {
      i2 = i;
      if (!locala.b(2)) {
        break label499;
      }
      paramInputStream = c;
      i3 = d;
      i4 = paramInputStream[i3];
      i2 = i;
      if (!locala.a(paramInputStream[(i3 + 1)] & 0xFF | (i4 & 0xFF) << 8)) {
        break label499;
      }
    }
    int i2 = 1;
    label499:
    if (i2 == 0)
    {
      paramInputStream = e.b.a.a.c.UTF8;
    }
    else
    {
      i2 = h;
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if (i2 == 4)
          {
            if (g) {
              paramInputStream = e.b.a.a.c.UTF32_BE;
            } else {
              paramInputStream = e.b.a.a.c.UTF32_LE;
            }
          }
          else {
            throw new RuntimeException("Internal error");
          }
        }
        else if (g) {
          paramInputStream = e.b.a.a.c.UTF16_BE;
        } else {
          paramInputStream = e.b.a.a.c.UTF16_LE;
        }
      }
      else {
        paramInputStream = e.b.a.a.c.UTF8;
      }
    }
    a.b = paramInputStream;
    if ((paramInputStream == e.b.a.a.c.UTF8) && (d.a.CANONICALIZE_FIELD_NAMES.enabledIn(k)))
    {
      if (localObject2 != null)
      {
        paramInputStream = new e.b.a.a.r.a((e.b.a.a.r.a)localObject2, d.a.INTERN_FIELD_NAMES.enabledIn(k), c, d.a.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(k), (a.a)b.get());
        paramInputStream = new e.b.a.a.q.h(a, j, b, paramInputStream, c, d, e, f);
      }
      else
      {
        throw null;
      }
    }
    else
    {
      localObject1 = a;
      e.b.a.a.c localc = b;
      i2 = localc.bits();
      if ((i2 != 8) && (i2 != 16))
      {
        if (i2 == 32)
        {
          paramInputStream = a;
          paramInputStream = new e.b.a.a.p.h(paramInputStream, b, c, d, e, b.isBigEndian());
        }
        else
        {
          throw new RuntimeException("Internal error");
        }
      }
      else
      {
        localObject2 = b;
        if (localObject2 == null)
        {
          paramInputStream = new ByteArrayInputStream(c, d, e);
        }
        else
        {
          paramInputStream = (InputStream)localObject2;
          if (d < e) {
            paramInputStream = new e(a, (InputStream)localObject2, c, d, e);
          }
        }
        paramInputStream = new InputStreamReader(paramInputStream, localc.getJavaName());
      }
      paramInputStream = new e.b.a.a.q.f((e.b.a.a.p.b)localObject1, j, paramInputStream, localb.b(k));
    }
    return setupJsonParser(paramInputStream);
  }
  
  public static e.b.a.a.i getJsonParser(String paramString)
  {
    e.b.a.a.d locald = jsonFactory;
    if (locald != null)
    {
      int i = paramString.length();
      if (i <= 32768)
      {
        e.b.a.a.p.b localb = locald.a(paramString, true);
        localb.a(g);
        char[] arrayOfChar = d.a(0, i);
        g = arrayOfChar;
        paramString.getChars(0, i, arrayOfChar, 0);
        paramString = new e.b.a.a.q.f(localb, B, null, x.b(A), arrayOfChar, 0, i + 0, true);
      }
      else
      {
        paramString = locald.a(new StringReader(paramString));
      }
      return setupJsonParser(paramString);
    }
    throw null;
  }
  
  public static RequestLocationMode getListingLocationMode(ResultContinuation paramResultContinuation)
  {
    if ((paramResultContinuation != null) && (paramResultContinuation.getTargetLocation() != null))
    {
      int i = paramResultContinuation.getTargetLocation().ordinal();
      if (i != 0)
      {
        if (i == 1) {
          return RequestLocationMode.SECONDARY_ONLY;
        }
        throw new IllegalArgumentException(String.format("The argument is out of range. Argument name: %s, Value passed: %s.", new Object[] { "token", paramResultContinuation.getTargetLocation() }));
      }
      return RequestLocationMode.PRIMARY_ONLY;
    }
    return RequestLocationMode.PRIMARY_OR_SECONDARY;
  }
  
  public static int getRemainingTimeout(Long paramLong, Integer paramInteger)
  {
    if (paramLong != null)
    {
      long l = paramLong.longValue() - new Date().getTime();
      if (l > 2147483647L) {
        return Integer.MAX_VALUE;
      }
      if (l > 0L) {
        return (int)l;
      }
      throw new StorageException("OperationTimedOut", "The client could not finish the operation within specified maximum execution timeout.", 306, null, new TimeoutException("The client could not finish the operation within specified maximum execution timeout."));
    }
    if (paramInteger != null) {
      return paramInteger.intValue() + 300000;
    }
    return 300000;
  }
  
  public static SAXParser getSAXParser()
  {
    SAXParser localSAXParser = (SAXParser)saxParserThreadLocal.get();
    localSAXParser.reset();
    return localSAXParser;
  }
  
  public static String getStandardHeaderValue(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    paramString = paramHttpURLConnection.getRequestProperty(paramString);
    paramHttpURLConnection = paramString;
    if (paramString == null) {
      paramHttpURLConnection = "";
    }
    return paramHttpURLConnection;
  }
  
  public static String getUTCTimeOrEmpty(Date paramDate)
  {
    if (paramDate == null) {
      return "";
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", LOCALE_US);
    localSimpleDateFormat.setTimeZone(UTC_ZONE);
    return localSimpleDateFormat.format(paramDate);
  }
  
  public static IOException initIOException(Exception paramException)
  {
    Object localObject;
    if ((paramException != null) && (paramException.getMessage() != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramException.getMessage());
      ((StringBuilder)localObject).append(" Please see the cause for further information.");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "Please see the cause for further information.";
    }
    return new IOException((String)localObject, paramException);
  }
  
  public static boolean isHostDnsName(URI paramURI)
  {
    paramURI = paramURI.getHost();
    for (int i = 0; i < paramURI.length(); i++)
    {
      char c = paramURI.charAt(i);
      if ((!Character.isDigit(c)) && (c != '.')) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isNullOrEmpty(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (paramString.length() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isNullOrEmptyOrWhitespace(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (paramString.trim().length() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static void logHttpError(StorageException paramStorageException, OperationContext paramOperationContext)
  {
    if (Logger.shouldLog(paramOperationContext)) {}
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("Error response received. ");
      localStringBuilder.append("HttpStatusCode= ");
      localStringBuilder.append(paramStorageException.getHttpStatusCode());
      localStringBuilder.append(", HttpStatusMessage= ");
      localStringBuilder.append(paramStorageException.getMessage());
      localStringBuilder.append(", ErrorCode= ");
      localStringBuilder.append(paramStorageException.getErrorCode());
      paramStorageException = paramStorageException.getExtendedErrorInformation();
      if (paramStorageException != null)
      {
        localStringBuilder.append(", ExtendedErrorInformation= {ErrorMessage= ");
        localStringBuilder.append(paramStorageException.getErrorMessage());
        paramStorageException = paramStorageException.getAdditionalDetails();
        if (paramStorageException != null)
        {
          localStringBuilder.append(", AdditionalDetails= { ");
          paramStorageException = paramStorageException.entrySet().iterator();
          while (paramStorageException.hasNext())
          {
            Object localObject = (Map.Entry)paramStorageException.next();
            localStringBuilder.append((String)((Map.Entry)localObject).getKey());
            localStringBuilder.append("= ");
            localObject = (String[])((Map.Entry)localObject).getValue();
            int i = localObject.length;
            for (int j = 0; j < i; j++) {
              localStringBuilder.append(localObject[j]);
            }
            localStringBuilder.append(",");
          }
          localStringBuilder.setCharAt(localStringBuilder.length() - 1, '}');
        }
        localStringBuilder.append("}");
      }
      Logger.debug(paramOperationContext, localStringBuilder.toString());
      return;
    }
    catch (Exception paramStorageException)
    {
      for (;;) {}
    }
  }
  
  public static void logHttpRequest(HttpURLConnection paramHttpURLConnection, OperationContext paramOperationContext)
  {
    if (Logger.shouldLog(paramOperationContext)) {}
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append(paramHttpURLConnection.getRequestMethod());
      localStringBuilder.append(" ");
      localStringBuilder.append(paramHttpURLConnection.getURL());
      localStringBuilder.append("\n");
      Iterator localIterator = paramHttpURLConnection.getRequestProperties().entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramHttpURLConnection = (Map.Entry)localIterator.next();
        if (paramHttpURLConnection.getKey() != null)
        {
          localStringBuilder.append((String)paramHttpURLConnection.getKey());
          localStringBuilder.append(": ");
        }
        for (int i = 0; i < ((List)paramHttpURLConnection.getValue()).size(); i++)
        {
          localStringBuilder.append((String)((List)paramHttpURLConnection.getValue()).get(i));
          if (i < ((List)paramHttpURLConnection.getValue()).size() - 1) {
            localStringBuilder.append(",");
          }
        }
        localStringBuilder.append('\n');
      }
      Logger.trace(paramOperationContext, localStringBuilder.toString());
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      for (;;) {}
    }
  }
  
  public static void logHttpResponse(HttpURLConnection paramHttpURLConnection, OperationContext paramOperationContext)
  {
    if (Logger.shouldLog(paramOperationContext)) {}
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      Iterator localIterator = paramHttpURLConnection.getHeaderFields().entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramHttpURLConnection = (Map.Entry)localIterator.next();
        if (paramHttpURLConnection.getKey() != null)
        {
          localStringBuilder.append((String)paramHttpURLConnection.getKey());
          localStringBuilder.append(": ");
        }
        for (int i = 0; i < ((List)paramHttpURLConnection.getValue()).size(); i++)
        {
          localStringBuilder.append((String)((List)paramHttpURLConnection.getValue()).get(i));
          if (i < ((List)paramHttpURLConnection.getValue()).size() - 1) {
            localStringBuilder.append(",");
          }
        }
        localStringBuilder.append('\n');
      }
      Logger.trace(paramOperationContext, localStringBuilder.toString());
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      for (;;) {}
    }
  }
  
  public static HashMap<String, String> parseAccountString(String paramString)
  {
    String[] arrayOfString = paramString.split(";");
    paramString = new HashMap();
    int i = 0;
    while (i < arrayOfString.length)
    {
      if (arrayOfString[i].length() != 0)
      {
        int j = arrayOfString[i].indexOf("=");
        if (j >= 1) {
          paramString.put(arrayOfString[i].substring(0, j), arrayOfString[i].substring(j + 1));
        }
      }
      else
      {
        i++;
        continue;
      }
      throw new IllegalArgumentException("Invalid connection string.");
    }
    return paramString;
  }
  
  public static Date parseDate(String paramString)
  {
    int i = paramString.length();
    Object localObject = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    if (i != 17)
    {
      if (i != 20) {
        switch (i)
        {
        default: 
          throw new IllegalArgumentException(String.format("Invalid Date String: %s.", new Object[] { paramString }));
        case 24: 
        case 25: 
        case 26: 
        case 27: 
        case 28: 
          paramString = paramString.substring(0, MAX_PRECISION_DATESTRING_LENGTH);
          break;
        case 23: 
          paramString = paramString.replace("Z", "0");
          break;
        case 22: 
          paramString = paramString.replace("Z", "00");
          break;
        }
      } else {
        localObject = "yyyy-MM-dd'T'HH:mm:ss'Z'";
      }
    }
    else {
      localObject = "yyyy-MM-dd'T'HH:mm'Z'";
    }
    localObject = new SimpleDateFormat((String)localObject, LOCALE_US);
    ((DateFormat)localObject).setTimeZone(UTC_ZONE);
    try
    {
      localObject = ((DateFormat)localObject).parse(paramString);
      return (Date)localObject;
    }
    catch (ParseException localParseException)
    {
      throw new IllegalArgumentException(String.format("Invalid Date String: %s.", new Object[] { paramString }), localParseException);
    }
  }
  
  public static Date parseDate(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return parseDate(paramString);
    }
    Object localObject = paramString;
    if (paramString.length() > 24)
    {
      localObject = paramString;
      if ("0000".equals(paramString.substring(20, 24)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, 20));
        ((StringBuilder)localObject).append(paramString.substring(24));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return parseDate((String)localObject);
  }
  
  public static Date parseRFC1123DateFromStringInGMT(String paramString)
  {
    return ((DateFormat)RFC1123_GMT_DATE_TIME_FORMATTER.get()).parse(paramString);
  }
  
  public static String safeDecode(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.length() == 0) {
      return "";
    }
    try
    {
      boolean bool = paramString.contains("+");
      if (bool)
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        int i = 0;
        int k;
        for (int j = 0; i < paramString.length(); j = k)
        {
          k = j;
          if (paramString.charAt(i) == '+')
          {
            if (i > j) {
              localStringBuilder.append(URLDecoder.decode(paramString.substring(j, i), "UTF-8"));
            }
            localStringBuilder.append("+");
            k = i + 1;
          }
          i++;
        }
        if (j != paramString.length()) {
          localStringBuilder.append(URLDecoder.decode(paramString.substring(j, paramString.length()), "UTF-8"));
        }
        return localStringBuilder.toString();
      }
      paramString = URLDecoder.decode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw generateNewUnexpectedStorageException(paramString);
    }
  }
  
  public static String safeEncode(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.length() == 0) {
      return "";
    }
    try
    {
      Object localObject = URLEncoder.encode(paramString, "UTF-8");
      if (paramString.contains(" "))
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        int i = 0;
        int k;
        for (int j = 0; i < paramString.length(); j = k)
        {
          k = j;
          if (paramString.charAt(i) == ' ')
          {
            if (i > j) {
              ((StringBuilder)localObject).append(URLEncoder.encode(paramString.substring(j, i), "UTF-8"));
            }
            ((StringBuilder)localObject).append("%20");
            k = i + 1;
          }
          i++;
        }
        if (j != paramString.length()) {
          ((StringBuilder)localObject).append(URLEncoder.encode(paramString.substring(j, paramString.length()), "UTF-8"));
        }
        paramString = ((StringBuilder)localObject).toString();
        return paramString;
      }
      return (String)localObject;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw generateNewUnexpectedStorageException(paramString);
    }
  }
  
  public static String safeRelativize(URI paramURI1, URI paramURI2)
  {
    if ((paramURI1.getHost().equals(paramURI2.getHost())) && (paramURI1.getScheme().equals(paramURI2.getScheme())))
    {
      Object localObject = paramURI1.getPath();
      paramURI1 = paramURI2.getPath();
      int i = 0;
      int j = 0;
      int n;
      for (int k = 1; i < ((String)localObject).length(); k = n)
      {
        if (i >= paramURI1.length())
        {
          m = j;
          n = k;
          if (((String)localObject).charAt(i) == '/')
          {
            m = j + 1;
            n = k;
          }
        }
        else
        {
          if (((String)localObject).charAt(i) != paramURI1.charAt(i)) {
            break;
          }
          m = j;
          n = k;
          if (((String)localObject).charAt(i) == '/')
          {
            n = i + 1;
            m = j;
          }
        }
        i++;
        j = m;
      }
      int m = k;
      if (i < paramURI1.length())
      {
        m = k;
        if (paramURI1.charAt(i) == '/')
        {
          n = i - 1;
          if (paramURI1.charAt(n) == '/')
          {
            m = k;
            if (((String)localObject).charAt(n) == '/') {}
          }
          else
          {
            m = i + 1;
          }
        }
      }
      if (i == paramURI1.length()) {
        return new URI(null, null, null, paramURI2.getQuery(), paramURI2.getFragment()).toString();
      }
      paramURI1 = paramURI1.substring(m);
      localObject = new StringBuilder();
      while (j > 0)
      {
        ((StringBuilder)localObject).append("../");
        j--;
      }
      if (!isNullOrEmpty(paramURI1)) {
        ((StringBuilder)localObject).append(paramURI1);
      }
      if (!isNullOrEmpty(paramURI2.getQuery()))
      {
        ((StringBuilder)localObject).append("?");
        ((StringBuilder)localObject).append(paramURI2.getQuery());
      }
      if (!isNullOrEmpty(paramURI2.getFragment()))
      {
        ((StringBuilder)localObject).append("#");
        ((StringBuilder)localObject).append(paramURI2.getRawFragment());
      }
      return ((StringBuilder)localObject).toString();
    }
    return paramURI2.toString();
  }
  
  public static e.b.a.a.i setupJsonParser(e.b.a.a.i parami)
  {
    Object localObject1 = i.a.AUTO_CLOSE_SOURCE;
    Object localObject2 = (e.b.a.a.o.b)parami;
    x &= ((i.a)localObject1).getMask();
    if (localObject1 == i.a.STRICT_DUPLICATE_DETECTION)
    {
      localObject1 = N;
      d = null;
      N = ((e.b.a.a.q.d)localObject1);
    }
    localObject2 = i.a.ALLOW_NON_NUMERIC_NUMBERS;
    parami = (e.b.a.a.o.b)parami;
    x |= ((i.a)localObject2).getMask();
    if (localObject2 == i.a.STRICT_DUPLICATE_DETECTION)
    {
      localObject2 = N;
      if (d == null)
      {
        d = new e.b.a.a.q.b(parami);
        N = ((e.b.a.a.q.d)localObject2);
      }
    }
    return parami;
  }
  
  public static String trimEnd(String paramString, char paramChar)
  {
    for (int i = paramString.length() - 1; (i > 0) && (paramString.charAt(i) == paramChar); i--) {}
    if (i != paramString.length() - 1) {
      paramString = paramString.substring(i);
    }
    return paramString;
  }
  
  public static String trimStart(String paramString)
  {
    for (int i = 0; (i < paramString.length()) && (paramString.charAt(i) == ' '); i++) {}
    return paramString.substring(i);
  }
  
  public static boolean validateMaxExecutionTimeout(Long paramLong)
  {
    return validateMaxExecutionTimeout(paramLong, 0L);
  }
  
  public static boolean validateMaxExecutionTimeout(Long paramLong, long paramLong1)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramLong != null)
    {
      long l = new Date().getTime();
      bool2 = bool1;
      if (paramLong.longValue() < l + paramLong1) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public static StreamMd5AndLength writeToOutputStream(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong, boolean paramBoolean1, boolean paramBoolean2, OperationContext paramOperationContext, RequestOptions paramRequestOptions)
  {
    return writeToOutputStream(paramInputStream, paramOutputStream, paramLong, paramBoolean1, paramBoolean2, paramOperationContext, paramRequestOptions, Boolean.valueOf(true));
  }
  
  public static StreamMd5AndLength writeToOutputStream(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong, boolean paramBoolean1, boolean paramBoolean2, OperationContext paramOperationContext, RequestOptions paramRequestOptions, Boolean paramBoolean)
  {
    return writeToOutputStream(paramInputStream, paramOutputStream, paramLong, paramBoolean1, paramBoolean2, paramOperationContext, paramRequestOptions, paramBoolean, null, null);
  }
  
  public static StreamMd5AndLength writeToOutputStream(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong, boolean paramBoolean1, boolean paramBoolean2, OperationContext paramOperationContext, RequestOptions paramRequestOptions, Boolean paramBoolean, StorageRequest<?, ?, Integer> paramStorageRequest, StreamMd5AndLength paramStreamMd5AndLength)
  {
    paramOperationContext = paramStreamMd5AndLength;
    if ((paramBoolean1) && (paramInputStream.markSupported()))
    {
      paramInputStream.reset();
      paramInputStream.mark(268435456);
    }
    if (paramOperationContext == null)
    {
      paramStreamMd5AndLength = new StreamMd5AndLength();
      paramOperationContext = paramStreamMd5AndLength;
      if (paramBoolean2) {
        try
        {
          paramStreamMd5AndLength.setDigest(MessageDigest.getInstance("MD5"));
          paramOperationContext = paramStreamMd5AndLength;
        }
        catch (NoSuchAlgorithmException paramInputStream)
        {
          throw generateNewUnexpectedStorageException(paramInputStream);
        }
      }
    }
    else
    {
      paramOperationContext.setMd5(null);
    }
    if (paramLong < 0L) {
      paramLong = Long.MAX_VALUE;
    }
    paramStreamMd5AndLength = new byte[' '];
    long l1 = ' ';
    int i = (int)Math.min(l1, paramLong);
    int j = paramInputStream.read(paramStreamMd5AndLength, 0, i);
    while ((i > 0) && (j != -1)) {
      if (!validateMaxExecutionTimeout(paramRequestOptions.getOperationExpiryTimeInMs()))
      {
        if (paramOutputStream != null) {
          paramOutputStream.write(paramStreamMd5AndLength, 0, j);
        }
        if (paramBoolean2) {
          paramOperationContext.getDigest().update(paramStreamMd5AndLength, 0, j);
        }
        long l2 = paramOperationContext.getLength();
        long l3 = j;
        paramOperationContext.setLength(l2 + l3);
        paramOperationContext.setCurrentOperationByteCount(paramOperationContext.getCurrentOperationByteCount() + l3);
        if (paramStorageRequest != null)
        {
          paramStorageRequest.setCurrentRequestByteCount(paramStorageRequest.getCurrentRequestByteCount() + l3);
          paramStorageRequest.setCurrentDescriptor(paramOperationContext);
        }
        i = (int)Math.min(l1, paramLong - paramOperationContext.getLength());
        j = paramInputStream.read(paramStreamMd5AndLength, 0, i);
      }
      else
      {
        throw initIOException(new TimeoutException("The client could not finish the operation within specified maximum execution timeout."));
      }
    }
    if ((paramOutputStream != null) && (paramBoolean.booleanValue())) {
      paramOutputStream.flush();
    }
    return paramOperationContext;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.Utility
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */