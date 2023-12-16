package DAO;

import Model.ChuyenXe;

import java.util.ArrayList;

public interface DA0_INTERFACE<T>{
    public T insert(T t);
    public T update(T t);
    public T delete(T t);
    public void selectAll();
    public int selectById(T t);
    public ArrayList<T> selectByCondition(String condition);
}
