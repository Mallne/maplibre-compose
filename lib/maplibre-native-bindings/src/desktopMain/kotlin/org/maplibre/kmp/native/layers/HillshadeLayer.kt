package org.maplibre.kmp.native.layers

import smjni.jnigen.CalledByNative
import smjni.jnigen.ExposeToNative

@ExposeToNative
public class HillshadeLayer(
    id: String,
    @get:CalledByNative
    public val sourceId: String
) : Layer(id)
