# 6. Runtime View

This chapter shows the most important runtime scenarios.

## 6.1 Application Start

```mermaid
sequenceDiagram
	actor User
	participant Browser
	participant SPA
	User ->> Browser: Open application URL
	Browser ->> Browser: Download static files (HTML, JS, Wasm)
	Browser ->> SPA: Start application
	SPA ->> SPA: Load reference data (feed components, pig profiles, recommendations)
	SPA -->> User: Show application
	SPA -) Browser: Load user data
	Browser --) SPA: Recipes, custom feed components (or empty)
	SPA -->> User: Show data
```

## 6.2 Recipe interactions

Following we show the use case of a recipe being evaluated.
This process is triggered when the user changes a recipe (e.g. adds a component, changes an amount etc.).
The flow is the same for several processes involving a recipe or feed components (optimise a recipe, supplementary feed,
search a match for a laboratory analysis result, pig feed label derivation etc.).

```mermaid
sequenceDiagram
	actor User
	participant Presentation
	participant Application
	participant JsAdapter
	participant Domain
	participant Calculation Engine
	User ->> Presentation: Change recipe
	Presentation ->> Application: Input data
	Application -) JsAdapter: evaluate(JsRecipe)
	JsAdapter ->> Domain: evaluate(Recipe)
	Domain ->> Domain: Input validation
	Domain ->> Calculation Engine: Request evaluation
	Calculation Engine -->> Domain: Nutritional values<br/> + deviations from recommendation
	Domain -->> JsAdapter: Evaluation result
	JsAdapter --) Application: Evaluation result
	Application -->> Presentation: Evaluation result
	Presentation -->> User: Show values and<br/> out-of-range results
```

On invalid input or a calculation error, no result is shown. The user sees an explanatory message instead
(see [8.6 Validation and Error Handling](../08-crosscutting-concepts/crosscutting-concepts.md#86-validation-and-error-handling)).
