import com.raquo.laminar.api.L._
import org.scalajs.dom

object Main {
  val app = {
    val $tick = EventStream.periodic(1000)
    div(
      div(
        "Tick #: ",
        child.text <-- $tick.map(_.toString)
      ),
      div(
        "Random #: ",
        child.text <-- $tick.mapTo((scala.util.Random.nextInt() % 100).toString)
      )
    )
  }

  def main(args: Array[String]): Unit = {
    documentEvents.onDomContentLoaded.foreach { _ =>
      render(dom.document.getElementById("main"), app)
    }(unsafeWindowOwner)
  }
}
