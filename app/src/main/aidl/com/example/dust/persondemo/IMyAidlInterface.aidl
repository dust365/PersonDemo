// IMyAidlInterface.aidl
package com.example.dust.persondemo;


import com.example.dust.persondemo.bean.Person;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    /*void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,double aDouble, String aString);*/

     /**
     * 获取名称
     * */
     String getName();



  /**
   *   添加 PersonBuild
   **/
    void addPerson(in Person person);


      /**
       *   获取 PersonBuild
       **/
    List<Person> getPersonList();


}
