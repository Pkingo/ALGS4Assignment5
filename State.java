class State {
  /*
  * State class to keep tract of name, seats, population and priority of a single state.
  */

  int population;
  String stateName;
  int seats;
  double priority;

  public State(String _stateName, int _population) {
    // sets state name and population,
    population = _population;
    stateName = _stateName;
    // State always starts with 0 seats
    seats = 0;
    // calcates the base priority value
    calculatePriorityValue();
  }

  // Getter for priority value
  public double getPriorityValue() {
    return priority;
  }

  // increaser for seats. Firstly it increases the number of seats by one
  // and then it recalculates the priority value
  public void increaseSeats() {
    seats++;
    calculatePriorityValue();
  }

  // Calculates the priority value based on the Huntington Hill method.
  private void calculatePriorityValue() {
    priority = population/(Math.sqrt(seats * (seats + 1)));
  }

  // Returns a right formatted string to solve the exericse.
  public String toString() {
    return stateName + " " + seats;
  }
}
