class Map[T,U](val f: T=>U ){
    def apply(x: T): U = f(x)
} 

class Homomorphism[T,U](f: T=>U) extends Map[T, U](f)


class Function[T,U](f: T=>U) extends Map[T, U](f)