package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.entities.AbstractEntity;

import java.util.List;
import java.util.NoSuchElementException;

public interface DAOService<T extends AbstractEntity> {

    List<T> getAll();

    T get(Integer id);

    void delete(Integer id);

    void update(T elem);

    T create(T elem);

    default int getListIdByDatabaseId(String idParam, List<T> list) {
        int id = Integer.parseInt(idParam);
        int i = 0;
        for (T elem : list) {
            if(elem.getId() == id){
                return i;
            }
            i++;
        }
        throw new NoSuchElementException("Not such id in list");
    }

    default T getElemByDatabaseId(String idParam, List<T> list) {
        int id = Integer.parseInt(idParam);
        for (T elem : list) {
            if(elem.getId() == id){
                return elem;
            }
        }
        throw new NoSuchElementException("No such element in list");
    }

    default int getNextIdForNewElem(List<T> list){
        if(list.isEmpty()){
            return 0;
        }
        int maxId = list.get(0).getId();
        for (T elem : list) {
            if(elem.getId() > maxId){
                maxId = elem.getId();
            }
        }
        return ++maxId;
    }
}
