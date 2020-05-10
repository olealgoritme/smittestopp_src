package com.microsoft.azure.storage.blob;

public enum SharedAccessBlobPermissions
{
  static
  {
    ADD = new SharedAccessBlobPermissions("ADD", 1);
    CREATE = new SharedAccessBlobPermissions("CREATE", 2);
    WRITE = new SharedAccessBlobPermissions("WRITE", 3);
    DELETE = new SharedAccessBlobPermissions("DELETE", 4);
    SharedAccessBlobPermissions localSharedAccessBlobPermissions = new SharedAccessBlobPermissions("LIST", 5);
    LIST = localSharedAccessBlobPermissions;
    $VALUES = new SharedAccessBlobPermissions[] { READ, ADD, CREATE, WRITE, DELETE, localSharedAccessBlobPermissions };
  }
  
  public SharedAccessBlobPermissions() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.SharedAccessBlobPermissions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */