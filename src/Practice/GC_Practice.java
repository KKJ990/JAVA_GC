
package Practice;

public class GC_Practice {
	
	private String name;
	
	
	public GC_Practice(String name) {
		
		this.name=name;
		
		System.out.println(name + "객체가 생성 되었습니다");
		
	}
	
	///(소멸자) 가비지 컬렉션이 호출되고 Mark and Sweep 할때 수행됨
	
	public void finalize() {
		
		System.out.println(name+"객체가 가비지 컬렉션에 의해 해제 되었습니다");
		
		
	}
	public static void main(String[] args) {
		///1.Eden 영역에 저장
		GC_Practice GC1 = new GC_Practice("GC1");
		
		///1.Eden 영역에 저장
		GC_Practice GC2 = new GC_Practice("GC2");
		
		
		
		///2.Eden 영역 꽉참 GC_Practice GC1 = new GC_Practice("GC1");<Unreachable>를 버림 
		///Reachable 객체는 survivor0 영역으로 이동 , age증가  그후로 Eden되면 Mark sweap은 Eden 뿐아니라 survivor에도 일어남 
		GC1=null;
		
		/// 가비지 컬렉션 동작
		System.gc();
		
		
		///2.Eden 영역 꽉참 GC_Practice GC1 = new GC_Practice("GC1");<Unreachable>를 버림 
		///Reachable 객체는 survivor0 영역으로 이동 , age증가  그후로 Eden되면 Mark sweap은 Eden 뿐아니라 survivor에도 일어남 
		
		GC2=null;
		
		///가비지 컬렉션 동작
		Runtime.getRuntime().gc();
		
		
		//객체 사용이 끝난 후에는 해당 객체에 대한 참조를 null로 설정하여 GC가 불필요한 객체를 식별하고 정리할 수 있도록 해야 한다.
	}
	
	
	
	
	

}
