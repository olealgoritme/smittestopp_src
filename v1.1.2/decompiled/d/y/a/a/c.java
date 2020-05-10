package d.y.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import d.b.a.s;
import d.f.a;
import d.f.h;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class c
  extends f
  implements b
{
  public ArgbEvaluator A = null;
  public final Drawable.Callback B = new a();
  public b y;
  public Context z;
  
  public c()
  {
    this(null, null, null);
  }
  
  public c(Context paramContext, b paramb, Resources paramResources)
  {
    z = paramContext;
    if (paramb != null) {
      y = paramb;
    } else {
      y = new b(paramb, B, paramResources);
    }
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      localDrawable.applyTheme(paramTheme);
    }
  }
  
  public boolean canApplyTheme()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.canApplyTheme();
    }
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      localDrawable.draw(paramCanvas);
      return;
    }
    y.b.draw(paramCanvas);
    if (y.c.isStarted()) {
      invalidateSelf();
    }
  }
  
  public int getAlpha()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.getAlpha();
    }
    return y.b.getAlpha();
  }
  
  public int getChangingConfigurations()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | y.a;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if ((x != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new c(x.getConstantState());
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return y.b.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return y.b.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.getOpacity();
    }
    return y.b.getOpacity();
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  /* Error */
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	d/y/a/a/f:x	Landroid/graphics/drawable/Drawable;
    //   4: astore 5
    //   6: aload 5
    //   8: ifnull +14 -> 22
    //   11: aload 5
    //   13: aload_1
    //   14: aload_2
    //   15: aload_3
    //   16: aload 4
    //   18: invokevirtual 125	android/graphics/drawable/Drawable:inflate	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)V
    //   21: return
    //   22: aload_2
    //   23: invokeinterface 130 1 0
    //   28: istore 6
    //   30: aload_2
    //   31: invokeinterface 133 1 0
    //   36: istore 7
    //   38: iload 6
    //   40: iconst_1
    //   41: if_icmpeq +614 -> 655
    //   44: aload_2
    //   45: invokeinterface 133 1 0
    //   50: iload 7
    //   52: iconst_1
    //   53: iadd
    //   54: if_icmpge +9 -> 63
    //   57: iload 6
    //   59: iconst_3
    //   60: if_icmpeq +595 -> 655
    //   63: iload 6
    //   65: iconst_2
    //   66: if_icmpne +578 -> 644
    //   69: aload_2
    //   70: invokeinterface 137 1 0
    //   75: astore 8
    //   77: ldc -117
    //   79: aload 8
    //   81: invokevirtual 145	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: istore 9
    //   86: aconst_null
    //   87: astore 10
    //   89: aconst_null
    //   90: astore 11
    //   92: aconst_null
    //   93: astore 5
    //   95: iload 9
    //   97: ifeq +91 -> 188
    //   100: aload_1
    //   101: aload 4
    //   103: aload_3
    //   104: getstatic 151	d/y/a/a/a:e	[I
    //   107: invokestatic 156	d/b/a/s:a	(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   110: astore 5
    //   112: aload 5
    //   114: iconst_0
    //   115: iconst_0
    //   116: invokevirtual 162	android/content/res/TypedArray:getResourceId	(II)I
    //   119: istore 6
    //   121: iload 6
    //   123: ifeq +57 -> 180
    //   126: aload_1
    //   127: iload 6
    //   129: aload 4
    //   131: invokestatic 165	d/y/a/a/g:a	(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)Ld/y/a/a/g;
    //   134: astore 8
    //   136: aload 8
    //   138: iconst_0
    //   139: putfield 169	d/y/a/a/g:C	Z
    //   142: aload 8
    //   144: aload_0
    //   145: getfield 37	d/y/a/a/c:B	Landroid/graphics/drawable/Drawable$Callback;
    //   148: invokevirtual 173	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   151: aload_0
    //   152: getfield 41	d/y/a/a/c:y	Ld/y/a/a/c$b;
    //   155: getfield 65	d/y/a/a/c$b:b	Ld/y/a/a/g;
    //   158: astore 10
    //   160: aload 10
    //   162: ifnull +9 -> 171
    //   165: aload 10
    //   167: aconst_null
    //   168: invokevirtual 173	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   171: aload_0
    //   172: getfield 41	d/y/a/a/c:y	Ld/y/a/a/c$b;
    //   175: aload 8
    //   177: putfield 65	d/y/a/a/c$b:b	Ld/y/a/a/g;
    //   180: aload 5
    //   182: invokevirtual 176	android/content/res/TypedArray:recycle	()V
    //   185: goto +459 -> 644
    //   188: ldc -78
    //   190: aload 8
    //   192: invokevirtual 145	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   195: ifeq +449 -> 644
    //   198: aload_1
    //   199: aload_3
    //   200: getstatic 181	d/y/a/a/a:f	[I
    //   203: invokevirtual 187	android/content/res/Resources:obtainAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   206: astore 12
    //   208: aload 12
    //   210: iconst_0
    //   211: invokevirtual 191	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   214: astore 13
    //   216: aload 12
    //   218: iconst_1
    //   219: iconst_0
    //   220: invokevirtual 162	android/content/res/TypedArray:getResourceId	(II)I
    //   223: istore 6
    //   225: iload 6
    //   227: ifeq +412 -> 639
    //   230: aload_0
    //   231: getfield 39	d/y/a/a/c:z	Landroid/content/Context;
    //   234: astore 14
    //   236: aload 14
    //   238: ifnull +385 -> 623
    //   241: getstatic 98	android/os/Build$VERSION:SDK_INT	I
    //   244: bipush 24
    //   246: if_icmplt +15 -> 261
    //   249: aload 14
    //   251: iload 6
    //   253: invokestatic 197	android/animation/AnimatorInflater:loadAnimator	(Landroid/content/Context;I)Landroid/animation/Animator;
    //   256: astore 5
    //   258: goto +58 -> 316
    //   261: aload 14
    //   263: invokevirtual 203	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   266: astore 15
    //   268: aload 14
    //   270: invokevirtual 207	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   273: astore 16
    //   275: aload 15
    //   277: iload 6
    //   279: invokevirtual 211	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   282: astore 8
    //   284: aload 8
    //   286: invokestatic 217	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   289: astore 5
    //   291: aload 14
    //   293: aload 15
    //   295: aload 16
    //   297: aload 8
    //   299: aload 5
    //   301: aconst_null
    //   302: iconst_0
    //   303: fconst_1
    //   304: invokestatic 220	d/b/a/s:a	(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/animation/AnimatorSet;IF)Landroid/animation/Animator;
    //   307: astore 5
    //   309: aload 8
    //   311: invokeinterface 225 1 0
    //   316: aload 5
    //   318: aload_0
    //   319: getfield 41	d/y/a/a/c:y	Ld/y/a/a/c$b;
    //   322: getfield 65	d/y/a/a/c$b:b	Ld/y/a/a/g;
    //   325: getfield 228	d/y/a/a/g:y	Ld/y/a/a/g$h;
    //   328: getfield 233	d/y/a/a/g$h:b	Ld/y/a/a/g$g;
    //   331: getfield 239	d/y/a/a/g$g:p	Ld/f/a;
    //   334: aload 13
    //   336: aconst_null
    //   337: invokevirtual 245	d/f/h:getOrDefault	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   340: invokevirtual 251	android/animation/Animator:setTarget	(Ljava/lang/Object;)V
    //   343: aload_0
    //   344: getfield 41	d/y/a/a/c:y	Ld/y/a/a/c$b;
    //   347: astore 8
    //   349: aload 8
    //   351: getfield 255	d/y/a/a/c$b:d	Ljava/util/ArrayList;
    //   354: ifnonnull +29 -> 383
    //   357: aload 8
    //   359: new 257	java/util/ArrayList
    //   362: dup
    //   363: invokespecial 258	java/util/ArrayList:<init>	()V
    //   366: putfield 255	d/y/a/a/c$b:d	Ljava/util/ArrayList;
    //   369: aload_0
    //   370: getfield 41	d/y/a/a/c:y	Ld/y/a/a/c$b;
    //   373: new 260	d/f/a
    //   376: dup
    //   377: invokespecial 261	d/f/a:<init>	()V
    //   380: putfield 263	d/y/a/a/c$b:e	Ld/f/a;
    //   383: aload_0
    //   384: getfield 41	d/y/a/a/c:y	Ld/y/a/a/c$b;
    //   387: getfield 255	d/y/a/a/c$b:d	Ljava/util/ArrayList;
    //   390: aload 5
    //   392: invokevirtual 266	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   395: pop
    //   396: aload_0
    //   397: getfield 41	d/y/a/a/c:y	Ld/y/a/a/c$b;
    //   400: getfield 263	d/y/a/a/c$b:e	Ld/f/a;
    //   403: aload 5
    //   405: aload 13
    //   407: invokevirtual 269	d/f/h:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   410: pop
    //   411: goto +228 -> 639
    //   414: astore_1
    //   415: goto +12 -> 427
    //   418: astore_1
    //   419: goto +17 -> 436
    //   422: astore_1
    //   423: goto +186 -> 609
    //   426: astore_1
    //   427: aload_1
    //   428: astore_2
    //   429: aload 8
    //   431: astore_1
    //   432: goto +20 -> 452
    //   435: astore_1
    //   436: aload_1
    //   437: astore_2
    //   438: aload 8
    //   440: astore_1
    //   441: goto +90 -> 531
    //   444: astore_1
    //   445: goto +160 -> 605
    //   448: astore_2
    //   449: aload 10
    //   451: astore_1
    //   452: aload_1
    //   453: astore 5
    //   455: new 271	android/content/res/Resources$NotFoundException
    //   458: astore_3
    //   459: aload_1
    //   460: astore 5
    //   462: new 273	java/lang/StringBuilder
    //   465: astore 4
    //   467: aload_1
    //   468: astore 5
    //   470: aload 4
    //   472: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   475: aload_1
    //   476: astore 5
    //   478: aload 4
    //   480: ldc_w 276
    //   483: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload_1
    //   488: astore 5
    //   490: aload 4
    //   492: iload 6
    //   494: invokestatic 285	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   497: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload_1
    //   502: astore 5
    //   504: aload_3
    //   505: aload 4
    //   507: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokespecial 291	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   513: aload_1
    //   514: astore 5
    //   516: aload_3
    //   517: aload_2
    //   518: invokevirtual 295	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   521: pop
    //   522: aload_1
    //   523: astore 5
    //   525: aload_3
    //   526: athrow
    //   527: astore_2
    //   528: aload 11
    //   530: astore_1
    //   531: aload_1
    //   532: astore 5
    //   534: new 271	android/content/res/Resources$NotFoundException
    //   537: astore 4
    //   539: aload_1
    //   540: astore 5
    //   542: new 273	java/lang/StringBuilder
    //   545: astore_3
    //   546: aload_1
    //   547: astore 5
    //   549: aload_3
    //   550: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   553: aload_1
    //   554: astore 5
    //   556: aload_3
    //   557: ldc_w 276
    //   560: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload_1
    //   565: astore 5
    //   567: aload_3
    //   568: iload 6
    //   570: invokestatic 285	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   573: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload_1
    //   578: astore 5
    //   580: aload 4
    //   582: aload_3
    //   583: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokespecial 291	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   589: aload_1
    //   590: astore 5
    //   592: aload 4
    //   594: aload_2
    //   595: invokevirtual 295	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   598: pop
    //   599: aload_1
    //   600: astore 5
    //   602: aload 4
    //   604: athrow
    //   605: aload 5
    //   607: astore 8
    //   609: aload 8
    //   611: ifnull +10 -> 621
    //   614: aload 8
    //   616: invokeinterface 225 1 0
    //   621: aload_1
    //   622: athrow
    //   623: aload 12
    //   625: invokevirtual 176	android/content/res/TypedArray:recycle	()V
    //   628: new 297	java/lang/IllegalStateException
    //   631: dup
    //   632: ldc_w 299
    //   635: invokespecial 300	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   638: athrow
    //   639: aload 12
    //   641: invokevirtual 176	android/content/res/TypedArray:recycle	()V
    //   644: aload_2
    //   645: invokeinterface 303 1 0
    //   650: istore 6
    //   652: goto -614 -> 38
    //   655: aload_0
    //   656: getfield 41	d/y/a/a/c:y	Ld/y/a/a/c$b;
    //   659: astore_1
    //   660: aload_1
    //   661: getfield 71	d/y/a/a/c$b:c	Landroid/animation/AnimatorSet;
    //   664: ifnonnull +14 -> 678
    //   667: aload_1
    //   668: new 73	android/animation/AnimatorSet
    //   671: dup
    //   672: invokespecial 304	android/animation/AnimatorSet:<init>	()V
    //   675: putfield 71	d/y/a/a/c$b:c	Landroid/animation/AnimatorSet;
    //   678: aload_1
    //   679: getfield 71	d/y/a/a/c$b:c	Landroid/animation/AnimatorSet;
    //   682: aload_1
    //   683: getfield 255	d/y/a/a/c$b:d	Ljava/util/ArrayList;
    //   686: invokevirtual 308	android/animation/AnimatorSet:playTogether	(Ljava/util/Collection;)V
    //   689: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	690	0	this	c
    //   0	690	1	paramResources	Resources
    //   0	690	2	paramXmlPullParser	XmlPullParser
    //   0	690	3	paramAttributeSet	AttributeSet
    //   0	690	4	paramTheme	Resources.Theme
    //   4	602	5	localObject1	Object
    //   28	623	6	i	int
    //   36	18	7	j	int
    //   75	540	8	localObject2	Object
    //   84	12	9	bool	boolean
    //   87	363	10	localg	g
    //   90	439	11	localObject3	Object
    //   206	434	12	localTypedArray	android.content.res.TypedArray
    //   214	192	13	str	String
    //   234	58	14	localContext	Context
    //   266	28	15	localResources	Resources
    //   273	23	16	localTheme	Resources.Theme
    // Exception table:
    //   from	to	target	type
    //   291	309	414	java/io/IOException
    //   291	309	418	org/xmlpull/v1/XmlPullParserException
    //   284	291	422	finally
    //   291	309	422	finally
    //   284	291	426	java/io/IOException
    //   284	291	435	org/xmlpull/v1/XmlPullParserException
    //   275	284	444	finally
    //   455	459	444	finally
    //   462	467	444	finally
    //   470	475	444	finally
    //   478	487	444	finally
    //   490	501	444	finally
    //   504	513	444	finally
    //   516	522	444	finally
    //   525	527	444	finally
    //   534	539	444	finally
    //   542	546	444	finally
    //   549	553	444	finally
    //   556	564	444	finally
    //   567	577	444	finally
    //   580	589	444	finally
    //   592	599	444	finally
    //   602	605	444	finally
    //   275	284	448	java/io/IOException
    //   275	284	527	org/xmlpull/v1/XmlPullParserException
  }
  
  public boolean isAutoMirrored()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.isAutoMirrored();
    }
    return y.b.isAutoMirrored();
  }
  
  public boolean isRunning()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return ((AnimatedVectorDrawable)localDrawable).isRunning();
    }
    return y.c.isRunning();
  }
  
  public boolean isStateful()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.isStateful();
    }
    return y.b.isStateful();
  }
  
  public Drawable mutate()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      localDrawable.mutate();
    }
    return this;
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      localDrawable.setBounds(paramRect);
      return;
    }
    y.b.setBounds(paramRect);
  }
  
  public boolean onLevelChange(int paramInt)
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.setLevel(paramInt);
    }
    return y.b.setLevel(paramInt);
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.setState(paramArrayOfInt);
    }
    return y.b.setState(paramArrayOfInt);
  }
  
  public void setAlpha(int paramInt)
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      localDrawable.setAlpha(paramInt);
      return;
    }
    y.b.setAlpha(paramInt);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      localDrawable.setAutoMirrored(paramBoolean);
      return;
    }
    g localg = y.b;
    localDrawable = x;
    if (localDrawable != null) {
      localDrawable.setAutoMirrored(paramBoolean);
    } else {
      y.e = paramBoolean;
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    Object localObject = x;
    if (localObject != null)
    {
      ((Drawable)localObject).setColorFilter(paramColorFilter);
      return;
    }
    localObject = y.b;
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      localDrawable.setColorFilter(paramColorFilter);
    }
    else
    {
      A = paramColorFilter;
      ((g)localObject).invalidateSelf();
    }
  }
  
  public void setTint(int paramInt)
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      s.b(localDrawable, paramInt);
      return;
    }
    y.b.setTint(paramInt);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      s.a(localDrawable, paramColorStateList);
      return;
    }
    y.b.setTintList(paramColorStateList);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      s.a(localDrawable, paramMode);
      return;
    }
    y.b.setTintMode(paramMode);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    y.b.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void start()
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      ((AnimatedVectorDrawable)localDrawable).start();
      return;
    }
    if (y.c.isStarted()) {
      return;
    }
    y.c.start();
    invalidateSelf();
  }
  
  public void stop()
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      ((AnimatedVectorDrawable)localDrawable).stop();
      return;
    }
    y.c.end();
  }
  
  public class a
    implements Drawable.Callback
  {
    public a() {}
    
    public void invalidateDrawable(Drawable paramDrawable)
    {
      invalidateSelf();
    }
    
    public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
    {
      scheduleSelf(paramRunnable, paramLong);
    }
    
    public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
    {
      unscheduleSelf(paramRunnable);
    }
  }
  
  public static class b
    extends Drawable.ConstantState
  {
    public int a;
    public g b;
    public AnimatorSet c;
    public ArrayList<Animator> d;
    public a<Animator, String> e;
    
    public b(b paramb, Drawable.Callback paramCallback, Resources paramResources)
    {
      if (paramb != null)
      {
        a = a;
        Object localObject = b;
        int i = 0;
        if (localObject != null)
        {
          localObject = ((g)localObject).getConstantState();
          if (paramResources != null) {
            b = ((g)((Drawable.ConstantState)localObject).newDrawable(paramResources));
          } else {
            b = ((g)((Drawable.ConstantState)localObject).newDrawable());
          }
          paramResources = b;
          paramResources.mutate();
          b = paramResources;
          paramResources.setCallback(paramCallback);
          b.setBounds(b.getBounds());
          b.C = false;
        }
        paramCallback = d;
        if (paramCallback != null)
        {
          int j = paramCallback.size();
          d = new ArrayList(j);
          e = new a(j);
          while (i < j)
          {
            paramResources = (Animator)d.get(i);
            paramCallback = paramResources.clone();
            paramResources = (String)e.getOrDefault(paramResources, null);
            paramCallback.setTarget(b.y.b.p.getOrDefault(paramResources, null));
            d.add(paramCallback);
            e.put(paramCallback, paramResources);
            i++;
          }
          if (c == null) {
            c = new AnimatorSet();
          }
          c.playTogether(d);
        }
      }
    }
    
    public int getChangingConfigurations()
    {
      return a;
    }
    
    public Drawable newDrawable()
    {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }
  }
  
  public static class c
    extends Drawable.ConstantState
  {
    public final Drawable.ConstantState a;
    
    public c(Drawable.ConstantState paramConstantState)
    {
      a = paramConstantState;
    }
    
    public boolean canApplyTheme()
    {
      return a.canApplyTheme();
    }
    
    public int getChangingConfigurations()
    {
      return a.getChangingConfigurations();
    }
    
    public Drawable newDrawable()
    {
      c localc = new c(null, null, null);
      Drawable localDrawable = a.newDrawable();
      x = localDrawable;
      localDrawable.setCallback(B);
      return localc;
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      c localc = new c(null, null, null);
      paramResources = a.newDrawable(paramResources);
      x = paramResources;
      paramResources.setCallback(B);
      return localc;
    }
    
    public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      c localc = new c(null, null, null);
      paramResources = a.newDrawable(paramResources, paramTheme);
      x = paramResources;
      paramResources.setCallback(B);
      return localc;
    }
  }
}

/* Location:
 * Qualified Name:     d.y.a.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */