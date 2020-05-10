package k.b.i.c.b.f;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import k.b.a.l2.s;
import k.b.a.t;

public class f
  extends KeyFactorySpi
  implements k.b.d.a.c.b
{
  public PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
  {
    if ((paramKeySpec instanceof PKCS8EncodedKeySpec))
    {
      paramKeySpec = ((PKCS8EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = new a(k.b.a.i2.f.a(t.a(paramKeySpec)));
        return paramKeySpec;
      }
      catch (Exception paramKeySpec)
      {
        throw new InvalidKeySpecException(paramKeySpec.toString());
      }
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("unsupported key specification: ");
    localStringBuilder.append(paramKeySpec.getClass());
    localStringBuilder.append(".");
    throw new InvalidKeySpecException(localStringBuilder.toString());
  }
  
  public PublicKey engineGeneratePublic(KeySpec paramKeySpec)
  {
    if ((paramKeySpec instanceof X509EncodedKeySpec))
    {
      paramKeySpec = ((X509EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = new b(s.a(paramKeySpec));
        return paramKeySpec;
      }
      catch (Exception paramKeySpec)
      {
        throw new InvalidKeySpecException(paramKeySpec.toString());
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unknown key specification: ");
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
    }
    else
    {
      if (!(paramKey instanceof b)) {
        break label100;
      }
      if (X509EncodedKeySpec.class.isAssignableFrom(paramClass)) {
        return new X509EncodedKeySpec(paramKey.getEncoded());
      }
    }
    paramKey = new StringBuilder();
    paramKey.append("unknown key specification: ");
    paramKey.append(paramClass);
    paramKey.append(".");
    throw new InvalidKeySpecException(paramKey.toString());
    label100:
    paramClass = e.a.a.a.a.a("unsupported key type: ");
    paramClass.append(paramKey.getClass());
    paramClass.append(".");
    throw new InvalidKeySpecException(paramClass.toString());
  }
  
  public final Key engineTranslateKey(Key paramKey)
  {
    if ((!(paramKey instanceof a)) && (!(paramKey instanceof b))) {
      throw new InvalidKeyException("unsupported key type");
    }
    return paramKey;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.c.b.f.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */