package nishant.gfg.java.oop.abstractclass;

abstract class Level1 {
	abstract void print1();
	abstract void print2();
}

abstract class Level2 extends Level1 {
	@Override
	public void print1() {
		System.out.println("Printing 1 in Level 2");
	}
}

class Level3 extends Level2 {
//	@Override
//	public void print1() {
//		System.out.println("Printing 1 in Level 3");
//	}

	@Override
	public void print2() {
		System.out.println("Printint 2 in Level 3");		
	}
	
}

public class MultiLevelAbstractClasses {

	public static void main(String[] args) {
		System.out.println("==> Level1");
		Level1 l1 = new Level3();
		l1.print1();
		l1.print2();
		
		System.out.println("==> Level2");
		Level1 l2 = new Level3();
		l2.print1();
		l2.print2();
		
		System.out.println("==> Level3");
		Level1 l3 = new Level3();
		l3.print1();
		l3.print2();

	}

}
