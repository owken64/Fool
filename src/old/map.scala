package map

class Map[T,U](val f: T=>U ){
    def apply(x: T): U = f(x)
} 

trait Homomorphism[T,U] extends Map[T,U]

trait Injection[T,U] extends Map[T,U]

trait Surjective[T, U] extends Map[T,U]

trait Bijection[T, U](f: T=>U) extends Injection[T,U] with Surjective[T, U]

trait Isomorphism[T, U](f: T=>U) extends Homomorphism[T, U] with Bijection[T, U]