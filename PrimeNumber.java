public class PrimeNumber {

	public static void main(String[] args) {
		
		int count=0;
		int num=27;
		
	for(int i=1;i<=num;i++){
		if(num%i==0) {
			count++;
		}
		}
		if(count==2) {
			System.out.println("prime no.");
		}else {
			System.out.println("not a prime no.");
		}

	}

}
