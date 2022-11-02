public class GenericClass {
    public static void main(String[] args) {
        Generic<Integer> integerObject = new Generic<Integer>(100);
        Generic<String> stringObject = new Generic<String>("hello");
        Generic<Boolean> booleanObject = new Generic<Boolean>(true);

        integerObject.showType();
        stringObject.showType();
        booleanObject.showType();

        int integer = integerObject.getObject();
        String str = stringObject.getObject();
        boolean bool = booleanObject.getObject();

        System.out.println("Integer: " + integer);
        System.out.println("String: " + str);
        System.out.println("Boolean: " + bool);
    }

}

class Generic<Type>{
    private Type object;
    public Generic(Type o) {object = o;}
    public Type getObject() {return object;}
    public void showType() {System.out.println(object.getClass().getName());}
}
