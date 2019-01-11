package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.entities.AbstractEntity;

import java.util.List;

public abstract class AbstractService<T extends AbstractEntity> {

    int getNextIdForNewElem(List<T> list){
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
