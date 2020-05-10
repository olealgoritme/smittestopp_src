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
import l.b.a.l2.s;
import l.b.a.t;
import l.b.a.u;

public class f
  extends KeyFactorySpi
  implements l.b.d.a.c.b
{
  public PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
  {
    Object localObject1;
    if ((paramKeySpec instanceof PKCS8EncodedKeySpec))
    {
      paramKeySpec = ((PKCS8EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = l.b.a.i2.f.a(t.a(paramKeySpec));
        try
        {
          if (l.b.i.a.e.c.b(y.x))
          {
            paramKeySpec = paramKeySpec.f();
            if ((paramKeySpec instanceof l.b.i.a.c)) {
              paramKeySpec = (l.b.i.a.c)paramKeySpec;
            } else if (paramKeySpec != null) {
              paramKeySpec = new l.b.i.a.c(u.a(paramKeySpec));
            } else {
              paramKeySpec = null;
            }
            localObject1 = new l/b/i/b/a/e;
            int i = x;
            int j = y;
            l.b.i.d.a.b localb = new l/b/i/d/a/b;
            localb.<init>(z);
            l.b.i.d.a.e locale = new l/b/i/d/a/e;
            Object localObject2 = new l/b/i/d/a/b;
            ((l.b.i.d.a.b)localObject2).<init>(z);
            locale.<init>((l.b.i.d.a.b)localObject2, A);
            localObject2 = new l/b/i/d/a/d;
            ((l.b.i.d.a.d)localObject2).<init>(C);
            l.b.i.d.a.d locald = new l/b/i/d/a/d;
            locald.<init>(D);
            l.b.i.d.a.a locala = new l/b/i/d/a/a;
            locala.<init>(B);
            ((l.b.i.b.a.e)localObject1).<init>(i, j, localb, locale, (l.b.i.d.a.d)localObject2, locald, locala);
            return new c((l.b.i.b.a.e)localObject1);
          }
          paramKeySpec = new java/security/spec/InvalidKeySpecException;
          paramKeySpec.<init>("Unable to recognise OID in McEliece private key");
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
    Object localObject;
    if ((paramKeySpec instanceof X509EncodedKeySpec))
    {
      paramKeySpec = ((X509EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = s.a(t.a(paramKeySpec));
        try
        {
          if (l.b.i.a.e.c.b(x.x))
          {
            paramKeySpec = paramKeySpec.f();
            if ((paramKeySpec instanceof l.b.i.a.d)) {
              paramKeySpec = (l.b.i.a.d)paramKeySpec;
            } else if (paramKeySpec != null) {
              paramKeySpec = new l.b.i.a.d(u.a(paramKeySpec));
            } else {
              paramKeySpec = null;
            }
            localObject = new l/b/i/b/a/f;
            int i = x;
            int j = y;
            l.b.i.d.a.a locala = new l/b/i/d/a/a;
            locala.<init>(z);
            ((l.b.i.b.a.f)localObject).<init>(i, j, locala);
            return new d((l.b.i.b.a.f)localObject);
          }
          paramKeySpec = new java/security/spec/InvalidKeySpecException;
          paramKeySpec.<init>("Unable to recognise OID in McEliece public key");
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
 * Qualified Name:     l.b.i.c.b.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */