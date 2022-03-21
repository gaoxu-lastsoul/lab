class A {
    A() {
        i =( (j++ != 20) ? ++j : --j);
    }

    public int i=10;
    public static int j = 20;
}