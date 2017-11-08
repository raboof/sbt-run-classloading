bug::ConfigFactory
---

- application.conf + ConfigFactory.load()
  + sbt 0.13.16 + `sbt "$name/run"` - works well
  + sbt 1.0.3 + IntelliJ - works well
  + sbt 1.0.3 + `sbt "$name/run"` - not works

- ConfigFactory.parseString(str)
  + sbt 1.0.3 + `sbt "$name/run"` - not works
