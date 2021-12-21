package pairmatching.domain.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

	public static void updateMatching(PairMatch currentPairMatch, PairMatch newPairMatch) {
		pairMatchings.removeIf(pairMatch -> Objects.equals(pairMatch, currentPairMatch));
		pairMatchings.add(newPairMatch);
	}

	public static void deleteAllMatching() {
		pairMatchings.clear();
	}

	public static PairMatch selectPairMatch(Course course, Level level, Mission mission) {
		return pairMatchings.stream()
			.filter(matching -> matching.equalsCourse(course))
			.filter(matching -> matching.equalsLevel(level))
			.filter(matching -> matching.equalsMission(mission))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_EXIST_NOT_PAIR_MATCH));
	}
}
