package com.example.dust.persondemo.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.dust.persondemo.IMyAidlInterface;
import com.example.dust.persondemo.bean.Person;

import java.util.ArrayList;
import java.util.List;
//import com.example.dust.persondemo.bean.Person;


public class MyService  extends Service {


    ArrayList<Person> mList;

    @Override
    public IBinder onBind(Intent intent) {

         mList = new ArrayList<>();

        return new MyBinder();
    }


    /**
     * 内部类
     */
    private class MyBinder extends IMyAidlInterface.Stub {

        @Override
        public String getName() throws RemoteException {
            return "服务端代码是猎人";
        }

        @Override
        public void addPerson(Person person) throws RemoteException {

            mList.add(person);

        }

        @Override
        public List<Person> getPersonList() throws RemoteException {
            return mList;
        }
    }
}
