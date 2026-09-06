//package com.Project.post_comment.Payload;
//
//import jakarta.validation.constraints.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class PostDto {
//
//    private int id;
//    @NotEmpty
//    @Size(min = 4 , message = "name should consist of 4 characters")
//    private String name;
//    @NotEmpty
//    private String city;
//    @NotEmpty
//    @Email(message = "Provide proper mail id")
//    private String email;
//    @NotEmpty
//    @Min(value = 1000000, message = "mobile no must be 10 digits")
//    private String mobile;
//}
