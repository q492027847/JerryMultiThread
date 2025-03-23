package com.jerry.study.copy;

public class Myclass implements Cloneable{
    private String name;
    private int age;
    private String[] hobbies;

    public Myclass(String name, int age, String[] hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Myclass myclass = (Myclass) super.clone();
        myclass.hobbies = this.hobbies.clone();
        return myclass;
    }

    @Override
    public String toString() {
        return "Myclass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }


    //  nio实现文件读写
}
