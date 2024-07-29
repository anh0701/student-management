<details>
    <summary>26/07/2024</summary>
     1.

     ```java
     // Online Java Compiler
     // Use this editor to write, compile and run your Java code online
     import java.util.Scanner; 
     class HelloWorld {
         public static void main(String[] args) {
             Scanner sc = new Scanner(System.in);
             System.out.print("Nhap a, b, c: ");
             double a = sc.nextDouble();
             double b = sc.nextDouble();
             double c = sc.nextDouble();
             if(a == 0){
                 if(b == 0){
                     if(c == 0){
                         System.out.print("Vo so nghiem");
                     } else{
                         System.out.print("Vo nghiem");
                     }
                 } else{
                     System.out.printf("x = %.2f",-c/b);
                 }
             }else{
                 double delta = b * b - 4 * a * c;
                 if(delta < 0){
                     System.out.print("Vo nghiem");
                 } else if(delta == 0){
                     System.out.printf("x = %.2f",-b / (2 * a));
                 } else {
                     double x1 = ( -b + Math.sqrt(delta) ) / (2 * a);
                     double x2 = ( -b - Math.sqrt(delta) ) / (2 * a);
                     
                     System.out.printf("x1 = %.2f, x2 = %.2f", x1, x2);
                 }
                 
             }
             
         }
     }
     
     ```

        1. quản lý học sinh, nhập thông tin học sinh, xem thông tin học sinh, xem ds học sinh, xóa học sinh. note các tính chất OOP đã sử dụng
        2. QuanlySuVat - method laysuvat: List Persion -> list name
           ListConMeo -> list name
           co phai da hinh ko
</details>


<details>
<summary>29/07/2024</summary>
    Tiếp tục làm bài quản lý sinh viên, sử dụng interface và sử dụng kiểu tối ưu hơn List
</details>




  
