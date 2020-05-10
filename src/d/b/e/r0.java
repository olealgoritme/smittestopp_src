package d.b.e;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.appcompat.widget.SearchView;
import d.j.a.c;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
public class r0
  extends c
  implements View.OnClickListener
{
  public final SearchView I;
  public final SearchableInfo J;
  public final Context K;
  public final WeakHashMap<String, Drawable.ConstantState> L;
  public final int M;
  public boolean N = false;
  public int O = 1;
  public ColorStateList P;
  public int Q = -1;
  public int R = -1;
  public int S = -1;
  public int T = -1;
  public int U = -1;
  public int V = -1;
  
  public r0(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap<String, Drawable.ConstantState> paramWeakHashMap)
  {
    super(paramContext, paramSearchView.getSuggestionRowLayout(), null, true);
    SearchManager localSearchManager = (SearchManager)A.getSystemService("search");
    I = paramSearchView;
    J = paramSearchableInfo;
    M = paramSearchView.getSuggestionCommitIconResId();
    K = paramContext;
    L = paramWeakHashMap;
  }
  
  public static String a(Cursor paramCursor, int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    try
    {
      paramCursor = paramCursor.getString(paramInt);
      return paramCursor;
    }
    catch (Exception paramCursor)
    {
      Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", paramCursor);
    }
    return null;
  }
  
  public static String a(Cursor paramCursor, String paramString)
  {
    return a(paramCursor, paramCursor.getColumnIndex(paramString));
  }
  
  public Cursor a(SearchableInfo paramSearchableInfo, String paramString, int paramInt)
  {
    Object localObject1 = null;
    if (paramSearchableInfo == null) {
      return null;
    }
    Object localObject2 = paramSearchableInfo.getSuggestAuthority();
    if (localObject2 == null) {
      return null;
    }
    localObject2 = new Uri.Builder().scheme("content").authority((String)localObject2).query("").fragment("");
    String str = paramSearchableInfo.getSuggestPath();
    if (str != null) {
      ((Uri.Builder)localObject2).appendEncodedPath(str);
    }
    ((Uri.Builder)localObject2).appendPath("search_suggest_query");
    str = paramSearchableInfo.getSuggestSelection();
    if (str != null)
    {
      paramSearchableInfo = new String[1];
      paramSearchableInfo[0] = paramString;
    }
    else
    {
      ((Uri.Builder)localObject2).appendPath(paramString);
      paramSearchableInfo = (SearchableInfo)localObject1;
    }
    if (paramInt > 0) {
      ((Uri.Builder)localObject2).appendQueryParameter("limit", String.valueOf(paramInt));
    }
    paramString = ((Uri.Builder)localObject2).build();
    return A.getContentResolver().query(paramString, null, str, paramSearchableInfo, null);
  }
  
  public Drawable a(Uri paramUri)
  {
    String str = paramUri.getAuthority();
    if (!TextUtils.isEmpty(str)) {
      try
      {
        Resources localResources = A.getPackageManager().getResourcesForApplication(str);
        List localList = paramUri.getPathSegments();
        if (localList != null)
        {
          int i = localList.size();
          if (i == 1)
          {
            try
            {
              i = Integer.parseInt((String)localList.get(0));
            }
            catch (NumberFormatException localNumberFormatException)
            {
              localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("Single path segment is not a resource ID: ");
              localStringBuilder1.append(paramUri);
              throw new FileNotFoundException(localStringBuilder1.toString());
            }
          }
          else
          {
            if (i != 2) {
              break label184;
            }
            i = localStringBuilder1.getIdentifier((String)localList.get(1), (String)localList.get(0), str);
          }
          if (i != 0) {
            return localStringBuilder1.getDrawable(i);
          }
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("No resource found for: ");
          localStringBuilder1.append(paramUri);
          throw new FileNotFoundException(localStringBuilder1.toString());
          label184:
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("More than two path segments: ");
          localStringBuilder1.append(paramUri);
          throw new FileNotFoundException(localStringBuilder1.toString());
        }
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("No path: ");
        localStringBuilder1.append(paramUri);
        throw new FileNotFoundException(localStringBuilder1.toString());
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("No package found for authority: ");
        localStringBuilder2.append(paramUri);
        throw new FileNotFoundException(localStringBuilder2.toString());
      }
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("No authority: ");
    localStringBuilder2.append(paramUri);
    throw new FileNotFoundException(localStringBuilder2.toString());
  }
  
  /* Error */
  public final Drawable a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_2
    //   5: astore 4
    //   7: aload_1
    //   8: ifnull +544 -> 552
    //   11: aload_2
    //   12: astore 4
    //   14: aload_1
    //   15: invokevirtual 276	java/lang/String:isEmpty	()Z
    //   18: ifne +534 -> 552
    //   21: ldc_w 278
    //   24: aload_1
    //   25: invokevirtual 282	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   28: ifeq +9 -> 37
    //   31: aload_2
    //   32: astore 4
    //   34: goto +518 -> 552
    //   37: aload_1
    //   38: invokestatic 228	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   41: istore 5
    //   43: new 230	java/lang/StringBuilder
    //   46: astore_2
    //   47: aload_2
    //   48: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: ldc_w 284
    //   55: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_2
    //   60: aload_0
    //   61: getfield 86	d/b/e/r0:K	Landroid/content/Context;
    //   64: invokevirtual 287	android/content/Context:getPackageName	()Ljava/lang/String;
    //   67: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_2
    //   72: ldc_w 289
    //   75: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_2
    //   80: iload 5
    //   82: invokevirtual 292	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_2
    //   87: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore 4
    //   92: aload_0
    //   93: getfield 88	d/b/e/r0:L	Ljava/util/WeakHashMap;
    //   96: aload 4
    //   98: invokevirtual 297	java/util/WeakHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   101: checkcast 299	android/graphics/drawable/Drawable$ConstantState
    //   104: astore_2
    //   105: aload_2
    //   106: ifnonnull +8 -> 114
    //   109: aconst_null
    //   110: astore_2
    //   111: goto +8 -> 119
    //   114: aload_2
    //   115: invokevirtual 303	android/graphics/drawable/Drawable$ConstantState:newDrawable	()Landroid/graphics/drawable/Drawable;
    //   118: astore_2
    //   119: aload_2
    //   120: ifnull +5 -> 125
    //   123: aload_2
    //   124: areturn
    //   125: aload_0
    //   126: getfield 86	d/b/e/r0:K	Landroid/content/Context;
    //   129: iload 5
    //   131: invokestatic 309	d/i/b/a:c	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   134: astore_2
    //   135: aload_2
    //   136: ifnull +17 -> 153
    //   139: aload_0
    //   140: getfield 88	d/b/e/r0:L	Ljava/util/WeakHashMap;
    //   143: aload 4
    //   145: aload_2
    //   146: invokevirtual 315	android/graphics/drawable/Drawable:getConstantState	()Landroid/graphics/drawable/Drawable$ConstantState;
    //   149: invokevirtual 319	java/util/WeakHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: aload_2
    //   154: areturn
    //   155: astore_2
    //   156: new 230	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   163: astore_2
    //   164: aload_2
    //   165: ldc_w 321
    //   168: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_2
    //   173: aload_1
    //   174: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: ldc 102
    //   180: aload_2
    //   181: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 325	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   187: pop
    //   188: aconst_null
    //   189: areturn
    //   190: astore_2
    //   191: aload_0
    //   192: getfield 88	d/b/e/r0:L	Ljava/util/WeakHashMap;
    //   195: aload_1
    //   196: invokevirtual 297	java/util/WeakHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   199: checkcast 299	android/graphics/drawable/Drawable$ConstantState
    //   202: astore_2
    //   203: aload_2
    //   204: ifnonnull +8 -> 212
    //   207: aconst_null
    //   208: astore_2
    //   209: goto +8 -> 217
    //   212: aload_2
    //   213: invokevirtual 303	android/graphics/drawable/Drawable$ConstantState:newDrawable	()Landroid/graphics/drawable/Drawable;
    //   216: astore_2
    //   217: aload_2
    //   218: ifnull +5 -> 223
    //   221: aload_2
    //   222: areturn
    //   223: aload_1
    //   224: invokestatic 329	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   227: astore 4
    //   229: ldc_w 331
    //   232: aload 4
    //   234: invokevirtual 334	android/net/Uri:getScheme	()Ljava/lang/String;
    //   237: invokevirtual 282	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   240: istore 6
    //   242: iload 6
    //   244: ifeq +54 -> 298
    //   247: aload_0
    //   248: aload 4
    //   250: invokevirtual 336	d/b/e/r0:a	(Landroid/net/Uri;)Landroid/graphics/drawable/Drawable;
    //   253: astore_2
    //   254: goto +275 -> 529
    //   257: astore_2
    //   258: new 242	java/io/FileNotFoundException
    //   261: astore 7
    //   263: new 230	java/lang/StringBuilder
    //   266: astore_2
    //   267: aload_2
    //   268: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   271: aload_2
    //   272: ldc_w 338
    //   275: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload_2
    //   280: aload 4
    //   282: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 7
    //   288: aload_2
    //   289: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokespecial 248	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   295: aload 7
    //   297: athrow
    //   298: aload_0
    //   299: getfield 86	d/b/e/r0:K	Landroid/content/Context;
    //   302: invokevirtual 179	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   305: aload 4
    //   307: invokevirtual 342	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   310: astore 7
    //   312: aload 7
    //   314: ifnull +116 -> 430
    //   317: aload 7
    //   319: aconst_null
    //   320: invokestatic 346	android/graphics/drawable/Drawable:createFromStream	(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   323: astore_2
    //   324: aload 7
    //   326: invokevirtual 351	java/io/InputStream:close	()V
    //   329: goto +45 -> 374
    //   332: astore 7
    //   334: new 230	java/lang/StringBuilder
    //   337: astore 8
    //   339: aload 8
    //   341: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   344: aload 8
    //   346: ldc_w 353
    //   349: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 8
    //   355: aload 4
    //   357: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: ldc 102
    //   363: aload 8
    //   365: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: aload 7
    //   370: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   373: pop
    //   374: goto +155 -> 529
    //   377: astore_2
    //   378: aload 7
    //   380: invokevirtual 351	java/io/InputStream:close	()V
    //   383: goto +45 -> 428
    //   386: astore 7
    //   388: new 230	java/lang/StringBuilder
    //   391: astore 8
    //   393: aload 8
    //   395: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   398: aload 8
    //   400: ldc_w 353
    //   403: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 8
    //   409: aload 4
    //   411: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: ldc 102
    //   417: aload 8
    //   419: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: aload 7
    //   424: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   427: pop
    //   428: aload_2
    //   429: athrow
    //   430: new 242	java/io/FileNotFoundException
    //   433: astore 7
    //   435: new 230	java/lang/StringBuilder
    //   438: astore_2
    //   439: aload_2
    //   440: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   443: aload_2
    //   444: ldc_w 355
    //   447: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload_2
    //   452: aload 4
    //   454: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 7
    //   460: aload_2
    //   461: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokespecial 248	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   467: aload 7
    //   469: athrow
    //   470: astore_2
    //   471: new 230	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   478: astore 7
    //   480: aload 7
    //   482: ldc_w 357
    //   485: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload 7
    //   491: aload 4
    //   493: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload 7
    //   499: ldc_w 359
    //   502: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload 7
    //   508: aload_2
    //   509: invokevirtual 362	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   512: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: ldc 102
    //   518: aload 7
    //   520: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 325	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   526: pop
    //   527: aload_3
    //   528: astore_2
    //   529: aload_2
    //   530: astore 4
    //   532: aload_2
    //   533: ifnull +19 -> 552
    //   536: aload_0
    //   537: getfield 88	d/b/e/r0:L	Ljava/util/WeakHashMap;
    //   540: aload_1
    //   541: aload_2
    //   542: invokevirtual 315	android/graphics/drawable/Drawable:getConstantState	()Landroid/graphics/drawable/Drawable$ConstantState;
    //   545: invokevirtual 319	java/util/WeakHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   548: pop
    //   549: aload_2
    //   550: astore 4
    //   552: aload 4
    //   554: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	555	0	this	r0
    //   0	555	1	paramString	String
    //   1	153	2	localObject1	Object
    //   155	1	2	localNotFoundException1	android.content.res.Resources.NotFoundException
    //   163	18	2	localStringBuilder1	StringBuilder
    //   190	1	2	localNumberFormatException	NumberFormatException
    //   202	52	2	localObject2	Object
    //   257	1	2	localNotFoundException2	android.content.res.Resources.NotFoundException
    //   266	58	2	localObject3	Object
    //   377	52	2	localObject4	Object
    //   438	23	2	localStringBuilder2	StringBuilder
    //   470	39	2	localFileNotFoundException	FileNotFoundException
    //   528	22	2	localObject5	Object
    //   3	525	3	localObject6	Object
    //   5	548	4	localObject7	Object
    //   41	89	5	i	int
    //   240	3	6	bool	boolean
    //   261	64	7	localObject8	Object
    //   332	47	7	localIOException1	java.io.IOException
    //   386	37	7	localIOException2	java.io.IOException
    //   433	86	7	localObject9	Object
    //   337	81	8	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   37	105	155	android/content/res/Resources$NotFoundException
    //   114	119	155	android/content/res/Resources$NotFoundException
    //   125	135	155	android/content/res/Resources$NotFoundException
    //   139	153	155	android/content/res/Resources$NotFoundException
    //   37	105	190	java/lang/NumberFormatException
    //   114	119	190	java/lang/NumberFormatException
    //   125	135	190	java/lang/NumberFormatException
    //   139	153	190	java/lang/NumberFormatException
    //   247	254	257	android/content/res/Resources$NotFoundException
    //   324	329	332	java/io/IOException
    //   317	324	377	finally
    //   378	383	386	java/io/IOException
    //   229	242	470	java/io/FileNotFoundException
    //   247	254	470	java/io/FileNotFoundException
    //   258	298	470	java/io/FileNotFoundException
    //   298	312	470	java/io/FileNotFoundException
    //   334	374	470	java/io/FileNotFoundException
    //   388	428	470	java/io/FileNotFoundException
    //   428	430	470	java/io/FileNotFoundException
    //   430	470	470	java/io/FileNotFoundException
  }
  
  public View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    paramContext = H.inflate(F, paramViewGroup, false);
    paramContext.setTag(new r0.a(paramContext));
    ((ImageView)paramContext.findViewById(R.id.edit_query)).setImageResource(M);
    return paramContext;
  }
  
  public void a(Cursor paramCursor)
  {
    if (N)
    {
      Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
      if (paramCursor != null) {
        paramCursor.close();
      }
      return;
    }
    try
    {
      super.a(paramCursor);
      if (paramCursor != null)
      {
        Q = paramCursor.getColumnIndex("suggest_text_1");
        R = paramCursor.getColumnIndex("suggest_text_2");
        S = paramCursor.getColumnIndex("suggest_text_2_url");
        T = paramCursor.getColumnIndex("suggest_icon_1");
        U = paramCursor.getColumnIndex("suggest_icon_2");
        V = paramCursor.getColumnIndex("suggest_flags");
      }
    }
    catch (Exception paramCursor)
    {
      Log.e("SuggestionsAdapter", "error changing cursor and caching columns", paramCursor);
    }
  }
  
  public void a(View paramView, Context paramContext, Cursor paramCursor)
  {
    r0.a locala = (r0.a)paramView.getTag();
    int i = V;
    if (i != -1) {
      i = paramCursor.getInt(i);
    } else {
      i = 0;
    }
    if (a != null)
    {
      paramContext = a(paramCursor, Q);
      paramView = a;
      paramView.setText(paramContext);
      if (TextUtils.isEmpty(paramContext)) {
        paramView.setVisibility(8);
      } else {
        paramView.setVisibility(0);
      }
    }
    if (b != null)
    {
      paramContext = a(paramCursor, S);
      if (paramContext != null)
      {
        if (P == null)
        {
          paramView = new TypedValue();
          A.getTheme().resolveAttribute(R.attr.textColorSearchUrl, paramView, true);
          P = A.getResources().getColorStateList(resourceId);
        }
        paramView = new SpannableString(paramContext);
        paramView.setSpan(new TextAppearanceSpan(null, 0, 0, P, null), 0, paramContext.length(), 33);
      }
      else
      {
        paramView = a(paramCursor, R);
      }
      if (TextUtils.isEmpty(paramView))
      {
        paramContext = a;
        if (paramContext != null)
        {
          paramContext.setSingleLine(false);
          a.setMaxLines(2);
        }
      }
      else
      {
        paramContext = a;
        if (paramContext != null)
        {
          paramContext.setSingleLine(true);
          a.setMaxLines(1);
        }
      }
      paramContext = b;
      paramContext.setText(paramView);
      if (TextUtils.isEmpty(paramView)) {
        paramContext.setVisibility(8);
      } else {
        paramContext.setVisibility(0);
      }
    }
    ImageView localImageView = c;
    if (localImageView != null)
    {
      j = T;
      if (j == -1)
      {
        paramView = null;
      }
      else
      {
        paramView = a(paramCursor.getString(j));
        if (paramView == null)
        {
          ComponentName localComponentName = J.getSearchActivity();
          String str = localComponentName.flattenToShortString();
          if (L.containsKey(str))
          {
            paramView = (Drawable.ConstantState)L.get(str);
            if (paramView == null) {
              paramView = null;
            } else {
              paramView = paramView.newDrawable(K.getResources());
            }
          }
          else
          {
            paramContext = A.getPackageManager();
            try
            {
              paramView = paramContext.getActivityInfo(localComponentName, 128);
              j = paramView.getIconResource();
              if (j != 0)
              {
                paramContext = paramContext.getDrawable(localComponentName.getPackageName(), j, applicationInfo);
                paramView = paramContext;
                if (paramContext != null) {
                  break label511;
                }
                paramView = e.a.a.a.a.a("Invalid icon resource ", j, " for ");
                paramView.append(localComponentName.flattenToShortString());
                Log.w("SuggestionsAdapter", paramView.toString());
              }
            }
            catch (PackageManager.NameNotFoundException paramView)
            {
              Log.w("SuggestionsAdapter", paramView.toString());
            }
            paramView = null;
            label511:
            if (paramView == null) {
              paramContext = null;
            } else {
              paramContext = paramView.getConstantState();
            }
            L.put(str, paramContext);
          }
          if (paramView == null) {
            paramView = A.getPackageManager().getDefaultActivityIcon();
          }
        }
      }
      localImageView.setImageDrawable(paramView);
      if (paramView == null)
      {
        localImageView.setVisibility(4);
      }
      else
      {
        localImageView.setVisibility(0);
        paramView.setVisible(false, false);
        paramView.setVisible(true, false);
      }
    }
    paramContext = d;
    if (paramContext != null)
    {
      j = U;
      if (j == -1) {
        paramView = null;
      } else {
        paramView = a(paramCursor.getString(j));
      }
      paramContext.setImageDrawable(paramView);
      if (paramView == null)
      {
        paramContext.setVisibility(8);
      }
      else
      {
        paramContext.setVisibility(0);
        paramView.setVisible(false, false);
        paramView.setVisible(true, false);
      }
    }
    int j = O;
    if ((j != 2) && ((j != 1) || ((i & 0x1) == 0)))
    {
      e.setVisibility(8);
    }
    else
    {
      e.setVisibility(0);
      e.setTag(a.getText());
      e.setOnClickListener(this);
    }
  }
  
  public CharSequence b(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    String str = a(paramCursor, paramCursor.getColumnIndex("suggest_intent_query"));
    if (str != null) {
      return str;
    }
    if (J.shouldRewriteQueryFromData())
    {
      str = a(paramCursor, paramCursor.getColumnIndex("suggest_intent_data"));
      if (str != null) {
        return str;
      }
    }
    if (J.shouldRewriteQueryFromText())
    {
      paramCursor = a(paramCursor, paramCursor.getColumnIndex("suggest_text_1"));
      if (paramCursor != null) {
        return paramCursor;
      }
    }
    return null;
  }
  
  public final void c(Cursor paramCursor)
  {
    if (paramCursor != null) {
      paramCursor = paramCursor.getExtras();
    } else {
      paramCursor = null;
    }
    if ((paramCursor != null) && (paramCursor.getBoolean("in_progress"))) {}
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      View localView;
      if (x)
      {
        z.moveToPosition(paramInt);
        localView = paramView;
        if (paramView == null) {
          localView = H.inflate(G, paramViewGroup, false);
        }
        a(localView, A, z);
      }
      else
      {
        localView = null;
      }
      return localView;
    }
    catch (RuntimeException paramView)
    {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", paramView);
      paramViewGroup = H.inflate(G, paramViewGroup, false);
      if (paramViewGroup != null) {
        getTaga.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", paramView);
      paramViewGroup = a(A, z, paramViewGroup);
      if (paramViewGroup != null) {
        getTaga.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    c(z);
  }
  
  public void notifyDataSetInvalidated()
  {
    super.notifyDataSetInvalidated();
    c(z);
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof CharSequence)) {
      I.a((CharSequence)paramView);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.r0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */