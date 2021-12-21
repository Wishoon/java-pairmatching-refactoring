package pairmatching.domain.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatch;
import pairmatching.domain.Pairs;
import pairmatching.domain.repository.PairMatchingRepository;
import pairmatching.util.FileUtil;

public class PairMatchingService {
	private static final String ERROR_PAIR_NOT_MATCHING = "매칭을 할 수 없습니다.";
	private static final int LIMIT_PAIR_MATCHING_TRY_COUNT = 3;
	private static final int ODD_AND_EVEN_DIVISION_NUMBER = 2;

	public static boolean validateExistPairMatching(Course course, Level level, Mission mission) {
		List<PairMatch> pairMatchings = PairMatchingRepository.pairMatchings();
		List<PairMatch> pairMatch = pairMatchings.stream()
			.filter(matching -> matching.equalsCourse(course))
			.filter(matching -> matching.equalsLevel(level))
			.filter(matching -> matching.equalsMission(mission))
			.collect(Collectors.toList());

		return pairMatch.size() == 1;
	}

	public static void generatePairMatching(Course course, Level level, Mission mission) throws IOException {
		int generatePairMatchCount = 0;
		while (true) {
			Pairs pairs = isJudgeOddOrEvenCrewsNameSize(Randoms.shuffle(FileUtil.fileReader(course.getNameLocation())));
			if (generatePairMatchCount == LIMIT_PAIR_MATCHING_TRY_COUNT) {
				throw new IllegalArgumentException(ERROR_PAIR_NOT_MATCHING);
			}
			if (isValidateCourseAndLevelToSamePair(course, level, pairs)) {
				generatePairMatchCount++;
				continue;
			}
			PairMatchingRepository.addMatching(PairMatch.of(course, level, mission, pairs));
			break;
		}
	}

	private static boolean isValidateCourseAndLevelToSamePair(Course course, Level level, Pairs pairs) {
		List<PairMatch> pairMatchings = PairMatchingRepository.pairMatchings();
		List<PairMatch> equalsPairs = pairMatchings.stream()
			.filter(pairMatch -> pairMatch.equalsCourse(course))
			.filter(pairMatch -> pairMatch.equalsLevel(level))
			.filter(pairMatch -> pairMatch.equalsPairs(pairs))
			.collect(Collectors.toList());

		return equalsPairs.size() != 0;
	}

	private static Pairs isJudgeOddOrEvenCrewsNameSize(List<String> randomNames) {
		if (randomNames.size() % ODD_AND_EVEN_DIVISION_NUMBER != 0) {
			return new Pairs(calculateOddPairMatching(randomNames));
		}
		if (randomNames.size() % ODD_AND_EVEN_DIVISION_NUMBER == 0) {
			return new Pairs(calculateEvenPairMatching(randomNames));
		}

		return null;
	}

	private static List<Pair> calculateOddPairMatching(List<String> names) {
		final List<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < names.size() - 3; i += 2) {
			pairs.add(Pair.of(names.get(i), names.get(i + 1)));
		}

		final List<String> remainNames = new ArrayList<>(names.subList(names.size() - 3, names.size()));
		pairs.add(Pair.of(remainNames.get(0), remainNames.get(1), remainNames.get(2)));
		return pairs;
	}

	private static List<Pair> calculateEvenPairMatching(List<String> randomNames) {
		final List<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < randomNames.size(); i += 2) {
			pairs.add(Pair.of(randomNames.get(i), randomNames.get(i + 1)));
		}

		return pairs;
	}
}
