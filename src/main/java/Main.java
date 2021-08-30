import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.eshmakar.oneToOne.HomeAddress;
import ru.eshmakar.oneToOne.Person;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        session.save(new Student("gener", Days.MONDAY));
//        session.save(new Student("Max", Days.FRIDAY, new Date()));

//        Student load = session.load(Student.class, 4);//достаем по id, если такого значения нет, выбрасится ObjectNotFoundException
//        System.out.println(load.getName());//выводим имя объекта
//        Student get = session.get(Student.class, 7);//если такого значения нет, выбрасится NullPointerException
//        System.out.println(get.getIdPlusAge());

//        Student st = new Student("Max");
//        st.setAddress(new Address("Lenina", 45));//добавляем адрес студента
//        session.save(st);

        HomeAddress homeAddress = new HomeAddress("Pushkina");
        Person person = new Person("MIN", homeAddress);
        homeAddress.setPerson(person);
        session.persist(person);
        session.persist(homeAddress);

        session.getTransaction().commit();
        session.close();
    }
}
