package io.github.gaming32.smbwle.util;

import it.unimi.dsi.fastutil.Hash;

public enum IdentityStrategy implements Hash.Strategy<Object> {
    INSTANCE;

    @Override
    public int hashCode(Object o) {
        return System.identityHashCode(o);
    }

    @Override
    public boolean equals(Object a, Object b) {
        return a == b;
    }
}
