# 10. Quality Requirements

* [Q-01 Calculation Architecture and Numerical Accuracy](#q-01-calculation-architecture-and-numerical-accuracy)
* [Q-02: Feed component extensibility](#q-02-feed-component-extensibility)
* [Q-03: Pig profile extensibility](#q-03-pig-profile-extensibility)

## Q-01 Calculation Architecture and Numerical Accuracy

Nutritional calculations are a core functionality of the application. Their numerical correctness is therefore a
fundamental quality requirement.

- Calculations must provide sufficient numerical precision for the intended agricultural and nutritional use cases.
- Polynomial regression calculations must support polynomial degrees up to and including degree six.
- The numerical implementation must avoid unacceptable precision loss, rounding errors and numerical instability.
- The selected numerical representation and algorithms must be validated against reference calculations and
  representative test cases.

The Excel was using double precision (64 bit) which showed to be sufficient in practice which means we don't need
arbitrary precision arithmetic.

## Q-02: Feed component extensibility

The application initially provides approximately 300 feed materials.

- The feed material catalogue must be extensible without requiring programming knowledge.
- Feed material definitions should be maintained in a data-driven format.
- The architecture must support future extensions of the feed material catalogue.

## Q-03: Pig profile extensibility

The application initially supports four pig profiles:

- Piglet (Ferkel)
- Fattening (Mast)
- Gestating (Trächtig)
- Lactating (Laktierend)

Same quality requirements apply as for [Q-02](#q-02-feed-component-extensibility)
