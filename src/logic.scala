
abstract class LogicalFormula{
    def eval:Boolean
    def apply(): Boolean = eval
}

class PropositionalLetter(val c:Char, truth: Boolean) extends LogicalFormula{
    def eval:Boolean = truth
}

class Predicate(val truth: Any => Boolean) extends LogicalFormula {
    def eval: Boolean = ???
    def apply(name:Any):Boolean = truth(name)
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

