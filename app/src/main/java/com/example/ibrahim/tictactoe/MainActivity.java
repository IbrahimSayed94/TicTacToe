package com.example.ibrahim.tictactoe;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button a1,a2,a3,b1,b2,b3,c1,c2,c3,newgame;
    Button []array;

    boolean turn=true;
    //X=true , O=false

    int turn_count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1=(Button)findViewById(R.id.a1);
        a2=(Button)findViewById(R.id.a2);
        a3=(Button)findViewById(R.id.a3);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        c1=(Button)findViewById(R.id.c1);
        c2=(Button)findViewById(R.id.c2);
        c3=(Button)findViewById(R.id.c3);
        newgame=(Button)findViewById(R.id.newgame);


        array=new Button[]{a1,a2,a3,b1,b2,b3,c1,c2,c3};

        for(Button b :array)
        {
            b.setOnClickListener(this);
        }//end of for loop

        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn=true;
                turn_count=0;
                clear();

            }
        });

    } //end of onCreate method

   private void clear()
   {
       for(Button b:array)
       {
           b.setText("");
           b.setBackgroundColor(Color.LTGRAY);
           b.setClickable(true);
       }
   }//method clear
    @Override
    public void onClick(View v)
    {
        Button b=(Button)v;
        buttonclicked(b);
     // toast("Button Clicked");
    }//end of onClick method , this method called for every click

    public  void buttonclicked(Button b)
    {
        //game start with X turn

        if(turn)
        {
         b.setText("X");
        }// end of if
        else
        {
         b.setText("O");
        }//end of else
        turn_count++;
        b.setBackgroundColor(Color.MAGENTA);
        b.setClickable(false);
        turn=!turn;
        checkforwinner();

    }//end of buttonclicked method
    private  void checkforwinner()
    {
        boolean winner=false;

        //check horizontal
        if(a1.getText()==a2.getText() && a2.getText()==a3.getText() && !a1.isClickable())
            winner=true;
        else if(b1.getText()==b2.getText() && b2.getText()==b3.getText() && !b1.isClickable())
            winner=true;
        else if(c1.getText()==c2.getText() && c2.getText()==c3.getText() && !c1.isClickable())
            winner=true;
        //check vertical
       else if(a1.getText()==b1.getText() && b1.getText()==c1.getText() && !a1.isClickable())
            winner=true;
        else if(a2.getText()==b2.getText() && b2.getText()==c2.getText() && !b2.isClickable())
            winner=true;
        else if(a3.getText()==b3.getText() && b3.getText()==c3.getText() && !c3.isClickable())
            winner=true;
        //check diagonals
      else if(a1.getText()==b2.getText() && b2.getText()==c3.getText() && !a1.isClickable())
            winner=true;
        else if(a3.getText()==b2.getText() && b2.getText()==c1.getText() && !a3.isClickable())
            winner=true;
        if(winner)
        {
            if(!turn)
            {
                toast("Player X is Winner");
            }//end of if
            else
            {
                toast("Player O is Winner");
            }//end of else

              close(false);

        }// end of if winner
        else if(turn_count==9)
        {
                toast("Draw");
        }

    }//end of checkforwinner method

    private  void close(boolean e)
    {
        for(Button b:array)
        {
            b.setClickable(e);
            if(e)
                b.setBackgroundColor(Color.LTGRAY);
            else
                b.setBackgroundColor(Color.CYAN);
        }//for
    }//method close



    private void toast(String message)
    {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();//display message
    }//end of toast method

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
