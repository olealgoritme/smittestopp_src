package d.i.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.CustomFallbackBuilder;
import android.graphics.fonts.Font;
import android.graphics.fonts.Font.Builder;
import android.graphics.fonts.FontFamily.Builder;
import android.graphics.fonts.FontStyle;
import d.i.b.b.c;
import d.i.b.b.d;
import d.i.f.b.f;
import java.io.IOException;

public class h
  extends i
{
  public Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      paramContext = new android/graphics/fonts/FontFamily$Builder;
      paramString = new android/graphics/fonts/Font$Builder;
      paramString.<init>(paramResources, paramInt1);
      paramContext.<init>(paramString.build());
      paramContext = paramContext.build();
      if ((paramInt2 & 0x1) != 0) {
        paramInt1 = 700;
      } else {
        paramInt1 = 400;
      }
      if ((paramInt2 & 0x2) != 0) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      paramResources = new FontStyle(paramInt1, paramInt2);
      return new Typeface.CustomFallbackBuilder(paramContext).setStyle(paramResources).build();
    }
    catch (IOException paramContext) {}
    return null;
  }
  
  /* Error */
  public Typeface a(Context paramContext, android.os.CancellationSignal paramCancellationSignal, b.f[] paramArrayOff, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 54	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 5
    //   6: aload_3
    //   7: arraylength
    //   8: istore 6
    //   10: iconst_0
    //   11: istore 7
    //   13: aconst_null
    //   14: astore_1
    //   15: iconst_0
    //   16: istore 8
    //   18: iconst_1
    //   19: istore 9
    //   21: iload 8
    //   23: iload 6
    //   25: if_icmpge +185 -> 210
    //   28: aload_3
    //   29: iload 8
    //   31: aaload
    //   32: astore 10
    //   34: aload_1
    //   35: astore 11
    //   37: aload 5
    //   39: aload 10
    //   41: getfield 59	d/i/f/b$f:a	Landroid/net/Uri;
    //   44: ldc 61
    //   46: aload_2
    //   47: invokevirtual 67	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   50: astore 12
    //   52: aload 12
    //   54: ifnonnull +25 -> 79
    //   57: aload_1
    //   58: astore 11
    //   60: aload 12
    //   62: ifnull +139 -> 201
    //   65: aload_1
    //   66: astore 11
    //   68: aload 12
    //   70: invokevirtual 72	android/os/ParcelFileDescriptor:close	()V
    //   73: aload_1
    //   74: astore 11
    //   76: goto +125 -> 201
    //   79: new 17	android/graphics/fonts/Font$Builder
    //   82: astore 11
    //   84: aload 11
    //   86: aload 12
    //   88: invokespecial 75	android/graphics/fonts/Font$Builder:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   91: aload 11
    //   93: aload 10
    //   95: getfield 79	d/i/f/b$f:c	I
    //   98: invokevirtual 83	android/graphics/fonts/Font$Builder:setWeight	(I)Landroid/graphics/fonts/Font$Builder;
    //   101: astore 11
    //   103: aload 10
    //   105: getfield 87	d/i/f/b$f:d	Z
    //   108: ifeq +6 -> 114
    //   111: goto +6 -> 117
    //   114: iconst_0
    //   115: istore 9
    //   117: aload 11
    //   119: iload 9
    //   121: invokevirtual 90	android/graphics/fonts/Font$Builder:setSlant	(I)Landroid/graphics/fonts/Font$Builder;
    //   124: aload 10
    //   126: getfield 93	d/i/f/b$f:b	I
    //   129: invokevirtual 96	android/graphics/fonts/Font$Builder:setTtcIndex	(I)Landroid/graphics/fonts/Font$Builder;
    //   132: invokevirtual 24	android/graphics/fonts/Font$Builder:build	()Landroid/graphics/fonts/Font;
    //   135: astore 11
    //   137: aload_1
    //   138: ifnonnull +20 -> 158
    //   141: new 15	android/graphics/fonts/FontFamily$Builder
    //   144: dup
    //   145: aload 11
    //   147: invokespecial 27	android/graphics/fonts/FontFamily$Builder:<init>	(Landroid/graphics/fonts/Font;)V
    //   150: astore 11
    //   152: aload 11
    //   154: astore_1
    //   155: goto -90 -> 65
    //   158: aload_1
    //   159: aload 11
    //   161: invokevirtual 100	android/graphics/fonts/FontFamily$Builder:addFont	(Landroid/graphics/fonts/Font;)Landroid/graphics/fonts/FontFamily$Builder;
    //   164: pop
    //   165: goto -100 -> 65
    //   168: astore 13
    //   170: aload 13
    //   172: athrow
    //   173: astore 10
    //   175: aload 12
    //   177: invokevirtual 72	android/os/ParcelFileDescriptor:close	()V
    //   180: goto +15 -> 195
    //   183: astore 12
    //   185: aload_1
    //   186: astore 11
    //   188: aload 13
    //   190: aload 12
    //   192: invokevirtual 106	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   195: aload_1
    //   196: astore 11
    //   198: aload 10
    //   200: athrow
    //   201: iinc 8 1
    //   204: aload 11
    //   206: astore_1
    //   207: goto -189 -> 18
    //   210: aload_1
    //   211: ifnonnull +5 -> 216
    //   214: aconst_null
    //   215: areturn
    //   216: iload 4
    //   218: iconst_1
    //   219: iand
    //   220: ifeq +11 -> 231
    //   223: sipush 700
    //   226: istore 8
    //   228: goto +8 -> 236
    //   231: sipush 400
    //   234: istore 8
    //   236: iload 7
    //   238: istore 9
    //   240: iload 4
    //   242: iconst_2
    //   243: iand
    //   244: ifeq +6 -> 250
    //   247: iconst_1
    //   248: istore 9
    //   250: new 32	android/graphics/fonts/FontStyle
    //   253: dup
    //   254: iload 8
    //   256: iload 9
    //   258: invokespecial 35	android/graphics/fonts/FontStyle:<init>	(II)V
    //   261: astore_2
    //   262: new 37	android/graphics/Typeface$CustomFallbackBuilder
    //   265: dup
    //   266: aload_1
    //   267: invokevirtual 30	android/graphics/fonts/FontFamily$Builder:build	()Landroid/graphics/fonts/FontFamily;
    //   270: invokespecial 40	android/graphics/Typeface$CustomFallbackBuilder:<init>	(Landroid/graphics/fonts/FontFamily;)V
    //   273: aload_2
    //   274: invokevirtual 44	android/graphics/Typeface$CustomFallbackBuilder:setStyle	(Landroid/graphics/fonts/FontStyle;)Landroid/graphics/Typeface$CustomFallbackBuilder;
    //   277: invokevirtual 47	android/graphics/Typeface$CustomFallbackBuilder:build	()Landroid/graphics/Typeface;
    //   280: areturn
    //   281: astore_1
    //   282: goto -81 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	h
    //   0	285	1	paramContext	Context
    //   0	285	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	285	3	paramArrayOff	b.f[]
    //   0	285	4	paramInt	int
    //   4	34	5	localContentResolver	android.content.ContentResolver
    //   8	18	6	i	int
    //   11	226	7	j	int
    //   16	239	8	k	int
    //   19	238	9	m	int
    //   32	93	10	localf	b.f
    //   173	26	10	localObject1	Object
    //   35	170	11	localObject2	Object
    //   50	126	12	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   183	8	12	localThrowable	Throwable
    //   168	21	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   79	111	168	finally
    //   117	137	168	finally
    //   141	152	168	finally
    //   158	165	168	finally
    //   170	173	173	finally
    //   175	180	183	finally
    //   37	52	281	java/io/IOException
    //   68	73	281	java/io/IOException
    //   188	195	281	java/io/IOException
    //   198	201	281	java/io/IOException
  }
  
  public Typeface a(Context paramContext, c paramc, Resources paramResources, int paramInt)
  {
    d[] arrayOfd = a;
    int i = arrayOfd.length;
    int j = 0;
    paramContext = null;
    int k = 0;
    for (;;)
    {
      int m = 1;
      if (k >= i) {
        break;
      }
      paramc = arrayOfd[k];
      try
      {
        Object localObject = new android/graphics/fonts/Font$Builder;
        ((Font.Builder)localObject).<init>(paramResources, f);
        localObject = ((Font.Builder)localObject).setWeight(b);
        if (!c) {
          m = 0;
        }
        localObject = ((Font.Builder)localObject).setSlant(m).setTtcIndex(e).setFontVariationSettings(d).build();
        if (paramContext == null)
        {
          paramc = new android/graphics/fonts/FontFamily$Builder;
          paramc.<init>((Font)localObject);
          paramContext = paramc;
        }
        else
        {
          paramContext.addFont((Font)localObject);
        }
        k++;
      }
      catch (IOException paramc)
      {
        for (;;) {}
      }
    }
    if (paramContext == null) {
      return null;
    }
    if ((paramInt & 0x1) != 0) {
      k = 700;
    } else {
      k = 400;
    }
    m = j;
    if ((paramInt & 0x2) != 0) {
      m = 1;
    }
    paramc = new FontStyle(k, m);
    return new Typeface.CustomFallbackBuilder(paramContext.build()).setStyle(paramc).build();
  }
  
  public b.f a(b.f[] paramArrayOff, int paramInt)
  {
    throw new RuntimeException("Do not use this function in API 29 or later.");
  }
}

/* Location:
 * Qualified Name:     base.d.i.c.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */