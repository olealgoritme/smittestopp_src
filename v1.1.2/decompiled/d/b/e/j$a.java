package d.b.e;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import d.b.c.a.a;
import org.xmlpull.v1.XmlPullParser;

public class j$a
  implements j.d
{
  public Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    try
    {
      paramContext = a.a(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", paramContext);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     d.b.e.j.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */