package day01;

import util.AdventUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Day1Task1Main {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		AdventUtils.getStringInput(1).stream().map(s -> s.split("   ")).forEach(s -> {
			list1.add(Integer.valueOf(s[0]));
			list2.add(Integer.valueOf(s[1]));
		});

		list1.sort(Comparator.naturalOrder());
		list2.sort(Comparator.naturalOrder());

		int totalDist = IntStream.range(0, list1.size()).map(i -> list1.get(i) - list2.get(i)).map(Math::abs).sum();

		AdventUtils.publishResult(1, 1, totalDist);
	}
}
