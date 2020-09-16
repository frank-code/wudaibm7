package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml"); 

      StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate)
         context.getBean("studentJDBCTemplate");
      
      System.out.println("------Records Creation--------" );
      studentJDBCTemplate.create("小明", 11);
      studentJDBCTemplate.create("小强", 2);
      studentJDBCTemplate.create("小王", 15);

      System.out.println("------Listing Multiple Records--------" );
      List<Student> students = studentJDBCTemplate.listStudents();
      
      for (Student record : students) {
         System.out.print("ID : " + record.getId() );
         System.out.print(", Name : " + record.getName() );
         System.out.println(", Age : " + record.getAge());
      }  
   }
}