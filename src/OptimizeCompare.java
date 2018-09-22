import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


class OptimizeCompare {
	public static void main(String[] args) {
		System.out.println("Enter the number of range:");
		Scanner scanner=new Scanner(System.in);
		int size=scanner.nextInt();
		List<Range> list = new ArrayList<Range>();
		for (int i = 0; i < size; i++) {
			Scanner sc=new Scanner(System.in);
			Range range=new Range(sc.nextInt(), sc.nextInt());
			list.add(range);
			
		}
//		List<Range> list = new ArrayList<Range>();
//		list.add(new Range(94133,94133));
//		list.add(new Range(94200,94299));
//		list.add(new Range(94226,94399));
	
		Collections.sort(list, new RangeComparator());
		
		System.out.println("Input Range:");
		
		list.forEach(System.out::println);
		
		List<Range> newList = mergeRanges(list);
		
		System.out.println("Output Range:");
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