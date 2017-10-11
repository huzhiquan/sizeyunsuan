package calculator;

import java.util.Stack;

public class transform {

	private static Stack<String> stack;
	private String input;
	//private String infix;//中缀表达式
	private String post;//后缀表达式
	//中缀表达式转化为后缀表达式
	public transform(String input) {
        this.input = input;
        this.stack=new Stack<>();
        //this.infix="";
       this.post="";
    }
	//生成合适的中缀表达式
	private String getInfix(String input) {
		 String infix = "";//中缀表达式
		 for(int i=0;i<input.length()-1;i++)
		 {
			//若i位置上的字符为数字,i+1上的为操作符,或i+1位置上的字符为数字,i上的为操作符
			 if(((isOperater(input.charAt(i))==false)&&(isOperater(input.charAt(i+1))==true))||((isOperater(input.charAt(i))==true)&&(isOperater(input.charAt(i+1))==false)))
			 {
				 infix+=input.charAt(i)+" ";
			 }
			 else{
				 infix+=input.charAt(i);
			 }
		 }
		 infix+=input.charAt(input.length()-1);
		 return infix;
	}
	//由中缀转换为后缀
	private String infixTopost()
	{
		String[] strArr=getInfix(input).split(" ");
		for (int i = 0; i < strArr.length; i++) {
			String x=strArr[i];
			switch(x){
			//当x为符号时，与当前栈顶的符号比优先级，若x的优先级≤栈顶元素，则将栈顶元素出栈，再将x入栈
			case "+":
			case "-":transfer(x,1);break;
			case "×":
			case "÷":transfer(x,2);break;
			//当x为数字时，直接加到post中
			default:post+=" "+x;break;
			}
		}
		while (stack.isEmpty()==false) {//将栈中最后一个元素出栈
            post += " " + stack.pop();
        }
		post=post.trim();//去掉第一个空格
		//System.out.println("后缀表达式："+post);
		return post;
	}
	//当x为符号时，与当前栈顶的符号比优先级，若x的优先级≤栈顶元素，则将栈顶元素出栈，再将x入栈
	private void transfer(String x,int priority)
	{
		while(stack.isEmpty()==false){
			String top=stack.pop();
			int priorityoftop=getpriority(top);
			if(priority>=priorityoftop)//当x的优先级>=栈顶元素优先级时
			{
				stack.push(top);
				break;
			}
			else{//当x的优先级<栈顶元素优先级时
				post+=" "+top;			
			}
		}
		stack.push(x);
	}
	//判断操作符的优先级
	private int getpriority(String top) {
		// TODO Auto-generated method stub
		if(top.equals("+")==true||top.equals("-")==true)
		{
			return 1;
		}
		else return 2;
	}
	//由后缀表达式得结果
	public String postToresult()
	{
		String[] strArr=infixTopost().split(" ");
		for(int i = 0; i < strArr.length; i++){
            String temp = strArr[i];
            if(isOperater(temp)==false){//是数字时，入栈
                stack.push(temp);
            }else{//是操作符时，将栈顶两个元素进行运算，结果入栈
                stack.push(compute1(temp));
            }
        }
		return stack.pop();
	}
    //四则运算
	private static String STACK_ERROR="THE STACK IS NULL!";
	private String compute1(String temp) {
		// TODO Auto-generated method stub
		compute com=new compute();
		String result = "";
		String a;
		String b;
		while(true){
			if(stack==null||stack.size()==0){return "栈为空a1";}
			String tempa=stack.pop();
			if(tempa.equals(STACK_ERROR)){return "栈为空a2";}
			if(!tempa.equals("")){a=tempa;break;}
		}
		while(true){
			if(stack==null||stack.size()==0){return "栈为空b1";}
			String tempb=stack.pop();
			if(tempb.equals(STACK_ERROR)){return "栈为空b2";}
			if(!tempb.equals("")){b=tempb;break;}
		}
		switch(temp)
		{
			case "+":
				result=com.calculate(b, a, "+");
				//System.out.println("test:"+b+"+"+a+"="+ result);
				break;
			case "-":
				result=com.calculate(b, a, "-");
				//System.out.println("test:"+b+"-"+a+"="+ result);
				break;
			case "×":
				result=com.calculate(b, a, "×");
				//System.out.println("test:"+b+"×"+a+"="+ result);
				break;
			case "÷":
				if(a.equals("0")){return "被除数为0";};
				result=com.calculate(b, a, "÷");
				//System.out.println("test:"+b+"÷"+a+"="+ result);
				break;
			default:break;
		}
		return result;		
	}

	//判断string是否为操作符
	private boolean isOperater(String temp) {
		// TODO Auto-generated method stub
		char[] chArr = temp.toCharArray();
		if((chArr.length==1)&&(chArr[0]=='+'||chArr[0]=='-'||chArr[0]=='×'||chArr[0]=='÷'))
		{
			return true;
		}
		else return false;
	}
	//判断char是否为操作符
		private boolean isOperater(char ch) {
			// TODO Auto-generated method stub
			if(ch=='+'||ch=='-'||ch=='×'||ch=='÷')
			{
				return true;
			}
			else return false;
		}

}
