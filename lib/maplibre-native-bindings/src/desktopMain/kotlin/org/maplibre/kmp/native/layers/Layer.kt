package org.maplibre.kmp.native.layers

import smjni.jnigen.CalledByNative
import smjni.jnigen.ExposeToNative

@ExposeToNative
public abstract class Layer(
    @get:CalledByNative
    public val id: String
) {
    public external fun setProperty(name: String, jsonValue: String?)
    public external fun setFilter(jsonValue: String?)
}
