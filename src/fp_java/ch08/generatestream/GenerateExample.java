package fp_java.ch08.generatestream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class GenerateExample {
	
	public static void main(String[] args) {
		
		// 배열로 스트림 만들기1
		int[] numbers = {2, 3, 5, 7, 11, 13};
		Arrays.asList(numbers) // List<Int>
		      .stream() // Stream<Int[]>
		      .flatMapToInt(intArray -> Arrays.stream(intArray)) // IntStream 
		      .boxed() // Stream<Integer>
//		      .forEach(number -> System.out.println(number));
		      .forEach(System.out::println);
		
		// 배열로 스트림 만들기2
		Arrays.stream(numbers) // IntStream
			  .boxed() // Stream<Integer>
//			  .forEach(number -> System.out.println(number));
			  .forEach(System.out::println);
		
		// 문자열
		String[] chars = {"A", "B", "C"};
		Arrays.asList(chars) // List<String>
			  .stream() // Stream<String>
			  .forEach(System.out::println);
		
		Arrays.stream(chars) // Stream<String>
			  .forEach(System.out::println); // 위랑 같음
		
		// 파일로 스트림 만들기1
		File textFile = new File("C:\\Java Exam", "Java Exam.txt");
		List<String> lines = null;
		try {
			lines = Files.readAllLines(textFile.toPath(), Charset.defaultCharset());
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		if(lines != null) {
			lines.stream() // Stream<List>
				 .forEach(System.out::println);
		}
		
		// 파일로 스트림 만들기2
		// Auto closable Try ~ catch
		try (Stream<String> streamLines = Files.lines(textFile.toPath(), Charset.defaultCharset())) {
			streamLines.forEach(System.out::println);
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		
		// 리스트로 스트림만들기
		List<Integer> numberList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		numberList.stream() // Stream<Integer>
				  .map(number -> number * 2)
				  .forEach(System.out::println);
		

		
	}

}
