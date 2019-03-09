import com.liyueze.abastractFactory.DepartmentFactory;
import com.liyueze.abastractFactory.MathDepartmentFactory;
import com.liyueze.common.ICourse;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        DepartmentFactory department=new MathDepartmentFactory();
        ICourse course=department.creatJava();
        course.study();
    }
}
