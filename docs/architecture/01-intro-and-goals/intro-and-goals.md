# 1. Introduction and Goals

## 1.1 Requirements Overview

Rationenplaner is a web application designed to support farmers in formulating and optimising feed rations for pigs.

The application helps farmers combine different feed ingredients into nutritionally balanced recipes and calculate
supplementary feed requirements. Its primary purpose is to simplify the process of feed formulation and support
decisions regarding the nutritional composition of pig feed.

The application is provided as a static website and can be accessed through a web browser without requiring a local
installation.

The main requirements and capabilities are:

- **Feed recipe formulation:** Enable farmers to put together recipes for pig feed using available feed ingredients.
- **Nutritional optimisation:** Support the optimisation of feed recipes to achieve appropriate nutritional values.
- **Supplementary feed calculation:** Calculate the required amount of supplementary feed based on the feed recipe.
- **Accessibility:** Provide a web-based application that can be accessed without installation.

The application is intended to make feed formulation more accessible and efficient, enabling farmers to make better use
of their own farm-produced feed materials, as well as available side-streams and by-products. It supports them in
combining locally available feed ingredients into nutritionally suitable pig feed rations, helping them make better use
of existing resources, reduce food waste and promote a more sustainable use of materials available on their farms.

## 1.2 Quality Goals

The following quality goals are derived from the application's purpose and distribution model. They represent the
architectural qualities that should guide implementation and further development.

| Priority | Quality Goal                | Motivation                                                                                                                                                                                                                                     |
|----------|-----------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1        | Usability                   | Farmers should be able to formulate and optimise feed recipes efficiently without requiring extensive technical knowledge (of Excel).                                                                                                          |
| 2        | Correctness                 | Nutritional calculations and supplementary feed calculations must produce reliable and consistent results, as they directly influence feed formulation decisions.                                                                              |
| 3        | Accessibility / Portability | The application should be easy to access through a web browser without requiring installation or complex setup procedures.                                                                                                                     |
| 4        | Maintainability             | The software should remain understandable and straightforward to extend, fix and improve as requirements evolve.                                                                                                                               |
| 5        | Openness and Transparency   | Unlike many existing commercial feed formulation solutions, the application should be freely accessible and open source. Users should be able to use, inspect and adapt the software without being restricted by proprietary licensing models. |

These quality goals establish the primary criteria for evaluating architectural decisions and implementation trade-offs.

## 1.3 Stakeholders

The stakeholders are divided into two groups to distinguish between those directly involved in or affected by the
initial version and those who are relevant as well but rather for further development.

### Version 1 – Initial Release

| Stakeholder                                        | Expectations and Interests                                                                                                                                                                                                                                                                                                                                     |
|----------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Farmers                                            | Want to formulate nutritionally balanced pig feed recipes, optimise ingredient combinations and calculate supplementary feed requirements.                                                                                                                                                                                                                     |
| FiBL                                               | Responsible for the project and interested in providing a useful, maintainable and accessible application.                                                                                                                                                                                                                                                     |
| Peter Stoll (Original Developer of the Excel Tool) | Developed an extended version of Agroscope's original Excel-based feed calculation tool + an optimisation and a pig feed analyser, which serve as the foundation for this project. Contributed these Excels to the project and is an important source of domain knowledge regarding feed formulation, calculation logic and the underlying nutritional models. |
| Software developers and contributors               | Need a comprehensible codebase, clear requirements and a maintainable architecture to implement improvements and fix defects.                                                                                                                                                                                                                                  |
| Project maintainers                                | Need to ensure the application's continued functionality, correctness and evolution.                                                                                                                                                                                                                                                                           |

### Further development - Subject to Funding / Potential Scope

| Stakeholder                                                                                                  | Expectations and Interests                                                                                                                                                                                                                                                                                                                                                     |
|--------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Agricultural advisors / Nutrition experts                                                                    | Need a practical tool to support feed formulation and nutritional assessment.                                                                                                                                                                                                                                                                                                  |
| Agroscope                                                                                                    | Provides an Excel-based tool [1](#ref-1) for calculating pig feed rations. Is a potential source of updated feed material data (e.g. new versions of feed databases) and revised feed recommendations. The application should be able to benefit from these updates to ensure that its calculations and recommendations remain consistent with current agricultural knowledge. |
| Agricultural Schools                                                                                         | Interested in using the application for educational purposes, particularly to teach feed formulation and nutritional principles.                                                                                                                                                                                                                                               |
| BFH-HAFL (Bern University of Applied Sciences, School of Agricultural, Forest and Food Sciences, Zollikofen) | Interested in applying the tool in agricultural education, research and practical applications.                                                                                                                                                                                                                                                                                |
| ETH Zürich                                                                                                   | Interested in scientific aspects of animal nutrition, feed formulation and potential research applications.                                                                                                                                                                                                                                                                    |

These stakeholders may introduce additional requirements concerning scientific validation, educational usability, and
extensibility. Their involvement and specific requirements will need to be clarified as the project moves towards
a second version.

<a id="ref-1">[1]</a> <https://www.agroscope.admin.ch/dam/de/sd-web/cAnZ5piyPu2h/rationen-schweine-berechnen.xls>
