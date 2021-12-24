package pairmatching.controller;

import static pairmatching.controller.MainHandler.*;

import java.io.IOException;

import pairmatching.controller.menu.ReMatchMenu;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.service.PairMatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingHandler {
	public static final String INPUT_SPLIT = ", ";
	public static final int INPUT_SPLIT_LIMIT = -1;

	public static void generateMatching(Course course, Level level, Mission mission) throws IOException {
		if (PairMatchingService.validateExistPairMatching(course, level, mission)) {
			generateReMatching(course, level, mission);
			return;
		}
		PairMatchingService.generatePairMatching(course, level, mission);
	}

	private static void generateReMatching(Course course, Level level, Mission mission) throws IOException {
		try {
			ReMatchMenu byCommand = ReMatchMenu.findByCommand(InputView.getInputReMatchingCommand());
			if (byCommand.equals(ReMatchMenu.RE_MATCH)) {
				PairMatchingService.updatePairMatching(course, level, mission);
			}
			if (byCommand.equals(ReMatchMenu.NOT_RE_MATCH)) {
				matchingManager();
			}
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e);
			generateReMatching(course, level, mission);
		}
	}

	private static void matchingManager() {
		try {
			final String[] command_element = InputView.getInputRePairMatchingCommand()
				.split(INPUT_SPLIT, INPUT_SPLIT_LIMIT);
			Course course = Course.findByCourse(command_element[COURSE_INDEX]);
			Level level = Level.findByLevel(command_element[LEVEL_INDEX]);
			Mission mission = Mission.findByMission(command_element[MISSION_INDEX]);

			generateMatching(course, level, mission);
		} catch (Exception e) {
			OutputView.printErrorMessage(e);
			matchingManager();
		}
	}
}
