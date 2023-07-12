package net.java.test.springbootsearchrestapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.java.test.springbootsearchrestapi.entity.SysMenu;
import net.java.test.springbootsearchrestapi.service.SysMenuService;

@Slf4j   // log 
@RestController
@RequestMapping("api/v1/sys_menu")
@CrossOrigin(origins = "*")
public class SysMenuController {
    
    private SysMenuService sysMenuService;

    public SysMenuController(SysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }

    @RequestMapping
    List readSysMenu() {
        log.info("===SysMenuController===");
        List<SysMenu> sysMenuList = (List<SysMenu>) sysMenuService.readSysMenu();

        // sysMenuList.remove(0);

        // List<Integer> list = new ArrayList<>();
        List<SysMenu> list = new ArrayList<>();
        List<SysMenu> list2 = new ArrayList<>();
        List<SysMenu> list3 = new ArrayList<>();
        List<SysMenu> list4 = new ArrayList<>();

        int i = 0;
        for (SysMenu element : sysMenuList) {
            System.out.println("第" + i + "次");
            
            System.out.println(element.getMENU_NAME());
            if ( "MID01".equals(element.getP_MENU_ID()) ) {
                System.out.println("heyhey I gonna remove: " + i); 
                // sysMenuList.remove(i);
                // list.add(i);
                list.add(element);
            }
            if ( "MID02".equals(element.getP_MENU_ID()) ) {
                System.out.println("heyhey I gonna remove: " + i); 
                // sysMenuList.remove(i);
                // list.add(i);
                list2.add(element);
            }
            if ( "MID03".equals(element.getP_MENU_ID()) ) {
                System.out.println("heyhey I gonna remove: " + i); 
                // sysMenuList.remove(i);
                // list.add(i);
                list3.add(element);
            }
            if ( "MID04".equals(element.getP_MENU_ID()) ) {
                System.out.println("heyhey I gonna remove: " + i); 
                // sysMenuList.remove(i);
                // list.add(i);
                list4.add(element);
            }
            i++;

        }
        System.out.println(list);

        List newSysMenuList = new ArrayList<>();

        // int tmp, tmp2;
        // tmp = list.get(0);
        // for (int j = 1; j < list.size(); j++) {
        //     tmp2 = list.get(j);
        //     list.set(j, list.get(j) - tmp);
        //     tmp = tmp2;
        // }
        System.out.println("list = "+ list);

        int beforeInt = 0;
        // for (Integer integer : list) {
        //     System.out.println("I gonna remove: " + sysMenuList.get(integer.intValue() - beforeInt).getMENU_NAME()); 
        //     newSysMenuList.add(sysMenuList.remove(integer.intValue() - beforeInt).getMENU_NAME());
        //     // newSysMenuList.add(sysMenuList.remove(integer.intValue() - beforeInt));
        //     beforeInt = integer.intValue();
        // }

        // for (Integer integer : list) {
        //     System.out.println("I gonna remove: " + sysMenuList.get(integer.intValue() - beforeInt).getMENU_NAME()); 
        //     newSysMenuList.add(sysMenuList.remove(integer.intValue()).getMENU_NAME());
        //     // newSysMenuList.add(sysMenuList.remove(integer.intValue() - beforeInt));
        // }

        sysMenuList.removeAll(list);
        sysMenuList.removeAll(list2);
        sysMenuList.removeAll(list3);
        sysMenuList.removeAll(list4);

        System.out.println(sysMenuList.size());

        System.out.println("newSysMenuList = " + newSysMenuList);

        System.out.println(list.size());

        List entities1 = new ArrayList<>();
        for (SysMenu element : list) {

            Map<Object,Object> newMap = new HashMap<>();

            newMap.put("MENU_ID", element.getMENU_ID());
            newMap.put("MENU_NAME", element.getMENU_NAME());
            newMap.put("P_MENU_ID", element.getP_MENU_ID());
            newMap.put("SEQ_NO", element.getSEQ_NO());
            newMap.put("ICON", element.getICON());
            newMap.put("PATH", element.getPATH());
            newMap.put("CREATOR", element.getCREATOR());
            newMap.put("CREATE_TIME", element.getCREATE_TIME());
            newMap.put("UPDATER", element.getUPDATER());
            newMap.put("UPDATE_TIME", element.getUPDATE_TIME());

            switch (element.getMENU_ID()) {
                case "MID0101":
                newMap.put("PAGE","pages//System/UserSet.vue");
                    break;
                case "MID0102":
                newMap.put("PAGE","pages//System/RoleSet.vue");
                    break;
                case "MID0103":
                newMap.put("PAGE","pages//System/MenuSet.vue");
                    break;

                default:
                    break;
            }
  
            entities1.add(newMap);
        }
        
        List entities2 = new ArrayList<>();
        for (SysMenu element : list2) {

            Map<Object,Object> newMap = new HashMap<>();

            newMap.put("MENU_ID", element.getMENU_ID());
            newMap.put("MENU_NAME", element.getMENU_NAME());
            newMap.put("P_MENU_ID", element.getP_MENU_ID());
            newMap.put("SEQ_NO", element.getSEQ_NO());
            newMap.put("ICON", element.getICON());
            newMap.put("PATH", element.getPATH());
            newMap.put("CREATOR", element.getCREATOR());
            newMap.put("CREATE_TIME", element.getCREATE_TIME());
            newMap.put("UPDATER", element.getUPDATER());
            newMap.put("UPDATE_TIME", element.getUPDATE_TIME());
            
            switch (element.getMENU_ID()) {
                case "MID0201":
                newMap.put("PAGE","pages//Practice1/Practice1-1.vue");
                    break;
                case "MID0202":
                newMap.put("PAGE","pages//Practice1/Practice1-2.vue");
                    break;
                case "MID0203":
                newMap.put("PAGE","pages//Practice1/Practice1-3.vue");
                    break;
                case "MID0204":
                newMap.put("PAGE", "pages//Practice1/Practice1-4.vue");

                default:
                    break;
            }

            entities2.add(newMap);
        }
        
        List entities3 = new ArrayList<>();
        for (SysMenu element : list3) {

            Map<Object,Object> newMap = new HashMap<>();

            newMap.put("MENU_ID", element.getMENU_ID());
            newMap.put("MENU_NAME", element.getMENU_NAME());
            newMap.put("P_MENU_ID", element.getP_MENU_ID());
            newMap.put("SEQ_NO", element.getSEQ_NO());
            newMap.put("ICON", element.getICON());
            newMap.put("PATH", element.getPATH());
            newMap.put("CREATOR", element.getCREATOR());
            newMap.put("CREATE_TIME", element.getCREATE_TIME());
            newMap.put("UPDATER", element.getUPDATER());
            newMap.put("UPDATE_TIME", element.getUPDATE_TIME());
            
            switch (element.getMENU_ID()) {
                case "MID0301":
                newMap.put("PAGE","pages//Practice2/Practice2-1.vue");
                    break;
                case "MID0302":
                newMap.put("PAGE","pages//Practice2/Practice2-2.vue");
                    break;

                default:
                    break;
            }


            entities3.add(newMap);
        }
        
        List entities4 = new ArrayList<>();
        for (SysMenu element : list4) {

            Map<Object,Object> newMap = new HashMap<>();

            newMap.put("MENU_ID", element.getMENU_ID());
            newMap.put("MENU_NAME", element.getMENU_NAME());
            newMap.put("P_MENU_ID", element.getP_MENU_ID());
            newMap.put("SEQ_NO", element.getSEQ_NO());
            newMap.put("ICON", element.getICON());
            newMap.put("PATH", element.getPATH());
            newMap.put("CREATOR", element.getCREATOR());
            newMap.put("CREATE_TIME", element.getCREATE_TIME());
            newMap.put("UPDATER", element.getUPDATER());
            newMap.put("UPDATE_TIME", element.getUPDATE_TIME());
            
            switch (element.getMENU_ID()) {
                case "MID0401":
                newMap.put("PAGE","pages//Practice3/Practice3-1.vue");
                    break;
                case "MID0402":
                newMap.put("PAGE","pages//Practice3/Practice3-2.vue");
                    break;
                case "MID0403":
                newMap.put("PAGE","pages//Practice3/Practice3-3.vue");
                break;

                default:
                    break;
            }


            entities4.add(newMap);
        }
        

        List entities = new ArrayList<>();
        for (SysMenu element : sysMenuList) {

            Map<Object,Object> newMap = new HashMap<>();

            newMap.put("MENU_ID", element.getMENU_ID());
            newMap.put("MENU_NAME", element.getMENU_NAME());
            newMap.put("P_MENU_ID", element.getP_MENU_ID());
            newMap.put("SEQ_NO", element.getSEQ_NO());
            newMap.put("ICON", element.getICON());
            newMap.put("PATH", element.getPATH());
            newMap.put("CREATOR", element.getCREATOR());
            newMap.put("CREATE_TIME", element.getCREATE_TIME());
            newMap.put("UPDATER", element.getUPDATER());
            newMap.put("UPDATE_TIME", element.getUPDATE_TIME());
            

            if (element.getSEQ_NO() == 1) {
                // newMap.put("children", list);
                newMap.put("children", entities1);
            }
            if (element.getSEQ_NO() == 2) {
                // newMap.put("children", list2);
                newMap.put("children", entities2);
            }
            if (element.getSEQ_NO() == 3) {
                // newMap.put("children", list3);
                newMap.put("children", entities3);
            }
            if (element.getSEQ_NO() == 4) {
                // newMap.put("children", list4);
                newMap.put("children", entities4);
            }

            
            entities.add(newMap);
        }
        

        return entities;
    }

    // @RequestMapping
    // List readSysMenu() {
    //     log.info("===SysMenuController===");
    //     List<SysMenu> sysMenuList = (List<SysMenu>) sysMenuService.readSysMenu();

    //     // sysMenuList.remove(0);

    //     List<Integer> list = new ArrayList<>();

    //     int i = 0;
    //     for (SysMenu element : sysMenuList) {
    //         System.out.println("第" + i + "次");
            
    //         System.out.println(element.getMENU_NAME());
    //         if ( "MID01".equals(element.getP_MENU_ID()) ) {
    //             System.out.println("heyhey I gonna remove: " + i); 
    //             // sysMenuList.remove(i);
    //             list.add(i);
    //         }
    //         i++;

    //     }
    //     System.out.println(list);

    //     List newSysMenuList = new ArrayList<>();

    //     int beforeInt = 0;
    //     for (Integer integer : list) {
    //         System.out.println("I gonna remove: " +sysMenuList.get(beforeInt).getMENU_NAME()); 
    //         // newSysMenuList.add(sysMenuList.remove(integer.intValue() - beforeInt).getMENU_NAME());
    //         newSysMenuList.add(sysMenuList.remove(integer.intValue() - beforeInt));
    //         beforeInt = integer.intValue();
    //     }

    //     System.out.println(sysMenuList.size());

    //     System.out.println("newSysMenuList = " + newSysMenuList);

    //     System.out.println(sysMenuList.get(0));

    //     // Convert data to a JsonArray
    //     JsonArray jsonArray = new JsonArray();

    //     for (SysMenu sm : sysMenuList) {
    //         JsonObject jsonObject = new JsonObject();
    //         jsonObject.addProperty("MENU_NAME",sm.getMENU_NAME());
    //         jsonObject.addProperty("MENU_ID", sm.getMENU_ID());

    //         if (sm.getP_MENU_ID() == null) {
    //             jsonObject.addProperty("P_MENU_ID", "");
    //         } else {
    //             jsonObject.addProperty("P_MENU_ID", sm.getP_MENU_ID());
    //         }

    //         jsonArray.add(jsonObject);
    //     }
    //     System.out.println(jsonArray);

    //     //Creating an empty ArrayList of type Object  
    //     ArrayList<Object> listdata = new ArrayList<>();  
    
    //     //Checking whether the JSON array has some value or not  
    //     if (jsonArray != null) {   
                
    //         //Iterating JSON array  
    //         for (i=0;i<jsonArray.size();i++){   
                    
    //             //Adding each element of JSON array into ArrayList  
    //             listdata.add(jsonArray.get(i));  
    //         }   
    //     }  

    //     System.out.println(listdata);

    //     return listdata;
    // }

}
