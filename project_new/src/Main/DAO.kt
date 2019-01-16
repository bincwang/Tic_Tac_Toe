package Main

//Data Access Object. It is used as an transition between Controller and Engine
class DAO {

    private var mode = 1
    private var board = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    private var currentPlayer = 1

    fun getMode():Int{
        return mode
    }

    fun setMode(m:Int){
        mode = m
    }

    fun setPlayer(player: Int){
        currentPlayer = player
    }

    fun getPlayer():Int{
        return currentPlayer
    }

    fun setBoard(newBoard:Array<Int>){
        board = newBoard
    }

    fun getBoard():Array<Int>{
        return board
    }



}
