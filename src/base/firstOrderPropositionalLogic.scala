package logic.firstOrderPropositionalLogic

import logic.LogicalFormula

package syntax {

}

package semantics {
    abstract class Dt
    object One extends Dt
    object Zero extends Dt

    class 解釈(I: LogicalFormula => Dt) {
        def apply(lf: LogicalFormula) = I(lf)
    }

    var allI: List[解釈] = Nil
}

package inference {

    class Inference(gamma: Seq[LogicalFormula], delta: Option[LogicalFormula]) {
        require( !semantics.aiiI.exists( I => gamma.forall( x => I(x)) && if ( !delta.isEmpty ) I(delta.get) == semantics.Zero )  )
    }
}