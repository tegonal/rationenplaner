#!/usr/bin/env bash
#
#  This script is provided to you by https://github.com/fibl/rationenplaner
#  Copyright 2026 Forschungsinstitut für biologischen Landbau (FiBL) <info@fibl.org>
#  It is licensed under European Union Public Licence v. 1.2
#  Please report bugs and contribute back your improvements
#
#                                         Version: v0.1.0-SNAPSHOT
###################################
set -euo pipefail
shopt -s inherit_errexit
unset CDPATH
RATIONENPLANER_LATEST_VERSION="main"

if ! [[ -v scriptsDir ]]; then
	scriptsDir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]:-$0}")" >/dev/null && pwd 2>/dev/null)/../../../scripts"
	readonly scriptsDir
fi
source "$scriptsDir/dirs.source.sh"
sourceOnce "$dir_of_github_commons/gt/pull-hook-functions.sh"
sourceOnce "$dir_of_tegonal_scripts/utility/parse-fn-args.sh"

function pull_hook_before() {
	local _currentTag _tag source _target
	# shellcheck disable=SC2034   # is passed to parseFnArgs by name
	local -ra params=(_currentTag _tag source _target)
	parseFnArgs params "$@"

	replaceTegonalGhCommonsPlaceholders "$source" "Rationenplaner" "$RATIONENPLANER_LATEST_VERSION" \
		"Forschungsinstitut für biologischen Landbau (FiBL)" "info@fibl.org" "fibl" "rationenplaner"
}
pull_hook_before "$@"
