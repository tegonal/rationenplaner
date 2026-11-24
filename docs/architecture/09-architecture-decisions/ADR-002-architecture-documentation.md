# ADR-002: Architecture Documentation

- **Status:** Accepted
- **Date:** 2026-11-23
- **Decision:** Use the arc42 template to document the software architecture, mainly because it is the style the team is
  already used to.

**Table of Contents**

- [Decision](#decision)
- [Context](#context)
- [Decision Drivers](#decision-drivers)
- [Considered Options](#considered-options)
	- [Option 1: arc42](#option-1-arc42)
	- [Option 2: C4 Model Only](#option-2-c4-model-only)
	- [Option 3: Ad-hoc Wiki or Markdown Pages](#option-3-ad-hoc-wiki-or-markdown-pages)
- [Consequences](#consequences)
- [Guidelines](#guidelines)
- [References](#references)

## Decision

We will use **arc42 as the standard structure for the architecture documentation**.

This includes, but is not limited to:

- The overall architecture documentation of the system.
- Building block, runtime, and deployment views.
- Quality goals, constraints, risks, and technical debt.
- Cross-cutting concepts.
- References to Architecture Decision Records (ADRs), which remain separate documents.

arc42 is a template, not a process. Sections that are not relevant may be kept short or omitted, and arc42 may be
combined with other notations, such as C4 diagrams or PlantUML, where they add value.

## Context

The project requires a consistent and maintainable way to document its architecture. As the project is open source and
may attract new contributors, the documentation needs a predictable structure that makes it easy to find and add
information.

The team has already worked with arc42 in current and previous projects and is familiar with its chapters and
conventions.

The following options were considered:

1. **arc42:** Use the arc42 template for the architecture documentation.
2. **C4 model only:** Document the architecture using the C4 model diagrams exclusively.
3. **Ad-hoc wiki or Markdown pages:** Document the architecture in freely structured pages.

## Decision Drivers

The decision is based on the following considerations:

- **Familiarity:** The team is used to arc42. This is the main driver for this decision.
- **Consistency:** A fixed structure makes documents easier to read, review, and compare.
- **Completeness:** A predefined structure helps to avoid forgetting relevant topics.
- **Low onboarding effort:** New contributors can quickly find where information is located and where to add it.
- **Flexibility:** The approach should not impose a heavy process and should work with other tools and notations.
- **Maintainability:** The documentation should remain easy to maintain over the long term.
- **Ecosystem compatibility:** The format should work well with Markdown, version control, and common diagramming tools.

## Considered Options

### Option 1: arc42

Use the arc42 template as the structure for the architecture documentation.

**Advantages:**

- The team is already familiar with the template, so there is no learning curve.
- Provides a clear, fixed chapter structure that acts as a checklist.
- Widely known and well documented, which helps external contributors.
- Flexible: sections can be kept short or omitted, and other notations can be embedded.
- Works well with plain Markdown or AsciiDoc in version control.

**Disadvantages:**

- The template can tempt authors to fill sections without adding real value => we will only fill in the sections we 
  think provide value, for completeness we add all sections but mention that certain are empty on purpose
- Provides structure but no guidance on diagram notation.

### Option 2: C4 Model Only

Document the architecture using only the C4 model (context, container, component, and code diagrams).

**Advantages:**

- Provides a clear and simple approach to architecture diagrams.
- Easy to understand for technical and non-technical audiences.

**Disadvantages:**

- Offers no structure for textual topics such as quality goals, constraints, risks, or cross-cutting concepts.
- Not the style the team is used to.
- Needs to be complemented by another approach for non-diagram content.

### Option 3: Ad-hoc Wiki or Markdown Pages

Document the architecture in freely structured wiki or Markdown pages.

**Advantages:**

- Maximum flexibility and no upfront structure.
- No template to learn.

**Disadvantages:**

- Leads to inconsistent documentation and gaps.
- Makes it harder to find information.
- Increases the effort for new contributors to understand where to document what.
- Not the style the team is used to.

## Consequences

### Positive

- Fast start and low training effort, as the team already knows arc42.
- A predictable structure for readers and new team members.
- The chapter structure helps to cover all relevant architectural topics.
- Consistency with the approach used in previous projects.

### Negative

- Sections may be filled out for the sake of completeness rather than value. We must keep the documentation lean.
- Contributors who do not know arc42 need to familiarise themselves with the template.

### Neutral

- Other documentation styles are not ruled out for specific purposes, for example C4 diagrams within the building block
  view.
- ADRs remain separate documents and are referenced from the arc42 documentation.
- This decision will be revisited if the team or the context changes significantly.

## Guidelines

The following guidelines apply to new contributions and ongoing development:

1. The architecture documentation follows the arc42 chapter structure.
2. Only document what is relevant. Keep sections short, and omit those without value.
3. Use C4 diagrams or Mermaid within arc42 chapters where they improve understanding.
4. Record significant architectural decisions as ADRs and reference them from the arc42 documentation.
5. Keep the documentation in version control, next to the code.
6. Write the documentation in line with the language convention defined in ADR-001.

## References

- [arc42 Template](https://arc42.org/)
- [ADR-001: Language Convention for the Codebase](./ADR-001-language-convention.md)
