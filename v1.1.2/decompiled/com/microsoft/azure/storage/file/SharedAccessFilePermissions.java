package com.microsoft.azure.storage.file;

public enum SharedAccessFilePermissions
{
  static
  {
    CREATE = new SharedAccessFilePermissions("CREATE", 1);
    WRITE = new SharedAccessFilePermissions("WRITE", 2);
    DELETE = new SharedAccessFilePermissions("DELETE", 3);
    SharedAccessFilePermissions localSharedAccessFilePermissions = new SharedAccessFilePermissions("LIST", 4);
    LIST = localSharedAccessFilePermissions;
    $VALUES = new SharedAccessFilePermissions[] { READ, CREATE, WRITE, DELETE, localSharedAccessFilePermissions };
  }
  
  public SharedAccessFilePermissions() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.SharedAccessFilePermissions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */