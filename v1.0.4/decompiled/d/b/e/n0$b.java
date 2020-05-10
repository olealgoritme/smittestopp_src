package d.b.e;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import d.y.a.a.c;
import org.xmlpull.v1.XmlPullParser;

public class n0$b
  implements n0.d
{
  public Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    try
    {
      Resources localResources = paramContext.getResources();
      c localc = new d/y/a/a/c;
      localc.<init>(paramContext, null, null);
      localc.inflate(localResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return localc;
    }
    catch (Exception paramContext)
    {
      Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", paramContext);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.n0.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */