package com.example.my_calc_spring2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText reg1_input; //creates an EditText object, works like a string
    private EditText reg2_input;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reg1_input = (EditText) findViewById(R.id.editText_reg1_input); // telling java where to look in the xml file
        reg2_input = (EditText) findViewById((R.id.editText_reg2_input));
        result = (TextView) findViewById((R.id.textView_result));
    }
    public void addButtonClick(View view){
        String reg1_value = reg1_input.getText().toString();
        String reg2_value = reg2_input.getText().toString();
        String result_value;
        if(!isValid(reg1_value)){
            reg1_input.setError("Invalid input");
            reg1_input.setText("");
        }
        if(!isValid(reg2_value)){
            reg2_input.setError("Invalid input");
            reg2_input.setText("");
        }
        if(isValid(reg1_value) && isValid(reg2_value)){
            result_value = addValues(reg1_value, reg2_value);
            result.setText(result_value);
        }
        closeKeyboard();

    }
    public void subtractButtonClick(View view){
        String reg1_value = reg1_input.getText().toString();
        String reg2_value = reg2_input.getText().toString();
        String result_value;
        if(!isValid(reg1_value)){
            reg1_input.setError("Invalid input");
            reg1_input.setText("");
        }
        if(!isValid(reg2_value)){
            reg2_input.setError("Invalid input");
            reg2_input.setText("");
        }
        if(isValid(reg1_value) && isValid(reg2_value)){
            result_value = subValues(reg1_value, reg2_value);
            result.setText(result_value);
        }
        closeKeyboard();

    }

    public void multiplyButtonClick(View view){
        String reg1_value = reg1_input.getText().toString();
        String reg2_value = reg2_input.getText().toString();
        String result_value;
        if(!isValid(reg1_value)){
            reg1_input.setError("Invalid input");
            reg1_input.setText("");
        }
        if(!isValid(reg2_value)){
            reg2_input.setError("Invalid input");
            reg2_input.setText("");
        }
        if(isValid(reg1_value) && isValid(reg2_value)){
            result_value = multiplyValues(reg1_value, reg2_value);
            result.setText(result_value);
        }
        closeKeyboard();

    }

    public void  divButtonClick(View view){
        String reg1_value = reg1_input.getText().toString();
        String reg2_value = reg2_input.getText().toString();
        String result_value;
        if(!isValid(reg1_value)){
            Context context = getApplicationContext();
            CharSequence text = "Error: invalid value";
            int lengthLong = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, lengthLong);
            toast.show();
            //reg1_input.setError("Invalid input");
            //reg1_input.setText("");
        }
        if(!isValid(reg2_value) || reg2_value.equals("0")){
//            Context context = getApplicationContext();
//            CharSequence text = "Error: divide by 0";
//            int lengthLong = Toast.LENGTH_LONG;
//            Toast toast = Toast.makeText(context, text, lengthLong);
//            toast.show();
            reg2_input.setError("Invalid input");
            reg2_input.setText("");
        }
        if(isValid(reg1_value) && isValid(reg2_value)){
            if(!reg2_value.equals("0")) {
                result_value = divideValues(reg1_value, reg2_value);
                result.setText(result_value);
            } else
                result.setText("");

        }
        closeKeyboard();

    }
    public void modButtonClick(View view){
        String reg1_value = reg1_input.getText().toString();
        String reg2_value = reg2_input.getText().toString();
        String result_value;
        if(!isValid(reg1_value)){
            reg1_input.setError("Invalid input");
            reg1_input.setText("");
        }
        if(!isValid(reg2_value)){
            reg2_input.setError("Invalid input");
            reg2_input.setText("");
        }
        if(isValid(reg1_value) && isValid(reg2_value)){
            result_value = modValues(reg1_value, reg2_value);
            result.setText(result_value);
        }
        closeKeyboard();
    }
    public void gcdButtonClick(View view){
        String reg1_value = reg1_input.getText().toString();
        ArrayList<Integer> intvals = new ArrayList<>();
        //String val="";
        String[] strvals = reg1_value.split(",");
        for(String value : strvals) {
            if (isNumeric(value))
                intvals.add(Integer.parseInt(value));
        }
        String result_value;
        if(!isValid(reg1_value)) {
            reg1_input.setError("Invalid input");
            reg1_input.setText("");
        }
        result_value = gcdValues(intvals);
        result.setText(result_value);

        closeKeyboard();
    }

    public void lcmButtonClick(View view){
        String reg1_value = reg1_input.getText().toString();
        ArrayList<Integer> intvals = new ArrayList<>();
        //String val="";
        String[] strvals = reg1_value.split(",");
        for(String value : strvals) {
            if (isNumeric(value))
                intvals.add(Integer.parseInt(value));
        }
        String result_value;
        if(!isValid(reg1_value)) {
            reg1_input.setError("Invalid input");
            reg1_input.setText("");
        }
        result_value = lcmValues(intvals);
        result.setText(result_value);

        closeKeyboard();
    }
    public void resetButtonClick(View view){
        reg1_input.setText(null);
        reg2_input.setText(null);
        result.setText(null);
        closeKeyboard();
    }
    public String addValues(String reg1, String reg2){
        double reg1_num = Double.parseDouble(reg1);
        double reg2_num = Double.parseDouble(reg2);
        double scale = Math.pow(10,4);
        double result_num = Math.round((reg1_num+reg2_num)*scale)/scale;
        return String.valueOf(result_num);

    }
    public String subValues(String reg1, String reg2){
        double reg1_num = Double.parseDouble(reg1);
        double reg2_num = Double.parseDouble(reg2);
        double scale = Math.pow(10,4);
        double result_num = Math.round((reg1_num-reg2_num)*scale)/scale;
        return String.valueOf(result_num);

    }
    public String multiplyValues(String reg1, String reg2){
        double reg1_num = Double.parseDouble(reg1);
        double reg2_num = Double.parseDouble(reg2);
        //double scale = Math.pow(10,4);
        //double result_num = Math.round((reg1_num*reg2_num)*scale)/scale;
        double result_num = reg1_num*reg2_num;
        return String.valueOf(result_num);

    }
    public String divideValues(String reg1, String reg2){
        double reg1_num = Double.parseDouble(reg1);
        double reg2_num = Double.parseDouble(reg2);
        double scale = Math.pow(10,4);
        double result_num = Math.round((reg1_num/reg2_num)*scale)/scale;
        return String.valueOf(result_num);

    }
    public String modValues(String reg1, String reg2){
        double reg1_num = Double.parseDouble(reg1);
        double reg2_num = Double.parseDouble(reg2);
        double result_num = reg1_num % reg2_num;
        return String.valueOf(result_num);
    }
    public String gcdValues(ArrayList<Integer> reg1){
        int result = reg1.get(0);
        for (int element: reg1)
            result = gcd(result, element);
        return Integer.toString(result);

    }
    public String lcmValues(ArrayList<Integer> reg1) {
        int result = reg1.get(0);
        for (int element : reg1)
            result = (element * result) / gcd(result, element);
        return Integer.toString(result);
    }
    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    public static boolean isValid(String input){
        return isNumeric()&&!checkSpecial()&&atMostOneDecimal();
    }




    public static boolean isSpecial(char c){
        return true;
    }
    public static boolean checkSpecial(){
        return false;
    }
    public static boolean isNumeric(){
        return true;
        //String input_string goes as parameter
    }
    public static boolean atMostOneDecimal(){
        return true;
    }
    private void closeKeyboard(){
        View view = this.getCurrentFocus();
        if(view!= null){
            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
    //toast is an error message
}