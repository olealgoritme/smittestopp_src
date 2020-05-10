package d.b.d;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionProvider;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R.styleable;
import d.b.d.i.d;
import d.b.d.i.j;
import d.b.d.i.k;
import d.b.d.i.k.a;
import d.b.e.c0;
import e.a.a.a.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

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
    b localb = new b(paramMenu);
    int i = paramXmlPullParser.getEventType();
    label1040:
    label1074:
    label1101:
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
          break label1101;
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
                break label1074;
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
                break label1074;
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
                break label1040;
              }
              localObject = F.c.obtainStyledAttributes(paramAttributeSet, R.styleable.MenuItem);
              i = ((TypedArray)localObject).getResourceId(R.styleable.MenuItem_android_id, 0);
              j = (((TypedArray)localObject).getInt(R.styleable.MenuItem_android_menuCategory, c) & 0xFFFF0000 | ((TypedArray)localObject).getInt(R.styleable.MenuItem_android_orderInCategory, d) & 0xFFFF);
              k = ((TypedArray)localObject).getText(R.styleable.MenuItem_android_title);
              l = ((TypedArray)localObject).getText(R.styleable.MenuItem_android_titleCondensed);
              m = ((TypedArray)localObject).getResourceId(R.styleable.MenuItem_android_icon, 0);
              String str = ((TypedArray)localObject).getString(R.styleable.MenuItem_android_alphabeticShortcut);
              if (str == null) {
                i = 0;
              } else {
                i = str.charAt(0);
              }
              n = ((char)i);
              o = ((TypedArray)localObject).getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
              str = ((TypedArray)localObject).getString(R.styleable.MenuItem_android_numericShortcut);
              if (str == null) {
                i = 0;
              } else {
                i = str.charAt(0);
              }
              p = ((char)i);
              q = ((TypedArray)localObject).getInt(R.styleable.MenuItem_numericModifiers, 4096);
              if (((TypedArray)localObject).hasValue(R.styleable.MenuItem_android_checkable)) {
                r = ((TypedArray)localObject).getBoolean(R.styleable.MenuItem_android_checkable, false);
              } else {
                r = e;
              }
              s = ((TypedArray)localObject).getBoolean(R.styleable.MenuItem_android_checked, false);
              t = ((TypedArray)localObject).getBoolean(R.styleable.MenuItem_android_visible, f);
              u = ((TypedArray)localObject).getBoolean(R.styleable.MenuItem_android_enabled, g);
              v = ((TypedArray)localObject).getInt(R.styleable.MenuItem_showAsAction, -1);
              z = ((TypedArray)localObject).getString(R.styleable.MenuItem_android_onClick);
              w = ((TypedArray)localObject).getResourceId(R.styleable.MenuItem_actionLayout, 0);
              x = ((TypedArray)localObject).getString(R.styleable.MenuItem_actionViewClass);
              str = ((TypedArray)localObject).getString(R.styleable.MenuItem_actionProviderClass);
              y = str;
              if (str != null) {
                i = 1;
              } else {
                i = 0;
              }
              if ((i != 0) && (w == 0) && (x == null))
              {
                A = ((d.i.i.b)localb.a(y, f, F.b));
              }
              else
              {
                if (i != 0) {
                  Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                A = null;
              }
              B = ((TypedArray)localObject).getText(R.styleable.MenuItem_contentDescription);
              C = ((TypedArray)localObject).getText(R.styleable.MenuItem_tooltipText);
              if (((TypedArray)localObject).hasValue(R.styleable.MenuItem_iconTintMode)) {
                E = c0.a(((TypedArray)localObject).getInt(R.styleable.MenuItem_iconTintMode, -1), E);
              } else {
                E = null;
              }
              if (((TypedArray)localObject).hasValue(R.styleable.MenuItem_iconTint)) {
                D = ((TypedArray)localObject).getColorStateList(R.styleable.MenuItem_iconTint);
              } else {
                D = null;
              }
              ((TypedArray)localObject).recycle();
              h = false;
            }
          }
          i = k;
          break label1074;
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
    //   1: instanceof 385
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: aload_2
    //   10: invokespecial 387	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 4
    //   19: aconst_null
    //   20: astore 5
    //   22: aload_0
    //   23: getfield 36	d/b/d/f:c	Landroid/content/Context;
    //   26: invokevirtual 391	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   29: iload_1
    //   30: invokevirtual 397	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
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
    //   51: invokestatic 403	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   54: aload_2
    //   55: invokevirtual 375	d/b/d/f:a	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   58: aload 6
    //   60: invokeinterface 408 1 0
    //   65: return
    //   66: astore_2
    //   67: goto +57 -> 124
    //   70: astore_2
    //   71: aload_3
    //   72: astore 5
    //   74: new 410	android/view/InflateException
    //   77: astore 4
    //   79: aload_3
    //   80: astore 5
    //   82: aload 4
    //   84: ldc_w 412
    //   87: aload_2
    //   88: invokespecial 415	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: aload_3
    //   92: astore 5
    //   94: aload 4
    //   96: athrow
    //   97: astore_2
    //   98: aload 4
    //   100: astore 5
    //   102: new 410	android/view/InflateException
    //   105: astore_3
    //   106: aload 4
    //   108: astore 5
    //   110: aload_3
    //   111: ldc_w 412
    //   114: aload_2
    //   115: invokespecial 415	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   118: aload 4
    //   120: astore 5
    //   122: aload_3
    //   123: athrow
    //   124: aload 5
    //   126: ifnull +10 -> 136
    //   129: aload 5
    //   131: invokeinterface 408 1 0
    //   136: aload_2
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	f
    //   0	138	1	paramInt	int
    //   0	138	2	paramMenu	Menu
    //   15	108	3	localObject1	Object
    //   17	102	4	localObject2	Object
    //   20	110	5	localObject3	Object
    //   33	26	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   22	35	66	finally
    //   46	58	66	finally
    //   74	79	66	finally
    //   82	91	66	finally
    //   94	97	66	finally
    //   102	106	66	finally
    //   110	118	66	finally
    //   122	124	66	finally
    //   22	35	70	java/io/IOException
    //   46	58	70	java/io/IOException
    //   22	35	97	org/xmlpull/v1/XmlPullParserException
    //   46	58	97	org/xmlpull/v1/XmlPullParserException
  }
  
  public static class a
    implements MenuItem.OnMenuItemClickListener
  {
    public static final Class<?>[] c = { MenuItem.class };
    public Object a;
    public Method b;
    
    public a(Object paramObject, String paramString)
    {
      a = paramObject;
      Class localClass = paramObject.getClass();
      try
      {
        b = localClass.getMethod(paramString, c);
        return;
      }
      catch (Exception paramObject)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Couldn't resolve menu item onClick handler ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" in class ");
        localStringBuilder.append(localClass.getName());
        paramString = new InflateException(localStringBuilder.toString());
        paramString.initCause((Throwable)paramObject);
        throw paramString;
      }
    }
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      try
      {
        if (b.getReturnType() == Boolean.TYPE) {
          return ((Boolean)b.invoke(a, new Object[] { paramMenuItem })).booleanValue();
        }
        b.invoke(a, new Object[] { paramMenuItem });
        return true;
      }
      catch (Exception paramMenuItem)
      {
        throw new RuntimeException(paramMenuItem);
      }
    }
  }
  
  public class b
  {
    public d.i.i.b A;
    public CharSequence B;
    public CharSequence C;
    public ColorStateList D = null;
    public PorterDuff.Mode E = null;
    public Menu a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public CharSequence k;
    public CharSequence l;
    public int m;
    public char n;
    public int o;
    public char p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public int w;
    public String x;
    public String y;
    public String z;
    
    public b(Menu paramMenu)
    {
      a = paramMenu;
      b = 0;
      c = 0;
      d = 0;
      e = 0;
      f = true;
      g = true;
    }
    
    public SubMenu a()
    {
      h = true;
      SubMenu localSubMenu = a.addSubMenu(b, i, j, k);
      a(localSubMenu.getItem());
      return localSubMenu;
    }
    
    public final <T> T a(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      try
      {
        paramArrayOfClass = c.getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass);
        paramArrayOfClass.setAccessible(true);
        paramArrayOfClass = paramArrayOfClass.newInstance(paramArrayOfObject);
        return paramArrayOfClass;
      }
      catch (Exception paramArrayOfObject)
      {
        paramArrayOfClass = new StringBuilder();
        paramArrayOfClass.append("Cannot instantiate class: ");
        paramArrayOfClass.append(paramString);
        Log.w("SupportMenuInflater", paramArrayOfClass.toString(), paramArrayOfObject);
      }
      return null;
    }
    
    public final void a(MenuItem paramMenuItem)
    {
      Object localObject1 = paramMenuItem.setChecked(s).setVisible(t).setEnabled(u);
      int i1 = r;
      int i2 = 0;
      if (i1 >= 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((MenuItem)localObject1).setCheckable(bool).setTitleCondensed(l).setIcon(m);
      i1 = v;
      if (i1 >= 0) {
        paramMenuItem.setShowAsAction(i1);
      }
      if (z != null) {
        if (!c.isRestricted())
        {
          localObject1 = f.this;
          if (d == null) {
            d = ((f)localObject1).a(c);
          }
          paramMenuItem.setOnMenuItemClickListener(new f.a(d, z));
        }
        else
        {
          throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        }
      }
      boolean bool = paramMenuItem instanceof j;
      if (bool) {
        localObject1 = (j)paramMenuItem;
      }
      if (r >= 2) {
        if (bool)
        {
          ((j)paramMenuItem).b(true);
        }
        else if ((paramMenuItem instanceof k))
        {
          localObject1 = (k)paramMenuItem;
          try
          {
            if (e == null) {
              e = ((d.i.d.a.b)a).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
            }
            e.invoke(a, new Object[] { Boolean.valueOf(true) });
          }
          catch (Exception localException)
          {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", localException);
          }
        }
      }
      Object localObject2 = x;
      if (localObject2 != null)
      {
        paramMenuItem.setActionView((View)a((String)localObject2, f.e, a));
        i2 = 1;
      }
      i1 = w;
      if (i1 > 0) {
        if (i2 == 0) {
          paramMenuItem.setActionView(i1);
        } else {
          Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        }
      }
      localObject2 = A;
      if (localObject2 != null) {
        if ((paramMenuItem instanceof d.i.d.a.b)) {
          ((d.i.d.a.b)paramMenuItem).a((d.i.i.b)localObject2);
        } else {
          Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        }
      }
      localObject2 = B;
      bool = paramMenuItem instanceof d.i.d.a.b;
      if (bool) {
        ((d.i.d.a.b)paramMenuItem).setContentDescription((CharSequence)localObject2);
      } else if (Build.VERSION.SDK_INT >= 26) {
        paramMenuItem.setContentDescription((CharSequence)localObject2);
      }
      localObject2 = C;
      if (bool) {
        ((d.i.d.a.b)paramMenuItem).setTooltipText((CharSequence)localObject2);
      } else if (Build.VERSION.SDK_INT >= 26) {
        paramMenuItem.setTooltipText((CharSequence)localObject2);
      }
      char c1 = n;
      i2 = o;
      if (bool) {
        ((d.i.d.a.b)paramMenuItem).setAlphabeticShortcut(c1, i2);
      } else if (Build.VERSION.SDK_INT >= 26) {
        paramMenuItem.setAlphabeticShortcut(c1, i2);
      }
      c1 = p;
      i2 = q;
      if (bool) {
        ((d.i.d.a.b)paramMenuItem).setNumericShortcut(c1, i2);
      } else if (Build.VERSION.SDK_INT >= 26) {
        paramMenuItem.setNumericShortcut(c1, i2);
      }
      localObject2 = E;
      if (localObject2 != null) {
        if (bool) {
          ((d.i.d.a.b)paramMenuItem).setIconTintMode((PorterDuff.Mode)localObject2);
        } else if (Build.VERSION.SDK_INT >= 26) {
          paramMenuItem.setIconTintMode((PorterDuff.Mode)localObject2);
        }
      }
      localObject2 = D;
      if (localObject2 != null) {
        if (bool) {
          ((d.i.d.a.b)paramMenuItem).setIconTintList((ColorStateList)localObject2);
        } else if (Build.VERSION.SDK_INT >= 26) {
          paramMenuItem.setIconTintList((ColorStateList)localObject2);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.d.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */