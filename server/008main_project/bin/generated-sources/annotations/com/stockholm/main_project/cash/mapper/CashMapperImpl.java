package com.stockholm.main_project.cash.mapper;

import com.stockholm.main_project.cash.dto.CashPatchDto;
import com.stockholm.main_project.cash.dto.CashPostDto;
import com.stockholm.main_project.cash.dto.CashResponseDto;
import com.stockholm.main_project.cash.entity.Cash;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-11T16:22:26+0900",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class CashMapperImpl implements CashMapper {

    @Override
    public Cash cashPostToCash(CashPostDto requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Cash cash = new Cash();

        cash.setMoney( requestBody.getMoney() );

        return cash;
    }

    @Override
    public Cash cashPatchToCash(CashPatchDto requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Cash cash = new Cash();

        cash.setCashId( requestBody.getCashId() );
        cash.setMoney( requestBody.getMoney() );

        return cash;
    }

    @Override
    public CashResponseDto cashToCashResponseDto(Cash cash) {
        if ( cash == null ) {
            return null;
        }

        CashResponseDto cashResponseDto = new CashResponseDto();

        cashResponseDto.setCashId( cash.getCashId() );
        cashResponseDto.setCreatedAt( cash.getCreatedAt() );
        cashResponseDto.setModifiedAt( cash.getModifiedAt() );
        cashResponseDto.setMoney( cash.getMoney() );

        return cashResponseDto;
    }
}
