package com.microsoft.azure.storage.core;

public enum EncryptionAlgorithm
{
  static
  {
    EncryptionAlgorithm localEncryptionAlgorithm = new EncryptionAlgorithm("AES_CBC_256", 0);
    AES_CBC_256 = localEncryptionAlgorithm;
    $VALUES = new EncryptionAlgorithm[] { localEncryptionAlgorithm };
  }
  
  public EncryptionAlgorithm() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.EncryptionAlgorithm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */