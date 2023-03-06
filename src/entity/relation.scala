package entity

class Relation extends Map

object in extends Relation {
    def apply(lhs:Any, rhs:Any): Boolean = {
        rhs match {
            case ls: LogicalSet => ls.condition(lhs)
            case es: ElementalSet => es.elements.exists(x => x == lhs)
            case _ => false
        }
    }
}

