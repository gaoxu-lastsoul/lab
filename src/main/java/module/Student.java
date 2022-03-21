//package module;
//
//import lombok.Builder;
//import lombok.Data;
//
//@Data
//public class Student {
//    private Long id;
//    private  String firstName;
//    private  String lastName;
//    private  Double grade;
//    private Double feeDiscount = 0.0;
//    private Double baseFee = 2000.0;
//
//    public Student(String firstName, String lastName, Double grade) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.grade = grade;
//    }
//
//    public void printFee(){
//        Double newFee = baseFee - ((baseFee * feeDiscount)/100);
//        System.out.println("The fee after discount: " + newFee);
//    }
//}