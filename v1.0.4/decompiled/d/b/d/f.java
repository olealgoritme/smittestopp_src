package d.b.d;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.R.styleable;

import org.xmlpull.v1.XmlPullParser;

import d.b.d.i.j.a;
import d.b.e.e0;
import d.b.e.x0;
import d.i.i.b;

public class f
  extends MenuInflater
{
  public static final Class<?>[] e;
  public static final Class<?>[] f;
  public final Object[] a;
  public final Object[] b;
  public Context c;
  public Object d;
  
  static
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Context.class;
    e = arrayOfClass;
    f = arrayOfClass;
  }
  
  public f(Context paramContext)
  {
    super(paramContext);
    c = paramContext;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramContext;
    a = arrayOfObject;
    b = arrayOfObject;
  }
  
  public final Object a(Object paramObject)
  {
    if ((paramObject instanceof Activity)) {
      return paramObject;
    }
    Object localObject = paramObject;
    if ((paramObject instanceof ContextWrapper)) {
      localObject = a(((ContextWrapper)paramObject).getBaseContext());
    }
    return localObject;
  }
  
  public final void a(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
  {
    f.b localb = new f.b(this, paramMenu);
    int i = paramXmlPullParser.getEventType();
    label1043:
    label1077:
    label1104:
    for (;;)
    {
      if (i == 2)
      {
        paramMenu = paramXmlPullParser.getName();
        if (paramMenu.equals("menu")) {
          i = paramXmlPullParser.next();
        } else {
          throw new RuntimeException(a.b("Expecting menu, got ", paramMenu));
        }
      }
      else
      {
        i = paramXmlPullParser.next();
        if (i != 1) {
          break label1104;
        }
      }
      int j = 0;
      int k = 0;
      paramMenu = null;
      int m = i;
      while (j == 0) {
        if (m != 1)
        {
          Object localObject;
          if (m != 2)
          {
            if (m == 3)
            {
              localObject = paramXmlPullParser.getName();
              if ((k != 0) && (((String)localObject).equals(paramMenu)))
              {
                paramMenu = null;
                i = 0;
                break label1077;
              }
              if (((String)localObject).equals("group"))
              {
                b = 0;
                c = 0;
                d = 0;
                e = 0;
                f = true;
                g = true;
              }
              else if (((String)localObject).equals("item"))
              {
                if (!h)
                {
                  localObject = A;
                  if ((localObject != null) && (b.hasSubMenu()))
                  {
                    localb.a();
                  }
                  else
                  {
                    h = true;
                    localb.a(a.add(b, i, j, k));
                  }
                }
              }
              else if (((String)localObject).equals("menu"))
              {
                j = 1;
                i = k;
                break label1077;
              }
            }
          }
          else if (k == 0)
          {
            localObject = paramXmlPullParser.getName();
            if (((String)localObject).equals("group"))
            {
              localObject = F.c.obtainStyledAttributes(paramAttributeSet, R.styleable.MenuGroup);
              b = ((TypedArray)localObject).getResourceId(R.styleable.MenuGroup_android_id, 0);
              c = ((TypedArray)localObject).getInt(R.styleable.MenuGroup_android_menuCategory, 0);
              d = ((TypedArray)localObject).getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
              e = ((TypedArray)localObject).getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
              f = ((TypedArray)localObject).getBoolean(R.styleable.MenuGroup_android_visible, true);
              g = ((TypedArray)localObject).getBoolean(R.styleable.MenuGroup_android_enabled, true);
              ((TypedArray)localObject).recycle();
            }
            else
            {
              if (!((String)localObject).equals("item")) {
                break label1043;
              }
              localObject = x0.a(F.c, paramAttributeSet, R.styleable.MenuItem);
              i = ((x0)localObject).f(R.styleable.MenuItem_android_id, 0);
              j = (((x0)localObject).c(R.styleable.MenuItem_android_menuCategory, c) & 0xFFFF0000 | ((x0)localObject).c(R.styleable.MenuItem_android_orderInCategory, d) & 0xFFFF);
              k = ((x0)localObject).e(R.styleable.MenuItem_android_title);
              l = ((x0)localObject).e(R.styleable.MenuItem_android_titleCondensed);
              m = ((x0)localObject).f(R.styleable.MenuItem_android_icon, 0);
              String str = ((x0)localObject).d(R.styleable.MenuItem_android_alphabeticShortcut);
              if (str == null) {
                i = 0;
              } else {
                i = str.charAt(0);
              }
              n = ((char)i);
              o = ((x0)localObject).c(R.styleable.MenuItem_alphabeticModifiers, 4096);
              str = ((x0)localObject).d(R.styleable.MenuItem_android_numericShortcut);
              if (str == null) {
                i = 0;
              } else {
                i = str.charAt(0);
              }
              p = ((char)i);
              q = ((x0)localObject).c(R.styleable.MenuItem_numericModifiers, 4096);
              if (((x0)localObject).f(R.styleable.MenuItem_android_checkable)) {
                r = ((x0)localObject).a(R.styleable.MenuItem_android_checkable, false);
              } else {
                r = e;
              }
              s = ((x0)localObject).a(R.styleable.MenuItem_android_checked, false);
              t = ((x0)localObject).a(R.styleable.MenuItem_android_visible, f);
              u = ((x0)localObject).a(R.styleable.MenuItem_android_enabled, g);
              v = ((x0)localObject).c(R.styleable.MenuItem_showAsAction, -1);
              z = ((x0)localObject).d(R.styleable.MenuItem_android_onClick);
              w = ((x0)localObject).f(R.styleable.MenuItem_actionLayout, 0);
              x = ((x0)localObject).d(R.styleable.MenuItem_actionViewClass);
              str = ((x0)localObject).d(R.styleable.MenuItem_actionProviderClass);
              y = str;
              if (str != null) {
                i = 1;
              } else {
                i = 0;
              }
              if ((i != 0) && (w == 0) && (x == null))
              {
                A = ((b)localb.a(y, f, F.b));
              }
              else
              {
                if (i != 0) {
                  Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                A = null;
              }
              B = ((x0)localObject).e(R.styleable.MenuItem_contentDescription);
              C = ((x0)localObject).e(R.styleable.MenuItem_tooltipText);
              if (((x0)localObject).f(R.styleable.MenuItem_iconTintMode)) {
                E = e0.a(((x0)localObject).c(R.styleable.MenuItem_iconTintMode, -1), E);
              } else {
                E = null;
              }
              if (((x0)localObject).f(R.styleable.MenuItem_iconTint)) {
                D = ((x0)localObject).a(R.styleable.MenuItem_iconTint);
              } else {
                D = null;
              }
              b.recycle();
              h = false;
            }
          }
          i = k;
          break label1077;
          if (((String)localObject).equals("menu"))
          {
            a(paramXmlPullParser, paramAttributeSet, localb.a());
            i = k;
          }
          else
          {
            i = 1;
            paramMenu = (Menu)localObject;
          }
          m = paramXmlPullParser.next();
          k = i;
        }
        else
        {
          throw new RuntimeException("Unexpected end of document");
        }
      }
      return;
    }
  }
  
  /* Error */
  public void inflate(int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 395
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: aload_2
    //   10: invokespecial 397	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 4
    //   19: aconst_null
    //   20: astore 5
    //   22: aload_0
    //   23: getfield 36	d/b/d/f:c	Landroid/content/Context;
    //   26: invokevirtual 401	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   29: iload_1
    //   30: invokevirtual 407	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   33: astore 6
    //   35: aload 6
    //   37: astore 5
    //   39: aload 6
    //   41: astore_3
    //   42: aload 6
    //   44: astore 4
    //   46: aload_0
    //   47: aload 6
    //   49: aload 6
    //   51: invokestatic 413	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   54: aload_2
    //   55: invokevirtual 385	d/b/d/f:a	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   58: aload 6
    //   60: invokeinterface 418 1 0
    //   65: return
    //   66: astore_2
    //   67: goto +56 -> 123
    //   70: astore 4
    //   72: aload_3
    //   73: astore 5
    //   75: new 420	android/view/InflateException
    //   78: astore_2
    //   79: aload_3
    //   80: astore 5
    //   82: aload_2
    //   83: ldc_w 422
    //   86: aload 4
    //   88: invokespecial 425	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: aload_3
    //   92: astore 5
    //   94: aload_2
    //   95: athrow
    //   96: astore_2
    //   97: aload 4
    //   99: astore 5
    //   101: new 420	android/view/InflateException
    //   104: astore_3
    //   105: aload 4
    //   107: astore 5
    //   109: aload_3
    //   110: ldc_w 422
    //   113: aload_2
    //   114: invokespecial 425	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   117: aload 4
    //   119: astore 5
    //   121: aload_3
    //   122: athrow
    //   123: aload 5
    //   125: ifnull +10 -> 135
    //   128: aload 5
    //   130: invokeinterface 418 1 0
    //   135: aload_2
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	f
    //   0	137	1	paramInt	int
    //   0	137	2	paramMenu	Menu
    //   15	107	3	localObject1	Object
    //   17	28	4	localObject2	Object
    //   70	48	4	localIOException	java.io.IOException
    //   20	109	5	localObject3	Object
    //   33	26	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   22	35	66	finally
    //   46	58	66	finally
    //   75	79	66	finally
    //   82	91	66	finally
    //   94	96	66	finally
    //   101	105	66	finally
    //   109	117	66	finally
    //   121	123	66	finally
    //   22	35	70	java/io/IOException
    //   46	58	70	java/io/IOException
    //   22	35	96	org/xmlpull/v1/XmlPullParserException
    //   46	58	96	org/xmlpull/v1/XmlPullParserException
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */