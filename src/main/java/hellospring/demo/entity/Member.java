package hellospring.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Getter
@ToString(exclude = "memberPassword")
@NoArgsConstructor
// 매개변수 없는 생성자를 자동으로 만들어준다.
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    @Column(name = "member_email", unique = true)
    private String memberEmail;

    @Column(name = "member_password")
    private String memberPassword;

    @Column(name = "member_name")
    private String memberName;

    @Builder
    public Member(int memberId, String memberEmail, String memberPassword, String memberName){
        this.memberId = memberId;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
    }
}