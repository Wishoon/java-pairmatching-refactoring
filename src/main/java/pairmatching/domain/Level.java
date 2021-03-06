package pairmatching.domain;

import java.util.Arrays;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private static final String ERROR_INPUT_NOT_EXIST_COMMAND = "존재하지 않는 레벨입니다.";
	private String name;

	Level(String name) {
		this.name = name;
	}

	public static Level findByLevel(String command) {
		return Arrays.stream(Level.values())
			.filter(level -> level.name.equals(command))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_INPUT_NOT_EXIST_COMMAND));
	}
}
