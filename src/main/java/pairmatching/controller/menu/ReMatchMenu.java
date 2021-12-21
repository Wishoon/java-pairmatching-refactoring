package pairmatching.controller.menu;

import java.util.Arrays;

public enum ReMatchMenu {
	RE_MATCH("네"),
	NOT_RE_MATCH("아니오");

	private static final String ERROR_INPUT_EXISTS_NOT_COMMAND = "존재하지 않는 명령입니다.";
	private final String command;

	ReMatchMenu(String command) {
		this.command = command;
	}

	public static ReMatchMenu findByCommand(String command) {
		return Arrays.stream(ReMatchMenu.values())
			.filter(reMatchMenu -> reMatchMenu.command.equals(command))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_INPUT_EXISTS_NOT_COMMAND));
	}
}
