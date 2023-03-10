class Is(s: Something, t:String) extends Relation {
    val formula: String = s.toString + " is " + t
    override def eval: TruthValue = if s.typeName == t then True else False
}

object Is {
    def apply(s:Something, t: String) : Is = new Is(s, t)
}
