package org.lenscloth.scala.examples

/**
  * Created by wppark on 2017. 1. 19..
  */
object PrefixOperator {
  case class Number(x: Int) {
    // Infix operator
    def +(that: Number) = Number(x + that.x)

    // Postfix operator
    def -- = Number(x - 1)

    // prefix operator
    def unary_! = Number(-x)

    override def toString = x.toString
  }

  def main(args: Array[String]) = {
    println(s"1 + 1 = ${Number(1) + Number(1)}")
    println(s"1 -- = ${Number(1) --}")
    println(s"!1 = ${!Number(1)}")
  }
}
