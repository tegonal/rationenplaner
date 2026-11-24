# 8. Cross-cutting Concepts

This chapter describes concepts and principles that apply across multiple components of the Rationenplaner architecture.

* [8.1 Separation of Concerns](#81-separation-of-concerns)
* [8.2 Domain Model and Terminology](#82-domain-model-and-terminology)
* [8.3 Data Management and Persistence](#83-data-management-and-persistence)
    * [Reference Data](#reference-data)
    * [User Data](#user-data)
    * [Import and Export](#import-and-export)
* [8.4 Data and Algorithm Versioning](#84-data-and-algorithm-versioning)
    * [Compatibility and Migration](#compatibility-and-migration)
* [8.5 TypeScript and Kotlin/Wasm Interoperability](#85-typescript-and-kotlinwasm-interoperability)
* [8.6 Validation and Error Handling](#86-validation-and-error-handling)
    * [Input Validation](#input-validation)
    * [Domain Validation](#domain-validation)
    * [Calculation Errors](#calculation-errors)
    * [Error Presentation](#error-presentation)
* [8.7 Privacy and Security](#87-privacy-and-security)
* [8.8 Internationalisation and Localisation](#88-internationalisation-and-localisation)

## 8.1 Separation of Concerns

The application follows a separation-of-concerns principle to keep individual responsibilities independent and
manageable.

The architecture distinguishes between the following conceptual areas:

| Area               | Responsibility                                                                        |
|--------------------|---------------------------------------------------------------------------------------|
| Presentation       | User interface, user interactions and visualisation of results                        |
| Application Logic  | Coordination of application workflows and use cases                                   |
| Domain Logic       | Business rules and domain-specific functionality related to feed formulation          |
| Calculation Engine | Nutritional calculations, optimisation and mathematical algorithms                    |
| Data Management    | Management of feed components, recommendations, pig profiles and other reference data |
| Persistence        | Loading and storing user data                                                         |

The separation of these responsibilities should minimise dependencies between individual areas.

In particular:

- Presentation components must not implement nutritional calculation logic.
- Domain rules must not depend on specific UI components.
- Calculation algorithms must not depend on browser-specific APIs and its execution runtime must be abstracted
- Persistence mechanisms must be accessed through appropriate abstractions.
- Application workflows should coordinate the different responsibilities without duplicating domain logic.

This separation allows individual areas to evolve independently and supports testing and future architectural changes.

## 8.2 Domain Model and Terminology

See [12 Glossary -> Domain Model and Terminology](../12-glossary/glossary.md#121-domain-model-and-terminology)

## 8.3 Data Management and Persistence

Rationenplaner is designed as a client-side application without central data storage.
All user-entered data remains within the user's browser or local environment.
The architecture distinguishes between two categories of data:

### Reference Data

Reference data is provided as part of the application and includes (possibly not exhaustive):

- Feed component definitions.
- Nutritional properties of feed components.
- Pig profiles.
- Feeding recommendations
- Calculation-related reference data.

Reference data is maintained independently of individual user recipes. The architecture should allow reference data to
be maintained in a structured, data-driven format.

Changes to reference data are distributed through application releases and might change a previous evaluation of a
recipe.

### User Data

User data includes information created or modified by the application user, such as:

- Feed recipes.
- Custom feed components.
- Component prices.
- Other application-specific settings and data.

User data is persisted locally using browser storage.

The persistence implementation should be accessed through an abstraction so that application logic does not depend
directly on a specific browser storage technology.

### Import and Export

Users must be able to export and import their application data.

The import/export functionality provides the mechanism for:

- Creating backups.
- Transferring data between devices.
- Restoring previously exported data.

The application does not provide automatic synchronisation between devices or browsers.
Users are responsible for managing their exported data.

## 8.4 Data and Algorithm Versioning

Reference data, nutritional recommendations and calculation algorithms evolve independently.

To make these changes identifiable and manageable, the architecture uses separate version identifiers for different
types of application data and logic.

Independent versioning provides several benefits:

- Changes to nutritional reference data can be distinguished from changes to calculation algorithms.
- The origin of calculation results can be identified more precisely.
- Future compatibility checks and migration mechanisms can be introduced.
- Changes to individual reference data sets do not necessarily require changes to other version identifiers.

Version identifiers should be available wherever necessary to identify the data and algorithms used for calculations.

### Compatibility and Migration

Data migrations are explicitly out of scope for the current version (see
also [3.4 Out of Scope](../03-context-and-scope/context-and-scope.md#34-out-of-scope).

Changes to the data schema may therefore make previously exported user data incompatible with newer application
versions. However, the versioning approach establishes a foundation for introducing compatibility checks and migration
mechanisms in future versions.

## 8.5 TypeScript and Kotlin/Wasm Interoperability

Rationenplaner uses TypeScript for the UI and Kotlin compiled to WebAssembly for computationally intensive
functionality.

The communication between these technologies represents an important architectural boundary.

The `JsAdapter` is responsible for translating between the TypeScript application model and the
interfaces exposed by the Kotlin/Wasm calculation engine.

The following principles apply:

- Communication across the boundary must use explicitly defined interfaces (via dt.mts files).
- Input and output structures must have clearly defined semantics.
- Data conversion must not introduce unintended precision loss.
- Domain concepts should be represented consistently on both sides of the boundary.
- Technical details of WebAssembly execution should be encapsulated.
- Errors occurring during calculation execution must be propagated in a controlled manner.

The TypeScript application should not need to know the internal implementation details of individual calculation
algorithms. Likewise, the Kotlin calculation engine should not depend on React or other presentation-specific
technologies.

## 8.6 Validation and Error Handling

Input validation and error handling are necessary to ensure that the application behaves predictably and that invalid
data does not produce misleading calculation results.

Validation should take place at appropriate architectural boundaries.

### Input Validation

All user-provided data must be validated before being used in domain operations or calculations. This includes data
retrieved from browser storage and imported from files, as both are considered user-modifiable sources and must
therefore be treated as untrusted input.

Examples include:

- Feed component quantities must be valid numerical values.
- Component prices must fulfil the applicable input constraints.
- Nutritional values must use the expected units and representations.
- Required recipe information must be present.
- Imported data must conform to the expected data structure.

### Domain Validation

Domain-specific validation ensures that operations respect the rules of feed formulation.

Examples include:

- Checking nutritional minimum and maximum requirements.
- Identifying incomplete nutritional information.
- Detecting invalid feed compositions.
- Checking whether sufficient information is available for a calculation.

### Calculation Errors

Calculation errors must be handled explicitly, i.e. failures must not silently produce results that could be
interpreted as valid recipe evaluations/optimisation etc.

### Error Presentation

Technical errors should be separated from their presentation to users.
Users should receive understandable messages that explain the problem and, where possible, indicate how it can be
resolved.

## 8.7 Privacy and Security

Rationenplaner follows a privacy-oriented, client-side architecture.

The application does not require user accounts, authentication or a backend service.
See also
[7.4 Data Persistence and Distribution](../07-deployment-view/deployment-view.md#74-data-persistence-and-distribution).

The static application is distributed through HTTPS using GitHub Pages.
The absence of a backend significantly reduces the application's server-side attack surface.

However, it does not eliminate security considerations.
In particular, imported files must be validated before their contents are used by the application.

Browser storage must not be treated as a secure backup mechanism. Users remain responsible for exporting and protecting
their data. The application should also avoid collecting unnecessary information about its users.

## 8.8 Internationalisation and Localisation

The architecture distinguishes between internal domain representations and their presentation to users.

The following principles apply:

- Internal identifiers and technical representations should be in English (see
  also [ADR 001 Language convention](../09-architecture-decisions/ADR-001-language-convention.md).
- User-facing text should be externalised from application logic wherever practical.
- Translations should be managed consistently.
- Units and numerical formatting are in de-CH only, **no internationalisation**
- Domain calculations must remain independent of the selected interface language.

Rationenplaner supports English and German user interfaces. Adding further languages should primarily require extending
the translation
resources rather than modifying domain logic or calculation algorithms.
