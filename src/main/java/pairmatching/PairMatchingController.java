package pairmatching;

import pairmatching.controller.menu.MainMenu;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	private static final String EXIT_PROGRAM_COMMAND = "Q";

	public void run() {
		try {
			String inputMainCommand;
			do {
				inputMainCommand = InputView.getInputMainCommand();
				MainMenu.findByCommand(inputMainCommand).run();
			} while (isContinueProgram(inputMainCommand));
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e);
			run();
		}
	}

	private boolean isContinueProgram(String command) {
		return !EXIT_PROGRAM_COMMAND.equals(command);
	}
}
