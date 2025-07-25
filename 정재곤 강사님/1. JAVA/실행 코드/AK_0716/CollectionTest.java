package basic.AK_0716;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.ArrayList;
import java.util.HashMap;

public class CollectionTest{
	public static void main(String[] args) {

		/* Collection API 그릴 수 있으면 좋음
		 * List, Map, Set, Iterator 배열특징 크기가 고정되어있다 동일한 자료형만 저장가능하다 인덱스를 사용해서 접근한다
		 */
		List list = new ArrayList(); // List = inerface, ArrayList = class
		// List는 동적 배열, index로 참조한다. 0번째, 1번째

		list.add(33);
		list.add("Hello");
		list.add(new Employee());

		list.size(); // 전체갯수
		String str = (String) list.get(1);
		
		List<String> list2 = new ArrayList<String>(); //String타입만 다루게 된다.  제너릭 설정	
		//list2.add(11);
		list2.add("Hello");
		String str2 = list2.get(0);
		
		//Map name & value로 관리 컨테이너, 뭔가 담아두는 것
		@SuppressWarnings("unused")
		Map<String, Object> map = new HashMap<String, Object>(); // map = stack영역에 64bit로 할당받은 변수 // Map의 주소값
		map.put("name", "Junghun");
		map.put("pw", "12345");
		String name = (String)map.get("name");
		map.put("list", list2);	 //벨류값을 Object으로 넣을때 장점
		
		//set : 수학의 set : 중복되지 않은 요소를 가지고 있는 콜렉션
		Set<String> keySet = map.keySet();  //keySet은 Map안에 있다. 31번줄에 선언되있다. 실제 실행되는 건 new HashMap<String, Object>()부분이다.
		//keySet() 실행 > map이 저장되어 있는 객체속에 있는 keySet이 실행됌

	}

}
