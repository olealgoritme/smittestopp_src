package h.c;

public enum d$b
{
  static
  {
    PPC = new b("PPC", 2);
    PPC64 = new b("PPC64", 3);
    PPC64LE = new b("PPC64LE", 4);
    SPARC = new b("SPARC", 5);
    SPARCV9 = new b("SPARCV9", 6);
    S390X = new b("S390X", 7);
    MIPS32 = new b("MIPS32", 8);
    ARM = new b("ARM", 9);
    AARCH64 = new b("AARCH64", 10);
    b localb = new b("UNKNOWN", 11);
    UNKNOWN = localb;
    $VALUES = new b[] { I386, X86_64, PPC, PPC64, PPC64LE, SPARC, SPARCV9, S390X, MIPS32, ARM, AARCH64, localb };
  }
  
  public d$b() {}
  
  public String toString()
  {
    return name().toLowerCase(d.d);
  }
}

/* Location:
 * Qualified Name:     h.c.d.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */