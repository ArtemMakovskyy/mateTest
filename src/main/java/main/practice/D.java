package main.practice;

 class D {
  public static void main(String[] args) {
   String s1 = "Hello";
   String s2 = new String("Hello").intern();
   String s4 = new String("Hello").intern();
   String s3 = "Hello";
   System.out.println(s1 == s2);  //true
   System.out.println(s1 == s3.intern());  //true
   System.out.println(s2.intern()== s4.intern());              //false
   System.out.println(s2==s4.intern());              //false
  }
}
