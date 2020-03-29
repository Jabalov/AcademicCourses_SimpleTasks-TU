package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME = "Answer.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void saveFile(View view)
    {
        FileOutputStream fos = null;
        EditText n1 = (EditText) findViewById(R.id.N1);
        EditText n2 = (EditText) findViewById(R.id.N2);
        int num1 = Integer.parseInt(n1.getText().toString());
        int num2 = Integer.parseInt(n2.getText().toString());
        try
        {
            fos = openFileOutput("Answer.txt", MODE_APPEND);
            fos.write(("Sum : " + (num1 + num2) + "\n").getBytes());
            fos.write(("Diff : " + (num1 - num2) + "\n").getBytes());
            fos.write(("Prod : " + (num1 * num2) + "\n").getBytes());
            fos.write(("Div : " + (num1 / num2) + "\n").getBytes());
            n1.setText("enter the first number");
            n2.setText("enter the second number");
            Toast.makeText(this, "Saved to " + getFilesDir() + "/Answer.txt", Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
