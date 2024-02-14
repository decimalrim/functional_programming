package fp_java.ch07.primitivestream;

import java.util.List;
import java.util.OptionalDouble;

import fp_java.ch02.stream.vo.Dish;
import fp_java.ch02.stream.vo.DishData;

public class PrimitiveStreamExample {
	
	public static void main(String[] args) {
		
		List<Dish> menu = DishData.menu;
		
		// 일반스트림으로 모든 메뉴들의 칼로리 총 합을 구해보기
		int calories = menu.stream()
//                          .map((dish) -> dish.getCalories()) // Stream<Integer>
							.map(Dish::getCalories) // Stream<Integer> 위랑 같음
							.reduce(0, (sumCalories, calory) -> sumCalories + calory);
		System.out.println(calories);
		
		// 프리미티브스트림으로 모든 메뉴들의 칼로리 총 합을 구해보기
		calories = menu.stream() // Stream<Dish>
//						.mapToInt((dish) -> dist.getCalories()) // IntStream
						.mapToInt(Dish::getCalories) // IntStream
						.sum();
		System.out.println(calories);
		
		// 프리미티브스트림으로 채식 메뉴들의 칼로리 총 합을 구해보기
		calories = menu.stream()
//			.filter(dish -> dish.isVegetarian())
			.filter(Dish::isVegetarian)
//			.mapToInt((dish) -> dist.getCalories())
			.mapToInt(Dish::getCalories)
			.sum();
		System.out.println(calories);
			
		// 프리미티브스트림으로 채식 메뉴들의 평균 칼로리를 구해보기
		double averageCalory = menu.stream()
			.filter(Dish::isVegetarian)
			.mapToInt(Dish::getCalories)
			.average()
			.orElse(0);
		System.out.println(averageCalory);
		
	}

}
