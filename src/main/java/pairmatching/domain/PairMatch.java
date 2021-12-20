package pairmatching.domain;

public class PairMatch {
	private Course course;
	private Level level;
	private Mission mission;
	private Pairs pairs;

	public PairMatch(Course course, Level level, Mission mission, Pairs paris) {
		this.course = course;
		this.level = level;
		this.mission = mission;
		this.pairs = paris;
	}

	public static PairMatch of(Course course, Level level, Mission mission, Pairs pairs) {
		return new PairMatch(course, level, mission, pairs);
	}

	public boolean equalsCourse(Course course) {
		return course.equals(course);
	}

	public boolean equalsLevel(Level level) {
		return level.equals(level);
	}

	public boolean equalsMission(Mission mission) {
		return mission.equals(mission);
	}

	public boolean equalsPairs(Pairs pairs) {
		return this.pairs.isValidateSamePairs(pairs);
	}

	public Pairs getPairs() {
		return pairs;
	}
}
