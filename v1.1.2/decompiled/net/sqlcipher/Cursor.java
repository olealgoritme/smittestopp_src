package net.sqlcipher;

public abstract interface Cursor
  extends android.database.Cursor
{
  public static final int FIELD_TYPE_BLOB = 4;
  public static final int FIELD_TYPE_FLOAT = 2;
  public static final int FIELD_TYPE_INTEGER = 1;
  public static final int FIELD_TYPE_NULL = 0;
  public static final int FIELD_TYPE_STRING = 3;
  
  public abstract int getType(int paramInt);
}

/* Location:
 * Qualified Name:     net.sqlcipher.Cursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */