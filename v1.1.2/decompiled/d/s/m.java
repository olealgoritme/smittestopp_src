package d.s;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.navigation.R.styleable;
import e.a.a.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public final class m
{
  public static final ThreadLocal<TypedValue> c = new ThreadLocal();
  public Context a;
  public q b;
  
  public m(Context paramContext, q paramq)
  {
    a = paramContext;
    b = paramq;
  }
  
  public static o a(TypedValue paramTypedValue, o paramo1, o paramo2, String paramString1, String paramString2)
  {
    if ((paramo1 != null) && (paramo1 != paramo2))
    {
      paramo1 = new StringBuilder();
      paramo1.append("Type is ");
      paramo1.append(paramString1);
      paramo1.append(" but found ");
      paramo1.append(paramString2);
      paramo1.append(": ");
      paramo1.append(data);
      throw new XmlPullParserException(paramo1.toString());
    }
    if (paramo1 == null) {
      paramo1 = paramo2;
    }
    return paramo1;
  }
  
  public final d a(TypedArray paramTypedArray, Resources paramResources, int paramInt)
  {
    int i = R.styleable.NavArgument_nullable;
    boolean bool1 = false;
    boolean bool2 = paramTypedArray.getBoolean(i, false);
    Object localObject1 = (TypedValue)c.get();
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new TypedValue();
      c.set(localObject2);
    }
    String str = paramTypedArray.getString(R.styleable.NavArgument_argType);
    Object localObject3 = null;
    Object localObject4;
    if (str != null)
    {
      localObject1 = paramResources.getResourcePackageName(paramInt);
      if (o.b.a().equals(str))
      {
        localObject1 = o.b;
      }
      else if (o.d.a().equals(str))
      {
        localObject1 = o.d;
      }
      else if (o.e.a().equals(str))
      {
        localObject1 = o.e;
      }
      else if (o.f.a().equals(str))
      {
        localObject1 = o.f;
      }
      else if (o.i.a().equals(str))
      {
        localObject1 = o.i;
      }
      else if (o.j.a().equals(str))
      {
        localObject1 = o.j;
      }
      else if (o.k.a().equals(str))
      {
        localObject1 = o.k;
      }
      else if (o.l.a().equals(str))
      {
        localObject1 = o.l;
      }
      else if (o.g.a().equals(str))
      {
        localObject1 = o.g;
      }
      else if (o.h.a().equals(str))
      {
        localObject1 = o.h;
      }
      else if (o.c.a().equals(str))
      {
        localObject1 = o.c;
      }
      else
      {
        if (!str.isEmpty()) {
          try
          {
            if ((str.startsWith(".")) && (localObject1 != null))
            {
              localObject4 = new java/lang/StringBuilder;
              ((StringBuilder)localObject4).<init>();
              ((StringBuilder)localObject4).append((String)localObject1);
              ((StringBuilder)localObject4).append(str);
              localObject1 = ((StringBuilder)localObject4).toString();
            }
            else
            {
              localObject1 = str;
            }
            if (str.endsWith("[]"))
            {
              localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
              localObject4 = Class.forName((String)localObject1);
              if (Parcelable.class.isAssignableFrom((Class)localObject4))
              {
                localObject1 = new o.m((Class)localObject4);
                break label599;
              }
              if (Serializable.class.isAssignableFrom((Class)localObject4))
              {
                localObject1 = new o.o((Class)localObject4);
                break label599;
              }
            }
            else
            {
              localObject4 = Class.forName((String)localObject1);
              if (Parcelable.class.isAssignableFrom((Class)localObject4))
              {
                localObject1 = new o.n((Class)localObject4);
                break label599;
              }
              if (Enum.class.isAssignableFrom((Class)localObject4))
              {
                localObject1 = new o.l((Class)localObject4);
                break label599;
              }
              if (Serializable.class.isAssignableFrom((Class)localObject4))
              {
                localObject1 = new o.p((Class)localObject4);
                break label599;
              }
            }
            paramResources = new java/lang/IllegalArgumentException;
            paramTypedArray = new java/lang/StringBuilder;
            paramTypedArray.<init>();
            paramTypedArray.append((String)localObject1);
            paramTypedArray.append(" is not Serializable or Parcelable.");
            paramResources.<init>(paramTypedArray.toString());
            throw paramResources;
          }
          catch (ClassNotFoundException paramTypedArray)
          {
            throw new RuntimeException(paramTypedArray);
          }
        }
        localObject1 = o.k;
      }
    }
    else
    {
      localObject1 = null;
    }
    label599:
    boolean bool3;
    if (paramTypedArray.getValue(R.styleable.NavArgument_android_defaultValue, (TypedValue)localObject2))
    {
      localObject4 = o.c;
      if (localObject1 == localObject4)
      {
        paramInt = resourceId;
        if (paramInt != 0)
        {
          paramTypedArray = Integer.valueOf(paramInt);
        }
        else if ((type == 16) && (data == 0))
        {
          paramTypedArray = Integer.valueOf(0);
        }
        else
        {
          paramTypedArray = a.a("unsupported value '");
          paramTypedArray.append(string);
          paramTypedArray.append("' for ");
          paramTypedArray.append(((o)localObject1).a());
          paramTypedArray.append(". Must be a reference to a resource.");
          throw new XmlPullParserException(paramTypedArray.toString());
        }
      }
      else
      {
        paramInt = resourceId;
        if (paramInt != 0)
        {
          if (localObject1 == null)
          {
            paramTypedArray = Integer.valueOf(paramInt);
            localObject1 = localObject4;
          }
          else
          {
            paramTypedArray = a.a("unsupported value '");
            paramTypedArray.append(string);
            paramTypedArray.append("' for ");
            paramTypedArray.append(((o)localObject1).a());
            paramTypedArray.append(". You must use a \"");
            paramTypedArray.append(o.c.a());
            paramTypedArray.append("\" type to reference other resources.");
            throw new XmlPullParserException(paramTypedArray.toString());
          }
        }
        else if (localObject1 == o.k)
        {
          paramTypedArray = paramTypedArray.getString(R.styleable.NavArgument_android_defaultValue);
        }
        else
        {
          paramInt = type;
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5)
              {
                if (paramInt != 18)
                {
                  if ((paramInt >= 16) && (paramInt <= 31))
                  {
                    localObject1 = a((TypedValue)localObject2, (o)localObject1, o.b, str, "integer");
                    paramTypedArray = Integer.valueOf(data);
                  }
                  else
                  {
                    paramTypedArray = a.a("unsupported argument type ");
                    paramTypedArray.append(type);
                    throw new XmlPullParserException(paramTypedArray.toString());
                  }
                }
                else
                {
                  localObject1 = a((TypedValue)localObject2, (o)localObject1, o.i, str, "boolean");
                  if (data != 0) {
                    bool3 = true;
                  } else {
                    bool3 = false;
                  }
                  paramTypedArray = Boolean.valueOf(bool3);
                }
              }
              else
              {
                localObject1 = a((TypedValue)localObject2, (o)localObject1, o.b, str, "dimension");
                paramTypedArray = Integer.valueOf((int)((TypedValue)localObject2).getDimension(paramResources.getDisplayMetrics()));
              }
            }
            else
            {
              localObject1 = a((TypedValue)localObject2, (o)localObject1, o.g, str, "float");
              paramTypedArray = Float.valueOf(((TypedValue)localObject2).getFloat());
            }
          }
          else
          {
            localObject2 = string.toString();
            paramResources = (Resources)localObject1;
            if (localObject1 == null) {
              try
              {
                o.b.a((String)localObject2);
                paramTypedArray = o.b;
                paramResources = paramTypedArray;
              }
              catch (IllegalArgumentException paramTypedArray)
              {
                for (;;)
                {
                  try
                  {
                    o.e.a((String)localObject2);
                    paramTypedArray = o.e;
                  }
                  catch (IllegalArgumentException paramTypedArray)
                  {
                    try
                    {
                      o.g.a((String)localObject2);
                      paramTypedArray = o.g;
                    }
                    catch (IllegalArgumentException paramTypedArray)
                    {
                      try
                      {
                        o.i.a((String)localObject2);
                        paramTypedArray = o.i;
                      }
                      catch (IllegalArgumentException paramTypedArray)
                      {
                        paramTypedArray = o.k;
                      }
                    }
                  }
                }
              }
            }
            paramTypedArray = paramResources.a((String)localObject2);
            localObject1 = paramResources;
          }
        }
      }
    }
    else
    {
      paramTypedArray = null;
    }
    if (paramTypedArray != null)
    {
      bool3 = true;
      paramResources = paramTypedArray;
    }
    else
    {
      paramResources = null;
      bool3 = bool1;
    }
    paramTypedArray = (TypedArray)localObject3;
    if (localObject1 != null) {
      paramTypedArray = (TypedArray)localObject1;
    }
    localObject1 = paramTypedArray;
    if (paramTypedArray == null) {
      localObject1 = o.a(paramResources);
    }
    return new d((o)localObject1, bool2, paramResources, bool3);
  }
  
  public final i a(Resources paramResources, XmlResourceParser paramXmlResourceParser, AttributeSet paramAttributeSet, int paramInt)
  {
    i locali = b.a(paramXmlResourceParser.getName()).a();
    locali.a(a, paramAttributeSet);
    int i = paramXmlResourceParser.getDepth() + 1;
    for (;;)
    {
      int j = paramInt;
      int k = paramXmlResourceParser.next();
      if (k == 1) {
        break;
      }
      int m = paramXmlResourceParser.getDepth();
      if ((m < i) && (k == 3)) {
        break;
      }
      if ((k == 2) && (m <= i))
      {
        Object localObject1 = paramXmlResourceParser.getName();
        Object localObject2;
        Object localObject3;
        if ("argument".equals(localObject1))
        {
          localObject2 = paramResources.obtainAttributes(paramAttributeSet, R.styleable.NavArgument);
          localObject3 = ((TypedArray)localObject2).getString(R.styleable.NavArgument_android_name);
          if (localObject3 != null)
          {
            localObject1 = a((TypedArray)localObject2, paramResources, j);
            if (E == null) {
              E = new HashMap();
            }
            E.put(localObject3, localObject1);
            ((TypedArray)localObject2).recycle();
          }
          else
          {
            throw new XmlPullParserException("Arguments must have a name");
          }
        }
        else if ("deepLink".equals(localObject1))
        {
          localObject1 = paramResources.obtainAttributes(paramAttributeSet, R.styleable.NavDeepLink);
          localObject3 = ((TypedArray)localObject1).getString(R.styleable.NavDeepLink_uri);
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject3 = ((String)localObject3).replace("${applicationId}", a.getPackageName());
            if (C == null) {
              C = new ArrayList();
            }
            C.add(new h((String)localObject3));
            ((TypedArray)localObject1).recycle();
          }
          else
          {
            throw new IllegalArgumentException("Every <deepLink> must include an app:uri");
          }
        }
        else if ("action".equals(localObject1))
        {
          localObject3 = paramResources.obtainAttributes(paramAttributeSet, R.styleable.NavAction);
          k = ((TypedArray)localObject3).getResourceId(R.styleable.NavAction_android_id, 0);
          localObject2 = new c(((TypedArray)localObject3).getResourceId(R.styleable.NavAction_destination, 0));
          b = new n(((TypedArray)localObject3).getBoolean(R.styleable.NavAction_launchSingleTop, false), ((TypedArray)localObject3).getResourceId(R.styleable.NavAction_popUpTo, -1), ((TypedArray)localObject3).getBoolean(R.styleable.NavAction_popUpToInclusive, false), ((TypedArray)localObject3).getResourceId(R.styleable.NavAction_enterAnim, -1), ((TypedArray)localObject3).getResourceId(R.styleable.NavAction_exitAnim, -1), ((TypedArray)localObject3).getResourceId(R.styleable.NavAction_popEnterAnim, -1), ((TypedArray)localObject3).getResourceId(R.styleable.NavAction_popExitAnim, -1));
          Bundle localBundle = new Bundle();
          m = paramXmlResourceParser.getDepth() + 1;
          int n;
          int i1;
          do
          {
            n = paramXmlResourceParser.next();
            if (n == 1) {
              break;
            }
            i1 = paramXmlResourceParser.getDepth();
            if ((i1 < m) && (n == 3)) {
              break;
            }
          } while (n != 2);
          for (;;)
          {
            if (i1 <= m)
            {
              if ("argument".equals(paramXmlResourceParser.getName()))
              {
                localObject1 = paramResources.obtainAttributes(paramAttributeSet, R.styleable.NavArgument);
                String str = ((TypedArray)localObject1).getString(R.styleable.NavArgument_android_name);
                if (str != null)
                {
                  d locald = a((TypedArray)localObject1, paramResources, j);
                  boolean bool = c;
                  if ((bool) && (bool)) {
                    a.a(localBundle, str, d);
                  }
                  ((TypedArray)localObject1).recycle();
                }
                else
                {
                  throw new XmlPullParserException("Arguments must have a name");
                }
              }
              j = paramInt;
            }
          }
          if (!localBundle.isEmpty()) {
            c = localBundle;
          }
          if (locali.a())
          {
            if (k != 0)
            {
              if (D == null) {
                D = new d.f.i(10);
              }
              D.c(k, localObject2);
              ((TypedArray)localObject3).recycle();
            }
            else
            {
              throw new IllegalArgumentException("Cannot have an action with actionId 0");
            }
          }
          else
          {
            paramResources = new StringBuilder();
            paramResources.append("Cannot add action ");
            paramResources.append(k);
            paramResources.append(" to ");
            paramResources.append(locali);
            paramResources.append(" as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
            throw new UnsupportedOperationException(paramResources.toString());
          }
        }
        else if (("include".equals(localObject1)) && ((locali instanceof j)))
        {
          localObject1 = paramResources.obtainAttributes(paramAttributeSet, R.styleable.NavInclude);
          j = ((TypedArray)localObject1).getResourceId(R.styleable.NavInclude_graph, 0);
          ((j)locali).a(a(j));
          ((TypedArray)localObject1).recycle();
        }
        else if ((locali instanceof j))
        {
          ((j)locali).a(a(paramResources, paramXmlResourceParser, paramAttributeSet, paramInt));
        }
      }
    }
    return locali;
  }
  
  /* Error */
  @android.annotation.SuppressLint({"ResourceType"})
  public j a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	d/s/m:a	Landroid/content/Context;
    //   4: invokevirtual 504	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   7: astore_2
    //   8: aload_2
    //   9: iload_1
    //   10: invokevirtual 508	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   13: astore_3
    //   14: aload_3
    //   15: invokestatic 514	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   18: astore 4
    //   20: aload_3
    //   21: invokeinterface 317 1 0
    //   26: istore 5
    //   28: iload 5
    //   30: iconst_2
    //   31: if_icmpeq +12 -> 43
    //   34: iload 5
    //   36: iconst_1
    //   37: if_icmpeq +6 -> 43
    //   40: goto -20 -> 20
    //   43: iload 5
    //   45: iconst_2
    //   46: if_icmpne +100 -> 146
    //   49: aload_3
    //   50: invokeinterface 296 1 0
    //   55: astore 6
    //   57: aload_0
    //   58: aload_2
    //   59: aload_3
    //   60: aload 4
    //   62: iload_1
    //   63: invokevirtual 495	d/s/m:a	(Landroid/content/res/Resources;Landroid/content/res/XmlResourceParser;Landroid/util/AttributeSet;I)Ld/s/i;
    //   66: astore 4
    //   68: aload 4
    //   70: instanceof 481
    //   73: ifeq +19 -> 92
    //   76: aload 4
    //   78: checkcast 481	d/s/j
    //   81: astore 6
    //   83: aload_3
    //   84: invokeinterface 517 1 0
    //   89: aload 6
    //   91: areturn
    //   92: new 64	java/lang/IllegalArgumentException
    //   95: astore 4
    //   97: new 30	java/lang/StringBuilder
    //   100: astore 7
    //   102: aload 7
    //   104: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   107: aload 7
    //   109: ldc_w 519
    //   112: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 7
    //   118: aload 6
    //   120: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 7
    //   126: ldc_w 521
    //   129: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 4
    //   135: aload 7
    //   137: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokespecial 197	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   143: aload 4
    //   145: athrow
    //   146: new 52	org/xmlpull/v1/XmlPullParserException
    //   149: astore 6
    //   151: aload 6
    //   153: ldc_w 523
    //   156: invokespecial 59	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   159: aload 6
    //   161: athrow
    //   162: astore_2
    //   163: goto +76 -> 239
    //   166: astore 7
    //   168: new 199	java/lang/RuntimeException
    //   171: astore 6
    //   173: new 30	java/lang/StringBuilder
    //   176: astore 4
    //   178: aload 4
    //   180: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   183: aload 4
    //   185: ldc_w 525
    //   188: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 4
    //   194: aload_2
    //   195: iload_1
    //   196: invokevirtual 528	android/content/res/Resources:getResourceName	(I)Ljava/lang/String;
    //   199: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 4
    //   205: ldc_w 530
    //   208: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 4
    //   214: aload_3
    //   215: invokeinterface 533 1 0
    //   220: invokevirtual 50	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 6
    //   226: aload 4
    //   228: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: aload 7
    //   233: invokespecial 536	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   236: aload 6
    //   238: athrow
    //   239: aload_3
    //   240: invokeinterface 517 1 0
    //   245: aload_2
    //   246: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	m
    //   0	247	1	paramInt	int
    //   7	52	2	localResources	Resources
    //   162	84	2	localObject1	Object
    //   13	227	3	localXmlResourceParser	XmlResourceParser
    //   18	209	4	localObject2	Object
    //   26	21	5	i	int
    //   55	182	6	localObject3	Object
    //   100	36	7	localStringBuilder	StringBuilder
    //   166	66	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   20	28	162	finally
    //   49	83	162	finally
    //   92	146	162	finally
    //   146	162	162	finally
    //   168	239	162	finally
    //   20	28	166	java/lang/Exception
    //   49	83	166	java/lang/Exception
    //   92	146	166	java/lang/Exception
    //   146	162	166	java/lang/Exception
  }
}

/* Location:
 * Qualified Name:     d.s.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */