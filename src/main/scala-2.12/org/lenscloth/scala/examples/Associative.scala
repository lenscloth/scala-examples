package org.lenscloth.scala.examples

object Associative {
  // Left Associative
  // caller method argument
  case class NumberLeft(x: Int) {
    def /(that: NumberLeft) = NumberLeft(x / that.x)
    override def toString = x.toString
  }

  // Right Associative
  // argument method caller
  case class NumberRight(x: Int) {
    def /:(that: NumberRight) = NumberRight(that.x / x)
    override def toString = x.toString
  }

  def main(args: Array[String]) = {
    println(s"50 / (25 / 5) == ${NumberRight(50) /: NumberRight(25) /: NumberRight(5)}")
    println(s"(50 / 25) / 5 == ${NumberLeft(50) / NumberLeft(25) / NumberLeft(5)}")
  }
}