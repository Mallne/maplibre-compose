package org.maplibre.kmp.native.sources

import smjni.jnigen.CalledByNative
import smjni.jnigen.ExposeToNative

@ExposeToNative
public abstract class Source(
    @get:CalledByNative
    public val id: String
) {
    @get:CalledByNative
    public abstract val attribution: String
}
