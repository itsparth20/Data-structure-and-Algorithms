
import java.io.FileNotFoundException;
import java.io.IOException;

public class ComputePath {
	Map cityMap;

	public ComputePath(String fileName) throws InvalidMapException, FileNotFoundException, IOException {
		cityMap = new Map(fileName);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		try {

			if (args.length < 1)
				throw new IllegalArgumentException("Provide the name of the file with the input map");
			String mapFileName = args[0];
			ComputePath computePathObj = new ComputePath(mapFileName);
			
			MyStack stack = new MyStack();
			MapCell start = computePathObj.cityMap.getStart();
			stack.push(start);
			
			while(!stack.isEmpty()) {
				MapCell tempDesk = (MapCell) stack.peek();				
				if(tempDesk.isCustomer()) break;
				if(computePathObj.interference(tempDesk)) {
					tempDesk.markOutStack();
					stack.pop();						
					continue;
				}
				MapCell neighbourCell = computePathObj.nextCell(tempDesk);
				if(neighbourCell != null) {
					stack.push(neighbourCell);
					neighbourCell.markInStack();
				}else {
					stack.pop();
					tempDesk.markOutStack();
				}								
			}
			
			if(stack.isEmpty()) {
				System.out.println("Path does not exist");
			}else {
				System.out.println("Path exist");
				System.out.println(String.format("Total %d number of cell in path from the initial cell to the destination cell.", stack.size()));
			}

		} catch (InvalidMapException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//check that does neighbor cell is tower or not
	private boolean interference(MapCell cell) {
		for (int i = 0; i < 6; i++) {
			if (cell.getNeighbour(i) != null && cell.getNeighbour(i).isTower())
				return true;
		}
		return false;
	}

	//return next cell to visit
	private MapCell nextCell(MapCell cell) {
		try {
			for (int i = 0; i < 6; i++) {
				MapCell neighbour = cell.getNeighbour(i);
				if (neighbour != null && ( neighbour.isCustomer() || (!neighbour.isMarked() && neighbour.isFree() ) ) )
					return neighbour;
			}
			for (int i = 0; i < 6; i++) {
				MapCell neighbour = cell.getNeighbour(i);
				if (neighbour != null && ( neighbour.isCustomer() || (!neighbour.isMarked() && neighbour.isHighAltitude() ) ) )
					return neighbour;
			}
			for (int i = 0; i < 6; i++) {
				MapCell neighbour = cell.getNeighbour(i);
				if (neighbour != null && ( neighbour.isCustomer() || (!neighbour.isMarked() && neighbour.isThief() ) ) )
					return neighbour;
			}
		} catch (Exception e) {
			System.out.println("NextCell method having an issue ");
			e.printStackTrace();
		}
		return null;
	}
}
