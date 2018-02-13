
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Marqeta {

	static Queue<Model> queue = new ConcurrentLinkedQueue<Model>();

	public static void main(String[] args) throws IOException {
		Thread t1 = new Thread(new CreationOfModelObject(), "creation");
		Thread t2 = new Thread(new ProcessTransation(), "processing1");
		t1.start();
		t2.start();
//		ExecutorService executor = Executors.newFixedThreadPool(2);
//		executor.execute(t1);
//		executor.execute(t2);

	}

	static class ProcessTransation implements Runnable {

		@Override
		public void run() {
			while (true) {
				try {
					Model obj;
					synchronized (queue) {
						if (queue.peek() == null) {
							try {
								queue.wait(3000l);
								if (queue.peek() == null)
									return;
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					obj = queue.poll();
					if (obj != null) {
						Response response = TransactionProcessor.process(obj);
						System.out.println(obj.getTransactionCode());
					}
				} catch (Exception e) {
					System.out.println("Exception During Processing Transation " + e);
				}
			}
		}

	}

	static class CreationOfModelObject implements Runnable {

		@Override
		public void run() {
			String path = "C:/Users/itspa/workspace/FreelancerWorkSpace/work/rawData.txt";
			File inputFile = new File(path);
			try (InputStream inputStream = new FileInputStream(inputFile);
					BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));) {

				String line;
				Model obj = null;
				while ((line = br.readLine()) != null) {
					try {
						String[] arr = Parser.parse(line);
						if (arr[0].equals("06")) {
							if (obj != null) {
								synchronized (queue) {
									queue.add(obj);
									queue.notify();
								}
							}
							obj = new Model(arr[0].trim(), arr[1].trim(), arr[2].trim(), arr[3].trim(), arr[4].trim(),
									arr[5].trim(), arr[6].trim().equals("") ? null : new BigDecimal(arr[6].trim()));
						} else if (arr[0].equals("07")) {
							Model.SupplementryData supplementryData = new Model.SupplementryData(arr[0].trim(),
									arr[1].trim(), arr[2].trim(), arr[3].trim());
							obj.setSupplementryData(supplementryData);
						}
					} catch (Exception e) {
						System.out.print("Exception while processing model: " + e);
					}
				}
				if (obj != null) {
					synchronized (queue) {
						queue.add(obj);
						queue.notify();
					}
				}

			} catch (Exception e) {
				System.out.print("Exception: " + e);
			}

		}

	}

}

class Parser {
	public static String[] parse(String s) {
		if (s.substring(0, 2).equals("06")) {
			int i = 0;
			String[] arr = new String[7];
			arr[0] = s.substring(i, i + 2);
			i += 2;

			arr[1] = s.substring(i, i + 4);
			i += 4;

			arr[2] = s.substring(i, i + 19);
			i += 19;

			arr[3] = s.substring(i, i + 4);
			i += 4;

			arr[4] = s.substring(i, i + 15);
			i += 15;

			arr[5] = s.substring(i, i + 8);
			i += 8;

			arr[6] = s.substring(i, i + 12);
			i += 12;
			return arr;
		} else {
			int i = 0;
			String[] arr = new String[4];
			arr[0] = s.substring(i, i + 2);
			i += 2;

			arr[1] = s.substring(i, i + 4);
			i += 4;

			arr[2] = s.substring(i, i + 19);
			i += 19;

			arr[3] = s.substring(i, i + 39);
			i += 39;
			return arr;
		}

	}
}

class TransactionProcessor {
	public static Response process(Model obj) {
		// System.out.print("Hello");
		return new Response();
	}
}

class Response {

}
