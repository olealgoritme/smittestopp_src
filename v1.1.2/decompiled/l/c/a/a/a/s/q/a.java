package l.c.a.a.a.s.q;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import l.c.a.a.a.p;

public class a
{
  public static final String[] d = { "com.ibm.ssl.protocol", "com.ibm.ssl.contextProvider", "com.ibm.ssl.keyStore", "com.ibm.ssl.keyStorePassword", "com.ibm.ssl.keyStoreType", "com.ibm.ssl.keyStoreProvider", "com.ibm.ssl.keyManager", "com.ibm.ssl.trustStore", "com.ibm.ssl.trustStorePassword", "com.ibm.ssl.trustStoreType", "com.ibm.ssl.trustStoreProvider", "com.ibm.ssl.trustManager", "com.ibm.ssl.enabledCipherSuites", "com.ibm.ssl.clientAuthentication" };
  public static final byte[] e = { -99, -89, -39, -128, 5, -72, -119, -100 };
  public Hashtable a = new Hashtable();
  public Properties b;
  public l.c.a.a.a.t.b c = null;
  
  public static String a(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfChar.length * 2];
    int i = 0;
    int j = 0;
    int k = 0;
    for (;;)
    {
      if (j >= paramArrayOfChar.length) {
        for (j = i;; j++)
        {
          if (j >= arrayOfByte.length)
          {
            paramArrayOfChar = new StringBuilder("{xor}");
            paramArrayOfChar.append(new String(b.a(arrayOfByte)));
            return paramArrayOfChar.toString();
          }
          k = arrayOfByte[j];
          paramArrayOfChar = e;
          arrayOfByte[j] = ((byte)(byte)((k ^ paramArrayOfChar[(j % paramArrayOfChar.length)]) & 0xFF));
        }
      }
      int m = k + 1;
      arrayOfByte[k] = ((byte)(byte)(paramArrayOfChar[j] & 0xFF));
      k = m + 1;
      arrayOfByte[m] = ((byte)(byte)(paramArrayOfChar[j] >> '\b' & 0xFF));
      j++;
    }
  }
  
  public static char[] o(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = b.a(paramString.substring(5));
      int i = 0;
      for (int j = 0;; j++)
      {
        if (j >= paramString.length)
        {
          localObject = new char[paramString.length / 2];
          k = 0;
          j = i;
          i = k;
          for (;;)
          {
            if (j >= paramString.length) {
              return (char[])localObject;
            }
            k = j + 1;
            localObject[i] = ((char)(char)((paramString[j] & 0xFF) + ((paramString[k] & 0xFF) << 8)));
            i++;
            j = k + 1;
          }
        }
        int k = paramString[j];
        Object localObject = e;
        paramString[j] = ((byte)(byte)((k ^ localObject[(j % localObject.length)]) & 0xFF));
      }
      return null;
    }
    catch (Exception paramString) {}
  }
  
  public final String a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = null;
    if (paramString1 != null) {
      localObject2 = (Properties)a.get(paramString1);
    } else {
      localObject2 = null;
    }
    paramString1 = (String)localObject1;
    if (localObject2 != null)
    {
      localObject2 = ((Properties)localObject2).getProperty(paramString2);
      paramString1 = (String)localObject2;
      if (localObject2 != null)
      {
        paramString1 = (String)localObject2;
        break label74;
      }
    }
    Object localObject2 = b;
    if (localObject2 != null) {
      paramString1 = ((Properties)localObject2).getProperty(paramString2);
    }
    label74:
    if (paramString1 != null) {
      return paramString1;
    }
    if (paramString3 != null) {
      paramString1 = System.getProperty(paramString3);
    }
    return paramString1;
  }
  
  public SSLSocketFactory a(String paramString)
  {
    SSLContext localSSLContext = h(paramString);
    l.c.a.a.a.t.b localb = c;
    if (localb != null)
    {
      String str;
      if (paramString != null) {
        str = paramString;
      } else {
        str = "null (broker defaults)";
      }
      if (b(paramString) != null) {
        paramString = a(paramString, "com.ibm.ssl.enabledCipherSuites", null);
      } else {
        paramString = "null (using platform-enabled cipher suites)";
      }
      localb.b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "createSocketFactory", "12020", new Object[] { str, paramString });
    }
    return localSSLContext.getSocketFactory();
  }
  
  public void a(Properties paramProperties, String paramString)
  {
    Iterator localIterator = paramProperties.keySet().iterator();
    if (!localIterator.hasNext())
    {
      localObject = new Properties();
      ((Properties)localObject).putAll(paramProperties);
      paramProperties = ((Properties)localObject).getProperty("com.ibm.ssl.keyStorePassword");
      if ((paramProperties != null) && (!paramProperties.startsWith("{xor}"))) {
        ((Properties)localObject).put("com.ibm.ssl.keyStorePassword", a(paramProperties.toCharArray()));
      }
      paramProperties = ((Properties)localObject).getProperty("com.ibm.ssl.trustStorePassword");
      if ((paramProperties != null) && (!paramProperties.startsWith("{xor}"))) {
        ((Properties)localObject).put("com.ibm.ssl.trustStorePassword", a(paramProperties.toCharArray()));
      }
      if (paramString != null) {
        a.put(paramString, localObject);
      } else {
        b = ((Properties)localObject);
      }
      return;
    }
    Object localObject = (String)localIterator.next();
    int i = 0;
    for (int j = 0;; j++)
    {
      String[] arrayOfString = d;
      if ((j >= arrayOfString.length) || (arrayOfString[j].equals(localObject)))
      {
        if (j < d.length) {
          i = 1;
        }
        if (i != 0) {
          break;
        }
        paramProperties = new StringBuilder(String.valueOf(localObject));
        paramProperties.append(" is not a valid IBM SSL property key.");
        throw new IllegalArgumentException(paramProperties.toString());
      }
    }
  }
  
  public String[] b(String paramString)
  {
    Vector localVector = null;
    paramString = a(paramString, "com.ibm.ssl.enabledCipherSuites", null);
    int i;
    int j;
    if (paramString == null)
    {
      paramString = localVector;
    }
    else
    {
      localVector = new Vector();
      i = paramString.indexOf(',');
      j = 0;
    }
    for (;;)
    {
      if (i <= -1)
      {
        localVector.add(paramString.substring(j));
        paramString = new String[localVector.size()];
        localVector.toArray(paramString);
        return paramString;
      }
      localVector.add(paramString.substring(j, i));
      j = i + 1;
      i = paramString.indexOf(',', j);
    }
  }
  
  public String c(String paramString)
  {
    return a(paramString, "com.ibm.ssl.contextProvider", null);
  }
  
  public String d(String paramString)
  {
    return a(paramString, "com.ibm.ssl.keyManager", "ssl.KeyManagerFactory.algorithm");
  }
  
  public char[] e(String paramString)
  {
    paramString = a(paramString, "com.ibm.ssl.keyStorePassword", "javax.net.ssl.keyStorePassword");
    if (paramString != null)
    {
      if (paramString.startsWith("{xor}")) {
        paramString = o(paramString);
      } else {
        paramString = paramString.toCharArray();
      }
    }
    else {
      paramString = null;
    }
    return paramString;
  }
  
  public String f(String paramString)
  {
    return a(paramString, "com.ibm.ssl.keyStoreProvider", null);
  }
  
  public String g(String paramString)
  {
    return a(paramString, "com.ibm.ssl.keyStoreType", "javax.net.ssl.keyStoreType");
  }
  
  public final SSLContext h(String paramString)
  {
    Object localObject1 = paramString;
    Object localObject2 = i(paramString);
    Object localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = "TLS";
    }
    Object localObject4 = c;
    if (localObject4 != null)
    {
      if (localObject1 != null) {
        localObject2 = localObject1;
      } else {
        localObject2 = "null (broker defaults)";
      }
      ((l.c.a.a.a.t.b)localObject4).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12000", new Object[] { localObject2, localObject3 });
    }
    localObject2 = c(paramString);
    if (localObject2 == null) {}
    try
    {
      localObject4 = SSLContext.getInstance((String)localObject3);
      break label99;
      localObject4 = SSLContext.getInstance((String)localObject3, (String)localObject2);
      label99:
      if (c != null)
      {
        localObject2 = c;
        if (localObject1 != null) {
          localObject3 = localObject1;
        } else {
          localObject3 = "null (broker defaults)";
        }
        ((l.c.a.a.a.t.b)localObject2).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12001", new Object[] { localObject3, ((SSLContext)localObject4).getProvider().getName() });
      }
      localObject2 = a((String)localObject1, "com.ibm.ssl.keyStore", null);
      localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = a((String)localObject1, "com.ibm.ssl.keyStore", "javax.net.ssl.keyStore");
      }
      localObject2 = c;
      Object localObject5 = "null";
      if (localObject2 != null)
      {
        localObject6 = c;
        if (localObject1 != null) {
          localObject2 = localObject1;
        } else {
          localObject2 = "null (broker defaults)";
        }
        if (localObject3 != null) {
          localObject7 = localObject3;
        } else {
          localObject7 = "null";
        }
        ((l.c.a.a.a.t.b)localObject6).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12004", new Object[] { localObject2, localObject7 });
      }
      Object localObject8 = e(paramString);
      if (c != null)
      {
        localObject6 = c;
        if (localObject1 != null) {
          localObject2 = localObject1;
        } else {
          localObject2 = "null (broker defaults)";
        }
        if (localObject8 != null) {
          localObject7 = a((char[])localObject8);
        } else {
          localObject7 = "null";
        }
        ((l.c.a.a.a.t.b)localObject6).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12005", new Object[] { localObject2, localObject7 });
      }
      Object localObject7 = g(paramString);
      localObject2 = localObject7;
      if (localObject7 == null) {
        localObject2 = KeyStore.getDefaultType();
      }
      if (c != null)
      {
        localObject9 = c;
        if (localObject1 != null) {
          localObject7 = localObject1;
        } else {
          localObject7 = "null (broker defaults)";
        }
        if (localObject2 != null) {
          localObject6 = localObject2;
        } else {
          localObject6 = "null";
        }
        ((l.c.a.a.a.t.b)localObject9).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12006", new Object[] { localObject7, localObject6 });
      }
      localObject7 = KeyManagerFactory.getDefaultAlgorithm();
      Object localObject9 = f(paramString);
      Object localObject6 = d(paramString);
      if (localObject6 != null) {
        localObject7 = localObject6;
      }
      if ((localObject3 != null) && (localObject2 != null) && (localObject7 != null)) {
        try
        {
          localObject6 = KeyStore.getInstance((String)localObject2);
          localObject2 = new java/io/FileInputStream;
          ((FileInputStream)localObject2).<init>((String)localObject3);
          ((KeyStore)localObject6).load((InputStream)localObject2, (char[])localObject8);
          if (localObject9 != null) {
            localObject3 = KeyManagerFactory.getInstance((String)localObject7, (String)localObject9);
          } else {
            localObject3 = KeyManagerFactory.getInstance((String)localObject7);
          }
          if (c != null)
          {
            localObject9 = c;
            if (localObject1 != null) {
              localObject2 = localObject1;
            } else {
              localObject2 = "null (broker defaults)";
            }
            ((l.c.a.a.a.t.b)localObject9).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12010", new Object[] { localObject2, localObject7 });
            localObject7 = c;
            if (localObject1 != null) {
              localObject2 = localObject1;
            } else {
              localObject2 = "null (broker defaults)";
            }
            ((l.c.a.a.a.t.b)localObject7).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12009", new Object[] { localObject2, ((KeyManagerFactory)localObject3).getProvider().getName() });
          }
          ((KeyManagerFactory)localObject3).init((KeyStore)localObject6, (char[])localObject8);
          localObject2 = ((KeyManagerFactory)localObject3).getKeyManagers();
        }
        catch (UnrecoverableKeyException paramString)
        {
          localObject1 = new l/c/a/a/a/p;
          ((p)localObject1).<init>(paramString);
          throw ((Throwable)localObject1);
        }
        catch (IOException localIOException1)
        {
          paramString = new l/c/a/a/a/p;
          paramString.<init>(localIOException1);
          throw paramString;
        }
        catch (FileNotFoundException localFileNotFoundException1)
        {
          paramString = new l/c/a/a/a/p;
          paramString.<init>(localFileNotFoundException1);
          throw paramString;
        }
        catch (CertificateException paramString)
        {
          p localp1 = new l/c/a/a/a/p;
          localp1.<init>(paramString);
          throw localp1;
        }
        catch (KeyStoreException localKeyStoreException)
        {
          paramString = new l/c/a/a/a/p;
          paramString.<init>(localKeyStoreException);
          throw paramString;
        }
      }
      localObject2 = null;
      localObject8 = k(paramString);
      if (c != null)
      {
        localObject6 = c;
        if (localKeyStoreException != null) {
          localObject3 = localKeyStoreException;
        } else {
          localObject3 = "null (broker defaults)";
        }
        if (localObject8 != null) {
          localObject7 = localObject8;
        } else {
          localObject7 = "null";
        }
        ((l.c.a.a.a.t.b)localObject6).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12011", new Object[] { localObject3, localObject7 });
      }
      localObject9 = l(paramString);
      if (c != null)
      {
        localObject6 = c;
        if (localKeyStoreException != null) {
          localObject3 = localKeyStoreException;
        } else {
          localObject3 = "null (broker defaults)";
        }
        if (localObject9 != null) {
          localObject7 = a((char[])localObject9);
        } else {
          localObject7 = "null";
        }
        ((l.c.a.a.a.t.b)localObject6).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12012", new Object[] { localObject3, localObject7 });
      }
      localObject7 = n(paramString);
      localObject3 = localObject7;
      if (localObject7 == null) {
        localObject3 = KeyStore.getDefaultType();
      }
      if (c != null)
      {
        l.c.a.a.a.t.b localb = c;
        if (localKeyStoreException != null) {
          localObject7 = localKeyStoreException;
        } else {
          localObject7 = "null (broker defaults)";
        }
        localObject6 = localObject5;
        if (localObject3 != null) {
          localObject6 = localObject3;
        }
        localb.b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12013", new Object[] { localObject7, localObject6 });
      }
      localObject7 = TrustManagerFactory.getDefaultAlgorithm();
      localObject5 = m(paramString);
      localObject6 = j(paramString);
      paramString = (String)localObject7;
      if (localObject6 != null) {
        paramString = (String)localObject6;
      }
      if ((localObject8 != null) && (localObject3 != null) && (paramString != null)) {
        try
        {
          localObject6 = KeyStore.getInstance((String)localObject3);
          localObject3 = new java/io/FileInputStream;
          ((FileInputStream)localObject3).<init>((String)localObject8);
          ((KeyStore)localObject6).load((InputStream)localObject3, (char[])localObject9);
          if (localObject5 != null) {
            localObject3 = TrustManagerFactory.getInstance(paramString, (String)localObject5);
          } else {
            localObject3 = TrustManagerFactory.getInstance(paramString);
          }
          if (c != null)
          {
            localObject5 = c;
            if (localKeyStoreException != null) {
              localObject7 = localKeyStoreException;
            } else {
              localObject7 = "null (broker defaults)";
            }
            ((l.c.a.a.a.t.b)localObject5).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12017", new Object[] { localObject7, paramString });
            paramString = c;
            String str;
            if (localKeyStoreException == null) {
              str = "null (broker defaults)";
            }
            paramString.b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12016", new Object[] { str, ((TrustManagerFactory)localObject3).getProvider().getName() });
          }
          ((TrustManagerFactory)localObject3).init((KeyStore)localObject6);
          paramString = ((TrustManagerFactory)localObject3).getTrustManagers();
        }
        catch (IOException localIOException2)
        {
          paramString = new l/c/a/a/a/p;
          paramString.<init>(localIOException2);
          throw paramString;
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          paramString = new l/c/a/a/a/p;
          paramString.<init>(localFileNotFoundException2);
          throw paramString;
        }
        catch (CertificateException paramString)
        {
          localp2 = new l/c/a/a/a/p;
          localp2.<init>(paramString);
          throw localp2;
        }
        catch (KeyStoreException paramString)
        {
          p localp2 = new l/c/a/a/a/p;
          localp2.<init>(paramString);
          throw localp2;
        }
      }
      paramString = null;
      ((SSLContext)localObject4).init((KeyManager[])localObject2, paramString, null);
      return (SSLContext)localObject4;
    }
    catch (KeyManagementException paramString)
    {
      throw new p(paramString);
    }
    catch (NoSuchProviderException paramString)
    {
      throw new p(paramString);
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new p(paramString);
    }
  }
  
  public String i(String paramString)
  {
    return a(paramString, "com.ibm.ssl.protocol", null);
  }
  
  public String j(String paramString)
  {
    return a(paramString, "com.ibm.ssl.trustManager", "ssl.TrustManagerFactory.algorithm");
  }
  
  public String k(String paramString)
  {
    return a(paramString, "com.ibm.ssl.trustStore", "javax.net.ssl.trustStore");
  }
  
  public char[] l(String paramString)
  {
    paramString = a(paramString, "com.ibm.ssl.trustStorePassword", "javax.net.ssl.trustStorePassword");
    if (paramString != null)
    {
      if (paramString.startsWith("{xor}")) {
        paramString = o(paramString);
      } else {
        paramString = paramString.toCharArray();
      }
    }
    else {
      paramString = null;
    }
    return paramString;
  }
  
  public String m(String paramString)
  {
    return a(paramString, "com.ibm.ssl.trustStoreProvider", null);
  }
  
  public String n(String paramString)
  {
    return a(paramString, "com.ibm.ssl.trustStoreType", null);
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.q.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */