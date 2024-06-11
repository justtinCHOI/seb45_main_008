package com.stockholm.main_project.stock.mapper;

import com.stockholm.main_project.member.entity.Member;
import com.stockholm.main_project.stock.dto.StockAsBiResponseDto;
import com.stockholm.main_project.stock.dto.StockInfResponseDto;
import com.stockholm.main_project.stock.dto.StockMinResponseDto;
import com.stockholm.main_project.stock.dto.StockOrderResponseDto;
import com.stockholm.main_project.stock.entity.Company;
import com.stockholm.main_project.stock.entity.StockAsBi;
import com.stockholm.main_project.stock.entity.StockInf;
import com.stockholm.main_project.stock.entity.StockMin;
import com.stockholm.main_project.stock.entity.StockOrder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-11T16:22:26+0900",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class StockMapperImpl implements StockMapper {

    @Override
    public StockInfResponseDto stockInfToStockInfResponseDto(StockInf stockInf) {
        if ( stockInf == null ) {
            return null;
        }

        StockInfResponseDto stockInfResponseDto = new StockInfResponseDto();

        stockInfResponseDto.setCompanyId( stockInfCompanyCompanyId( stockInf ) );
        stockInfResponseDto.setAcml_tr_pbmn( stockInf.getAcml_tr_pbmn() );
        stockInfResponseDto.setAcml_vol( stockInf.getAcml_vol() );
        stockInfResponseDto.setPrdy_ctrt( stockInf.getPrdy_ctrt() );
        stockInfResponseDto.setPrdy_vrss( stockInf.getPrdy_vrss() );
        stockInfResponseDto.setStck_prpr( stockInf.getStck_prpr() );
        stockInfResponseDto.setStockInfId( stockInf.getStockInfId() );

        return stockInfResponseDto;
    }

    @Override
    public StockAsBiResponseDto stockAsBiToStockAsBiResponseDto(StockAsBi stockAsBi) {
        if ( stockAsBi == null ) {
            return null;
        }

        StockAsBiResponseDto stockAsBiResponseDto = new StockAsBiResponseDto();

        stockAsBiResponseDto.setCompanyId( stockAsBiCompanyCompanyId( stockAsBi ) );
        stockAsBiResponseDto.setAskp1( stockAsBi.getAskp1() );
        stockAsBiResponseDto.setAskp10( stockAsBi.getAskp10() );
        stockAsBiResponseDto.setAskp2( stockAsBi.getAskp2() );
        stockAsBiResponseDto.setAskp3( stockAsBi.getAskp3() );
        stockAsBiResponseDto.setAskp4( stockAsBi.getAskp4() );
        stockAsBiResponseDto.setAskp5( stockAsBi.getAskp5() );
        stockAsBiResponseDto.setAskp6( stockAsBi.getAskp6() );
        stockAsBiResponseDto.setAskp7( stockAsBi.getAskp7() );
        stockAsBiResponseDto.setAskp8( stockAsBi.getAskp8() );
        stockAsBiResponseDto.setAskp9( stockAsBi.getAskp9() );
        stockAsBiResponseDto.setAskp_rsqn1( stockAsBi.getAskp_rsqn1() );
        stockAsBiResponseDto.setAskp_rsqn10( stockAsBi.getAskp_rsqn10() );
        stockAsBiResponseDto.setAskp_rsqn2( stockAsBi.getAskp_rsqn2() );
        stockAsBiResponseDto.setAskp_rsqn3( stockAsBi.getAskp_rsqn3() );
        stockAsBiResponseDto.setAskp_rsqn4( stockAsBi.getAskp_rsqn4() );
        stockAsBiResponseDto.setAskp_rsqn5( stockAsBi.getAskp_rsqn5() );
        stockAsBiResponseDto.setAskp_rsqn6( stockAsBi.getAskp_rsqn6() );
        stockAsBiResponseDto.setAskp_rsqn7( stockAsBi.getAskp_rsqn7() );
        stockAsBiResponseDto.setAskp_rsqn8( stockAsBi.getAskp_rsqn8() );
        stockAsBiResponseDto.setAskp_rsqn9( stockAsBi.getAskp_rsqn9() );
        stockAsBiResponseDto.setBidp1( stockAsBi.getBidp1() );
        stockAsBiResponseDto.setBidp10( stockAsBi.getBidp10() );
        stockAsBiResponseDto.setBidp2( stockAsBi.getBidp2() );
        stockAsBiResponseDto.setBidp3( stockAsBi.getBidp3() );
        stockAsBiResponseDto.setBidp4( stockAsBi.getBidp4() );
        stockAsBiResponseDto.setBidp5( stockAsBi.getBidp5() );
        stockAsBiResponseDto.setBidp6( stockAsBi.getBidp6() );
        stockAsBiResponseDto.setBidp7( stockAsBi.getBidp7() );
        stockAsBiResponseDto.setBidp8( stockAsBi.getBidp8() );
        stockAsBiResponseDto.setBidp9( stockAsBi.getBidp9() );
        stockAsBiResponseDto.setBidp_rsqn1( stockAsBi.getBidp_rsqn1() );
        stockAsBiResponseDto.setBidp_rsqn10( stockAsBi.getBidp_rsqn10() );
        stockAsBiResponseDto.setBidp_rsqn2( stockAsBi.getBidp_rsqn2() );
        stockAsBiResponseDto.setBidp_rsqn3( stockAsBi.getBidp_rsqn3() );
        stockAsBiResponseDto.setBidp_rsqn4( stockAsBi.getBidp_rsqn4() );
        stockAsBiResponseDto.setBidp_rsqn5( stockAsBi.getBidp_rsqn5() );
        stockAsBiResponseDto.setBidp_rsqn6( stockAsBi.getBidp_rsqn6() );
        stockAsBiResponseDto.setBidp_rsqn7( stockAsBi.getBidp_rsqn7() );
        stockAsBiResponseDto.setBidp_rsqn8( stockAsBi.getBidp_rsqn8() );
        stockAsBiResponseDto.setBidp_rsqn9( stockAsBi.getBidp_rsqn9() );
        stockAsBiResponseDto.setStockAsBiId( stockAsBi.getStockAsBiId() );

        return stockAsBiResponseDto;
    }

    @Override
    public StockMinResponseDto stockMinToStockMinResponseDto(StockMin stockMin) {
        if ( stockMin == null ) {
            return null;
        }

        StockMinResponseDto stockMinResponseDto = new StockMinResponseDto();

        stockMinResponseDto.setCompanyId( stockMinCompanyCompanyId( stockMin ) );
        stockMinResponseDto.setCntg_vol( stockMin.getCntg_vol() );
        stockMinResponseDto.setStck_cntg_hour( stockMin.getStck_cntg_hour() );
        stockMinResponseDto.setStck_hgpr( stockMin.getStck_hgpr() );
        stockMinResponseDto.setStck_lwpr( stockMin.getStck_lwpr() );
        stockMinResponseDto.setStck_oprc( stockMin.getStck_oprc() );
        stockMinResponseDto.setStck_prpr( stockMin.getStck_prpr() );
        stockMinResponseDto.setStockMinId( stockMin.getStockMinId() );
        stockMinResponseDto.setStockTradeTime( stockMin.getStockTradeTime() );

        return stockMinResponseDto;
    }

    @Override
    public StockOrderResponseDto stockOrderToStockOrderResponseDto(StockOrder stockOrder) {
        if ( stockOrder == null ) {
            return null;
        }

        StockOrderResponseDto stockOrderResponseDto = new StockOrderResponseDto();

        stockOrderResponseDto.setCompanyId( stockOrderCompanyCompanyId( stockOrder ) );
        stockOrderResponseDto.setMemberId( stockOrderMemberMemberId( stockOrder ) );
        stockOrderResponseDto.setModifiedAt( stockOrder.getModifiedAt() );
        stockOrderResponseDto.setOrderStates( stockOrder.getOrderStates() );
        stockOrderResponseDto.setOrderTypes( stockOrder.getOrderTypes() );
        stockOrderResponseDto.setPrice( stockOrder.getPrice() );
        stockOrderResponseDto.setStockCount( stockOrder.getStockCount() );
        stockOrderResponseDto.setStockOrderId( stockOrder.getStockOrderId() );

        return stockOrderResponseDto;
    }

    private long stockInfCompanyCompanyId(StockInf stockInf) {
        if ( stockInf == null ) {
            return 0L;
        }
        Company company = stockInf.getCompany();
        if ( company == null ) {
            return 0L;
        }
        long companyId = company.getCompanyId();
        return companyId;
    }

    private long stockAsBiCompanyCompanyId(StockAsBi stockAsBi) {
        if ( stockAsBi == null ) {
            return 0L;
        }
        Company company = stockAsBi.getCompany();
        if ( company == null ) {
            return 0L;
        }
        long companyId = company.getCompanyId();
        return companyId;
    }

    private long stockMinCompanyCompanyId(StockMin stockMin) {
        if ( stockMin == null ) {
            return 0L;
        }
        Company company = stockMin.getCompany();
        if ( company == null ) {
            return 0L;
        }
        long companyId = company.getCompanyId();
        return companyId;
    }

    private long stockOrderCompanyCompanyId(StockOrder stockOrder) {
        if ( stockOrder == null ) {
            return 0L;
        }
        Company company = stockOrder.getCompany();
        if ( company == null ) {
            return 0L;
        }
        long companyId = company.getCompanyId();
        return companyId;
    }

    private long stockOrderMemberMemberId(StockOrder stockOrder) {
        if ( stockOrder == null ) {
            return 0L;
        }
        Member member = stockOrder.getMember();
        if ( member == null ) {
            return 0L;
        }
        long memberId = member.getMemberId();
        return memberId;
    }
}
