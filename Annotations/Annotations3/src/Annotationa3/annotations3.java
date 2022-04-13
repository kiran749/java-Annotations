package Annotationa3;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface excecute
{int sequence();
	}
public class annotations3 {
	private String s;
	@excecute(sequence = 3)
	public void method3()
	{
		System.out.println("METHOD 3 "+s );
		
	}
	@excecute(sequence = 2)
	public void method2()
	{
		System.out.println("METHOD 2 "+s);
		
	}
	@excecute(sequence = 1)
	public void method1()
	{
		System.out.println("METHOD 1 "+ s);
		
	}

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException 
	{
		annotations3 ass1=new annotations3();
		Class c=ass1.getClass();
		/*Method[] m=c.getMethods();
		for (Method method : m) 
		{
			System.out.println("METHOD NAME "+method.getName());
			
		}*/
		System.out.println("--------------------");
		Field f=c.getDeclaredField("s");
		f.setAccessible(true);
		f.set(ass1,"GKR");
		Method m1=c.getDeclaredMethod("method3");
		excecute ex=m1.getAnnotation(excecute.class);
		int seq=ex.sequence();
		Method m2=c.getDeclaredMethod("method2");
		excecute ex1=m2.getAnnotation(excecute.class);
		int seq1=ex1.sequence();
		
		Method m3=c.getDeclaredMethod("method1");
		excecute ex3=m3.getAnnotation(excecute.class);
		int seq3=ex3.sequence();
		
		if((seq>seq1) && (seq>seq3) &&(seq1>seq3))
		{
			m3.invoke(ass1);
			m2.invoke(ass1);
			m1.invoke(ass1);
			
		}
		else if(seq1>seq3 && seq1>seq && seq3>seq)
		{
			m2.invoke(ass1);
			m3.invoke(ass1);
			m1.invoke(ass1);
		}
		else
		{
			m1.invoke(ass1);
			m2.invoke(ass1);
			m3.invoke(ass1);
			
			
		}
		

	}

}