package d.i.b.b;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.core.R.styleable;
import d.b.a.r;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a
{
  public final Shader a;
  public final ColorStateList b;
  public int c;
  
  public a(Shader paramShader, ColorStateList paramColorStateList, int paramInt)
  {
    a = paramShader;
    b = paramColorStateList;
    c = paramInt;
  }
  
  public static a a(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    XmlResourceParser localXmlResourceParser = paramResources.getXml(paramInt);
    AttributeSet localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
    do
    {
      paramInt = localXmlResourceParser.next();
    } while ((paramInt != 2) && (paramInt != 1));
    if (paramInt == 2)
    {
      Object localObject = localXmlResourceParser.getName();
      paramInt = -1;
      int i = ((String)localObject).hashCode();
      if (i != 89650992)
      {
        if ((i == 1191572447) && (((String)localObject).equals("selector"))) {
          paramInt = 0;
        }
      }
      else if (((String)localObject).equals("gradient")) {
        paramInt = 1;
      }
      if (paramInt != 0)
      {
        if (paramInt == 1)
        {
          localObject = localXmlResourceParser.getName();
          if (((String)localObject).equals("gradient"))
          {
            localObject = r.a(paramResources, paramTheme, localAttributeSet, R.styleable.GradientColor);
            float f1 = r.a((TypedArray)localObject, localXmlResourceParser, "startX", R.styleable.GradientColor_android_startX, 0.0F);
            float f2 = r.a((TypedArray)localObject, localXmlResourceParser, "startY", R.styleable.GradientColor_android_startY, 0.0F);
            float f3 = r.a((TypedArray)localObject, localXmlResourceParser, "endX", R.styleable.GradientColor_android_endX, 0.0F);
            float f4 = r.a((TypedArray)localObject, localXmlResourceParser, "endY", R.styleable.GradientColor_android_endY, 0.0F);
            float f5 = r.a((TypedArray)localObject, localXmlResourceParser, "centerX", R.styleable.GradientColor_android_centerX, 0.0F);
            float f6 = r.a((TypedArray)localObject, localXmlResourceParser, "centerY", R.styleable.GradientColor_android_centerY, 0.0F);
            int j = r.b((TypedArray)localObject, localXmlResourceParser, "type", R.styleable.GradientColor_android_type, 0);
            i = r.a((TypedArray)localObject, localXmlResourceParser, "startColor", R.styleable.GradientColor_android_startColor, 0);
            boolean bool1 = r.a(localXmlResourceParser, "centerColor");
            int k = r.a((TypedArray)localObject, localXmlResourceParser, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
            int m = r.a((TypedArray)localObject, localXmlResourceParser, "endColor", R.styleable.GradientColor_android_endColor, 0);
            paramInt = r.b((TypedArray)localObject, localXmlResourceParser, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
            float f7 = r.a((TypedArray)localObject, localXmlResourceParser, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, 0.0F);
            ((TypedArray)localObject).recycle();
            int n = localXmlResourceParser.getDepth() + 1;
            ArrayList localArrayList1 = new ArrayList(20);
            ArrayList localArrayList2 = new ArrayList(20);
            localObject = paramResources;
            label556:
            for (;;)
            {
              int i1 = localXmlResourceParser.next();
              if (i1 == 1) {
                break;
              }
              int i2 = localXmlResourceParser.getDepth();
              if ((i2 < n) && (i1 == 3)) {
                break;
              }
              if (i1 == 2)
              {
                if (i2 <= n)
                {
                  if (!localXmlResourceParser.getName().equals("item")) {
                    break label556;
                  }
                  localObject = r.a((Resources)localObject, paramTheme, localAttributeSet, R.styleable.GradientColorItem);
                  boolean bool2 = ((TypedArray)localObject).hasValue(R.styleable.GradientColorItem_android_color);
                  boolean bool3 = ((TypedArray)localObject).hasValue(R.styleable.GradientColorItem_android_offset);
                  if ((bool2) && (bool3))
                  {
                    i1 = ((TypedArray)localObject).getColor(R.styleable.GradientColorItem_android_color, 0);
                    float f8 = ((TypedArray)localObject).getFloat(R.styleable.GradientColorItem_android_offset, 0.0F);
                    ((TypedArray)localObject).recycle();
                    localArrayList2.add(Integer.valueOf(i1));
                    localArrayList1.add(Float.valueOf(f8));
                  }
                  else
                  {
                    paramResources = new StringBuilder();
                    paramResources.append(localXmlResourceParser.getPositionDescription());
                    paramResources.append(": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                    throw new XmlPullParserException(paramResources.toString());
                  }
                }
                localObject = paramResources;
              }
            }
            if (localArrayList2.size() > 0) {
              paramResources = new f(localArrayList2, localArrayList1);
            } else {
              paramResources = null;
            }
            if (paramResources == null) {
              for (;;)
              {
                if (bool1) {
                  paramResources = new f(i, k, m);
                } else {
                  paramResources = new f(i, m);
                }
              }
            }
            if (j != 1)
            {
              if (j != 2)
              {
                paramTheme = a;
                localObject = b;
                if (paramInt != 1)
                {
                  if (paramInt != 2) {
                    paramResources = Shader.TileMode.CLAMP;
                  } else {
                    paramResources = Shader.TileMode.MIRROR;
                  }
                }
                else {
                  paramResources = Shader.TileMode.REPEAT;
                }
                paramResources = new LinearGradient(f1, f2, f3, f4, paramTheme, (float[])localObject, paramResources);
              }
              else
              {
                paramResources = new SweepGradient(f5, f6, a, b);
              }
            }
            else
            {
              if (f7 <= 0.0F) {
                break label800;
              }
              paramTheme = a;
              localObject = b;
              if (paramInt != 1)
              {
                if (paramInt != 2) {
                  paramResources = Shader.TileMode.CLAMP;
                } else {
                  paramResources = Shader.TileMode.MIRROR;
                }
              }
              else {
                paramResources = Shader.TileMode.REPEAT;
              }
              paramResources = new RadialGradient(f5, f6, f7, paramTheme, (float[])localObject, paramResources);
            }
            return new a(paramResources, null, 0);
            label800:
            throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
          }
          paramResources = new StringBuilder();
          paramResources.append(localXmlResourceParser.getPositionDescription());
          paramResources.append(": invalid gradient color tag ");
          paramResources.append((String)localObject);
          throw new XmlPullParserException(paramResources.toString());
        }
        paramResources = new StringBuilder();
        paramResources.append(localXmlResourceParser.getPositionDescription());
        paramResources.append(": unsupported complex color tag ");
        paramResources.append((String)localObject);
        throw new XmlPullParserException(paramResources.toString());
      }
      paramResources = r.a(paramResources, localXmlResourceParser, localAttributeSet, paramTheme);
      return new a(null, paramResources, paramResources.getDefaultColor());
    }
    throw new XmlPullParserException("No start tag found");
  }
  
  public boolean a()
  {
    boolean bool;
    if (a != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(int[] paramArrayOfInt)
  {
    if (b())
    {
      ColorStateList localColorStateList = b;
      int i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
      if (i != c)
      {
        bool = true;
        c = i;
        break label44;
      }
    }
    boolean bool = false;
    label44:
    return bool;
  }
  
  public boolean b()
  {
    if (a == null)
    {
      ColorStateList localColorStateList = b;
      if ((localColorStateList != null) && (localColorStateList.isStateful())) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.d.i.b.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */