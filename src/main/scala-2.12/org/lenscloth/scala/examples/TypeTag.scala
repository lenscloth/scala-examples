package org.lenscloth.scala.examples

import scala.reflect.runtime.universe._

object TypeTagExample {

  trait Person[T]

  trait Bad
  trait Good

  def remeberMe[T: TypeTag](p: Person[T]): String = {
    if (typeOf[T] =:= typeOf[Bad]) {
      "You are bad person"
    } else if (typeOf[T] =:= typeOf[Good]) {
      "You are good person"
    } else
      "We don't know you"
  }

  def main(args: Array[String]): Unit = {
    println(remeberMe(new Person[Bad]{}))
    println(remeberMe(new Person[Good]{}))
  }

}
