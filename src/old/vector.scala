package vector

abstract class Vector[T <: Complex] extends Tensor {
    val lenght: Natural
    def apply(index:Natural): T
}

class ZeroVector[T <: Complex](size: Natural) extends Vector[T] {
    val length: Natural = size
    val value: IndexedSeq[T] = Range(0, size.toInt) map (_=> Compex(0, 0))
    def apply(index:Natural) : T = value(index.toInt)
}

object Vector {
    def apply[T](size: Natural) : Vector[T] = {
        new ZeroVector(size)
    }
}


