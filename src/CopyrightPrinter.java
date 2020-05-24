import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

public class CopyrightPrinter {

	public static void main(String[] args) throws IOException {
		final String copyright = "// Copyright Nolan Unruh, 2020";
		final String srcDir = new java.io.File("src").getCanonicalPath();
		Stream<Path> walk = Files.walk(Paths.get(srcDir));
		
		List<String> result = walk.map(x -> x.toString())
			.filter(f -> f.endsWith(".java")).collect(Collectors.toList());
			for (String path : result) {
				File files = new File(path);
				if (FileUtils.readFileToString(files, "UTF-8").contains(copyright)) {
				} else {
					FileUtils.writeStringToFile(files, "\n" + copyright, "UTF-8", true);
					}
				}
	
	}

}