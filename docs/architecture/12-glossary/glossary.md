# 12. Glossary

## 12.1 Domain Model and Terminology

Rationenplaner implements a domain-specific model for formulating and evaluating pig feed recipes.
The domain model provides a common understanding of the central concepts used throughout the application.

The most important domain concepts are:

| Concept                    | German                          | Description                                                                                                                                                                                                                                                                            |
|----------------------------|---------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Feed Component             | Futterkomponente                | An individual ingredient that can be used in a feed recipe. It contains nutritional properties (e.g crude protein/kg, MJ VES/kg etc.) and potentially additional information such as price.                                                                                            |
| (Feed) Recipe              | (Futter-)Rezept                 | A composition of multiple feed components, including their respective quantities.                                                                                                                                                                                                      |
| Nutritional Parameter      | Nährwertparameter               | A measurable or calculated property describing the nutritional composition or quality of a feed component or feed recipe. See [12.2 Nutritional Parameters](#122-nutritional-parameters) for more details.                                                                             |
| Feeding Recommendation     | Fütterungsempfehlung            | Defines recommended feeding parameters per profile. See [12.3 Feeding Recommendations](#123-feeding-recommendations) for more information.                                                                                                                                             |
| Pig Profile                | Schweineprofil                  | A profile describing a type of pig, including recommended amino acid levels and weight range.                                                                                                                                                                                          |
| Recipe Evaluation          | Rezeptbewertung                 | The process of evaluating a feed recipe against recommendations.                                                                                                                                                                                                                       |
| Supplementary Feed         | Ergänzungsfutter                | A calculated feed composition intended to complement an existing feed recipe.                                                                                                                                                                                                          |
| Recipe Optimisation        | Rezeptoptimierung               | The process of finding a suitable combination of available feed components that fulfils defined nutritional requirements.                                                                                                                                                              |
| (Pig) Feed Label           | (Schweine-)Futtermitteletikette | A label describing the nutritional composition and other relevant properties of a commercially available pig feed. It typically contains nutritional parameters such as dry matter, crude protein, crude fibre, crude fat, crude ash and vitamins.                                     |
| Feed Label Derivation      | Futtermittel-Nährwertableitung  | The process of deriving (nearly) all nutritional parameters from a pig feed label, enabling the feed to be registered as an independent feed component.                                                                                                                                |
| Laboratory Analysis Result | Laboranalyseergebnis            | A set of laboratory-measured nutritional parameters describing the composition of a feed sample. It contains measured values (e.g. crude protein, crude fibre, crude fat, minerals and amino acids), potentially including measurement units, analysis methods and sample information. |
| Feed Component Matching    | Futterkomponentenabgleich       | The process of identifying existing feed components that best match a laboratory analysis result. It compares the measured nutritional parameters with the nutritional properties of available feed components and identifies potential matches.                                       |
| Feed Component Search      | Futterkomponentensuche          | The process of finding feed components based on component names.                                                                                                                                                                                                                       |                                                                                                                                                                                                                                                         |
| Dry Matter                 | Trockensubstanz (TS)            | The portion of feed remaining after removing all moisture.                                                                                                                                                                                                                             |
| Fresh Matter               | Frischsubstanz (FS)             | The feed in its natural state, including its moisture content.                                                                                                                                                                                                                         |

## 12.2 Nutritional Parameters

See [nutritional-parameters.csv](./nutritional-parameters.csv).

This glossary defines the feed and nutritional parameters used in the data model, with English and German terminology.

- **Parameter** is the identifier/abbreviation used in interfaces.
    - The prefix **v** means *verdaulich* / *digestible*.
    - The suffix **nat** means **native**
    - The suffix **zuges** means *zugesetzt*/*added*
    - **native** means naturally present in the feed material; **added** means supplied through the premix.

## 12.3 Feeding Recommendations

Defines recommended feeding parameters for a particular pig profile. They include:

- Nutritional concentration requirements (e.g. MJ VES/kg or g crude protein/kg)
- Daily nutritional requirements (e.g. MJ VES/day)
- Recommended feed intake and boundaries (e.g. kg/day).

Recommendations may depend on factors such as the animal's body weight or the dry matter content of the feed. Therefore,
a recommendation is generally expressed as a formula that allows a range to be calculated based on the relevant
parameters, rather than as a fixed range.
