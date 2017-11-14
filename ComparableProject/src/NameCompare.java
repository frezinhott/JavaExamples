import java.util.*;
public class NameCompare implements Comparator<Object>{
	public int compare(Object o1, Object o2) {
		return ((Student)o1).firstName.compareTo(((Student)o2).firstName);
	}

}
