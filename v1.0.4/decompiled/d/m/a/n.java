package d.m.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import androidx.fragment.R.styleable;
import androidx.fragment.app.Fragment;
import e.a.a.a.a;

public class n
  implements LayoutInflater.Factory2
{
  public final p x;
  
  public n(p paramp)
  {
    x = paramp;
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (j.class.getName().equals(paramString)) {
      return new j(paramContext, paramAttributeSet, x);
    }
    boolean bool = "fragment".equals(paramString);
    paramString = null;
    if (!bool) {
      return null;
    }
    String str1 = paramAttributeSet.getAttributeValue(null, "class");
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Fragment);
    String str2 = str1;
    if (str1 == null) {
      str2 = localTypedArray.getString(R.styleable.Fragment_android_name);
    }
    int i = localTypedArray.getResourceId(R.styleable.Fragment_android_id, -1);
    str1 = localTypedArray.getString(R.styleable.Fragment_android_tag);
    localTypedArray.recycle();
    if ((str2 != null) && (l.b(paramContext.getClassLoader(), str2)))
    {
      int j;
      if (paramView != null) {
        j = paramView.getId();
      } else {
        j = 0;
      }
      if ((j == -1) && (i == -1) && (str1 == null))
      {
        paramView = new StringBuilder();
        paramView.append(paramAttributeSet.getPositionDescription());
        paramView.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
        paramView.append(str2);
        throw new IllegalArgumentException(paramView.toString());
      }
      paramView = paramString;
      if (i != -1) {
        paramView = x.b(i);
      }
      paramString = paramView;
      if (paramView == null)
      {
        paramString = paramView;
        if (str1 != null) {
          paramString = x.b(str1);
        }
      }
      paramView = paramString;
      if (paramString == null)
      {
        paramView = paramString;
        if (j != -1) {
          paramView = x.b(j);
        }
      }
      if (p.c(2))
      {
        paramString = a.a("onCreateView: id=0x");
        paramString.append(Integer.toHexString(i));
        paramString.append(" fname=");
        paramString.append(str2);
        paramString.append(" existing=");
        paramString.append(paramView);
        Log.v("FragmentManager", paramString.toString());
      }
      if (paramView == null)
      {
        paramView = x.h().a(paramContext.getClassLoader(), str2);
        mFromLayout = true;
        int k;
        if (i != 0) {
          k = i;
        } else {
          k = j;
        }
        mFragmentId = k;
        mContainerId = j;
        mTag = str1;
        mInLayout = true;
        paramString = x;
        mFragmentManager = paramString;
        paramString = n;
        mHost = paramString;
        paramView.onInflate(y, paramAttributeSet, mSavedFragmentState);
        x.a(paramView);
        paramString = x;
        paramString.a(paramView, m);
      }
      else
      {
        if (mInLayout) {
          break label606;
        }
        mInLayout = true;
        paramString = x.n;
        mHost = paramString;
        paramView.onInflate(y, paramAttributeSet, mSavedFragmentState);
      }
      paramString = x;
      if ((m < 1) && (mFromLayout))
      {
        paramString.a(paramView, 1);
      }
      else
      {
        paramString = x;
        paramString.a(paramView, m);
      }
      paramString = mView;
      if (paramString != null)
      {
        if (i != 0) {
          paramString.setId(i);
        }
        if (mView.getTag() == null) {
          mView.setTag(str1);
        }
        return mView;
      }
      throw new IllegalStateException(a.a("Fragment ", str2, " did not create a view."));
      label606:
      paramView = new StringBuilder();
      paramView.append(paramAttributeSet.getPositionDescription());
      paramView.append(": Duplicate id 0x");
      paramView.append(Integer.toHexString(i));
      paramView.append(", tag ");
      paramView.append(str1);
      paramView.append(", or parent id 0x");
      paramView.append(Integer.toHexString(j));
      paramView.append(" with another fragment for ");
      paramView.append(str2);
      throw new IllegalArgumentException(paramView.toString());
    }
    return null;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
}

/* Location:
 * Qualified Name:     base.d.m.a.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */