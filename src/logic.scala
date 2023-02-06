
abstract class LogicalFormula{
    def eval:Boolean
}

class PropositionalLetter(val c:Char) extends LogicalFormula{

}

abstract class TruthFunction extends LogicalFormula{

}

abstract class ZeroPlaceTruthFunction extends TruthFunction {

}

object True extends ZeroPlaceTruthFunction {
    def eval:Boolean = true
}

object False extends ZeroPlaceTruthFunction {
    def eval:Boolean = false
}

abstract class OnePlaceTruthFunction extends TruthFunction {

}

class Not(val lf: LogicalFormula) extends OnePlaceTruthFunction {
    def eval:Boolean = ! lf.eval
}

abstract class TwoPlaceTruthFunction extends TruthFunction {

}

