import java.util.*;
import java.util.concurrent.*;

public class Stats {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		
		Map<String, List<Double>> map = new ConcurrentHashMap<>();
		
		@Override
		public void putNewPrice(String symbol, double price) {
			
			if( map.get(symbol) != null ) {
				List<Double> lst = map.get(symbol);
				lst.add(price);
				map.put(symbol, lst);
			}
			else {
				List<Double> lst = new ArrayList<>();
				lst.add(price);
				map.put(symbol, lst);
			}
			
		}

		@Override
		public double getAveragePrice(String symbol) {
		// YOUR CODE HERE
			List<Double> lst = map.get(symbol);
			int cntOfPrices = 0;
			double addOfPrice = 0;
			double avg = 0;
			for(double price : lst) {
				cntOfPrices++;
				addOfPrice = addOfPrice + price;
			}
			if(addOfPrice>0 && cntOfPrices>0)
				avg = addOfPrice/cntOfPrices;
			return avg;
		}

		@Override
		public int getTickCount(String symbol) {
		// YOUR CODE HERE
			List<Double> lst = map.get(symbol);
			return lst.size();
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(String.format("%s %.4f %d", symbol,
						stats.getAveragePrice(symbol),
						stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}