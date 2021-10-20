package com.example.controller;

import com.example.entity.Item;
import com.example.redis.RedisTest;
import com.example.service.ItemService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/***
 @author wangtang
 */
@Slf4j
@RestController
@RequestMapping("/itemBoot")
public class ItemController {




    @Autowired
    private ItemService itemService;


    @RequestMapping("/selectItemList")
    public String getAllItemList(){
        log.info("------ enter selectItemList method");
        Gson gson =new Gson();
        List<Item> list= itemService.getAllItemList();
        String json=gson.toJson(list).toString();
        log.info("------  selectItemList response="+json);
        log.info("------ leave selectItemList method");
        return json;
    }


    @RequestMapping("updateItemCode/{code}")
    public String updateItemCode(@PathVariable String code){
        log.info("------ enter updateItemCode method code="+code);
        Integer  count=itemService.getCountItemCode(code);
        log.info("------  updateItemCode count="+count);
        if(count>0){
            RedisTest redisTest=new   RedisTest();
            itemService.updateItemCode(code);
            log.info("------ enter setkey");
            redisTest.setkey(code+count,count+"");
            log.info("------ leave setkey");
        }else{
            return "this item sold out";
        }
        log.info("------ leave updateItemCode method ");
        return "ok";
    }



    @RequestMapping("updateAddItemCode/{code}")
    public String updateAddItemCode(@PathVariable String code){
        itemService.updateAddItemCode(code);
        return "ok";
    }


    @RequestMapping("getItemCode/{code}")
    public String getItemCode(@PathVariable String code){
        Gson gson =new Gson();
        Item  item=itemService.getItemCode(code);
        if(item==null){
            return null;
        }
        return gson.toJson(item).toString();

    }

    @RequestMapping("getCountItemCode/{code}")
    public String getCountItemCode(@PathVariable String code){
        Gson gson =new Gson();
        Integer  count=itemService.getCountItemCode(code);
        if(count==null){
            return "0";
        }
        return gson.toJson(count).toString();

    }


}
