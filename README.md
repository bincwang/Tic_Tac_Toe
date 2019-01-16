Part1: How to run the project

Step 1: git clone “ssh link”, you’ll download the project in your local directory.
Step 2: Double Click you intellij icon on your laptop 
Step 3: Very Important! Please not click Import Project. 
Click “Open”, which is on the third line, and open the project directly
Step4: Once you open it, everything should be with my original setup, which won’t ruin anything. 
Step 5: Click on the file, “Main”, then click on the green arrow on the left side of the line   
public static void main(String[] args) {launch(args);}
Then my Tic-Tac-Toe Gui with good decoration will come up. 
There is no gradle setting in my project. I used Javafx directly. So please not import my project with gradle. Just open it directly and go to Main file. Thanks a lot!
I commented everything in my code.

Professor, in case something happens again. You could git clone the code you reorganized for me and replace the controller class with my current one. Then you could still see a smart version of my Tic-tac-Toe Gui, which won’t have my decoration though. But it won’t waste your time to reorganize my code again. But if you clicked open for that instead of importing, everything should be fine. Thanks again!

This is my tic-tac-toe project for my CS:2820 Object-oriented Software Development class.
November 10, 2018 Saturday. It's very first basic version without any GUI. We could play on the terminal by typing number 0 - 8 matching each box. Simply, we just run main, it could play clearly with player X and O. After game, we have to click "run" again for the second game.
November 12, 2018 Monday. It's still the first iteration of basic Tic-Tac-Toe without GUI, but it has Test cases now. Test cases covers most of methods and those passes. The only two methods I didn't test because it involves Scanner.in. But if we click run button on main method and plays the game, we will notice that everything works fine. I checked Google and people said it's normal that tests might not cover everything, because in the very complicated program, we could only use it to test basic functions.
November 13, 2018 Tuesday. Before moving forward to JavaFX. I made the interface clear, so it will be convenient for the future. First version ends here
November 15 - 24, 2018. I started a project again with javafx in Intellij. Now it reaches to the second version. But it lost connection with the engine part Also I am not able to connect with my github My github account works fine before my last commit
November 26, 2018 Monday (The first day after Thanksgiving break) Now I put the engine part on and I am going to modify them to connect my Service for OO design purpose
My Service was actually a "engine", but it's not very obvious. So now the first version of project becomes an Interface "Engine" and my class service is directly using Engine's methods without copying the codes.
Also, I added a restart button on the bottom of GUI.
Controller calls method from data access object and Service to make an OO design pattern. Now if we go to class "Main" and Launch the GUI by clicking green button We could have the GUI and having two players to play on a GUI version. People can restart whenever they want. Note: Once someone wins. The button is still clickable. So please click restart once you win the game or turn it off Junit has a little problem. Just fixed it again
November 29, 2018.
Now after the game ends, people won't be able to click on empty spot unless pressing restart
Second version ends here.
November 29 - December 1: Third version starts, change some decoration which looks better. Then add a new mode "Player vs CPU". We can click button switch to switch mode. After game ends, we could click restart to play the game under the same mode again. Most of my time is to try and think how do put CPU in and how to put the picture into the fxml.
Third version ends here.
December 8th- December 9th
Fourth version starts. CPU becomes smarter than before. 
Fourth version ends here. (Since pdf is the most important part of the fourth version)

