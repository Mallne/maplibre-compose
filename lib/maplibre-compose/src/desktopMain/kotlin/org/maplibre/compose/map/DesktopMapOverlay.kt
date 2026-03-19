package org.maplibre.compose.map

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties

@Composable
internal actual fun MaplibreMapOverlay(
    modifier: Modifier,
    content: @Composable () -> Unit,
    overlayContent: @Composable () -> Unit
) {
    Box(modifier = modifier) {
        content()
        Popup(
            properties = PopupProperties(
                focusable = false,
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Box(modifier = modifier) {
                overlayContent()
            }
        }
    }
}
