package calculator;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class calculator {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a,b,c,d;
		String op1,op2,op3;
		String result;
		String input;
		int score=0;
		System.out.print("请输入题目个数:");
		int x=new Scanner(System.in).nextInt();
		int per=100/x;
		for(int i=0;i<x;i++)
		{
			a=generateNum();
			b=generateNum();
			c=generateNum();
			d=generateNum();
			op1=generateOperater();
			op2=generateOperater();
			op3=generateOperater();
			input=a+op1+b+op2+c+op3+d;
			System.out.printf(i+1+". "+input+"=");
			//System.out.println(input);
			transform trans=new transform(input);
			result=trans.postToresult();
			//System.out.println("正确答案为:"+result);
		    String y=new Scanner(System.in).next();
		    if(y.equals(result)==true)
		    {
		    	System.out.println("正确！");
		    	score+=per;
		    }
		    else{
		    	System.out.println("不正确！正确答案="+result);
		    }	
		}	
		System.out.println("本次共"+x+"题，满分100分");   
		System.out.println("本次得分："+score);  
	}
//生成真分数
	public static int[] generateFraction()
	{
		int [] fraction=new int[2];
		int temp=0;
		int x,y;
		x=new Random().nextInt(99)+1;
		y=new Random().nextInt(99)+1;
		while(x==y)
		{
			y=new Random().nextInt(99)+1;
		};
		if(x>y)
		{
			temp=x;
			x=y;
			y=temp;
		}
		fraction[0]=x;
		fraction[1]=y;
		return fraction;
	}
//生成操作符
	public static String generateOperater()
	{
		String[] Operater={"+","-","×","÷"};
		int x=new Random().nextInt(4);
		String Op=Operater[x];
		return Op;
	}
//生成数
//生成整数或随机数本身也是随机的
	public static String generateNum()
	{
		int x=new Random().nextInt(2);
		if(x==0)
		{
			int y=new Random().nextInt(100);
			return String.valueOf(y);
		}
		else {
			int []y=generateFraction();
			return String.valueOf(y[0])+"/"+String.valueOf(y[1]);
		}
	}
}
