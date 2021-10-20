package com.example.service;

import com.example.entity.Item;
import com.example.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;


/**
 * @Author:wang tang
 */
@Service
public class ItemService {

    private Logger logger=Logger.getLogger("ItemService");


    @Autowired
    public ItemMapper itemMapper;


    public List<Item> getAllItemList(){
        List<Item> item = null;
        try{
            item = itemMapper.getAllItemList();
        }catch (Exception e){
            logger.info("getAllItemList |has exception"+e.getMessage());

        }
        return item;
    }



    public void updateItemCode(String code){
        try{
            itemMapper.updateItemCode(code);
        }catch (Exception e){
            //System.out.println(e.getMessage());
            logger.info("updateItemCode |"+code+"|has exception"+e.getMessage());
        }

    }


    public  void updateAddItemCode(String code){
        try{
            itemMapper.updateAddItemCode(code);

        }catch (Exception e){

            logger.info("updateItemCode |"+code+"|has exception"+e.getMessage());
        }

    }


    public  void updateTotalItemCode(Integer stock,String code){
        try{
            itemMapper.updateTotalItemCode(stock,code);

        }catch (Exception e){
            logger.info("updateTotalItemCode |"+stock+"|"+code+"|has exception"+e.getMessage());
        }

    }


    public Item  getItemCode(String code){
        try{
            return itemMapper.getItemCode(code);
        }catch (Exception e){

            logger.info("getItemCode |"+code+"|has exception"+e.getMessage());
        }
        return null;
    }


    public Integer  getCountItemCode(String code){
        try{
            return itemMapper.getCountItemCode(code);
        }catch (Exception e){

            logger.info("getItemCode |"+code+"|has exception"+e.getMessage());
        }
        return null;
    }

}
