
abstract class Function[T, U <: Num] extends Mapping[T,U] {
    def apply(args: T): U
}

object AddNatural extends Function[(Natural, Natural), Natural] {
    def apply(args: (Natural, Natural)): Natural = Natural( args(0).toInt + args(1).toInt )
}

object MulNatural extends Function[(Natural, Natural), Natural] {
    def apply(args: (Natural, Natural)): Natural = Natural( args(0).toInt * args(1).toInt )
}

