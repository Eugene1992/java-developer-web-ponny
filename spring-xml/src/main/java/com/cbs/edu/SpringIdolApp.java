package com.cbs.edu;

import com.cbs.edu.spring_xml.Auditorium;
import com.cbs.edu.spring_xml.Stage;
import com.cbs.edu.spring_xml.Ticket;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIdolApp {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("wire-by-property.xml");
        AbstractApplicationContext context
                = new ClassPathXmlApplicationContext(new String []{"wire-by-property.xml"});

//        Performer juggler = (Performer) context.getBean("duke");
//        juggler.perform();

//        Performer poeticDude = context.getBean("poeticDuke", Performer.class);
//        poeticDude.perform();

//        Performer kenny = context.getBean("kenny", Performer.class);
//        kenny.perform();
//        Ticket ticket1 = context.getBean("ticket", Ticket.class);
//        Ticket ticket2 = context.getBean("ticket", Ticket.class);

//        System.out.println(ticket1 == ticket2);

//        Auditorium auditorium = context.getBean(Auditorium.class);
//        context.destroy();

        Stage stage1 = context.getBean(Stage.class);
        Stage stage2 = context.getBean(Stage.class);
        System.out.println(stage1 == stage2);
    }
}
