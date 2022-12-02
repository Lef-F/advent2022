setup-mac:
	brew install coursier/formulas/coursier && cs setup
	sbt compile
