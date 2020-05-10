package d.b.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import d.b.b.a.a;
import d.i.i.n;

public class w
  extends Spinner
{
  public static final int[] F = { 16843505 };
  public SpinnerAdapter A;
  public final boolean B;
  public b C;
  public int D;
  public final Rect E;
  public final e x;
  public final Context y;
  public f0 z;
  
  /* Error */
  public w(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 46	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 48	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 50	android/graphics/Rect:<init>	()V
    //   15: putfield 52	d/b/e/w:E	Landroid/graphics/Rect;
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic 57	androidx/appcompat/R$styleable:Spinner	[I
    //   23: iload_3
    //   24: iconst_0
    //   25: invokevirtual 63	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   28: astore 4
    //   30: aload_0
    //   31: new 65	d/b/e/e
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 68	d/b/e/e:<init>	(Landroid/view/View;)V
    //   39: putfield 70	d/b/e/w:x	Ld/b/e/e;
    //   42: aconst_null
    //   43: astore 5
    //   45: aload 4
    //   47: getstatic 73	androidx/appcompat/R$styleable:Spinner_popupTheme	I
    //   50: iconst_0
    //   51: invokevirtual 79	android/content/res/TypedArray:getResourceId	(II)I
    //   54: istore 6
    //   56: iload 6
    //   58: ifeq +20 -> 78
    //   61: aload_0
    //   62: new 81	d/b/d/c
    //   65: dup
    //   66: aload_1
    //   67: iload 6
    //   69: invokespecial 84	d/b/d/c:<init>	(Landroid/content/Context;I)V
    //   72: putfield 86	d/b/e/w:y	Landroid/content/Context;
    //   75: goto +26 -> 101
    //   78: getstatic 91	android/os/Build$VERSION:SDK_INT	I
    //   81: bipush 23
    //   83: if_icmpge +9 -> 92
    //   86: aload_1
    //   87: astore 7
    //   89: goto +6 -> 95
    //   92: aconst_null
    //   93: astore 7
    //   95: aload_0
    //   96: aload 7
    //   98: putfield 86	d/b/e/w:y	Landroid/content/Context;
    //   101: aload_0
    //   102: getfield 86	d/b/e/w:y	Landroid/content/Context;
    //   105: ifnull +245 -> 350
    //   108: iconst_m1
    //   109: istore 8
    //   111: aload_1
    //   112: aload_2
    //   113: getstatic 39	d/b/e/w:F	[I
    //   116: iload_3
    //   117: iconst_0
    //   118: invokevirtual 63	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   121: astore 7
    //   123: aload 7
    //   125: astore 5
    //   127: iload 8
    //   129: istore 6
    //   131: aload 7
    //   133: astore 9
    //   135: aload 7
    //   137: iconst_0
    //   138: invokevirtual 95	android/content/res/TypedArray:hasValue	(I)Z
    //   141: ifeq +78 -> 219
    //   144: aload 7
    //   146: astore 5
    //   148: aload 7
    //   150: iconst_0
    //   151: iconst_0
    //   152: invokevirtual 98	android/content/res/TypedArray:getInt	(II)I
    //   155: istore 6
    //   157: aload 7
    //   159: astore 9
    //   161: goto +58 -> 219
    //   164: astore_1
    //   165: aload 5
    //   167: astore_2
    //   168: goto +172 -> 340
    //   171: astore 9
    //   173: goto +15 -> 188
    //   176: astore_1
    //   177: aload 5
    //   179: astore_2
    //   180: goto +160 -> 340
    //   183: astore 9
    //   185: aconst_null
    //   186: astore 7
    //   188: aload 7
    //   190: astore 5
    //   192: ldc 100
    //   194: ldc 102
    //   196: aload 9
    //   198: invokestatic 108	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   201: pop
    //   202: iload 8
    //   204: istore 6
    //   206: aload 7
    //   208: ifnull +16 -> 224
    //   211: aload 7
    //   213: astore 9
    //   215: iload 8
    //   217: istore 6
    //   219: aload 9
    //   221: invokevirtual 111	android/content/res/TypedArray:recycle	()V
    //   224: iload 6
    //   226: iconst_1
    //   227: if_icmpne +123 -> 350
    //   230: new 9	d/b/e/w$b
    //   233: dup
    //   234: aload_0
    //   235: aload_0
    //   236: getfield 86	d/b/e/w:y	Landroid/content/Context;
    //   239: aload_2
    //   240: iload_3
    //   241: invokespecial 114	d/b/e/w$b:<init>	(Ld/b/e/w;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   244: astore 7
    //   246: aload_0
    //   247: getfield 86	d/b/e/w:y	Landroid/content/Context;
    //   250: aload_2
    //   251: getstatic 57	androidx/appcompat/R$styleable:Spinner	[I
    //   254: iload_3
    //   255: iconst_0
    //   256: invokestatic 119	d/b/e/u0:a	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Ld/b/e/u0;
    //   259: astore 9
    //   261: aload_0
    //   262: aload 9
    //   264: getstatic 122	androidx/appcompat/R$styleable:Spinner_android_dropDownWidth	I
    //   267: bipush -2
    //   269: invokevirtual 125	d/b/e/u0:f	(II)I
    //   272: putfield 127	d/b/e/w:D	I
    //   275: aload 9
    //   277: getstatic 130	androidx/appcompat/R$styleable:Spinner_android_popupBackground	I
    //   280: invokevirtual 133	d/b/e/u0:b	(I)Landroid/graphics/drawable/Drawable;
    //   283: astore 5
    //   285: aload 7
    //   287: getfield 139	d/b/e/i0:Y	Landroid/widget/PopupWindow;
    //   290: aload 5
    //   292: invokevirtual 145	android/widget/PopupWindow:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   295: aload 7
    //   297: aload 4
    //   299: getstatic 148	androidx/appcompat/R$styleable:Spinner_android_prompt	I
    //   302: invokevirtual 152	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   305: putfield 156	d/b/e/w$b:c0	Ljava/lang/CharSequence;
    //   308: aload 9
    //   310: getfield 159	d/b/e/u0:b	Landroid/content/res/TypedArray;
    //   313: invokevirtual 111	android/content/res/TypedArray:recycle	()V
    //   316: aload_0
    //   317: aload 7
    //   319: putfield 161	d/b/e/w:C	Ld/b/e/w$b;
    //   322: aload_0
    //   323: new 163	d/b/e/v
    //   326: dup
    //   327: aload_0
    //   328: aload_0
    //   329: aload 7
    //   331: invokespecial 166	d/b/e/v:<init>	(Ld/b/e/w;Landroid/view/View;Ld/b/e/w$b;)V
    //   334: putfield 168	d/b/e/w:z	Ld/b/e/f0;
    //   337: goto +13 -> 350
    //   340: aload_2
    //   341: ifnull +7 -> 348
    //   344: aload_2
    //   345: invokevirtual 111	android/content/res/TypedArray:recycle	()V
    //   348: aload_1
    //   349: athrow
    //   350: aload 4
    //   352: getstatic 171	androidx/appcompat/R$styleable:Spinner_android_entries	I
    //   355: invokevirtual 175	android/content/res/TypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   358: astore 7
    //   360: aload 7
    //   362: ifnull +28 -> 390
    //   365: new 177	android/widget/ArrayAdapter
    //   368: dup
    //   369: aload_1
    //   370: ldc -78
    //   372: aload 7
    //   374: invokespecial 181	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   377: astore_1
    //   378: aload_1
    //   379: getstatic 186	androidx/appcompat/R$layout:support_simple_spinner_dropdown_item	I
    //   382: invokevirtual 190	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   385: aload_0
    //   386: aload_1
    //   387: invokevirtual 194	d/b/e/w:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   390: aload 4
    //   392: invokevirtual 111	android/content/res/TypedArray:recycle	()V
    //   395: aload_0
    //   396: iconst_1
    //   397: putfield 196	d/b/e/w:B	Z
    //   400: aload_0
    //   401: getfield 198	d/b/e/w:A	Landroid/widget/SpinnerAdapter;
    //   404: astore_1
    //   405: aload_1
    //   406: ifnull +13 -> 419
    //   409: aload_0
    //   410: aload_1
    //   411: invokevirtual 194	d/b/e/w:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   414: aload_0
    //   415: aconst_null
    //   416: putfield 198	d/b/e/w:A	Landroid/widget/SpinnerAdapter;
    //   419: aload_0
    //   420: getfield 70	d/b/e/w:x	Ld/b/e/e;
    //   423: aload_2
    //   424: iload_3
    //   425: invokevirtual 201	d/b/e/e:a	(Landroid/util/AttributeSet;I)V
    //   428: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	this	w
    //   0	429	1	paramContext	Context
    //   0	429	2	paramAttributeSet	AttributeSet
    //   0	429	3	paramInt	int
    //   28	363	4	localTypedArray	android.content.res.TypedArray
    //   43	248	5	localObject1	Object
    //   54	174	6	i	int
    //   87	286	7	localObject2	Object
    //   109	107	8	j	int
    //   133	27	9	localObject3	Object
    //   171	1	9	localException1	Exception
    //   183	14	9	localException2	Exception
    //   213	96	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   135	144	164	finally
    //   148	157	164	finally
    //   192	202	164	finally
    //   135	144	171	java/lang/Exception
    //   148	157	171	java/lang/Exception
    //   111	123	176	finally
    //   111	123	183	java/lang/Exception
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
    b localb = C;
    if (localb != null) {
      return C;
    }
    return super.getDropDownHorizontalOffset();
  }
  
  public int getDropDownVerticalOffset()
  {
    b localb = C;
    if (localb != null)
    {
      int i;
      if (!F) {
        i = 0;
      } else {
        i = D;
      }
      return i;
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
  
  public Drawable getPopupBackground()
  {
    b localb = C;
    if (localb != null) {
      return localb.c();
    }
    return super.getPopupBackground();
  }
  
  public Context getPopupContext()
  {
    if (C != null) {
      return y;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return super.getPopupContext();
    }
    return null;
  }
  
  public CharSequence getPrompt()
  {
    Object localObject = C;
    if (localObject != null) {
      localObject = c0;
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
    b localb = C;
    if ((localb != null) && (localb.e())) {
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
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    f0 localf0 = z;
    if ((localf0 != null) && (localf0.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    b localb = C;
    if (localb != null)
    {
      if (!localb.e()) {
        C.a();
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
      C.a(new a(paramSpinnerAdapter, localContext2.getTheme()));
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
    b localb = C;
    if (localb != null) {
      C = paramInt;
    } else {
      super.setDropDownHorizontalOffset(paramInt);
    }
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    b localb = C;
    if (localb != null)
    {
      D = paramInt;
      F = true;
    }
    else
    {
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
    b localb = C;
    if (localb != null) {
      Y.setBackgroundDrawable(paramDrawable);
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
    b localb = C;
    if (localb != null) {
      c0 = paramCharSequence;
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
  
  public static class a
    implements ListAdapter, SpinnerAdapter
  {
    public SpinnerAdapter x;
    public ListAdapter y;
    
    public a(SpinnerAdapter paramSpinnerAdapter, Resources.Theme paramTheme)
    {
      x = paramSpinnerAdapter;
      if ((paramSpinnerAdapter instanceof ListAdapter)) {
        y = ((ListAdapter)paramSpinnerAdapter);
      }
      if (paramTheme != null) {
        if ((Build.VERSION.SDK_INT >= 23) && ((paramSpinnerAdapter instanceof ThemedSpinnerAdapter)))
        {
          paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
          if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
            paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
          }
        }
        else if ((paramSpinnerAdapter instanceof q0))
        {
          paramSpinnerAdapter = (q0)paramSpinnerAdapter;
          if (paramSpinnerAdapter.getDropDownViewTheme() == null) {
            paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
          }
        }
      }
    }
    
    public boolean areAllItemsEnabled()
    {
      ListAdapter localListAdapter = y;
      if (localListAdapter != null) {
        return localListAdapter.areAllItemsEnabled();
      }
      return true;
    }
    
    public int getCount()
    {
      SpinnerAdapter localSpinnerAdapter = x;
      int i;
      if (localSpinnerAdapter == null) {
        i = 0;
      } else {
        i = localSpinnerAdapter.getCount();
      }
      return i;
    }
    
    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      SpinnerAdapter localSpinnerAdapter = x;
      if (localSpinnerAdapter == null) {
        paramView = null;
      } else {
        paramView = localSpinnerAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
      }
      return paramView;
    }
    
    public Object getItem(int paramInt)
    {
      Object localObject = x;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((SpinnerAdapter)localObject).getItem(paramInt);
      }
      return localObject;
    }
    
    public long getItemId(int paramInt)
    {
      SpinnerAdapter localSpinnerAdapter = x;
      long l;
      if (localSpinnerAdapter == null) {
        l = -1L;
      } else {
        l = localSpinnerAdapter.getItemId(paramInt);
      }
      return l;
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      SpinnerAdapter localSpinnerAdapter = x;
      if (localSpinnerAdapter == null) {
        paramView = null;
      } else {
        paramView = localSpinnerAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
      }
      return paramView;
    }
    
    public int getViewTypeCount()
    {
      return 1;
    }
    
    public boolean hasStableIds()
    {
      SpinnerAdapter localSpinnerAdapter = x;
      boolean bool;
      if ((localSpinnerAdapter != null) && (localSpinnerAdapter.hasStableIds())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean isEmpty()
    {
      boolean bool;
      if (getCount() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean isEnabled(int paramInt)
    {
      ListAdapter localListAdapter = y;
      if (localListAdapter != null) {
        return localListAdapter.isEnabled(paramInt);
      }
      return true;
    }
    
    public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      SpinnerAdapter localSpinnerAdapter = x;
      if (localSpinnerAdapter != null) {
        localSpinnerAdapter.registerDataSetObserver(paramDataSetObserver);
      }
    }
    
    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      SpinnerAdapter localSpinnerAdapter = x;
      if (localSpinnerAdapter != null) {
        localSpinnerAdapter.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
  
  public class b
    extends i0
  {
    public CharSequence c0;
    public ListAdapter d0;
    public final Rect e0 = new Rect();
    
    public b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt, 0);
      O = w.this;
      a(true);
      M = 0;
      P = new a(w.this);
    }
    
    public void a()
    {
      boolean bool = e();
      d();
      Y.setInputMethodMode(2);
      super.a();
      z.setChoiceMode(1);
      int i = getSelectedItemPosition();
      final Object localObject = z;
      if ((e()) && (localObject != null))
      {
        ((d0)localObject).setListSelectionHidden(false);
        ((ListView)localObject).setSelection(i);
        if (((ListView)localObject).getChoiceMode() != 0) {
          ((ListView)localObject).setItemChecked(i, true);
        }
      }
      if (bool) {
        return;
      }
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver != null)
      {
        localObject = new b();
        localViewTreeObserver.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)localObject);
        localObject = new c((ViewTreeObserver.OnGlobalLayoutListener)localObject);
        Y.setOnDismissListener((PopupWindow.OnDismissListener)localObject);
      }
    }
    
    public void a(ListAdapter paramListAdapter)
    {
      super.a(paramListAdapter);
      d0 = paramListAdapter;
    }
    
    public void d()
    {
      Object localObject = c();
      int i = 0;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(E);
        if (b1.a(w.this)) {
          i = E.right;
        } else {
          i = -E.left;
        }
      }
      else
      {
        localObject = E;
        right = 0;
        left = 0;
      }
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = getWidth();
      localObject = w.this;
      int n = D;
      if (n == -2)
      {
        int i1 = ((w)localObject).a((SpinnerAdapter)d0, c());
        n = getContext().getResources().getDisplayMetrics().widthPixels;
        localObject = E;
        int i2 = n - left - right;
        n = i1;
        if (i1 > i2) {
          n = i2;
        }
        a(Math.max(n, m - j - k));
      }
      else if (n == -1)
      {
        a(m - j - k);
      }
      else
      {
        a(n);
      }
      if (b1.a(w.this)) {
        i = m - k - B + i;
      } else {
        i += j;
      }
      C = i;
    }
    
    public class a
      implements AdapterView.OnItemClickListener
    {
      public a(w paramw) {}
      
      public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
      {
        setSelection(paramInt);
        if (getOnItemClickListener() != null)
        {
          paramAdapterView = w.b.this;
          f0.performItemClick(paramView, paramInt, d0.getItemId(paramInt));
        }
        dismiss();
      }
    }
    
    public class b
      implements ViewTreeObserver.OnGlobalLayoutListener
    {
      public b() {}
      
      public void onGlobalLayout()
      {
        w.b localb = w.b.this;
        w localw = f0;
        if (localb != null)
        {
          int i;
          if ((n.s(localw)) && (localw.getGlobalVisibleRect(e0))) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0)
          {
            dismiss();
          }
          else
          {
            d();
            w.b.a(w.b.this);
          }
          return;
        }
        throw null;
      }
    }
    
    public class c
      implements PopupWindow.OnDismissListener
    {
      public c(ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener) {}
      
      public void onDismiss()
      {
        ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
        if (localViewTreeObserver != null) {
          localViewTreeObserver.removeGlobalOnLayoutListener(localObject);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */