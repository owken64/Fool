package something

import logic

abstract class Something {
    val name: Option[String]
    val typeName: String
    val logic: List[LogicalFormula]

    override def toString(): String = {
        if !name.isEmpty then{
            name.get + ":" + this.typeName
        }
        else {
            "Anon" + ":" + this.typeName
        }
    }
}

class AnonymousSomething(t: String) extends Something {
    val name: Option[String] = None
    val typeName: String = t
    val logic: List[LogicalFormula] = Nil 
}

object Something {
    def apply(t:String): Something = new AnonymousSomething(t)
}