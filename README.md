# Infection
This is the repo for the take-home project of Khan Academy.
## Dependency
The only deependency is the basic java dev environment.
## Total Infection
For total infection, I used two different methods, BFS and DFS, to infect all the users that is reachable from one particular user.
## Limited Infection
In contrary to total infection, limited infection tries to infect a group of users similar to a number specified. Starting from a paticular user, this method applies Breadth First Search to infect other users layer-by-layer. The counter will update every time all the adjacent users of the current user-group are infected. When the counter is larger or equal to the target value, it returns the counter number.
## Exact Infection
This is a modified version of limited infection that infects exactly the
## Future Work
