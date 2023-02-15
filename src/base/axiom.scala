package axiom

import truthValue
import logic

class Axiom(val f: LogicalFormula, n: Option[String] = None) extends LogicalFormula {
    override def name: Option[String] = n
    val formula: String = f.formula
    def eval: TruthValue = True
}

