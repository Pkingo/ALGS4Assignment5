import edu.princeton.cs.algs4.*;

class Congress {
  public static void main(String[] args) {
    int numberOfStates = Integer.parseInt(StdIn.readLine());
    int numberOfSeats = Integer.parseInt(StdIn.readLine());
    StdOut.println("Number of states: " + numberOfStates);
    StdOut.println("Number of seats: " + numberOfSeats);
    MaxPQ pq = new MaxPQ(numberOfStates);
    for (int i = 0; i < numberOfStates; i++)
      pq.insert(new State(StdIn.readLine(), Integer.parseInt(StdIn.readLine())));
    while (numberOfSeats > 0) {
      pq.max().increaseSeats();
      pq.sink(1);
      numberOfSeats--;
    }
    for (int i = 0; i < numberOfStates; i++) {

      StdOut.println(pq.get(i).toString());
    }
  }
}
