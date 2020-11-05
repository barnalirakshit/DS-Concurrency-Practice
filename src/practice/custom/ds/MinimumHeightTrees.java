package practice.custom.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumHeightTrees {

	public static void main(String[] args) {
		int n = 4, edges[][] = new int[][] { { 1, 0 }, { 1, 2 }, { 1, 3 } };
		List<Integer> result = findMinHeightTrees(n, edges);
		System.out.println("result:" + result);
	}

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1)
			return Collections.singletonList(0);
		List<List<Integer>> adj = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<>());
		for (int i = 0; i < edges.length; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}
		List<Integer> leaves = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			if (adj.get(i).size() == 1)
				leaves.add(i);
		}
		while (n > 2) {
			n = n - leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for (int leave : leaves) {
				int node = adj.get(leave).get(0);
				int index = adj.get(node).indexOf(leave);
				adj.get(node).remove(index);
				if (adj.get(node).size() == 1)
					newLeaves.add(node);
			}
			leaves = newLeaves;
		}
		return leaves;
	}

}
