package pairmatching.controller;

import java.io.IOException;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.repository.PairMatchingRepository;
import pairmatching.domain.service.PairMatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingHandler {

	private static final String NOT_RE_MATCHING = "아니오";

	public static void generateMatching(Course course, Level level, Mission mission) throws IOException {
		if (PairMatchingService.validateExistPairMatching(course, level, mission)) {
			final String inputReMatchingCommand = InputView.getInputReMatchingCommand();
			if (inputReMatchingCommand.equals(NOT_RE_MATCHING)) {
				return;
			}
		}
		PairMatchingService.generatePairMatching(course, level, mission);
		OutputView.printGenerateMatchingResult(PairMatchingRepository.selectPairCrews(course, level, mission));
	}
}
