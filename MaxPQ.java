public class MaxPQ {
  /*
  * This PQ class is loosely based on that from the book.
  * But some methods were removed, since they were not indeed it solve this exercise.
  */

  // Array of states
  private State[] pq;
  // Count
  private int n = 0;

  public MaxPQ(int maxN) {
    // Inits an array that is one bigger then N, Since heaps sorted arrays starts at 1 and not 0
    pq = new State[maxN + 1];
  }

  public void insert(State v) {
    // Inserts the new states and increases n
    pq[++n] = v;
    // Swims the new state up to restore heap order.
    swim(n);
  }

  // Returns the state with the highest priority based on the Huntington Hill method
  public State max() {
    return pq[1];
  }

  // compares two states based on the Huntington Hill method
  private boolean less(int i, int j) {
    return pq[i].getPriorityValue() < pq[j].getPriorityValue();
  }

  // getter for state at position i + 1
  public State get(int i) {
    return pq[++i];
  }

  // Switch the position of two states in the array
  private void exch(int i, int j) {
    State t  = pq[i];
    pq[i] = pq[j];
    pq[j] = t;
  }

  // Swim a state up until heap order is restored.
  private void swim(int k) {
    while (k > 1 && less(k/2, k)) {
      exch(k/2, 2);
      k = k/2;
    }
  }
  // Skin a state down until heap order is restored.
  public void sink(int k) {
    while (2*k <= n) {
      int j = 2*k;
      if (j < n && less(j, j+1)) j++;
      if (!less(k, j)) break;
      exch(k, j);
      k = j;
    }
  }
}
