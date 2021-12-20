package pairmatching.domain;

import java.util.Arrays;

public enum Mission {
	RACING_CAR("자동차경주"),
	LOTTO("로또"),
	BASEBALL_NUMBER_GAME("숫자야구게임"),
	SHOPPING_BASKET("장바구니"),
	PAYMENT("결제"),
	SUBWAY_MAP("지하철노선도"),
	PERFORMANCE_IMPROVEMENT("성능개선"),
	DISTRIBUTE("배포");

	private static final String ERROR_INPUT_EXIST_NOT_COMMAND = "존재하지 않는 미션입니다.";
	private final String name;

	Mission(String name) {
		this.name = name;
	}

	public static Mission findByMission(String command) {
		return Arrays.stream(Mission.values())
			.filter(mission -> mission.name.equals(command))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_INPUT_EXIST_NOT_COMMAND));
	}
}
