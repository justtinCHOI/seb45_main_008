package com.stockholm.main_project.cash.mapper;

import com.stockholm.main_project.cash.dto.CashPatchDto;
import com.stockholm.main_project.cash.dto.CashPostDto;
import com.stockholm.main_project.cash.dto.CashResponseDto;
import com.stockholm.main_project.cash.entity.Cash;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-18T12:06:42+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.9 (Oracle Corporation)"
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
        cashResponseDto.setMoney( cash.getMoney() );
        cashResponseDto.setCreatedAt( cash.getCreatedAt() );
        cashResponseDto.setModifiedAt( cash.getModifiedAt() );

        return cashResponseDto;
    }
}
