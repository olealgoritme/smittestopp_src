package l.b.i.c.b.a;

import java.io.IOException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import l.b.a.i2.f;
import l.b.a.l2.s;
import l.b.a.t;
import l.b.a.u;
import l.b.i.b.a.c;
import l.b.i.d.a.d;

public class e
  extends KeyFactorySpi
  implements l.b.d.a.c.b
{
  public PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
  {
    if ((paramKeySpec instanceof PKCS8EncodedKeySpec))
    {
      paramKeySpec = ((PKCS8EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = f.a(t.a(paramKeySpec));
        try
        {
          if (l.b.i.a.e.d.b(y.x))
          {
            paramKeySpec = paramKeySpec.f();
            if ((paramKeySpec instanceof l.b.i.a.a)) {
              paramKeySpec = (l.b.i.a.a)paramKeySpec;
            } else if (paramKeySpec != null) {
              paramKeySpec = new l.b.i.a.a(u.a(paramKeySpec));
            } else {
              paramKeySpec = null;
            }
            l.b.i.b.a.b localb = new l/b/i/b/a/b;
            int i = x;
            int j = y;
            l.b.i.d.a.b localb1 = new l/b/i/d/a/b;
            localb1.<init>(z);
            l.b.i.d.a.e locale = new l/b/i/d/a/e;
            Object localObject = new l/b/i/d/a/b;
            ((l.b.i.d.a.b)localObject).<init>(z);
            locale.<init>((l.b.i.d.a.b)localObject, A);
            localObject = new l/b/i/d/a/d;
            ((d)localObject).<init>(B);
            localb.<init>(i, j, localb1, locale, (d)localObject, l.b.c.e.a.a(C).a());
            return new a(localb);
          }
          paramKeySpec = new java/security/spec/InvalidKeySpecException;
          paramKeySpec.<init>("Unable to recognise OID in McEliece public key");
          throw paramKeySpec;
        }
        catch (IOException paramKeySpec)
        {
          throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
        }
        localStringBuilder = e.a.a.a.a.a("Unsupported key specification: ");
      }
      catch (IOException localIOException)
      {
        paramKeySpec = new StringBuilder();
        paramKeySpec.append("Unable to decode PKCS8EncodedKeySpec: ");
        paramKeySpec.append(localIOException);
        throw new InvalidKeySpecException(paramKeySpec.toString());
      }
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append(paramKeySpec.getClass());
    localStringBuilder.append(".");
    throw new InvalidKeySpecException(localStringBuilder.toString());
  }
  
  public PublicKey engineGeneratePublic(KeySpec paramKeySpec)
  {
    Object localObject;
    if ((paramKeySpec instanceof X509EncodedKeySpec))
    {
      paramKeySpec = ((X509EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = s.a(t.a(paramKeySpec));
        try
        {
          if (l.b.i.a.e.d.b(x.x))
          {
            paramKeySpec = paramKeySpec.f();
            if ((paramKeySpec instanceof l.b.i.a.b)) {
              paramKeySpec = (l.b.i.a.b)paramKeySpec;
            } else if (paramKeySpec != null) {
              paramKeySpec = new l.b.i.a.b(u.a(paramKeySpec));
            } else {
              paramKeySpec = null;
            }
            localObject = new l/b/i/b/a/c;
            ((c)localObject).<init>(x, y, z, l.b.c.e.a.a(A).a());
            return new b((c)localObject);
          }
          paramKeySpec = new java/security/spec/InvalidKeySpecException;
          paramKeySpec.<init>("Unable to recognise OID in McEliece private key");
          throw paramKeySpec;
        }
        catch (IOException paramKeySpec)
        {
          localObject = e.a.a.a.a.a("Unable to decode X509EncodedKeySpec: ");
          ((StringBuilder)localObject).append(paramKeySpec.getMessage());
          throw new InvalidKeySpecException(((StringBuilder)localObject).toString());
        }
        localObject = e.a.a.a.a.a("Unsupported key specification: ");
      }
      catch (IOException paramKeySpec)
      {
        throw new InvalidKeySpecException(paramKeySpec.toString());
      }
    }
    ((StringBuilder)localObject).append(paramKeySpec.getClass());
    ((StringBuilder)localObject).append(".");
    throw new InvalidKeySpecException(((StringBuilder)localObject).toString());
  }
  
  public KeySpec engineGetKeySpec(Key paramKey, Class paramClass)
  {
    return null;
  }
  
  public Key engineTranslateKey(Key paramKey)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     l.b.i.c.b.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */