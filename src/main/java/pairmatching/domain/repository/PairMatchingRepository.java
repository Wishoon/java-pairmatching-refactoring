package pairmatching.domain.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.PairMatch;

public class PairMatchingRepository {
	private static final String ERROR_EXIST_NOT_PAIR_MATCH = "매칭된 내역이 존재하지 않습니다.";
	private static final List<PairMatch> pairMatchings = new ArrayList<>();

	public static List<PairMatch> pairMatchings() {
		return Collections.unmodifiableList(pairMatchings);
	}

	public static void addMatching(PairMatch pairMatch) {
		pairMatchings.add(pairMatch);
	}

	public static PairMatch selectPairCrews(Course course, Level level, Mission mission) {
		return pairMatchings.stream()
			.filter(matching -> matching.equalsCourse(course))
			.filter(matching -> matching.equalsLevel(level))
			.filter(matching -> matching.equalsMission(mission))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_EXIST_NOT_PAIR_MATCH));
	}
}
