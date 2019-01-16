package Main

// this is where you will begin the first version of your project
// but you will also need to connect this project with your github.uiowa.edu
// repository, as explained in the discussion section 9th November
import java.util.Scanner

interface Engine {  //This interface is for connecting future's implementation of GUI, first version of our homework
    var win:Boolean


    //Initialize the board
    fun init(board:Array<Int>):Array<Int>{
        return board.map{i -> 0}.toTypedArray()
    }

    //Check if the move is valid, since we can't put move on others' move or put repeated moves
    fun checkValid(board:Array<Int>,index:Int):Boolean{

        if ((board[index] == 0)&&(checkWin(board) == false)){
            return true
        }
        return false
    }

    //Once we clicked switch mode on the screen, it will switch between "User vs User" and "User vs CPU"
    fun switchMode(mode:Int):Int{
        return if (mode==1) 2 else 1
    }

    //Once we clicked on a valid spot, we will put the player number on board
    fun makeMove(board:Array<Int>,index:Int,player: Int):Array<Int>{
        board[index] = player
        return board
    }

    //This function is to check if one side already wins once after a move
    fun checkWin(board:Array<Int>):Boolean{

        //horizontal comparison for every line
        if (board[0]==board[1] && board[1] == board[2] && board[0]!=0) return true
        if (board[3]==board[4] && board[4] == board[5] && board[3]!=0) return true
        if (board[6]==board[7] && board[7] == board[8] && board[6]!=0) return true

        //vertical comparison for every line
        if (board[0]==board[3] && board[3] == board[6] && board[0]!=0) return true
        if (board[1]==board[4] && board[4] == board[7] && board[1]!=0) return true
        if (board[2]==board[5] && board[5] == board[8] && board[2]!=0) return true

        //back slash comparison
        if (board[0] == board[4] && board[4] == board[8] && board[0]!=0) return true

        //forward slash comparison
        if (board[2] == board[4] && board[4] == board[6] && board[2]!=0) return true
        win = true
        return false
    }

    //Check that if everyspot is already filled so the game tied or not
    fun checkTie(board: Array<Int>):Boolean{
        win = true
        return board.filter{i -> i==0}.size==0
    }

    //Once after a click, player will switch to the other. So
    fun nextPlayer(player:Int):Int{
        return if (player == 1) 2 else 1
    }
}

//This is for the test code
class board_game:Engine{
    override var win = false
}

//I deleted things from here(First version), to use above to run a terminal version of Tic-Tac-Toe
fun main(args: Array<String>) {
}
