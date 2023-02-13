package set

abstract class Set extends Type1 {

}

object Set {
    def apply(include_algorithm: Type=>Boolean): Set = new Set {
            override def include(that:Type): Boolean = include_algorithm(that)
    }
}

