import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class OptimizeCompare {
	public static void main(String[] args) {
		List<Range> list = new ArrayList<Range>();
		list.add(new Range(1,5));
		list.add(new Range(7,9));
		list.add(new Range(2,4));
		list.add(new Range(8,10));
		
		Collections.sort(list, new RangeComparator());
		
		System.out.println("Input List");
		
		list.forEach(System.out::println);
		
		List<Range> newList = mergeRanges(list);
		
		System.out.println("Output List");
		newList.forEach(System.out::println);
	}
	
	public static List<Range> mergeRanges(List<Range> list){
		if(list.size() == 0 || list.size()==1){
			return list;
		} else{
			Range first = list.get(0);
	        int start = first.getStart();
	        int end = first.getEnd();
	        
	        List<Range> result = new ArrayList<Range>();
	        
	        for(int i = 1; i < list.size(); i++){
	            Range range = list.get(i);
	            if(range.getStart() <= end){
	                end = Math.max(range.getEnd(), end);
	            }else{
	                result.add(new Range(start, end));
	                start = range.getStart();
	                end = range.getEnd();
	            }
	            
	        }
	        
	        result.add(new Range(start, end));
			return result;
		}
	}
}