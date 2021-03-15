package javaphase1;
import java.util.Scanner;

public class ArithCalculator {

	public static void main(String[] args) {
	Scanner kb=new Scanner(System.in);
	double num1,num2;
	boolean nextoper=true;
	char ch='\0';
		while(nextoper)
		{
			
		
System.out.println("ENTER FIRST NUMBER:\n");
num1=kb.nextDouble();
System.out.println("ENTER SECOND NUMBER:\n");
num2=kb.nextDouble();

System.out.println("ENTER AN OPERATOR(+,-,*,/)");
char oper=kb.next().charAt(0);
double out;
switch(oper)
{
case '+':
	out=num1+num2;
	break;
	
case '-':
	out=num1-num2;
	break;
	
case '/':
	out=num1/num2;
	break;
	
case '*':
	out=num1*num2;
	break;
	
	default:
		System.out.println("WRONG OPERATOR");
		return;
}
System.out.println(num1+" "+oper+" "+num2+": "+out);
  System.out.println("WANT TO CONTINUE");
  System.out.println("ENTER Y/N: :");
  ch=kb.next().charAt(0);
  if(Character.toUpperCase(ch)!='Y')
		  nextoper=false;
  System.out.println();
  
	}
	}

}
