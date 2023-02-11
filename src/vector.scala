package vector

abstract class Vector[T] extends Tensor

class VectorImpl[T](size: Natural) extends Vector[T] {
    val length: Natural = size
    val value: IndexedSeq[T] = Range(0, size.toInt) map (_=> 0)
    def apply(index:Natural) : T = value(index.toInt)
}

object Vector {
    def apply(size: Natural) : Vector = {
        new VectorImpl(size)
    }
}


