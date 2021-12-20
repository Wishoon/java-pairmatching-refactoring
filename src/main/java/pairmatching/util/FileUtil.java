package pairmatching.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	public static List<String> fileReader(String location) throws IOException {
		final List<String> names = new ArrayList<>();

		Path currentPath = Paths.get("");
		String path = currentPath.toAbsolutePath() + "/src/main/resources";
		BufferedReader reader = new BufferedReader(new FileReader(path + location));
		String str;
		while ((str = reader.readLine()) != null) {
			names.add(str);
		}
		reader.close();

		return names;
	}
}
