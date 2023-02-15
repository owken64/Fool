package relation

abstract class Relation[T](op: (T,T)=>Boolean) extends Function[(T, T), Boolean](op) {
    def apply(lhs: T, rhs:T): Boolean = op(lhs, rhs)
}

