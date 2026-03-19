package org.maplibre.compose.layers

import org.maplibre.compose.expressions.ast.CompiledExpression
import org.maplibre.compose.expressions.value.*
import org.maplibre.compose.sources.Source

internal actual class SymbolLayer actual constructor(id: String, source: Source) :
  FeatureLayer(source) {
  override val impl = org.maplibre.kmp.native.layers.SymbolLayer(id, source.id)

  actual override var sourceLayer: String = ""
    set(value) {
      field = value
      setProperty("source-layer", org.maplibre.compose.expressions.ast.StringLiteral.of(value))
    }

  actual override fun setFilter(filter: CompiledExpression<BooleanValue>) {
    setFilterInternal(filter)
  }

  actual fun setSymbolPlacement(placement: CompiledExpression<SymbolPlacement>) {
    setProperty("symbol-placement", placement)
  }

  actual fun setSymbolSpacing(spacing: CompiledExpression<DpValue>) {
    setProperty("symbol-spacing", spacing)
  }

  actual fun setSymbolAvoidEdges(avoidEdges: CompiledExpression<BooleanValue>) {
    setProperty("symbol-avoid-edges", avoidEdges)
  }

  actual fun setSymbolSortKey(sortKey: CompiledExpression<FloatValue>) {
    setProperty("symbol-sort-key", sortKey)
  }

  actual fun setSymbolZOrder(zOrder: CompiledExpression<SymbolZOrder>) {
    setProperty("symbol-z-order", zOrder)
  }

  actual fun setIconAllowOverlap(allowOverlap: CompiledExpression<BooleanValue>) {
    setProperty("icon-allow-overlap", allowOverlap)
  }

  actual fun setIconOverlap(overlap: CompiledExpression<StringValue>) {
    setProperty("icon-overlap", overlap)
  }

  actual fun setIconIgnorePlacement(ignorePlacement: CompiledExpression<BooleanValue>) {
    setProperty("icon-ignore-placement", ignorePlacement)
  }

  actual fun setIconOptional(optional: CompiledExpression<BooleanValue>) {
    setProperty("icon-optional", optional)
  }

  actual fun setIconRotationAlignment(
    rotationAlignment: CompiledExpression<IconRotationAlignment>
  ) {
    setProperty("icon-rotation-alignment", rotationAlignment)
  }

  actual fun setIconSize(size: CompiledExpression<FloatValue>) {
    setProperty("icon-size", size)
  }

  actual fun setIconTextFit(textFit: CompiledExpression<IconTextFit>) {
    setProperty("icon-text-fit", textFit)
  }

  actual fun setIconTextFitPadding(textFitPadding: CompiledExpression<DpPaddingValue>) {
    setProperty("icon-text-fit-padding", textFitPadding)
  }

  actual fun setIconImage(image: CompiledExpression<ImageValue>) {
    setProperty("icon-image", image)
  }

  actual fun setIconRotate(rotate: CompiledExpression<FloatValue>) {
    setProperty("icon-rotate", rotate)
  }

  actual fun setIconPadding(padding: CompiledExpression<DpPaddingValue>) {
    setProperty("icon-padding", padding)
  }

  actual fun setIconKeepUpright(keepUpright: CompiledExpression<BooleanValue>) {
    setProperty("icon-keep-upright", keepUpright)
  }

  actual fun setIconOffset(offset: CompiledExpression<DpOffsetValue>) {
    setProperty("icon-offset", offset)
  }

  actual fun setIconAnchor(anchor: CompiledExpression<SymbolAnchor>) {
    setProperty("icon-anchor", anchor)
  }

  actual fun setIconPitchAlignment(pitchAlignment: CompiledExpression<IconPitchAlignment>) {
    setProperty("icon-pitch-alignment", pitchAlignment)
  }

  actual fun setIconOpacity(opacity: CompiledExpression<FloatValue>) {
    setProperty("icon-opacity", opacity)
  }

  actual fun setIconColor(color: CompiledExpression<ColorValue>) {
    setProperty("icon-color", color)
  }

  actual fun setIconHaloColor(haloColor: CompiledExpression<ColorValue>) {
    setProperty("icon-halo-color", haloColor)
  }

  actual fun setIconHaloWidth(haloWidth: CompiledExpression<DpValue>) {
    setProperty("icon-halo-width", haloWidth)
  }

  actual fun setIconHaloBlur(haloBlur: CompiledExpression<DpValue>) {
    setProperty("icon-halo-blur", haloBlur)
  }

  actual fun setIconTranslate(translate: CompiledExpression<DpOffsetValue>) {
    setProperty("icon-translate", translate)
  }

  actual fun setIconTranslateAnchor(translateAnchor: CompiledExpression<TranslateAnchor>) {
    setProperty("icon-translate-anchor", translateAnchor)
  }

  actual fun setTextPitchAlignment(pitchAlignment: CompiledExpression<TextPitchAlignment>) {
    setProperty("text-pitch-alignment", pitchAlignment)
  }

  actual fun setTextRotationAlignment(
    rotationAlignment: CompiledExpression<TextRotationAlignment>
  ) {
    setProperty("text-rotation-alignment", rotationAlignment)
  }

  actual fun setTextField(field: CompiledExpression<FormattedValue>) {
    setProperty("text-field", field)
  }

  actual fun setTextFont(font: CompiledExpression<ListValue<StringValue>>) {
    setProperty("text-font", font)
  }

  actual fun setTextSize(size: CompiledExpression<DpValue>) {
    setProperty("text-size", size)
  }

  actual fun setTextMaxWidth(maxWidth: CompiledExpression<FloatValue>) {
    setProperty("text-max-width", maxWidth)
  }

  actual fun setTextLineHeight(lineHeight: CompiledExpression<FloatValue>) {
    setProperty("text-line-height", lineHeight)
  }

  actual fun setTextLetterSpacing(letterSpacing: CompiledExpression<FloatValue>) {
    setProperty("text-letter-spacing", letterSpacing)
  }

  actual fun setTextJustify(justify: CompiledExpression<TextJustify>) {
    setProperty("text-justify", justify)
  }

  actual fun setTextRadialOffset(radialOffset: CompiledExpression<FloatValue>) {
    setProperty("text-radial-offset", radialOffset)
  }

  actual fun setTextVariableAnchor(variableAnchor: CompiledExpression<ListValue<SymbolAnchor>>) {
    setProperty("text-variable-anchor", variableAnchor)
  }

  actual fun setTextVariableAnchorOffset(
    variableAnchorOffset: CompiledExpression<TextVariableAnchorOffsetValue>
  ) {
    setProperty("text-variable-anchor-offset", variableAnchorOffset)
  }

  actual fun setTextAnchor(anchor: CompiledExpression<SymbolAnchor>) {
    setProperty("text-anchor", anchor)
  }

  actual fun setTextMaxAngle(maxAngle: CompiledExpression<FloatValue>) {
    setProperty("text-max-angle", maxAngle)
  }

  actual fun setTextWritingMode(writingMode: CompiledExpression<ListValue<TextWritingMode>>) {
    setProperty("text-writing-mode", writingMode)
  }

  actual fun setTextRotate(rotate: CompiledExpression<FloatValue>) {
    setProperty("text-rotate", rotate)
  }

  actual fun setTextPadding(padding: CompiledExpression<DpValue>) {
    setProperty("text-padding", padding)
  }

  actual fun setTextKeepUpright(keepUpright: CompiledExpression<BooleanValue>) {
    setProperty("text-keep-upright", keepUpright)
  }

  actual fun setTextTransform(transform: CompiledExpression<TextTransform>) {
    setProperty("text-transform", transform)
  }

  actual fun setTextOffset(offset: CompiledExpression<FloatOffsetValue>) {
    setProperty("text-offset", offset)
  }

  actual fun setTextAllowOverlap(allowOverlap: CompiledExpression<BooleanValue>) {
    setProperty("text-allow-overlap", allowOverlap)
  }

  actual fun setTextOverlap(overlap: CompiledExpression<SymbolOverlap>) {
    setProperty("text-overlap", overlap)
  }

  actual fun setTextIgnorePlacement(ignorePlacement: CompiledExpression<BooleanValue>) {
    setProperty("text-ignore-placement", ignorePlacement)
  }

  actual fun setTextOptional(optional: CompiledExpression<BooleanValue>) {
    setProperty("text-optional", optional)
  }

  actual fun setTextOpacity(opacity: CompiledExpression<FloatValue>) {
    setProperty("text-opacity", opacity)
  }

  actual fun setTextColor(color: CompiledExpression<ColorValue>) {
    setProperty("text-color", color)
  }

  actual fun setTextHaloColor(haloColor: CompiledExpression<ColorValue>) {
    setProperty("text-halo-color", haloColor)
  }

  actual fun setTextHaloWidth(haloWidth: CompiledExpression<DpValue>) {
    setProperty("text-halo-width", haloWidth)
  }

  actual fun setTextHaloBlur(haloBlur: CompiledExpression<DpValue>) {
    setProperty("text-halo-blur", haloBlur)
  }

  actual fun setTextTranslate(translate: CompiledExpression<DpOffsetValue>) {
    setProperty("text-translate", translate)
  }

  actual fun setTextTranslateAnchor(translateAnchor: CompiledExpression<TranslateAnchor>) {
    setProperty("text-translate-anchor", translateAnchor)
  }
}
