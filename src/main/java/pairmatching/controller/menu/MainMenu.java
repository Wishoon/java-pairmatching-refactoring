package pairmatching.controller.menu;

import java.util.Arrays;

import pairmatching.controller.MainHandler;

public enum MainMenu {
	MATCHING_MANAGER("1", MainHandler::matchingManager),
	SELECT_MANAGER("2", MainHandler::selectManager),
	RESET_MANAGER("3", MainHandler::resetManager),
	EXIT_MANAGER("Q", MainHandler::exitManager);

	private static final String ERROR_INPUT_EXISTS_NOT_COMMAND = "존재하지 않는 명령입니다.";
	private final String command;
	private final Runnable runnable;

	MainMenu(String command, Runnable runnable) {
		this.command = command;
		this.runnable = runnable;
	}

	public static MainMenu findByCommand(String command) {
		return Arrays.stream(MainMenu.values())
			.filter(menu -> menu.command.equals(command))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_INPUT_EXISTS_NOT_COMMAND));
	}

	public void run() {
		this.runnable.run();
	}
}
