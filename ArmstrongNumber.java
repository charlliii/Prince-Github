public class ArmstrongNumber {

	public static void main(String[] args) {
	
        int num=153;
        int sum=0;
        int temp=num;
        while(num!=0) {
        sum=sum+(num%10)*(num%10)*(num%10);
        num=num/10;
        }
        if(temp==sum) {
        System.out.println("armstrong number");
        }else {
        System.out.println("not a armstrong number");
        }
	}

}

