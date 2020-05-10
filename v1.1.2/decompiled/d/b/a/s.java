package d.b.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Property;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.ActionMode.Callback;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.R.attr;
import androidx.core.R.styleable;
import androidx.fragment.R.anim;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.t;
import d.b.e.c1;
import d.b.e.y0;
import d.g.a.h.c.c;
import d.g.a.h.d.a;
import d.g.a.h.f;
import d.g.a.h.h;
import d.g.a.h.j;
import d.g.a.h.l;
import d.g.a.h.n;
import d.i.g.a.a;
import d.t.a.r;
import e.c.a.a.b.j.o;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class s
{
  public static Field a;
  public static boolean b;
  public static Class c;
  public static boolean d;
  public static Field e;
  public static boolean f;
  public static Field g;
  public static boolean h;
  public static Method i;
  public static boolean j;
  public static Method k;
  public static boolean l;
  public static Field m;
  public static boolean n;
  public static Method o;
  public static boolean p;
  public static Field q;
  public static boolean r;
  public static Method s;
  public static boolean t;
  
  public static float a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, float paramFloat)
  {
    if (!a(paramXmlPullParser, paramString)) {
      return paramFloat;
    }
    return paramTypedArray.getFloat(paramInt, paramFloat);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt >= 0) {
      return paramInt;
    }
    throw new IllegalArgumentException();
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    int i1 = Process.myPid();
    int i2 = Process.myUid();
    String str = paramContext.getPackageName();
    int i3 = paramContext.checkPermission(paramString, i1, i2);
    i1 = -1;
    if (i3 == -1)
    {
      i2 = i1;
    }
    else
    {
      if (Build.VERSION.SDK_INT >= 23) {
        paramString = AppOpsManager.permissionToOp(paramString);
      } else {
        paramString = null;
      }
      if (paramString == null) {}
      do
      {
        i2 = 0;
        break;
        Object localObject = str;
        if (str == null)
        {
          localObject = paramContext.getPackageManager().getPackagesForUid(i2);
          i2 = i1;
          if (localObject == null) {
            break;
          }
          if (localObject.length <= 0)
          {
            i2 = i1;
            break;
          }
          localObject = localObject[0];
        }
        if (Build.VERSION.SDK_INT >= 23) {
          i2 = ((AppOpsManager)paramContext.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(paramString, (String)localObject);
        } else {
          i2 = 1;
        }
      } while (i2 == 0);
      i2 = -2;
    }
    return i2;
  }
  
  public static int a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2)
  {
    if (!a(paramXmlPullParser, paramString)) {
      return paramInt2;
    }
    return paramTypedArray.getColor(paramInt1, paramInt2);
  }
  
  public static int a(Cursor paramCursor, String paramString)
  {
    int i1 = paramCursor.getColumnIndex(paramString);
    if (i1 >= 0) {
      return i1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("`");
    localStringBuilder.append(paramString);
    localStringBuilder.append("`");
    return paramCursor.getColumnIndexOrThrow(localStringBuilder.toString());
  }
  
  public static int a(Parcel paramParcel)
  {
    return j(paramParcel, 20293);
  }
  
  public static int a(RecyclerView.t paramt, r paramr, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean)
  {
    if ((paramLayoutManager.d() != 0) && (paramt.a() != 0) && (paramView1 != null) && (paramView2 != null))
    {
      if (!paramBoolean) {
        return Math.abs(paramLayoutManager.a(paramView1) - paramLayoutManager.a(paramView2)) + 1;
      }
      int i1 = paramr.a(paramView2);
      int i2 = paramr.b(paramView1);
      return Math.min(paramr.c(), i1 - i2);
    }
    return 0;
  }
  
  public static int a(RecyclerView.t paramt, r paramr, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramLayoutManager.d() != 0) && (paramt.a() != 0) && (paramView1 != null) && (paramView2 != null))
    {
      int i1 = Math.min(paramLayoutManager.a(paramView1), paramLayoutManager.a(paramView2));
      int i2 = Math.max(paramLayoutManager.a(paramView1), paramLayoutManager.a(paramView2));
      if (paramBoolean2) {
        i2 = Math.max(0, paramt.a() - i2 - 1);
      } else {
        i2 = Math.max(0, i1);
      }
      if (!paramBoolean1) {
        return i2;
      }
      i1 = Math.abs(paramr.a(paramView2) - paramr.b(paramView1));
      int i3 = Math.abs(paramLayoutManager.a(paramView1) - paramLayoutManager.a(paramView2));
      float f1 = i1 / (i3 + 1);
      return Math.round(i2 * f1 + (paramr.b() - paramr.b(paramView1)));
    }
    return 0;
  }
  
  public static int a(d.g.a.h.d paramd)
  {
    float f1;
    int i1;
    if (paramd.e() == d.a.MATCH_CONSTRAINT)
    {
      if (H == 0) {
        f1 = paramd.d() * G;
      } else {
        f1 = paramd.d() / G;
      }
      i1 = (int)f1;
      paramd.f(i1);
    }
    else if (paramd.h() == d.a.MATCH_CONSTRAINT)
    {
      if (H == 1) {
        f1 = paramd.i() * G;
      } else {
        f1 = paramd.i() / G;
      }
      i1 = (int)f1;
      paramd.e(i1);
    }
    else
    {
      i1 = -1;
    }
    return i1;
  }
  
  public static int a(d.g.a.h.d paramd, int paramInt)
  {
    int i1 = paramInt * 2;
    Object localObject1 = A;
    Object localObject2 = localObject1[i1];
    localObject1 = localObject1[(i1 + 1)];
    Object localObject3 = d;
    if (localObject3 != null)
    {
      Object localObject4 = b;
      localObject3 = D;
      if (localObject4 == localObject3)
      {
        localObject4 = d;
        if ((localObject4 != null) && (b == localObject3))
        {
          i1 = ((d.g.a.h.d)localObject3).c(paramInt);
          float f1;
          if (paramInt == 0) {
            f1 = V;
          } else {
            f1 = W;
          }
          paramInt = paramd.c(paramInt);
          return (int)((i1 - ((d.g.a.h.c)localObject2).a() - ((d.g.a.h.c)localObject1).a() - paramInt) * f1);
        }
      }
    }
    return 0;
  }
  
  public static int a(d.g.a.h.d paramd, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    boolean bool = b0;
    int i1 = 0;
    if (!bool) {
      return 0;
    }
    if ((w.d != null) && (paramInt1 == 1)) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i5;
    int i6;
    if (paramBoolean)
    {
      i3 = Q;
      i4 = paramd.d() - Q;
      i5 = paramInt1 * 2;
      i6 = i5 + 1;
    }
    else
    {
      i6 = paramd.d();
      i4 = Q;
      i3 = i6 - i4;
      i6 = paramInt1 * 2;
      i5 = i6 + 1;
    }
    Object localObject1 = A;
    int i8;
    if ((d != null) && (d == null))
    {
      i7 = -1;
      i8 = i5;
      i5 = i6;
      i6 = i8;
      i8 = i7;
    }
    else
    {
      i8 = 1;
    }
    if (i2 != 0) {
      paramInt2 -= i3;
    }
    int i7 = A[i5].a();
    int i9 = a(paramd, paramInt1) + i7 * i8;
    i7 = paramInt2 + i9;
    if (paramInt1 == 0) {
      paramInt2 = paramd.i();
    } else {
      paramInt2 = paramd.d();
    }
    int i10 = paramInt2 * i8;
    localObject1 = A[i5].a.a.iterator();
    for (paramInt2 = i1; ((Iterator)localObject1).hasNext(); paramInt2 = Math.max(paramInt2, a(nextc.b, paramInt1, paramBoolean, i7))) {}
    localObject1 = A[i6].a.a.iterator();
    for (i1 = 0; ((Iterator)localObject1).hasNext(); i1 = Math.max(i1, a(nextc.b, paramInt1, paramBoolean, i10 + i7))) {}
    int i11;
    if (i2 != 0)
    {
      i11 = paramInt2 - i3;
      i1 += i4;
    }
    for (;;)
    {
      break;
      if (paramInt1 == 0) {
        i11 = paramd.i();
      } else {
        i11 = paramd.d();
      }
      i1 += i11 * i8;
      i11 = paramInt2;
    }
    Object localObject2;
    if (paramInt1 == 1)
    {
      localObject1 = w.a.a.iterator();
      paramInt2 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (j)((Iterator)localObject1).next();
        if (i8 == 1) {
          paramInt2 = Math.max(paramInt2, a(c.b, paramInt1, paramBoolean, i3 + i7));
        } else {
          paramInt2 = Math.max(paramInt2, a(c.b, paramInt1, paramBoolean, i4 * i8 + i7));
        }
      }
      if ((w.a.a.size() > 0) && (i2 == 0)) {
        if (i8 == 1) {
          paramInt2 += i3;
        } else {
          paramInt2 -= i4;
        }
      }
    }
    else
    {
      paramInt2 = 0;
    }
    int i4 = Math.max(i11, Math.max(i1, paramInt2));
    int i2 = i10 + i7;
    int i3 = i7;
    paramInt2 = i2;
    if (i8 == -1)
    {
      paramInt2 = i7;
      i3 = i2;
    }
    if (paramBoolean)
    {
      d.g.a.h.i.a(paramd, paramInt1, i3);
      paramd.a(i3, paramInt2, paramInt1);
    }
    else
    {
      p.a(paramd, paramInt1);
      if (paramInt1 == 0) {
        K = i3;
      } else if (paramInt1 == 1) {
        L = i3;
      }
    }
    if ((paramd.b(paramInt1) == d.a.MATCH_CONSTRAINT) && (G != 0.0F)) {
      p.a(paramd, paramInt1);
    }
    localObject1 = A;
    if ((d != null) && (d != null))
    {
      localObject2 = D;
      if ((d.b == localObject2) && (d.b == localObject2)) {
        p.a(paramd, paramInt1);
      }
    }
    return i4 + i9;
  }
  
  public static int a(f paramf, int paramInt)
  {
    int i1 = paramInt * 2;
    List localList = null;
    if (paramf != null)
    {
      if (paramInt == 0) {
        localList = f;
      } else if (paramInt == 1) {
        localList = g;
      }
      int i2 = localList.size();
      int i3 = 0;
      int i4 = 0;
      while (i3 < i2)
      {
        d.g.a.h.d locald = (d.g.a.h.d)localList.get(i3);
        d.g.a.h.c[] arrayOfc = A;
        int i5 = i1 + 1;
        boolean bool;
        if ((d != null) && ((d == null) || (d == null))) {
          bool = false;
        } else {
          bool = true;
        }
        i4 = Math.max(i4, a(locald, paramInt, bool, 0));
        i3++;
      }
      e[paramInt] = i4;
      return i4;
    }
    throw null;
  }
  
  public static Animator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, AnimatorSet paramAnimatorSet, int paramInt, float paramFloat)
  {
    int i1 = paramXmlPullParser.getDepth();
    Object localObject1 = null;
    Object localObject2 = null;
    for (;;)
    {
      int i2 = paramXmlPullParser.next();
      int i3 = 3;
      int i4 = 0;
      if (((i2 == 3) && (paramXmlPullParser.getDepth() <= i1)) || (i2 == 1)) {
        break label1454;
      }
      if (i2 == 2)
      {
        Object localObject3 = paramXmlPullParser.getName();
        Object localObject4;
        if (((String)localObject3).equals("objectAnimator"))
        {
          localObject4 = new ObjectAnimator();
          a(paramContext, paramResources, paramTheme, paramAttributeSet, (ValueAnimator)localObject4, paramFloat, paramXmlPullParser);
        }
        else
        {
          if (!((String)localObject3).equals("animator")) {
            break label133;
          }
          localObject4 = a(paramContext, paramResources, paramTheme, paramAttributeSet, null, paramFloat, paramXmlPullParser);
        }
        break label1369;
        label133:
        if (((String)localObject3).equals("set"))
        {
          localObject4 = new AnimatorSet();
          localObject3 = a(paramResources, paramTheme, paramAttributeSet, d.y.a.a.a.h);
          a(paramContext, paramResources, paramTheme, paramXmlPullParser, paramAttributeSet, (AnimatorSet)localObject4, b((TypedArray)localObject3, paramXmlPullParser, "ordering", 0, 0), paramFloat);
          ((TypedArray)localObject3).recycle();
        }
        else
        {
          localObject4 = "propertyValuesHolder";
          if (!((String)localObject3).equals("propertyValuesHolder")) {
            break;
          }
          AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
          localObject3 = null;
          i4 = i3;
          Object localObject5;
          for (;;)
          {
            i3 = paramXmlPullParser.getEventType();
            if ((i3 == i4) || (i3 == 1)) {
              break;
            }
            if (i3 != 2)
            {
              paramXmlPullParser.next();
            }
            else
            {
              if (paramXmlPullParser.getName().equals(localObject4))
              {
                TypedArray localTypedArray1 = a(paramResources, paramTheme, localAttributeSet, d.y.a.a.a.i);
                String str = a(localTypedArray1, paramXmlPullParser, "propertyName", i4);
                int i5 = b(localTypedArray1, paramXmlPullParser, "valueType", 2, 4);
                localObject5 = null;
                i2 = i5;
                Object localObject6 = localObject4;
                i3 = i4;
                Object localObject7;
                float f1;
                for (;;)
                {
                  localObject7 = paramTheme;
                  Resources localResources = paramResources;
                  i4 = paramXmlPullParser.next();
                  if ((i4 == i3) || (i4 == 1)) {
                    break;
                  }
                  if (paramXmlPullParser.getName().equals("keyframe"))
                  {
                    i4 = i2;
                    if (i2 == 4)
                    {
                      TypedArray localTypedArray2 = a(localResources, (Resources.Theme)localObject7, Xml.asAttributeSet(paramXmlPullParser), d.y.a.a.a.j);
                      if (!a(paramXmlPullParser, "value")) {
                        localObject4 = null;
                      } else {
                        localObject4 = localTypedArray2.peekValue(0);
                      }
                      if (localObject4 != null) {
                        i4 = 1;
                      } else {
                        i4 = 0;
                      }
                      if ((i4 != 0) && (b(type))) {
                        i4 = 3;
                      } else {
                        i4 = 0;
                      }
                      localTypedArray2.recycle();
                    }
                    localObject7 = a(localResources, (Resources.Theme)localObject7, Xml.asAttributeSet(paramXmlPullParser), d.y.a.a.a.j);
                    f1 = a((TypedArray)localObject7, paramXmlPullParser, "fraction", 3, -1.0F);
                    if (!a(paramXmlPullParser, "value")) {
                      localObject4 = null;
                    } else {
                      localObject4 = ((TypedArray)localObject7).peekValue(0);
                    }
                    if (localObject4 != null) {
                      i2 = 1;
                    } else {
                      i2 = 0;
                    }
                    if (i4 == 4)
                    {
                      if ((i2 != 0) && (b(type))) {
                        i3 = 3;
                      } else {
                        i3 = 0;
                      }
                    }
                    else {
                      i3 = i4;
                    }
                    if (i2 != 0)
                    {
                      if (i3 != 0)
                      {
                        if ((i3 != 1) && (i3 != 3)) {
                          localObject4 = null;
                        } else {
                          localObject4 = Keyframe.ofInt(f1, b((TypedArray)localObject7, paramXmlPullParser, "value", 0, 0));
                        }
                      }
                      else {
                        localObject4 = Keyframe.ofFloat(f1, a((TypedArray)localObject7, paramXmlPullParser, "value", 0, 0.0F));
                      }
                    }
                    else if (i3 == 0) {
                      localObject4 = Keyframe.ofFloat(f1);
                    } else {
                      localObject4 = Keyframe.ofInt(f1);
                    }
                    if (!a(paramXmlPullParser, "interpolator")) {
                      i3 = 0;
                    } else {
                      i3 = ((TypedArray)localObject7).getResourceId(1, 0);
                    }
                    if (i3 > 0) {
                      ((Keyframe)localObject4).setInterpolator(AnimationUtils.loadInterpolator(paramContext, i3));
                    }
                    ((TypedArray)localObject7).recycle();
                    localObject7 = localObject5;
                    if (localObject4 != null)
                    {
                      localObject7 = localObject5;
                      if (localObject5 == null) {
                        localObject7 = new ArrayList();
                      }
                      ((ArrayList)localObject7).add(localObject4);
                    }
                    paramXmlPullParser.next();
                    i3 = 3;
                    localObject5 = localObject7;
                    i2 = i4;
                  }
                }
                int i6 = i1;
                if (localObject5 != null)
                {
                  i4 = ((ArrayList)localObject5).size();
                  if (i4 > 0)
                  {
                    localObject4 = (Keyframe)((ArrayList)localObject5).get(0);
                    localObject7 = (Keyframe)((ArrayList)localObject5).get(i4 - 1);
                    f1 = ((Keyframe)localObject7).getFraction();
                    i1 = i4;
                    if (f1 < 1.0F) {
                      if (f1 < 0.0F)
                      {
                        ((Keyframe)localObject7).setFraction(1.0F);
                        i1 = i4;
                      }
                      else
                      {
                        ((ArrayList)localObject5).add(((ArrayList)localObject5).size(), a((Keyframe)localObject7, 1.0F));
                        i1 = i4 + 1;
                      }
                    }
                    f1 = ((Keyframe)localObject4).getFraction();
                    i4 = i1;
                    if (f1 != 0.0F) {
                      if (f1 < 0.0F)
                      {
                        ((Keyframe)localObject4).setFraction(0.0F);
                        i4 = i1;
                      }
                      else
                      {
                        ((ArrayList)localObject5).add(0, a((Keyframe)localObject4, 0.0F));
                        i4 = i1 + 1;
                      }
                    }
                    localObject4 = new Keyframe[i4];
                    ((ArrayList)localObject5).toArray((Object[])localObject4);
                    i1 = 0;
                    while (i1 < i4)
                    {
                      localObject5 = localObject4[i1];
                      i3 = i4;
                      if (((Keyframe)localObject5).getFraction() < 0.0F) {
                        if (i1 == 0)
                        {
                          ((Keyframe)localObject5).setFraction(0.0F);
                          i3 = i4;
                        }
                        else
                        {
                          int i7 = i4 - 1;
                          if (i1 == i7)
                          {
                            ((Keyframe)localObject5).setFraction(1.0F);
                            i3 = i4;
                          }
                          else
                          {
                            i3 = i1 + 1;
                            int i8 = i1;
                            while ((i3 < i7) && (localObject4[i3].getFraction() < 0.0F))
                            {
                              i8 = i3;
                              i3++;
                            }
                            f1 = (localObject4[(i8 + 1)].getFraction() - localObject4[(i1 - 1)].getFraction()) / (i8 - i1 + 2);
                            for (i7 = i1;; i7++)
                            {
                              i3 = i4;
                              if (i7 > i8) {
                                break;
                              }
                              localObject4[i7].setFraction(localObject4[(i7 - 1)].getFraction() + f1);
                            }
                          }
                        }
                      }
                      i1++;
                      i4 = i3;
                    }
                    localObject5 = PropertyValuesHolder.ofKeyframe(str, (Keyframe[])localObject4);
                    localObject4 = localObject5;
                    if (i2 != 3) {
                      break label1187;
                    }
                    ((PropertyValuesHolder)localObject5).setEvaluator(d.y.a.a.e.a);
                    localObject4 = localObject5;
                    break label1187;
                  }
                }
                localObject4 = null;
                label1187:
                i4 = 3;
                localObject5 = localObject4;
                if (localObject4 == null) {
                  localObject5 = a(localTypedArray1, i5, 0, 1, str);
                }
                localObject4 = localObject3;
                if (localObject5 != null)
                {
                  localObject4 = localObject3;
                  if (localObject3 == null) {
                    localObject4 = new ArrayList();
                  }
                  ((ArrayList)localObject4).add(localObject5);
                }
                localTypedArray1.recycle();
                localObject3 = localObject4;
                localObject4 = localObject6;
                i1 = i6;
              }
              paramXmlPullParser.next();
            }
          }
          if (localObject3 != null)
          {
            i3 = ((ArrayList)localObject3).size();
            localObject5 = new PropertyValuesHolder[i3];
            for (i4 = 0;; i4++)
            {
              localObject4 = localObject5;
              if (i4 >= i3) {
                break;
              }
              localObject5[i4] = ((PropertyValuesHolder)((ArrayList)localObject3).get(i4));
            }
          }
          localObject4 = null;
          if ((localObject4 != null) && (localObject1 != null) && ((localObject1 instanceof ValueAnimator))) {
            ((ValueAnimator)localObject1).setValues((PropertyValuesHolder[])localObject4);
          }
          i4 = 1;
          localObject4 = localObject1;
        }
        label1369:
        localObject3 = localObject2;
        if (paramAnimatorSet != null)
        {
          localObject3 = localObject2;
          if (i4 == 0)
          {
            localObject3 = localObject2;
            if (localObject2 == null) {
              localObject3 = new ArrayList();
            }
            ((ArrayList)localObject3).add(localObject4);
          }
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
      }
    }
    paramContext = e.a.a.a.a.a("Unknown animator name: ");
    paramContext.append(paramXmlPullParser.getName());
    throw new RuntimeException(paramContext.toString());
    label1454:
    if ((paramAnimatorSet != null) && (localObject2 != null))
    {
      paramContext = new Animator[((ArrayList)localObject2).size()];
      paramResources = ((ArrayList)localObject2).iterator();
      for (i1 = 0; paramResources.hasNext(); i1++) {
        paramContext[i1] = ((Animator)paramResources.next());
      }
      if (paramInt == 0) {
        paramAnimatorSet.playTogether(paramContext);
      } else {
        paramAnimatorSet.playSequentially(paramContext);
      }
    }
    return (Animator)localObject1;
  }
  
  public static Keyframe a(Keyframe paramKeyframe, float paramFloat)
  {
    if (paramKeyframe.getType() == Float.TYPE) {
      paramKeyframe = Keyframe.ofFloat(paramFloat);
    } else if (paramKeyframe.getType() == Integer.TYPE) {
      paramKeyframe = Keyframe.ofInt(paramFloat);
    } else {
      paramKeyframe = Keyframe.ofObject(paramFloat);
    }
    return paramKeyframe;
  }
  
  public static <T> ObjectAnimator a(T paramT, Property<T, PointF> paramProperty, Path paramPath)
  {
    return ObjectAnimator.ofObject(paramT, paramProperty, null, paramPath);
  }
  
  public static PropertyValuesHolder a(TypedArray paramTypedArray, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject1 = paramTypedArray.peekValue(paramInt2);
    int i1;
    if (localObject1 != null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (i1 != 0) {
      i2 = type;
    } else {
      i2 = 0;
    }
    localObject1 = paramTypedArray.peekValue(paramInt3);
    int i3;
    if (localObject1 != null) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    int i4;
    if (i3 != 0) {
      i4 = type;
    } else {
      i4 = 0;
    }
    int i5 = paramInt1;
    if (paramInt1 == 4) {
      if (((i1 != 0) && (b(i2))) || ((i3 != 0) && (b(i4)))) {
        i5 = 3;
      } else {
        i5 = 0;
      }
    }
    if (i5 == 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    localObject1 = null;
    String str = null;
    Object localObject2;
    if (i5 == 2)
    {
      localObject2 = paramTypedArray.getString(paramInt2);
      str = paramTypedArray.getString(paramInt3);
      d.i.c.b[] arrayOfb1 = b((String)localObject2);
      d.i.c.b[] arrayOfb2 = b(str);
      if (arrayOfb1 == null)
      {
        paramTypedArray = (TypedArray)localObject1;
        if (arrayOfb2 == null) {}
      }
      else if (arrayOfb1 != null)
      {
        paramTypedArray = new d.y.a.a.d();
        if (arrayOfb2 != null)
        {
          if (a(arrayOfb1, arrayOfb2))
          {
            paramTypedArray = PropertyValuesHolder.ofObject(paramString, paramTypedArray, new Object[] { arrayOfb1, arrayOfb2 });
          }
          else
          {
            paramTypedArray = new StringBuilder();
            paramTypedArray.append(" Can't morph from ");
            paramTypedArray.append((String)localObject2);
            paramTypedArray.append(" to ");
            paramTypedArray.append(str);
            throw new InflateException(paramTypedArray.toString());
          }
        }
        else {
          paramTypedArray = PropertyValuesHolder.ofObject(paramString, paramTypedArray, new Object[] { arrayOfb1 });
        }
      }
      else
      {
        paramTypedArray = (TypedArray)localObject1;
        if (arrayOfb2 != null) {
          paramTypedArray = PropertyValuesHolder.ofObject(paramString, new d.y.a.a.d(), new Object[] { arrayOfb2 });
        }
      }
    }
    else
    {
      if (i5 == 3) {
        localObject2 = d.y.a.a.e.a;
      } else {
        localObject2 = null;
      }
      if (paramInt1 != 0)
      {
        float f1;
        if (i1 != 0)
        {
          if (i2 == 5) {
            f1 = paramTypedArray.getDimension(paramInt2, 0.0F);
          } else {
            f1 = paramTypedArray.getFloat(paramInt2, 0.0F);
          }
          if (i3 != 0)
          {
            float f2;
            if (i4 == 5) {
              f2 = paramTypedArray.getDimension(paramInt3, 0.0F);
            } else {
              f2 = paramTypedArray.getFloat(paramInt3, 0.0F);
            }
            paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1, f2 });
          }
          else
          {
            paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1 });
          }
        }
        else
        {
          if (i4 == 5) {
            f1 = paramTypedArray.getDimension(paramInt3, 0.0F);
          } else {
            f1 = paramTypedArray.getFloat(paramInt3, 0.0F);
          }
          paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1 });
        }
      }
      else if (i1 != 0)
      {
        if (i2 == 5) {
          paramInt1 = (int)paramTypedArray.getDimension(paramInt2, 0.0F);
        } else if (b(i2)) {
          paramInt1 = paramTypedArray.getColor(paramInt2, 0);
        } else {
          paramInt1 = paramTypedArray.getInt(paramInt2, 0);
        }
        if (i3 != 0)
        {
          if (i4 == 5) {
            paramInt2 = (int)paramTypedArray.getDimension(paramInt3, 0.0F);
          } else if (b(i4)) {
            paramInt2 = paramTypedArray.getColor(paramInt3, 0);
          } else {
            paramInt2 = paramTypedArray.getInt(paramInt3, 0);
          }
          paramTypedArray = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1, paramInt2 });
        }
        else
        {
          paramTypedArray = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1 });
        }
      }
      else
      {
        localObject1 = str;
        if (i3 == 0) {
          break label699;
        }
        if (i4 == 5) {
          paramInt1 = (int)paramTypedArray.getDimension(paramInt3, 0.0F);
        } else if (b(i4)) {
          paramInt1 = paramTypedArray.getColor(paramInt3, 0);
        } else {
          paramInt1 = paramTypedArray.getInt(paramInt3, 0);
        }
        paramTypedArray = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1 });
      }
      localObject1 = paramTypedArray;
      label699:
      paramTypedArray = (TypedArray)localObject1;
      if (localObject1 != null)
      {
        paramTypedArray = (TypedArray)localObject1;
        if (localObject2 != null)
        {
          ((PropertyValuesHolder)localObject1).setEvaluator((TypeEvaluator)localObject2);
          paramTypedArray = (TypedArray)localObject1;
        }
      }
    }
    return paramTypedArray;
  }
  
  public static ValueAnimator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    TypedArray localTypedArray1 = a(paramResources, paramTheme, paramAttributeSet, d.y.a.a.a.g);
    TypedArray localTypedArray2 = a(paramResources, paramTheme, paramAttributeSet, d.y.a.a.a.k);
    if (paramValueAnimator == null) {
      paramResources = new ValueAnimator();
    } else {
      paramResources = paramValueAnimator;
    }
    long l1 = b(localTypedArray1, paramXmlPullParser, "duration", 1, 300);
    int i1 = 0;
    long l2 = b(localTypedArray1, paramXmlPullParser, "startOffset", 2, 0);
    int i2 = b(localTypedArray1, paramXmlPullParser, "valueType", 7, 4);
    int i4;
    int i5;
    if ((a(paramXmlPullParser, "valueFrom")) && (a(paramXmlPullParser, "valueTo")))
    {
      i3 = i2;
      if (i2 == 4)
      {
        paramTheme = localTypedArray1.peekValue(5);
        if (paramTheme != null) {
          i3 = 1;
        } else {
          i3 = 0;
        }
        if (i3 != 0) {
          i2 = type;
        } else {
          i2 = 0;
        }
        paramTheme = localTypedArray1.peekValue(6);
        if (paramTheme != null) {
          i4 = 1;
        } else {
          i4 = 0;
        }
        if (i4 != 0) {
          i5 = type;
        } else {
          i5 = 0;
        }
        if (((i3 != 0) && (b(i2))) || ((i4 != 0) && (b(i5)))) {
          i3 = 3;
        } else {
          i3 = 0;
        }
      }
      paramTheme = a(localTypedArray1, i3, 5, 6, "");
      if (paramTheme != null) {
        paramResources.setValues(new PropertyValuesHolder[] { paramTheme });
      }
    }
    paramResources.setDuration(l1);
    paramResources.setStartDelay(l2);
    paramResources.setRepeatCount(b(localTypedArray1, paramXmlPullParser, "repeatCount", 3, 0));
    paramResources.setRepeatMode(b(localTypedArray1, paramXmlPullParser, "repeatMode", 4, 1));
    if (localTypedArray2 != null)
    {
      paramValueAnimator = (ObjectAnimator)paramResources;
      paramAttributeSet = a(localTypedArray2, paramXmlPullParser, "pathData", 1);
      if (paramAttributeSet != null)
      {
        paramTheme = a(localTypedArray2, paramXmlPullParser, "propertyXName", 2);
        String str = a(localTypedArray2, paramXmlPullParser, "propertyYName", 3);
        if ((paramTheme == null) && (str == null))
        {
          paramContext = new StringBuilder();
          paramContext.append(localTypedArray2.getPositionDescription());
          paramContext.append(" propertyXName or propertyYName is needed for PathData");
          throw new InflateException(paramContext.toString());
        }
        Object localObject = c(paramAttributeSet);
        paramAttributeSet = new PathMeasure((Path)localObject, false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Float.valueOf(0.0F));
        float f1 = 0.0F;
        for (;;)
        {
          f1 += paramAttributeSet.getLength();
          localArrayList.add(Float.valueOf(f1));
          if (!paramAttributeSet.nextContour())
          {
            PathMeasure localPathMeasure = new PathMeasure((Path)localObject, false);
            i3 = Math.min(100, (int)(f1 / (0.5F * paramFloat)) + 1);
            float[] arrayOfFloat1 = new float[i3];
            localObject = new float[i3];
            float[] arrayOfFloat2 = new float[2];
            f1 /= (i3 - 1);
            i5 = 0;
            paramFloat = 0.0F;
            i2 = i1;
            for (;;)
            {
              paramAttributeSet = null;
              if (i2 >= i3) {
                break;
              }
              localPathMeasure.getPosTan(paramFloat - ((Float)localArrayList.get(i5)).floatValue(), arrayOfFloat2, null);
              arrayOfFloat1[i2] = arrayOfFloat2[0];
              localObject[i2] = arrayOfFloat2[1];
              paramFloat += f1;
              i1 = i5 + 1;
              i4 = i5;
              if (i1 < localArrayList.size())
              {
                i4 = i5;
                if (paramFloat > ((Float)localArrayList.get(i1)).floatValue())
                {
                  localPathMeasure.nextContour();
                  i4 = i1;
                }
              }
              i2++;
              i5 = i4;
            }
            if (paramTheme != null) {
              paramTheme = PropertyValuesHolder.ofFloat(paramTheme, arrayOfFloat1);
            } else {
              paramTheme = null;
            }
            if (str != null) {
              paramAttributeSet = PropertyValuesHolder.ofFloat(str, (float[])localObject);
            }
            if (paramTheme == null)
            {
              paramValueAnimator.setValues(new PropertyValuesHolder[] { paramAttributeSet });
              break;
            }
            if (paramAttributeSet == null)
            {
              paramValueAnimator.setValues(new PropertyValuesHolder[] { paramTheme });
              break;
            }
            paramValueAnimator.setValues(new PropertyValuesHolder[] { paramTheme, paramAttributeSet });
            break;
          }
        }
      }
      paramValueAnimator.setPropertyName(a(localTypedArray2, paramXmlPullParser, "propertyName", 0));
    }
    int i3 = 0;
    if (a(paramXmlPullParser, "interpolator")) {
      i3 = localTypedArray1.getResourceId(0, 0);
    }
    if (i3 > 0) {
      paramResources.setInterpolator(AnimationUtils.loadInterpolator(paramContext, i3));
    }
    localTypedArray1.recycle();
    if (localTypedArray2 != null) {
      localTypedArray2.recycle();
    }
    return paramResources;
  }
  
  /* Error */
  public static Intent a(Activity paramActivity)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 637	android/app/Activity:getParentActivityIntent	()Landroid/content/Intent;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +5 -> 11
    //   9: aload_1
    //   10: areturn
    //   11: aload_0
    //   12: aload_0
    //   13: invokevirtual 641	android/app/Activity:getComponentName	()Landroid/content/ComponentName;
    //   16: invokestatic 644	d/b/a/s:b	(Landroid/content/Context;Landroid/content/ComponentName;)Ljava/lang/String;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnonnull +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: new 646	android/content/ComponentName
    //   29: dup
    //   30: aload_0
    //   31: aload_1
    //   32: invokespecial 649	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   35: astore_2
    //   36: aload_0
    //   37: aload_2
    //   38: invokestatic 644	d/b/a/s:b	(Landroid/content/Context;Landroid/content/ComponentName;)Ljava/lang/String;
    //   41: ifnonnull +11 -> 52
    //   44: aload_2
    //   45: invokestatic 655	android/content/Intent:makeMainActivity	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   48: astore_0
    //   49: goto +17 -> 66
    //   52: new 651	android/content/Intent
    //   55: astore_0
    //   56: aload_0
    //   57: invokespecial 656	android/content/Intent:<init>	()V
    //   60: aload_0
    //   61: aload_2
    //   62: invokevirtual 659	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   65: astore_0
    //   66: aload_0
    //   67: areturn
    //   68: astore_0
    //   69: new 111	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   76: astore_0
    //   77: aload_0
    //   78: ldc_w 661
    //   81: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_0
    //   86: aload_1
    //   87: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_0
    //   92: ldc_w 663
    //   95: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: ldc_w 665
    //   102: aload_0
    //   103: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 669	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   109: pop
    //   110: aconst_null
    //   111: areturn
    //   112: astore_0
    //   113: new 42	java/lang/IllegalArgumentException
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 672	java/lang/IllegalArgumentException:<init>	(Ljava/lang/Throwable;)V
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramActivity	Activity
    //   4	83	1	localObject	Object
    //   35	27	2	localComponentName	ComponentName
    // Exception table:
    //   from	to	target	type
    //   36	49	68	android/content/pm/PackageManager$NameNotFoundException
    //   52	66	68	android/content/pm/PackageManager$NameNotFoundException
    //   11	20	112	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public static Intent a(Context paramContext, ComponentName paramComponentName)
  {
    String str = b(paramContext, paramComponentName);
    if (str == null) {
      return null;
    }
    paramComponentName = new ComponentName(paramComponentName.getPackageName(), str);
    if (b(paramContext, paramComponentName) == null) {
      paramContext = Intent.makeMainActivity(paramComponentName);
    } else {
      paramContext = new Intent().setComponent(paramComponentName);
    }
    return paramContext;
  }
  
  public static ColorStateList a(Resources paramResources, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
  {
    AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
    int i1;
    do
    {
      i1 = paramXmlPullParser.next();
    } while ((i1 != 2) && (i1 != 1));
    if (i1 == 2) {
      return a(paramResources, paramXmlPullParser, localAttributeSet, paramTheme);
    }
    throw new XmlPullParserException("No start tag found");
  }
  
  public static ColorStateList a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    Object localObject1 = paramXmlPullParser.getName();
    if (((String)localObject1).equals("selector"))
    {
      int i1 = paramXmlPullParser.getDepth() + 1;
      localObject1 = new int[20][];
      Object localObject2 = new int[20];
      int i2 = 0;
      for (;;)
      {
        int i3 = paramXmlPullParser.next();
        if (i3 == 1) {
          break;
        }
        int i4 = paramXmlPullParser.getDepth();
        if ((i4 < i1) && (i3 == 3)) {
          break;
        }
        if ((i3 == 2) && (i4 <= i1) && (paramXmlPullParser.getName().equals("item")))
        {
          Object localObject3 = R.styleable.ColorStateListItem;
          if (paramTheme == null) {
            localObject3 = paramResources.obtainAttributes(paramAttributeSet, (int[])localObject3);
          } else {
            localObject3 = paramTheme.obtainStyledAttributes(paramAttributeSet, (int[])localObject3, 0, 0);
          }
          int i5 = ((TypedArray)localObject3).getColor(R.styleable.ColorStateListItem_android_color, -65281);
          float f1 = 1.0F;
          if (((TypedArray)localObject3).hasValue(R.styleable.ColorStateListItem_android_alpha)) {
            f1 = ((TypedArray)localObject3).getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0F);
          } else if (((TypedArray)localObject3).hasValue(R.styleable.ColorStateListItem_alpha)) {
            f1 = ((TypedArray)localObject3).getFloat(R.styleable.ColorStateListItem_alpha, 1.0F);
          }
          ((TypedArray)localObject3).recycle();
          int i6 = paramAttributeSet.getAttributeCount();
          localObject3 = new int[i6];
          i3 = 0;
          for (i4 = 0; i3 < i6; i4 = i8)
          {
            i7 = paramAttributeSet.getAttributeNameResource(i3);
            i8 = i4;
            if (i7 != 16843173)
            {
              i8 = i4;
              if (i7 != 16843551)
              {
                i8 = i4;
                if (i7 != R.attr.alpha)
                {
                  if (paramAttributeSet.getAttributeBooleanValue(i3, false)) {
                    i8 = i7;
                  } else {
                    i8 = -i7;
                  }
                  localObject3[i4] = i8;
                  i8 = i4 + 1;
                }
              }
            }
            i3++;
          }
          int[] arrayOfInt = StateSet.trimStateSet((int[])localObject3, i4);
          int i7 = Math.round(Color.alpha(i5) * f1);
          i4 = i2 + 1;
          i3 = localObject2.length;
          int i8 = 8;
          localObject3 = localObject2;
          if (i4 > i3)
          {
            if (i2 <= 4) {
              i3 = 8;
            } else {
              i3 = i2 * 2;
            }
            localObject3 = new int[i3];
            System.arraycopy(localObject2, 0, localObject3, 0, i2);
          }
          localObject3[i2] = (i7 << 24 | i5 & 0xFFFFFF);
          localObject2 = localObject1;
          if (i4 > localObject1.length)
          {
            localObject2 = localObject1.getClass().getComponentType();
            if (i2 <= 4) {
              i3 = i8;
            } else {
              i3 = i2 * 2;
            }
            localObject2 = (Object[])Array.newInstance((Class)localObject2, i3);
            System.arraycopy(localObject1, 0, localObject2, 0, i2);
          }
          localObject2[i2] = arrayOfInt;
          localObject1 = (int[][])localObject2;
          i2 = i4;
          localObject2 = localObject3;
        }
      }
      paramXmlPullParser = new int[i2];
      paramResources = new int[i2][];
      System.arraycopy(localObject2, 0, paramXmlPullParser, 0, i2);
      System.arraycopy(localObject1, 0, paramResources, 0, i2);
      return new ColorStateList(paramResources, paramXmlPullParser);
    }
    paramResources = new StringBuilder();
    paramResources.append(paramXmlPullParser.getPositionDescription());
    paramResources.append(": invalid color state list tag ");
    paramResources.append((String)localObject1);
    throw new XmlPullParserException(paramResources.toString());
  }
  
  public static TypedArray a(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    if (paramTheme == null) {
      return paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    }
    return paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
  }
  
  public static Drawable a(CompoundButton paramCompoundButton)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramCompoundButton.getButtonDrawable();
    }
    if (!n)
    {
      try
      {
        Field localField1 = CompoundButton.class.getDeclaredField("mButtonDrawable");
        m = localField1;
        localField1.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", localNoSuchFieldException);
      }
      n = true;
    }
    Field localField2 = m;
    if (localField2 != null) {
      try
      {
        paramCompoundButton = (Drawable)localField2.get(paramCompoundButton);
        return paramCompoundButton;
      }
      catch (IllegalAccessException paramCompoundButton)
      {
        Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", paramCompoundButton);
        m = null;
      }
    }
    return null;
  }
  
  public static Bundle a(Parcel paramParcel, int paramInt)
  {
    int i1 = h(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i1 == 0) {
      return null;
    }
    Bundle localBundle = paramParcel.readBundle();
    paramParcel.setDataPosition(paramInt + i1);
    return localBundle;
  }
  
  public static <T extends Parcelable> T a(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    paramInt = h(paramParcel, paramInt);
    int i1 = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    paramCreator = (Parcelable)paramCreator.createFromParcel(paramParcel);
    paramParcel.setDataPosition(i1 + paramInt);
    return paramCreator;
  }
  
  public static ActionMode.Callback a(TextView paramTextView, ActionMode.Callback paramCallback)
  {
    int i1 = Build.VERSION.SDK_INT;
    if ((i1 >= 26) && (i1 <= 27) && (!(paramCallback instanceof d.i.j.d))) {
      return new d.i.j.d(paramCallback, paramTextView);
    }
    return paramCallback;
  }
  
  public static InputConnection a(InputConnection paramInputConnection, EditorInfo paramEditorInfo, View paramView)
  {
    if ((paramInputConnection != null) && (hintText == null)) {
      for (paramView = paramView.getParent(); (paramView instanceof View); paramView = paramView.getParent()) {
        if ((paramView instanceof c1))
        {
          hintText = ((c1)paramView).a();
          break;
        }
      }
    }
    return paramInputConnection;
  }
  
  public static final NavController a(Activity paramActivity, int paramInt)
  {
    if (paramActivity != null)
    {
      Object localObject = a(d.i.a.a.a(paramActivity, paramInt));
      if (localObject != null)
      {
        i.k.b.g.a(localObject, "Navigation.findNavController(this, viewId)");
        return (NavController)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Activity ");
      ((StringBuilder)localObject).append(paramActivity);
      ((StringBuilder)localObject).append(" does not have a NavController set on ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    i.k.b.g.a("$this$findNavController");
    throw null;
  }
  
  public static NavController a(View paramView)
  {
    while (paramView != null)
    {
      Object localObject = paramView.getTag(androidx.navigation.R.id.nav_controller_view_tag);
      if ((localObject instanceof WeakReference)) {
        localObject = (NavController)((WeakReference)localObject).get();
      } else if ((localObject instanceof NavController)) {
        localObject = (NavController)localObject;
      } else {
        localObject = null;
      }
      if (localObject != null) {
        return (NavController)localObject;
      }
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        paramView = (View)paramView;
      } else {
        paramView = null;
      }
    }
    return null;
  }
  
  public static d.i.b.b.a a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme, String paramString, int paramInt1, int paramInt2)
  {
    if (a(paramXmlPullParser, paramString))
    {
      paramXmlPullParser = new TypedValue();
      paramTypedArray.getValue(paramInt1, paramXmlPullParser);
      int i1 = type;
      if ((i1 >= 28) && (i1 <= 31)) {
        return new d.i.b.b.a(null, null, data);
      }
      paramXmlPullParser = paramTypedArray.getResources();
      paramInt1 = paramTypedArray.getResourceId(paramInt1, 0);
      try
      {
        paramTypedArray = d.i.b.b.a.a(paramXmlPullParser, paramInt1, paramTheme);
      }
      catch (Exception paramTypedArray)
      {
        Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", paramTypedArray);
        paramTypedArray = null;
      }
      if (paramTypedArray != null) {
        return paramTypedArray;
      }
    }
    return new d.i.b.b.a(null, null, paramInt2);
  }
  
  public static d.i.b.b.b a(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    int i1;
    do
    {
      i1 = paramXmlPullParser.next();
    } while ((i1 != 2) && (i1 != 1));
    if (i1 == 2)
    {
      Object localObject1 = null;
      paramXmlPullParser.require(2, null, "font-family");
      if (paramXmlPullParser.getName().equals("font-family"))
      {
        Object localObject2 = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.FontFamily);
        String str = ((TypedArray)localObject2).getString(R.styleable.FontFamily_fontProviderAuthority);
        Object localObject3 = ((TypedArray)localObject2).getString(R.styleable.FontFamily_fontProviderPackage);
        Object localObject4 = ((TypedArray)localObject2).getString(R.styleable.FontFamily_fontProviderQuery);
        int i2 = ((TypedArray)localObject2).getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int i3 = ((TypedArray)localObject2).getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        i1 = ((TypedArray)localObject2).getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        ((TypedArray)localObject2).recycle();
        if ((str != null) && (localObject3 != null) && (localObject4 != null))
        {
          while (paramXmlPullParser.next() != 3) {
            a(paramXmlPullParser);
          }
          paramXmlPullParser = new d.i.b.b.e(new d.i.f.a(str, (String)localObject3, (String)localObject4, a(paramResources, i2)), i3, i1);
        }
        else
        {
          localObject4 = new ArrayList();
          while (paramXmlPullParser.next() != 3) {
            if (paramXmlPullParser.getEventType() == 2) {
              if (paramXmlPullParser.getName().equals("font"))
              {
                localObject3 = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.FontFamilyFont);
                if (((TypedArray)localObject3).hasValue(R.styleable.FontFamilyFont_fontWeight)) {
                  i1 = R.styleable.FontFamilyFont_fontWeight;
                } else {
                  i1 = R.styleable.FontFamilyFont_android_fontWeight;
                }
                i2 = ((TypedArray)localObject3).getInt(i1, 400);
                if (((TypedArray)localObject3).hasValue(R.styleable.FontFamilyFont_fontStyle)) {
                  i1 = R.styleable.FontFamilyFont_fontStyle;
                } else {
                  i1 = R.styleable.FontFamilyFont_android_fontStyle;
                }
                boolean bool;
                if (1 == ((TypedArray)localObject3).getInt(i1, 0)) {
                  bool = true;
                } else {
                  bool = false;
                }
                if (((TypedArray)localObject3).hasValue(R.styleable.FontFamilyFont_ttcIndex)) {
                  i1 = R.styleable.FontFamilyFont_ttcIndex;
                } else {
                  i1 = R.styleable.FontFamilyFont_android_ttcIndex;
                }
                if (((TypedArray)localObject3).hasValue(R.styleable.FontFamilyFont_fontVariationSettings)) {
                  i3 = R.styleable.FontFamilyFont_fontVariationSettings;
                } else {
                  i3 = R.styleable.FontFamilyFont_android_fontVariationSettings;
                }
                str = ((TypedArray)localObject3).getString(i3);
                i3 = ((TypedArray)localObject3).getInt(i1, 0);
                if (((TypedArray)localObject3).hasValue(R.styleable.FontFamilyFont_font)) {
                  i1 = R.styleable.FontFamilyFont_font;
                } else {
                  i1 = R.styleable.FontFamilyFont_android_font;
                }
                int i4 = ((TypedArray)localObject3).getResourceId(i1, 0);
                localObject2 = ((TypedArray)localObject3).getString(i1);
                ((TypedArray)localObject3).recycle();
                while (paramXmlPullParser.next() != 3) {
                  a(paramXmlPullParser);
                }
                ((ArrayList)localObject4).add(new d.i.b.b.d((String)localObject2, i2, bool, str, i3, i4));
              }
              else
              {
                a(paramXmlPullParser);
              }
            }
          }
          if (((ArrayList)localObject4).isEmpty()) {
            paramXmlPullParser = (XmlPullParser)localObject1;
          } else {
            paramXmlPullParser = new d.i.b.b.c((d.i.b.b.d[])((ArrayList)localObject4).toArray(new d.i.b.b.d[((ArrayList)localObject4).size()]));
          }
        }
      }
      else
      {
        a(paramXmlPullParser);
        paramXmlPullParser = (XmlPullParser)localObject1;
      }
      return paramXmlPullParser;
    }
    throw new XmlPullParserException("No start tag found");
  }
  
  public static a.a a(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return new a.a(paramTextView.getTextMetricsParams());
    }
    TextPaint localTextPaint = new TextPaint(paramTextView.getPaint());
    int i1 = Build.VERSION.SDK_INT;
    int i2 = 0;
    int i3;
    if (i1 >= 23)
    {
      i3 = 1;
      i1 = 1;
    }
    else
    {
      i3 = 0;
      i1 = 0;
    }
    TextDirectionHeuristic localTextDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
    if (Build.VERSION.SDK_INT >= 23)
    {
      i3 = paramTextView.getBreakStrategy();
      i1 = paramTextView.getHyphenationFrequency();
    }
    if ((paramTextView.getTransformationMethod() instanceof PasswordTransformationMethod))
    {
      paramTextView = TextDirectionHeuristics.LTR;
    }
    else if ((Build.VERSION.SDK_INT >= 28) && ((paramTextView.getInputType() & 0xF) == 3))
    {
      i2 = Character.getDirectionality(android.icu.text.DecimalFormatSymbols.getInstance(paramTextView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
      if ((i2 != 1) && (i2 != 2)) {
        paramTextView = TextDirectionHeuristics.LTR;
      } else {
        paramTextView = TextDirectionHeuristics.RTL;
      }
    }
    else
    {
      if (paramTextView.getLayoutDirection() == 1) {
        i2 = 1;
      }
      switch (paramTextView.getTextDirection())
      {
      default: 
        if (i2 != 0) {
          paramTextView = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        }
        break;
      case 7: 
        paramTextView = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        break;
      case 6: 
        paramTextView = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        break;
      case 5: 
        paramTextView = TextDirectionHeuristics.LOCALE;
        break;
      case 4: 
        paramTextView = TextDirectionHeuristics.RTL;
        break;
      case 3: 
        paramTextView = TextDirectionHeuristics.LTR;
        break;
      case 2: 
        paramTextView = TextDirectionHeuristics.ANYRTL_LTR;
        break;
      }
      paramTextView = TextDirectionHeuristics.FIRSTSTRONG_LTR;
    }
    return new a.a(localTextPaint, paramTextView, i3, i1);
  }
  
  public static d.m.a.g a(Context paramContext, d.m.a.i parami, Fragment paramFragment, boolean paramBoolean)
  {
    int i1 = paramFragment.getNextTransition();
    int i2 = paramFragment.getNextAnim();
    int i3 = 0;
    paramFragment.setNextAnim(0);
    parami = parami.a(mContainerId);
    if ((parami != null) && (parami.getTag(androidx.fragment.R.id.visible_removing_fragment_view_tag) != null)) {
      parami.setTag(androidx.fragment.R.id.visible_removing_fragment_view_tag, null);
    }
    parami = mContainer;
    if ((parami != null) && (parami.getLayoutTransition() != null)) {
      return null;
    }
    parami = paramFragment.onCreateAnimation(i1, paramBoolean, i2);
    if (parami != null) {
      return new d.m.a.g(parami);
    }
    parami = paramFragment.onCreateAnimator(i1, paramBoolean, i2);
    if (parami != null) {
      return new d.m.a.g(parami);
    }
    int i4;
    if (i2 != 0)
    {
      boolean bool = "anim".equals(paramContext.getResources().getResourceTypeName(i2));
      i4 = i3;
      if (bool) {
        try
        {
          parami = AnimationUtils.loadAnimation(paramContext, i2);
          if (parami != null)
          {
            parami = new d.m.a.g(parami);
            return parami;
          }
          i4 = 1;
        }
        catch (RuntimeException parami)
        {
          i4 = i3;
        }
        catch (Resources.NotFoundException paramContext)
        {
          throw paramContext;
        }
      }
      if (i4 == 0) {
        try
        {
          parami = AnimatorInflater.loadAnimator(paramContext, i2);
          if (parami != null)
          {
            parami = new d.m.a.g(parami);
            return parami;
          }
        }
        catch (RuntimeException parami)
        {
          if (!bool)
          {
            parami = AnimationUtils.loadAnimation(paramContext, i2);
            if (parami != null) {
              return new d.m.a.g(parami);
            }
          }
          else
          {
            throw parami;
          }
        }
      }
    }
    if (i1 == 0) {
      return null;
    }
    if (i1 != 4097)
    {
      if (i1 != 4099)
      {
        if (i1 != 8194) {
          i4 = -1;
        } else if (paramBoolean) {
          i4 = R.anim.fragment_close_enter;
        } else {
          i4 = R.anim.fragment_close_exit;
        }
      }
      else if (paramBoolean) {
        i4 = R.anim.fragment_fade_enter;
      } else {
        i4 = R.anim.fragment_fade_exit;
      }
    }
    else if (paramBoolean) {
      i4 = R.anim.fragment_open_enter;
    } else {
      i4 = R.anim.fragment_open_exit;
    }
    if (i4 < 0) {
      return null;
    }
    return new d.m.a.g(AnimationUtils.loadAnimation(paramContext, i4));
  }
  
  public static d.r.e a(RandomAccessFile paramRandomAccessFile)
  {
    long l1 = paramRandomAccessFile.length() - 22L;
    long l2 = 0L;
    if (l1 >= 0L)
    {
      long l3 = l1 - 65536L;
      if (l3 < 0L) {
        l3 = l2;
      }
      int i1 = Integer.reverseBytes(101010256);
      do
      {
        paramRandomAccessFile.seek(l1);
        if (paramRandomAccessFile.readInt() == i1)
        {
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          localObject = new d.r.e();
          b = (Integer.reverseBytes(paramRandomAccessFile.readInt()) & 0xFFFFFFFF);
          a = (Integer.reverseBytes(paramRandomAccessFile.readInt()) & 0xFFFFFFFF);
          return (d.r.e)localObject;
        }
        l1 -= 1L;
      } while (l1 >= l3);
      throw new ZipException("End Of Central Directory signature not found");
    }
    Object localObject = e.a.a.a.a.a("File too short to be a zip file: ");
    ((StringBuilder)localObject).append(paramRandomAccessFile.length());
    throw new ZipException(((StringBuilder)localObject).toString());
  }
  
  public static File a(Context paramContext)
  {
    paramContext = paramContext.getCacheDir();
    if (paramContext == null) {
      return null;
    }
    Object localObject = e.a.a.a.a.a(".font");
    ((StringBuilder)localObject).append(Process.myPid());
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(Process.myTid());
    ((StringBuilder)localObject).append("-");
    localObject = ((StringBuilder)localObject).toString();
    for (int i1 = 0; i1 < 100; i1++)
    {
      File localFile = new File(paramContext, e.a.a.a.a.a((String)localObject, i1));
      try
      {
        boolean bool = localFile.createNewFile();
        if (bool) {
          return localFile;
        }
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
    return null;
  }
  
  public static <T> T a(T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException("null reference");
  }
  
  public static <T> T a(T paramT, Object paramObject)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(String.valueOf(paramObject));
  }
  
  public static String a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    if (!a(paramXmlPullParser, paramString)) {
      return null;
    }
    return paramTypedArray.getString(paramInt);
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    throw new IllegalArgumentException("Given String is empty or null");
  }
  
  /* Error */
  public static java.nio.ByteBuffer a(Context paramContext, android.os.CancellationSignal paramCancellationSignal, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1323	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_2
    //   7: ldc_w 1324
    //   10: aload_1
    //   11: invokevirtual 1330	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   14: astore_0
    //   15: aload_0
    //   16: ifnonnull +13 -> 29
    //   19: aload_0
    //   20: ifnull +7 -> 27
    //   23: aload_0
    //   24: invokevirtual 1335	android/os/ParcelFileDescriptor:close	()V
    //   27: aconst_null
    //   28: areturn
    //   29: new 1337	java/io/FileInputStream
    //   32: astore_1
    //   33: aload_1
    //   34: aload_0
    //   35: invokevirtual 1341	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   38: invokespecial 1344	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   41: aload_1
    //   42: invokevirtual 1348	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 1352	java/nio/channels/FileChannel:size	()J
    //   50: lstore_3
    //   51: aload_2
    //   52: getstatic 1358	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   55: lconst_0
    //   56: lload_3
    //   57: invokevirtual 1362	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   60: astore_2
    //   61: aload_1
    //   62: invokevirtual 1363	java/io/FileInputStream:close	()V
    //   65: aload_0
    //   66: invokevirtual 1335	android/os/ParcelFileDescriptor:close	()V
    //   69: aload_2
    //   70: areturn
    //   71: astore 5
    //   73: aload 5
    //   75: athrow
    //   76: astore_2
    //   77: aload_1
    //   78: invokevirtual 1363	java/io/FileInputStream:close	()V
    //   81: goto +10 -> 91
    //   84: astore_1
    //   85: aload 5
    //   87: aload_1
    //   88: invokevirtual 1368	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   91: aload_2
    //   92: athrow
    //   93: astore_1
    //   94: aload_1
    //   95: athrow
    //   96: astore_2
    //   97: aload_0
    //   98: invokevirtual 1335	android/os/ParcelFileDescriptor:close	()V
    //   101: goto +9 -> 110
    //   104: astore_0
    //   105: aload_1
    //   106: aload_0
    //   107: invokevirtual 1368	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   110: aload_2
    //   111: athrow
    //   112: astore_0
    //   113: aconst_null
    //   114: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramContext	Context
    //   0	115	1	paramCancellationSignal	android.os.CancellationSignal
    //   0	115	2	paramUri	android.net.Uri
    //   50	7	3	l1	long
    //   71	15	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   41	61	71	finally
    //   73	76	76	finally
    //   77	81	84	finally
    //   29	41	93	finally
    //   61	65	93	finally
    //   85	91	93	finally
    //   91	93	93	finally
    //   94	96	96	finally
    //   97	101	104	finally
    //   5	15	112	java/io/IOException
    //   23	27	112	java/io/IOException
    //   65	69	112	java/io/IOException
    //   105	110	112	java/io/IOException
    //   110	112	112	java/io/IOException
  }
  
  public static List<List<byte[]>> a(Resources paramResources, int paramInt)
  {
    if (paramInt == 0) {
      return Collections.emptyList();
    }
    TypedArray localTypedArray = paramResources.obtainTypedArray(paramInt);
    try
    {
      if (localTypedArray.length() == 0)
      {
        paramResources = Collections.emptyList();
        return paramResources;
      }
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      if (localTypedArray.getType(0) == 1) {
        for (paramInt = 0; paramInt < localTypedArray.length(); paramInt++)
        {
          int i1 = localTypedArray.getResourceId(paramInt, 0);
          if (i1 != 0) {
            localArrayList.add(a(paramResources.getStringArray(i1)));
          }
        }
      }
      localArrayList.add(a(paramResources.getStringArray(paramInt)));
      return localArrayList;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
  
  public static List<byte[]> a(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = paramArrayOfString.length;
    for (int i2 = 0; i2 < i1; i2++) {
      localArrayList.add(Base64.decode(paramArrayOfString[i2], 0));
    }
    return localArrayList;
  }
  
  public static void a(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramDrawable.clearColorFilter();
    }
    else
    {
      paramDrawable.clearColorFilter();
      if ((paramDrawable instanceof InsetDrawable))
      {
        a(((InsetDrawable)paramDrawable).getDrawable());
      }
      else if ((paramDrawable instanceof d.i.c.j.b))
      {
        a(((d.i.c.j.b)paramDrawable).a());
      }
      else if ((paramDrawable instanceof DrawableContainer))
      {
        DrawableContainer.DrawableContainerState localDrawableContainerState = (DrawableContainer.DrawableContainerState)((DrawableContainer)paramDrawable).getConstantState();
        if (localDrawableContainerState != null)
        {
          int i1 = 0;
          int i2 = localDrawableContainerState.getChildCount();
          while (i1 < i2)
          {
            paramDrawable = localDrawableContainerState.getChild(i1);
            if (paramDrawable != null) {
              a(paramDrawable);
            }
            i1++;
          }
        }
      }
    }
  }
  
  public static void a(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    paramDrawable.setTintList(paramColorStateList);
  }
  
  public static void a(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    paramDrawable.setTintMode(paramMode);
  }
  
  public static void a(Handler paramHandler)
  {
    if (Looper.myLooper() == paramHandler.getLooper()) {
      return;
    }
    throw new IllegalStateException("Must be called on the handler thread");
  }
  
  public static void a(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    c(paramParcel, paramInt1, 4);
    paramParcel.writeInt(paramInt2);
  }
  
  public static void a(Parcel paramParcel, int paramInt, long paramLong)
  {
    c(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong);
  }
  
  public static void a(Parcel paramParcel, int paramInt, IBinder paramIBinder, boolean paramBoolean)
  {
    if (paramIBinder == null)
    {
      if (paramBoolean) {
        c(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = j(paramParcel, paramInt);
    paramParcel.writeStrongBinder(paramIBinder);
    k(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt1, Parcelable paramParcelable, int paramInt2, boolean paramBoolean)
  {
    if (paramParcelable == null)
    {
      if (paramBoolean) {
        c(paramParcel, paramInt1, 0);
      }
      return;
    }
    paramInt1 = j(paramParcel, paramInt1);
    paramParcelable.writeToParcel(paramParcel, paramInt2);
    k(paramParcel, paramInt1);
  }
  
  public static void a(Parcel paramParcel, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      if (paramBoolean) {
        c(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = j(paramParcel, paramInt);
    paramParcel.writeString(paramString);
    k(paramParcel, paramInt);
  }
  
  public static <T extends Parcelable> void a(Parcel paramParcel, int paramInt, List<T> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean) {
        c(paramParcel, paramInt, 0);
      }
      return;
    }
    int i1 = j(paramParcel, paramInt);
    int i2 = paramList.size();
    paramParcel.writeInt(i2);
    for (paramInt = 0; paramInt < i2; paramInt++)
    {
      Parcelable localParcelable = (Parcelable)paramList.get(paramInt);
      if (localParcelable == null) {
        paramParcel.writeInt(0);
      } else {
        a(paramParcel, localParcelable, 0);
      }
    }
    k(paramParcel, i1);
  }
  
  public static void a(Parcel paramParcel, int paramInt, boolean paramBoolean)
  {
    c(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramBoolean);
  }
  
  public static <T extends Parcelable> void a(Parcel paramParcel, int paramInt1, T[] paramArrayOfT, int paramInt2, boolean paramBoolean)
  {
    if (paramArrayOfT == null)
    {
      if (paramBoolean) {
        c(paramParcel, paramInt1, 0);
      }
      return;
    }
    int i1 = j(paramParcel, paramInt1);
    int i2 = paramArrayOfT.length;
    paramParcel.writeInt(i2);
    for (paramInt1 = 0; paramInt1 < i2; paramInt1++)
    {
      T ? = paramArrayOfT[paramInt1];
      if (? == null) {
        paramParcel.writeInt(0);
      } else {
        a(paramParcel, ?, paramInt2);
      }
    }
    k(paramParcel, i1);
  }
  
  public static <T extends Parcelable> void a(Parcel paramParcel, T paramT, int paramInt)
  {
    int i1 = paramParcel.dataPosition();
    paramParcel.writeInt(1);
    int i2 = paramParcel.dataPosition();
    paramT.writeToParcel(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    paramParcel.setDataPosition(i1);
    paramParcel.writeInt(paramInt - i2);
    paramParcel.setDataPosition(paramInt);
  }
  
  public static void a(View paramView, CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramView.setTooltipText(paramCharSequence);
    }
    else
    {
      y0 localy0 = y0.G;
      if ((localy0 != null) && (x == paramView)) {
        y0.a(null);
      }
      if (TextUtils.isEmpty(paramCharSequence))
      {
        paramCharSequence = y0.H;
        if ((paramCharSequence != null) && (x == paramView)) {
          paramCharSequence.b();
        }
        paramView.setOnLongClickListener(null);
        paramView.setLongClickable(false);
        paramView.setOnHoverListener(null);
      }
      else
      {
        new y0(paramView, paramCharSequence);
      }
    }
  }
  
  public static void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (!t)
    {
      try
      {
        Method localMethod1 = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[] { Boolean.TYPE });
        s = localMethod1;
        localMethod1.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", localNoSuchMethodException);
      }
      t = true;
    }
    Method localMethod2 = s;
    if (localMethod2 != null) {
      try
      {
        localMethod2.invoke(paramViewGroup, new Object[] { Boolean.valueOf(paramBoolean) });
      }
      catch (InvocationTargetException paramViewGroup)
      {
        Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", paramViewGroup);
      }
      catch (IllegalAccessException paramViewGroup)
      {
        Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", paramViewGroup);
      }
    }
  }
  
  public static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramPopupWindow.setWindowLayoutType(paramInt);
      return;
    }
    if (!p) {}
    try
    {
      localMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { Integer.TYPE });
      o = localMethod;
      localMethod.setAccessible(true);
      p = true;
      localMethod = o;
      if (localMethod == null) {}
    }
    catch (Exception localException)
    {
      try
      {
        Method localMethod;
        localMethod.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
        return;
        localException = localException;
      }
      catch (Exception paramPopupWindow)
      {
        for (;;) {}
      }
    }
  }
  
  public static void a(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramPopupWindow.setOverlapAnchor(paramBoolean);
    }
    else
    {
      if (!r)
      {
        try
        {
          Field localField1 = PopupWindow.class.getDeclaredField("mOverlapAnchor");
          q = localField1;
          localField1.setAccessible(true);
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", localNoSuchFieldException);
        }
        r = true;
      }
      Field localField2 = q;
      if (localField2 != null) {
        try
        {
          localField2.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
        }
        catch (IllegalAccessException paramPopupWindow)
        {
          Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", paramPopupWindow);
        }
      }
    }
  }
  
  public static void a(TextView paramTextView, int paramInt)
  {
    a(paramInt);
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramTextView.setFirstBaselineToTopHeight(paramInt);
      return;
    }
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    int i1;
    if (paramTextView.getIncludeFontPadding()) {
      i1 = top;
    } else {
      i1 = ascent;
    }
    if (paramInt > Math.abs(i1)) {
      paramTextView.setPadding(paramTextView.getPaddingLeft(), paramInt + i1, paramTextView.getPaddingRight(), paramTextView.getPaddingBottom());
    }
  }
  
  public static void a(TextView paramTextView, d.i.g.a parama)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      if (parama != null) {
        paramTextView.setText(null);
      } else {
        throw null;
      }
    }
    else
    {
      a.a locala = a(paramTextView);
      if (parama == null) {
        break label56;
      }
      if (!locala.a(null)) {
        break label45;
      }
      paramTextView.setText(parama);
    }
    return;
    label45:
    throw new IllegalArgumentException("Given text can not be applied to TextView.");
    label56:
    throw null;
  }
  
  public static void a(d.g.a.h.e parame)
  {
    if ((C0 & 0x20) != 32)
    {
      w0.clear();
      w0.add(0, new f(k0));
      return;
    }
    D0 = true;
    x0 = false;
    y0 = false;
    z0 = false;
    Object localObject1 = k0;
    List localList = w0;
    int i1;
    if (parame.e() == d.a.WRAP_CONTENT) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (parame.h() == d.a.WRAP_CONTENT) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    boolean bool;
    if ((i1 == 0) && (i2 == 0)) {
      bool = false;
    } else {
      bool = true;
    }
    localList.clear();
    Iterator localIterator = ((List)localObject1).iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (d.g.a.h.d)localIterator.next();
      p = null;
      d0 = false;
      ((d.g.a.h.d)localObject2).l();
    }
    localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (d.g.a.h.d)localIterator.next();
      if (p == null)
      {
        localObject2 = new f(new ArrayList(), true);
        localList.add(localObject2);
        if (!a((d.g.a.h.d)localObject1, (f)localObject2, localList, bool))
        {
          w0.clear();
          w0.add(0, new f(k0));
          D0 = false;
          return;
        }
      }
    }
    localObject1 = localList.iterator();
    int i3 = 0;
    for (int i4 = 0; ((Iterator)localObject1).hasNext(); i4 = Math.max(i4, a((f)localObject2, 1)))
    {
      localObject2 = (f)((Iterator)localObject1).next();
      i3 = Math.max(i3, a((f)localObject2, 0));
    }
    if (i1 != 0)
    {
      parame.a(d.a.FIXED);
      parame.f(i3);
      x0 = true;
      y0 = true;
      A0 = i3;
    }
    if (i2 != 0)
    {
      parame.b(d.a.FIXED);
      parame.e(i4);
      x0 = true;
      z0 = true;
      B0 = i4;
    }
    a(localList, 0, parame.i());
    a(localList, 1, parame.d());
  }
  
  public static void a(d.g.a.h.e parame, d.g.a.e parame1, int paramInt)
  {
    Object localObject1 = parame;
    Object localObject2 = parame1;
    int i1;
    int i2;
    if (paramInt == 0)
    {
      i1 = s0;
      localObject3 = v0;
      i2 = 0;
    }
    else
    {
      i1 = t0;
      localObject3 = u0;
      i2 = 2;
    }
    int i3 = 0;
    Object localObject4 = localObject3;
    int i4 = i1;
    Object localObject3 = localObject2;
    while (i3 < i4)
    {
      Object localObject5 = localObject4[i3];
      int i5;
      Object localObject6;
      Object localObject7;
      int i6;
      float f1;
      if (!q)
      {
        i5 = l * 2;
        localObject2 = a;
        localObject6 = localObject2;
        i1 = 0;
        while (i1 == 0)
        {
          i += 1;
          localObject7 = i0;
          i6 = l;
          localObject7[i6] = null;
          h0[i6] = null;
          if (Y != 8)
          {
            if (b == null) {
              b = ((d.g.a.h.d)localObject2);
            }
            d = ((d.g.a.h.d)localObject2);
            localObject7 = C;
            i6 = l;
            if (localObject7[i6] == d.a.MATCH_CONSTRAINT)
            {
              localObject7 = g;
              if ((localObject7[i6] == 0) || (localObject7[i6] == 3) || (localObject7[i6] == 2))
              {
                j += 1;
                localObject7 = g0;
                i6 = l;
                f1 = localObject7[i6];
                if (f1 > 0.0F) {
                  k += localObject7[i6];
                }
                i6 = l;
                if ((Y != 8) && (C[i6] == d.a.MATCH_CONSTRAINT))
                {
                  localObject7 = g;
                  if ((localObject7[i6] == 0) || (localObject7[i6] == 3))
                  {
                    i6 = 1;
                    break label358;
                  }
                }
                i6 = 0;
                label358:
                if (i6 != 0)
                {
                  if (f1 < 0.0F) {
                    n = true;
                  } else {
                    o = true;
                  }
                  if (h == null) {
                    h = new ArrayList();
                  }
                  h.add(localObject2);
                }
                if (f == null) {
                  f = ((d.g.a.h.d)localObject2);
                }
                localObject7 = g;
                if (localObject7 != null) {
                  h0[l] = localObject2;
                }
                g = ((d.g.a.h.d)localObject2);
              }
            }
          }
          if (localObject6 != localObject2) {
            i0[l] = localObject2;
          }
          localObject6 = A[(i5 + 1)].d;
          if (localObject6 != null)
          {
            localObject6 = b;
            localObject7 = A;
            if ((d != null) && (d.b == localObject2)) {}
          }
          else
          {
            localObject6 = null;
          }
          if (localObject6 == null)
          {
            localObject6 = localObject2;
            i1 = 1;
          }
          localObject7 = localObject6;
          localObject6 = localObject2;
          localObject2 = localObject7;
        }
        c = ((d.g.a.h.d)localObject2);
        if ((l == 0) && (m)) {
          e = ((d.g.a.h.d)localObject2);
        } else {
          e = a;
        }
        boolean bool;
        if ((o) && (n)) {
          bool = true;
        } else {
          bool = false;
        }
        p = bool;
      }
      q = true;
      if (((d.g.a.h.e)localObject1).g(4))
      {
        localObject6 = a;
        d.g.a.h.d locald1 = c;
        Object localObject8 = b;
        d.g.a.h.d locald2 = d;
        localObject2 = e;
        float f2 = k;
        localObject1 = C[paramInt];
        localObject1 = d.a.WRAP_CONTENT;
        if (paramInt == 0)
        {
          if (e0 == 0) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (e0 == 1) {
            i6 = 1;
          } else {
            i6 = 0;
          }
          i5 = i6;
          i7 = i1;
          if (e0 != 2) {
            break label848;
          }
        }
        else
        {
          if (f0 == 0) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (f0 == 1) {
            i6 = 1;
          } else {
            i6 = 0;
          }
          i8 = f0;
          i5 = i6;
          i7 = i1;
          if (i8 != 2) {
            break label848;
          }
        }
        int i7 = 1;
        i5 = i6;
        i6 = i7;
        break label855;
        label848:
        i6 = 0;
        i1 = i7;
        label855:
        localObject7 = localObject6;
        i7 = 0;
        int i8 = 0;
        float f3 = 0.0F;
        float f4 = 0.0F;
        int i9 = 0;
        localObject2 = localObject5;
        int i10;
        int i11;
        if (i9 == 0)
        {
          i10 = Y;
          localObject1 = localObject2;
          i11 = i7;
          f1 = f3;
          f5 = f4;
          if (i10 != 8)
          {
            i11 = i7 + 1;
            if (paramInt == 0) {
              i7 = ((d.g.a.h.d)localObject7).i();
            } else {
              i7 = ((d.g.a.h.d)localObject7).d();
            }
            f1 = f3 + i7;
            f5 = f1;
            if (localObject7 != localObject8) {
              f5 = f1 + A[i2].a();
            }
            f1 = f5;
            if (localObject7 != locald2) {
              f1 = f5 + A[(i2 + 1)].a();
            }
            f5 = f4 + A[i2].a() + A[(i2 + 1)].a();
          }
          localObject5 = A[i2];
          i10 = i8;
          if (Y != 8)
          {
            i10 = i8;
            if (C[paramInt] == d.a.MATCH_CONSTRAINT)
            {
              i10 = i8 + 1;
              if (paramInt == 0)
              {
                if (e == 0) {
                  label1096:
                  if (h == 0) {
                    if (i == 0) {
                      break label1152;
                    }
                  }
                }
              }
              else {
                if (f == 0) {
                  break label1133;
                }
              }
            }
          }
        }
        label1133:
        label1152:
        label1235:
        j localj;
        do
        {
          do
          {
            localObject6 = localObject3;
            break;
          } while (k != 0);
          if (l == 0) {
            if (G != 0.0F) {
              break label1096;
            }
          }
          localObject2 = A[(i2 + 1)].d;
          if (localObject2 != null)
          {
            localObject2 = b;
            localObject5 = A;
            if ((d != null) && (d.b == localObject7)) {
              break label1235;
            }
          }
          localObject2 = null;
          if (localObject2 != null)
          {
            localObject7 = localObject2;
            localObject2 = localObject1;
            i7 = i11;
            i8 = i10;
            f3 = f1;
            f4 = f5;
            break;
          }
          i9 = 1;
          localObject2 = localObject1;
          i7 = i11;
          i8 = i10;
          f3 = f1;
          f4 = f5;
          break;
          localObject5 = A[i2].a;
          localObject1 = A;
          i9 = i2 + 1;
          localObject1 = a;
          localj = d;
        } while (localj == null);
        localObject3 = d;
        if ((localObject3 == null) || (b != 1) || (b != 1) || ((i8 > 0) && (i8 != i7))) {}
        float f6;
        float f7;
        do
        {
          localObject6 = parame1;
          break label2465;
          if ((i6 == 0) && (i1 == 0) && (i5 == 0))
          {
            f1 = 0.0F;
          }
          else
          {
            if (localObject8 != null) {
              f5 = A[i2].a();
            } else {
              f5 = 0.0F;
            }
            f1 = f5;
            if (locald2 != null) {
              f1 = f5 + A[i9].a();
            }
          }
          f6 = d.g;
          f5 = d.g;
          if (f6 < f5) {
            f5 -= f6;
          } else {
            f5 = f6 - f5;
          }
          f7 = f5 - f3;
          f5 = -1.0F;
          if ((i8 <= 0) || (i8 != i7)) {
            break;
          }
          localObject3 = D;
        } while ((localObject3 != null) && (C[paramInt] == d.a.WRAP_CONTENT));
        f4 = f7 + f3 - f4;
        float f5 = f6;
        for (localObject3 = localObject6; localObject3 != null; localObject3 = localObject6)
        {
          localObject6 = i0[paramInt];
          if ((localObject6 == null) && (localObject3 != locald1)) {
            continue;
          }
          f1 = f4 / i8;
          if (f2 > 0.0F)
          {
            localObject1 = g0;
            if (localObject1[paramInt] == -1.0F) {
              f1 = 0.0F;
            } else {
              f1 = localObject1[paramInt] * f4 / f2;
            }
          }
          if (Y == 8) {
            f1 = 0.0F;
          }
          f5 += A[i2].a();
          A[i2].a.a(f, f5);
          localObject7 = A[i9].a;
          localObject1 = f;
          f1 = f5 + f1;
          ((j)localObject7).a((j)localObject1, f1);
          A[i2].a.a(parame1);
          A[i9].a.a(parame1);
          f5 = f1 + A[i9].a();
        }
        for (;;)
        {
          localObject6 = parame1;
          i1 = 1;
          break;
          localObject1 = parame1;
          if (f7 < 0.0F)
          {
            i5 = 0;
            i6 = 1;
            i1 = 0;
          }
          if (i6 != 0)
          {
            if (paramInt == 0) {
              f5 = V;
            } else if (paramInt == 1) {
              f5 = W;
            }
            f1 = (f7 - f1) * f5 + f6;
            localObject3 = localObject6;
            while (localObject3 != null)
            {
              localObject6 = i0[paramInt];
              if (localObject6 == null)
              {
                f5 = f1;
                if (localObject3 != locald1) {}
              }
              else
              {
                if (paramInt == 0) {
                  i1 = ((d.g.a.h.d)localObject3).i();
                } else {
                  i1 = ((d.g.a.h.d)localObject3).d();
                }
                f5 = i1;
                f1 += A[i2].a();
                A[i2].a.a(f, f1);
                localObject7 = A[i9].a;
                localObject8 = f;
                f1 += f5;
                ((j)localObject7).a((j)localObject8, f1);
                A[i2].a.a((d.g.a.e)localObject1);
                A[i9].a.a((d.g.a.e)localObject1);
                f5 = f1 + A[i9].a();
              }
              localObject3 = localObject6;
              f1 = f5;
            }
          }
          if ((i1 == 0) && (i5 == 0)) {}
          if (i1 == 0)
          {
            f5 = f7;
            if (i5 == 0) {}
          }
          else
          {
            f5 = f7 - f1;
          }
          f4 = f5 / (i7 + 1);
          if (i5 != 0)
          {
            if (i7 > 1) {
              f1 = i7 - 1;
            } else {
              f1 = 2.0F;
            }
            f4 = f5 / f1;
          }
          if (Y != 8) {
            f1 = f6 + f4;
          } else {
            f1 = f6;
          }
          if ((i5 != 0) && (i7 > 1)) {
            f1 = A[i2].a() + f6;
          }
          f5 = f1;
          if (i1 != 0)
          {
            f5 = f1;
            if (localObject8 != null) {
              f5 = f1 + A[i2].a();
            }
          }
          localObject3 = localObject6;
          f1 = f5;
          while (localObject3 != null)
          {
            localObject6 = i0[paramInt];
            if (localObject6 == null)
            {
              f5 = f1;
              if (localObject3 == locald1) {}
            }
            do
            {
              f1 = f5;
              break;
              if (paramInt == 0) {
                i1 = ((d.g.a.h.d)localObject3).i();
              } else {
                i1 = ((d.g.a.h.d)localObject3).d();
              }
              f6 = i1;
              f5 = f1;
              if (localObject3 != localObject8) {
                f5 = f1 + A[i2].a();
              }
              A[i2].a.a(f, f5);
              A[i9].a.a(f, f5 + f6);
              A[i2].a.a((d.g.a.e)localObject1);
              A[i9].a.a((d.g.a.e)localObject1);
              f6 = f5 + (f6 + A[i9].a());
              f5 = f6;
            } while (localObject6 == null);
            f1 = f6;
            if (Y != 8) {
              f1 = f6 + f4;
            }
            localObject3 = localObject6;
          }
        }
        label2465:
        i1 = 0;
        localObject7 = parame;
        localObject1 = localObject7;
        localObject3 = localObject6;
        if (i1 == 0)
        {
          a((d.g.a.h.e)localObject7, (d.g.a.e)localObject6, paramInt, i2, (d.g.a.h.b)localObject2);
          localObject1 = localObject7;
          localObject3 = localObject6;
        }
      }
      else
      {
        a((d.g.a.h.e)localObject1, (d.g.a.e)localObject3, paramInt, i2, (d.g.a.h.b)localObject5);
      }
      i3++;
    }
  }
  
  public static void a(d.g.a.h.e parame, d.g.a.e parame1, int paramInt1, int paramInt2, d.g.a.h.b paramb)
  {
    Object localObject1 = paramb;
    d.g.a.h.d locald1 = a;
    Object localObject2 = c;
    d.g.a.h.d locald2 = b;
    d.g.a.h.d locald3 = d;
    Object localObject3 = e;
    float f1 = k;
    boolean bool;
    if (C[paramInt1] == d.a.WRAP_CONTENT) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramInt1 == 0)
    {
      if (e0 == 0) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (e0 == 1) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      i4 = i2;
      i5 = i3;
      if (e0 != 2) {
        break label188;
      }
    }
    else
    {
      if (f0 == 0) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (f0 == 1) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      i4 = i2;
      i5 = i3;
      if (f0 != 2) {
        break label188;
      }
    }
    int i6 = 1;
    int i4 = i2;
    break label195;
    label188:
    i6 = 0;
    int i3 = i5;
    label195:
    Object localObject4 = locald1;
    int i5 = i4;
    int i2 = 0;
    i4 = i3;
    Object localObject5;
    Object localObject7;
    int i8;
    Object localObject8;
    for (;;)
    {
      localObject5 = null;
      localObject6 = null;
      if (i2 != 0) {
        break;
      }
      localObject7 = A[paramInt2];
      if ((!bool) && (i6 == 0)) {
        i3 = 4;
      } else {
        i3 = 1;
      }
      int i7 = ((d.g.a.h.c)localObject7).a();
      localObject5 = d;
      i8 = i7;
      if (localObject5 != null)
      {
        i8 = i7;
        if (localObject4 != locald1) {
          i8 = ((d.g.a.h.c)localObject5).a() + i7;
        }
      }
      if ((i6 != 0) && (localObject4 != locald1) && (localObject4 != locald2)) {
        i3 = 6;
      } else if ((i5 != 0) && (bool)) {
        i3 = 4;
      }
      localObject5 = d;
      if (localObject5 != null)
      {
        if (localObject4 == locald2) {
          parame1.b(i, i, i8, 5);
        } else {
          parame1.b(i, i, i8, 6);
        }
        parame1.a(i, d.i, i8, i3);
      }
      if (bool)
      {
        if ((Y != 8) && (C[paramInt1] == d.a.MATCH_CONSTRAINT))
        {
          localObject7 = A;
          parame1.b(1i, i, 0, 5);
        }
        parame1.b(A[paramInt2].i, A[paramInt2].i, 0, 6);
      }
      localObject5 = A[(paramInt2 + 1)].d;
      localObject7 = localObject6;
      if (localObject5 != null)
      {
        localObject5 = b;
        localObject8 = A;
        localObject7 = localObject6;
        if (d != null) {
          if (d.b != localObject4) {
            localObject7 = localObject6;
          } else {
            localObject7 = localObject5;
          }
        }
      }
      if (localObject7 != null) {
        localObject4 = localObject7;
      } else {
        i2 = 1;
      }
    }
    if (locald3 != null)
    {
      localObject4 = A;
      i2 = paramInt2 + 1;
      if (d != null)
      {
        localObject7 = A[i2];
        parame1.c(i, d.i, -((d.g.a.h.c)localObject7).a(), 5);
      }
    }
    if (bool)
    {
      parame = A;
      i2 = paramInt2 + 1;
      localObject7 = i;
      parame = A;
      parame1.b((d.g.a.g)localObject7, i, parame[i2].a(), 6);
    }
    Object localObject6 = h;
    parame = (d.g.a.h.e)localObject2;
    label925:
    Object localObject9;
    if (localObject6 != null)
    {
      i3 = ((ArrayList)localObject6).size();
      parame = (d.g.a.h.e)localObject2;
      if (i3 > 1)
      {
        float f2;
        if ((n) && (!p)) {
          f2 = j;
        } else {
          f2 = f1;
        }
        localObject4 = null;
        i2 = 0;
        float f3 = 0.0F;
        localObject7 = localObject2;
        localObject2 = localObject6;
        for (;;)
        {
          parame = (d.g.a.h.e)localObject7;
          if (i2 >= i3) {
            break;
          }
          parame = (d.g.a.h.d)((ArrayList)localObject2).get(i2);
          float f4 = g0[paramInt1];
          f1 = f4;
          if (f4 < 0.0F)
          {
            if (p)
            {
              parame = A;
              parame1.a(1i, i, 0, 4);
            }
            else
            {
              f1 = 1.0F;
            }
          }
          else
          {
            bool = f1 < 0.0F;
            if (bool) {
              break label925;
            }
            parame = A;
            parame1.a(1i, i, 0, 6);
          }
          f1 = f3;
          break label1207;
          if (localObject4 != null)
          {
            localObject1 = A;
            localObject4 = i;
            i8 = paramInt2 + 1;
            localObject6 = i;
            localObject8 = A;
            localObject1 = i;
            localObject8 = i;
            localObject9 = parame1.b();
            b = 0.0F;
            if ((f2 != 0.0F) && (f3 != f1))
            {
              if (f3 == 0.0F)
              {
                d.a((d.g.a.g)localObject4, 1.0F);
                d.a((d.g.a.g)localObject6, -1.0F);
              }
              else if (!bool)
              {
                d.a((d.g.a.g)localObject1, 1.0F);
                d.a((d.g.a.g)localObject8, -1.0F);
              }
              else
              {
                f3 = f3 / f2 / (f1 / f2);
                d.a((d.g.a.g)localObject4, 1.0F);
                d.a((d.g.a.g)localObject6, -1.0F);
                d.a((d.g.a.g)localObject8, f3);
                d.a((d.g.a.g)localObject1, -f3);
              }
            }
            else
            {
              d.a((d.g.a.g)localObject4, 1.0F);
              d.a((d.g.a.g)localObject6, -1.0F);
              d.a((d.g.a.g)localObject8, 1.0F);
              d.a((d.g.a.g)localObject1, -1.0F);
            }
            parame1.a((d.g.a.b)localObject9);
          }
          localObject4 = parame;
          label1207:
          i2++;
          f3 = f1;
        }
      }
    }
    if ((locald2 != null) && ((locald2 == locald3) || (i6 != 0)))
    {
      paramb = A;
      localObject2 = paramb[paramInt2];
      localObject7 = parame;
      localObject4 = A;
      i2 = paramInt2 + 1;
      localObject4 = localObject4[i2];
      if (d != null) {
        paramb = d.i;
      } else {
        paramb = null;
      }
      localObject7 = A;
      if (d != null) {
        localObject7 = d.i;
      } else {
        localObject7 = null;
      }
      if (locald2 == locald3)
      {
        localObject4 = A;
        localObject2 = localObject4[paramInt2];
        localObject4 = localObject4[i2];
      }
      if ((paramb != null) && (localObject7 != null))
      {
        if (paramInt1 == 0) {
          f1 = V;
        } else {
          f1 = W;
        }
        paramInt1 = ((d.g.a.h.c)localObject2).a();
        i2 = ((d.g.a.h.c)localObject4).a();
        parame1.a(i, paramb, paramInt1, f1, (d.g.a.g)localObject7, i, i2, 5);
      }
    }
    else
    {
      localObject8 = parame;
      if ((i5 != 0) && (locald2 != null))
      {
        i2 = j;
        if ((i2 > 0) && (i == i2)) {
          bool = true;
        } else {
          bool = false;
        }
        localObject7 = locald2;
        localObject4 = localObject7;
      }
      while (localObject7 != null)
      {
        for (localObject3 = i0[paramInt1]; (localObject3 != null) && (Y == 8); localObject3 = i0[paramInt1]) {}
        if ((localObject3 == null) && (localObject7 != locald3)) {}
        for (;;)
        {
          break;
          localObject1 = A[paramInt2];
          d.g.a.g localg = i;
          paramb = d;
          if (paramb != null) {
            localObject2 = i;
          } else {
            localObject2 = null;
          }
          if (localObject4 != localObject7)
          {
            paramb = A[(paramInt2 + 1)].i;
          }
          else
          {
            paramb = (d.g.a.h.b)localObject2;
            if (localObject7 == locald2)
            {
              paramb = (d.g.a.h.b)localObject2;
              if (localObject4 == localObject7)
              {
                paramb = A;
                if (d != null) {
                  paramb = d.i;
                } else {
                  paramb = null;
                }
              }
            }
          }
          i6 = ((d.g.a.h.c)localObject1).a();
          localObject2 = A;
          i8 = paramInt2 + 1;
          i3 = localObject2[i8].a();
          if (localObject3 != null)
          {
            localObject2 = A[paramInt2];
            localObject1 = i;
            localObject6 = A[i8].i;
          }
          else
          {
            localObject9 = A[i8].d;
            if (localObject9 != null) {
              localObject2 = i;
            } else {
              localObject2 = null;
            }
            localObject6 = A[i8].i;
            localObject1 = localObject2;
            localObject2 = localObject9;
          }
          i2 = i3;
          if (localObject2 != null) {
            i2 = i3 + ((d.g.a.h.c)localObject2).a();
          }
          i3 = i6;
          if (localObject4 != null) {
            i3 = i6 + A[i8].a();
          }
          if ((localg != null) && (paramb != null) && (localObject1 != null) && (localObject6 != null))
          {
            if (localObject7 == locald2) {
              i3 = A[paramInt2].a();
            }
            if (localObject7 == locald3) {
              i2 = A[i8].a();
            }
            if (bool) {
              i6 = 6;
            } else {
              i6 = 4;
            }
            parame1.a(localg, paramb, i3, 0.5F, (d.g.a.g)localObject1, (d.g.a.g)localObject6, i2, i6);
          }
        }
        if (Y != 8) {
          localObject4 = localObject7;
        }
        localObject7 = localObject3;
        continue;
        if ((i4 != 0) && (locald2 != null))
        {
          i2 = j;
          if ((i2 > 0) && (i == i2)) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          localObject7 = locald2;
          localObject3 = localObject7;
          while (localObject7 != null)
          {
            for (paramb = i0[paramInt1]; (paramb != null) && (Y == 8); paramb = i0[paramInt1]) {}
            if ((localObject7 != locald2) && (localObject7 != locald3) && (paramb != null))
            {
              if (paramb == locald3) {
                paramb = null;
              }
              localObject2 = A[paramInt2];
              localObject6 = i;
              localObject4 = d;
              if (localObject4 != null) {
                localObject4 = i;
              }
              localObject4 = A;
              int i1 = paramInt2 + 1;
              localObject9 = i;
              i6 = ((d.g.a.h.c)localObject2).a();
              i3 = A[i1].a();
              if (paramb != null)
              {
                localObject1 = A[paramInt2];
                localObject4 = i;
                localObject2 = d;
                if (localObject2 != null) {
                  localObject2 = i;
                } else {
                  localObject2 = null;
                }
              }
              else
              {
                localObject1 = A[i1].d;
                if (localObject1 != null) {
                  localObject4 = i;
                } else {
                  localObject4 = null;
                }
                localObject2 = A[i1].i;
              }
              if (localObject1 != null) {
                i3 = ((d.g.a.h.c)localObject1).a() + i3;
              }
              i8 = A[i1].a();
              if (i2 != 0) {
                i1 = 6;
              } else {
                i1 = 4;
              }
              if ((localObject6 != null) && (localObject9 != null) && (localObject4 != null) && (localObject2 != null)) {
                parame1.a((d.g.a.g)localObject6, (d.g.a.g)localObject9, i8 + i6, 0.5F, (d.g.a.g)localObject4, (d.g.a.g)localObject2, i3, i1);
              }
            }
            if (Y == 8) {
              localObject7 = localObject3;
            }
            localObject3 = localObject7;
            localObject7 = paramb;
          }
          paramb = A[paramInt2];
          localObject7 = A[paramInt2].d;
          localObject3 = A;
          paramInt1 = paramInt2 + 1;
          localObject3 = localObject3[paramInt1];
          localObject2 = A[paramInt1].d;
          if (localObject7 != null) {
            if (locald2 != locald3) {
              parame1.a(i, i, paramb.a(), 5);
            } else if (localObject2 != null) {
              parame1.a(i, i, paramb.a(), 0.5F, i, i, ((d.g.a.h.c)localObject3).a(), 5);
            }
          }
          if ((localObject2 != null) && (locald2 != locald3)) {
            parame1.a(i, i, -((d.g.a.h.c)localObject3).a(), 5);
          }
        }
      }
    }
    localObject2 = parame;
    if (((i5 != 0) || (i4 != 0)) && (locald2 != null))
    {
      localObject3 = A[paramInt2];
      parame = A;
      paramInt1 = paramInt2 + 1;
      localObject7 = parame[paramInt1];
      parame = d;
      if (parame != null) {
        paramb = i;
      } else {
        paramb = null;
      }
      parame = d;
      if (parame != null) {
        parame = i;
      } else {
        parame = null;
      }
      if (localObject2 != locald3)
      {
        localObject2 = A[paramInt1].d;
        parame = (d.g.a.h.e)localObject5;
        if (localObject2 != null) {
          parame = i;
        }
      }
      if (locald2 == locald3)
      {
        localObject7 = A;
        localObject3 = localObject7[paramInt2];
        localObject7 = localObject7[paramInt1];
      }
      if ((paramb != null) && (parame != null))
      {
        paramInt2 = ((d.g.a.h.c)localObject3).a();
        paramInt1 = A[paramInt1].a();
        parame1.a(i, paramb, paramInt2, 0.5F, parame, i, paramInt1, 5);
      }
    }
  }
  
  public static void a(Object paramObject, StringBuilder paramStringBuilder)
  {
    if (paramObject == null)
    {
      paramStringBuilder.append("null");
    }
    else
    {
      String str1 = paramObject.getClass().getSimpleName();
      String str2 = str1;
      if (str1.length() <= 0)
      {
        str1 = paramObject.getClass().getName();
        int i1 = str1.lastIndexOf('.');
        str2 = str1;
        if (i1 > 0) {
          str2 = str1.substring(i1 + 1);
        }
      }
      paramStringBuilder.append(str2);
      paramStringBuilder.append('{');
      paramStringBuilder.append(Integer.toHexString(System.identityHashCode(paramObject)));
    }
  }
  
  public static void a(List<f> paramList, int paramInt1, int paramInt2)
  {
    int i1 = paramList.size();
    int i2 = 0;
    while (i2 < i1)
    {
      Object localObject1 = (f)paramList.get(i2);
      HashSet localHashSet = null;
      if (localObject1 != null)
      {
        if (paramInt1 == 0) {
          localHashSet = h;
        } else if (paramInt1 == 1) {
          localHashSet = i;
        }
        Iterator localIterator = localHashSet.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (d.g.a.h.d)localIterator.next();
          if (b0)
          {
            int i3 = paramInt1 * 2;
            Object localObject2 = A;
            localHashSet = localObject2[i3];
            localObject2 = localObject2[(i3 + 1)];
            int i4;
            if ((d != null) && (d != null)) {
              i4 = 1;
            } else {
              i4 = 0;
            }
            if (i4 != 0)
            {
              i4 = a((d.g.a.h.d)localObject1, paramInt1);
              d.g.a.h.i.a((d.g.a.h.d)localObject1, paramInt1, localHashSet.a() + i4);
            }
            else if ((G != 0.0F) && (((d.g.a.h.d)localObject1).b(paramInt1) == d.a.MATCH_CONSTRAINT))
            {
              i4 = a((d.g.a.h.d)localObject1);
              i3 = (int)A[i3].a.g;
              localObject2 = a;
              f = a;
              g = i4;
              b = 1;
              ((d.g.a.h.d)localObject1).a(i3, i3 + i4, paramInt1);
            }
            else
            {
              if (paramInt1 == 0) {
                i4 = K;
              } else if (paramInt1 == 1) {
                i4 = L;
              } else {
                i4 = 0;
              }
              i3 = paramInt2 - i4;
              i4 = i3 - ((d.g.a.h.d)localObject1).c(paramInt1);
              ((d.g.a.h.d)localObject1).a(i4, i3, paramInt1);
              d.g.a.h.i.a((d.g.a.h.d)localObject1, paramInt1, i4);
            }
          }
        }
        i2++;
      }
      else
      {
        throw null;
      }
    }
  }
  
  public static void a(XmlPullParser paramXmlPullParser)
  {
    int i1 = 1;
    while (i1 > 0)
    {
      int i2 = paramXmlPullParser.next();
      if (i2 != 2)
      {
        if (i2 == 3) {
          i1--;
        }
      }
      else {
        i1++;
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public static void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(String.valueOf(paramObject));
  }
  
  public static boolean a(Drawable paramDrawable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramDrawable.setLayoutDirection(paramInt);
    }
    if (!j)
    {
      try
      {
        Method localMethod1 = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[] { Integer.TYPE });
        i = localMethod1;
        localMethod1.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", localNoSuchMethodException);
      }
      j = true;
    }
    Method localMethod2 = i;
    if (localMethod2 != null) {
      try
      {
        localMethod2.invoke(paramDrawable, new Object[] { Integer.valueOf(paramInt) });
        return true;
      }
      catch (Exception paramDrawable)
      {
        Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", paramDrawable);
        i = null;
      }
    }
    return false;
  }
  
  public static boolean a(d.g.a.h.d paramd, f paramf, List<f> paramList, boolean paramBoolean)
  {
    if (paramd == null) {
      return true;
    }
    c0 = false;
    d.g.a.h.e locale = (d.g.a.h.e)D;
    Object localObject1 = p;
    if (localObject1 == null)
    {
      b0 = true;
      a.add(paramd);
      p = paramf;
      if ((s.d == null) && (u.d == null) && (t.d == null) && (v.d == null) && (w.d == null) && (z.d == null))
      {
        d = false;
        D0 = false;
        b0 = false;
        if (paramBoolean) {
          return false;
        }
      }
      Object localObject2;
      if ((t.d != null) && (v.d != null))
      {
        locale.h();
        localObject1 = d.a.WRAP_CONTENT;
        if (paramBoolean)
        {
          d = false;
          D0 = false;
          b0 = false;
          return false;
        }
        localObject1 = t.d.b;
        localObject2 = D;
        if ((localObject1 != localObject2) || (v.d.b != localObject2))
        {
          d = false;
          D0 = false;
          b0 = false;
        }
      }
      if ((s.d != null) && (u.d != null))
      {
        locale.e();
        localObject1 = d.a.WRAP_CONTENT;
        if (paramBoolean)
        {
          d = false;
          D0 = false;
          b0 = false;
          return false;
        }
        localObject2 = s.d.b;
        localObject1 = D;
        if ((localObject2 != localObject1) || (u.d.b != localObject1))
        {
          d = false;
          D0 = false;
          b0 = false;
        }
      }
      if (paramd.e() == d.a.MATCH_CONSTRAINT) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (paramd.h() == d.a.MATCH_CONSTRAINT) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (((i1 ^ i2) != 0) && (G != 0.0F))
      {
        a(paramd);
      }
      else if ((paramd.e() == d.a.MATCH_CONSTRAINT) || (paramd.h() == d.a.MATCH_CONSTRAINT))
      {
        d = false;
        D0 = false;
        b0 = false;
        if (paramBoolean) {
          return false;
        }
      }
      if ((s.d != null) || (u.d != null))
      {
        localObject1 = s.d;
        if ((localObject1 == null) || (b != D) || (u.d != null))
        {
          localObject1 = u.d;
          if ((localObject1 == null) || (b != D) || (s.d != null))
          {
            localObject1 = s.d;
            if (localObject1 == null) {
              break label642;
            }
            localObject2 = b;
            localObject1 = D;
            if (localObject2 != localObject1) {
              break label642;
            }
            localObject2 = u.d;
            if ((localObject2 == null) || (b != localObject1)) {
              break label642;
            }
          }
        }
      }
      if ((z.d == null) && (!(paramd instanceof d.g.a.h.g)) && (!(paramd instanceof h))) {
        f.add(paramd);
      }
      label642:
      if ((t.d != null) || (v.d != null))
      {
        localObject1 = t.d;
        if ((localObject1 == null) || (b != D) || (v.d != null))
        {
          localObject1 = v.d;
          if ((localObject1 == null) || (b != D) || (t.d != null))
          {
            localObject1 = t.d;
            if (localObject1 == null) {
              break label837;
            }
            localObject2 = b;
            localObject1 = D;
            if (localObject2 != localObject1) {
              break label837;
            }
            localObject2 = v.d;
            if ((localObject2 == null) || (b != localObject1)) {
              break label837;
            }
          }
        }
      }
      if ((z.d == null) && (w.d == null) && (!(paramd instanceof d.g.a.h.g)) && (!(paramd instanceof h))) {
        g.add(paramd);
      }
      label837:
      if ((paramd instanceof h))
      {
        d = false;
        D0 = false;
        b0 = false;
        if (paramBoolean) {
          return false;
        }
        localObject1 = (h)paramd;
        for (i1 = 0; i1 < l0; i1++) {
          if (!a(k0[i1], paramf, paramList, paramBoolean)) {
            return false;
          }
        }
      }
      int i2 = A.length;
      for (int i1 = 0; i1 < i2; i1++)
      {
        d.g.a.h.c localc = A[i1];
        localObject2 = d;
        if ((localObject2 != null) && (b != D))
        {
          if (c == c.c.CENTER)
          {
            d = false;
            D0 = false;
            b0 = false;
            if (paramBoolean) {
              return false;
            }
          }
          else
          {
            localObject1 = a;
            if ((localObject2 != null) && (d != localc)) {
              a.a.add(localObject1);
            }
          }
          if (!a(d.b, paramf, paramList, paramBoolean)) {
            return false;
          }
        }
      }
      return true;
    }
    if (localObject1 != paramf)
    {
      a.addAll(a);
      f.addAll(p.f);
      g.addAll(p.g);
      if (!p.d) {
        d = false;
      }
      paramList.remove(p);
      paramd = p.a.iterator();
      while (paramd.hasNext()) {
        nextp = paramf;
      }
    }
    return true;
  }
  
  /* Error */
  public static boolean a(File paramFile, Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: invokevirtual 1938	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   5: astore_1
    //   6: aload_0
    //   7: aload_1
    //   8: invokestatic 1941	d/b/a/s:a	(Ljava/io/File;Ljava/io/InputStream;)Z
    //   11: istore_3
    //   12: aload_1
    //   13: ifnull +9 -> 22
    //   16: aload_1
    //   17: invokeinterface 1944 1 0
    //   22: iload_3
    //   23: ireturn
    //   24: astore_0
    //   25: goto +6 -> 31
    //   28: astore_0
    //   29: aconst_null
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +9 -> 41
    //   35: aload_1
    //   36: invokeinterface 1944 1 0
    //   41: aload_0
    //   42: athrow
    //   43: astore_0
    //   44: goto -22 -> 22
    //   47: astore_1
    //   48: goto -7 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	paramFile	File
    //   0	51	1	paramResources	Resources
    //   0	51	2	paramInt	int
    //   11	12	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	12	24	finally
    //   0	6	28	finally
    //   16	22	43	java/io/IOException
    //   35	41	47	java/io/IOException
  }
  
  /* Error */
  public static boolean a(File paramFile, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: invokestatic 1950	android/os/StrictMode:allowThreadDiskWrites	()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_3
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 4
    //   11: astore 5
    //   13: new 1952	java/io/FileOutputStream
    //   16: astore 6
    //   18: aload 4
    //   20: astore 5
    //   22: aload 6
    //   24: aload_0
    //   25: iconst_0
    //   26: invokespecial 1955	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   29: sipush 1024
    //   32: newarray <illegal type>
    //   34: astore_0
    //   35: aload_1
    //   36: aload_0
    //   37: invokevirtual 1961	java/io/InputStream:read	([B)I
    //   40: istore 7
    //   42: iload 7
    //   44: iconst_m1
    //   45: if_icmpeq +15 -> 60
    //   48: aload 6
    //   50: aload_0
    //   51: iconst_0
    //   52: iload 7
    //   54: invokevirtual 1965	java/io/FileOutputStream:write	([BII)V
    //   57: goto -22 -> 35
    //   60: aload 6
    //   62: invokevirtual 1966	java/io/FileOutputStream:close	()V
    //   65: aload_2
    //   66: invokestatic 1970	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   69: iconst_1
    //   70: ireturn
    //   71: astore_0
    //   72: aload 6
    //   74: astore 5
    //   76: goto +89 -> 165
    //   79: astore_1
    //   80: aload 6
    //   82: astore_0
    //   83: goto +10 -> 93
    //   86: astore_0
    //   87: goto +78 -> 165
    //   90: astore_1
    //   91: aload_3
    //   92: astore_0
    //   93: aload_0
    //   94: astore 5
    //   96: new 111	java/lang/StringBuilder
    //   99: astore 6
    //   101: aload_0
    //   102: astore 5
    //   104: aload 6
    //   106: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   109: aload_0
    //   110: astore 5
    //   112: aload 6
    //   114: ldc_w 1972
    //   117: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_0
    //   122: astore 5
    //   124: aload 6
    //   126: aload_1
    //   127: invokevirtual 1975	java/io/IOException:getMessage	()Ljava/lang/String;
    //   130: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_0
    //   135: astore 5
    //   137: ldc_w 1977
    //   140: aload 6
    //   142: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 669	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   148: pop
    //   149: aload_0
    //   150: ifnull +9 -> 159
    //   153: aload_0
    //   154: invokeinterface 1944 1 0
    //   159: aload_2
    //   160: invokestatic 1970	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   163: iconst_0
    //   164: ireturn
    //   165: aload 5
    //   167: ifnull +10 -> 177
    //   170: aload 5
    //   172: invokeinterface 1944 1 0
    //   177: aload_2
    //   178: invokestatic 1970	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   181: aload_0
    //   182: athrow
    //   183: astore_0
    //   184: goto -119 -> 65
    //   187: astore_0
    //   188: goto -29 -> 159
    //   191: astore_1
    //   192: goto -15 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramFile	File
    //   0	195	1	paramInputStream	java.io.InputStream
    //   3	175	2	localThreadPolicy	android.os.StrictMode.ThreadPolicy
    //   5	87	3	localObject1	Object
    //   7	12	4	localObject2	Object
    //   11	160	5	localObject3	Object
    //   16	125	6	localObject4	Object
    //   40	13	7	i1	int
    // Exception table:
    //   from	to	target	type
    //   29	35	71	finally
    //   35	42	71	finally
    //   48	57	71	finally
    //   29	35	79	java/io/IOException
    //   35	42	79	java/io/IOException
    //   48	57	79	java/io/IOException
    //   13	18	86	finally
    //   22	29	86	finally
    //   96	101	86	finally
    //   104	109	86	finally
    //   112	121	86	finally
    //   124	134	86	finally
    //   137	149	86	finally
    //   13	18	90	java/io/IOException
    //   22	29	90	java/io/IOException
    //   60	65	183	java/io/IOException
    //   153	159	187	java/io/IOException
    //   170	177	191	java/io/IOException
  }
  
  public static boolean a(XmlPullParser paramXmlPullParser, String paramString)
  {
    boolean bool;
    if (paramXmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", paramString) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(d.i.c.b[] paramArrayOfb1, d.i.c.b[] paramArrayOfb2)
  {
    if ((paramArrayOfb1 != null) && (paramArrayOfb2 != null))
    {
      if (paramArrayOfb1.length != paramArrayOfb2.length) {
        return false;
      }
      int i1 = 0;
      while (i1 < paramArrayOfb1.length) {
        if ((a == a) && (b.length == b.length)) {
          i1++;
        } else {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public static float[] a(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
    {
      int i1 = paramArrayOfFloat.length;
      if ((paramInt1 >= 0) && (paramInt1 <= i1))
      {
        paramInt2 -= paramInt1;
        i1 = Math.min(paramInt2, i1 - paramInt1);
        float[] arrayOfFloat = new float[paramInt2];
        System.arraycopy(paramArrayOfFloat, paramInt1, arrayOfFloat, 0, i1);
        return arrayOfFloat;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public static d.i.c.b[] a(d.i.c.b[] paramArrayOfb)
  {
    if (paramArrayOfb == null) {
      return null;
    }
    d.i.c.b[] arrayOfb = new d.i.c.b[paramArrayOfb.length];
    for (int i1 = 0; i1 < paramArrayOfb.length; i1++) {
      arrayOfb[i1] = new d.i.c.b(paramArrayOfb[i1]);
    }
    return arrayOfb;
  }
  
  public static int b(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2)
  {
    if (!a(paramXmlPullParser, paramString)) {
      return paramInt2;
    }
    return paramTypedArray.getInt(paramInt1, paramInt2);
  }
  
  public static int b(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramDrawable.getLayoutDirection();
    }
    if (!l)
    {
      try
      {
        Method localMethod1 = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
        k = localMethod1;
        localMethod1.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", localNoSuchMethodException);
      }
      l = true;
    }
    Method localMethod2 = k;
    if (localMethod2 != null) {
      try
      {
        int i1 = ((Integer)localMethod2.invoke(paramDrawable, new Object[0])).intValue();
        return i1;
      }
      catch (Exception paramDrawable)
      {
        Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", paramDrawable);
        k = null;
      }
    }
    return 0;
  }
  
  public static int b(Parcel paramParcel)
  {
    int i1 = paramParcel.readInt();
    int i2 = h(paramParcel, i1);
    int i3 = paramParcel.dataPosition();
    if ((0xFFFF & i1) != 20293)
    {
      localObject = String.valueOf(Integer.toHexString(i1));
      if (((String)localObject).length() != 0) {
        localObject = "Expected object header. Got 0x".concat((String)localObject);
      } else {
        localObject = new String("Expected object header. Got 0x");
      }
      throw new e.c.a.a.b.j.s.b((String)localObject, paramParcel);
    }
    i2 += i3;
    if ((i2 >= i3) && (i2 <= paramParcel.dataSize())) {
      return i2;
    }
    Object localObject = new StringBuilder(54);
    ((StringBuilder)localObject).append("Size read is invalid start=");
    ((StringBuilder)localObject).append(i3);
    ((StringBuilder)localObject).append(" end=");
    ((StringBuilder)localObject).append(i2);
    throw new e.c.a.a.b.j.s.b(((StringBuilder)localObject).toString(), paramParcel);
  }
  
  public static int b(RecyclerView.t paramt, r paramr, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean)
  {
    if ((paramLayoutManager.d() != 0) && (paramt.a() != 0) && (paramView1 != null) && (paramView2 != null))
    {
      if (!paramBoolean) {
        return paramt.a();
      }
      int i1 = paramr.a(paramView2);
      int i2 = paramr.b(paramView1);
      int i3 = Math.abs(paramLayoutManager.a(paramView1) - paramLayoutManager.a(paramView2));
      return (int)((i1 - i2) / (i3 + 1) * paramt.a());
    }
    return 0;
  }
  
  public static <T> T b(T paramT, Object paramObject)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(String.valueOf(paramObject));
  }
  
  public static String b(Context paramContext, ComponentName paramComponentName)
  {
    Object localObject = paramContext.getPackageManager();
    int i1 = Build.VERSION.SDK_INT;
    i1 = 640;
    int i2 = Build.VERSION.SDK_INT;
    if (i2 >= 29) {
      i1 = 269222528;
    } else if (i2 >= 24) {
      i1 = 787072;
    }
    localObject = ((PackageManager)localObject).getActivityInfo(paramComponentName, i1);
    paramComponentName = parentActivityName;
    if (paramComponentName != null) {
      return paramComponentName;
    }
    paramComponentName = metaData;
    if (paramComponentName == null) {
      return null;
    }
    localObject = paramComponentName.getString("android.support.PARENT_ACTIVITY");
    if (localObject == null) {
      return null;
    }
    paramComponentName = (ComponentName)localObject;
    if (((String)localObject).charAt(0) == '.')
    {
      paramComponentName = new StringBuilder();
      paramComponentName.append(paramContext.getPackageName());
      paramComponentName.append((String)localObject);
      paramComponentName = paramComponentName.toString();
    }
    return paramComponentName;
  }
  
  public static String b(Parcel paramParcel, int paramInt)
  {
    paramInt = h(paramParcel, paramInt);
    int i1 = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    String str = paramParcel.readString();
    paramParcel.setDataPosition(i1 + paramInt);
    return str;
  }
  
  public static void b(Drawable paramDrawable, int paramInt)
  {
    paramDrawable.setTint(paramInt);
  }
  
  public static void b(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    paramInt1 = h(paramParcel, paramInt1);
    if (paramInt1 == paramInt2) {
      return;
    }
    String str = Integer.toHexString(paramInt1);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 46);
    localStringBuilder.append("Expected size ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" got ");
    localStringBuilder.append(paramInt1);
    throw new e.c.a.a.b.j.s.b(e.a.a.a.a.a(localStringBuilder, " (0x", str, ")"), paramParcel);
  }
  
  public static void b(TextView paramTextView, int paramInt)
  {
    a(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    int i1;
    if (paramTextView.getIncludeFontPadding()) {
      i1 = bottom;
    } else {
      i1 = descent;
    }
    if (paramInt > Math.abs(i1)) {
      paramTextView.setPadding(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop(), paramTextView.getPaddingRight(), paramInt - i1);
    }
  }
  
  public static void b(Object paramObject)
  {
    if (!d)
    {
      try
      {
        c = Class.forName("android.content.res.ThemedResourceCache");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", localClassNotFoundException);
      }
      d = true;
    }
    Object localObject1 = c;
    if (localObject1 == null) {
      return;
    }
    if (!f)
    {
      try
      {
        localObject1 = ((Class)localObject1).getDeclaredField("mUnthemedEntries");
        e = (Field)localObject1;
        ((Field)localObject1).setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", localNoSuchFieldException);
      }
      f = true;
    }
    Field localField = e;
    if (localField == null) {
      return;
    }
    Object localObject2 = null;
    try
    {
      paramObject = (LongSparseArray)localField.get(paramObject);
    }
    catch (IllegalAccessException paramObject)
    {
      Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", (Throwable)paramObject);
      paramObject = localObject2;
    }
    if (paramObject != null) {
      ((LongSparseArray)paramObject).clear();
    }
  }
  
  public static boolean b(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 28) && (paramInt <= 31)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static d.i.c.b[] b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 1;
    int i2 = 0;
    while (i1 < paramString.length())
    {
      int i3;
      while (i1 < paramString.length())
      {
        i3 = paramString.charAt(i1);
        if ((((i3 - 90) * (i3 - 65) <= 0) || ((i3 - 122) * (i3 - 97) <= 0)) && (i3 != 101) && (i3 != 69)) {
          break;
        }
        i1++;
      }
      String str = paramString.substring(i2, i1).trim();
      if (str.length() > 0)
      {
        if ((str.charAt(0) != 'z') && (str.charAt(0) != 'Z')) {
          try
          {
            arrayOfFloat = new float[str.length()];
            int i4 = str.length();
            i3 = 1;
            for (int i5 = 0; i3 < i4; i5 = i2)
            {
              int i6 = 0;
              i2 = 0;
              int i7 = 0;
              int i8 = 0;
              int i10;
              for (int i9 = i3;; i9++)
              {
                i10 = i2;
                if (i9 >= str.length()) {
                  break;
                }
                i10 = str.charAt(i9);
                int i11;
                if (i10 != 32) {
                  if ((i10 != 69) && (i10 != 101)) {
                    i11 = i2;
                  }
                }
                switch (i10)
                {
                default: 
                  i10 = i6;
                  i11 = i2;
                  i12 = i7;
                  break;
                case 46: 
                  if (i7 == 0)
                  {
                    i12 = 1;
                    i10 = i6;
                    i11 = i2;
                  }
                  break;
                case 45: 
                  i10 = i6;
                  i11 = i2;
                  i12 = i7;
                  if (i9 == i3) {
                    break label344;
                  }
                  i10 = i6;
                  i11 = i2;
                  i12 = i7;
                  if (i8 != 0) {
                    break label344;
                  }
                  i11 = 1;
                  break label337;
                  i8 = 1;
                  break label358;
                  i11 = i2;
                }
                label337:
                i10 = 1;
                int i12 = i7;
                label344:
                i8 = 0;
                i7 = i12;
                i2 = i11;
                i6 = i10;
                label358:
                if (i6 != 0)
                {
                  i10 = i2;
                  break;
                }
              }
              i2 = i5;
              if (i3 < i9)
              {
                arrayOfFloat[i5] = Float.parseFloat(str.substring(i3, i9));
                i2 = i5 + 1;
              }
              if (i10 == 0) {
                i9++;
              }
              i3 = i9;
            }
            arrayOfFloat = a(arrayOfFloat, 0, i5);
          }
          catch (NumberFormatException paramString)
          {
            throw new RuntimeException(e.a.a.a.a.a("error in parsing \"", str, "\""), paramString);
          }
        }
        float[] arrayOfFloat = new float[0];
        localArrayList.add(new d.i.c.b(str.charAt(0), arrayOfFloat));
      }
      i2 = i1;
      i1++;
    }
    if ((i1 - i2 == 1) && (i2 < paramString.length())) {
      localArrayList.add(new d.i.c.b(paramString.charAt(i2), new float[0]));
    }
    return (d.i.c.b[])localArrayList.toArray(new d.i.c.b[localArrayList.size()]);
  }
  
  public static <T> T[] b(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    int i1 = h(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i1 == 0) {
      return null;
    }
    paramCreator = paramParcel.createTypedArray(paramCreator);
    paramParcel.setDataPosition(paramInt + i1);
    return paramCreator;
  }
  
  public static Path c(String paramString)
  {
    Path localPath = new Path();
    d.i.c.b[] arrayOfb = b(paramString);
    if (arrayOfb != null) {
      try
      {
        d.i.c.b.a(arrayOfb, localPath);
        return localPath;
      }
      catch (RuntimeException localRuntimeException)
      {
        throw new RuntimeException(e.a.a.a.a.b("Error in parsing ", paramString), localRuntimeException);
      }
    }
    return null;
  }
  
  public static Drawable c(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramDrawable;
    }
    if (!(paramDrawable instanceof d.i.c.j.a)) {
      return new d.i.c.j.d(paramDrawable);
    }
    return paramDrawable;
  }
  
  public static o c(Object paramObject)
  {
    return new o(paramObject, null);
  }
  
  public static <T> ArrayList<T> c(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    paramInt = h(paramParcel, paramInt);
    int i1 = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    paramCreator = paramParcel.createTypedArrayList(paramCreator);
    paramParcel.setDataPosition(i1 + paramInt);
    return paramCreator;
  }
  
  public static void c(Parcel paramParcel, int paramInt)
  {
    if (paramParcel.dataPosition() == paramInt) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(37);
    localStringBuilder.append("Overread allowed size end=");
    localStringBuilder.append(paramInt);
    throw new e.c.a.a.b.j.s.b(localStringBuilder.toString(), paramParcel);
  }
  
  public static void c(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 65535)
    {
      paramParcel.writeInt(paramInt1 | 0xFFFF0000);
      paramParcel.writeInt(paramInt2);
      return;
    }
    paramParcel.writeInt(paramInt1 | paramInt2 << 16);
  }
  
  public static void c(TextView paramTextView, int paramInt)
  {
    a(paramInt);
    int i1 = paramTextView.getPaint().getFontMetricsInt(null);
    if (paramInt != i1) {
      paramTextView.setLineSpacing(paramInt - i1, 1.0F);
    }
  }
  
  public static boolean c(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static void d(TextView paramTextView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramTextView.setTextAppearance(paramInt);
    } else {
      paramTextView.setTextAppearance(paramTextView.getContext(), paramInt);
    }
  }
  
  public static boolean d(Parcel paramParcel, int paramInt)
  {
    b(paramParcel, paramInt, 4);
    return paramParcel.readInt() != 0;
  }
  
  public static IBinder e(Parcel paramParcel, int paramInt)
  {
    int i1 = h(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i1 == 0) {
      return null;
    }
    IBinder localIBinder = paramParcel.readStrongBinder();
    paramParcel.setDataPosition(paramInt + i1);
    return localIBinder;
  }
  
  public static int f(Parcel paramParcel, int paramInt)
  {
    b(paramParcel, paramInt, 4);
    return paramParcel.readInt();
  }
  
  public static long g(Parcel paramParcel, int paramInt)
  {
    b(paramParcel, paramInt, 8);
    return paramParcel.readLong();
  }
  
  public static int h(Parcel paramParcel, int paramInt)
  {
    if ((paramInt & 0xFFFF0000) != -65536) {
      return paramInt >> 16 & 0xFFFF;
    }
    return paramParcel.readInt();
  }
  
  public static void i(Parcel paramParcel, int paramInt)
  {
    paramInt = h(paramParcel, paramInt);
    paramParcel.setDataPosition(paramParcel.dataPosition() + paramInt);
  }
  
  public static int j(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(paramInt | 0xFFFF0000);
    paramParcel.writeInt(0);
    return paramParcel.dataPosition();
  }
  
  public static void k(Parcel paramParcel, int paramInt)
  {
    int i1 = paramParcel.dataPosition();
    paramParcel.setDataPosition(paramInt - 4);
    paramParcel.writeInt(i1 - paramInt);
    paramParcel.setDataPosition(i1);
  }
}

/* Location:
 * Qualified Name:     d.b.a.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */