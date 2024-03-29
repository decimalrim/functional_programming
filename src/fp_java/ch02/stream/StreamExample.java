package fp_java.ch02.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import fp_java.ch02.stream.vo.Dish;
import fp_java.ch02.stream.vo.DishData;

public class StreamExample {
	
	
	public static void main(String[] args) {
		
		List<Dish> menu = DishData.menu;
		
		List<String> lowCaloricDishesName = 
				// List<Dish> -> Stream<Dish>로 변경
				menu.stream()
				// 병렬처리를 하는 스트림
//				menu.parallelStream()
					// 데이터 걸러냄, 400칼로리 이하의 요리 선택
					// filter(Predicate<Dish>
					// Predicate -> dish를 파라미터로 받아서
					//				boolean으로 반환.
					//				true가 반환된 것만 새로운 Stream으로 생성된다.
					.filter(dish -> dish.getCalories() > 300)
					// 데이터 오름차순 정렬(칼로리 기준)
					// sorted(Comparator<Dish>)
					// Comparator -> compare(dish1, dish2)
					//					-> dish1.getCalories() - dish2.getCalories()
					//						-> 오름차순
					//					-> dish2.getCalories() - dish1.getCalories()
					//						-> 내림차순
					//					-> Comparator.comparing(Dish::getCalories)
					.sorted(Comparator.comparing(Dish::getCalories)) // 람다식-오름차순 할때 편함
//					.sorted(Comparator.comparing(dish -> dish.getCalories)) // 원래 코드
//					.sorted(dish1, dish2) -> dish1.getCalories() - dish2.getCalories()
					// 데이터 변경 (Dish -> Name)
					// map(Function<Dish, 반환되는타입>)
					.map(Dish::getName)
//					.map(dish -> dish.getName()) // 원래 코드
					// 현재까지 처리된 Stream 데이터에서 상위 2개는 제외한다.
					.skip(2)
					// 현재까지 처리된 Stream 데이터에서 가장 상위 데이터 3개만 가져온다.
					.limit(3)
					// List로 변경, 모든 요리명을 리스트에 저장
					// 최종함수: Stream을 일반 클래스 혹은 Primitive Type으로 반환
					// Collectors.toList() -> Stream을 List로 변경.
					// 이 때, Stream의 제네릭이 List에도 동일하게 전달
					// Stream<String> ==> List<String>
					.collect(Collectors.toList());
		
		
		lowCaloricDishesName
			// Stream 혹은 List의 데이터를 반복하며 Lamda를 수행.
			// forEach(Consumer<String>)
			// Consumer -> String을 파라미터로 받아 VOID를 반환.
			.forEach(System.out::println);
//			.forEach(menuName -> System.out.println(menuName));
		
		
		
	}

}
