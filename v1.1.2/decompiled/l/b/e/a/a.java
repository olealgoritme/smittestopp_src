package l.b.e.a;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import l.b.a.o;

public final class a
  extends Provider
  implements l.b.d.a.a.a
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
    AccessController.doPrivileged(new a());
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
          localObject3 = new l/b/d/a/b/a/a;
          ((l.b.d.a.b.a.a)localObject3).<init>((String)localObject1);
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
          ((l.b.d.a.c.a)((Class)localObject2).newInstance()).a(this);
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
  
  public void a(o paramo, l.b.d.a.c.b paramb)
  {
    synchronized (x)
    {
      x.put(paramo, paramb);
      return;
    }
  }
  
  public class a
    implements PrivilegedAction
  {
    public a() {}
    
    public Object run()
    {
      a locala = a.this;
      locala.a("org.bouncycastle.jcajce.provider.digest.", a.D);
      locala.a("org.bouncycastle.jcajce.provider.symmetric.", a.y);
      locala.a("org.bouncycastle.jcajce.provider.symmetric.", a.z);
      locala.a("org.bouncycastle.jcajce.provider.symmetric.", a.A);
      locala.a("org.bouncycastle.jcajce.provider.asymmetric.", a.B);
      locala.a("org.bouncycastle.jcajce.provider.asymmetric.", a.C);
      locala.a("org.bouncycastle.jcajce.provider.keystore.", a.E);
      locala.a("org.bouncycastle.jcajce.provider.drbg.", a.F);
      locala.a(l.b.i.a.e.e, new l.b.i.c.b.e.c());
      locala.a(l.b.i.a.e.f, new l.b.i.c.b.b.c());
      locala.a(l.b.i.a.e.g, new l.b.i.c.b.f.e());
      locala.a(l.b.i.a.e.l, new l.b.i.c.b.f.f());
      locala.a(l.b.i.a.e.c, new l.b.i.c.b.a.f());
      locala.a(l.b.i.a.e.d, new l.b.i.c.b.a.e());
      locala.a(l.b.i.a.e.a, new l.b.i.c.b.d.c());
      locala.a(l.b.i.a.e.q, new l.b.i.c.b.c.c());
      locala.a(l.b.i.a.e.r, new l.b.i.c.b.c.c());
      locala.put("X509Store.CERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertCollection");
      locala.put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreAttrCertCollection");
      locala.put("X509Store.CRL/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCRLCollection");
      locala.put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertPairCollection");
      locala.put("X509Store.CERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCerts");
      locala.put("X509Store.CRL/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCRLs");
      locala.put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPAttrCerts");
      locala.put("X509Store.CERTIFICATEPAIR/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCertPairs");
      locala.put("X509StreamParser.CERTIFICATE", "org.bouncycastle.jce.provider.X509CertParser");
      locala.put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.bouncycastle.jce.provider.X509AttrCertParser");
      locala.put("X509StreamParser.CRL", "org.bouncycastle.jce.provider.X509CRLParser");
      locala.put("X509StreamParser.CERTIFICATEPAIR", "org.bouncycastle.jce.provider.X509CertPairParser");
      locala.put("Cipher.BROKENPBEWITHMD5ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
      locala.put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
      locala.put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
      locala.put("CertPathValidator.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
      locala.put("CertPathBuilder.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
      locala.put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
      locala.put("CertPathBuilder.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi");
      locala.put("CertPathValidator.PKIX", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
      locala.put("CertPathBuilder.PKIX", "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi");
      locala.put("CertStore.Collection", "org.bouncycastle.jce.provider.CertStoreCollectionSpi");
      locala.put("CertStore.LDAP", "org.bouncycastle.jce.provider.X509LDAPCertStoreSpi");
      locala.put("CertStore.Multi", "org.bouncycastle.jce.provider.MultiCertStoreSpi");
      locala.put("Alg.Alias.CertStore.X509LDAP", "LDAP");
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     l.b.e.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */