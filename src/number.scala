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
class RationalEntity(val numer:Int, val denom:Int) extends Rational {
    def getReal(): Double = numer.toDouble / denom.toDouble 
}

object Rational {
    def apply(numer:Int, denom:Int): Rational = {
        new RationalEntity(numer, denom)
    }
}

abstract class Integer extends Rational {
    def toInt: Int
}

class IntegerEntity(val value:Int) extends Integer {
    def getReal() :Double = value.toDouble
    def toInt: Int = value
}

object Integer {
    def apply(v:Int): Integer = {
        new IntegerEntity(v)
    }
}

abstract class Natural extends Integer
class NaturalEntity(val value: Int) extends Natural {
    require( value >= 0)
    def getReal() : Double = value.toDouble
    def toInt: Int = value
}

object Natural {
    def apply(v:Int): Natural = {
        new NaturalEntity(v)
    }
}

abstract class Prime extends Natural {
    protected def isPrime(v: Int):Boolean = {
        (v != 1) && (Range(2, v) forall ( x => (v % x != 0)))
    }
}
class PrimeEntity(val value:Int) extends Prime{
    require(isPrime(value))
    def getReal(): Double = value.toDouble
    def toInt: Int = value
}

object Prime{
    def apply(v:Int): Prime = {
        new PrimeEntity(v)
    }
}

object Infinity extends Num
