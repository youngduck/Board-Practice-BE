package hellospring.demo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Board {
  
    Integer ID;
    String CONTENT;
    String TITLE;
    LocalDateTime CREATE_TIME;
    

    public boolean isValidTitle(String title){
        return title !=null && title.length()<=10;
    }

}
