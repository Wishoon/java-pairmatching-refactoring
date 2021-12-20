package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Pair {
	private List<String> name;

	public Pair(List<String> name) {
		this.name = name;
	}

	public static Pair of(String firstPair, String twicePair) {
		return new Pair(Arrays.asList(firstPair, twicePair));
	}

	public static Pair of(String firstPair, String twicePair, String thirdPair) {
		return new Pair(Arrays.asList(firstPair, twicePair, thirdPair));
	}

	public List<String> getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Pair))
			return false;
		Pair pair = (Pair)o;
		return Objects.equals(name, pair.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
