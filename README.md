# **Tic-Tac-Toe game with AI** 

This project represent text game Tic Tac Toe with three levels of difficulty:

 • The **"easy"** level difficulty makes a random move.

 • The **"medium"** level difficulty makes a move using the following process:            
  1. If it can win in one move (if it has two in a row), it places a third to get three in a row and win.
  2. If the opponent can win in one move, it plays the third itself to block the opponent to win.
  3. Otherwise, it makes a random move.
  
 • The **"hard"** level difficulty use _Minimax Algorithm_ . This level can see two moves ahead, three moves ahead and so on. Basically, it can see all possible outcomes till the end of the game and choose the best of them considering his opponent also would play perfectly.
 
 You can play with computer or another human. You can also see how computer play with itself choosing different levels of difficulty and combine them 
 
 ### Start menu
 
 Start menu loop can interpret two commands: **"start"** and **"exit"**.
 
 1. The command "start" take two parameters: who will play ‘X’ and who will play ‘O.’ Two possible parameters are : 
    
    • **user** - to play as a human and **"easy/medium/hard"** to play as AI.
        
```
   Input command: start user hard
```
    
 2. The command **"exit"** terminate the program.
 
``` 
   Input command: exit
 ```
        
### Human move        

If you choose to play as **user**  when it's your turn you'll be called to enter the coordinates to make a move.

***_Note_***: the first coordinate goes from left to right and the second coordinate goes from bottom to top. Also, notice that coordinates start with 1 and can be 1, 2 or 3.
        
     Enter the coordinates: 2 2
        ---------
        |       |
        |   X   |
        |       |
        ---------
 
 
 
 
 

