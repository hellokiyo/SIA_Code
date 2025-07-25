package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class CollectionTest {

	public static void main(String[] args) {
		// List, Map, Set, Iterator
		List list = new ArrayList(); // List interface, new ArrayList() 클래스 (생성자 호출)
		// List는 동적 배열, index로 참조한다 0번째 1번째
		list.add(33);
		list.add("Hello");
		list.add(new Employee());

		list.size(); // 전체갯수
		String str = (String) list.get(1);

		List<String> list2 = new ArrayList<String>(); // String 타입만 다루게 된다
		// list2.add(11);
		list2.add("Hello");
		
		String str2 = list2.get(0);

		// Map name & value로 관리 컨테이너, 뭔가를 담아두는 것
		Map<String, Object> map = new HashMap<String, Object>(); // map : 64bit -> 객체의 주소값을 할당, Stack 영역에 생성된 변수
		map.put("name", "Heeman");
		map.put("pw", "12345");
		map.put("list", list2);
		
		String name =(String) map.get("name");
		
		// set : 수학의 set : 중복되지 않은 요소를 가지고 있는 콜렉션
		Set<String> keySet = map.keySet();
		
	}

}
