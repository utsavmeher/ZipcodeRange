import java.util.Comparator;

public class RangeComparator implements Comparator<Range>{

	@Override
	public int compare(Range o1, Range o2) {
		return o1.getStart()-o2.getStart();
	}

}
