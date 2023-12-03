package com.arifhoque.builder_pattern;

public class BuilderPattern {
    public static void main(String[] args) {
        Student student = new Student
                .Builder(101,"Ariful Hoque","Java ET")
                .address("Dhaka")
                .build();
    }
}

class Student {
    private Integer id;             // Mandatory field
    private String fullName;        // Mandatory filed
    private String nickName;        // Optional field
    private String batch;           // Mandatory field
    private String address;         // Optional field

    public Student(Builder builder) {
        this.id = builder.studentId;
        this.fullName = builder.fullName;
        this.nickName = builder.nickName;
        this.batch = builder.batchName;
        this.address = builder.address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullname='" + fullName + '\'' +
                ", nickname='" + nickName + '\'' +
                ", batch='" + batch + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder {
        private final Integer studentId;  // Mandatory field
        private final String fullName;    // Mandatory field
        private String nickName;          // Optional field
        private final String batchName;   // Mandatory field
        private String address;           // Optional field

        public Builder(Integer studentId, String fullName, String batchName) {
            this.studentId = studentId;
            this.fullName = fullName;
            this.batchName = batchName;
        }

        public Builder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
