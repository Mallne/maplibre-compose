package org.maplibre.kmp.native.sources

import smjni.jnigen.CalledByNative
import smjni.jnigen.ExposeToNative

@ExposeToNative
public class RasterSource(
    id: String,
    @get:CalledByNative
    public val uri: String? = null,
    @get:CalledByNative
    public val tiles: List<String>? = null,
    @get:CalledByNative
    public val tileSize: Int = 512,
    override val attribution: String = ""
) : Source(id)
