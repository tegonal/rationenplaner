package org.fibl.rationenplaner.domain

interface RecipeEvaluator {
	fun evaluate(recipe: FeedRecipe): EvaluationResult
}

interface RecipeOptimizer {
	fun optimise(feedRecipe: FeedRecipe): FeedRecipe = feedRecipe
}

interface RecipeValidator {
	fun validate(feedRecipe: FeedRecipe): ValidationResult
}

class DomainFacade(
	private val recipeEvaluator: RecipeEvaluator,
	private val recipeOptimizer: RecipeOptimizer,
	private val recipeValidator: RecipeValidator,
) {

	fun evaluateRecipe(recipe: FeedRecipe): EvaluationResult {
		return recipeEvaluator.evaluate(recipe)
	}

	fun optimizeRecipe(recipe: FeedRecipe): FeedRecipe {
		return recipeOptimizer.optimise(recipe)
	}

	fun validateRecipe(recipe: FeedRecipe): ValidationResult {
		return recipeValidator.validate(recipe)
	}
}


//data class FeedComponent(
//	val name: String,
//	val dryMatter: GramPerKg,
//	val crudeAsh: GramPerKg,
//	val crudeProtein: GramPerKg,
//	val crudeFat: GramPerKg,
//	val crudeFibre: GramPerKg,
//	val nitrogenFreeExtract: GramPerKg,
//	val digestibleEnergy: MegaJoulePerKg,
//	val vitaminD3Added: IuPerKg,
//)

data class FeedRecipe(
	val pigProfile: PigProfile,
	val weight: Double,
	val components: List<RecipePosition>
)

class RecipePosition(
	val component: ComponentId,
	val percentage: Double
)

enum class PigProfile {
	Piglet,
	FatteningPig,
	GestatingSow,
	LactatingSow
}
//
//data class EvaluationResult(
//	val proximate: ProximateConstituents,
//	val energy: Energy,
//	val digestibleNutrients: DigestibleNutrients,
//	val aminoAcids: AminoAcids,
//	val digestibleAminoAcids: DigestibleAminoAcids,
//	val fattyAcids: FattyAcids,
//	val fatQuality: FatQuality,
//	val minerals: Minerals,
//	val digestibleMinerals: DigestibleMinerals,
//	val traceElements: TraceElements,
//	val vitamins: Vitamins,
//)

sealed interface FeedComponent

data class SingleComponent(val id: ComponentId, val parameters: List<NutritionalParameter>) : FeedComponent

data class EvaluatedParameter(
	val parameter: NutritionalParameter,
	val amount: Double,
	val validityRange: ClosedFloatingPointRange<Double>
)

data class EvaluationResult(val parameters: List<EvaluatedParameter>)

data class ValidationResult(val isValid: Boolean, val issues: List<String>)
