package com.org.demo.provider;

import android.Manifest;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.org.helloworld.R;

import java.util.ArrayList;

public class ContentProviderActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        //获取通讯录信息
        findViewById(R.id.btn_get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContacts();
            }
        });
        //添加信息到通讯录
//        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addContact();
//            }
//        });
        findViewById(R.id.btn_add).setEnabled(false);
        findViewById(R.id.btn_get_permissions).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //从6.0系统开始,需要动态获取权限
                //读权限
                int permissionCheck = ContextCompat.checkSelfPermission(ContentProviderActivity.this, Manifest.permission.READ_CONTACTS);
                if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ContentProviderActivity.this, new String[]{Manifest.permission.READ_CONTACTS}, 0);
                }
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                //写权限
//                int permissionCheck2 = ContextCompat.checkSelfPermission(ContentProviderActivity.this, Manifest.permission.WRITE_CONTACTS);
//                if (permissionCheck2 != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(ContentProviderActivity.this, new String[]{Manifest.permission.WRITE_CONTACTS}, 1);
//                }
            }
        });
        //创建Test数据库
        findViewById(R.id.btn_create_test_db).setEnabled(false);
//        findViewById(R.id.btn_create_test_db).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NameContentProvider ncp = new NameContentProvider();
//                ncp.onCreate();
//                Log.e("a"," new NameContentProvider");
//            }
//        });
        //外部添加数据到Test数据库
        findViewById(R.id.btn_add_data_test).setEnabled(false);
//        findViewById(R.id.btn_add_data_test).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final ContentResolver resolver = ContentProviderActivity.this.getContentResolver();
//                ContentValues values = new ContentValues();
//                values.put("name", "测试");
//                Uri uri = Uri.parse("content://com.org.providers.MyProvider/test");
//                resolver.insert(uri, values);
//                Toast.makeText(getApplicationContext(), "数据插入成功", Toast.LENGTH_SHORT).show();
//            }
//        });

//        //从6.0系统开始,需要动态获取权限
//        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
//        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 0);
//        }
    }

    /**
     * 返回请求权限结果
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 0:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    Toast.makeText(ContentProviderActivity.this, "读取联系人权限授权成功", Toast.LENGTH_SHORT).show();
                }
                break;
            case 1:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    Toast.makeText(ContentProviderActivity.this, "写入联系人权限授权成功", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    private void getContacts() {
        //①查询raw_contacts表获得联系人的id
        ContentResolver resolver = getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        //查询联系人数据
        Cursor cursor = resolver.query(uri, null, null, null, null);
        String name = "";
        String num = "";
        while (cursor.moveToNext()) {
            //获取联系人姓名,手机号码
            String cName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String cNum = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            name = name + cName + "\n";
            num = num + cNum + "\n";

            Log.e("ttit", "姓名:" + cName);
            Log.e("ttit", "号码:" + cNum);
            Log.e("ttit", "======================");
        }
        Toast.makeText(getApplicationContext(), "姓名:" + name+"  号码:" + num, Toast.LENGTH_SHORT).show();
        cursor.close();
    }

    private void addContact() {
        try {
            //使用事务添加联系人
            Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
            Uri dataUri = Uri.parse("content://com.android.contacts/data");

            ContentResolver resolver = getContentResolver();
            ArrayList<ContentProviderOperation> operations = new ArrayList<ContentProviderOperation>();

//            //为了便于Android中进行批量数据库操作时效率更高，Android中推荐使用ContentProviderOperation
            ContentProviderOperation op1 = ContentProviderOperation.newInsert(uri)
                    .withValue("account_name", null)
                    .build();
            operations.add(op1);

            //依次是姓名，号码，邮编
            ContentProviderOperation op2 = ContentProviderOperation.newInsert(dataUri)
                    .withValueBackReference("raw_contact_id", 0)
                    .withValue("mimetype", "vnd.android.cursor.item/name")
                    .withValue("data2", "张三")
                    .build();
            operations.add(op2);

            ContentProviderOperation op3 = ContentProviderOperation.newInsert(dataUri)
                    .withValueBackReference("raw_contact_id", 0)
                    .withValue("mimetype", "vnd.android.cursor.item/phone_v2")
                    .withValue("data1", "13988888888")
                    .withValue("data2", "2")
                    .build();
            operations.add(op3);

            ContentProviderOperation op4 = ContentProviderOperation.newInsert(dataUri)
                    .withValueBackReference("raw_contact_id", 0)
                    .withValue("mimetype", "vnd.android.cursor.item/email_v2")
                    .withValue("data1", "1111111@qq.com")
                    .withValue("data2", "2")
                    .build();
            operations.add(op4);
            //将上述内容添加到手机联系人中~
            resolver.applyBatch("com.android.contacts", operations);
            Toast.makeText(getApplicationContext(), "添加成功", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("ttit", e.getMessage());
        }
    }
}
