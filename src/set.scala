package set

abstract class Set extends Type1

object Set {
    def apply(in_algorithm: Type=>Boolean): Set = new Set {
            override def in(that:Type): Boolean = in_algorithm(that)
    }
}

