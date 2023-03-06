package entity

abstract class NaturalNumber extends Number

class SUCC(expr: NaturalNumber) extends NaturalNumber {
    override def toString: String = "SUCC(" + expr.toString +")"
}

object Zero extends NaturalNumber {
    override def toString: String = "0"
}

object NaturalNumber {
    def apply(n: Int): NaturalNumber = {
        n match {
            case 0 => Zero
            case n if n > 0 => new SUCC( NaturalNumber(n-1) )
        }
    }
}
