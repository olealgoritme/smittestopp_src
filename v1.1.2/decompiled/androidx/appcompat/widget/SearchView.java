package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.dimen;
import androidx.appcompat.R.id;
import androidx.appcompat.R.layout;
import androidx.appcompat.R.string;
import androidx.appcompat.R.styleable;
import d.b.a.s;
import d.b.d.b;
import d.b.e.b1;
import d.b.e.d;
import d.b.e.g0;
import d.b.e.o0;
import d.b.e.u0;
import d.i.i.n;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView
  extends g0
  implements b
{
  public static final k N0 = new k();
  public boolean A0;
  public int B0;
  public SearchableInfo C0;
  public Bundle D0;
  public final Runnable E0 = new b();
  public Runnable F0 = new c();
  public final WeakHashMap<String, Drawable.ConstantState> G0 = new WeakHashMap();
  public final View.OnClickListener H0 = new f();
  public View.OnKeyListener I0 = new g();
  public final TextView.OnEditorActionListener J0 = new h();
  public final AdapterView.OnItemClickListener K0 = new i();
  public final AdapterView.OnItemSelectedListener L0 = new j();
  public final SearchAutoComplete M;
  public TextWatcher M0 = new a();
  public final View N;
  public final View O;
  public final View P;
  public final ImageView Q;
  public final ImageView R;
  public final ImageView S;
  public final ImageView T;
  public final View U;
  public p V;
  public Rect W = new Rect();
  public Rect a0 = new Rect();
  public int[] b0 = new int[2];
  public int[] c0 = new int[2];
  public final ImageView d0;
  public final Drawable e0;
  public final int f0;
  public final int g0;
  public final Intent h0;
  public final Intent i0;
  public final CharSequence j0;
  public m k0;
  public l l0;
  public View.OnFocusChangeListener m0;
  public n n0;
  public View.OnClickListener o0;
  public boolean p0;
  public boolean q0;
  public d.j.a.a r0;
  public boolean s0;
  public CharSequence t0;
  public boolean u0;
  public boolean v0;
  public int w0;
  public boolean x0;
  public CharSequence y0;
  public CharSequence z0;
  
  public SearchView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.searchViewStyle);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new u0(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SearchView, paramInt, 0));
    LayoutInflater.from(paramContext).inflate(paramAttributeSet.g(R.styleable.SearchView_layout, R.layout.abc_search_view), this, true);
    paramContext = (SearchAutoComplete)findViewById(R.id.search_src_text);
    M = paramContext;
    paramContext.setSearchView(this);
    N = findViewById(R.id.search_edit_frame);
    O = findViewById(R.id.search_plate);
    P = findViewById(R.id.submit_area);
    Q = ((ImageView)findViewById(R.id.search_button));
    R = ((ImageView)findViewById(R.id.search_go_btn));
    S = ((ImageView)findViewById(R.id.search_close_btn));
    T = ((ImageView)findViewById(R.id.search_voice_btn));
    d0 = ((ImageView)findViewById(R.id.search_mag_icon));
    n.a(O, paramAttributeSet.b(R.styleable.SearchView_queryBackground));
    P.setBackground(paramAttributeSet.b(R.styleable.SearchView_submitBackground));
    Q.setImageDrawable(paramAttributeSet.b(R.styleable.SearchView_searchIcon));
    R.setImageDrawable(paramAttributeSet.b(R.styleable.SearchView_goIcon));
    S.setImageDrawable(paramAttributeSet.b(R.styleable.SearchView_closeIcon));
    T.setImageDrawable(paramAttributeSet.b(R.styleable.SearchView_voiceIcon));
    d0.setImageDrawable(paramAttributeSet.b(R.styleable.SearchView_searchIcon));
    e0 = paramAttributeSet.b(R.styleable.SearchView_searchHintIcon);
    s.a(Q, getResources().getString(R.string.abc_searchview_description_search));
    f0 = paramAttributeSet.g(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
    g0 = paramAttributeSet.g(R.styleable.SearchView_commitIcon, 0);
    Q.setOnClickListener(H0);
    S.setOnClickListener(H0);
    R.setOnClickListener(H0);
    T.setOnClickListener(H0);
    M.setOnClickListener(H0);
    M.addTextChangedListener(M0);
    M.setOnEditorActionListener(J0);
    M.setOnItemClickListener(K0);
    M.setOnItemSelectedListener(L0);
    M.setOnKeyListener(I0);
    M.setOnFocusChangeListener(new d());
    setIconifiedByDefault(paramAttributeSet.a(R.styleable.SearchView_iconifiedByDefault, true));
    paramInt = paramAttributeSet.c(R.styleable.SearchView_android_maxWidth, -1);
    if (paramInt != -1) {
      setMaxWidth(paramInt);
    }
    j0 = paramAttributeSet.d(R.styleable.SearchView_defaultQueryHint);
    t0 = paramAttributeSet.d(R.styleable.SearchView_queryHint);
    paramInt = paramAttributeSet.d(R.styleable.SearchView_android_imeOptions, -1);
    if (paramInt != -1) {
      setImeOptions(paramInt);
    }
    paramInt = paramAttributeSet.d(R.styleable.SearchView_android_inputType, -1);
    if (paramInt != -1) {
      setInputType(paramInt);
    }
    setFocusable(paramAttributeSet.a(R.styleable.SearchView_android_focusable, true));
    b.recycle();
    paramContext = new Intent("android.speech.action.WEB_SEARCH");
    h0 = paramContext;
    paramContext.addFlags(268435456);
    h0.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    paramContext = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    i0 = paramContext;
    paramContext.addFlags(268435456);
    paramContext = findViewById(M.getDropDownAnchor());
    U = paramContext;
    if (paramContext != null) {
      paramContext.addOnLayoutChangeListener(new e());
    }
    b(p0);
    j();
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool;
    if (getResourcesgetConfigurationorientation == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private int getPreferredHeight()
  {
    return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
  }
  
  private int getPreferredWidth()
  {
    return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
  }
  
  private void setQuery(CharSequence paramCharSequence)
  {
    M.setText(paramCharSequence);
    SearchAutoComplete localSearchAutoComplete = M;
    int i;
    if (TextUtils.isEmpty(paramCharSequence)) {
      i = 0;
    } else {
      i = paramCharSequence.length();
    }
    localSearchAutoComplete.setSelection(i);
  }
  
  public final Intent a(Intent paramIntent, SearchableInfo paramSearchableInfo)
  {
    ComponentName localComponentName = paramSearchableInfo.getSearchActivity();
    Object localObject1 = new Intent("android.intent.action.SEARCH");
    ((Intent)localObject1).setComponent(localComponentName);
    PendingIntent localPendingIntent = PendingIntent.getActivity(getContext(), 0, (Intent)localObject1, 1073741824);
    Bundle localBundle = new Bundle();
    localObject1 = D0;
    if (localObject1 != null) {
      localBundle.putParcelable("app_data", (Parcelable)localObject1);
    }
    Intent localIntent = new Intent(paramIntent);
    int i = 1;
    Object localObject2 = getResources();
    if (paramSearchableInfo.getVoiceLanguageModeId() != 0) {
      paramIntent = ((Resources)localObject2).getString(paramSearchableInfo.getVoiceLanguageModeId());
    } else {
      paramIntent = "free_form";
    }
    int j = paramSearchableInfo.getVoicePromptTextId();
    Object localObject3 = null;
    if (j != 0) {
      localObject1 = ((Resources)localObject2).getString(paramSearchableInfo.getVoicePromptTextId());
    } else {
      localObject1 = null;
    }
    if (paramSearchableInfo.getVoiceLanguageId() != 0) {
      localObject2 = ((Resources)localObject2).getString(paramSearchableInfo.getVoiceLanguageId());
    } else {
      localObject2 = null;
    }
    if (paramSearchableInfo.getVoiceMaxResults() != 0) {
      i = paramSearchableInfo.getVoiceMaxResults();
    }
    localIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", paramIntent);
    localIntent.putExtra("android.speech.extra.PROMPT", (String)localObject1);
    localIntent.putExtra("android.speech.extra.LANGUAGE", (String)localObject2);
    localIntent.putExtra("android.speech.extra.MAX_RESULTS", i);
    if (localComponentName == null) {
      paramIntent = (Intent)localObject3;
    } else {
      paramIntent = localComponentName.flattenToShortString();
    }
    localIntent.putExtra("calling_package", paramIntent);
    localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", localPendingIntent);
    localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", localBundle);
    return localIntent;
  }
  
  public final Intent a(String paramString1, Uri paramUri, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    paramString1 = new Intent(paramString1);
    paramString1.addFlags(268435456);
    if (paramUri != null) {
      paramString1.setData(paramUri);
    }
    paramString1.putExtra("user_query", z0);
    if (paramString3 != null) {
      paramString1.putExtra("query", paramString3);
    }
    if (paramString2 != null) {
      paramString1.putExtra("intent_extra_data_key", paramString2);
    }
    paramUri = D0;
    if (paramUri != null) {
      paramString1.putExtra("app_data", paramUri);
    }
    if (paramInt != 0)
    {
      paramString1.putExtra("action_key", paramInt);
      paramString1.putExtra("action_msg", paramString4);
    }
    paramString1.setComponent(C0.getSearchActivity());
    return paramString1;
  }
  
  public void a()
  {
    if (A0) {
      return;
    }
    A0 = true;
    int i = M.getImeOptions();
    B0 = i;
    M.setImeOptions(i | 0x2000000);
    M.setText("");
    setIconified(false);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = a("android.intent.action.SEARCH", null, null, paramString2, paramInt, paramString1);
    getContext().startActivity(paramString1);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    setQuery(paramCharSequence);
  }
  
  public final void a(boolean paramBoolean)
  {
    boolean bool = s0;
    int i = 0;
    if (bool)
    {
      if (((bool) || (x0)) && (!q0)) {
        j = 1;
      } else {
        j = 0;
      }
      if ((j != 0) && (hasFocus()))
      {
        j = i;
        if (paramBoolean) {
          break label74;
        }
        if (!x0)
        {
          j = i;
          break label74;
        }
      }
    }
    int j = 8;
    label74:
    R.setVisibility(j);
  }
  
  public final void b(boolean paramBoolean)
  {
    q0 = paramBoolean;
    int i = 0;
    int j;
    if (paramBoolean) {
      j = 0;
    } else {
      j = 8;
    }
    boolean bool = TextUtils.isEmpty(M.getText()) ^ true;
    Q.setVisibility(j);
    a(bool);
    View localView = N;
    if (paramBoolean) {
      j = 8;
    } else {
      j = 0;
    }
    localView.setVisibility(j);
    if (d0.getDrawable() != null)
    {
      j = i;
      if (!p0) {}
    }
    else
    {
      j = 8;
    }
    d0.setVisibility(j);
    h();
    c(bool ^ true);
    k();
  }
  
  public boolean b(int paramInt)
  {
    Object localObject1 = n0;
    if ((localObject1 != null) && (((n)localObject1).b(paramInt))) {
      return false;
    }
    Cursor localCursor = r0.z;
    if ((localCursor != null) && (localCursor.moveToPosition(paramInt)))
    {
      Object localObject3 = null;
      Object localObject5;
      Object localObject2;
      try
      {
        Object localObject4 = o0.a(localCursor, "suggest_intent_action");
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = C0.getSuggestIntentAction();
        }
        localObject4 = localObject1;
        if (localObject1 == null) {
          localObject4 = "android.intent.action.SEARCH";
        }
        localObject5 = o0.a(localCursor, localCursor.getColumnIndex("suggest_intent_data"));
        localObject1 = localObject5;
        if (localObject5 == null) {
          localObject1 = C0.getSuggestIntentData();
        }
        localObject5 = localObject1;
        if (localObject1 != null)
        {
          String str = o0.a(localCursor, localCursor.getColumnIndex("suggest_intent_data_id"));
          localObject5 = localObject1;
          if (str != null)
          {
            localObject5 = new java/lang/StringBuilder;
            ((StringBuilder)localObject5).<init>();
            ((StringBuilder)localObject5).append((String)localObject1);
            ((StringBuilder)localObject5).append("/");
            ((StringBuilder)localObject5).append(Uri.encode(str));
            localObject5 = ((StringBuilder)localObject5).toString();
          }
        }
        if (localObject5 == null) {
          localObject1 = null;
        } else {
          localObject1 = Uri.parse((String)localObject5);
        }
        localObject5 = o0.a(localCursor, localCursor.getColumnIndex("suggest_intent_query"));
        localObject1 = a((String)localObject4, (Uri)localObject1, o0.a(localCursor, localCursor.getColumnIndex("suggest_intent_extra_data")), (String)localObject5, 0, null);
      }
      catch (RuntimeException localRuntimeException1)
      {
        try
        {
          paramInt = localCursor.getPosition();
        }
        catch (RuntimeException localRuntimeException2)
        {
          paramInt = -1;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Search suggestions cursor at row ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" returned exception.");
        Log.w("SearchView", localStringBuilder.toString(), localRuntimeException1);
        localObject2 = localObject3;
      }
      if (localObject2 != null) {
        try
        {
          getContext().startActivity((Intent)localObject2);
        }
        catch (RuntimeException localRuntimeException3)
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("Failed launch activity: ");
          ((StringBuilder)localObject5).append(localObject2);
          Log.e("SearchView", ((StringBuilder)localObject5).toString(), localRuntimeException3);
        }
      }
    }
    M.setImeVisibility(false);
    M.dismissDropDown();
    return true;
  }
  
  public void c()
  {
    M.setText("");
    SearchAutoComplete localSearchAutoComplete = M;
    localSearchAutoComplete.setSelection(localSearchAutoComplete.length());
    z0 = "";
    clearFocus();
    b(true);
    M.setImeOptions(B0);
    A0 = false;
  }
  
  public final void c(boolean paramBoolean)
  {
    boolean bool = x0;
    int i = 8;
    int j = i;
    if (bool)
    {
      j = i;
      if (!q0)
      {
        j = i;
        if (paramBoolean)
        {
          R.setVisibility(8);
          j = 0;
        }
      }
    }
    T.setVisibility(j);
  }
  
  public boolean c(int paramInt)
  {
    Object localObject1 = n0;
    if ((localObject1 != null) && (((n)localObject1).a(paramInt))) {
      return false;
    }
    localObject1 = M.getText();
    Object localObject2 = r0.z;
    if (localObject2 != null) {
      if (((Cursor)localObject2).moveToPosition(paramInt))
      {
        localObject2 = r0.b((Cursor)localObject2);
        if (localObject2 != null) {
          setQuery((CharSequence)localObject2);
        } else {
          setQuery((CharSequence)localObject1);
        }
      }
      else
      {
        setQuery((CharSequence)localObject1);
      }
    }
    return true;
  }
  
  public void clearFocus()
  {
    v0 = true;
    super.clearFocus();
    M.clearFocus();
    M.setImeVisibility(false);
    v0 = false;
  }
  
  public void d()
  {
    Object localObject = N0;
    SearchAutoComplete localSearchAutoComplete = M;
    localObject = a;
    if (localObject != null) {}
    try
    {
      ((Method)localObject).invoke(localSearchAutoComplete, new Object[0]);
      localObject = N0;
      localSearchAutoComplete = M;
      localObject = b;
      if (localObject == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        ((Method)localObject).invoke(localSearchAutoComplete, new Object[0]);
        return;
        localException1 = localException1;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
  
  public void e()
  {
    if (TextUtils.isEmpty(M.getText()))
    {
      if (p0)
      {
        l locall = l0;
        if ((locall == null) || (!locall.a()))
        {
          clearFocus();
          b(true);
        }
      }
    }
    else
    {
      M.setText("");
      M.requestFocus();
      M.setImeVisibility(true);
    }
  }
  
  public void f()
  {
    b(false);
    M.requestFocus();
    M.setImeVisibility(true);
    View.OnClickListener localOnClickListener = o0;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this);
    }
  }
  
  public void g()
  {
    Editable localEditable = M.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0))
    {
      m localm = k0;
      if ((localm == null) || (!localm.b(localEditable.toString())))
      {
        if (C0 != null) {
          a(0, null, localEditable.toString());
        }
        M.setImeVisibility(false);
        M.dismissDropDown();
      }
    }
  }
  
  public int getImeOptions()
  {
    return M.getImeOptions();
  }
  
  public int getInputType()
  {
    return M.getInputType();
  }
  
  public int getMaxWidth()
  {
    return w0;
  }
  
  public CharSequence getQuery()
  {
    return M.getText();
  }
  
  public CharSequence getQueryHint()
  {
    Object localObject = t0;
    if (localObject == null)
    {
      localObject = C0;
      if ((localObject != null) && (((SearchableInfo)localObject).getHintId() != 0)) {
        localObject = getContext().getText(C0.getHintId());
      } else {
        localObject = j0;
      }
    }
    return (CharSequence)localObject;
  }
  
  public int getSuggestionCommitIconResId()
  {
    return g0;
  }
  
  public int getSuggestionRowLayout()
  {
    return f0;
  }
  
  public d.j.a.a getSuggestionsAdapter()
  {
    return r0;
  }
  
  public final void h()
  {
    boolean bool = TextUtils.isEmpty(M.getText());
    int i = 1;
    int j = bool ^ true;
    int k = 0;
    int m = i;
    if (j == 0) {
      if ((p0) && (!A0)) {
        m = i;
      } else {
        m = 0;
      }
    }
    Object localObject = S;
    if (m != 0) {
      m = k;
    } else {
      m = 8;
    }
    ((ImageView)localObject).setVisibility(m);
    Drawable localDrawable = S.getDrawable();
    if (localDrawable != null)
    {
      if (j != 0) {
        localObject = ViewGroup.ENABLED_STATE_SET;
      } else {
        localObject = ViewGroup.EMPTY_STATE_SET;
      }
      localDrawable.setState((int[])localObject);
    }
  }
  
  public void i()
  {
    int[] arrayOfInt;
    if (M.hasFocus()) {
      arrayOfInt = ViewGroup.FOCUSED_STATE_SET;
    } else {
      arrayOfInt = ViewGroup.EMPTY_STATE_SET;
    }
    Drawable localDrawable = O.getBackground();
    if (localDrawable != null) {
      localDrawable.setState(arrayOfInt);
    }
    localDrawable = P.getBackground();
    if (localDrawable != null) {
      localDrawable.setState(arrayOfInt);
    }
    invalidate();
  }
  
  public final void j()
  {
    Object localObject1 = getQueryHint();
    SearchAutoComplete localSearchAutoComplete = M;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    localObject1 = localObject2;
    if (p0) {
      if (e0 == null)
      {
        localObject1 = localObject2;
      }
      else
      {
        int i = (int)(M.getTextSize() * 1.25D);
        e0.setBounds(0, 0, i, i);
        localObject1 = new SpannableStringBuilder("   ");
        ((SpannableStringBuilder)localObject1).setSpan(new ImageSpan(e0), 1, 2, 33);
        ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
      }
    }
    localSearchAutoComplete.setHint((CharSequence)localObject1);
  }
  
  public final void k()
  {
    boolean bool = s0;
    int i = 0;
    if (((bool) || (x0)) && (!q0)) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      j = i;
      if (R.getVisibility() == 0) {
        break label66;
      }
      if (T.getVisibility() == 0)
      {
        j = i;
        break label66;
      }
    }
    int j = 8;
    label66:
    P.setVisibility(j);
  }
  
  public void onDetachedFromWindow()
  {
    removeCallbacks(E0);
    post(F0);
    super.onDetachedFromWindow();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      SearchAutoComplete localSearchAutoComplete = M;
      Rect localRect = W;
      localSearchAutoComplete.getLocationInWindow(b0);
      getLocationInWindow(c0);
      int[] arrayOfInt = b0;
      paramInt1 = arrayOfInt[1];
      Object localObject = c0;
      paramInt3 = paramInt1 - localObject[1];
      paramInt1 = arrayOfInt[0] - localObject[0];
      localRect.set(paramInt1, paramInt3, localSearchAutoComplete.getWidth() + paramInt1, localSearchAutoComplete.getHeight() + paramInt3);
      localRect = a0;
      localObject = W;
      localRect.set(left, 0, right, paramInt4 - paramInt2);
      localObject = V;
      if (localObject == null)
      {
        localObject = new p(a0, W, M);
        V = ((p)localObject);
        setTouchDelegate((TouchDelegate)localObject);
      }
      else
      {
        ((p)localObject).a(a0, W);
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (q0)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    if (i != Integer.MIN_VALUE)
    {
      if (i != 0)
      {
        if (i != 1073741824)
        {
          paramInt1 = j;
        }
        else
        {
          i = w0;
          paramInt1 = j;
          if (i > 0) {
            paramInt1 = Math.min(i, j);
          }
        }
      }
      else
      {
        paramInt1 = w0;
        if (paramInt1 <= 0) {
          paramInt1 = getPreferredWidth();
        }
      }
    }
    else
    {
      paramInt1 = w0;
      if (paramInt1 > 0) {
        paramInt1 = Math.min(paramInt1, j);
      } else {
        paramInt1 = Math.min(getPreferredWidth(), j);
      }
    }
    j = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (j != Integer.MIN_VALUE)
    {
      if (j == 0) {
        paramInt2 = getPreferredHeight();
      }
    }
    else {
      paramInt2 = Math.min(getPreferredHeight(), paramInt2);
    }
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof o))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (o)paramParcelable;
    super.onRestoreInstanceState(x);
    b(z);
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    o localo = new o(super.onSaveInstanceState());
    z = q0;
    return localo;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    post(E0);
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (v0) {
      return false;
    }
    if (!isFocusable()) {
      return false;
    }
    if (!q0)
    {
      boolean bool = M.requestFocus(paramInt, paramRect);
      if (bool) {
        b(false);
      }
      return bool;
    }
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void setAppSearchData(Bundle paramBundle)
  {
    D0 = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    if (paramBoolean) {
      e();
    } else {
      f();
    }
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    if (p0 == paramBoolean) {
      return;
    }
    p0 = paramBoolean;
    b(paramBoolean);
    j();
  }
  
  public void setImeOptions(int paramInt)
  {
    M.setImeOptions(paramInt);
  }
  
  public void setInputType(int paramInt)
  {
    M.setInputType(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    w0 = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(l paraml)
  {
    l0 = paraml;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    m0 = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(m paramm)
  {
    k0 = paramm;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    o0 = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(n paramn)
  {
    n0 = paramn;
  }
  
  public void setQueryHint(CharSequence paramCharSequence)
  {
    t0 = paramCharSequence;
    j();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    u0 = paramBoolean;
    Object localObject = r0;
    if ((localObject instanceof o0))
    {
      localObject = (o0)localObject;
      int i;
      if (paramBoolean) {
        i = 2;
      } else {
        i = 1;
      }
      O = i;
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    C0 = paramSearchableInfo;
    boolean bool = true;
    Object localObject = null;
    if (paramSearchableInfo != null)
    {
      M.setThreshold(paramSearchableInfo.getSuggestThreshold());
      M.setImeOptions(C0.getImeOptions());
      int i = C0.getInputType();
      int j = i;
      if ((i & 0xF) == 1)
      {
        i &= 0xFFFEFFFF;
        j = i;
        if (C0.getSuggestAuthority() != null) {
          j = i | 0x10000 | 0x80000;
        }
      }
      M.setInputType(j);
      paramSearchableInfo = r0;
      if (paramSearchableInfo != null) {
        paramSearchableInfo.a(null);
      }
      if (C0.getSuggestAuthority() != null)
      {
        paramSearchableInfo = new o0(getContext(), this, C0, G0);
        r0 = paramSearchableInfo;
        M.setAdapter(paramSearchableInfo);
        paramSearchableInfo = (o0)r0;
        if (u0) {
          j = 2;
        } else {
          j = 1;
        }
        O = j;
      }
      j();
    }
    paramSearchableInfo = C0;
    if ((paramSearchableInfo != null) && (paramSearchableInfo.getVoiceSearchEnabled()))
    {
      if (C0.getVoiceSearchLaunchWebSearch())
      {
        paramSearchableInfo = h0;
      }
      else
      {
        paramSearchableInfo = (SearchableInfo)localObject;
        if (C0.getVoiceSearchLaunchRecognizer()) {
          paramSearchableInfo = i0;
        }
      }
      if ((paramSearchableInfo != null) && (getContext().getPackageManager().resolveActivity(paramSearchableInfo, 65536) != null)) {}
    }
    else
    {
      bool = false;
    }
    x0 = bool;
    if (bool) {
      M.setPrivateImeOptions("nm");
    }
    b(q0);
  }
  
  public void setSubmitButtonEnabled(boolean paramBoolean)
  {
    s0 = paramBoolean;
    b(q0);
  }
  
  public void setSuggestionsAdapter(d.j.a.a parama)
  {
    r0 = parama;
    M.setAdapter(parama);
  }
  
  public static class SearchAutoComplete
    extends d
  {
    public int A = getThreshold();
    public SearchView B;
    public boolean C;
    public final Runnable D = new a();
    
    public SearchAutoComplete(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
    {
      this(paramContext, paramAttributeSet, R.attr.autoCompleteTextViewStyle);
    }
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    private int getSearchViewTextMinWidthDp()
    {
      Configuration localConfiguration = getResources().getConfiguration();
      int i = screenWidthDp;
      int j = screenHeightDp;
      if ((i >= 960) && (j >= 720) && (orientation == 2)) {
        return 256;
      }
      if ((i < 600) && ((i < 640) || (j < 480))) {
        return 160;
      }
      return 192;
    }
    
    public boolean enoughToFilter()
    {
      boolean bool;
      if ((A > 0) && (!super.enoughToFilter())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
    {
      paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
      if (C)
      {
        removeCallbacks(D);
        post(D);
      }
      return paramEditorInfo;
    }
    
    public void onFinishInflate()
    {
      super.onFinishInflate();
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      setMinWidth((int)TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), localDisplayMetrics));
    }
    
    public void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
    {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      paramRect = B;
      paramRect.b(q0);
      paramRect.post(E0);
      if (M.hasFocus()) {
        paramRect.d();
      }
    }
    
    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
          return true;
        }
        if (paramKeyEvent.getAction() == 1)
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.handleUpEvent(paramKeyEvent);
          }
          if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
          {
            B.clearFocus();
            setImeVisibility(false);
            return true;
          }
        }
      }
      return super.onKeyPreIme(paramInt, paramKeyEvent);
    }
    
    public void onWindowFocusChanged(boolean paramBoolean)
    {
      super.onWindowFocusChanged(paramBoolean);
      Method localMethod;
      if ((paramBoolean) && (B.hasFocus()) && (getVisibility() == 0))
      {
        C = true;
        if (SearchView.a(getContext()))
        {
          localMethod = N0c;
          if (localMethod == null) {}
        }
      }
      try
      {
        localMethod.invoke(this, new Object[] { Boolean.valueOf(true) });
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
    
    public void performCompletion() {}
    
    public void replaceText(CharSequence paramCharSequence) {}
    
    public void setImeVisibility(boolean paramBoolean)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (!paramBoolean)
      {
        C = false;
        removeCallbacks(D);
        localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
      }
      if (localInputMethodManager.isActive(this))
      {
        C = false;
        removeCallbacks(D);
        localInputMethodManager.showSoftInput(this, 0);
        return;
      }
      C = true;
    }
    
    public void setSearchView(SearchView paramSearchView)
    {
      B = paramSearchView;
    }
    
    public void setThreshold(int paramInt)
    {
      super.setThreshold(paramInt);
      A = paramInt;
    }
    
    public class a
      implements Runnable
    {
      public a() {}
      
      public void run()
      {
        SearchView.SearchAutoComplete localSearchAutoComplete = SearchView.SearchAutoComplete.this;
        if (C)
        {
          ((InputMethodManager)localSearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(localSearchAutoComplete, 0);
          C = false;
        }
      }
    }
  }
  
  public class a
    implements TextWatcher
  {
    public a() {}
    
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      SearchView localSearchView = SearchView.this;
      Editable localEditable = M.getText();
      z0 = localEditable;
      boolean bool = TextUtils.isEmpty(localEditable) ^ true;
      localSearchView.a(bool);
      localSearchView.c(bool ^ true);
      localSearchView.h();
      localSearchView.k();
      if ((k0 != null) && (!TextUtils.equals(paramCharSequence, y0))) {
        k0.a(paramCharSequence.toString());
      }
      y0 = paramCharSequence.toString();
    }
  }
  
  public class b
    implements Runnable
  {
    public b() {}
    
    public void run()
    {
      i();
    }
  }
  
  public class c
    implements Runnable
  {
    public c() {}
    
    public void run()
    {
      d.j.a.a locala = r0;
      if ((locala != null) && ((locala instanceof o0))) {
        locala.a(null);
      }
    }
  }
  
  public class d
    implements View.OnFocusChangeListener
  {
    public d() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      SearchView localSearchView = SearchView.this;
      paramView = m0;
      if (paramView != null) {
        paramView.onFocusChange(localSearchView, paramBoolean);
      }
    }
  }
  
  public class e
    implements View.OnLayoutChangeListener
  {
    public e() {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      SearchView localSearchView = SearchView.this;
      if (U.getWidth() > 1)
      {
        Resources localResources = localSearchView.getContext().getResources();
        paramInt3 = O.getPaddingLeft();
        paramView = new Rect();
        boolean bool = b1.a(localSearchView);
        if (p0)
        {
          paramInt1 = localResources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width);
          paramInt1 = localResources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + paramInt1;
        }
        else
        {
          paramInt1 = 0;
        }
        M.getDropDownBackground().getPadding(paramView);
        if (bool) {
          paramInt2 = -left;
        } else {
          paramInt2 = paramInt3 - (left + paramInt1);
        }
        M.setDropDownHorizontalOffset(paramInt2);
        paramInt5 = U.getWidth();
        paramInt4 = left;
        paramInt2 = right;
        M.setDropDownWidth(paramInt5 + paramInt4 + paramInt2 + paramInt1 - paramInt3);
      }
    }
  }
  
  public class f
    implements View.OnClickListener
  {
    public f() {}
    
    public void onClick(View paramView)
    {
      SearchView localSearchView = SearchView.this;
      if (paramView == Q)
      {
        localSearchView.f();
      }
      else if (paramView == S)
      {
        localSearchView.e();
      }
      else if (paramView == R)
      {
        localSearchView.g();
      }
      else if (paramView == T)
      {
        paramView = C0;
        if (paramView != null) {
          try
          {
            if (paramView.getVoiceSearchLaunchWebSearch())
            {
              Intent localIntent1 = h0;
              Intent localIntent2 = new android/content/Intent;
              localIntent2.<init>(localIntent1);
              paramView = paramView.getSearchActivity();
              if (paramView == null) {
                paramView = null;
              } else {
                paramView = paramView.flattenToShortString();
              }
              localIntent2.putExtra("calling_package", paramView);
              localSearchView.getContext().startActivity(localIntent2);
            }
            else if (paramView.getVoiceSearchLaunchRecognizer())
            {
              paramView = localSearchView.a(i0, paramView);
              localSearchView.getContext().startActivity(paramView);
            }
          }
          catch (ActivityNotFoundException paramView)
          {
            Log.w("SearchView", "Could not find voice search activity");
          }
        }
      }
      else if (paramView == M)
      {
        localSearchView.d();
      }
    }
  }
  
  public class g
    implements View.OnKeyListener
  {
    public g() {}
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      SearchView localSearchView = SearchView.this;
      SearchableInfo localSearchableInfo = C0;
      boolean bool1 = false;
      if (localSearchableInfo == null) {
        return false;
      }
      boolean bool2;
      if ((M.isPopupShowing()) && (M.getListSelection() != -1))
      {
        paramView = SearchView.this;
        if (C0 == null)
        {
          bool2 = bool1;
        }
        else if (r0 == null)
        {
          bool2 = bool1;
        }
        else
        {
          bool2 = bool1;
          if (paramKeyEvent.getAction() == 0)
          {
            bool2 = bool1;
            if (paramKeyEvent.hasNoModifiers()) {
              if ((paramInt != 66) && (paramInt != 84) && (paramInt != 61))
              {
                if ((paramInt != 21) && (paramInt != 22))
                {
                  bool2 = bool1;
                  if (paramInt != 19) {
                    break label260;
                  }
                  M.getListSelection();
                  bool2 = bool1;
                  break label260;
                }
                if (paramInt == 21) {
                  paramInt = 0;
                } else {
                  paramInt = M.length();
                }
                M.setSelection(paramInt);
                M.setListSelection(0);
                M.clearListSelection();
                paramKeyEvent = SearchView.N0;
                paramView = M;
                paramKeyEvent = c;
                if (paramKeyEvent == null) {}
              }
            }
          }
        }
      }
      try
      {
        paramKeyEvent.invoke(paramView, new Object[] { Boolean.valueOf(true) });
        bool2 = true;
        break label260;
        bool2 = paramView.b(M.getListSelection());
        label260:
        return bool2;
        int i;
        if (TextUtils.getTrimmedLength(M.getText()) == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i == 0) && (paramKeyEvent.hasNoModifiers()) && (paramKeyEvent.getAction() == 1) && (paramInt == 66))
        {
          paramView.cancelLongPress();
          paramView = SearchView.this;
          paramView.a(0, null, M.getText().toString());
          return true;
        }
        return false;
      }
      catch (Exception paramView)
      {
        for (;;) {}
      }
    }
  }
  
  public class h
    implements TextView.OnEditorActionListener
  {
    public h() {}
    
    public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      g();
      return true;
    }
  }
  
  public class i
    implements AdapterView.OnItemClickListener
  {
    public i() {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      b(paramInt);
    }
  }
  
  public class j
    implements AdapterView.OnItemSelectedListener
  {
    public j() {}
    
    public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      c(paramInt);
    }
    
    public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  }
  
  public static class k
  {
    public Method a;
    public Method b;
    public Method c;
    
    public k()
    {
      try
      {
        localMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
        a = localMethod;
        localMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        try
        {
          localMethod = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
          b = localMethod;
          localMethod.setAccessible(true);
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          try
          {
            for (;;)
            {
              Method localMethod = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
              c = localMethod;
              localMethod.setAccessible(true);
              return;
              localNoSuchMethodException1 = localNoSuchMethodException1;
              continue;
              localNoSuchMethodException2 = localNoSuchMethodException2;
            }
          }
          catch (NoSuchMethodException localNoSuchMethodException3)
          {
            for (;;) {}
          }
        }
      }
    }
  }
  
  public static abstract interface l
  {
    public abstract boolean a();
  }
  
  public static abstract interface m
  {
    public abstract boolean a(String paramString);
    
    public abstract boolean b(String paramString);
  }
  
  public static abstract interface n
  {
    public abstract boolean a(int paramInt);
    
    public abstract boolean b(int paramInt);
  }
  
  public static class o
    extends d.k.a.a
  {
    public static final Parcelable.Creator<o> CREATOR = new a();
    public boolean z;
    
    public o(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      z = ((Boolean)paramParcel.readValue(null)).booleanValue();
    }
    
    public o(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = e.a.a.a.a.a("SearchView.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" isIconified=");
      localStringBuilder.append(z);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(x, paramInt);
      paramParcel.writeValue(Boolean.valueOf(z));
    }
    
    public static final class a
      implements Parcelable.ClassLoaderCreator<SearchView.o>
    {
      public Object createFromParcel(Parcel paramParcel)
      {
        return new SearchView.o(paramParcel, null);
      }
      
      public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new SearchView.o(paramParcel, paramClassLoader);
      }
      
      public Object[] newArray(int paramInt)
      {
        return new SearchView.o[paramInt];
      }
    }
  }
  
  public static class p
    extends TouchDelegate
  {
    public final View a;
    public final Rect b;
    public final Rect c;
    public final Rect d;
    public final int e;
    public boolean f;
    
    public p(Rect paramRect1, Rect paramRect2, View paramView)
    {
      super(paramView);
      e = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      b = new Rect();
      d = new Rect();
      c = new Rect();
      a(paramRect1, paramRect2);
      a = paramView;
    }
    
    public void a(Rect paramRect1, Rect paramRect2)
    {
      b.set(paramRect1);
      d.set(paramRect1);
      paramRect1 = d;
      int i = e;
      paramRect1.inset(-i, -i);
      c.set(paramRect2);
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      int k = paramMotionEvent.getAction();
      boolean bool1 = true;
      boolean bool2 = false;
      if (k != 0) {
        if ((k != 1) && (k != 2))
        {
          if (k != 3) {
            break label131;
          }
          bool1 = f;
          f = false;
        }
        else
        {
          bool3 = f;
          bool1 = bool3;
          if (bool3)
          {
            bool1 = bool3;
            if (!d.contains(i, j))
            {
              bool1 = bool3;
              k = 0;
              break label137;
            }
          }
        }
      }
      for (;;)
      {
        k = 1;
        break label137;
        if (!b.contains(i, j)) {
          break;
        }
        f = true;
      }
      label131:
      k = 1;
      bool1 = false;
      label137:
      boolean bool3 = bool2;
      if (bool1)
      {
        if ((k != 0) && (!c.contains(i, j)))
        {
          paramMotionEvent.setLocation(a.getWidth() / 2, a.getHeight() / 2);
        }
        else
        {
          Rect localRect = c;
          paramMotionEvent.setLocation(i - left, j - top);
        }
        bool3 = a.dispatchTouchEvent(paramMotionEvent);
      }
      return bool3;
    }
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.widget.SearchView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */