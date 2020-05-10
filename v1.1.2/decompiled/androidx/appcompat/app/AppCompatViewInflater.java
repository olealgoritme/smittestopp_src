package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.styleable;
import d.b.d.c;
import d.b.e.d;
import d.b.e.f;
import d.b.e.g;
import d.b.e.h;
import d.b.e.k;
import d.b.e.l;
import d.b.e.o;
import d.b.e.r;
import d.b.e.r0;
import d.b.e.s;
import d.b.e.t;
import d.b.e.w;
import d.b.e.y;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class AppCompatViewInflater
{
  public static final String LOG_TAG = "AppCompatViewInflater";
  public static final String[] sClassPrefixList = { "android.widget.", "android.view.", "android.webkit." };
  public static final Map<String, Constructor<? extends View>> sConstructorMap = new d.f.a();
  public static final Class<?>[] sConstructorSignature = { Context.class, AttributeSet.class };
  public static final int[] sOnClickAttrs = { 16843375 };
  public final Object[] mConstructorArgs = new Object[2];
  
  private void checkOnClickListener(View paramView, AttributeSet paramAttributeSet)
  {
    Object localObject = paramView.getContext();
    if (((localObject instanceof ContextWrapper)) && (d.i.i.n.q(paramView)))
    {
      paramAttributeSet = ((Context)localObject).obtainStyledAttributes(paramAttributeSet, sOnClickAttrs);
      localObject = paramAttributeSet.getString(0);
      if (localObject != null) {
        paramView.setOnClickListener(new a(paramView, (String)localObject));
      }
      paramAttributeSet.recycle();
    }
  }
  
  private View createViewByPrefix(Context paramContext, String paramString1, String paramString2)
  {
    Constructor localConstructor = (Constructor)sConstructorMap.get(paramString1);
    Object localObject = localConstructor;
    if (localConstructor == null) {}
    try
    {
      localObject = paramContext.getClassLoader();
      if (paramString2 != null)
      {
        paramContext = new java/lang/StringBuilder;
        paramContext.<init>();
        paramContext.append(paramString2);
        paramContext.append(paramString1);
        paramContext = paramContext.toString();
      }
      else
      {
        paramContext = paramString1;
      }
      localObject = ((ClassLoader)localObject).loadClass(paramContext).asSubclass(View.class).getConstructor(sConstructorSignature);
      sConstructorMap.put(paramString1, localObject);
      ((Constructor)localObject).setAccessible(true);
      paramContext = (View)((Constructor)localObject).newInstance(mConstructorArgs);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  /* Error */
  private View createViewFromTag(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 4
    //   3: aload_2
    //   4: ldc -106
    //   6: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +14 -> 23
    //   12: aload_3
    //   13: aconst_null
    //   14: ldc -100
    //   16: invokeinterface 160 3 0
    //   21: astore 4
    //   23: aload_0
    //   24: getfield 57	androidx/appcompat/app/AppCompatViewInflater:mConstructorArgs	[Ljava/lang/Object;
    //   27: iconst_0
    //   28: aload_1
    //   29: aastore
    //   30: aload_0
    //   31: getfield 57	androidx/appcompat/app/AppCompatViewInflater:mConstructorArgs	[Ljava/lang/Object;
    //   34: iconst_1
    //   35: aload_3
    //   36: aastore
    //   37: iconst_m1
    //   38: aload 4
    //   40: bipush 46
    //   42: invokevirtual 164	java/lang/String:indexOf	(I)I
    //   45: if_icmpne +69 -> 114
    //   48: iconst_0
    //   49: istore 5
    //   51: iload 5
    //   53: getstatic 46	androidx/appcompat/app/AppCompatViewInflater:sClassPrefixList	[Ljava/lang/String;
    //   56: arraylength
    //   57: if_icmpge +42 -> 99
    //   60: aload_0
    //   61: aload_1
    //   62: aload 4
    //   64: getstatic 46	androidx/appcompat/app/AppCompatViewInflater:sClassPrefixList	[Ljava/lang/String;
    //   67: iload 5
    //   69: aaload
    //   70: invokespecial 166	androidx/appcompat/app/AppCompatViewInflater:createViewByPrefix	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/view/View;
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull +18 -> 93
    //   78: aload_0
    //   79: getfield 57	androidx/appcompat/app/AppCompatViewInflater:mConstructorArgs	[Ljava/lang/Object;
    //   82: astore_1
    //   83: aload_1
    //   84: iconst_0
    //   85: aconst_null
    //   86: aastore
    //   87: aload_1
    //   88: iconst_1
    //   89: aconst_null
    //   90: aastore
    //   91: aload_2
    //   92: areturn
    //   93: iinc 5 1
    //   96: goto -45 -> 51
    //   99: aload_0
    //   100: getfield 57	androidx/appcompat/app/AppCompatViewInflater:mConstructorArgs	[Ljava/lang/Object;
    //   103: astore_1
    //   104: aload_1
    //   105: iconst_0
    //   106: aconst_null
    //   107: aastore
    //   108: aload_1
    //   109: iconst_1
    //   110: aconst_null
    //   111: aastore
    //   112: aconst_null
    //   113: areturn
    //   114: aload_0
    //   115: aload_1
    //   116: aload 4
    //   118: aconst_null
    //   119: invokespecial 166	androidx/appcompat/app/AppCompatViewInflater:createViewByPrefix	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/view/View;
    //   122: astore_1
    //   123: aload_0
    //   124: getfield 57	androidx/appcompat/app/AppCompatViewInflater:mConstructorArgs	[Ljava/lang/Object;
    //   127: astore_2
    //   128: aload_2
    //   129: iconst_0
    //   130: aconst_null
    //   131: aastore
    //   132: aload_2
    //   133: iconst_1
    //   134: aconst_null
    //   135: aastore
    //   136: aload_1
    //   137: areturn
    //   138: astore_1
    //   139: aload_0
    //   140: getfield 57	androidx/appcompat/app/AppCompatViewInflater:mConstructorArgs	[Ljava/lang/Object;
    //   143: astore_2
    //   144: aload_2
    //   145: iconst_0
    //   146: aconst_null
    //   147: aastore
    //   148: aload_2
    //   149: iconst_1
    //   150: aconst_null
    //   151: aastore
    //   152: aload_1
    //   153: athrow
    //   154: astore_1
    //   155: aload_0
    //   156: getfield 57	androidx/appcompat/app/AppCompatViewInflater:mConstructorArgs	[Ljava/lang/Object;
    //   159: astore_1
    //   160: aload_1
    //   161: iconst_0
    //   162: aconst_null
    //   163: aastore
    //   164: aload_1
    //   165: iconst_1
    //   166: aconst_null
    //   167: aastore
    //   168: aconst_null
    //   169: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	AppCompatViewInflater
    //   0	170	1	paramContext	Context
    //   0	170	2	paramString	String
    //   0	170	3	paramAttributeSet	AttributeSet
    //   1	116	4	str	String
    //   49	45	5	i	int
    // Exception table:
    //   from	to	target	type
    //   23	48	138	finally
    //   51	74	138	finally
    //   114	123	138	finally
    //   23	48	154	java/lang/Exception
    //   51	74	154	java/lang/Exception
    //   114	123	154	java/lang/Exception
  }
  
  public static Context themifyContext(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.View, 0, 0);
    int i;
    if (paramBoolean1) {
      i = paramAttributeSet.getResourceId(R.styleable.View_android_theme, 0);
    } else {
      i = 0;
    }
    int j = i;
    if (paramBoolean2)
    {
      j = i;
      if (i == 0)
      {
        i = paramAttributeSet.getResourceId(R.styleable.View_theme, 0);
        j = i;
        if (i != 0)
        {
          Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
          j = i;
        }
      }
    }
    paramAttributeSet.recycle();
    paramAttributeSet = paramContext;
    if (j != 0) {
      if ((paramContext instanceof c))
      {
        paramAttributeSet = paramContext;
        if (a == j) {}
      }
      else
      {
        paramAttributeSet = new c(paramContext, j);
      }
    }
    return paramAttributeSet;
  }
  
  private void verifyNotNull(View paramView, String paramString)
  {
    if (paramView != null) {
      return;
    }
    paramView = new StringBuilder();
    paramView.append(getClass().getName());
    paramView.append(" asked to inflate view for <");
    paramView.append(paramString);
    paramView.append(">, but returned null");
    throw new IllegalStateException(paramView.toString());
  }
  
  public d createAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new d(paramContext, paramAttributeSet);
  }
  
  public f createButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new f(paramContext, paramAttributeSet, R.attr.buttonStyle);
  }
  
  public g createCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new g(paramContext, paramAttributeSet);
  }
  
  public h createCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new h(paramContext, paramAttributeSet);
  }
  
  public k createEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new k(paramContext, paramAttributeSet);
  }
  
  public l createImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new l(paramContext, paramAttributeSet);
  }
  
  public d.b.e.n createImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new d.b.e.n(paramContext, paramAttributeSet, 0);
  }
  
  public o createMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new o(paramContext, paramAttributeSet);
  }
  
  public r createRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new r(paramContext, paramAttributeSet);
  }
  
  public s createRatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new s(paramContext, paramAttributeSet);
  }
  
  public t createSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new t(paramContext, paramAttributeSet);
  }
  
  public w createSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new w(paramContext, paramAttributeSet, R.attr.spinnerStyle);
  }
  
  public y createTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new y(paramContext, paramAttributeSet);
  }
  
  public View createView(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    return null;
  }
  
  public final View createView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((paramBoolean1) && (paramView != null)) {
      paramView = paramView.getContext();
    } else {
      paramView = paramContext;
    }
    Object localObject;
    if (!paramBoolean2)
    {
      localObject = paramView;
      if (!paramBoolean3) {}
    }
    else
    {
      localObject = themifyContext(paramView, paramAttributeSet, paramBoolean2, paramBoolean3);
    }
    if (paramBoolean4) {
      r0.a((Context)localObject);
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 2001146706: 
      if (paramString.equals("Button")) {
        i = 2;
      }
      break;
    case 1666676343: 
      if (paramString.equals("EditText")) {
        i = 3;
      }
      break;
    case 1601505219: 
      if (paramString.equals("CheckBox")) {
        i = 6;
      }
      break;
    case 1413872058: 
      if (paramString.equals("AutoCompleteTextView")) {
        i = 9;
      }
      break;
    case 1125864064: 
      if (paramString.equals("ImageView")) {
        i = 1;
      }
      break;
    case 776382189: 
      if (paramString.equals("RadioButton")) {
        i = 7;
      }
      break;
    case -339785223: 
      if (paramString.equals("Spinner")) {
        i = 4;
      }
      break;
    case -658531749: 
      if (paramString.equals("SeekBar")) {
        i = 12;
      }
      break;
    case -937446323: 
      if (paramString.equals("ImageButton")) {
        i = 5;
      }
      break;
    case -938935918: 
      if (paramString.equals("TextView")) {
        i = 0;
      }
      break;
    case -1346021293: 
      if (paramString.equals("MultiAutoCompleteTextView")) {
        i = 10;
      }
      break;
    case -1455429095: 
      if (paramString.equals("CheckedTextView")) {
        i = 8;
      }
      break;
    case -1946472170: 
      if (paramString.equals("RatingBar")) {
        i = 11;
      }
      break;
    }
    switch (i)
    {
    default: 
      paramView = createView((Context)localObject, paramString, paramAttributeSet);
      break;
    case 12: 
      paramView = createSeekBar((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 11: 
      paramView = createRatingBar((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 10: 
      paramView = createMultiAutoCompleteTextView((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 9: 
      paramView = createAutoCompleteTextView((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 8: 
      paramView = createCheckedTextView((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 7: 
      paramView = createRadioButton((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 6: 
      paramView = createCheckBox((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 5: 
      paramView = createImageButton((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 4: 
      paramView = createSpinner((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 3: 
      paramView = createEditText((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 2: 
      paramView = createButton((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 1: 
      paramView = createImageView((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 0: 
      paramView = createTextView((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
    }
    View localView = paramView;
    if (paramView == null)
    {
      localView = paramView;
      if (paramContext != localObject) {
        localView = createViewFromTag((Context)localObject, paramString, paramAttributeSet);
      }
    }
    if (localView != null) {
      checkOnClickListener(localView, paramAttributeSet);
    }
    return localView;
  }
  
  public static class a
    implements View.OnClickListener
  {
    public Context A;
    public final View x;
    public final String y;
    public Method z;
    
    public a(View paramView, String paramString)
    {
      x = paramView;
      y = paramString;
    }
    
    public void onClick(View paramView)
    {
      if (z == null)
      {
        Object localObject = x.getContext();
        while (localObject != null) {
          try
          {
            if (!((Context)localObject).isRestricted())
            {
              Method localMethod = localObject.getClass().getMethod(y, new Class[] { View.class });
              if (localMethod != null)
              {
                z = localMethod;
                A = ((Context)localObject);
              }
            }
          }
          catch (NoSuchMethodException localNoSuchMethodException)
          {
            if ((localObject instanceof ContextWrapper)) {
              localObject = ((ContextWrapper)localObject).getBaseContext();
            } else {
              localObject = null;
            }
          }
        }
        int i = x.getId();
        if (i == -1)
        {
          paramView = "";
        }
        else
        {
          paramView = e.a.a.a.a.a(" with id '");
          paramView.append(x.getContext().getResources().getResourceEntryName(i));
          paramView.append("'");
          paramView = paramView.toString();
        }
        localObject = e.a.a.a.a.a("Could not find method ");
        ((StringBuilder)localObject).append(y);
        ((StringBuilder)localObject).append("(View) in a parent or ancestor Context for android:onClick ");
        ((StringBuilder)localObject).append("attribute defined on view ");
        ((StringBuilder)localObject).append(x.getClass());
        ((StringBuilder)localObject).append(paramView);
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      try
      {
        z.invoke(A, new Object[] { paramView });
        return;
      }
      catch (InvocationTargetException paramView)
      {
        throw new IllegalStateException("Could not execute method for android:onClick", paramView);
      }
      catch (IllegalAccessException paramView)
      {
        throw new IllegalStateException("Could not execute non-public method for android:onClick", paramView);
      }
    }
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.app.AppCompatViewInflater
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */