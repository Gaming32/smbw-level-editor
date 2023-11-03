package io.github.gaming32.smbwle.byml.node;

public abstract sealed class BymlCollection extends BymlNode permits BymlArray, BymlHash {
    public abstract int size();
}
