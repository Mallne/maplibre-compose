package org.maplibre.compose.map

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal actual fun MaplibreMapOverlay(
    modifier: Modifier,
    content: @Composable () -> Unit,
    overlayContent: @Composable () -> Unit
) {
    Box(modifier = modifier) {
        content()
        overlayContent()
    }
}
