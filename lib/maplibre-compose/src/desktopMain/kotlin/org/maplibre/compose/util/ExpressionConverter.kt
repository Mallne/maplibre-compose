package org.maplibre.compose.util

import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.LayoutDirection
import kotlinx.serialization.json.*
import org.maplibre.compose.expressions.ast.*

internal fun CompiledExpression<*>.toJson(): String? {
  if (this == NullLiteral) return null
  return normalizeJsonLike(false).toString()
}

private fun buildLiteralArray(inLiteral: Boolean, block: JsonArrayBuilder.() -> Unit): JsonElement {
  val array = buildJsonArray(block)
  return if (inLiteral) {
    array
  } else {
    buildJsonArray {
      add("literal")
      add(array)
    }
  }
}

private fun buildLiteralObject(inLiteral: Boolean, block: JsonObjectBuilder.() -> Unit): JsonElement {
  val obj = buildJsonObject(block)
  return if (inLiteral) {
    obj
  } else {
    buildJsonObject {
      put("literal", obj)
    }
  }
}

private fun CompiledExpression<*>.normalizeJsonLike(inLiteral: Boolean): JsonElement =
  when (this) {
    NullLiteral -> JsonNull
    is BooleanLiteral -> JsonPrimitive(value)
    is FloatLiteral -> JsonPrimitive(value)
    is StringLiteral -> JsonPrimitive(value)
    is OffsetLiteral ->
      buildLiteralArray(inLiteral) {
        add(value.x)
        add(value.y)
      }

    is ColorLiteral ->
      JsonPrimitive(
        value.toArgb().let {
          "rgba(${(it shr 16) and 0xFF}, ${(it shr 8) and 0xFF}, ${it and 0xFF}, ${value.alpha})"
        }
      )

    is DpPaddingLiteral ->
      buildLiteralArray(inLiteral) {
        add(value.calculateTopPadding().value)
        add(value.calculateRightPadding(LayoutDirection.Ltr).value)
        add(value.calculateBottomPadding().value)
        add(value.calculateLeftPadding(LayoutDirection.Ltr).value)
      }

    is CompiledFunctionCall ->
      buildJsonArray {
        add(name)
        args.forEachIndexed { i, v -> add(v.normalizeJsonLike(inLiteral || isLiteralArg(i))) }
      }

    is CompiledListLiteral<*> ->
      buildLiteralArray(inLiteral) { value.forEach { add(it.normalizeJsonLike(true)) } }

    is CompiledMapLiteral<*> ->
      buildLiteralObject(inLiteral) {
        value.forEach { (k, v) -> put(k, v.normalizeJsonLike(true)) }
      }

    is CompiledOptions<*> ->
      buildJsonObject { value.forEach { (k, v) -> put(k, v.normalizeJsonLike(inLiteral)) } }
  }
