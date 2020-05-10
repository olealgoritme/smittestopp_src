package e.c.a.b.a;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public class e
  extends Property<ImageView, Matrix>
{
  public final Matrix a = new Matrix();
  
  public e()
  {
    super(Matrix.class, "imageMatrixProperty");
  }
  
  public Object get(Object paramObject)
  {
    paramObject = (ImageView)paramObject;
    a.set(((ImageView)paramObject).getImageMatrix());
    return a;
  }
  
  public void set(Object paramObject1, Object paramObject2)
  {
    ((ImageView)paramObject1).setImageMatrix((Matrix)paramObject2);
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */