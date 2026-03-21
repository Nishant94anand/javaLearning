package nishant.gfg.java.oop.abstractclass;

import nishant.gfg.java.oop.abstractclass.OuterAbstractClass.InnerAbstractClass;

//import nishant.gfg.java.oop.abstractclass.OuterAbstractClass.InnerAbstractClass;

// Abstract classes
abstract class OuterAbstractClass {
	String outerAbstractClassID;
	
	// Constructor
	public OuterAbstractClass(String id) {
		System.out.println("==> Into OuterAbstractClass Constructor with ID: " + id);
		this.outerAbstractClassID = id;
	}
	
	// Concrete Method
	public void printAbstractID() {
		System.out.println("outerAbstractClassID: " + outerAbstractClassID);
	}
	
	abstract class InnerAbstractClass {
		String innerAbstractClassID;
		
		// Constructor
		public InnerAbstractClass(String innerAbstractID, String outerAbstractID) {
			System.out.println("==> Into OuterAbstractClass Constructor with innerAbstractID: " + innerAbstractID + " | outerAbstractID: " + outerAbstractID);
			this.innerAbstractClassID = innerAbstractID;
			outerAbstractClassID = outerAbstractID;
		}
		
		abstract void printInnerAndOuterIDs();
		
		// Concrete Method
		public void printAbstractID() {
			System.out.println("outerAbstractClassID: " + outerAbstractClassID);
			System.out.println("innerAbstractClassID: " + innerAbstractClassID);
		}
	}
}

// Abstract classes 
class OuterRegularClass extends OuterAbstractClass {
	String outerRegularClassID;

	public OuterRegularClass(String absId, String regularId) {
		super(absId);
		System.out.println("==> Into OuterRegularClass Constructor with ID: " + absId + " | regularId: " + regularId);
		this.outerRegularClassID = regularId;
	}
	
	public void printRegularClassId() {
		System.out.println("regularClassId: " + outerRegularClassID);
	}
	
	class InnerRegularClass extends InnerAbstractClass {
		String innerRegularClassID;

		public InnerRegularClass(String innerAbstractID, String outerAbstractID, String innerRegularId, String outerRegularId) {
			super(innerAbstractID, outerAbstractID);
			System.out.println("==> Into OuterRegularClass Constructor with innerAbstractID: " + innerAbstractID + 
					" | outerAbstractID: " + outerAbstractID + " | innerRegularId: "+ innerRegularId + " | outerRegularId" + outerRegularId);
			this.innerRegularClassID = innerRegularId;
			outerRegularClassID = outerRegularId;			
		}

		@Override
		void printInnerAndOuterIDs() {
			System.out.println("outerAbstractClassID: " + outerAbstractClassID);
			System.out.println("innerAbstractClassID: " + innerAbstractClassID);
			System.out.println("outerRegularClassID: " + outerRegularClassID);
			System.out.println("innerRegularClassID: " + innerRegularClassID);
		}		
	}
}

//class NormalClassExtendingInner extends OuterAbstractClass.InnerAbstractClass {
//	String normalClassId;
//	
//	public NormalClassExtendingInner(String normalClassId, String innerAbstractID, String outerAbstractID)
//	{
//		super(innerAbstractID, outerAbstractID);
//		
//	}
//
//	public NormalClassExtendingInner(OuterAbstractClass outerAbstractClass, String innerAbstractID,
//			String outerAbstractID) {
//		outerAbstractClass.super(innerAbstractID, outerAbstractID);
//	}
//
//	@Override
//	void printInnerAndOuterIDs() {
////		System.out.println("outerAbstractClassID: " + this.outerAbstractClassID);
//		System.out.println("innerAbstractClassID: " + this.innerAbstractClassID);
//		super.printInnerAndOuterIDs();
//		System.out.println("outerRegularClassID: " + outerRegularClassID);
//		System.out.println("innerRegularClassID: " + innerRegularClassID);
//		
//	}
//	
//}

public class InnerClassAbstraction {

	public static void main(String[] args) {
		String outerRegularClassID = "OuterRegularClassID";
		String innerRegularClassID = "InnerRegularClassID";
		String outerAbstractClassID = "OuterAbstractClassID";
		String innerAbstractClassID = "InnerAbstractClassID";
		
		// OuterRegularClass
		System.out.println("\n==> Outer Abstract");
		OuterAbstractClass outerAbs = new OuterRegularClass(outerAbstractClassID, outerRegularClassID);
		outerAbs.printAbstractID();
		System.out.println("\n==> Outer Regular");
		OuterRegularClass outerReg = new OuterRegularClass(outerAbstractClassID, outerRegularClassID);
		outerReg.printAbstractID();
		
		// InnerRegularClass
		System.out.println("\n==> Inner Abstract");
		InnerAbstractClass innerAbstract = outerReg.new InnerRegularClass(innerAbstractClassID, outerAbstractClassID, innerRegularClassID, outerRegularClassID);
		innerAbstract.printInnerAndOuterIDs();
		System.out.println("\n==> Inner Regular");
		OuterRegularClass.InnerRegularClass innerRegular = outerReg.new InnerRegularClass(innerAbstractClassID, outerAbstractClassID, innerRegularClassID, outerRegularClassID);
		innerRegular.printInnerAndOuterIDs();

	}

}
