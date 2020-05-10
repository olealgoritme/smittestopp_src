package com.microsoft.identity.common.internal.authorities;

public enum Environment
{
  static
  {
    Environment localEnvironment = new Environment("Production", 1);
    Production = localEnvironment;
    $VALUES = new Environment[] { PreProduction, localEnvironment };
  }
  
  public Environment() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.authorities.Environment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */