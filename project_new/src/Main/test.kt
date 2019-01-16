package Main


import org.junit.Test
import org.junit.Assert.*
import javax.xml.ws.Service


//These are the tests part which could test that if engine works fine.
class Test_Version1 {


    @Test
    fun example() {
        assert(true)
        assertEquals(1, 1)
        assertNotEquals(1, 2)
    }

    @Test
    fun empty_board() {

        val S = board_game()
        var list = Array<Int>(9){index -> 0}
        /*for(i:Int in 0..8){
            println(list[i])
        }*/
        assertEquals(S.checkWin(list), false)
    }

    @Test
    fun horizonal() {
        val S = board_game()
        var list = Array<Int>(9){index -> 0}
        for(i:Int in 0..2){
            list[i] = 1
        }
        assertTrue(S.checkWin(list))
    }

    @Test
    fun vertical() {
        val S = board_game()
        var list = Array<Int>(9){index -> 0}
        list[0] = 1
        list[1] = 1
        list[2] = 1
        assertTrue(S.checkWin(list))
    }


    @Test
    fun diagonal() {
        val S = board_game()
        var list = Array<Int>(9){index -> 0}
        list[0] = 1
        list[4] = 1
        list[8] = 1
        assertTrue(S.checkWin(list))
    }

    @Test
    fun tie_game() {
        val S = board_game()
        var list = Array<Int>(9){index -> 0}
        list[1] = 1
        list[2] = 1
        list[3] = 1
        list[4] = 1
        list[8] = 1
        list[0] = 2
        list[5] = 2
        list[6] = 2
        list[7] = 2
        assertTrue(S.checkTie(list))
    }

    @Test
    fun validity() {
        val S = board_game()
        var list = Array<Int>(9){index -> 0}
        list[1] = 1
        list[2] = 1
        list[3] = 1
        list[4] = 1
        list[0] = 2
        list[5] = 2
        list[6] = 2
        list[7] = 2
        assertFalse(S.checkValid(list,6))
    }
}

