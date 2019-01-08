package filesystem.commands
import filesystem.State

object UnknownCommand extends Command {

  override def apply(state: State): State =
    State(state.workingDirectory, output = "Command not found")

}