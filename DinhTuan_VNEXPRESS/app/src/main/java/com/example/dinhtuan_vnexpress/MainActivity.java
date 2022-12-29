package com.example.dinhtuan_vnexpress;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import com.example.dinhtuan_vnexpress.adapter.MyArrayAdapter;
import com.example.dinhtuan_vnexpress.model.List;
import com.example.dinhtuan_vnexpress.service.XMLParser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ListView lv1;
    ArrayList<List> myList;
    MyArrayAdapter myadapter;
    String nodeName;
    String title = "";
    String link = "";
    String description = "";
    String des = "";
    String urlStr = "";
    Bitmap mIcon_val = null;
    String URL = "https://vnexpress.net/rss/thoi-su.rss";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1 = findViewById(R.id.lv1);
        myList = new ArrayList<List>();
        myadapter = new MyArrayAdapter(MainActivity.this, myList, R.layout.layout_listview);
        lv1.setAdapter(myadapter);
        LoadExampleTask task = new LoadExampleTask();
        task.execute();

    }

    class LoadExampleTask extends AsyncTask<Void, Void, ArrayList<List>>{
        @Override
        protected ArrayList<List> doInBackground(Void... voids) {
            myList = new ArrayList<List>();
            try {
                // Tạo đối tượng Parser để chứa dữ liệu từ file XML
                XmlPullParserFactory fc = XmlPullParserFactory.newInstance();
                XmlPullParser parser = fc.newPullParser();
                // Tạo mới và gọi đến phương thức getXmlFromUrl (URL)
                XMLParser myparser = new XMLParser();
                // getting XML from URL
                String xml = myparser.getXmlFromUrl(URL);
                parser.setInput(new StringReader(xml));
                // Bắt đầu duyệt parser
                int eventType = -1;
                while(eventType != XmlPullParser.END_DOCUMENT ){
                    eventType = parser.next();
                    switch (eventType){
                        case XmlPullParser.START_DOCUMENT:
                            break;
                        case XmlPullParser.END_DOCUMENT:
                            break;
                        case XmlPullParser.START_TAG:
                            nodeName = parser.getName();
                            if (nodeName.equals("title")){
                                title = parser.nextText();
                            }else if (nodeName.equals("link")){
                                link = parser.nextText();
                            }else if (nodeName.equals("description")){
                                description = parser.nextText();
                                try {
                                    urlStr = description.substring((description.indexOf("src=") + 5),(description.indexOf("8.jpg") + 5));
                                }catch (Exception e1){
                                    e1.printStackTrace();
                                }
                                des = description.substring(description.indexOf("</br>") + 5);
                                try {
                                    java.net.URL newurl = new URL(urlStr.toString() + "");
                                    mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream());
                                }catch (IOException e1){
                                    e1.printStackTrace();
                                }
                            }
                            break;
                            case XmlPullParser.END_TAG:
                                nodeName = parser.getName();
                                if (nodeName.equals("item")){
                                    myList.add(new List(mIcon_val, title, des, link));
                                }
                                break;
                    }
                }
            }catch (XmlPullParserException e){
                e.printStackTrace();
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
            return myList;
        }

        @Override
        protected void onPostExecute(ArrayList<List> result) {
            super.onPostExecute(result);
            myadapter.clear();
            myadapter.addAll(result);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            myadapter.clear();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}