package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamEx5 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("바둑","바나나","포도","딸기","바질","강아지");
		
		//'바'로 시작하는 문장만 출력
		for(String f: list) {
			if(f.startsWith("바")) {
				System.out.println(f);
			}
		}
		//stream 이용
		//list.stream().filter(f -> f.startsWith("바")).forEach(f -> System.out.println(f));
		list.stream().filter(f -> f.startsWith("바")).forEach(System.out::println);
		
		
		List<Student> stuList = new ArrayList<Student>();
		stuList.add(new Student("홍길동",70));
		stuList.add(new Student("송혜교",75));
		stuList.add(new Student("김지원",88));
		stuList.add(new Student("정우성",92));
		stuList.add(new Student("송중기",93));
		
		
		//송으로 시작하는 학생
		for(Student stu : stuList) {
			if(stu.getName().startsWith("송")) {
				System.out.println(stu.getName());
			}
		}
		//stuList.stream().filter(n -> n.getName().startsWith("송")).forEach(s -> System.out.println(s));
		stuList.stream().map(n -> n.getName()).filter(s -> s.startsWith("송")).forEach(s->System.out.println(s));
		
		//점수를 모아서 80점 이상이 점수만 출력
		stuList.stream().map(n -> n.getJumsu()).filter(s -> s >= 80).forEach(s->System.out.println(s));
	}

}
