import ru.eshmakar.entity.Days;
import ru.eshmakar.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        session.save(new Student("Max"));
//        session.save(new Student("Max", Days.FRIDAY));
//        session.save(new Student("Max", Days.FRIDAY, new Date()));
        Student load = session.load(Student.class, 4);//если такого значения нет, выбрасится ObjectNotFoundException
        Student get = session.get(Student.class, 7);//если такого значения нет, выбрасится NullPointerException
        System.out.println(load.getName());
        System.out.println(get.getName());
        session.getTransaction().commit();
        session.close();
    }
}
