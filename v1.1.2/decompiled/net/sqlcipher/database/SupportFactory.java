package net.sqlcipher.database;

import d.w.a.c;
import d.w.a.c.b;
import d.w.a.c.c;

public class SupportFactory
  implements c.c
{
  public final boolean clearPassphrase;
  public final SQLiteDatabaseHook hook;
  public final byte[] passphrase;
  
  public SupportFactory(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, null);
  }
  
  public SupportFactory(byte[] paramArrayOfByte, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    this(paramArrayOfByte, paramSQLiteDatabaseHook, true);
  }
  
  public SupportFactory(byte[] paramArrayOfByte, SQLiteDatabaseHook paramSQLiteDatabaseHook, boolean paramBoolean)
  {
    passphrase = paramArrayOfByte;
    hook = paramSQLiteDatabaseHook;
    clearPassphrase = paramBoolean;
  }
  
  public c create(c.b paramb)
  {
    return new SupportHelper(paramb, passphrase, hook, clearPassphrase);
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SupportFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */