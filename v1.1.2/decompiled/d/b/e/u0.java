package d.b.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import d.b.a.s;
import d.f.f;
import d.i.b.b.b;
import d.i.b.b.g;
import d.i.c.c;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public class u0
{
  public final Context a;
  public final TypedArray b;
  public TypedValue c;
  
  public u0(Context paramContext, TypedArray paramTypedArray)
  {
    a = paramContext;
    b = paramTypedArray;
  }
  
  public static u0 a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    return new u0(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, paramInt1, paramInt2));
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return b.getColor(paramInt1, paramInt2);
  }
  
  public ColorStateList a(int paramInt)
  {
    if (b.hasValue(paramInt))
    {
      int i = b.getResourceId(paramInt, 0);
      if (i != 0)
      {
        ColorStateList localColorStateList = d.b.b.a.a.b(a, i);
        if (localColorStateList != null) {
          return localColorStateList;
        }
      }
    }
    return b.getColorStateList(paramInt);
  }
  
  public Typeface a(int paramInt1, int paramInt2, g paramg)
  {
    paramInt1 = b.getResourceId(paramInt1, 0);
    Object localObject1 = null;
    Object localObject3 = null;
    if (paramInt1 == 0) {
      return null;
    }
    if (c == null) {
      c = new TypedValue();
    }
    Context localContext = a;
    Object localObject4 = c;
    Object localObject5;
    if (localContext.isRestricted())
    {
      localObject3 = localObject1;
    }
    else
    {
      localObject5 = localContext.getResources();
      ((Resources)localObject5).getValue(paramInt1, (TypedValue)localObject4, true);
      localObject1 = string;
      if (localObject1 == null) {
        break label466;
      }
      localObject4 = ((CharSequence)localObject1).toString();
      Object localObject2;
      if (!((String)localObject4).startsWith("res/"))
      {
        localObject1 = localObject3;
        if (paramg != null)
        {
          paramg.a(-3, null);
          localObject1 = localObject3;
        }
      }
      else
      {
        localObject1 = (Typeface)c.b.a(c.a((Resources)localObject5, paramInt1, paramInt2));
        if (localObject1 != null)
        {
          if (paramg != null) {
            paramg.a((Typeface)localObject1, null);
          }
        }
        else
        {
          try
          {
            if (((String)localObject4).toLowerCase().endsWith(".xml"))
            {
              localObject1 = s.a(((Resources)localObject5).getXml(paramInt1), (Resources)localObject5);
              if (localObject1 == null)
              {
                Log.e("ResourcesCompat", "Failed to find font-family tag");
                localObject1 = localObject3;
                if (paramg != null)
                {
                  paramg.a(-3, null);
                  localObject1 = localObject3;
                }
              }
              else
              {
                localObject1 = c.a(localContext, (b)localObject1, (Resources)localObject5, paramInt1, paramInt2, paramg, null, true);
              }
            }
            else
            {
              localObject5 = c.a(localContext, (Resources)localObject5, paramInt1, (String)localObject4, paramInt2);
              localObject1 = localObject5;
              if (paramg != null) {
                if (localObject5 != null)
                {
                  paramg.a((Typeface)localObject5, null);
                  localObject1 = localObject5;
                }
                else
                {
                  paramg.a(-3, null);
                  localObject1 = localObject5;
                }
              }
            }
          }
          catch (IOException localIOException)
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("Failed to read xml resource ");
            ((StringBuilder)localObject5).append((String)localObject4);
            Log.e("ResourcesCompat", ((StringBuilder)localObject5).toString(), localIOException);
          }
          catch (XmlPullParserException localXmlPullParserException)
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("Failed to parse xml resource ");
            ((StringBuilder)localObject5).append((String)localObject4);
            Log.e("ResourcesCompat", ((StringBuilder)localObject5).toString(), localXmlPullParserException);
          }
          localObject2 = localObject3;
          if (paramg != null)
          {
            paramg.a(-3, null);
            localObject2 = localObject3;
          }
        }
      }
      localObject3 = localObject2;
      if (localObject2 == null) {
        if (paramg != null)
        {
          localObject3 = localObject2;
        }
        else
        {
          paramg = e.a.a.a.a.a("Font resource ID #0x");
          paramg.append(Integer.toHexString(paramInt1));
          paramg.append(" could not be retrieved.");
          throw new Resources.NotFoundException(paramg.toString());
        }
      }
    }
    return (Typeface)localObject3;
    label466:
    paramg = e.a.a.a.a.a("Resource \"");
    paramg.append(((Resources)localObject5).getResourceName(paramInt1));
    paramg.append("\" (");
    paramg.append(Integer.toHexString(paramInt1));
    paramg.append(") is not a Font: ");
    paramg.append(localObject4);
    throw new Resources.NotFoundException(paramg.toString());
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    return b.getBoolean(paramInt, paramBoolean);
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    return b.getDimensionPixelOffset(paramInt1, paramInt2);
  }
  
  public Drawable b(int paramInt)
  {
    if (b.hasValue(paramInt))
    {
      int i = b.getResourceId(paramInt, 0);
      if (i != 0) {
        return d.b.b.a.a.c(a, i);
      }
    }
    return b.getDrawable(paramInt);
  }
  
  public int c(int paramInt1, int paramInt2)
  {
    return b.getDimensionPixelSize(paramInt1, paramInt2);
  }
  
  public Drawable c(int paramInt)
  {
    if (b.hasValue(paramInt))
    {
      paramInt = b.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return j.a().a(a, paramInt, true);
      }
    }
    return null;
  }
  
  public int d(int paramInt1, int paramInt2)
  {
    return b.getInt(paramInt1, paramInt2);
  }
  
  public CharSequence d(int paramInt)
  {
    return b.getText(paramInt);
  }
  
  public int e(int paramInt1, int paramInt2)
  {
    return b.getInteger(paramInt1, paramInt2);
  }
  
  public boolean e(int paramInt)
  {
    return b.hasValue(paramInt);
  }
  
  public int f(int paramInt1, int paramInt2)
  {
    return b.getLayoutDimension(paramInt1, paramInt2);
  }
  
  public int g(int paramInt1, int paramInt2)
  {
    return b.getResourceId(paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     d.b.e.u0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */