import edu.princeton.cs.algs4.*;

class Congress {
  public static void main(String[] args) {
    // Reads the first line from the data file, which is  the number of states.
    int numberOfStates = Integer.parseInt(StdIn.readLine());
    // Reads the second line from the data file, which is  is the number of seats.
    int numberOfSeats = Integer.parseInt(StdIn.readLine());
    // Initilizes a max priority queue, with the length numberOfStates
    MaxPQ pq = new MaxPQ(numberOfStates);
    //Populates the PQ with the states and how many voters they have.
    for (int i = 0; i < numberOfStates; i++)
      pq.insert(new State(StdIn.readLine(), Integer.parseInt(StdIn.readLine())));
    // While loop for each state
    while (numberOfSeats > 0) {
      // first it increase the number of seats the first state in the PQ has by one,
      pq.max().increaseSeats();
      // Then it sinkes that state to restore heap order in the PQ
      pq.sink(1);
      // Decrease the number of states so that we break it loop at some point
      numberOfSeats--;
    }
    for (int i = 0; i < numberOfStates; i++) {
      // Prints out the states and how many seats they got.
      StdOut.println(pq.get(i).toString());
    }
  }
}
