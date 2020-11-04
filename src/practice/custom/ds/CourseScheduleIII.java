package practice.custom.ds;
//Course Schedule III
import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {
	public static void main(String[] args) {
		int[][] courses = new int[][] {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
		int output = scheduleCourse(courses);
		System.out.println(output);
	}
	
	public static int scheduleCourse(int[][] courses) {
		Arrays.sort(courses, (a,b)->a[1]-b[1]);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->b-a);
		int time=0;
		for(int[] course:courses)
		{
			pq.offer(course[0]);
			time = time+course[0];
			if(time>course[1])
				time = time - pq.poll();
		}
		return pq.size();

	}

}
