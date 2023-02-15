abstract class Num

def isPrime(a: Int): Boolean = {
    def _isPrime(cur:Int)(a: Int): Boolean = {
        if ( cur == a ) true
        else if (a % cur == 0) false
        else _isPrime(cur + 1) (a)
    }

    if (a <= 1) false
    else _isPrime(2)(a)
}

case class Prime(val v:Int) extends Num {
    require( isPrime(v) )

    override def toString: String = v.toString
    override def equals(other: Any): Boolean = other match {
        case Prime(that) => this.v == that
        case _ => false
    }
}

case class Natural(val v: Int) extends Num {
    require(v >= 0)

    override def toString: String = v.toString
    override def equals(other: Any): Boolean = other match {
        case Natural(that) => this.v == that
        case _ => false
    }
}

case class Integer(val v: Int) extends Num{

    override def toString: String = v.toString
    override def equals(other: Any): Boolean = other match {
        case Integer(that) => this.v == that
        case _ => false
    }
}

case class Rational(val numer: Int, val denom: Int) extends Num{

    override def toString: String = numer + "/" + denom
    override def equals(other: Any): Boolean = other match {
        case Rational(that1, that2) => this.denom == that2 && this.numer == that1
        case _ => false
    }
}

case class Real(val v: Double) extends Num {

    override def toString: String = v.toString
    override def equals(other: Any): Boolean = other match {
        case Real(that) => this.v == that
        case _ => false
    }
}

case class Complex(val real:Double, val imag:Double) extends Num{

    override def toString: String = real + "+" + imag + "i"
    override def equals(other: Any): Boolean = other match {
        case Complex(that1, that2) => this.real == that1 && this.imag == that2
        case _ => false
    }
}

case object Infinity extends Num {

    override def toString: String = "inf"
}

case object -Infinity extends Num {

    override def toString: String = "-inf"
}


def addNatural(a: Natural, b: Natural): Natural = new Natural( a.v + b.v )
def mulNatural(a: Natural, b: Natural): Natural = new Natural( a.v * b.v)
def addInteger(a: Integer, b: Integer): Integer = new Integer( a.v + b.v )
def mulInteger(a: Integer, b: Integer): Integer = new Integer( a.v * b.v )
def subInteger(a: Integer, b: Integer): Integer = new Integer( a.v - b.v )
def addRational(a: Rational, b: Rational): Rational = new Rational( a.numer * b.denom + b.numer * a.denom, a.denom * b.denom)
def mulRational(a: Rational, b: Rational): Rational = new Rational( a.numer * b.numer, a.denom * b.denom)
def subRational(a: Rational, b: Rational): Rational = new Rational( a.numer * b.denom - b.numer * a.denom, a.denom * b.denom)
def divRational(a: Rational, b: Rational): Rational = new Rational( a.numer * b.denom, a.denom * b.numer)
def addReal(a: Real, b: Real): Real = new Real(a.v + b.v)
def mulReal(a: Real, b: Real): Real = new Real(a.v * b.v)
def subReal(a: Real, b: Real): Real = new Real(a.v - b.v)
def divReal(a: Real, b: Real): Real = new Real(a.v / b.v)
def addComplex(a: Complex, b:Complex): Complex = new Complex(a.real + b.real, a.imag + b.imag)
def mulComplex(a: Complex, b:Complex): Complex = new Complex(a.real * b.real - a.imag * b.imag, a.real * b.imag + a.imag * b.real)
def subComplex(a: Complex, b:Complex): Complex = new Complex(a.real - b.real, a.imag - b.imag)
def divComplex(a: Complex, b:Complex): Complex = new Complex((a.real * b.real + a.imag * b.imag) / (b.real * b.real + b.imag * b.imag), ( -a.real * b.imag + a.imag * b.real ) / (b.real * b.real + b.imag * b.imag))