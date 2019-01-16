package Main;

import com.sun.prism.paint.Color
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.event.ActionEvent
import javafx.scene.control.Button
import javafx.scene.Scene
import javafx.fxml.FXMLLoader
import javafx.scene.Parent


//Controller class is the brain of this project. It makes everything work from those
class Controller {
    var mode:Int = 1 //1 is vs User, 2 is vs CPU
    val dao = DAO()
    val service = Service()


    @FXML
    var pos0 = Button()
    @FXML
    var pos1 = Button()
    @FXML
    var pos2 = Button()
    @FXML
    var pos3 = Button()
    @FXML
    var pos4 = Button()
    @FXML
    var pos5 = Button()
    @FXML
    var pos6 = Button()
    @FXML
    var pos7 = Button()
    @FXML
    var pos8 = Button()
    @FXML
    var restart = Button()
    @FXML
    var switch = Button()


    @FXML
    var info = Label()


    @FXML
    var info2 = Label()

    @FXML
    var info3 = Label()


    //This is how we initialize the board
    //It will be called at the beginning when we run the code and it will also be called once we click restart or switch
    //Please look at my FXML page for more details of color, etc...
    @FXML
    private fun init(){
        var pos = arrayOf(pos0,pos1,pos2,pos3,pos4,pos5,pos6,pos7,pos8)
        println("restart")
        pos.map{it->it.style="-fx-background-color: limegreen"}
        var board = dao.getBoard()
        board = service.init(board)
        dao.setBoard(board)
        info.text = "Current: Black"
        dao.setPlayer(1)
    }

    //When we click on switch, it will call this function
    @FXML
    private fun switch(event: ActionEvent){
        //This function is to change the mode of the game
        init()
        mode = dao.getMode()
        dao.setMode(service.switchMode(mode))
        info3.text = if (dao.getMode() == 1) "Mode: Two player" else "Mode: Single player"
    }

    //Click function is inside of Controller. Once we clicked on the button, it will call this function
    @FXML
    private fun clicked(event: ActionEvent) {

        //Update anytime we click
        mode = dao.getMode()
        var pos = arrayOf(pos0,pos1,pos2,pos3,pos4,pos5,pos6,pos7,pos8)
        var board = dao.getBoard()
        var color = arrayOf("Black", "Red")
        var value = mapOf<String, Int>("pos0" to 0, "pos1" to 1, "pos2" to 2, "pos3" to 3, "pos4" to 4, "pos5" to 5, "pos6" to 6, "pos7" to 7, "pos8" to 8)
        var btn: Button = event.getSource() as Button
        var player = dao.getPlayer()
        var next = service.nextPlayer(player)

        //This is the default mode. Human vs CPU
        if (mode == 1) {
            println("clicked: ${btn.id}")
            if (service.checkValid(board, value[btn.id]!!)) {
                info.text = "Current: " + color[next - 1]
                dao.setPlayer(next)
                btn.style = "-fx-background-color: " + color[player - 1]
                board = service.makeMove(board, value[btn.id]!!, player)
                dao.setBoard(board)
                if (service.checkWin(board)) {
                    info.text = color[player - 1] + " won!"
                    info2.text = "Please restart game to play again,"
                    return
                } else if (service.checkTie(board)) {
                    info2.text = "Please restart to play again,"
                    info.text = "Tie!"
                    return
                }
            } else {
                info.text = "This spot was already taken!"
                return
            }
        } //This part is for human vs CPU mode, since the mode ==2 here.
            else {
            println("Here is the mode against computer")
            println("clicked: ${btn.id}")

            //This part is for checking and putting newest player's button

            var playing = true
            var board_copy = board
            var winning_move = false
            var defense_move = false
            if (service.checkValid(board, value[btn.id]!!)) {
                info.text = "Current: " + color[next - 1]
                btn.style = "-fx-background-color: " + color[player - 1]
                board = service.makeMove(board, value[btn.id]!!, player)
                dao.setBoard(board)

                if (service.checkWin(board)) {
                    info.text = color[player - 1] + " won!"
                    info2.text = "Please restart game to play again,"
                    playing = false
                    return
                } else if (service.checkTie(board)) {
                    info2.text = "Please restart to play again,"
                    info.text = "Tie!"
                    playing = false
                    return
                }
            } else {
                info.text = "This spot was already taken!"
                return
            }
            //If playing is still equal to true, which means that computer is going to make a move
            if(playing){
                info.text = "Current: CPU"
                //Initialize the randomInteger we are going to use for computer's move
                var randomInteger = (0..8).shuffled().first()

                //Now, I am going to make computer smarter now (The earlier version was just random
                //I am going to let the CPU think every better move
                //First of all, Consider all of the possibility of winning the game

                board_copy = board



                //For this part, if there is a move that CPU could win the game, it will make the move
                //There are a little used variable, please ignore that because they were created in case i want to make
                // the program better.
                for(iter in 0..8){
                    if(board_copy[iter]==0) {
                        board_copy.set(iter, 2)
                        if(service.checkWin(board_copy)){
                            randomInteger = iter
                            winning_move = true
                            board = service.makeMove(board_copy,randomInteger,next)
                            dao.setBoard(board_copy)
                            pos[randomInteger].setStyle("-fx-background-color: " + color[player]);
                                info.text = color[player] + " won!"
                                info2.text = "Please restart game to play again,"


                            println("haha wwwwwwwasvgewakjgnwakjegnwioGENw")
                            for(i in 0..8){
                                println(board_copy[i])
                            }
                            return
                        }else{
                            board_copy.set(iter,0)
                        }
                    }
                }

                //For this part, the CPU will try to block you once you have two at the same line.
                //If you have a two connected together and cpu cannot win, it will block you
                //Tic Blocker

                for(iter in 0..8){
                    if(board_copy[iter]==0) {
                        board_copy.set(iter, 1)
                        if(service.checkWin(board_copy)){
                            randomInteger = iter
                            defense_move = true
                            board = service.makeMove(board_copy,randomInteger,next)
                            dao.setBoard(board_copy)
                            pos[randomInteger].setStyle("-fx-background-color: " + color[player]);
                            println("Defense")
                            /*for(i in 0..8){
                                println(board_copy[i])
                            }*/
                            return
                        }else{
                            board_copy.set(iter,0)
                        }
                    }
                }

                //Getting middle at the beginning, I think this will be a wise move and it will avoid lots of failures
                if(board_copy[4]==0) {

                    randomInteger = 4
                    board = service.makeMove(board_copy, 4, next)
                    dao.setBoard(board_copy)
                    pos[randomInteger].setStyle("-fx-background-color: " + color[player]);
                    println("Take up")
                    return
                }

                //This part is more defined, it will take up the corner if we take the middle at the first time, because if it doesn't
                //Human will always win.
                //After this part, human might not able to always win
                //At least there will be lots of change to tie. Please try it. It's fun
                if(board_copy[4]==1){
                    if(board_copy[0]==0){
                        randomInteger = 0
                        board = service.makeMove(board_copy, 0, next)
                        dao.setBoard(board_copy)
                        pos[randomInteger].setStyle("-fx-background-color: " + color[player]);
                        println("Take up")
                        return
                    }
                    if(board_copy[2]==0){
                        randomInteger = 2
                        board = service.makeMove(board_copy, 2, next)
                        dao.setBoard(board_copy)
                        pos[randomInteger].setStyle("-fx-background-color: " + color[player]);
                        println("Take up")
                        return
                    }
                    if(board_copy[6]==0){
                        randomInteger = 6
                        board = service.makeMove(board_copy, 6, next)
                        dao.setBoard(board_copy)
                        pos[randomInteger].setStyle("-fx-background-color: " + color[player]);
                        println("Take up")
                        return
                    }
                    if(board_copy[8]==0){
                        randomInteger = 8
                        board = service.makeMove(board_copy, 8, next)
                        dao.setBoard(board_copy)
                        pos[randomInteger].setStyle("-fx-background-color: " + color[player]);
                        println("Take up")
                        return
                    }
                }

                //This part is just random if  the move doesn't satisfy any of the condition above
                if(winning_move == false) {
                    while (!service.checkValid(board, randomInteger)) {

                        randomInteger = (0..8).shuffled().first()
                    }
                }

                //Following are just to put the move on the board. (Both Data and Gragh)
                println("cpu:"+randomInteger)
                board = service.makeMove(board,randomInteger,next)
                dao.setBoard(board)

                pos[randomInteger].setStyle("-fx-background-color: " + color[player]);
                if (service.checkWin(board)) {
                    info.text = color[player] + " won!"
                    info2.text = "Please restart game to play again,"

                } else if (service.checkTie(board)) {
                    info2.text = "Please restart to play again,"
                    info.text = "Tie!"

                }
            }
        }
    }
}


