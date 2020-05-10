package k.b.e.a;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import k.b.a.o;

public final class a
  extends Provider
  implements k.b.d.a.a.a
{
  public static final String[] A = { "AES", "ARC4", "ARIA", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "SM4", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", "XTEA", "XSalsa20", "OpenSSLPBKDF", "DSTU7624", "GOST3412_2015", "Zuc" };
  public static final String[] B = { "X509", "IES" };
  public static final String[] C = { "DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM", "EdEC" };
  public static final String[] D = { "GOST3411", "Keccak", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "Blake2s", "DSTU7564", "Haraka" };
  public static final String[] E = { "BC", "BCFKS", "PKCS12" };
  public static final String[] F = { "DRBG" };
  public static final Map x;
  public static final String[] y;
  public static final String[] z;
  
  static
  {
    new b();
    x = new HashMap();
    y = new String[] { "PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF", "SCRYPT" };
    z = new String[] { "SipHash", "Poly1305" };
  }
  
  public a()
  {
    super("BC", 1.64D, "BouncyCastle Security Provider v1.64");
    AccessController.doPrivileged(new a.a(this));
  }
  
  public final void a(String paramString, String[] paramArrayOfString)
  {
    for (int i = 0; i != paramArrayOfString.length; i++)
    {
      Object localObject1 = e.a.a.a.a.a(e.a.a.a.a.a(paramString), paramArrayOfString[i], "$Mappings");
      Object localObject2;
      try
      {
        Object localObject3 = a.class.getClassLoader();
        if (localObject3 != null)
        {
          localObject1 = ((ClassLoader)localObject3).loadClass((String)localObject1);
        }
        else
        {
          localObject3 = new k/b/d/a/b/a/a;
          ((k.b.d.a.b.a.a)localObject3).<init>((String)localObject1);
          localObject1 = (Class)AccessController.doPrivileged((PrivilegedAction)localObject3);
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localObject2 = null;
      }
      if (localObject2 != null) {
        try
        {
          ((k.b.d.a.c.a)((Class)localObject2).newInstance()).a(this);
        }
        catch (Exception localException)
        {
          paramString = e.a.a.a.a.a("cannot create instance of ", paramString);
          paramString.append(paramArrayOfString[i]);
          paramString.append("$Mappings : ");
          paramString.append(localException);
          throw new InternalError(paramString.toString());
        }
      }
    }
  }
  
  public void a(o paramo, k.b.d.a.c.b paramb)
  {
    synchronized (x)
    {
      x.put(paramo, paramb);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.e.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */