import com.liyueze.common.ICourse;
import com.liyueze.factoryMethod.FactoryAbstact;
import com.liyueze.factoryMethod.PythonFactory;

public class FactoryMethodTest {
    public static void main(String[] args) {
        FactoryAbstact factory = new PythonFactory();
        ICourse course = factory.creat();
        course.study();
    }
}
