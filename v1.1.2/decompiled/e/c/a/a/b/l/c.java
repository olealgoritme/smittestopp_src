package e.c.a.a.b.l;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.security.KeyPairGeneratorSpec.Builder;
import android.security.keystore.KeyGenParameterSpec.Builder;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewAnimationUtils;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import de.adorsys.android.securestoragelibrary.R.string;
import e.c.a.b.g.c.b;
import e.c.a.b.g.c.c;
import e.c.a.b.g.c.e;
import f.a.a.a.b.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.AlgorithmParameterSpec;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.security.auth.x500.X500Principal;
import l.a.b.a.c.z0.c0;
import l.a.b.a.c.z0.d0;
import l.a.b.a.c.z0.p;
import l.a.b.a.c.z0.u;
import l.a.b.a.c.z0.v;
import l.a.b.a.c.z0.w;
import l.a.b.a.c.z0.z;
import l.b.a.j1;

public final class c
{
  public static Boolean a;
  public static Boolean b;
  public static Boolean c;
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat3 * paramFloat2 + (1.0F - paramFloat3) * paramFloat1;
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (float)Math.hypot(paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
  }
  
  public static int a(int paramInt)
  {
    int i;
    do
    {
      i = h.b.a.d.a.b(paramInt);
    } while ((i < 0) && (h.a.d.b.EINTR.equals(b())));
    if (i >= 0) {
      return i;
    }
    throw new h.b.a.f(String.format("Error closing fd %d: %s", new Object[] { Integer.valueOf(paramInt), c() }), b());
  }
  
  public static int a(int paramInt, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer != null)
    {
      if (!paramByteBuffer.isReadOnly())
      {
        int i;
        do
        {
          i = h.b.a.d.a.b(paramInt, paramByteBuffer, paramByteBuffer.remaining());
        } while ((i < 0) && (h.a.d.b.EINTR.equals(b())));
        if (i > 0) {
          paramByteBuffer.position(paramByteBuffer.position() + i);
        }
        return i;
      }
      throw new IllegalArgumentException("Read-only buffer");
    }
    throw new NullPointerException("Destination buffer cannot be null");
  }
  
  public static final <T> int a(Iterable<? extends T> paramIterable, int paramInt)
  {
    if (paramIterable != null)
    {
      if ((paramIterable instanceof Collection)) {
        paramInt = ((Collection)paramIterable).size();
      }
      return paramInt;
    }
    i.k.b.g.a("$this$collectionSizeOrDefault");
    throw null;
  }
  
  public static int a(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    int i = Math.min(paramByteBuffer1.remaining(), paramByteBuffer2.remaining());
    ByteBuffer localByteBuffer = paramByteBuffer1.duplicate();
    localByteBuffer.limit(localByteBuffer.position() + i);
    paramByteBuffer2.put(localByteBuffer);
    paramByteBuffer1.position(paramByteBuffer1.position() + i);
    return i;
  }
  
  public static int a(ByteBuffer paramByteBuffer, l.a.b.a.d.g0.b0 paramb0)
  {
    if (paramb0.capacity() == -1)
    {
      if (!paramByteBuffer.hasRemaining()) {
        return -1;
      }
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("Destination has reached end of stream: ");
      paramByteBuffer.append(paramb0);
      throw new IllegalStateException(paramByteBuffer.toString());
    }
    int i = paramByteBuffer.remaining();
    while ((paramByteBuffer.hasRemaining()) && (paramb0.capacity() > 0))
    {
      a(paramByteBuffer, paramb0.tail());
      paramb0.process();
    }
    return i - paramByteBuffer.remaining();
  }
  
  public static int a(PrivateKey paramPrivateKey)
  {
    if (!(paramPrivateKey instanceof RSAPrivateKey)) {
      return -1;
    }
    paramPrivateKey = (RSAPrivateKey)paramPrivateKey;
    try
    {
      int i = paramPrivateKey.getModulus().bitLength();
      return i;
    }
    catch (Exception paramPrivateKey) {}
    return -1;
  }
  
  public static final <T> int a(T[] paramArrayOfT, T paramT)
  {
    if (paramArrayOfT != null)
    {
      int i = 0;
      int j = 0;
      if (paramT == null)
      {
        i = paramArrayOfT.length;
        while (j < i)
        {
          if (paramArrayOfT[j] == null) {
            return j;
          }
          j++;
        }
      }
      int k = paramArrayOfT.length;
      for (j = i; j < k; j++) {
        if (i.k.b.g.a(paramT, paramArrayOfT[j])) {
          return j;
        }
      }
      return -1;
    }
    i.k.b.g.a("$this$indexOf");
    throw null;
  }
  
  public static Animator a(e.c.a.b.g.c paramc, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofObject(paramc, c.c.a, c.b.b, new c.e[] { new c.e(paramFloat1, paramFloat2, paramFloat3) });
    Object localObject = paramc.getRevealInfo();
    if (localObject != null)
    {
      float f = c;
      localObject = ViewAnimationUtils.createCircularReveal((View)paramc, (int)paramFloat1, (int)paramFloat2, f, paramFloat3);
      paramc = new AnimatorSet();
      paramc.playTogether(new Animator[] { localObjectAnimator, localObject });
      return paramc;
    }
    throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
  }
  
  public static ColorStateList a(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
      {
        paramContext = d.b.b.a.a.b(paramContext, i);
        if (paramContext != null) {
          return paramContext;
        }
      }
    }
    return paramTypedArray.getColorStateList(paramInt);
  }
  
  public static PorterDuff.Mode a(int paramInt, PorterDuff.Mode paramMode)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 9)
        {
          switch (paramInt)
          {
          default: 
            return paramMode;
          case 16: 
            return PorterDuff.Mode.ADD;
          case 15: 
            return PorterDuff.Mode.SCREEN;
          }
          return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_ATOP;
      }
      return PorterDuff.Mode.SRC_IN;
    }
    return PorterDuff.Mode.SRC_OVER;
  }
  
  public static e.c.c.j a(e.c.c.y.a parama)
  {
    try
    {
      parama.r();
      int i = 0;
      try
      {
        parama = (e.c.c.j)TypeAdapters.X.read(parama);
        return parama;
      }
      catch (EOFException parama) {}
      if (i == 0) {
        break label65;
      }
    }
    catch (NumberFormatException parama)
    {
      throw new e.c.c.s(parama);
    }
    catch (IOException parama)
    {
      throw new e.c.c.k(parama);
    }
    catch (e.c.c.y.d parama)
    {
      throw new e.c.c.s(parama);
    }
    catch (EOFException parama)
    {
      i = 1;
    }
    return e.c.c.l.a;
    label65:
    throw new e.c.c.s(parama);
  }
  
  public static e.e.a.a a(j.a.b.d paramd)
  {
    if (paramd.containsKey("alg")) {
      return new e.e.a.a(d(paramd, "alg"), null);
    }
    return null;
  }
  
  public static j.a.b.a a(j.a.b.d paramd, String paramString)
  {
    return (j.a.b.a)a(paramd, paramString, j.a.b.a.class);
  }
  
  public static final <T> Class<T> a(i.m.b<T> paramb)
  {
    if (paramb != null)
    {
      paramb = ((i.k.b.c)paramb).a();
      if (!paramb.isPrimitive()) {
        return paramb;
      }
      String str = paramb.getName();
      switch (str.hashCode())
      {
      default: 
        break;
      case 109413500: 
        if (str.equals("short")) {
          paramb = Short.class;
        }
        break;
      case 97526364: 
        if (str.equals("float")) {
          paramb = Float.class;
        }
        break;
      case 64711720: 
        if (str.equals("boolean")) {
          paramb = Boolean.class;
        }
        break;
      case 3625364: 
        if (str.equals("void")) {
          paramb = Void.class;
        }
        break;
      case 3327612: 
        if (str.equals("long")) {
          paramb = Long.class;
        }
        break;
      case 3052374: 
        if (str.equals("char")) {
          paramb = Character.class;
        }
        break;
      case 3039496: 
        if (str.equals("byte")) {
          paramb = Byte.class;
        }
        break;
      case 104431: 
        if (str.equals("int")) {
          paramb = Integer.class;
        }
        break;
      case -1325958191: 
        if (str.equals("double")) {
          paramb = Double.class;
        }
        break;
      }
      return paramb;
    }
    i.k.b.g.a("$this$javaObjectType");
    throw null;
  }
  
  public static <T> T a(j.a.b.d paramd, String paramString, Class<T> paramClass)
  {
    if (paramd.get(paramString) == null) {
      return null;
    }
    paramd = paramd.get(paramString);
    if (paramClass.isAssignableFrom(paramd.getClass())) {
      return paramd;
    }
    throw new ParseException(e.a.a.a.a.a("Unexpected type of JSON object member with key \"", paramString, "\""), 0);
  }
  
  public static <T> T a(T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw null;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      Cipher localCipher;
      if (i >= 23) {
        localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidKeyStoreBCWorkaround");
      } else {
        localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");
      }
      localCipher.init(2, a(paramContext));
      paramContext = new javax/crypto/CipherInputStream;
      ByteArrayInputStream localByteArrayInputStream = new java/io/ByteArrayInputStream;
      localByteArrayInputStream.<init>(Base64.decode(paramString, 0));
      paramContext.<init>(localByteArrayInputStream, localCipher);
      paramString = new java/util/ArrayList;
      paramString.<init>();
      for (;;)
      {
        i = paramContext.read();
        if (i == -1) {
          break;
        }
        paramString.add(Byte.valueOf((byte)i));
      }
      int j = paramString.size();
      paramContext = new byte[j];
      for (i = 0; i < j; i++) {
        paramContext[i] = ((Byte)paramString.get(i)).byteValue();
      }
      paramContext = new String(paramContext, 0, j, "UTF-8");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      throw new f.a.a.a.b(paramContext.getMessage(), paramContext, b.a.CRYPTO_EXCEPTION);
    }
  }
  
  public static String a(String paramString)
  {
    int i = paramString.length();
    char[] arrayOfChar = new char[i + 3];
    arrayOfChar[0] = ((char)103);
    int j = 1;
    arrayOfChar[1] = ((char)101);
    arrayOfChar[2] = ((char)116);
    int k = paramString.charAt(0);
    int m = k;
    if (k >= 97)
    {
      m = k;
      if (k <= 122) {
        m = (char)(k - 32);
      }
    }
    arrayOfChar[3] = ((char)m);
    for (m = j;; m++)
    {
      if (m >= i) {
        return new String(arrayOfChar);
      }
      arrayOfChar[(m + 3)] = paramString.charAt(m);
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = paramString1;
    if (!a(paramString1))
    {
      localObject = paramString1;
      if (!a(paramString2))
      {
        localObject = paramString1;
        if (paramString3 != null)
        {
          int i = 0;
          int j = paramString1.indexOf(paramString2, 0);
          if (j == -1)
          {
            localObject = paramString1;
          }
          else
          {
            int k = paramString2.length();
            int m = paramString3.length() - k;
            int n = m;
            if (m < 0) {
              n = 0;
            }
            localObject = new StringBuilder(paramString1.length() + n * 16);
            m = -1;
            n = i;
            for (;;)
            {
              i = n;
              if (j == -1) {
                break;
              }
              ((StringBuilder)localObject).append(paramString1.substring(n, j));
              ((StringBuilder)localObject).append(paramString3);
              n = j + k;
              m--;
              if (m == 0)
              {
                i = n;
                break;
              }
              j = paramString1.indexOf(paramString2, n);
            }
            ((StringBuilder)localObject).append(paramString1.substring(i));
            localObject = ((StringBuilder)localObject).toString();
          }
        }
      }
    }
    return (String)localObject;
  }
  
  public static String a(l.b.a.e parame)
  {
    Object localObject = b(parame);
    int i = ((String)localObject).length();
    int j = 1;
    parame = (l.b.a.e)localObject;
    if (i > 0)
    {
      parame = (l.b.a.e)localObject;
      if (((String)localObject).charAt(0) == '#') {
        try
        {
          l.b.a.t localt = l.b.a.t.a(l.b.j.g.f.a((String)localObject, 1, ((String)localObject).length() - 1));
          parame = (l.b.a.e)localObject;
          if ((localt instanceof l.b.a.a0)) {
            parame = ((l.b.a.a0)localt).c();
          }
        }
        catch (IOException parame)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("unknown encoding in name: ");
          ((StringBuilder)localObject).append(parame);
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
      }
    }
    localObject = l.b.j.f.b(parame);
    i = ((String)localObject).length();
    if (i < 2)
    {
      parame = (l.b.a.e)localObject;
    }
    else
    {
      int k = i - 1;
      for (i = 0; (i < k) && (((String)localObject).charAt(i) == '\\') && (((String)localObject).charAt(i + 1) == ' '); i += 2) {}
      for (int m = k; (m > i + 1) && (((String)localObject).charAt(m - 1) == '\\') && (((String)localObject).charAt(m) == ' '); m -= 2) {}
      if (i <= 0)
      {
        parame = (l.b.a.e)localObject;
        if (m >= k) {}
      }
      else
      {
        parame = ((String)localObject).substring(i, m + 1);
      }
      if (parame.indexOf("  ") >= 0)
      {
        localObject = new StringBuffer();
        int n = parame.charAt(0);
        ((StringBuffer)localObject).append(n);
        i = j;
        m = n;
        while (i < parame.length())
        {
          n = parame.charAt(i);
          if ((m != 32) || (n != 32))
          {
            ((StringBuffer)localObject).append(n);
            m = n;
          }
          i++;
        }
        parame = ((StringBuffer)localObject).toString();
      }
    }
    return parame;
  }
  
  public static KeyStore a()
  {
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance("AndroidKeyStore");
      localKeyStore.load(null);
      return localKeyStore;
    }
    catch (Exception localException)
    {
      throw new f.a.a.a.b(localException.getMessage(), localException, b.a.KEYSTORE_EXCEPTION);
    }
  }
  
  public static PrivateKey a(Context paramContext)
  {
    try
    {
      if (e()) {
        return (PrivateKey)a().getKey("adorsysKeyPair", null);
      }
      f.a.a.a.b localb = new f/a/a/a/b;
      localb.<init>(paramContext.getString(R.string.message_keypair_does_not_exist), null, b.a.INTERNAL_LIBRARY_EXCEPTION);
      throw localb;
    }
    catch (Exception paramContext)
    {
      throw new f.a.a.a.b(paramContext.getMessage(), paramContext, b.a.KEYSTORE_EXCEPTION);
    }
  }
  
  public static X509Certificate a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      paramArrayOfByte = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(paramArrayOfByte));
      if ((paramArrayOfByte instanceof X509Certificate)) {
        return (X509Certificate)paramArrayOfByte;
      }
      StringBuilder localStringBuilder = e.a.a.a.a.a("Not a X.509 certificate: ");
      localStringBuilder.append(paramArrayOfByte.getType());
      throw new CertificateException(localStringBuilder.toString());
    }
    return null;
  }
  
  public static DateFormat a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 == 3) {
            str = "M/d/yy";
          } else {
            throw new IllegalArgumentException(e.a.a.a.a.a("Unknown DateFormat style: ", paramInt1));
          }
        }
        else {
          str = "MMM d, yyyy";
        }
      }
      else {
        str = "MMMM d, yyyy";
      }
    }
    else {
      str = "EEEE, MMMM d, yyyy";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    if ((paramInt2 != 0) && (paramInt2 != 1))
    {
      if (paramInt2 != 2)
      {
        if (paramInt2 == 3) {
          str = "h:mm a";
        } else {
          throw new IllegalArgumentException(e.a.a.a.a.a("Unknown DateFormat style: ", paramInt2));
        }
      }
      else {
        str = "h:mm:ss a";
      }
    }
    else {
      str = "h:mm:ss a z";
    }
    localStringBuilder.append(str);
    return new SimpleDateFormat(localStringBuilder.toString(), Locale.US);
  }
  
  public static List<e.e.a.v.a> a(j.a.b.a parama)
  {
    if (parama == null) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < parama.size())
    {
      Object localObject = parama.get(i);
      if (localObject != null)
      {
        if ((localObject instanceof String))
        {
          localLinkedList.add(new e.e.a.v.a((String)localObject));
          i++;
        }
        else
        {
          throw new ParseException(e.a.a.a.a.b("The X.509 certificate at position ", i, " must be encoded as a Base64 string"), 0);
        }
      }
      else {
        throw new ParseException(e.a.a.a.a.b("The X.509 certificate at position ", i, " must not be null"), 0);
      }
    }
    return localLinkedList;
  }
  
  public static List<X509Certificate> a(List<e.e.a.v.a> paramList)
  {
    if (paramList == null) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      if (paramList.get(i) != null)
      {
        Object localObject1 = ((e.e.a.v.a)paramList.get(i)).c();
        Object localObject2;
        try
        {
          localObject1 = a((byte[])localObject1);
        }
        catch (CertificateException localCertificateException)
        {
          localObject2 = null;
        }
        if (localObject2 != null) {
          localLinkedList.add(localObject2);
        }
      }
      else
      {
        i++;
        continue;
      }
      throw new ParseException(e.a.a.a.a.a("Invalid X.509 certificate at position ", i), 0);
    }
    return localLinkedList;
  }
  
  public static final <K, V, M extends Map<? super K, ? super V>> M a(Iterable<? extends i.c<? extends K, ? extends V>> paramIterable, M paramM)
  {
    if (paramIterable != null)
    {
      if (paramM != null)
      {
        paramIterable = paramIterable.iterator();
        while (paramIterable.hasNext())
        {
          i.c localc = (i.c)paramIterable.next();
          paramM.put(x, y);
        }
        return paramM;
      }
      i.k.b.g.a("destination");
      throw null;
    }
    i.k.b.g.a("$this$toMap");
    throw null;
  }
  
  public static l.a.b.a.g.d a(l.a.b.a.g.f paramf, l.a.b.a.d.l... paramVarArgs)
  {
    paramf = new l.a.b.a.g.i.d(new l.a.b.a.g.i.c(), paramf);
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      l.a.b.a.d.l locall = paramVarArgs[j];
      paramf.M().add(locall);
    }
    return paramf;
  }
  
  public static void a(AnimatorSet paramAnimatorSet, List<Animator> paramList)
  {
    int i = paramList.size();
    long l1 = 0L;
    for (int j = 0; j < i; j++)
    {
      localObject = (Animator)paramList.get(j);
      long l2 = ((Animator)localObject).getStartDelay();
      l1 = Math.max(l1, ((Animator)localObject).getDuration() + l2);
    }
    Object localObject = ValueAnimator.ofInt(new int[] { 0, 0 });
    ((Animator)localObject).setDuration(l1);
    paramList.add(0, localObject);
    paramAnimatorSet.playTogether(paramList);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    Context localContext = paramContext.getApplicationContext();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((!e()) && (!e())) {
      if (Build.VERSION.SDK_INT >= 23)
      {
        try
        {
          if (c(localContext)) {
            Locale.setDefault(Locale.US);
          }
          localObject1 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
          localObject2 = new android/security/keystore/KeyGenParameterSpec$Builder;
          ((KeyGenParameterSpec.Builder)localObject2).<init>("adorsysKeyPair", 3);
          ((KeyPairGenerator)localObject1).initialize(((KeyGenParameterSpec.Builder)localObject2).setEncryptionPaddings(new String[] { "PKCS1Padding" }).build());
          ((KeyPairGenerator)localObject1).generateKeyPair();
        }
        catch (Exception paramContext)
        {
          throw new f.a.a.a.b(paramContext.getMessage(), paramContext, b.a.KEYSTORE_EXCEPTION);
        }
      }
      else
      {
        f.a.a.a.a.a();
        try
        {
          if (c(localContext)) {
            Locale.setDefault(Locale.US);
          }
          localObject1 = Calendar.getInstance();
          localObject2 = Calendar.getInstance();
          ((Calendar)localObject2).add(1, 99);
          localObject3 = new android/security/KeyPairGeneratorSpec$Builder;
          ((KeyPairGeneratorSpec.Builder)localObject3).<init>(localContext);
          localObject3 = ((KeyPairGeneratorSpec.Builder)localObject3).setAlias("adorsysKeyPair");
          X500Principal localX500Principal = new javax/security/auth/x500/X500Principal;
          localX500Principal.<init>("CN=SecureDeviceStorage, O=Adorsys, C=Germany");
          localObject1 = ((KeyPairGeneratorSpec.Builder)localObject3).setSubject(localX500Principal).setSerialNumber(BigInteger.TEN).setStartDate(((Calendar)localObject1).getTime()).setEndDate(((Calendar)localObject2).getTime()).build();
          localObject2 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
          ((KeyPairGenerator)localObject2).initialize((AlgorithmParameterSpec)localObject1);
          ((KeyPairGenerator)localObject2).generateKeyPair();
        }
        catch (Exception paramContext)
        {
          throw new f.a.a.a.b(paramContext.getMessage(), paramContext, b.a.KEYSTORE_EXCEPTION);
        }
      }
    }
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 23) {
        localObject2 = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidKeyStoreBCWorkaround");
      } else {
        localObject2 = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");
      }
      ((Cipher)localObject2).init(1, b(localContext));
      localObject3 = new java/io/ByteArrayOutputStream;
      ((ByteArrayOutputStream)localObject3).<init>();
      localObject1 = new javax/crypto/CipherOutputStream;
      ((CipherOutputStream)localObject1).<init>((OutputStream)localObject3, (Cipher)localObject2);
      ((CipherOutputStream)localObject1).write(paramString2.getBytes("UTF-8"));
      ((CipherOutputStream)localObject1).close();
      paramString2 = Base64.encodeToString(((ByteArrayOutputStream)localObject3).toByteArray(), 0);
      if (!TextUtils.isEmpty(paramString2))
      {
        localContext.getSharedPreferences("SecurePreferences", 0).edit().putString(paramString1, paramString2).apply();
        return;
      }
      throw new f.a.a.a.b(paramContext.getString(R.string.message_problem_encryption), null, b.a.CRYPTO_EXCEPTION);
    }
    catch (Exception paramContext)
    {
      throw new f.a.a.a.b(paramContext.getMessage(), paramContext, b.a.KEYSTORE_EXCEPTION);
    }
  }
  
  public static void a(StringBuffer paramStringBuffer, l.b.a.k2.a parama, Hashtable paramHashtable)
  {
    paramHashtable = (String)paramHashtable.get(x);
    if (paramHashtable == null) {
      paramHashtable = x.x;
    }
    paramStringBuffer.append(paramHashtable);
    paramStringBuffer.append('=');
    paramStringBuffer.append(b(y));
  }
  
  public static void a(l.a.b.a.c.i parami, l.a.b.a.c.x paramx)
  {
    Object localObject1 = new l.a.b.a.c.c1.l(paramx);
    Object localObject2 = l.a.b.a.c.c1.l.d;
    int i = localObject2.length;
    int j = 0;
    for (int k = 0; k < i; k++)
    {
      localObject3 = localObject2[k];
      ((l.a.b.a.c.r)parami).a(localObject3, (l.a.b.a.c.s)localObject1);
    }
    paramx.a((l.a.b.a.c.a)localObject1);
    Object localObject3 = new l.a.b.a.c.c1.b(paramx);
    for (localObject2 : l.a.b.a.c.c1.b.d) {
      ((l.a.b.a.c.r)parami).a(localObject2, (l.a.b.a.c.s)localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
    localObject3 = new l.a.b.a.c.c1.a(paramx);
    for (localObject1 : l.a.b.a.c.c1.a.d) {
      ((l.a.b.a.c.r)parami).a(localObject1, (l.a.b.a.c.s)localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
    localObject2 = new l.a.b.a.c.c1.k(paramx);
    for (localObject3 : l.a.b.a.c.c1.k.d) {
      ((l.a.b.a.c.r)parami).a(localObject3, (l.a.b.a.c.s)localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject1 = new l.a.b.a.c.c1.m(paramx);
    for (localObject3 : l.a.b.a.c.c1.m.d) {
      ((l.a.b.a.c.r)parami).a(localObject3, (l.a.b.a.c.s)localObject1);
    }
    paramx.a((l.a.b.a.c.a)localObject1);
    localObject3 = new l.a.b.a.c.c1.e(paramx);
    for (localObject1 : l.a.b.a.c.c1.e.d) {
      ((l.a.b.a.c.r)parami).a(localObject1, (l.a.b.a.c.s)localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
    localObject2 = new l.a.b.a.c.c1.d(paramx);
    for (localObject1 : l.a.b.a.c.c1.d.d) {
      ((l.a.b.a.c.r)parami).a(localObject1, (l.a.b.a.c.s)localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject3 = new l.a.b.a.c.c1.f(paramx);
    for (localObject1 : l.a.b.a.c.c1.f.d) {
      ((l.a.b.a.c.r)parami).a(localObject1, (l.a.b.a.c.s)localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
    localObject2 = new l.a.b.a.c.c1.c(paramx);
    for (localObject3 : l.a.b.a.c.c1.c.d) {
      ((l.a.b.a.c.r)parami).a(localObject3, (l.a.b.a.c.s)localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject1 = new l.a.b.a.c.c1.g(paramx);
    for (localObject2 : l.a.b.a.c.c1.g.d) {
      ((l.a.b.a.c.r)parami).a(localObject2, (l.a.b.a.c.s)localObject1);
    }
    paramx.a((l.a.b.a.c.a)localObject1);
    localObject1 = new l.a.b.a.c.c1.i(paramx);
    for (localObject2 : l.a.b.a.c.c1.i.b) {
      e.put(localObject2, localObject1);
    }
    paramx.a((l.a.b.a.c.a)localObject1);
    localObject3 = new l.a.b.a.c.c1.j(paramx);
    for (localObject1 : l.a.b.a.c.c1.j.b) {
      e.put(localObject1, localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
    localObject2 = new l.a.b.a.c.c1.h(paramx);
    for (localObject1 : l.a.b.a.c.c1.h.b) {
      e.put(localObject1, localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject2 = new v(paramx);
    for (localObject3 : v.d) {
      ((l.a.b.a.c.r)parami).a(localObject3, (l.a.b.a.c.s)localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject3 = new l.a.b.a.c.z0.a(paramx);
    for (localObject1 : l.a.b.a.c.z0.a.d) {
      ((l.a.b.a.c.r)parami).a(localObject1, (l.a.b.a.c.s)localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
    localObject3 = new l.a.b.a.c.z0.y(paramx);
    for (localObject1 : l.a.b.a.c.z0.y.d) {
      ((l.a.b.a.c.r)parami).a(localObject1, (l.a.b.a.c.s)localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
    localObject1 = new l.a.b.a.c.z0.j(paramx);
    for (localObject3 : l.a.b.a.c.z0.j.d) {
      ((l.a.b.a.c.r)parami).a(localObject3, (l.a.b.a.c.s)localObject1);
    }
    paramx.a((l.a.b.a.c.a)localObject1);
    localObject1 = new w(paramx);
    for (localObject3 : w.d) {
      ((l.a.b.a.c.r)parami).a(localObject3, (l.a.b.a.c.s)localObject1);
    }
    paramx.a((l.a.b.a.c.a)localObject1);
    localObject2 = new l.a.b.a.c.z0.d(paramx);
    for (localObject3 : l.a.b.a.c.z0.d.d) {
      ((l.a.b.a.c.r)parami).a(localObject3, (l.a.b.a.c.s)localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject2 = new l.a.b.a.c.z0.e(paramx);
    for (localObject1 : l.a.b.a.c.z0.e.d) {
      ((l.a.b.a.c.r)parami).a(localObject1, (l.a.b.a.c.s)localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject2 = new l.a.b.a.c.z0.b(paramx);
    for (localObject1 : l.a.b.a.c.z0.b.d) {
      ((l.a.b.a.c.r)parami).a(localObject1, (l.a.b.a.c.s)localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject2 = new l.a.b.a.c.z0.c(paramx);
    for (localObject1 : l.a.b.a.c.z0.c.d) {
      ((l.a.b.a.c.r)parami).a(localObject1, (l.a.b.a.c.s)localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject2 = new u(paramx);
    for (localObject1 : u.d) {
      ((l.a.b.a.c.r)parami).a(localObject1, (l.a.b.a.c.s)localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject1 = new z(paramx);
    for (localObject2 : z.d) {
      ((l.a.b.a.c.r)parami).a(localObject2, (l.a.b.a.c.s)localObject1);
    }
    paramx.a((l.a.b.a.c.a)localObject1);
    localObject3 = new l.a.b.a.c.z0.a0(paramx);
    for (localObject2 : l.a.b.a.c.z0.a0.d) {
      ((l.a.b.a.c.r)parami).a(localObject2, (l.a.b.a.c.s)localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
    localObject1 = new l.a.b.a.c.z0.b0(paramx);
    for (localObject2 : l.a.b.a.c.z0.b0.d) {
      ((l.a.b.a.c.r)parami).a(localObject2, (l.a.b.a.c.s)localObject1);
    }
    paramx.a((l.a.b.a.c.a)localObject1);
    localObject2 = new l.a.b.a.c.z0.x(paramx);
    for (localObject3 : l.a.b.a.c.z0.x.d) {
      ((l.a.b.a.c.r)parami).a(localObject3, (l.a.b.a.c.s)localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject3 = new c0(paramx);
    for (localObject2 : c0.d) {
      ((l.a.b.a.c.r)parami).a(localObject2, (l.a.b.a.c.s)localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
    localObject3 = new d0(paramx);
    for (localObject2 : d0.d) {
      ((l.a.b.a.c.r)parami).a(localObject2, (l.a.b.a.c.s)localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
    localObject1 = new l.a.b.a.c.z0.f(paramx);
    for (localObject2 : l.a.b.a.c.z0.f.d) {
      ((l.a.b.a.c.r)parami).a(localObject2, (l.a.b.a.c.s)localObject1);
    }
    paramx.a((l.a.b.a.c.a)localObject1);
    localObject2 = new l.a.b.a.c.z0.h(paramx);
    for (localObject3 : l.a.b.a.c.z0.h.d) {
      ((l.a.b.a.c.r)parami).a(localObject3, (l.a.b.a.c.s)localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject3 = new l.a.b.a.c.z0.i(paramx);
    for (localObject1 : l.a.b.a.c.z0.i.d) {
      ((l.a.b.a.c.r)parami).a(localObject1, (l.a.b.a.c.s)localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
    localObject2 = new l.a.b.a.c.z0.g(paramx);
    for (localObject1 : l.a.b.a.c.z0.g.d) {
      ((l.a.b.a.c.r)parami).a(localObject1, (l.a.b.a.c.s)localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject1 = new l.a.b.a.c.z0.r(paramx);
    for (localObject2 : l.a.b.a.c.z0.r.b) {
      e.put(localObject2, localObject1);
    }
    paramx.a((l.a.b.a.c.a)localObject1);
    localObject1 = new l.a.b.a.c.z0.k(paramx);
    for (localObject2 : l.a.b.a.c.z0.k.b) {
      e.put(localObject2, localObject1);
    }
    paramx.a((l.a.b.a.c.a)localObject1);
    localObject3 = new l.a.b.a.c.z0.t(paramx);
    for (localObject1 : l.a.b.a.c.z0.t.b) {
      e.put(localObject1, localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
    localObject1 = new p(paramx);
    for (localObject2 : p.c) {
      e.put(localObject2, localObject1);
    }
    paramx.a((l.a.b.a.c.a)localObject1);
    localObject2 = new l.a.b.a.c.z0.s(paramx);
    for (localObject3 : l.a.b.a.c.z0.s.c) {
      e.put(localObject3, localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject2 = new l.a.b.a.c.z0.n(paramx);
    for (localObject3 : l.a.b.a.c.z0.n.c) {
      e.put(localObject3, localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject3 = new l.a.b.a.c.z0.o(paramx);
    for (localObject1 : l.a.b.a.c.z0.o.b) {
      e.put(localObject1, localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
    localObject2 = new l.a.b.a.c.z0.l(paramx);
    for (localObject3 : l.a.b.a.c.z0.l.b) {
      e.put(localObject3, localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject1 = new l.a.b.a.c.z0.m(paramx);
    for (localObject3 : l.a.b.a.c.z0.m.b) {
      e.put(localObject3, localObject1);
    }
    paramx.a((l.a.b.a.c.a)localObject1);
    localObject3 = new l.a.b.a.c.z0.q(paramx);
    for (localObject2 : l.a.b.a.c.z0.q.b) {
      e.put(localObject2, localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
    localObject3 = new l.a.b.a.c.b1.a(paramx);
    for (localObject2 : l.a.b.a.c.b1.a.d) {
      ((l.a.b.a.c.r)parami).a(localObject2, (l.a.b.a.c.s)localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
    localObject3 = new l.a.b.a.c.b1.b(paramx);
    for (localObject2 : l.a.b.a.c.b1.b.d) {
      ((l.a.b.a.c.r)parami).a(localObject2, (l.a.b.a.c.s)localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
    localObject3 = new l.a.b.a.c.b1.d(paramx);
    for (localObject1 : l.a.b.a.c.b1.d.d) {
      ((l.a.b.a.c.r)parami).a(localObject1, (l.a.b.a.c.s)localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
    localObject2 = new l.a.b.a.c.b1.c(paramx);
    for (localObject3 : l.a.b.a.c.b1.c.d) {
      ((l.a.b.a.c.r)parami).a(localObject3, (l.a.b.a.c.s)localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject2 = new l.a.b.a.c.b1.e(paramx);
    for (localObject3 : l.a.b.a.c.b1.e.d) {
      ((l.a.b.a.c.r)parami).a(localObject3, (l.a.b.a.c.s)localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject1 = new l.a.b.a.c.a1.c(paramx);
    for (localObject2 : l.a.b.a.c.a1.c.d) {
      ((l.a.b.a.c.r)parami).a(localObject2, (l.a.b.a.c.s)localObject1);
    }
    paramx.a((l.a.b.a.c.a)localObject1);
    localObject2 = new l.a.b.a.c.a1.b(paramx);
    for (localObject1 : l.a.b.a.c.a1.b.d) {
      ((l.a.b.a.c.r)parami).a(localObject1, (l.a.b.a.c.s)localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject2 = new l.a.b.a.c.a1.a(paramx);
    for (localObject3 : l.a.b.a.c.a1.a.d) {
      ((l.a.b.a.c.r)parami).a(localObject3, (l.a.b.a.c.s)localObject2);
    }
    paramx.a((l.a.b.a.c.a)localObject2);
    localObject1 = new l.a.b.a.c.a1.e(paramx);
    for (localObject3 : l.a.b.a.c.a1.e.d) {
      ((l.a.b.a.c.r)parami).a(localObject3, (l.a.b.a.c.s)localObject1);
    }
    paramx.a((l.a.b.a.c.a)localObject1);
    localObject3 = new l.a.b.a.c.a1.d(paramx);
    localObject2 = l.a.b.a.c.a1.d.d;
    i = localObject2.length;
    for (k = j; k < i; k++)
    {
      localObject1 = localObject2[k];
      ((l.a.b.a.c.r)parami).a(localObject1, (l.a.b.a.c.s)localObject3);
    }
    paramx.a((l.a.b.a.c.a)localObject3);
  }
  
  public static void a(l.e.a.s params, l.e.a.y paramy)
  {
    int i = a;
    int j = i;
    if (i == 12) {
      j = 10;
    }
    switch (j)
    {
    default: 
      break;
    case 8: 
      params.b(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
      break;
    case 7: 
      params.b(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
      break;
    case 6: 
      params.b(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
      break;
    case 5: 
      params.b(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
      break;
    case 4: 
      params.b(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
      break;
    case 3: 
      params.b(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
      break;
    case 2: 
      params.b(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
      break;
    case 1: 
      params.b(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public static final boolean a(char paramChar1, char paramChar2, boolean paramBoolean)
  {
    if (paramChar1 == paramChar2) {
      return true;
    }
    if (!paramBoolean) {
      return false;
    }
    if (Character.toUpperCase(paramChar1) == Character.toUpperCase(paramChar2)) {
      return true;
    }
    return Character.toLowerCase(paramChar1) == Character.toLowerCase(paramChar2);
  }
  
  public static final boolean a(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    if (paramBluetoothGattCharacteristic != null) {
      return i.k.b.g.a(paramBluetoothGattCharacteristic.getUuid(), k.b.a.t.c);
    }
    i.k.b.g.a("$this$isDeviceIdentifier");
    throw null;
  }
  
  public static boolean a(CharSequence paramCharSequence)
  {
    boolean bool;
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 != null) && (paramObject2 != null))
    {
      if (((paramObject1 instanceof Object[])) && ((paramObject2 instanceof Object[]))) {
        return Arrays.deepEquals((Object[])paramObject1, (Object[])paramObject2);
      }
      if (((paramObject1 instanceof boolean[])) && ((paramObject2 instanceof boolean[]))) {
        return Arrays.equals((boolean[])paramObject1, (boolean[])paramObject2);
      }
      if (((paramObject1 instanceof byte[])) && ((paramObject2 instanceof byte[]))) {
        return Arrays.equals((byte[])paramObject1, (byte[])paramObject2);
      }
      if (((paramObject1 instanceof char[])) && ((paramObject2 instanceof char[]))) {
        return Arrays.equals((char[])paramObject1, (char[])paramObject2);
      }
      if (((paramObject1 instanceof double[])) && ((paramObject2 instanceof double[]))) {
        return Arrays.equals((double[])paramObject1, (double[])paramObject2);
      }
      if (((paramObject1 instanceof float[])) && ((paramObject2 instanceof float[]))) {
        return Arrays.equals((float[])paramObject1, (float[])paramObject2);
      }
      if (((paramObject1 instanceof int[])) && ((paramObject2 instanceof int[]))) {
        return Arrays.equals((int[])paramObject1, (int[])paramObject2);
      }
      if (((paramObject1 instanceof long[])) && ((paramObject2 instanceof long[]))) {
        return Arrays.equals((long[])paramObject1, (long[])paramObject2);
      }
      if (((paramObject1 instanceof short[])) && ((paramObject2 instanceof short[]))) {
        return Arrays.equals((short[])paramObject1, (short[])paramObject2);
      }
      return paramObject1.equals(paramObject2);
    }
    boolean bool;
    if (paramObject1 == paramObject2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final int b(int paramInt)
  {
    if (paramInt >= 0) {
      if (paramInt < 3) {
        paramInt++;
      } else if (paramInt < 1073741824) {
        paramInt = (int)(paramInt / 0.75F + 1.0F);
      } else {
        paramInt = Integer.MAX_VALUE;
      }
    }
    return paramInt;
  }
  
  public static final int b(int paramInt1, int paramInt2)
  {
    paramInt1 %= paramInt2;
    if (paramInt1 < 0) {
      paramInt1 += paramInt2;
    }
    return paramInt1;
  }
  
  public static int b(int paramInt, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer != null)
    {
      int i;
      do
      {
        i = h.b.a.d.a.a(paramInt, paramByteBuffer, paramByteBuffer.remaining());
      } while ((i < 0) && (h.a.d.b.EINTR.equals(b())));
      if (i > 0) {
        paramByteBuffer.position(paramByteBuffer.position() + i);
      }
      return i;
    }
    throw new NullPointerException("Source buffer cannot be null");
  }
  
  public static e.e.b.b b(String paramString)
  {
    int i = paramString.indexOf(".");
    if (i != -1)
    {
      Object localObject = new e.e.a.v.c(paramString.substring(0, i));
      try
      {
        localObject = b(((e.e.a.v.a)localObject).e());
        localObject = e.e.a.e.a((j.a.b.d)localObject);
        if (((e.e.a.a)localObject).equals(e.e.a.a.y))
        {
          paramString = e.e.a.g.a(paramString);
          if (2x.isEmpty()) {
            return new e.e.b.d(paramString[0], paramString[1]);
          }
          throw new ParseException("Unexpected third Base64URL part in the unsecured JWT object", 0);
        }
        if ((localObject instanceof e.e.a.l))
        {
          paramString = e.e.a.g.a(paramString);
          if (paramString.length == 3) {
            return new e.e.b.e(paramString[0], paramString[1], paramString[2]);
          }
          throw new ParseException("Unexpected number of Base64URL parts, must be three", 0);
        }
        if ((localObject instanceof e.e.a.i))
        {
          paramString = e.e.a.g.a(paramString);
          if (paramString.length == 5) {
            return new e.e.b.a(paramString[0], paramString[1], paramString[2], paramString[3], paramString[4]);
          }
          throw new ParseException("Unexpected number of Base64URL parts, must be five", 0);
        }
        paramString = new StringBuilder();
        paramString.append("Unexpected algorithm type: ");
        paramString.append(localObject);
        throw new AssertionError(paramString.toString());
      }
      catch (ParseException paramString)
      {
        localObject = e.a.a.a.a.a("Invalid unsecured/JWS/JWE header: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        throw new ParseException(((StringBuilder)localObject).toString(), 0);
      }
    }
    throw new ParseException("Invalid JWT serialization: Missing dot delimiter(s)", 0);
  }
  
  public static h.a.d.b b()
  {
    return h.a.d.b.valueOf(h.b.a.d.b.a());
  }
  
  public static j.a.b.d b(j.a.b.d paramd, String paramString)
  {
    return (j.a.b.d)a(paramd, paramString, j.a.b.d.class);
  }
  
  public static j.a.b.d b(String paramString)
  {
    try
    {
      j.a.b.l.a locala = new j/a/b/l/a;
      locala.<init>(640);
      paramString = locala.a(paramString);
      if ((paramString instanceof j.a.b.d)) {
        return (j.a.b.d)paramString;
      }
      throw new ParseException("JSON entity is not an object", 0);
    }
    catch (Exception localException)
    {
      paramString = e.a.a.a.a.a("Unexpected exception: ");
      paramString.append(localException.getMessage());
      throw new ParseException(paramString.toString(), 0);
    }
    catch (j.a.b.l.e paramString)
    {
      StringBuilder localStringBuilder = e.a.a.a.a.a("Invalid JSON: ");
      localStringBuilder.append(paramString.getMessage());
      throw new ParseException(localStringBuilder.toString(), 0);
    }
  }
  
  public static String b(j.a.b.d paramd)
  {
    if (paramd.containsKey("kid")) {
      return d(paramd, "kid");
    }
    return null;
  }
  
  public static String b(l.b.a.e parame)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    boolean bool = parame instanceof l.b.a.a0;
    int i = 0;
    if ((bool) && (!(parame instanceof j1)))
    {
      parame = ((l.b.a.a0)parame).c();
      if ((parame.length() > 0) && (parame.charAt(0) == '#')) {
        localStringBuffer.append('\\');
      }
      localStringBuffer.append(parame);
    }
    try
    {
      localStringBuffer.append('#');
      localStringBuffer.append(l.b.j.g.f.b(parame.b().a("DER")));
      int j = localStringBuffer.length();
      int k = localStringBuffer.length();
      int m = 2;
      if ((k < 2) || (localStringBuffer.charAt(0) != '\\') || (localStringBuffer.charAt(1) != '#')) {
        m = 0;
      }
      while (m != j)
      {
        k = localStringBuffer.charAt(m);
        if ((k != 34) && (k != 92) && (k != 43) && (k != 44)) {}
        switch (k)
        {
        default: 
          m++;
          break;
        case 59: 
        case 60: 
        case 61: 
        case 62: 
          localStringBuffer.insert(m, "\\");
          m += 2;
          j++;
        }
      }
      if (localStringBuffer.length() > 0) {
        for (m = i; (localStringBuffer.length() > m) && (localStringBuffer.charAt(m) == ' '); m += 2) {
          localStringBuffer.insert(m, "\\");
        }
      }
      for (m = localStringBuffer.length() - 1; (m >= 0) && (localStringBuffer.charAt(m) == ' '); m--) {
        localStringBuffer.insert(m, '\\');
      }
      return localStringBuffer.toString();
    }
    catch (IOException parame)
    {
      throw new IllegalArgumentException("Other value has no encoded form");
    }
  }
  
  public static PublicKey b(Context paramContext)
  {
    try
    {
      if (e()) {
        return a().getCertificate("adorsysKeyPair").getPublicKey();
      }
      f.a.a.a.b localb = new f/a/a/a/b;
      localb.<init>(paramContext.getString(R.string.message_keypair_does_not_exist), null, b.a.INTERNAL_LIBRARY_EXCEPTION);
      throw localb;
    }
    catch (Exception paramContext)
    {
      throw new f.a.a.a.b(paramContext.getMessage(), paramContext, b.a.KEYSTORE_EXCEPTION);
    }
  }
  
  public static boolean b(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if (paramObject1 == null)
    {
      if (paramObject2 == null) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else {
      bool = paramObject1.equals(paramObject2);
    }
    return bool;
  }
  
  public static long c(j.a.b.d paramd, String paramString)
  {
    paramd = (Number)a(paramd, paramString, Number.class);
    if (paramd != null) {
      return paramd.longValue();
    }
    throw new ParseException(e.a.a.a.a.a("JSON object member with key \"", paramString, "\" is missing or null"), 0);
  }
  
  public static String c()
  {
    return h.b.a.d.a.a(h.b.a.d.b.a());
  }
  
  public static Set<e.e.a.u.e> c(j.a.b.d paramd)
  {
    if (paramd.containsKey("key_ops")) {
      return e.e.a.u.e.parse(e(paramd, "key_ops"));
    }
    return null;
  }
  
  public static boolean c(Context paramContext)
  {
    int i = paramContext.getResources().getConfiguration().getLayoutDirection();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public static l.e.a.q[] c(int paramInt)
  {
    l.e.a.q[] arrayOfq = new l.e.a.q[paramInt];
    for (int i = 0;; i++)
    {
      if (i >= paramInt) {
        return arrayOfq;
      }
      arrayOfq[i] = new l.e.a.q();
    }
  }
  
  public static e.e.a.u.f d(j.a.b.d paramd)
  {
    return e.e.a.u.f.a(d(paramd, "kty"));
  }
  
  public static String d(j.a.b.d paramd, String paramString)
  {
    return (String)a(paramd, paramString, String.class);
  }
  
  public static boolean d()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  @TargetApi(20)
  public static boolean d(Context paramContext)
  {
    if (a == null) {
      a = Boolean.valueOf(paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
    }
    return a.booleanValue();
  }
  
  public static e.e.a.u.g e(j.a.b.d paramd)
  {
    if (paramd.containsKey("use")) {
      return e.e.a.u.g.a(d(paramd, "use"));
    }
    return null;
  }
  
  public static List<String> e(j.a.b.d paramd, String paramString)
  {
    paramd = a(paramd, paramString);
    if (paramd == null) {
      paramd = null;
    }
    try
    {
      paramd = (String[])paramd.toArray(new String[0]);
      if (paramd == null) {
        return null;
      }
      return Arrays.asList(paramd);
    }
    catch (ArrayStoreException paramd)
    {
      throw new ParseException(e.a.a.a.a.a("JSON object member with key \"", paramString, "\" is not an array of strings"), 0);
    }
  }
  
  public static boolean e()
  {
    boolean bool = false;
    try
    {
      Key localKey = a().getKey("adorsysKeyPair", null);
      if (localKey != null) {
        bool = true;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new f.a.a.a.b(localNoSuchAlgorithmException.getMessage(), localNoSuchAlgorithmException, b.a.KEYSTORE_EXCEPTION);
    }
    catch (KeyStoreException|UnrecoverableKeyException localKeyStoreException)
    {
      for (;;) {}
    }
    return bool;
  }
  
  @TargetApi(26)
  public static boolean e(Context paramContext)
  {
    if (d(paramContext))
    {
      int i;
      if (Build.VERSION.SDK_INT >= 24) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (b == null) {
          b = Boolean.valueOf(paramContext.getPackageManager().hasSystemFeature("cn.google"));
        }
        if ((!b.booleanValue()) || (d())) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  public static URI f(j.a.b.d paramd, String paramString)
  {
    paramd = d(paramd, paramString);
    if (paramd == null) {
      return null;
    }
    try
    {
      paramd = new URI(paramd);
      return paramd;
    }
    catch (URISyntaxException paramd)
    {
      throw new ParseException(paramd.getMessage(), 0);
    }
  }
  
  public static List<e.e.a.v.a> f(j.a.b.d paramd)
  {
    if (paramd.containsKey("x5c"))
    {
      paramd = a(a(paramd, "x5c"));
      if (!paramd.isEmpty()) {
        return paramd;
      }
      throw new ParseException("The X.509 certificate chain \"x5c\" must not be empty", 0);
    }
    return null;
  }
  
  public static e.e.a.v.c g(j.a.b.d paramd)
  {
    if (paramd.containsKey("x5t#S256")) {
      return new e.e.a.v.c(d(paramd, "x5t#S256"));
    }
    return null;
  }
  
  public static e.e.a.v.c h(j.a.b.d paramd)
  {
    if (paramd.containsKey("x5t")) {
      return new e.e.a.v.c(d(paramd, "x5t"));
    }
    return null;
  }
  
  public static URI i(j.a.b.d paramd)
  {
    if (paramd.containsKey("x5u")) {
      return f(paramd, "x5u");
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.l.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */