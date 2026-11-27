# 2. Constraints

This chapter describes the technical, organisational and operational constraints that influence the architecture and
implementation of the Rationenplaner.

* [2.1 Technical Constraints](#21-technical-constraints)
    * [TC-01: Browser-based application](#tc-01-browser-based-application)
    * [TC-02: Browser compatibility](#tc-02-browser-compatibility)
    * [TC-03: Local data storage and privacy](#tc-03-local-data-storage-and-privacy)
* [2.2 Organisational Constraints](#22-organisational-constraints)
    * [OC-01: Limited project budget](#oc-01-limited-project-budget)
    * [OC-02: Minimal operational costs](#oc-02-minimal-operational-costs)
    * [OC-03: Open-source licensing](#oc-03-open-source-licensing)
    * [OC-04: Project language](#oc-04-project-language)
* [2.3 Development Conventions](#23-development-conventions)
    * [DC-01: Language conventions](#dc-01-language-conventions)

## 2.1 Technical Constraints

### TC-01: Browser-based application

The application must run entirely in a web browser.

- No installation of software on the user's machine must be required.
- The application must be platform-independent, supporting common desktop operating systems.
- No browser extensions or additional runtime environments may be required.
- Users must be able to access the application through a regular web browser.

### TC-02: Browser compatibility

The application must support the latest stable versions of the following browsers:

- Mozilla Firefox
- Google Chrome
- Apple Safari

Compatibility with older browser versions, alternative browsers or browser versions outside the supported range is not
guaranteed (requires at least WasmGC). Mobile and Tablet are out of scope
(see [3.4 Out of Scope](../03-context-and-scope/context-and-scope.md#34-out-of-scope).)

### TC-03: Local data storage and privacy

The application must not collect, transmit or centrally store user-entered data.

- User-entered data must remain within the user's browser or local environment.
- No backend or central database for user data is provided.
- Users must be able to export and import their data.
- Data synchronisation between different devices or browsers is the responsibility of the user, using the export/import
  functionality.
- The application must not transmit user data to third-party services.

## 2.2 Organisational Constraints

### OC-01: Limited project budget

The project is developed under restricted financial resources.

- The implementation must follow an MVP-oriented approach.
- Development effort must focus on essential functionality.
- Unnecessary architectural complexity and infrastructure must be avoided.
- External dependencies and services should be minimised where practical.

### OC-02: Minimal operational costs

The application must be designed to minimise recurring operational and maintenance costs.

- Hosting costs must be kept to a minimum.
- Dependencies on paid third-party services must be avoided where practical.
- Operational complexity and maintenance effort must be minimised.
- The solution must not require expensive or specialised infrastructure.

### OC-03: Open-source licensing

The project must be released as open-source software under the European Union Public Licence (EUPL), version 1.2.

- Project code and associated source artefacts must comply with the selected licence.
- Third-party dependencies must have licences compatible with the project's licensing obligations.
- The licence must be clearly documented and distributed with the project.

### OC-04: Project language

German is the primary language of the project from a domain and project-management perspective.

This does not impose restrictions on the technical architecture or implementation technologies.

## 2.3 Development Conventions

### DC-01: Language conventions

English is the required language for software development artefacts and technical documentation, see
[ADR-001](../09-architecture-decisions/ADR-001-language-convention.md) for detailed information.
