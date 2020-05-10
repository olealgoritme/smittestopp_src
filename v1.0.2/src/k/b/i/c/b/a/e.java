package k.b.i.c.b.a;

import java.io.IOException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import k.b.a.i2.f;
import k.b.a.l2.s;
import k.b.a.t;
import k.b.a.u;
import k.b.i.b.a.c;
import k.b.i.d.a.d;

public class e
  extends KeyFactorySpi
  implements k.b.d.a.c.b
{
  public PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
  {
    Object localObject1;
    if ((paramKeySpec instanceof PKCS8EncodedKeySpec))
    {
      paramKeySpec = ((PKCS8EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = f.a(t.a(paramKeySpec));
        try
        {
          if (k.b.i.a.e.d.b(y.x))
          {
            paramKeySpec = paramKeySpec.f();
            if ((paramKeySpec instanceof k.b.i.a.a)) {
              paramKeySpec = (k.b.i.a.a)paramKeySpec;
            } else if (paramKeySpec != null) {
              paramKeySpec = new k.b.i.a.a(u.a(paramKeySpec));
            } else {
              paramKeySpec = null;
            }
            k.b.i.b.a.b localb = new k/b/i/b/a/b;
            int i = x;
            int j = y;
            localObject1 = new k/b/i/d/a/b;
            ((k.b.i.d.a.b)localObject1).<init>(z);
            k.b.i.d.a.e locale = new k/b/i/d/a/e;
            Object localObject2 = new k/b/i/d/a/b;
            ((k.b.i.d.a.b)localObject2).<init>(z);
            locale.<init>((k.b.i.d.a.b)localObject2, A);
            localObject2 = new k/b/i/d/a/d;
            ((d)localObject2).<init>(B);
            localb.<init>(i, j, (k.b.i.d.a.b)localObject1, locale, (d)localObject2, k.b.c.e.a.a(C).a());
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
        localObject1 = e.a.a.a.a.a("Unsupported key specification: ");
      }
      catch (IOException paramKeySpec)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Unable to decode PKCS8EncodedKeySpec: ");
        ((StringBuilder)localObject1).append(paramKeySpec);
        throw new InvalidKeySpecException(((StringBuilder)localObject1).toString());
      }
    }
    ((StringBuilder)localObject1).append(paramKeySpec.getClass());
    ((StringBuilder)localObject1).append(".");
    throw new InvalidKeySpecException(((StringBuilder)localObject1).toString());
  }
  
  public PublicKey engineGeneratePublic(KeySpec paramKeySpec)
  {
    if ((paramKeySpec instanceof X509EncodedKeySpec))
    {
      paramKeySpec = ((X509EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = s.a(t.a(paramKeySpec));
        try
        {
          if (k.b.i.a.e.d.b(x.x))
          {
            paramKeySpec = paramKeySpec.f();
            if ((paramKeySpec instanceof k.b.i.a.b)) {
              paramKeySpec = (k.b.i.a.b)paramKeySpec;
            } else if (paramKeySpec != null) {
              paramKeySpec = new k.b.i.a.b(u.a(paramKeySpec));
            } else {
              paramKeySpec = null;
            }
            c localc = new k/b/i/b/a/c;
            localc.<init>(x, y, z, k.b.c.e.a.a(A).a());
            return new b(localc);
          }
          paramKeySpec = new java/security/spec/InvalidKeySpecException;
          paramKeySpec.<init>("Unable to recognise OID in McEliece private key");
          throw paramKeySpec;
        }
        catch (IOException localIOException)
        {
          paramKeySpec = e.a.a.a.a.a("Unable to decode X509EncodedKeySpec: ");
          paramKeySpec.append(localIOException.getMessage());
          throw new InvalidKeySpecException(paramKeySpec.toString());
        }
        localStringBuilder = e.a.a.a.a.a("Unsupported key specification: ");
      }
      catch (IOException paramKeySpec)
      {
        throw new InvalidKeySpecException(paramKeySpec.toString());
      }
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append(paramKeySpec.getClass());
    localStringBuilder.append(".");
    throw new InvalidKeySpecException(localStringBuilder.toString());
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
 * Qualified Name:     base.k.b.i.c.b.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */