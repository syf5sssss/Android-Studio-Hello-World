package com.org.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.org.helloworld.R;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Thread1Activity extends AppCompatActivity {

    TextView tv;
    String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread1);

        tv = (TextView)findViewById(R.id.ThreadText1);

        //1.继承Thread类
        findViewById(R.id.ThreadButton1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1.继承Thread类
                MyThread myThread = new MyThread();
                myThread.start();//开启一个线程方法
            }
        });
        //2.实现Runnable接口
        findViewById(R.id.ThreadButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable runnable = new RunnableThread();
                Thread thread = new Thread(runnable);
                thread.start();
            }
        });
        //3.CallableThread
        findViewById(R.id.ThreadButton3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Callable<String> callable = new CallableThread();
                FutureTask<String> futureTask = new FutureTask<String>(callable);
                Thread thread = new Thread(futureTask);
                thread.start();

//                doSomething();
                try {
                    String ResultVal = futureTask.get();//获取线程返回值
                    System.out.println("ResultVal = " + ResultVal);
                    AddMessage("ResultVal = " + ResultVal +" \n");
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
        //4.CallableThread Activity
        findViewById(R.id.ThreadButton4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Callable<String> callable = new CallableThread2();
                FutureTask<String> futureTask = new FutureTask<String>(callable);
                Thread thread = new Thread(futureTask);
                thread.start();

                try {
                    String ResultVal = futureTask.get();//获取线程返回值
                    System.out.println("ResultVal2 = " + ResultVal);
                    AddMessage("ResultVal2 = " + ResultVal +" \n");
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });




    }

    public class MyThread extends Thread {

        @Override
        public void run() {
            doSomething();
        }

        private void doSomething() {
            AddMessage("我是一个Thread线程中的方法 \n");
            System.out.println("我是一个Thread线程中的方法");
        }
    }
    public class RunnableThread implements Runnable {

        @Override
        public void run() {
            doSomeThing();
        }

        private void doSomeThing() {
            System.out.println("我是一个Runnable线程方法");
            AddMessage("我是一个Runnable线程方法 \n");
        }

    }
    public class CallableThread implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(200);
            doSomeThing();
            return "需要返回的值";
        }

        private void doSomeThing() {
            System.out.println("我是Callable线程中的方法");
            str = str +" 我是Callable线程中的方法 \n";
//            AddMessage("我是Callable线程中的方法 \n");
        }

    }
    public class CallableThread2 implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(200);
            doSomeThing();
            return "需要返回的值";
        }

        private void doSomeThing() {
            System.out.println("我是Callable线程中的方法");
            AddMessage("我是Callable修改页面线程中的方法 \n");
        }

    }



    /**
     * 添加信息
     * @param s
     */
    public void AddMessage(final String s)
    {
        Thread1Activity.this.runOnUiThread(new Runnable() {
            public void run() {
                str = str +""+s+" \n";
                tv.setText(str);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        str = "";
    }
}