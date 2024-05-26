class test2<T,U>
{
    T obj1;
    U obj2;

    test2(T obj1, U obj2)
    {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void print()
    {
        System.out.println(obj1);
        System.out.println(obj2);
    }

    public static void main(String[] args) {
        test2 <String, Integer> obj = new test2<String, Integer>("Two Classes", 15);
        obj.print();
}

}