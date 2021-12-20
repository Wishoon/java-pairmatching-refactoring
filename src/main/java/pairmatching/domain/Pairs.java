package pairmatching.domain;

import java.util.List;

public class Pairs {
	private List<Pair> pairs;

	public Pairs(List<Pair> pairs) {
		this.pairs = pairs;
	}

	public boolean isValidateSamePairs(Pairs pairs) {
		for (Pair pair : this.pairs) {
			boolean equalsPair = pairs.getPairs().stream()
				.anyMatch(otherPair -> otherPair.equals(pair));

			if (equalsPair) {
				return false;
			}
		}

		return true;
	}

	public List<Pair> getPairs() {
		return pairs;
	}
}
