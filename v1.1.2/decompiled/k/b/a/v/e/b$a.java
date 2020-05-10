package k.b.a.v.e;

import android.content.Context;
import android.util.Log;
import l.d.b.g.a;

public class b$a
  extends b.b
{
  public b$a(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public void a(a parama, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Upgrading schema from version ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" to ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" by dropping all tables");
    Log.i("greenDAO", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DROP TABLE ");
    localStringBuilder.append("IF EXISTS ");
    localStringBuilder.append("\"MEASUREMENT\"");
    parama.execSQL(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DROP TABLE ");
    localStringBuilder.append("IF EXISTS ");
    localStringBuilder.append("\"BLUETOOTH_CONTACT\"");
    parama.execSQL(localStringBuilder.toString());
    a(parama);
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.e.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */