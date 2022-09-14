import com.ideas2it.AppConfig;
import com.ideas2it.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class EmployeeController {
    public static void main(String[] args) {

        ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
        Employee employee = (Employee) factory.getBean("employee");
        employee.callTrainer();
    }
}