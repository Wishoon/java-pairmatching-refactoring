package pairmatching.controller;

import java.io.IOException;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.PairMatch;
import pairmatching.domain.repository.PairMatchingRepository;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainHandler {
	public static final int COURSE_INDEX = 0;
	public static final int LEVEL_INDEX = 1;
	public static final int MISSION_INDEX = 2;
	public static final String INPUT_SPLIT = ", ";
	public static final int INPUT_SPLIT_LIMIT = -1;

	public static void matchingManager() {
		try {
			final String[] command_element = InputView.getInputPairMatchingCommand()
				.split(INPUT_SPLIT, INPUT_SPLIT_LIMIT);
			Course course = Course.findByCourse(command_element[COURSE_INDEX]);
			Level level = Level.findByLevel(command_element[LEVEL_INDEX]);
			Mission mission = Mission.findByMission(command_element[MISSION_INDEX]);

			PairMatchingHandler.generateMatching(course, level, mission);
			OutputView.printGenerateMatchingResult(PairMatchingRepository.selectPairMatch(course, level, mission));
		} catch (IllegalArgumentException | IOException e) {
			OutputView.printErrorMessage(e);
			matchingManager();
		}
	}

	public static void selectManager() {
		String[] command_element = null;
		try {
			command_element = InputView.getInputPairMatchingCommand().split(INPUT_SPLIT, INPUT_SPLIT_LIMIT);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e);
			selectManager();
		}
		Course course = Course.findByCourse(command_element[COURSE_INDEX]);
		Level level = Level.findByLevel(command_element[LEVEL_INDEX]);
		Mission mission = Mission.findByMission(command_element[MISSION_INDEX]);

		PairMatch pairMatch = PairMatchingRepository.selectPairMatch(course, level, mission);
		OutputView.printGenerateMatchingResult(pairMatch);
	}

	public static void resetManager() {
		PairMatchingRepository.deleteAllMatching();
		OutputView.printInitializeMatching();
	}

	public static void exitManager() {
		return;
	}
}
