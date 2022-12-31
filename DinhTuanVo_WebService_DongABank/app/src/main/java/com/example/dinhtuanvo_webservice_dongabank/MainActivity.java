package com.example.dinhtuanvo_webservice_dongabank;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dinhtuanvo_webservice_dongabank.adapter.MyArrayAdapter;
import com.example.dinhtuanvo_webservice_dongabank.model.TyGia;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ListView lvTigia;
    TextView txtdate;
    ArrayList<TyGia> dstygia;
    MyArrayAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvTigia = (ListView) findViewById(R.id.lv1);
        txtdate = (TextView) findViewById(R.id.txtdate);
        getdate();
        dstygia = new ArrayList<TyGia>();
        myadapter = new MyArrayAdapter(MainActivity.this, R.layout.layout_listview, dstygia);
        lvTigia.setAdapter(myadapter);
        TyGiaTask task = new TyGiaTask();
        task.execute();
    }

    public void getdate(){
        // Lấy giờ hệ thống
        Date currentDate = Calendar.getInstance().getTime();
        // Format theo định dạnh dd/mm/yyyy;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        // Hiển thị lên TextView
        txtdate.setText("Hôm nay: " + simpleDateFormat.format(currentDate));
    }

    class TyGiaTask extends AsyncTask<Void, Void, ArrayList<TyGia>>{
        @Override
        protected ArrayList<TyGia> doInBackground(Void... voids) {
            ArrayList<TyGia> ds = new ArrayList<TyGia>();
            try {
                // link Server
                URL url = new URL("http://dongabank.com.vn/exchange/export");
                // Mở connection
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                // Thiết lập method và GET dữ liệu
                connection.setRequestMethod("GET");
                // Thiết lập thuộc tính nó thuộc loại JSon nào, để biết sử dụng công cụ HttpRequester trong FireBox
                connection.setRequestProperty("Content-type", "application/json; charset=utf-8");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 ( compatible ) ");
                connection.setRequestProperty("Accept", "*/*");
                // Lấy dữ liệu và server trả về
                // Lấy chuỗi dữ liệu mà Input trả về
                InputStream is = connection.getInputStream();
                // Chuyển kiểu vè kiều UTF-8 và đưa vào bộ đọc dữ liệu
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                // Lưu và bộ đệm
                BufferedReader br = new BufferedReader(isr);

                String line = br.readLine();
                StringBuilder builder = new StringBuilder();
                while(line != null){
                    builder.append(line);
                    line = br.readLine();
                }
                String json = builder.toString();
                // Bỏ hai ngoặc tròn trong dữ liệu trả về
                json = json.replace("(", "");
                json = json.replace(")", "");
                JSONObject jsonObject = new JSONObject(json);
                JSONArray jsonArray = jsonObject.getJSONArray("items");
                for (int i = 0; i<jsonArray.length(); i++){
                    JSONObject item = jsonArray.getJSONObject(i);
                    TyGia tyGia = new TyGia();
                    tyGia.setType(item.getString("type"));
                    if (item.has("imageurl")){
                        tyGia.setImageurl(item.getString("imageurl"));
                        url = new URL(tyGia.getImageurl());
                        connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible) ");
                        connection.setRequestProperty("Accept", "*/*");
                        Bitmap bitmap = BitmapFactory.decodeStream(connection.getInputStream());
                        tyGia.setBitmap(bitmap);
                    }if(item.has("muatienmat")){
                        tyGia.setMuatienmat(item.getString("muatienmat"));
                    }if (item.has("muack")){
                        tyGia.setMuack(item.getString("muack"));
                    }if (item.has("bantienmat")){
                        tyGia.setBantienmat(item.getString("bantienmat"));
                    }if (item.has("banck")){
                        tyGia.setBanck(item.getString("banck"));
                    }
                    ds.add(tyGia);
                }
                Log.d("JSON_DONGA", json);
            }catch (Exception ex){
                Log.e("Fail!!!", ex.toString());
            }
            return ds;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            myadapter.clear();
        }

        @Override
        protected void onPostExecute(ArrayList<TyGia> tyGias) {
            super.onPostExecute(tyGias);
            myadapter.clear();
            myadapter.addAll(tyGias);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }
    }
}