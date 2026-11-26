package org.fibl.rationenplaner.adapter

import org.fibl.rationenplaner.domain.*
import org.fibl.rationenplaner.domain.NutritionalParameterId.*

private fun g(make: (GramPerKg) -> NutritionalParameter): (Double) -> NutritionalParameter =
	{ make(GramPerKg(it)) }

private fun mg(make: (MilligramPerKg) -> NutritionalParameter): (Double) -> NutritionalParameter =
	{ make(MilligramPerKg(it)) }

private fun mj(make: (MegaJoulePerKg) -> NutritionalParameter): (Double) -> NutritionalParameter =
	{ make(MegaJoulePerKg(it)) }

private fun iu(make: (IuPerKg) -> NutritionalParameter): (Double) -> NutritionalParameter = { make(IuPerKg(it)) }

val parameterFactories: Map<NutritionalParameterId, (Double) -> NutritionalParameter> = mapOf(
	TS to g(::DryMatter), RA to g(::CrudeAsh), RP to g(::CrudeProtein),
	RL to g(::CrudeFat), RF to g(::CrudeFibre),
	VES to mj(::DigestibleEnergy), VPS to g(::DigestibleProtein),

	LYS to g(::Lysine), MET to g(::Methionine), CYS to g(::Cysteine), THR to g(::Threonine),
	TRP to g(::Tryptophan), ILE to g(::Isoleucine), LEU to g(::Leucine), PHE to g(::Phenylalanine),
	TYR to g(::Tyrosine), VAL to g(::Valine), ARG to g(::Arginine), HIS to g(::Histidine),

	V_LYS to g(::DigestibleLysine), V_MET to g(::DigestibleMethionine), V_CYS to g(::DigestibleCysteine),
	V_THR to g(::DigestibleThreonine), V_TRP to g(::DigestibleTryptophan), V_ILE to g(::DigestibleIsoleucine),
	V_LEU to g(::DigestibleLeucine), V_PHE to g(::DigestiblePhenylalanine), V_TYR to g(::DigestibleTyrosine),
	V_VAL to g(::DigestibleValine), V_ARG to g(::DigestibleArginine), V_HIS to g(::DigestibleHistidine),

	SAT to g(::SaturatedFattyAcids), MUFA to g(::MonounsaturatedFattyAcids), PUFA to g(::PolyunsaturatedFattyAcids),
	PMI to g(::Pmi), PUI to g(::Pui), JZI to g(::Jzi),
	CA to g(::Calcium), P to g(::Phosphorus), NA to g(::Sodium), VDP to g(::DigestiblePhosphorus),

	FE_NAT to mg(::IronNatural), FE_ADDED to mg(::IronAdded),
	CU_NAT to mg(::CopperNatural), CU_ADDED to mg(::CopperAdded),
	ZN_NAT to mg(::ZincNatural), ZN_ADDED to mg(::ZincAdded),
	MN_NAT to mg(::ManganeseNatural), MN_ADDED to mg(::ManganeseAdded),
	SE_NAT to mg(::SeleniumNatural), SE_ADDED to mg(::SeleniumAdded),

	VIT_A_ADDED to iu(::VitaminAAdded), VIT_D3_ADDED to iu(::VitaminD3Added), VIT_E_ADDED to iu(::VitaminEAdded),
)

class RawParameter(val id: String, val unit: String)

class ParseResult(val parameters: List<NutritionalParameter>, val errors: List<String>)
//
//fun parseParameters(raw: List<RawParameter>): ParseResult {
//	val parameters = mutableListOf<NutritionalParameter>()
//	val errors = mutableListOf<String>()
//	for (parameter in raw) {
//		val id = NutritionalParameterId.fromCode(parameter.id)
//		val factory = id?.let(parameterFactories::get)
//		when {
//			id == null || factory == null -> errors += "Unknown or read-only parameter '${parameter.id}'"
//			parameter.unit != id.unit -> errors += "'${parameter.id}' expects '${id.unit}', got '${parameter.unit}'"
//			else -> parameters += factory(parameter.amount)
//		}
//	}
//	return ParseResult(parameters, errors)
//}
