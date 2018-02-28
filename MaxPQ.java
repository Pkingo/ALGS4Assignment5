public class MaxPQ {
  private State[] pq;
  private int n = 0;

  public MaxPQ(int maxN) {
    pq = new State[maxN + 1];
  }

  public void insert(State v) {
    pq[++n] = v;
    swim(n);
  }

  public State max() {
    return pq[1];
  }

  private boolean less(int i, int j) {
    return pq[i].getAllocateValue() < pq[j].getAllocateValue();
  }

  public State get(int i) {
    return pq[++i];
  }

  private void exch(int i, int j) {
    State t  = pq[i];
    pq[i] = pq[j];
    pq[j] = t;
  }

  private void swim(int k) {
    while (k > 1 && less(k/2, k)) {
      exch(k/2, 2);
      k = k/2;
    }
  }

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
