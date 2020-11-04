//210. Course Schedule II
/*
There are a total of n courses you have to take labelled from 0 to n - 1.
Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.
Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.
*/
package practice.custom.ds;

import java.util.ArrayList;
import java.util.List;

public class GraphCourseSchedule {

	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int[] result = findOrder(numCourses, prerequisites);
		for (int num : result) {
			System.out.print(num + " ");
		}
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		Graph graph = new Graph(numCourses);
		for (int i = 0; i < prerequisites.length; i++) {
			int source = prerequisites[i][1];
			int target = prerequisites[i][0];
			graph.addEdge(source, target);
		}
		boolean recStack[] = new boolean[numCourses];
		boolean visited[] = new boolean[numCourses];
		List<Integer> resultLst = new ArrayList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (graph.isCyclic(i, recStack, visited, resultLst)) {
				return new int[0];
			}
		}
		int result[] = new int[resultLst.size()];
		for (int i = 0; i < resultLst.size(); i++) {
			result[i] = resultLst.get(i);
		}
		return result;
	}

}

class Graph {
	int numberOfNode;
	List<List<Integer>> edges;

	public Graph(int numberOfNode) {
		this.numberOfNode = numberOfNode;
		edges = new ArrayList<List<Integer>>();
		for (int i = 0; i < numberOfNode; i++) {
			edges.add(new ArrayList<Integer>());
		}
	}

	public void addEdge(int source, int target) {
		edges.get(source).add(target);
	}

	public boolean isCyclic(int node, boolean[] recStack, boolean[] visited, List<Integer> result) {
		if (recStack[node])
			return true;
		if (visited[node])
			return false;
		visited[node] = true;
		recStack[node] = true;
		
		for(int nextNode:edges.get(node))
		{
			if (isCyclic(nextNode, recStack, visited, result)) {
				return true;
			}
			if(!result.contains(nextNode))
			{
				result.add(0,nextNode);
			}
		}
		if(!result.contains(node))
		{
			result.add(0,node);
		}
		recStack[node] = false;
		return false;
	}
}
