class State {
  int population;
  String stateName;
  int seats;
  double allocate;

  public State(String _stateName, int _population) {
    population = _population;
    stateName = _stateName;
    seats = 0;
    calculateAllocateValue();
  }

  public double getAllocateValue() {
    return allocate;
  }

  public void increaseSeats() {
    seats++;
    calculateAllocateValue();
  }

  private void calculateAllocateValue() {
    allocate = population/(Math.sqrt(seats * (seats + 1)));
  }

  public String toString() {
    return stateName + " " + seats;
  }
}
