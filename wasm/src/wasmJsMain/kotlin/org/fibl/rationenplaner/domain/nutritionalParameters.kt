package org.fibl.rationenplaner.domain

private typealias Id = NutritionalParameterId

private const val G = "g/kg"
private const val MG = "mg/kg"
private const val MJ = "MJ/kg"
private const val IU = "IU/kg"

/** [code] is the identifier JavaScript sends, [unit] the unit it must be sent in. */
enum class NutritionalParameterId(val code: String, val unit: String) {
	// Proximate constituents
	TS("TS", G), RA("RA", G), RP("RP", G), RL("RL", G), RF("RF", G), NFE("NfE", G),

	// Energy / digestible nutrients
	VES("VES", MJ), VPS("VPS", G),

	// Amino acids
	LYS("Lys", G), MET("Met", G), CYS("Cys", G), THR("Thr", G), TRP("Trp", G), ILE("Ile", G),
	LEU("Leu", G), PHE("Phe", G), TYR("Tyr", G), VAL("Val", G), ARG("Arg", G), HIS("His", G),
	MET_CYS("Met+Cys", G), PHE_TYR("Phe+Tyr", G),

	// Digestible amino acids
	V_LYS("vLys", G), V_MET("vMet", G), V_CYS("vCys", G), V_THR("vThr", G), V_TRP("vTrp", G),
	V_ILE("vIle", G), V_LEU("vLeu", G), V_PHE("vPhe", G), V_TYR("vTyr", G), V_VAL("vVal", G),
	V_ARG("vArg", G), V_HIS("vHis", G), V_MET_CYS("vMet+Cys", G), V_PHE_TYR("vPhe+Tyr", G),

	// Fatty acids / fat quality
	SAT("SAT", G), MUFA("MUFA", G), PUFA("PUFA", G), PMI("PMI", G), PUI("PUI", G), JZI("JZI", G),

	// Minerals
	CA("Ca", G), P("P", G), NA("Na", G), VDP("VDP", G),

	// Trace elements
	FE_NAT("Fe nat", MG), FE_ADDED("Fe zuges", MG), FE_TOTAL("Fe total", MG),
	CU_NAT("Cu nat", MG), CU_ADDED("Cu zuges", MG), CU_TOTAL("Cu total", MG),
	ZN_NAT("Zn nat", MG), ZN_ADDED("Zn zuges", MG), ZN_TOTAL("Zn total", MG),
	MN_NAT("Mn nat", MG), MN_ADDED("Mn zuges", MG), MN_TOTAL("Mn total", MG),
	SE_NAT("Se nat", MG), SE_ADDED("Se zuges", MG), SE_TOTAL("Se total", MG),

	// Vitamins
	VIT_A_ADDED("Vit. A zuges", IU), VIT_D3_ADDED("Vit. D3 zuges", IU), VIT_E_ADDED("Vit. E zuges", IU);

	companion object {
		private val byCode = entries.associateBy { it.code }
		fun fromCode(code: String): NutritionalParameterId? = byCode[code]
	}
}

sealed interface NutritionalParameter {
	val id: Id
}

// ───────────── Proximate constituents ─────────────
sealed interface ProximateConstituent : NutritionalParameter

value class DryMatter(val value: GramPerKg) : ProximateConstituent {
	override val id get() = Id.TS
}

value class CrudeAsh(val value: GramPerKg) : ProximateConstituent {
	override val id get() = Id.RA
}

value class CrudeProtein(val value: GramPerKg) : ProximateConstituent {
	override val id get() = Id.RP
}

value class CrudeFat(val value: GramPerKg) : ProximateConstituent {
	override val id get() = Id.RL
}

value class CrudeFibre(val value: GramPerKg) : ProximateConstituent {
	override val id get() = Id.RF
}

value class NitrogenFreeExtract(val value: GramPerKg) : ProximateConstituent {
	override val id get() = Id.NFE

	companion object {
		fun of(
			dryMatter: DryMatter,
			crudeAsh: CrudeAsh,
			crudeProtein: CrudeProtein,
			crudeFat: CrudeFat,
			crudeFibre: CrudeFibre,
		) = NitrogenFreeExtract(
			dryMatter.value - crudeAsh.value - crudeProtein.value - crudeFat.value - crudeFibre.value
		)
	}
}

// ───────────── Energy ─────────────
sealed interface EnergyParameter : NutritionalParameter

value class DigestibleEnergy(val value: MegaJoulePerKg) : EnergyParameter {
	override val id get() = Id.VES
}

// ───────────── Digestible nutrients ─────────────
sealed interface DigestibleNutrient : NutritionalParameter

value class DigestibleProtein(val value: GramPerKg) : DigestibleNutrient {
	override val id get() = Id.VPS
}

// ───────────── Amino acids ─────────────
sealed interface AminoAcid : NutritionalParameter

value class Lysine(val value: GramPerKg) : AminoAcid {
	override val id get() = Id.LYS
}

value class Methionine(val value: GramPerKg) : AminoAcid {
	override val id get() = Id.MET
}

value class Cysteine(val value: GramPerKg) : AminoAcid {
	override val id get() = Id.CYS
}

value class Threonine(val value: GramPerKg) : AminoAcid {
	override val id get() = Id.THR
}

value class Tryptophan(val value: GramPerKg) : AminoAcid {
	override val id get() = Id.TRP
}

value class Isoleucine(val value: GramPerKg) : AminoAcid {
	override val id get() = Id.ILE
}

value class Leucine(val value: GramPerKg) : AminoAcid {
	override val id get() = Id.LEU
}

value class Phenylalanine(val value: GramPerKg) : AminoAcid {
	override val id get() = Id.PHE
}

value class Tyrosine(val value: GramPerKg) : AminoAcid {
	override val id get() = Id.TYR
}

value class Valine(val value: GramPerKg) : AminoAcid {
	override val id get() = Id.VAL
}

value class Arginine(val value: GramPerKg) : AminoAcid {
	override val id get() = Id.ARG
}

value class Histidine(val value: GramPerKg) : AminoAcid {
	override val id get() = Id.HIS
}

value class MethionineCysteine(val value: GramPerKg) : AminoAcid {
	override val id get() = Id.MET_CYS

	companion object {
		fun of(methionine: Methionine, cysteine: Cysteine) =
			MethionineCysteine(methionine.value + cysteine.value)
	}
}

value class PhenylalanineTyrosine(val value: GramPerKg) : AminoAcid {
	override val id get() = Id.PHE_TYR

	companion object {
		fun of(phenylalanine: Phenylalanine, tyrosine: Tyrosine) =
			PhenylalanineTyrosine(phenylalanine.value + tyrosine.value)
	}
}

// ───────────── Digestible amino acids ─────────────
sealed interface DigestibleAminoAcid : NutritionalParameter

value class DigestibleLysine(val value: GramPerKg) : DigestibleAminoAcid {
	override val id get() = Id.V_LYS
}

value class DigestibleMethionine(val value: GramPerKg) : DigestibleAminoAcid {
	override val id get() = Id.V_MET
}

value class DigestibleCysteine(val value: GramPerKg) : DigestibleAminoAcid {
	override val id get() = Id.V_CYS
}

value class DigestibleThreonine(val value: GramPerKg) : DigestibleAminoAcid {
	override val id get() = Id.V_THR
}

value class DigestibleTryptophan(val value: GramPerKg) : DigestibleAminoAcid {
	override val id get() = Id.V_TRP
}

value class DigestibleIsoleucine(val value: GramPerKg) : DigestibleAminoAcid {
	override val id get() = Id.V_ILE
}

value class DigestibleLeucine(val value: GramPerKg) : DigestibleAminoAcid {
	override val id get() = Id.V_LEU
}

value class DigestiblePhenylalanine(val value: GramPerKg) : DigestibleAminoAcid {
	override val id get() = Id.V_PHE
}

value class DigestibleTyrosine(val value: GramPerKg) : DigestibleAminoAcid {
	override val id get() = Id.V_TYR
}

value class DigestibleValine(val value: GramPerKg) : DigestibleAminoAcid {
	override val id get() = Id.V_VAL
}

value class DigestibleArginine(val value: GramPerKg) : DigestibleAminoAcid {
	override val id get() = Id.V_ARG
}

value class DigestibleHistidine(val value: GramPerKg) : DigestibleAminoAcid {
	override val id get() = Id.V_HIS
}

value class DigestibleMethionineCysteine(val value: GramPerKg) : DigestibleAminoAcid {
	override val id get() = Id.V_MET_CYS

	companion object {
		fun of(methionine: DigestibleMethionine, cysteine: DigestibleCysteine) =
			DigestibleMethionineCysteine(methionine.value + cysteine.value)
	}
}

value class DigestiblePhenylalanineTyrosine(val value: GramPerKg) : DigestibleAminoAcid {
	override val id get() = Id.V_PHE_TYR

	companion object {
		fun of(phenylalanine: DigestiblePhenylalanine, tyrosine: DigestibleTyrosine) =
			DigestiblePhenylalanineTyrosine(phenylalanine.value + tyrosine.value)
	}
}

// ───────────── Fatty acids ─────────────
sealed interface FattyAcid : NutritionalParameter

value class SaturatedFattyAcids(val value: GramPerKg) : FattyAcid {
	override val id get() = Id.SAT
}

value class MonounsaturatedFattyAcids(val value: GramPerKg) : FattyAcid {
	override val id get() = Id.MUFA
}

value class PolyunsaturatedFattyAcids(val value: GramPerKg) : FattyAcid {
	override val id get() = Id.PUFA
}

// ───────────── Fat quality ─────────────
sealed interface FatQualityIndex : NutritionalParameter

value class Pmi(val value: GramPerKg) : FatQualityIndex {
	override val id get() = Id.PMI
}

value class Pui(val value: GramPerKg) : FatQualityIndex {
	override val id get() = Id.PUI
}

value class Jzi(val value: GramPerKg) : FatQualityIndex {
	override val id get() = Id.JZI
}

// ───────────── Minerals ─────────────
sealed interface Mineral : NutritionalParameter

value class Calcium(val value: GramPerKg) : Mineral {
	override val id get() = Id.CA
}

value class Phosphorus(val value: GramPerKg) : Mineral {
	override val id get() = Id.P
}

value class Sodium(val value: GramPerKg) : Mineral {
	override val id get() = Id.NA
}

// ───────────── Digestible minerals ─────────────
sealed interface DigestibleMineral : NutritionalParameter

value class DigestiblePhosphorus(val value: GramPerKg) : DigestibleMineral {
	override val id get() = Id.VDP
}

// ───────────── Trace elements ─────────────
sealed interface TraceElement : NutritionalParameter

value class IronNatural(val value: MilligramPerKg) : TraceElement {
	override val id get() = Id.FE_NAT
}

value class IronAdded(val value: MilligramPerKg) : TraceElement {
	override val id get() = Id.FE_ADDED
}

value class IronTotal(val value: MilligramPerKg) : TraceElement {
	override val id get() = Id.FE_TOTAL

	companion object {
		fun of(natural: IronNatural, added: IronAdded) = IronTotal(natural.value + added.value)
	}
}

value class CopperNatural(val value: MilligramPerKg) : TraceElement {
	override val id get() = Id.CU_NAT
}

value class CopperAdded(val value: MilligramPerKg) : TraceElement {
	override val id get() = Id.CU_ADDED
}

value class CopperTotal(val value: MilligramPerKg) : TraceElement {
	override val id get() = Id.CU_TOTAL

	companion object {
		fun of(natural: CopperNatural, added: CopperAdded) = CopperTotal(natural.value + added.value)
	}
}

value class ZincNatural(val value: MilligramPerKg) : TraceElement {
	override val id get() = Id.ZN_NAT
}

value class ZincAdded(val value: MilligramPerKg) : TraceElement {
	override val id get() = Id.ZN_ADDED
}

value class ZincTotal(val value: MilligramPerKg) : TraceElement {
	override val id get() = Id.ZN_TOTAL

	companion object {
		fun of(natural: ZincNatural, added: ZincAdded) = ZincTotal(natural.value + added.value)
	}
}

value class ManganeseNatural(val value: MilligramPerKg) : TraceElement {
	override val id get() = Id.MN_NAT
}

value class ManganeseAdded(val value: MilligramPerKg) : TraceElement {
	override val id get() = Id.MN_ADDED
}

value class ManganeseTotal(val value: MilligramPerKg) : TraceElement {
	override val id get() = Id.MN_TOTAL

	companion object {
		fun of(natural: ManganeseNatural, added: ManganeseAdded) = ManganeseTotal(natural.value + added.value)
	}
}

value class SeleniumNatural(val value: MilligramPerKg) : TraceElement {
	override val id get() = Id.SE_NAT
}

value class SeleniumAdded(val value: MilligramPerKg) : TraceElement {
	override val id get() = Id.SE_ADDED
}

value class SeleniumTotal(val value: MilligramPerKg) : TraceElement {
	override val id get() = Id.SE_TOTAL

	companion object {
		fun of(natural: SeleniumNatural, added: SeleniumAdded) = SeleniumTotal(natural.value + added.value)
	}
}

// ───────────── Vitamins ─────────────
sealed interface Vitamin : NutritionalParameter

value class VitaminAAdded(val value: IuPerKg) : Vitamin {
	override val id get() = Id.VIT_A_ADDED
}

value class VitaminD3Added(val value: IuPerKg) : Vitamin {
	override val id get() = Id.VIT_D3_ADDED
}

value class VitaminEAdded(val value: IuPerKg) : Vitamin {
	override val id get() = Id.VIT_E_ADDED
}
