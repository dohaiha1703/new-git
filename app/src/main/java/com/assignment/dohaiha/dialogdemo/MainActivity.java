package com.assignment.dohaiha.dialogdemo;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showTimePickerDialog(View view) {
        // cau hinh thoi gian hien thi
        Calendar calendar = Calendar.getInstance();
        final int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        //khoi tao time picker dialog

        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, "time: " + hour + ":" + minute, Toast.LENGTH_SHORT).show();
            }
        }, hour, minute, false);

        //hienthi
        dialog.show();
    }

    public void showDatePickerDialog(View view) {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this,
                        dayOfMonth + "/" + (month + 1) + "/" + year, Toast.LENGTH_SHORT).show();
            }
        }, year, month, day);

        dialog.show();
    }

    public void showSpinerProgress(View view) {

        //dinh nghia progressdialog
        ProgressDialog dialog = new ProgressDialog(MainActivity.this);

        //lap thong tin
        dialog.setTitle("open");
        dialog.setMessage("Loading");

        dialog.setButton(ProgressDialog.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        //thiet lap k the huy
        dialog.setCancelable(false);

        //show dialog
        dialog.show();

    }

    public void showSpinnerHorizontalProgress(View view) {
        //dinh nghia progressdialog
        ProgressDialog dialog = new ProgressDialog(MainActivity.this);

        //lap thong tin
        dialog.setTitle("open");
        dialog.setMessage("Loading");

        dialog.setButton(ProgressDialog.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        //thiet lap k the huy
        dialog.setCancelable(false);

        //lap style
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        //show dialog
        dialog.show();

        //dinh nghia gia tri
        dialog.setProgress(60);
    }

    public void showAlertDialog(View view) {
        //dinh nghia dialog
        android.support.v7.app.AlertDialog.Builder builder =
                new android.support.v7.app.AlertDialog.Builder(MainActivity.this);

        //thiet lap header, body, button
        builder.setTitle("AlerDialog");
        builder.setMessage("are you sure?");
        builder.setPositiveButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "close", Toast.LENGTH_SHORT).show();
            }
        });

        //show
        builder.show();
    }

    public void showAlertDialogList(View view) {

        android.support.v7.app.AlertDialog.Builder builder =
                new android.support.v7.app.AlertDialog.Builder(MainActivity.this);

        builder.setTitle("ListDialog");
        builder.setIcon(android.R.drawable.btn_dialog);

        final String[] list = {"abc", "def", "ghi", "klm"};
        builder.setItems(list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "item: " + list[which], Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    public void showAlertDialogSingleChoice(View view) {

        android.support.v7.app.AlertDialog.Builder builder =
                new android.support.v7.app.AlertDialog.Builder(MainActivity.this);

        builder.setTitle("What would you want?");
        builder.setIcon(android.R.drawable.btn_dropdown);

        final String[] list = {"Set as Home Screen", "Set as Lock Screen", "Set Both"};

        builder.setSingleChoiceItems(list, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "item: " + which, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "OK" + which, Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();

    }

    public void showAlertDialogMultiple(View view) {

        android.support.v7.app.AlertDialog.Builder builder =
                new android.support.v7.app.AlertDialog.Builder(MainActivity.this);

        builder.setTitle("SingleChoiceDialog");
        builder.setIcon(android.R.drawable.btn_dropdown);

        final String[] list = {"abc", "def", "ghi", "klm"};

        builder.setMultiChoiceItems(list, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(MainActivity.this, list[which] + "\t" + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();

    }

    public void showAlertDialogCustom(View view) {

//        final android.support.v7.app.AlertDialog.Builder builder =
//                new android.support.v7.app.AlertDialog.Builder(MainActivity.this);
//
//        //thiet lap body
//        LayoutInflater inflater = MainActivity.this.getLayoutInflater();
//        final View view1 = inflater.inflate(R.layout.dialog_update, null);
//        builder.setView(view1);
//
//        final Dialog dialog = builder.create(); // chuyen ve dialog de co the cancel
//
//
//        //xu ly widget tren dialog
//        final EditText name = view1.findViewById(R.id.edtName);
//        final EditText address = view1.findViewById(R.id.edtAdd);
//        Button update = view1.findViewById(R.id.btnUpdate);
//        Button cancel = view1.findViewById(R.id.btnCancel);
//
//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "name: " + name.getText() + "\n" +
//                        "address: " + address.getText(), Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//            }
//        });
//
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();

    }
}
