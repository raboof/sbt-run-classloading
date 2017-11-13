object Main extends App {
  // Works:
  Class.forName("scala.Int")

  // Does not work:
  val classLoader = Option(Thread.currentThread.getContextClassLoader).get
  Class.forName("scala.Int", true, classLoader)
  
  // And neither:
  Class.forName("scala.Int", false, classLoader)
}
