import java.util.PriorityQueue;

/**
 * @author Siddhant Sharma
 * @date 03-Apr-2021 @time 5:02:41 pm
 */
public class MinNoRefuelingStopsSol1 {

	public static void main(String[] args) {
		MinNoRefuelingStopsSol1 obj = new MinNoRefuelingStopsSol1();
		int target = 100, startFuel = 10;
		int[][] station = {{10,60},{30,30},{20,30},{60,40}};
//		int[][] station = {{25,25},{50,25},{75,25}};
		System.out.println(obj.minRefuelStops(target, startFuel, station));
	}
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		// the position we can achieve without any fuel
        int curr = startFuel;
		// total number of times need to refill the fuel 
        int res = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int index = 0;
		// The will not stop until we achieve the target
        while(curr < target) {
            while(index < stations.length && stations[index][0] <= curr) {
                queue.offer(stations[index]);
                index++;
            }
            if(!queue.isEmpty()) {
                int[] station = queue.poll();
                res++;
                curr += station[1];
            }else {
                res = -1;
                break;
            }
        }
        return res;
    }

}
