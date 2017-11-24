/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andresfranco.testspring.controllers;

/**
 *
 * @author afranco
 */
public class GeneralController {
     
    String setRoute(String moduleName ,String type ,String id){
        String routePath ="";
        switch (type) {
            case "index":
                routePath ="/"+moduleName;
                break;
            case "show":
               routePath ="/"+moduleName+"/show/"+id;
                break; // optional
            case "edit":
                routePath ="/"+moduleName+"/edit/"+id;
                break; // optional
            case "delete":
                routePath ="/"+moduleName+"/delete/"+id;
                break; 
             case "update":
                routePath ="/"+moduleName+"/update";
                break; 
            case "new":
                routePath ="/"+moduleName+"/new";
                break; 
            case "create":
                routePath ="/"+moduleName+"/create";
                break; 
        }
        
        return routePath;
    }
   
}
