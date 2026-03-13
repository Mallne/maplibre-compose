package org.maplibre.kmp.native.layers

import smjni.jnigen.CalledByNative
import smjni.jnigen.ExposeToNative

@ExposeToNative
public abstract class Layer(
    @get:CalledByNative
    public val id: String
)
