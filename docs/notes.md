# Dev Log

## General Notes

- On macOS, remember to update Xcode when you update your OS. I had version `14.0` but `coursier` (and other things) needed at least `14.1`. This was due to the macOS Ventura upgrade.

- I'm starting to enjoy `match/case` quite a bit. Wanna try more of it in Python's 3.10+ own version soon.

## Scala 🪜

- `sbt new scala/scala3.g8` will create a new scala template project and ask for the project name, which will become the folder name in your current path in which the scala project will be initialized.

- Looping through an `Iterator` works only the first time. You need to re-instantiate the `Iterator` to loop through it again. It's kinda like Python's generators with `yield`. Of course you could use something like `Array` instead and then it's no problem.


## Coming from Python 🐍

- It wasn't so straightforward to append elements to a list, albeit easy to figure out. You import `ListBuffer` from `import scala.collection.mutable.ListBuffer` and they actually have quite a lot more functionality e.g. count, distinct etc. [Read more.](https://docs.scala-lang.org/overviews/collections-2.13/concrete-mutable-collection-classes.html#list-buffers)

- Nice to see familiar string formatting with `f` strings almost being identical between the two languages. [Read more](https://docs.scala-lang.org/overviews/core/string-interpolation.html#the-f-interpolator)

- Quite strange to not have to specify `return`, just type the thing you wanna return in the last line in a function.
