import com.liyueze.simpleFactory.Factory;
import com.liyueze.common.ICourse;
import com.liyueze.common.JavaCourse;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        ICourse course1=new Factory().creatCourseByClass(JavaCourse.class);
        ICourse course2=new Factory().creatCourseByClass(null);
        ICourse course3=new Factory().creatCourseByString("Python");
        ICourse course4=new Factory().creatCourseByString("math");
        course1.study();
        course3.study();
        /*course2.study();
        course4.study();*/
    }
}
