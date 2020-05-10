package k.c.a.a.a.s.q;

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
import k.c.a.a.a.p;

public class a
{
  public static final String[] d = { "com.ibm.ssl.protocol", "com.ibm.ssl.contextProvider", "com.ibm.ssl.keyStore", "com.ibm.ssl.keyStorePassword", "com.ibm.ssl.keyStoreType", "com.ibm.ssl.keyStoreProvider", "com.ibm.ssl.keyManager", "com.ibm.ssl.trustStore", "com.ibm.ssl.trustStorePassword", "com.ibm.ssl.trustStoreType", "com.ibm.ssl.trustStoreProvider", "com.ibm.ssl.trustManager", "com.ibm.ssl.enabledCipherSuites", "com.ibm.ssl.clientAuthentication" };
  public static final byte[] e = { -99, -89, -39, -128, 5, -72, -119, -100 };
  public Hashtable a = new Hashtable();
  public Properties b;
  public k.c.a.a.a.t.b c = null;
  
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
          j = 0;
          for (;;)
          {
            if (i >= paramString.length) {
              return (char[])localObject;
            }
            k = i + 1;
            localObject[j] = ((char)(char)((paramString[i] & 0xFF) + ((paramString[k] & 0xFF) << 8)));
            j++;
            i = k + 1;
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
    k.c.a.a.a.t.b localb = c;
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
    String str1 = paramString;
    Object localObject1 = i(paramString);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "TLS";
    }
    Object localObject3 = c;
    if (localObject3 != null)
    {
      if (str1 != null) {
        localObject1 = str1;
      } else {
        localObject1 = "null (broker defaults)";
      }
      ((k.c.a.a.a.t.b)localObject3).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12000", new Object[] { localObject1, localObject2 });
    }
    localObject1 = c(paramString);
    if (localObject1 == null) {}
    try
    {
      localObject3 = SSLContext.getInstance((String)localObject2);
      break label99;
      localObject3 = SSLContext.getInstance((String)localObject2, (String)localObject1);
      label99:
      if (c != null)
      {
        localObject1 = c;
        if (str1 != null) {
          localObject2 = str1;
        } else {
          localObject2 = "null (broker defaults)";
        }
        ((k.c.a.a.a.t.b)localObject1).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12001", new Object[] { localObject2, ((SSLContext)localObject3).getProvider().getName() });
      }
      localObject1 = a(str1, "com.ibm.ssl.keyStore", null);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = a(str1, "com.ibm.ssl.keyStore", "javax.net.ssl.keyStore");
      }
      localObject1 = c;
      Object localObject4 = "null";
      if (localObject1 != null)
      {
        localObject5 = c;
        if (str1 != null) {
          localObject1 = str1;
        } else {
          localObject1 = "null (broker defaults)";
        }
        if (localObject2 != null) {
          localObject6 = localObject2;
        } else {
          localObject6 = "null";
        }
        ((k.c.a.a.a.t.b)localObject5).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12004", new Object[] { localObject1, localObject6 });
      }
      Object localObject7 = e(paramString);
      if (c != null)
      {
        localObject5 = c;
        if (str1 != null) {
          localObject1 = str1;
        } else {
          localObject1 = "null (broker defaults)";
        }
        if (localObject7 != null) {
          localObject6 = a((char[])localObject7);
        } else {
          localObject6 = "null";
        }
        ((k.c.a.a.a.t.b)localObject5).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12005", new Object[] { localObject1, localObject6 });
      }
      Object localObject6 = g(paramString);
      localObject1 = localObject6;
      if (localObject6 == null) {
        localObject1 = KeyStore.getDefaultType();
      }
      if (c != null)
      {
        localObject8 = c;
        if (str1 != null) {
          localObject6 = str1;
        } else {
          localObject6 = "null (broker defaults)";
        }
        if (localObject1 != null) {
          localObject5 = localObject1;
        } else {
          localObject5 = "null";
        }
        ((k.c.a.a.a.t.b)localObject8).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12006", new Object[] { localObject6, localObject5 });
      }
      localObject6 = KeyManagerFactory.getDefaultAlgorithm();
      Object localObject8 = f(paramString);
      Object localObject5 = d(paramString);
      if (localObject5 != null) {
        localObject6 = localObject5;
      }
      if ((localObject2 != null) && (localObject1 != null) && (localObject6 != null)) {
        try
        {
          localObject5 = KeyStore.getInstance((String)localObject1);
          localObject1 = new java/io/FileInputStream;
          ((FileInputStream)localObject1).<init>((String)localObject2);
          ((KeyStore)localObject5).load((InputStream)localObject1, (char[])localObject7);
          if (localObject8 != null) {
            localObject2 = KeyManagerFactory.getInstance((String)localObject6, (String)localObject8);
          } else {
            localObject2 = KeyManagerFactory.getInstance((String)localObject6);
          }
          if (c != null)
          {
            localObject8 = c;
            if (str1 != null) {
              localObject1 = str1;
            } else {
              localObject1 = "null (broker defaults)";
            }
            ((k.c.a.a.a.t.b)localObject8).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12010", new Object[] { localObject1, localObject6 });
            localObject6 = c;
            if (str1 != null) {
              localObject1 = str1;
            } else {
              localObject1 = "null (broker defaults)";
            }
            ((k.c.a.a.a.t.b)localObject6).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12009", new Object[] { localObject1, ((KeyManagerFactory)localObject2).getProvider().getName() });
          }
          ((KeyManagerFactory)localObject2).init((KeyStore)localObject5, (char[])localObject7);
          localObject1 = ((KeyManagerFactory)localObject2).getKeyManagers();
        }
        catch (UnrecoverableKeyException localUnrecoverableKeyException)
        {
          paramString = new k/c/a/a/a/p;
          paramString.<init>(localUnrecoverableKeyException);
          throw paramString;
        }
        catch (IOException paramString)
        {
          localp1 = new k/c/a/a/a/p;
          localp1.<init>(paramString);
          throw localp1;
        }
        catch (FileNotFoundException paramString)
        {
          localp1 = new k/c/a/a/a/p;
          localp1.<init>(paramString);
          throw localp1;
        }
        catch (CertificateException paramString)
        {
          p localp1 = new k/c/a/a/a/p;
          localp1.<init>(paramString);
          throw localp1;
        }
        catch (KeyStoreException localKeyStoreException1)
        {
          paramString = new k/c/a/a/a/p;
          paramString.<init>(localKeyStoreException1);
          throw paramString;
        }
      }
      localObject1 = null;
      localObject7 = k(paramString);
      if (c != null)
      {
        localObject5 = c;
        if (localKeyStoreException1 != null) {
          localObject2 = localKeyStoreException1;
        } else {
          localObject2 = "null (broker defaults)";
        }
        if (localObject7 != null) {
          localObject6 = localObject7;
        } else {
          localObject6 = "null";
        }
        ((k.c.a.a.a.t.b)localObject5).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12011", new Object[] { localObject2, localObject6 });
      }
      localObject8 = l(paramString);
      if (c != null)
      {
        localObject5 = c;
        if (localKeyStoreException1 != null) {
          localObject2 = localKeyStoreException1;
        } else {
          localObject2 = "null (broker defaults)";
        }
        if (localObject8 != null) {
          localObject6 = a((char[])localObject8);
        } else {
          localObject6 = "null";
        }
        ((k.c.a.a.a.t.b)localObject5).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12012", new Object[] { localObject2, localObject6 });
      }
      localObject6 = n(paramString);
      localObject2 = localObject6;
      if (localObject6 == null) {
        localObject2 = KeyStore.getDefaultType();
      }
      if (c != null)
      {
        k.c.a.a.a.t.b localb = c;
        if (localKeyStoreException1 != null) {
          localObject6 = localKeyStoreException1;
        } else {
          localObject6 = "null (broker defaults)";
        }
        localObject5 = localObject4;
        if (localObject2 != null) {
          localObject5 = localObject2;
        }
        localb.b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12013", new Object[] { localObject6, localObject5 });
      }
      localObject6 = TrustManagerFactory.getDefaultAlgorithm();
      localObject4 = m(paramString);
      localObject5 = j(paramString);
      paramString = (String)localObject6;
      if (localObject5 != null) {
        paramString = (String)localObject5;
      }
      if ((localObject7 != null) && (localObject2 != null) && (paramString != null)) {
        try
        {
          localObject5 = KeyStore.getInstance((String)localObject2);
          localObject2 = new java/io/FileInputStream;
          ((FileInputStream)localObject2).<init>((String)localObject7);
          ((KeyStore)localObject5).load((InputStream)localObject2, (char[])localObject8);
          if (localObject4 != null) {
            localObject2 = TrustManagerFactory.getInstance(paramString, (String)localObject4);
          } else {
            localObject2 = TrustManagerFactory.getInstance(paramString);
          }
          if (c != null)
          {
            localObject4 = c;
            if (localKeyStoreException1 != null) {
              localObject6 = localKeyStoreException1;
            } else {
              localObject6 = "null (broker defaults)";
            }
            ((k.c.a.a.a.t.b)localObject4).b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12017", new Object[] { localObject6, paramString });
            paramString = c;
            String str2;
            if (localKeyStoreException1 == null) {
              str2 = "null (broker defaults)";
            }
            paramString.b("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12016", new Object[] { str2, ((TrustManagerFactory)localObject2).getProvider().getName() });
          }
          ((TrustManagerFactory)localObject2).init((KeyStore)localObject5);
          paramString = ((TrustManagerFactory)localObject2).getTrustManagers();
        }
        catch (IOException localIOException)
        {
          paramString = new k/c/a/a/a/p;
          paramString.<init>(localIOException);
          throw paramString;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          paramString = new k/c/a/a/a/p;
          paramString.<init>(localFileNotFoundException);
          throw paramString;
        }
        catch (CertificateException paramString)
        {
          p localp2 = new k/c/a/a/a/p;
          localp2.<init>(paramString);
          throw localp2;
        }
        catch (KeyStoreException localKeyStoreException2)
        {
          paramString = new k/c/a/a/a/p;
          paramString.<init>(localKeyStoreException2);
          throw paramString;
        }
      }
      paramString = null;
      ((SSLContext)localObject3).init((KeyManager[])localObject1, paramString, null);
      return (SSLContext)localObject3;
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
 * Qualified Name:     base.k.c.a.a.a.s.q.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */