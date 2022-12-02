# Dev Log

## General Notes

- On macOS, remember to update Xcode when you update your OS. I had version `14.0` but `coursier` (and other things) needed at least `14.1`. This was due to the macOS Ventura upgrade.

## Scala

- `sbt new scala/scala3.g8` will create a new scala template project and ask for the project name, which will become the folder name in your current path in which the scala project will be initialized.
