package io.github.gaming32.smbwle.byml.node;

public abstract sealed class BymlNumber extends BymlNode permits BymlDouble, BymlFloat, BymlInt, BymlInt64, BymlUInt, BymlUInt64 {
    public abstract Number toNumber();

    public abstract int intValue();

    public abstract long longValue();

    public abstract float floatValue();

    public abstract double doubleValue();
}
