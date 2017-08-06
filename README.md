# CalculateRuntimeExercise
Java MultiThreading Exercises
Coding Exercise
Instructions:
Please complete the following exercise in Java.  The goal of this exercise is to demonstrate your coding style, not simply your ability to select an appropriate algorithm.  The code you deliver should have the following characteristics:
Well structured
Readable
Efficient
Testable (positive and negative tests) 
Ready to compile and run
Details
You are provided a randomized data set containing tasks, their runtimes and dependencies resembling the following:
TaskID
Runtime (seconds)
Dependency (Parent TaskID)
1
12
NONE
2
2
NONE
3
8
2
4
7
2
5
11
1
6
3
4
7
4
NONE

Given such a data set, please generate write a program that calculates the minimum runtime of the data set a) if the tasks are executed serially (single threaded application) and b) if the tasks can be executed in parallel (no limit on number of threads)
