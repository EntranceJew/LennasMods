package scripts.phone

import scala.util.continuations._

class NiceContact extends PhoneContactScript {
  override def call(): Boolean @cps[Unit] = {
    showText("Nice.")
    true
  }
}