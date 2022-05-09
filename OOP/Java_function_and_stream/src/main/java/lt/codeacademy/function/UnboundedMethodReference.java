package lt.codeacademy.function;

class TestClass {
    public String testMethod(String value) {
        return "testMethod " + value;
    }

    public static String secondMethod(String value) {
        return "second value " + value;
    }
}

interface Transform {
    String transform(TestClass testClass, String value);

    default String testTransformMethod(String value) {
        return "testTransformMethod " + value;
    }
}

interface SecondTransform {
    String getValue(String value);
}

public class UnboundedMethodReference {

    public static void main(String[] args) {
        //nuoroda/ referencas perduodant deklaracija kvietimo metu
        Transform transform = TestClass::testMethod;
        System.out.println(transform.testTransformMethod("value"));

        TestClass testClass = new TestClass();
        String kazkas = transform.transform(testClass, "kazkas");
        System.out.println(kazkas);
        System.out.println(testClass.testMethod("Kazkas2"));

        //2.referencas is sukurto objekto, noriu tureti rysi iis objekto
        SecondTransform secondTransform = testClass::testMethod;
        System.out.println(secondTransform.getValue("Mano kazkokia reiksme"));

        //3. refernce kai metodas statinis
        SecondTransform reference = TestClass::secondMethod;
        System.out.println(reference.getValue("Nauja reiksme"));
    }
}
