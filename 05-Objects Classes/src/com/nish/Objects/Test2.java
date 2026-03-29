package com.nish.Objects;
class C {
    static { System.out.println("C static"); }
    { System.out.println("C instance"); }
    C() { System.out.println("C constructor"); }
}

class D extends C {
    static { System.out.println("D static"); }
    { System.out.println("D instance"); }
    D() { System.out.println("D constructor"); }
}

public class Test2 {
    public static void main(String[] args) {
        new D();
    }
}