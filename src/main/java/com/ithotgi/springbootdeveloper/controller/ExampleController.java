package com.ithotgi.springbootdeveloper.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class ExampleController {

    @GetMapping("/th/example")
    public String example(Model model){
        Person person = new Person();
        person.setId(1L);
        person.setName("홍길동");
        person.setAge(11);
        person.setHobbies(List.of("농구","당구","골프"));

        model.addAttribute("person", person);
        model.addAttribute("today", LocalDate.now());

        return "example";
    }

    @Setter
    @Getter
    class Person{
        private Long id;
        private String name;
        private int age;
        private List<String> hobbies;
    }

    @GetMapping("/th/example2")
    public String example2(Model model){
        // 간단한 데이터 설정
        User user = new User(1L, "홍길동", 30, true, Arrays.asList("당구", "축구", "음악"));

        // 오늘 날짜 설정
        LocalDate today = LocalDate.now();

        // 모델에 데이터 전달
        model.addAttribute("user", user);
        model.addAttribute("today", today);

        // Fragment로 전달할 데이터
        model.addAttribute("pageTitle", "타임리프 예제");
        model.addAttribute("headerText", "Thymeleaf Header Fragment");

        return "example2"; // example2.html 파일로 매핑
    }

    // 내부 클래스 - 테스트용 User 객체
    static class User {
        private Long id;
        private String name;
        private int age;
        private boolean loggedIn;
        private java.util.List<String> hobbies;

        public User(Long id, String name, int age, boolean loggedIn, java.util.List<String> hobbies) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.loggedIn = loggedIn;
            this.hobbies = hobbies;
        }

        // Getters
        public Long getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }
        public boolean isLoggedIn() { return loggedIn; }
        public java.util.List<String> getHobbies() { return hobbies; }
    }
}
