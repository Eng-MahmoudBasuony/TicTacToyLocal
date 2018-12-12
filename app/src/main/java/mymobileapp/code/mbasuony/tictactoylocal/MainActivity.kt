package mymobileapp.code.mbasuony.tictactoylocal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


//فكره اللعبه اللى يملى صف كامل يكون هوا الفائز
//صف طولى او عرضى المهم ثلاث خانات تكمل من شخص واحد = يكون هوا الفائز
class MainActivity : AppCompatActivity()
{

    private var player1= ArrayList<Int>();// save number of cell for clicked player 1
    private var player2=ArrayList<Int>(); //save number of cell for clicked player 2
    private var activePlayer=1 // for Switch between tow player




    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }





    //event click for All Button =sam name Method
    fun buSelect(view:View)
    {  //view return id button on Current Click

        val btnChoice =view as Button //casting

        var celLId=0

        when(btnChoice.id)//Return Button Id Clicked
        {
            R.id.bu1-> celLId=1
            R.id.bu2-> celLId=2
            R.id.bu3-> celLId=3
            R.id.bu4-> celLId=4
            R.id.bu5-> celLId=5
            R.id.bu6-> celLId=6
            R.id.bu7-> celLId=7
            R.id.bu8-> celLId=8
            R.id.bu9-> celLId=9
        }

        Log.d("cellId : ",celLId.toString())
        playGame(celLId,btnChoice)


    }



    fun playGame(cellId:Int,btnChoce:Button)
    {
        //change background color in btn Clicked
          if (activePlayer==1)
          {
              btnChoce.text="X"
              btnChoce.setBackgroundResource(R.color.itemX)
              player1.add(cellId)// number of cell
              activePlayer=2 //Switch between tow player
              autoPlay() //Device Start Game

          }else
          {
              btnChoce.text="o"
              btnChoce.setBackgroundResource(R.color.itemO)
              player2.add(cellId) // number of cell
              activePlayer=1 //Switch between tow player
              autoPlay()//Device Start Game
          }

        btnChoce.isEnabled=false //Because not clicked again

        checkWinner()
    }


    fun checkWinner()
    {
        var winner=-1

        //----------------Player 1------------------------//
         //row 1
        if (player1.contains(1)&&player1.contains(2)&&player1.contains(3))
        {
             winner=1
        }
        //row 2
        if (player1.contains(4)&&player1.contains(5)&&player1.contains(6))
        {
            winner=1
        }
        //row 3
        if (player1.contains(7)&&player1.contains(8)&&player1.contains(9))
        {
            winner=1
        }


        //col 1
        if (player1.contains(1)&&player1.contains(4)&&player1.contains(7))
        {
            winner=1
        }
        //col 2
        if (player1.contains(2)&&player1.contains(5)&&player1.contains(8))
        {
            winner=1
        }
        //col 3
        if (player1.contains(3)&&player1.contains(6)&&player1.contains(9))
        {
            winner=1
        }


        //-------------------PLayer 2------------------------//
        //row 1
        if (player2.contains(1)&&player2.contains(2)&&player2.contains(3))
        {
            winner=2
        }
        //row 2
        if (player2.contains(4)&&player2.contains(5)&&player2.contains(6))
        {
            winner=2
        }
        //row 3
        if (player2.contains(7)&&player2.contains(8)&&player2.contains(9))
        {
            winner=2
        }

        //col 1
        if (player2.contains(1)&&player2.contains(4)&&player2.contains(7))
        {
            winner=2
        }
        //col 2
        if (player2.contains(2)&&player2.contains(5)&&player2.contains(8))
        {
            winner=2
        }
        //col 3
        if (player2.contains(3)&&player2.contains(6)&&player2.contains(9))
        {
            winner=2
        }

        //----------------
        if (winner!=-1)
        {
            if (winner==1)
            {
                Toast.makeText(this,"Player 1 Win the Game ",Toast.LENGTH_LONG).show();
            }else
            {
                Toast.makeText(this,"Player 2 Win the Game ",Toast.LENGTH_LONG).show();

            }
        }

    }

    //Device Start Game
    fun autoPlay()
    {
        val emptyCells=ArrayList<Int>()// save number Empty Cells

          //----------Scan Empty Cells---------------//
         for (cellId in 1..9) //scan from 1 to 9 cell
         {
             if ( !(player1.contains(cellId)||player2.contains(cellId)) )//scan from 1 to 9 has not checked
             {
                 emptyCells.add(cellId)
             }
         }

        //-----------Chose Random number from Empty Cells-------------//
        val r=java.util.Random() //Generate Random Number
        val indexArray=r.nextInt(emptyCells.size-0)+0 //MAx Number =emptyCells.size()  , min=0
        val cellIdAuto=emptyCells[indexArray] //get Value "Number Cell"

        //-------------CLicked In Empty Cells-------------//
        var btnSelect:Button

        //-----Interpreter IndexArray"cellIdAuto" To Button--------//
        when(cellIdAuto) //ex Button 1= cell 1
        {
            1-> btnSelect=bu1
            2-> btnSelect=bu2
            3-> btnSelect=bu3
            4-> btnSelect=bu4
            5-> btnSelect=bu5
            6-> btnSelect=bu6
            7-> btnSelect=bu7
            8-> btnSelect=bu8
            9-> btnSelect=bu9
            else-> //problem this Language
            {
                btnSelect=bu1
            }
        }

        playGame(cellIdAuto,btnSelect)


    }

}
