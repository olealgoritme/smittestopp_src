package e.e.a.s;

import e.e.a.e;
import e.e.a.f;
import e.e.a.l;
import e.e.a.m;
import e.e.a.o;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class a
  extends e.e.a.s.b.a
  implements o
{
  public static final Set<l> d;
  public final PrivateKey c;
  
  static
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    localLinkedHashSet.add(l.C);
    localLinkedHashSet.add(l.D);
    localLinkedHashSet.add(l.E);
    localLinkedHashSet.add(l.J);
    localLinkedHashSet.add(l.K);
    localLinkedHashSet.add(l.L);
    d = Collections.unmodifiableSet(localLinkedHashSet);
  }
  
  public a(PrivateKey paramPrivateKey)
  {
    super(d);
    if ("RSA".equalsIgnoreCase(paramPrivateKey.getAlgorithm()))
    {
      int i = e.c.a.a.b.l.c.a(paramPrivateKey);
      if ((i > 0) && (i < 2048)) {
        throw new IllegalArgumentException("The RSA key size must be at least 2048 bits");
      }
      c = paramPrivateKey;
      return;
    }
    throw new IllegalArgumentException("The private key algorithm must be RSA");
  }
  
  public e.e.a.v.c a(m paramm, byte[] paramArrayOfByte)
  {
    paramm = (l)x;
    Provider localProvider = b.a;
    boolean bool = paramm.equals(l.C);
    Object localObject1 = null;
    if (bool)
    {
      paramm = "SHA256withRSA";
    }
    else if (paramm.equals(l.D))
    {
      paramm = "SHA384withRSA";
    }
    else if (paramm.equals(l.E))
    {
      paramm = "SHA512withRSA";
    }
    else
    {
      if (paramm.equals(l.J))
      {
        paramm = new PSSParameterSpec("SHA256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1);
        localObject1 = "SHA256withRSAandMGF1";
      }
      for (;;)
      {
        Object localObject2 = localObject1;
        localObject1 = paramm;
        paramm = (m)localObject2;
        break;
        if (paramm.equals(l.K))
        {
          paramm = new PSSParameterSpec("SHA384", "MGF1", MGF1ParameterSpec.SHA384, 48, 1);
          localObject1 = "SHA384withRSAandMGF1";
        }
        else
        {
          if (!paramm.equals(l.L)) {
            break label357;
          }
          paramm = new PSSParameterSpec("SHA512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1);
          localObject1 = "SHA512withRSAandMGF1";
        }
      }
    }
    if (localProvider != null) {}
    try
    {
      paramm = Signature.getInstance(paramm, localProvider);
      break label204;
      paramm = Signature.getInstance(paramm);
      label204:
      if (localObject1 != null) {
        try
        {
          paramm.setParameter((AlgorithmParameterSpec)localObject1);
        }
        catch (InvalidAlgorithmParameterException paramArrayOfByte)
        {
          paramm = e.a.a.a.a.a("Invalid RSASSA-PSS salt length parameter: ");
          paramm.append(paramArrayOfByte.getMessage());
          throw new f(paramm.toString(), paramArrayOfByte);
        }
      }
      try
      {
        paramm.initSign(c);
        paramm.update(paramArrayOfByte);
        paramm = e.e.a.v.c.a(paramm.sign());
        return paramm;
      }
      catch (SignatureException paramArrayOfByte)
      {
        paramm = e.a.a.a.a.a("RSA signature exception: ");
        paramm.append(paramArrayOfByte.getMessage());
        throw new f(paramm.toString(), paramArrayOfByte);
      }
      catch (InvalidKeyException paramArrayOfByte)
      {
        paramm = e.a.a.a.a.a("Invalid private RSA key: ");
        paramm.append(paramArrayOfByte.getMessage());
        throw new f(paramm.toString(), paramArrayOfByte);
      }
      localObject1 = d;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramm = e.a.a.a.a.a("Unsupported RSASSA algorithm: ");
      paramm.append(paramArrayOfByte.getMessage());
      throw new f(paramm.toString(), paramArrayOfByte);
    }
    label357:
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("Unsupported JWS algorithm ");
    paramArrayOfByte.append(paramm);
    paramArrayOfByte.append(", must be ");
    paramm = new StringBuilder();
    localObject1 = ((Collection)localObject1).toArray();
    for (int i = 0; i < localObject1.length; i++)
    {
      if (i != 0) {
        if (i < localObject1.length - 1) {
          paramm.append(", ");
        } else if (i == localObject1.length - 1) {
          paramm.append(" or ");
        }
      }
      paramm.append(localObject1[i].toString());
    }
    paramArrayOfByte.append(paramm.toString());
    throw new f(paramArrayOfByte.toString());
  }
}

/* Location:
 * Qualified Name:     e.e.a.s.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */