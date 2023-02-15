package truthValue

abstract class TruthValue

object True extends TruthValue {
    override def toString(): String = "True"
}

object False extends TruthValue {
    override def toString(): String = "False"
}

object Unsolved extends TruthValue {
    override def toString(): String = "Unsolved"
}
