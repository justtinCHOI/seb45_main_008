package com.stockholm.main_project.stock.entity;

import com.stockholm.main_project.audit.Auditable;
import com.stockholm.main_project.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StockHold extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stockHoldId;

    //Member와 연관 StockHold 엔티티 자동 삭제
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    // 실제 보유 주식 수량
    @Column
    private int stockCount;

    //특정 조건에서 예약한 주식 수량
    @Column
    private int reserveStockCount;

    @Column
    private long price;

}
