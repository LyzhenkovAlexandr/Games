# Tic-tac-toe

## The game supports:
- a game with an arbitrary number of players, starting with one. The turn order is determined
  the initial order of the players in the constructor of the "TicTacToe" class, which can also be changed
- playing on a field of arbitrary positive integer sizes, starting from size 1 x 1
- a way to change the number of crossed cells needed to win
- output to the console of the current rules of the game

This game is divided into the following main levels of abstraction: game rules, board, players.
The class "TicTacToe" is responsible for the beginning of the game and the 
entire gameplay, during initialization it can be passed both players and rules. 
In case of victory, the play() method will return the winner, 
in case of a tie it will return null.