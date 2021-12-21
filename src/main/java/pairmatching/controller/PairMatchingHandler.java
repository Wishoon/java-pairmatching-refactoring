package pairmatching.controller;

import java.io.IOException;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.service.PairMatchingService;

public class PairMatchingHandler {
	public static void generateMatching(Course course, Level level, Mission mission) throws IOException {
		if (PairMatchingService.validateExistPairMatching(course, level, mission)) {
			return;
		}
		PairMatchingService.generatePairMatching(course, level, mission);
	}
}
