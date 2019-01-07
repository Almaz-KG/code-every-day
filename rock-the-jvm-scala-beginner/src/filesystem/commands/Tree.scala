package filesystem.commands
import filesystem.State
import filesystem.files.{Directory, File}

object Tree extends Command {

  override def apply(state: State): State = {
    val output: String = buildTree(state.workingDirectory, "")
    State(state.workingDirectory, output)
  }


  private def buildTree(file: File, accumulator: String): String = {
    if (file.isDirectory){
      val directory = file.asInstanceOf[Directory]

      if (directory.contents.isEmpty)
        accumulator + "\n" + file.path
      else {
        directory
          .contents
          .map(f => buildTree(f, accumulator))
          .mkString("")
      }
    } else {
      accumulator + "\n" + file.path
    }
  }
}
