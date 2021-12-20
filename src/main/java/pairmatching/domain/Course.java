package pairmatching.domain;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드", "/backend-crew.md"),
	FRONTEND("프론트엔드", "/frontend-crew.md");

	private static final String ERROR_INPUT_NOT_EXIST_COMMAND = "해당 코스는 존재하지 않습니다.";
	private String name;
	private String crewNameLocation;

	Course(String name, String crewNameLocation) {
		this.name = name;
		this.crewNameLocation = crewNameLocation;
	}

	public static Course findByCourse(String command) {
		return Arrays.stream(Course.values())
			.filter(course -> course.name.equals(command))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_INPUT_NOT_EXIST_COMMAND));
	}

	public String getNameLocation() {
		return crewNameLocation;
	}
}
