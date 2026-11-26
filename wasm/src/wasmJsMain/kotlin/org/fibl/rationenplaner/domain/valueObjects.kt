package org.fibl.rationenplaner.domain

value class ComponentId(val value: String) {
	init {
		requireIsNotBlank(value, "id")
	}
}

private fun requireIsNotBlank(value: String, name: String) {
	require(value.isNotBlank()) { "$name must not be blank" }
}
