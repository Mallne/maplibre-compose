package org.maplibre.kmp.native.sources

import smjni.jnigen.CalledByNative
import smjni.jnigen.ExposeToNative

@ExposeToNative
public class GeoJsonSource(
    id: String,
    @get:CalledByNative
    public val json: String? = null,
    override val attribution: String = ""
) : Source(id)
