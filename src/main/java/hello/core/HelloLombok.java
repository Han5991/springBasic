package hello.core;

import lombok.Data;

@Data
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("name");
        helloLombok.setAge(45);

        System.out.println(helloLombok);
    }
}
