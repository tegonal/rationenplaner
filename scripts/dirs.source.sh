#!/usr/bin/env bash
# shellcheck disable=SC2034,SC2168,SC2154
#
#  This script is provided to you by https://github.com/fibl/rationenplaner
#  Copyright 2026 Forschungsinstitut für biologischen Landbau (FiBL) <info@fibl.org>
#  It is licensed under European Union Public Licence v. 1.2
#  Please report bugs and contribute back your improvements
#
#                                         Version: v0.1.0-SNAPSHOT
#
#  defines constants pointing to source root directories intended to be sourced in sh files
#
###################################

if ! [[ -v projectDir ]]; then
	projectDir="$(realpath "$scriptsDir/../")"
	readonly projectDir
fi

if ! [[ -v dir_of_tegonal_scripts ]]; then
	dir_of_tegonal_scripts="$scriptsDir/../lib/tegonal-scripts/src"
	source "$dir_of_tegonal_scripts/setup_tegonal_scripts.sh" "$dir_of_tegonal_scripts"
fi

if ! [[ -v dir_of_github_commons ]]; then
	dir_of_github_commons="$scriptsDir/../lib/tegonal-gh-commons/src"
	readonly dir_of_github_commons
fi
