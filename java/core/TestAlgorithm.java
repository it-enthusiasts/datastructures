package core;

import java.util.List;
import java.util.PriorityQueue;

public class TestAlgorithm {
	public List<Integer> findTopK(List<Integer> input, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		input.forEach(number-> {
			pq.add(number);
			if(pq.size()>k) pq.poll();
		});
	}
	List<Integer> result= new ArrayList<>(pq);
	return Collections.reverse(result);
}
