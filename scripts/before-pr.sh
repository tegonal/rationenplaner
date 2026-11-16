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

if ! [[ -v scriptsDir ]]; then
	scriptsDir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]:-$0}")" >/dev/null && pwd 2>/dev/null)"
	readonly scriptsDir
fi
source "$scriptsDir/dirs.source.sh"
sourceOnce "$scriptsDir/cleanup-on-push-to-main.sh"
sourceOnce "$scriptsDir/run-shellcheck.sh"

function beforePr() {
	# using && because this function might be used on the left side of an ||
	customRunShellcheck &&
		cleanupOnPushToMain
}

${__SOURCED__:+return}
beforePr "$@"
