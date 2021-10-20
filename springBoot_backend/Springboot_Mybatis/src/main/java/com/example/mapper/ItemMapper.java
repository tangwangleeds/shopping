package com.example.mapper;

import com.example.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 @author wangtang
 */
@Repository
public interface ItemMapper {


    List<Item> getAllItemList();


    void updateItemCode( String code);


    void updateAddItemCode(String code);


    void updateTotalItemCode( Integer stock, String code);


    Item  getItemCode( String code);


    int getCountItemCode( String code);
}
