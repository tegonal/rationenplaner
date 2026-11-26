package org.fibl.rationenplaner.domain

value class GramPerKg(val value: Double) : Comparable<GramPerKg> {
	override operator fun compareTo(other: GramPerKg): Int = value.compareTo(other.value)
	operator fun plus(other: GramPerKg) = GramPerKg(value + other.value)
	operator fun minus(other: GramPerKg) = GramPerKg(value - other.value)
	fun toMilligramPerKg() = MilligramPerKg(value * 1000)

	init {
		requireNonNegativeAndNotInfinity(value, "g/kg")
	}
}


value class MilligramPerKg(val value: Double) : Comparable<MilligramPerKg> {
	override operator fun compareTo(other: MilligramPerKg): Int = value.compareTo(other.value)
	operator fun plus(other: MilligramPerKg) = MilligramPerKg(value + other.value)
	operator fun minus(other: MilligramPerKg) = MilligramPerKg(value - other.value)
	fun toGramPerKg() = GramPerKg(value / 1000)

	init {
		requireNonNegativeAndNotInfinity(value, "mg/kg")
	}
}


private fun requireNonNegativeAndNotInfinity(value: Double, unit: String) {
	require(value.isFinite()) { "$unit/kg must be finite, got $value" }
	require(value >= 0.0) { "$unit/kg must not be negative, got $value" }
}

value class MegaJoulePerKg(val value: Double) {
	operator fun plus(o: MegaJoulePerKg) = MegaJoulePerKg(value + o.value)

	init {
		requireNonNegativeAndNotInfinity(value, "MJ/kg")
	}
}

/**
 * International Unit / kg = IU/kg (IE/kg in German)
 */
value class IuPerKg(val value: Double) : Comparable<IuPerKg> {
	override operator fun compareTo(other: IuPerKg): Int = value.compareTo(other.value)
	operator fun plus(other: IuPerKg) = IuPerKg(value + other.value)

	init {
		require(value.isFinite() && value >= 0.0) { "Iu/kg must be finite and >= 0, got $value" }
	}
}
