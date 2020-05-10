package e.c.a.b.a;

import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R.id;

public class c
  extends Property<ViewGroup, Float>
{
  public static final Property<ViewGroup, Float> a = new c("childrenAlpha");
  
  public c(String paramString)
  {
    super(Float.class, paramString);
  }
  
  public Object get(Object paramObject)
  {
    paramObject = (Float)((ViewGroup)paramObject).getTag(R.id.mtrl_internal_children_alpha_tag);
    if (paramObject == null) {
      paramObject = Float.valueOf(1.0F);
    }
    return paramObject;
  }
  
  public void set(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (ViewGroup)paramObject1;
    float f = ((Float)paramObject2).floatValue();
    ((ViewGroup)paramObject1).setTag(R.id.mtrl_internal_children_alpha_tag, Float.valueOf(f));
    int i = ((ViewGroup)paramObject1).getChildCount();
    for (int j = 0; j < i; j++) {
      ((ViewGroup)paramObject1).getChildAt(j).setAlpha(f);
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */