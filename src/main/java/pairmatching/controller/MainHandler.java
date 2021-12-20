package pairmatching.controller;

import java.io.IOException;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainHandler {
	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;
	private static final int MISSION_INDEX = 2;

	public static void matchingManager() {
		try {
			final String[] command_element = InputView.getInputPairMatchingCommand().split(", ", -1);
			Course course = Course.findByCourse(command_element[COURSE_INDEX]);
			Level level = Level.findByLevel(command_element[LEVEL_INDEX]);
			Mission mission = Mission.findByMission(command_element[MISSION_INDEX]);

			PairMatchingHandler.generateMatching(course, level, mission);
		} catch (IllegalArgumentException | IOException e) {
			OutputView.printErrorMessage(e);
			matchingManager();
		}
	}

	public static void selectManager() {
	}

	public static void resetManager() {
	}

	public static void exitManager() {
		return;
	}
}
