	Abstract 
  The game Tic tac toe X’s and O’s is for two players and the option for single player where players take turn marking the empty cells in a 3×3 grid. The one who is successful in putting three of the marks in a vertical, horizontal or diagonal. The game is a solvable game where a player is forced to draw presuming best play from the both of the players.  The aims of the project are to develop a puzzle game clone Android application and the selected game is the Tic-Tac-toe. The game has single and multiplayer options as functional needs. The objectives of the projects are to learn the JAVA development idea in the android studio, create the 2d board of the game, code the AI algorithm such as the Mini-Max, create different levels of difficulties like the option of easy, medium, and hard. The project result has so far has been successful. The single player where a user goes against another player is completed and working, and the two player which has the AI (Mini-max) algorithm which tracks the users moves and then makes the best move. AI has been completed and has a 100% success rate. Most of the objectives which have been mentioned in this report are completed. Artificial intelligence (AI) such as the mini-max algorithm and adding the levels of difficulty have been achieved. Some of the objective which were optional were removed since it was interfering with current Mini-max algorithm and also the single player. Furthermore, when testing the AI and the difficultly levels associated within it is very effective such as the algorithm trying to beat and track the user’s moves. It is estimated that it has a success rate of 70%-win ratio.
Implementation
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

 

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(first.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 15000);

    }
}
![image](https://user-images.githubusercontent.com/38366819/138062198-b718cd3d-d45a-4aef-9dd4-13ca614fe028.png)

 	 

The above code is of the splash screen called the first. It is a welcome screen which shows the user the rules of the games. The class has an handler in it which basically delays the splash screen so that the user can read all the text. The intent is to carry out a step on the screen which is used to start a another activity or class such as in the above code the main activity class is started when the delay is over.  


![erg](https://user-images.githubusercontent.com/38366819/138062660-18dc9329-7414-40e1-a532-8c4820cf009f.PNG)
![image](https://user-images.githubusercontent.com/38366819/138062908-78dd5c8a-5826-4d91-8cfc-549e3db2cbbf.png)

             
         


The above method shows a drop-down menu which gives a list of options to the user such as easy, medium, hard, and impossible. A spinner is used in this method which is used to display several options to the player in that only single item can be picked by the player. The android spinner acts like a drop-down menu with several values from that the user has to choose one value only. 

In the other method there is a switch statement which is sort of selection control tool utilizes to permit the value of a variable to change the control movement of programming completion. 

 ![image](https://user-images.githubusercontent.com/38366819/138063768-b36c0812-c90c-40e3-90dc-7d128b2c6320.png)


In the above method it shows the that I have used a checkbox.  It permits the player or users to pick one or several options from the set. Checkbox is a small box where a tick is entered. 
In this example a user has the option to select X or O. 

       
![image](https://user-images.githubusercontent.com/38366819/138063887-1f8befcc-fe3d-48db-adc5-3990f4b85a45.png)

    

The above code shows us the AI which is the mini-max algorithm and it uses the function which returns heuristic value for the leaf nodes. The heuristic value which measures the scores and it picks the best move of the node for maximizing player. Consequently 
nodes result in a suitable outcome, like a win, for increase player have top scores vs the nodes more suitable for the minimizing player. The analytical value for when the game ends leaf nodes which are scores parallel to win, loss, or draw for maximizing player. The standard of this estimate and also the exploration decides the standard and precision of the final mini-max outcome. 
 ![image](https://user-images.githubusercontent.com/38366819/138064283-4bbb3d19-405c-480b-9cce-85cdc232ed84.png)

 Sourced from internet
There are two players in the mini-max, maximizing player and the minimizing player. For example, the game which is played on has two possible moves per player in each turn. The AI produces the tree which is on the right side, the circles show the moves of the player that is running the algorithm such as the maximizing the player, and the squares show the moves of the minimizing player because of the restriction of computational resources. The algorithm analyses every leaf node utilizing a heuristic function, acquiring the values given. The maximizing player wins are shown with positive infinity and the moves which lead to minimizing player are given with negative infinity. In the third level the algorithm will select for every node the smallest child node. 

Updated version of the game
![image](https://user-images.githubusercontent.com/38366819/138064362-4f3442d7-b422-47b8-9d81-d403a1a65842.png)

 
 The main activity of the game shows the users options on what he would like to do. First the user has the freedom to select X or O and to type any name they would like to have. If the user selects single player, he will be playing with another person such as a human. If the user selects two player, they get the option of which difficulty level they would like to go for. Hence the player will be going against the AI.  
 ![image](https://user-images.githubusercontent.com/38366819/138064442-5a457f84-c4d4-4097-b2ef-c3caba1dfd3a.png)

In the above image the player 1 always goes first, but the other player also gets a chance to go first when the game ends. 


 ![image](https://user-images.githubusercontent.com/38366819/138064526-54d8a8b5-c2b4-4c26-a473-020d1215f510.png)


The prototype has difficultly levels shown. If the user picks easy as difficulty level then the game just places random move on the board. If the user picks difficulty levels such as the medium, hard and impossible; this is where the AI plays its part and algorithm tries to track the user positions as they play along. 
![image](https://user-images.githubusercontent.com/38366819/138065998-ce1bded8-b27b-413d-a6d1-cac995327578.png)

 
Wire-Frame
When the game starts the user is greeted with the splash screen which shows the users the game rule, the splash screen only lasts for a few seconds. After that the user enters the main activity which is the main page that has many options were a user can select what gameplay they would like to play such as single player or two players. They also have the option to select X or O before starting the game. If the user has selected single player, then the user will be having options to select different difficulty levels. When the game has started the player could exit the game any time, they want by pressing the black button, this would reset the game and would take them back to the main activity or the main page of the game. The player could also reset if the round is over and they could play again which will start the game from the beginning with the same options meaning their name and mark won't change. 

Build and run the app
To run the app simply open the project on the android studio and when the project has complied successfully and the Gradle files have been completed then simply click on the run button. After that an emulator will pop up and the project will start by itself automatically. Android studio will first open the splash screen and once that is completed then the main activity will start. If for some reason the app does not compile then please click on the logcat and check the error. The error may be because of an older version of android studio or it could be a Gradle error, please update the android studio and Gradle version accordingly.  

11. Conclusion
The project is fully executed and deployed in an APK format with the help of android studio. All of the essential parts have been completed such as the single player option where a user player against the computer with the option of selecting different difficulty levels, the other essential part was the two players where a user plays against another player, and the game alternates their turn when a round is over. Because of the steep learning curve of the android studio development, some of the scope of the project has been changed. Multiplayer game play and saving players scores on fire-base have not been developed, and I have communicated to the supervisor in the weekly meetings. The recommended features have been created and are tested utilizing both the android simulator. 
