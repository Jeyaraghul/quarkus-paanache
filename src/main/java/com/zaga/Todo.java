package com.zaga;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Todo extends PanacheEntity{

    public String title;
    public String url ;
    @Column (name= "ordering")
    public int order; 
    public boolean completed;

    public static void clearCompleted(){
        delete("completed = true ");
    }
    public static List<Todo> findByTiltle(String title){
  return list("title", title);
    }



 }


