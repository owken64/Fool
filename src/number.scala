abstract class Num

abstract class PAdicNumber extends Num

abstract class Complex extends Num
class ComplexEntity(val real:Double, val imag:Double) extends Complex
object Complex {
    def apply(r:Double, i:Double): Complex = new ComplexEntity(r, i)
}

abstract class Real extends Complex

abstract class Rational extends Real

abstract class Integer extends Rational

abstract class Natural extends Integer

abstract class Prime extends Natural