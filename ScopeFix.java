public class ScopeFix {
	public static void main(String[] args) {
		byte i, j;
		for(i=0; i<10; i+=1) {
			j=i;
			System.out.println(j);
		}
	}
}

