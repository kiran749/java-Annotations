package AnnotationQ2;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface info
{
	int AuthorID() default 1;
	int version();
	String Author();
	String Supervisior();
	String date();
	String time();
	
}
@info(AuthorID = 007,
      Author = "James bond",
      Supervisior = "Detactive",
      date = "07/02/2022",
      time = "8:00",version = 2)
public class annotationQ2 {
	
	@info(AuthorID = 2,Author = "Hulk",Supervisior = "radiation",date = "07/02/2022",time = "9:00",version = 3)
	private String str;
	
//	@info(AuthorID = 3,Author = "Spiderman",Supervisior = "lab",date = "07/02/2022",time = "9:00",version = 3)
//     private int I;
	
	@info(AuthorID = 4,Author = "THOR",Supervisior = "Asgaurd",date = "07/02/2022",time = "9:00",version = 4)
	public void print()
	{
		System.out.println();
	}
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException 
	{
		annotationQ2 a1=new annotationQ2();
//		a1.s="Ammy";
//		a1.k=0006;
//		a1.print();
		Class c=a1.getClass();
		info if1=(info) c.getAnnotation(info.class);
		System.out.println("Annotation using on class-----------------");
		System.out.println("ID "+if1.AuthorID());
		System.out.println("Author: "+if1.Author());
		System.out.println("Supervisior: "+if1.Supervisior());
		System.out.println("date: "+if1.date());
		System.out.println("time: "+if1.time());
		System.out.println("version "+if1.version());
		System.out.println("Annotation using on field------------------");
		Field f=c.getDeclaredField("str");
		info if2=f.getAnnotation(info.class);
		System.out.println("ID "+if2.AuthorID());
		System.out.println("Author: "+if2.Author());
		System.out.println("Supervisor: "+if2.Supervisior());
		System.out.println("Date: "+if2.date());
		System.out.println("time: "+if2.time());
		System.out.println("version: "+if2.version());
		System.out.println( "Annotation using on method-----------------");
		Method m=c.getMethod("print");
		info i2=m.getAnnotation(info.class);
		System.out.println("ID "+i2.AuthorID());
		System.out.println("Author "+i2.Author());
		System.out.println("Supervisor "+i2.Supervisior());
		System.out.println("date: "+i2.date());
		System.out.println("time: "+i2.time());
		System.out.println("version: "+i2.version());
		
		
		

	}

}