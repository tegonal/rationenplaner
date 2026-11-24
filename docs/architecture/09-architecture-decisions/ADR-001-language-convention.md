# ADR-001: Language Convention for the Codebase

- **Status:** Accepted
- **Date:** 2026-11-23
- **Decision:** British English for code and technical documentation; German permitted business and
  organisational communication (including requirements and UX flows)

**Table of Contents**

- [Decision](#decision)
- [Context](#context)
- [Decision Drivers](#decision-drivers)
- [Considered Options](#considered-options)
    - [Option 1: German Only](#option-1-german-only)
    - [Option 2: English for Technical Aspects, German for the Domain](#option-2-english-for-technical-aspects-german-for-the-domain)
    - [Option 3: English Only](#option-3-english-only)
- [Consequences](#consequences)
- [Guidelines](#guidelines)
- [References](#references)

## Decision

We will use **British English as the standard language for the codebase and all technical documentation**.

This includes, but is not limited to:

- Source code and identifiers (variables, functions, classes, interfaces, etc.).
- Code comments and inline documentation.
- Technical documentation.
- Architecture Decision Records (ADRs).
- Database table and column names.
- API specifications and technical interfaces.
- Tests and test descriptions.
- Commit messages and pull request descriptions.

**German may be used for project-related business and organisational communication**, as German is currently the
project's working language.

This includes, but is not limited to:

- **Business Decision Records (BDRs)** documenting business-related decisions, such as strategic direction and feature
  prioritisation.
- Requirements.
- UX flows and other artefacts used for communication.
- Project management artefacts, such as issues and task descriptions.
- Meeting notes.

The distinction is based on the type of content: technical and architectural documentation is written in English, while
business and organisational communication (including artefacts such as UX flows) may be written in German.

## Context

The project is an open-source web application developed in Switzerland. The business domain is currently predominantly
German-speaking, and the initial target audience consists mainly of German-speaking users.

However, the project aims to become accessible to all linguistic regions of Switzerland in the future, particularly
French- and Italian-speaking users. As an open-source project, we also want to encourage contributions from developers
regardless of their native language or geographical location.

We therefore need to establish a consistent language convention for the codebase and project documentation.

## Decision Drivers

The decision is based on the following considerations:

- **Consistency:** A consistent language convention makes the codebase easier to understand and maintain.
- **Inclusivity:** Make the project accessible to contributors with different language backgrounds.
- **Internationalisation:** Support the project's ambition to reach all linguistic regions of Switzerland.
- **Maintainability:** Code should remain understandable and maintainable over the long term.
- **Ecosystem compatibility:** The language should align with established conventions in software development,
  frameworks, libraries, and development tools.
- **Domain accuracy:** Domain-specific concepts should be represented clearly without losing their original meaning
  through translation.
- **Open-source community:** The language convention should minimise barriers to external contributions.

## Considered Options

### Option 1: German Only

Use German consistently throughout the codebase and project documentation.

**Advantages:**

- Domain-specific terminology can be used in its original form.
- German-speaking domain experts may find the code easier to understand.
- No translation of German business terminology is required.

**Disadvantages:**

- Creates a language barrier for French- and Italian-speaking contributors.
- Makes the project less accessible to international developers.
- Deviates from common conventions in software development.
- May limit the project's reach and potential contributor base.

### Option 2: English for Technical Aspects, German for the Domain

Use English for technical infrastructure and concepts, but German for domain-specific code and terminology.

**Advantages:**

- Preserves original domain terminology.
- Allows developers to express domain concepts in their native language.
- Follows common English-language conventions for technical infrastructure.
- Reduces the need to translate domain-specific terminology.

**Disadvantages:**

- Creates a mixed-language codebase.
- Can lead to inconsistent naming and documentation.
- Makes domain-related code harder to understand for international contributors.
- Requires clear rules to distinguish technical and domain-specific terminology.

### Option 3: English Only

Use English consistently throughout the codebase and technical documentation.

**Advantages:**

- Provides a common language for developers regardless of their native language.
- Makes the project more accessible to international contributors.
- Follows common conventions in software development.
- Aligns with the language used by most programming languages, frameworks, and libraries.
- Avoids mixing languages within the codebase.
- Makes it easier to share and reuse code and documentation.

**Disadvantages:**

- German business terminology must be translated into English.
- Some domain-specific terms may not have exact English equivalents.
- German-speaking developers may initially find English domain terminology less intuitive.
- A shared glossary may be necessary to ensure consistent terminology => We will translate the glossary

## Consequences

### Positive

- The codebase and technical documentation follow a consistent language convention.
- International developers can more easily understand and contribute to the project (contributions are not restricted to
  German-speaking developers)
- Technical concepts align with established software development terminology.
- The language convention supports future internationalisation.
- Business decisions and organisational communication can continue to use the team's current working language.

### Negative

- Developers must express domain concepts in English when writing code.
- Translating domain-specific terminology requires care to preserve its original meaning.
- German-language BDRs and project-management artefacts may create a language barrier for contributors who do not speak
  German.
- The project intentionally uses different languages for technical documentation and some business or organisational
  communication.

### Neutral

- The initial user interface may remain German.
- French and Italian translations of user-facing content are independent of the programming language.
- A shared glossary may be needed to document domain-specific terminology and its English equivalents.

## Guidelines

The following guidelines apply to new contributions and ongoing development:

1. All written code must use English.
2. Technical documentation, including Architecture Decision Records (ADRs), must be written in English.
3. Use established English terminology from the relevant technical ecosystem.
4. Maintain a shared glossary for domain-specific terms in English and German.
5. Business Decision Records (BDRs), meeting notes, and project-management artefacts may be written in German.
6. User-facing text must be externalised and prepared for localisation (i18n).
7. User-facing translations must be maintained independently of the source code language.

## References

None
