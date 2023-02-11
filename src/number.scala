abstract class Num extends Type0

abstract class PAdicNumber extends Num

abstract class Complex extends Num {
    def getReal():Double
    def getImag():Double
}
class ComplexEntity(val real:Double, val imag:Double) extends Complex {
    def getReal() = real
    def getImag() = imag
}

object Complex {
    def apply(r:Double, i:Double): Complex = new ComplexEntity(r, i)
}

abstract class Real extends Complex {
    def getImag():Double = 0.0
}

class RealEntity(val real:Double) extends Real {
    def getReal():Double = real
}

object Real {
    def apply(r:Double): Real = new RealEntity(r)
}

abstract class Irrational extends Real

abstract class Root extends Irrational
abstract class Sqrt extends Root

abstract class Rational extends Real

abstract class Integer extends Rational

abstract class Natural extends Integer

abstract class Prime extends Natural