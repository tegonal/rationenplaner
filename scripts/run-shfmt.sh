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
shopt -s inherit_errexit || { echo >&2 "please update to bash 5, see errors above" && exit 1; }
unset CDPATH

if ! [[ -v scriptsDir ]]; then
	scriptsDir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]:-$0}")" >/dev/null && pwd 2>/dev/null)"
	readonly scriptsDir
fi
source "$scriptsDir/dirs.source.sh"
sourceOnce "$dir_of_tegonal_scripts/qa/run-shfmt.sh"

function customRunShfmt() {
	# shellcheck disable=SC2034   # is passed by name to runShfmt
	local -ra dirs=("$scriptsDir")
	runShfmt dirs || return $?

	runShfmtPullHooks "$scriptsDir/../.gt"
}

${__SOURCED__:+return}
customRunShfmt "$@"
