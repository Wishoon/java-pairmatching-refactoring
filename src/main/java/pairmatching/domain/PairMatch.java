package pairmatching.domain;

import java.util.Objects;

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
		return this.course.equals(course);
	}

	public boolean equalsLevel(Level level) {
		return this.level.equals(level);
	}

	public boolean equalsMission(Mission mission) {
		return this.mission.equals(mission);
	}

	public boolean equalsPairs(Pairs pairs) {
		return this.pairs.isValidateSamePairs(pairs);
	}

	public Pairs getPairs() {
		return pairs;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof PairMatch))
			return false;
		PairMatch pairMatch = (PairMatch)o;
		return course == pairMatch.course && level == pairMatch.level && mission == pairMatch.mission
			&& Objects.equals(pairs, pairMatch.pairs);
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, level, mission, pairs);
	}
}
