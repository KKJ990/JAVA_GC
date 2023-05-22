package Practice;

import java.util.ArrayList;
import java.util.List;

public class GC_Memoryleak {

	
    private static List<Object> list = new ArrayList<>();

    
    
    public static void main(String[] args) {
        while (true) {
        	//새로운 객체 생성
            Object object = new Object();
            
            //GC는 참조 되지 않은객체 Unerachable 를 지우는데 쓰임
            //List 삽입 (List는 어태껏 호출한 object 객체가 쌓여있음)
            //object의 누적값이 list에 계속 쌓이므로 GC에서는 object가 계속 참조 되고 있다고 인식
            //GC는 참조되지 않은 객체를 식별하지 못하므로 메모리 사용량은 증가할것
            list.add(object);
            //----------------------
            //object=null; 
            //System.gc();
             
            //-------------------- 이 두코드가 들어간다면 Memoryleak는 발생하지 않음
        }
        //JVM에서 기본적으로 GC를 제공하지만 무한루프(while(ture)나 반복적인 상황에서 객체를 해제하고 자원을 반납해주는 것이 중요하다 
    }
}

//------------- 예제 코드는 github을 참조-----------------------------
