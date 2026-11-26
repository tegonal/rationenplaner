@file:OptIn(ExperimentalWasmJsInterop::class, ExperimentalJsExport::class)

package org.fibl.rationenplaner.adapter

import org.fibl.rationenplaner.domain.*

// ───────────── JS-side shapes (input) ─────────────
external interface JsParameter : JsAny {
	val id: String
	val value: Double
	val unit: String
}

external interface JsRecipeComponent : JsAny {
	val componentId: String
	val percentage: Double
}

external interface JsFeedRecipe : JsAny {
	val pigProfile: String
	val weight: Double
	val components: JsArray<JsRecipeComponent>
}


// ───────────── JS-side shapes (output) ─────────────
external interface JsEvaluatedParameter : JsAny {
	val id: String
	val value: Double
	val unit: String
	val validityMin: JsNumber?
	val validityMax: JsNumber?
}

external interface JsEvaluationResult : JsAny {
	val parameters: JsArray<JsEvaluatedParameter>
}

external interface JsValidationResult : JsAny {
	val isValid: Boolean
	val issues: JsArray<JsString>
}

// Object-literal factories (js() must be the sole body expression)
private fun jsParameter(id: String, value: Double, unit: String): JsParameter =
	js("({ id, value, unit })")

private fun jsRecipeComponent(id: String, percentage: Double): JsRecipeComponent =
	js("({ id, percentage })")

private fun jsFeedRecipe(pigProfile: String, weight: Double, components: JsArray<JsRecipeComponent>): JsFeedRecipe =
	js("({ pigProfile, weight, components })")

private fun jsEvaluatedParameter(
	id: String, value: Double, unit: String, validityMin: JsNumber?, validityMax: JsNumber?,
): JsEvaluatedParameter =
	js("({ id, value, unit, validityMax })")

private fun jsEvaluationResult(parameters: JsArray<JsEvaluatedParameter>): JsEvaluationResult =
	js("({ parameters: parameters })")

private fun jsValidationResult(isValid: Boolean, issues: JsArray<JsString>): JsValidationResult =
	js("({ isValid: isValid, issues: issues })")

// ───────────── Facade ─────────────
// Composition root: build RecipeEvaluator, RecipeOptimizer, RecipeValidator and DomainFacade here.
private val domain: DomainFacade by lazy {
	TODO("wire RecipeEvaluator, RecipeOptimizer, RecipeValidator")
}


@JsExport
fun evaluateRecipe(recipe: JsFeedRecipe): JsEvaluationResult =
	domain.evaluateRecipe(recipe.toDomain()).toJs()

@JsExport
fun optimizeRecipe(recipe: JsFeedRecipe): JsFeedRecipe =
	domain.optimizeRecipe(recipe.toDomain()).toJs()

@JsExport
fun validateRecipe(recipe: JsFeedRecipe): JsValidationResult =
	domain.validateRecipe(recipe.toDomain()).toJs()


/// ───────────── JS -> domain ─────────────

private fun JsFeedRecipe.toDomain(): FeedRecipe {
	val errors = mutableListOf<String>()

	val components = components.toList().map { c ->
		RecipePosition(
			component = ComponentId(c.componentId),
			percentage = c.percentage
		)
	}

	require(errors.isEmpty()) {
		errors.joinToString("; ")
	}

	return FeedRecipe(
		pigProfile = PigProfile.valueOf(pigProfile),
		weight = weight,
		components = components
	)
}


// ───────────── domain -> JS ─────────────

private fun NutritionalParameter.toRaw() =
	RawParameter(id.code, id.unit)

private fun FeedRecipe.toJs(): JsFeedRecipe =
	jsFeedRecipe(
		pigProfile = pigProfile.name,
		weight = weight,
		components = components.map { position ->
			jsRecipeComponent(
				id = position.component.value,
				percentage = position.percentage,
			)
		}.toJsArray()
	)

private fun EvaluationResult.toJs(): JsEvaluationResult =
	jsEvaluationResult(
		parameters.map { evaluatedParameter ->
			val raw = evaluatedParameter.parameter.toRaw()
			jsEvaluatedParameter(
				raw.id, evaluatedParameter.amount, raw.unit,
				evaluatedParameter.validityRange.start.toJsNumber(),
				evaluatedParameter.validityRange.endInclusive.toJsNumber(),
			)
		}.toJsArray()
	)

private fun ValidationResult.toJs(): JsValidationResult =
	jsValidationResult(isValid, issues.map { it.toJsString() }.toJsArray())
