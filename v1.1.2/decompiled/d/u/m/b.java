package d.u.m;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.MatrixCursor;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import d.u.g;
import d.w.a.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class b
{
  public static int a(File paramFile)
  {
    IOException localIOException = null;
    Object localObject = localIOException;
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localObject = localIOException;
      FileInputStream localFileInputStream = new java/io/FileInputStream;
      localObject = localIOException;
      localFileInputStream.<init>(paramFile);
      localObject = localIOException;
      paramFile = localFileInputStream.getChannel();
      localObject = paramFile;
      paramFile.tryLock(60L, 4L, true);
      localObject = paramFile;
      paramFile.position(60L);
      localObject = paramFile;
      if (paramFile.read(localByteBuffer) == 4)
      {
        localObject = paramFile;
        localByteBuffer.rewind();
        localObject = paramFile;
        int i = localByteBuffer.getInt();
        paramFile.close();
        return i;
      }
      localObject = paramFile;
      localIOException = new java/io/IOException;
      localObject = paramFile;
      localIOException.<init>("Bad database header, unable to read 4 bytes at offset 60");
      localObject = paramFile;
      throw localIOException;
    }
    finally
    {
      if (localObject != null) {
        ((FileChannel)localObject).close();
      }
    }
  }
  
  public static Cursor a(g paramg, e parame, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    parame = paramg.a(parame, paramCancellationSignal);
    if ((paramBoolean) && ((parame instanceof AbstractWindowedCursor)))
    {
      paramg = (AbstractWindowedCursor)parame;
      int i = paramg.getCount();
      int j;
      if (paramg.hasWindow()) {
        j = paramg.getWindow().getNumRows();
      } else {
        j = i;
      }
      if ((Build.VERSION.SDK_INT < 23) || (j < i)) {
        try
        {
          paramCancellationSignal = new android/database/MatrixCursor;
          paramCancellationSignal.<init>(paramg.getColumnNames(), paramg.getCount());
          while (paramg.moveToNext())
          {
            parame = new Object[paramg.getColumnCount()];
            for (j = 0; j < paramg.getColumnCount(); j++)
            {
              i = paramg.getType(j);
              if (i != 0)
              {
                if (i != 1)
                {
                  if (i != 2)
                  {
                    if (i != 3)
                    {
                      if (i == 4)
                      {
                        parame[j] = paramg.getBlob(j);
                      }
                      else
                      {
                        parame = new java/lang/IllegalStateException;
                        parame.<init>();
                        throw parame;
                      }
                    }
                    else {
                      parame[j] = paramg.getString(j);
                    }
                  }
                  else {
                    parame[j] = Double.valueOf(paramg.getDouble(j));
                  }
                }
                else {
                  parame[j] = Long.valueOf(paramg.getLong(j));
                }
              }
              else {
                parame[j] = null;
              }
            }
            paramCancellationSignal.addRow(parame);
          }
          return paramCancellationSignal;
        }
        finally
        {
          paramg.close();
        }
      }
    }
    return parame;
  }
}

/* Location:
 * Qualified Name:     d.u.m.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */