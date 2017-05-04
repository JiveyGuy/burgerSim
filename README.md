# burgerSim
COSC2336 - Lab 5

1 - Design an interactive simulation for a hamburger stand:
   * There are 1 thru N serving lines (10 maximum)
   * Customers arrive at the rate of 0 to M customers per minute and goes to the shortest queue
   * Customers wait until they are serviced (take X minutes median time)
   * Simulate to T hours
2 - Read from command line the values N and M and and X and T - Prompt if missing and after the 1st pass
3 - Run the simulation using the Java random number generator to generate customers and their order processing time
   * Use Normal / Gaussian distribution for service time, centered on X
4 - Keep track of:
   * Average queue length
   * Average customer wait time to be served
   * Maximum queue length
   * Maximum customer wait time
   * How often the queue is empty
   * How often a customer is served AFTER a customer that came after him
5 - At the end of each simulation, display statistic for the run
6 - Loop (step 2-6) simulating until user asks to stop

Hints: 
- Create a small ADT called Customer - Each instance should keep trach of: arrival time, departure time, ...
- Use book provided ADT when needed
- Create your own queue ADT - Do not use built-in
- Use either time-driven or event-driven simulation
- Run the simulation with 3 times with different input such:
 * One simulation shows a store with sometimes empty queue (Off-peak time)
 * One simulation shows a arrival rate about the same as departure rate (Desired maximum efficiency)
 * One simulation shows a gradual lengthling of the queue (Peak time)

Turn in a report & your .java code
- Professional looking report
- Describe the simulation you have done in details, explaining all the choices you selected
- Provide introduction, data, graphs, explaination, summary, credits
