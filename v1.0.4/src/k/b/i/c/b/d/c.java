package k.b.i.c.b.d;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import k.b.a.l;
import k.b.a.l2.s;
import k.b.a.t;
import k.b.a.u;
import k.b.i.a.g;

public class c
  extends KeyFactorySpi
  implements k.b.d.a.c.b
{
  public PrivateKey a(k.b.a.i2.f paramf)
  {
    paramf = paramf.f();
    if ((paramf instanceof k.b.i.a.f)) {
      paramf = (k.b.i.a.f)paramf;
    } else if (paramf != null) {
      paramf = new k.b.i.a.f(u.a(paramf));
    } else {
      paramf = null;
    }
    short[][] arrayOfShort1 = k.b.c.e.a.b(z);
    short[] arrayOfShort2 = k.b.c.e.a.c(A);
    short[][] arrayOfShort3 = k.b.c.e.a.b(B);
    short[] arrayOfShort4 = k.b.c.e.a.c(C);
    byte[] arrayOfByte = D;
    int[] arrayOfInt = new int[arrayOfByte.length];
    for (int i = 0; i < arrayOfByte.length; i++) {
      arrayOfByte[i] &= 0xFF;
    }
    return new a(arrayOfShort1, arrayOfShort2, arrayOfShort3, arrayOfShort4, arrayOfInt, E);
  }
  
  public PublicKey a(s params)
  {
    params = params.f();
    if ((params instanceof g)) {
      params = (g)params;
    } else if (params != null) {
      params = new g(u.a(params));
    } else {
      params = null;
    }
    return new b(z.k(), k.b.c.e.a.b(A), k.b.c.e.a.b(B), k.b.c.e.a.c(C));
  }
  
  public PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
  {
    if ((paramKeySpec instanceof k.b.i.c.c.a)) {
      return new a((k.b.i.c.c.a)paramKeySpec);
    }
    if ((paramKeySpec instanceof PKCS8EncodedKeySpec))
    {
      paramKeySpec = ((PKCS8EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = a(k.b.a.i2.f.a(t.a(paramKeySpec)));
        return paramKeySpec;
      }
      catch (Exception paramKeySpec)
      {
        throw new InvalidKeySpecException(paramKeySpec.toString());
      }
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("Unsupported key specification: ");
    localStringBuilder.append(paramKeySpec.getClass());
    localStringBuilder.append(".");
    throw new InvalidKeySpecException(localStringBuilder.toString());
  }
  
  public PublicKey engineGeneratePublic(KeySpec paramKeySpec)
  {
    if ((paramKeySpec instanceof k.b.i.c.c.b)) {
      return new b((k.b.i.c.c.b)paramKeySpec);
    }
    if ((paramKeySpec instanceof X509EncodedKeySpec))
    {
      paramKeySpec = ((X509EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = a(s.a(paramKeySpec));
        return paramKeySpec;
      }
      catch (Exception paramKeySpec)
      {
        throw new InvalidKeySpecException(paramKeySpec.toString());
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unknown key specification: ");
    localStringBuilder.append(paramKeySpec);
    localStringBuilder.append(".");
    throw new InvalidKeySpecException(localStringBuilder.toString());
  }
  
  public final KeySpec engineGetKeySpec(Key paramKey, Class paramClass)
  {
    if ((paramKey instanceof a))
    {
      if (PKCS8EncodedKeySpec.class.isAssignableFrom(paramClass)) {
        return new PKCS8EncodedKeySpec(paramKey.getEncoded());
      }
      if (k.b.i.c.c.a.class.isAssignableFrom(paramClass))
      {
        paramKey = (a)paramKey;
        return new k.b.i.c.c.a(x, y, z, A, C, B);
      }
    }
    else
    {
      if (!(paramKey instanceof b)) {
        break label187;
      }
      if (X509EncodedKeySpec.class.isAssignableFrom(paramClass)) {
        return new X509EncodedKeySpec(paramKey.getEncoded());
      }
      if (k.b.i.c.c.b.class.isAssignableFrom(paramClass))
      {
        paramKey = (b)paramKey;
        return new k.b.i.c.c.b(A, x, paramKey.a(), k.b.c.e.a.a(z));
      }
    }
    paramKey = new StringBuilder();
    paramKey.append("Unknown key specification: ");
    paramKey.append(paramClass);
    paramKey.append(".");
    throw new InvalidKeySpecException(paramKey.toString());
    label187:
    paramClass = e.a.a.a.a.a("Unsupported key type: ");
    paramClass.append(paramKey.getClass());
    paramClass.append(".");
    throw new InvalidKeySpecException(paramClass.toString());
  }
  
  public final Key engineTranslateKey(Key paramKey)
  {
    if ((!(paramKey instanceof a)) && (!(paramKey instanceof b))) {
      throw new InvalidKeyException("Unsupported key type");
    }
    return paramKey;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.c.b.d.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */