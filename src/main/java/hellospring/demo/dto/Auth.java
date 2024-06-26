package hellospring.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Auth {
    Integer ID;
    String NAME;
    String EMAIL;
    String PASSWORD;
}
