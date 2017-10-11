package calculator;

import java.util.Stack;

public class compute {
	
	//把计算两个数
	public String calculate(String a,String b,String symbol)
	{
		String result="";
		switch(symbol){
		case "+":result=add(a,b);break;
		case "-":result=substract(a,b);break;
		case "×":result=multiply(a,b);break;
		case "÷":result=divide(a,b);break;
		default:break;
		}
		return result;
	}
//化简分数
	public static String simplify(int[] fraction){
		
		if(fraction[0]==0){return "0";}
		if(fraction[0]%fraction[1]==0){return String.valueOf(fraction[0]/fraction[1]);}
		int gcd=gcd(fraction[0],fraction[1]);
		fraction[0]/=gcd;
		fraction[1]/=gcd;
		if(fraction[1]<0)
		{
			fraction[0]*=-1;
			fraction[1]*=-1;
		}
		return fraction[0]+"/"+fraction[1];
	}	
//求最大公约数
	public static int gcd(int a,int b){        
           if( b==0)  return a;      
           else return gcd(b,a%b);            
   }  
//把分数从String形式转换为int数组形式
	public static int [] strToarr(String x){
		int [] fraction=new int[2];
		if(x.contains("/")){
			String strings[]=x.split("/");
			fraction[0]=Integer.valueOf(strings[0]);
			fraction[1]=Integer.valueOf(strings[1]);
		}
		else{
			int intofx=Integer.valueOf(x);
			fraction[0]=intofx;
			fraction[1]=1;
		}
		return fraction;
	}
	//计算加法
	public static String add(String a,String b){
		//System.out.println(a+"|"+b);
		if((a.contains("/")==false)&&(b.contains("/")==false)){
			int intofa=Integer.valueOf(a);
			int intofb=Integer.valueOf(b);
			return String.valueOf(intofa+intofb);
		}
		else if((a.contains("/")==true)&&(b.contains("/")==false))
		{
			int []result = new int[2];
			int []fractionofa=strToarr(a);
			int intofb=Integer.valueOf(b);
			//分母化同并实现运算
			result[0]=fractionofa[0]+fractionofa[1]*intofb;
			result[1]=fractionofa[1];
			return simplify(result);			
		}
		else if((a.contains("/")==false)&&(b.contains("/")==true))
		{
			int []result = new int[2];
			int intofa=Integer.valueOf(a);
			int []fractionofb=strToarr(b);
			//分母化同并实现运算
			result[0]=intofa*fractionofb[1]+fractionofb[0];
			result[1]=fractionofb[1];
			return simplify(result);
		}
		else{
			int []result =new int[2];
			int []fractionofa=strToarr(a);
			int []fractionofb=strToarr(b);
			//分母化同并实现运算
			result[0]=fractionofa[0]*fractionofb[1]+fractionofa[1]*fractionofb[0];
			result[1]=fractionofa[1]*fractionofb[1];
			return simplify(result);
		}
	}	
	//计算减法
	public static String substract(String a,String b){
		
		if((a.contains("/")==false)&&(b.contains("/")==false)){
			int intofa=Integer.valueOf(a);
			int intofb=Integer.valueOf(b);
			return String.valueOf(intofa-intofb);
		}
		else if((a.contains("/")==true)&&(b.contains("/")==false))
		{
			int []result = new int[2];
			int []fractionofa=strToarr(a);
			int intofb=Integer.valueOf(b);
			//分母化同并实现运算
			result[0]=fractionofa[0]-fractionofa[1]*intofb;
			result[1]=fractionofa[1];
			return simplify(result);			
		}
		else if((a.contains("/")==false)&&(b.contains("/")==true))
		{
			int []result = new int[2];
			int intofa=Integer.valueOf(a);
			int []fractionofb=strToarr(b);
			//分母化同并实现运算
			result[0]=intofa*fractionofb[1]-fractionofb[0];
			result[1]=fractionofb[1];
			return simplify(result);
		}
		else{
			int []result = new int[2];
			int []fractionofa=strToarr(a);
			int []fractionofb=strToarr(b);
			//分母化同并实现运算
			result[0]=fractionofa[0]*fractionofb[1]-fractionofa[1]*fractionofb[0];
			result[1]=fractionofa[1]*fractionofb[1];
			return simplify(result);
		}
	}	
	//计算乘法
	public static String multiply(String a,String b){
		//System.out.println(a+"×"+b);
		if((a.contains("/")==false)&&(b.contains("/")==false)){
			int intofa=Integer.valueOf(a);
			int intofb=Integer.valueOf(b);
			return String.valueOf(intofa*intofb);
		}
		else if((a.contains("/")==true)&&(b.contains("/")==false))
		{
			int []result = new int[2];
			int []fractionofa=strToarr(a);
			int intofb=Integer.valueOf(b);
			//分母化同并实现运算
			result[0]=fractionofa[0]*intofb;
			result[1]=fractionofa[1];
			return simplify(result);			
		}
		else if((a.contains("/")==false)&&(b.contains("/")==true))
		{
			int []result = new int[2];
			int intofa=Integer.valueOf(a);
			int []fractionofb=strToarr(b);
			//分母化同并实现运算
			result[0]=intofa*fractionofb[0];
			result[1]=fractionofb[1];
			return simplify(result);
		}
		else{
			int []result = new int[2];
			int []fractionofa=strToarr(a);
			int []fractionofb=strToarr(b);
			//分母化同并实现运算
			result[0]=fractionofa[0]*fractionofb[0];
			result[1]=fractionofa[1]*fractionofb[1];
			return simplify(result);
		}
	}
	//计算除法
	public static String divide(String a,String b){
		
		if((a.contains("/")==false)&&(b.contains("/")==false)){
			int []intofresult=new int[2];
			intofresult[0]=Integer.valueOf(a);
			intofresult[1]=Integer.valueOf(b);
			return simplify(intofresult);
		}
		else if((a.contains("/")==true)&&(b.contains("/")==false))
		{
			int []result = new int[2];
			int []fractionofa=strToarr(a);
			int intofb=Integer.valueOf(b);
			//分母化同并实现运算
			result[0]=fractionofa[0];
			result[1]=fractionofa[1]*intofb;
			return simplify(result);			
		}
		else if((a.contains("/")==false)&&(b.contains("/")==true))
		{
			int []result = new int[2];
			int intofa=Integer.valueOf(a);
			int []fractionofb=strToarr(b);
			//分母化同并实现运算
			result[0]=intofa*fractionofb[1];
			result[1]=fractionofb[0];
			return simplify(result);
		}
		else{
			int []result = new int[2];
			int []fractionofa=strToarr(a);
			int []fractionofb=strToarr(b);
			//分母化同并实现运算
			result[0]=fractionofa[0]*fractionofb[1];
			result[1]=fractionofa[1]*fractionofb[0];
			return simplify(result);
		}
	}
}
