package com.example.dinhtuan_ss06_basiccontrols;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtID, edtAddInfor;
    Button btnSubmit;
    CheckBox chkRNews, chkRBook, chkCoding;
    RadioGroup idCertificate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtID = findViewById(R.id.edtID);
        edtAddInfor = findViewById(R.id.edtAddInfor);
        btnSubmit = findViewById(R.id.btnSubmit);
        chkRNews = findViewById(R.id.chkRNews);
        chkRBook = findViewById(R.id.chkRBook);
        chkCoding = findViewById(R.id.chkCoding);
        idCertificate = findViewById(R.id.idCertificate);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Lấy thông tin họ tên
                String name = edtName.getText().toString();
                if (name.length() < 3){
                    Toast.makeText(MainActivity.this, "Họ tên phải >= 3 ký tự!", Toast.LENGTH_SHORT).show();
                    edtName.requestFocus(); // Đưa con trỏ về edtName
                    edtName.selectAll();
                    return;
                }

                String ID = edtID.getText().toString();
                if(ID.length() !=9){
                    Toast.makeText(MainActivity.this, "ID phải đúng 9 số!", Toast.LENGTH_SHORT).show();
                    edtID.requestFocus();
                    edtID.selectAll();
                    return;
                }

                // Lấy thông tin bằng cấp
                String certificate = "";
                int idSelect = idCertificate.getCheckedRadioButtonId(); // Lấy id của RadioButton được chọn trong group.
                RadioButton radioSelect = findViewById(idSelect); // Khai báo và tham chiếu id cho Radio Button được chọn.
                certificate = radioSelect.getText().toString();

                // Lấy thông tin sở thích
                String hobbies = "";
                if (chkRNews.isChecked()){
                    hobbies += chkRNews.getText().toString() + "\n";
                }
                if (chkRBook.isChecked()){
                    hobbies += chkRBook.getText().toString() + "\n";
                }
                if (chkCoding.isChecked()){
                    hobbies += chkCoding.getText().toString() + "\n";
                }

                // Lấy thông tin bổ sung
                String add = edtAddInfor.getText().toString();

                String general = "Name: " +  name + "\n" +"ID: " + ID + "\n" + "Certificate: " + certificate + "\n" + "Hobbies: " + hobbies + "\n";
                general += "------ THÔNG TIN BỔ SUNG ------ \n";
                general += add;
                general += "---------------------------------------------";

                // Tạo dialog để hiển thị thông tin lên
                AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);
                myDialog.setTitle("PERSONAL INFORMATION");
                myDialog.setMessage(general);
                myDialog.setPositiveButton("Canel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel(); // Thoát
                    }
                });
                myDialog.create().show();
            }
        });


    }

    // Khi người dùng nhất nút back
    @Override
    public void onBackPressed() {
        // Make AlertDialog
        AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);
        myDialog.setTitle("BYE");
        myDialog.setMessage("Are you sure you want to exit? ");
        myDialog.setIcon(R.drawable.btnexit);

        myDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish(); // Thoát ứng dụng
            }
        });
        myDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel(); // Thoát dialog
            }
        });

        myDialog.create().show(); // Hiển thị
    }

}