package lambda;

public class StringConcatEx {
	public static void main(String[] args) {
//		StringConcat sc = new StingConcatImpl();
//			sc.makeString("Hello", "Interface");
		
		StringConcat sc = (s1, s2) -> System.out.println(s1+", "+s2);
		sc.makeString("hello", "world");

	}

}
