package d.b.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import d.b.b.a.a;

public class w
  extends Spinner
{
  public static final int[] F = { 16843505 };
  public SpinnerAdapter A;
  public final boolean B;
  public w.f C;
  public int D;
  public final Rect E;
  public final e x;
  public final Context y;
  public h0 z;
  
  /* Error */
  public w(Context paramContext, android.util.AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 59	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 61	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 63	android/graphics/Rect:<init>	()V
    //   15: putfield 65	d/b/e/w:E	Landroid/graphics/Rect;
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic 70	androidx/appcompat/R$styleable:Spinner	[I
    //   23: iload_3
    //   24: iconst_0
    //   25: invokevirtual 76	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   28: astore 4
    //   30: aload_0
    //   31: new 78	d/b/e/e
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 81	d/b/e/e:<init>	(Landroid/view/View;)V
    //   39: putfield 83	d/b/e/w:x	Ld/b/e/e;
    //   42: aload 4
    //   44: getstatic 86	androidx/appcompat/R$styleable:Spinner_popupTheme	I
    //   47: iconst_0
    //   48: invokevirtual 92	android/content/res/TypedArray:getResourceId	(II)I
    //   51: istore 5
    //   53: iload 5
    //   55: ifeq +20 -> 75
    //   58: aload_0
    //   59: new 94	d/b/d/c
    //   62: dup
    //   63: aload_1
    //   64: iload 5
    //   66: invokespecial 97	d/b/d/c:<init>	(Landroid/content/Context;I)V
    //   69: putfield 99	d/b/e/w:y	Landroid/content/Context;
    //   72: goto +8 -> 80
    //   75: aload_0
    //   76: aload_1
    //   77: putfield 99	d/b/e/w:y	Landroid/content/Context;
    //   80: aconst_null
    //   81: astore 6
    //   83: iconst_m1
    //   84: istore 7
    //   86: aload_1
    //   87: aload_2
    //   88: getstatic 52	d/b/e/w:F	[I
    //   91: iload_3
    //   92: iconst_0
    //   93: invokevirtual 76	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   96: astore 8
    //   98: aload 8
    //   100: astore 6
    //   102: iload 7
    //   104: istore 5
    //   106: aload 8
    //   108: astore 9
    //   110: aload 8
    //   112: iconst_0
    //   113: invokevirtual 103	android/content/res/TypedArray:hasValue	(I)Z
    //   116: ifeq +78 -> 194
    //   119: aload 8
    //   121: astore 6
    //   123: aload 8
    //   125: iconst_0
    //   126: iconst_0
    //   127: invokevirtual 106	android/content/res/TypedArray:getInt	(II)I
    //   130: istore 5
    //   132: aload 8
    //   134: astore 9
    //   136: goto +58 -> 194
    //   139: astore_2
    //   140: aload 6
    //   142: astore_1
    //   143: goto +288 -> 431
    //   146: astore 9
    //   148: goto +15 -> 163
    //   151: astore_2
    //   152: aload 6
    //   154: astore_1
    //   155: goto +276 -> 431
    //   158: astore 9
    //   160: aconst_null
    //   161: astore 8
    //   163: aload 8
    //   165: astore 6
    //   167: ldc 108
    //   169: ldc 110
    //   171: aload 9
    //   173: invokestatic 116	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   176: pop
    //   177: iload 7
    //   179: istore 5
    //   181: aload 8
    //   183: ifnull +16 -> 199
    //   186: aload 8
    //   188: astore 9
    //   190: iload 7
    //   192: istore 5
    //   194: aload 9
    //   196: invokevirtual 119	android/content/res/TypedArray:recycle	()V
    //   199: iload 5
    //   201: ifeq +122 -> 323
    //   204: iload 5
    //   206: iconst_1
    //   207: if_icmpeq +6 -> 213
    //   210: goto +142 -> 352
    //   213: new 14	d/b/e/w$d
    //   216: dup
    //   217: aload_0
    //   218: aload_0
    //   219: getfield 99	d/b/e/w:y	Landroid/content/Context;
    //   222: aload_2
    //   223: iload_3
    //   224: invokespecial 122	d/b/e/w$d:<init>	(Ld/b/e/w;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   227: astore 9
    //   229: aload_0
    //   230: getfield 99	d/b/e/w:y	Landroid/content/Context;
    //   233: aload_2
    //   234: getstatic 70	androidx/appcompat/R$styleable:Spinner	[I
    //   237: iload_3
    //   238: iconst_0
    //   239: invokestatic 128	d/b/e/x0:a	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Ld/b/e/x0;
    //   242: astore 8
    //   244: aload_0
    //   245: aload 8
    //   247: getstatic 131	androidx/appcompat/R$styleable:Spinner_android_dropDownWidth	I
    //   250: bipush -2
    //   252: invokevirtual 133	d/b/e/x0:e	(II)I
    //   255: putfield 135	d/b/e/w:D	I
    //   258: aload 8
    //   260: getstatic 138	androidx/appcompat/R$styleable:Spinner_android_popupBackground	I
    //   263: invokevirtual 141	d/b/e/x0:b	(I)Landroid/graphics/drawable/Drawable;
    //   266: astore 6
    //   268: aload 9
    //   270: getfield 147	d/b/e/k0:Y	Landroid/widget/PopupWindow;
    //   273: aload 6
    //   275: invokevirtual 153	android/widget/PopupWindow:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   278: aload 9
    //   280: aload 4
    //   282: getstatic 156	androidx/appcompat/R$styleable:Spinner_android_prompt	I
    //   285: invokevirtual 160	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   288: putfield 164	d/b/e/w$d:c0	Ljava/lang/CharSequence;
    //   291: aload 8
    //   293: getfield 167	d/b/e/x0:b	Landroid/content/res/TypedArray;
    //   296: invokevirtual 119	android/content/res/TypedArray:recycle	()V
    //   299: aload_0
    //   300: aload 9
    //   302: putfield 169	d/b/e/w:C	Ld/b/e/w$f;
    //   305: aload_0
    //   306: new 171	d/b/e/v
    //   309: dup
    //   310: aload_0
    //   311: aload_0
    //   312: aload 9
    //   314: invokespecial 174	d/b/e/v:<init>	(Ld/b/e/w;Landroid/view/View;Ld/b/e/w$d;)V
    //   317: putfield 176	d/b/e/w:z	Ld/b/e/h0;
    //   320: goto +32 -> 352
    //   323: new 8	d/b/e/w$b
    //   326: dup
    //   327: aload_0
    //   328: invokespecial 179	d/b/e/w$b:<init>	(Ld/b/e/w;)V
    //   331: astore 8
    //   333: aload_0
    //   334: aload 8
    //   336: putfield 169	d/b/e/w:C	Ld/b/e/w$f;
    //   339: aload 8
    //   341: aload 4
    //   343: getstatic 156	androidx/appcompat/R$styleable:Spinner_android_prompt	I
    //   346: invokevirtual 160	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   349: invokevirtual 182	d/b/e/w$b:a	(Ljava/lang/CharSequence;)V
    //   352: aload 4
    //   354: getstatic 185	androidx/appcompat/R$styleable:Spinner_android_entries	I
    //   357: invokevirtual 189	android/content/res/TypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   360: astore 8
    //   362: aload 8
    //   364: ifnull +28 -> 392
    //   367: new 191	android/widget/ArrayAdapter
    //   370: dup
    //   371: aload_1
    //   372: ldc -64
    //   374: aload 8
    //   376: invokespecial 195	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   379: astore_1
    //   380: aload_1
    //   381: getstatic 200	androidx/appcompat/R$layout:support_simple_spinner_dropdown_item	I
    //   384: invokevirtual 204	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   387: aload_0
    //   388: aload_1
    //   389: invokevirtual 208	d/b/e/w:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   392: aload 4
    //   394: invokevirtual 119	android/content/res/TypedArray:recycle	()V
    //   397: aload_0
    //   398: iconst_1
    //   399: putfield 210	d/b/e/w:B	Z
    //   402: aload_0
    //   403: getfield 212	d/b/e/w:A	Landroid/widget/SpinnerAdapter;
    //   406: astore_1
    //   407: aload_1
    //   408: ifnull +13 -> 421
    //   411: aload_0
    //   412: aload_1
    //   413: invokevirtual 208	d/b/e/w:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   416: aload_0
    //   417: aconst_null
    //   418: putfield 212	d/b/e/w:A	Landroid/widget/SpinnerAdapter;
    //   421: aload_0
    //   422: getfield 83	d/b/e/w:x	Ld/b/e/e;
    //   425: aload_2
    //   426: iload_3
    //   427: invokevirtual 215	d/b/e/e:a	(Landroid/util/AttributeSet;I)V
    //   430: return
    //   431: aload_1
    //   432: ifnull +7 -> 439
    //   435: aload_1
    //   436: invokevirtual 119	android/content/res/TypedArray:recycle	()V
    //   439: aload_2
    //   440: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	this	w
    //   0	441	1	paramContext	Context
    //   0	441	2	paramAttributeSet	android.util.AttributeSet
    //   0	441	3	paramInt	int
    //   28	365	4	localTypedArray	android.content.res.TypedArray
    //   51	157	5	i	int
    //   81	193	6	localObject1	Object
    //   84	107	7	j	int
    //   96	279	8	localObject2	Object
    //   108	27	9	localObject3	Object
    //   146	1	9	localException1	Exception
    //   158	14	9	localException2	Exception
    //   188	125	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   110	119	139	finally
    //   123	132	139	finally
    //   167	177	139	finally
    //   110	119	146	java/lang/Exception
    //   123	132	146	java/lang/Exception
    //   86	98	151	finally
    //   86	98	158	java/lang/Exception
  }
  
  public int a(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    int i = 0;
    if (paramSpinnerAdapter == null) {
      return 0;
    }
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int k = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int m = Math.max(0, getSelectedItemPosition());
    int n = Math.min(paramSpinnerAdapter.getCount(), m + 15);
    int i1 = Math.max(0, m - (15 - (n - m)));
    View localView = null;
    m = 0;
    while (i1 < n)
    {
      int i2 = paramSpinnerAdapter.getItemViewType(i1);
      int i3 = i;
      if (i2 != i)
      {
        localView = null;
        i3 = i2;
      }
      localView = paramSpinnerAdapter.getView(i1, localView, this);
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView.measure(j, k);
      m = Math.max(m, localView.getMeasuredWidth());
      i1++;
      i = i3;
    }
    i1 = m;
    if (paramDrawable != null)
    {
      paramDrawable.getPadding(E);
      paramSpinnerAdapter = E;
      i1 = m + (left + right);
    }
    return i1;
  }
  
  public void a()
  {
    C.a(getTextDirection(), getTextAlignment());
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    e locale = x;
    if (locale != null) {
      locale.a();
    }
  }
  
  public int getDropDownHorizontalOffset()
  {
    w.f localf = C;
    if (localf != null) {
      return localf.b();
    }
    return super.getDropDownHorizontalOffset();
  }
  
  public int getDropDownVerticalOffset()
  {
    w.f localf = C;
    if (localf != null) {
      return localf.d();
    }
    return super.getDropDownVerticalOffset();
  }
  
  public int getDropDownWidth()
  {
    if (C != null) {
      return D;
    }
    return super.getDropDownWidth();
  }
  
  public final w.f getInternalPopup()
  {
    return C;
  }
  
  public Drawable getPopupBackground()
  {
    w.f localf = C;
    if (localf != null) {
      return localf.e();
    }
    return super.getPopupBackground();
  }
  
  public Context getPopupContext()
  {
    return y;
  }
  
  public CharSequence getPrompt()
  {
    Object localObject = C;
    if (localObject != null) {
      localObject = ((w.f)localObject).f();
    } else {
      localObject = super.getPrompt();
    }
    return (CharSequence)localObject;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    Object localObject = x;
    if (localObject != null) {
      localObject = ((e)localObject).b();
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    Object localObject = x;
    if (localObject != null) {
      localObject = ((e)localObject).c();
    } else {
      localObject = null;
    }
    return (PorterDuff.Mode)localObject;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    w.f localf = C;
    if ((localf != null) && (localf.a())) {
      C.dismiss();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((C != null) && (View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (w.e)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (x)
    {
      paramParcelable = getViewTreeObserver();
      if (paramParcelable != null) {
        paramParcelable.addOnGlobalLayoutListener(new w.a(this));
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    w.e locale = new w.e(super.onSaveInstanceState());
    w.f localf = C;
    boolean bool;
    if ((localf != null) && (localf.a())) {
      bool = true;
    } else {
      bool = false;
    }
    x = bool;
    return locale;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    h0 localh0 = z;
    if ((localh0 != null) && (localh0.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    w.f localf = C;
    if (localf != null)
    {
      if (!localf.a()) {
        a();
      }
      return true;
    }
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!B)
    {
      A = paramSpinnerAdapter;
      return;
    }
    super.setAdapter(paramSpinnerAdapter);
    if (C != null)
    {
      Context localContext1 = y;
      Context localContext2 = localContext1;
      if (localContext1 == null) {
        localContext2 = getContext();
      }
      C.a(new w.c(paramSpinnerAdapter, localContext2.getTheme()));
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    paramDrawable = x;
    if (paramDrawable != null) {
      paramDrawable.d();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    e locale = x;
    if (locale != null) {
      locale.a(paramInt);
    }
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    w.f localf = C;
    if (localf != null)
    {
      localf.c(paramInt);
      C.a(paramInt);
    }
    else
    {
      super.setDropDownHorizontalOffset(paramInt);
    }
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    w.f localf = C;
    if (localf != null) {
      localf.b(paramInt);
    } else {
      super.setDropDownVerticalOffset(paramInt);
    }
  }
  
  public void setDropDownWidth(int paramInt)
  {
    if (C != null) {
      D = paramInt;
    } else {
      super.setDropDownWidth(paramInt);
    }
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    w.f localf = C;
    if (localf != null) {
      localf.a(paramDrawable);
    } else {
      super.setPopupBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setPopupBackgroundResource(int paramInt)
  {
    setPopupBackgroundDrawable(a.c(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    w.f localf = C;
    if (localf != null) {
      localf.a(paramCharSequence);
    } else {
      super.setPrompt(paramCharSequence);
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    e locale = x;
    if (locale != null) {
      locale.b(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    e locale = x;
    if (locale != null) {
      locale.a(paramMode);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */