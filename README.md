# CalculateRuntimeExercise
Java MultiThreading Exercises
Coding Exercise

Details
You are provided a randomized data set containing tasks, their runtimes and dependencies resembling the following:
https://Github.com/CalculateRuntimeExercise.pdf[/embed]

TaskID ,         Runtime (seconds)  ,  Dependency (Parent TaskID)

1      ,              12            ,             NONE

2      ,              2             ,             NONE

3      ,              8             ,             2

4      ,              7             ,             2

5      ,              11            ,             1

6      ,              3             ,             4

7      ,              4             ,             NONE



Instructions:
Given such a data set, please generate write a program that calculates the minimum runtime of the data set a) if the tasks are executed serially (single threaded application) and b) if the tasks can be executed in parallel (no limit on number of threads)
