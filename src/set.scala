package set

abstract class Set extends Type1 {
    def _include(that: Type0): Boolean

}

object Set {
    def apply(include_algorithm: Type0=>Boolean): Set = new Set {
            def _include(that:Type0): Boolean = include_algorithm(that)
            override def include(that:Type): Boolean = that match {
                case t0: Type0 => _include(t0)
                case _ => false
            }
    }
}

