package k.b.e.a;

import java.security.PrivilegedAction;
import java.security.Provider;

public class a$a
  implements PrivilegedAction
{
  public a$a(a parama) {}
  
  public Object run()
  {
    a locala = a;
    locala.a("org.bouncycastle.jcajce.provider.digest.", a.D);
    locala.a("org.bouncycastle.jcajce.provider.symmetric.", a.y);
    locala.a("org.bouncycastle.jcajce.provider.symmetric.", a.z);
    locala.a("org.bouncycastle.jcajce.provider.symmetric.", a.A);
    locala.a("org.bouncycastle.jcajce.provider.asymmetric.", a.B);
    locala.a("org.bouncycastle.jcajce.provider.asymmetric.", a.C);
    locala.a("org.bouncycastle.jcajce.provider.keystore.", a.E);
    locala.a("org.bouncycastle.jcajce.provider.drbg.", a.F);
    locala.a(k.b.i.a.e.e, new k.b.i.c.b.e.c());
    locala.a(k.b.i.a.e.f, new k.b.i.c.b.b.c());
    locala.a(k.b.i.a.e.g, new k.b.i.c.b.f.e());
    locala.a(k.b.i.a.e.l, new k.b.i.c.b.f.f());
    locala.a(k.b.i.a.e.c, new k.b.i.c.b.a.f());
    locala.a(k.b.i.a.e.d, new k.b.i.c.b.a.e());
    locala.a(k.b.i.a.e.a, new k.b.i.c.b.d.c());
    locala.a(k.b.i.a.e.q, new k.b.i.c.b.c.c());
    locala.a(k.b.i.a.e.r, new k.b.i.c.b.c.c());
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

/* Location:
 * Qualified Name:     base.k.b.e.a.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */