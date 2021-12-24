package pairmatching.view;

import pairmatching.domain.Pair;
import pairmatching.domain.PairMatch;

public class OutputView {
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String COLON = " : ";
	private static final String PAIR_MATCHING_RESULT_MESSAGE = "페어 매칭 결과입니다.";
	private static final String PAIR_MATCHING_INITIALIZE_MESSAGE = "초기화 되었습니다.";
	private static final int FIRST_PAIR_INDEX = 0;

	public static void printGenerateMatchingResult(PairMatch pairMatch) {
		System.out.println(PAIR_MATCHING_RESULT_MESSAGE);
		for (Pair pair : pairMatch.getPairs().getPairs()) {
			System.out.print(pair.getName().get(FIRST_PAIR_INDEX));
			for (int i = 1; i < pair.getName().size(); i++) {
				System.out.print(COLON + pair.getName().get(i));
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printErrorMessage(Exception e) {
		System.out.println(ERROR_MESSAGE + e.getMessage() + System.lineSeparator());
	}

	public static void printInitializeMatching() {
		System.out.println(PAIR_MATCHING_INITIALIZE_MESSAGE);
	}
}
