package com.stockholm.main_project.stock.service;

import com.stockholm.main_project.exception.BusinessLogicException;
import com.stockholm.main_project.exception.ExceptionCode;
import com.stockholm.main_project.stock.dto.StockasbiDataDto;
import com.stockholm.main_project.stock.entity.Company;
import com.stockholm.main_project.stock.entity.StockAsBi;
import com.stockholm.main_project.stock.mapper.ApiMapper;
import com.stockholm.main_project.stock.repository.StockAsBiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class StockAsBiService {

    private final StockAsBiRepository stockAsBiRepository;
    private final ApiCallService apiCallService;
    private final ApiMapper apiMapper;
    private final CompanyService companyService;

    public StockAsBiService(StockAsBiRepository stockAsBiRepository, ApiCallService apiCallService, ApiMapper apiMapper, CompanyService companyService) {
        this.stockAsBiRepository = stockAsBiRepository;
        this.apiCallService = apiCallService;
        this.apiMapper = apiMapper;
        this.companyService = companyService;
    }

    //StockAsBi 저장
    public StockAsBi saveStockAsBi(StockAsBi stockAsBi) {
        return stockAsBiRepository.save(stockAsBi);
    }

    //저장되어 있는 회사코드 -> AsBi 정보 update

    public void updateStockAsBi() throws InterruptedException {
        List<Company> companyList = companyService.findCompanies(); //모든 회사

        for(int i = 0; i < companyList.size(); i++) {
            // 주식 코드로 회사 불러오기
            Company company = companyService.findCompanyByCode(companyList.get(i).getCode());
            // 해당 회사의 asbi api호출하기
            StockasbiDataDto stockasbiDataDto = apiCallService.getStockasbiDataFromApi(company.getCode());
            // StockasbiDataDto -> StockAsBiOutput1 -> StockAsBi
            StockAsBi stockAsBi = apiMapper.stockAsBiOutput1ToStockAsBi(stockasbiDataDto.getOutput1());
            // 새로운 stockAsBi의 회사 등록
            stockAsBi.setCompany(company);
            // 호가 컬럼을 새로운 호가 컬럼으로 변경
            StockAsBi oldStockAsBi = company.getStockAsBi();
            stockAsBi.setStockAsBiId(oldStockAsBi.getStockAsBiId());
            company.setStockAsBi(stockAsBi);
            // 저장
            companyService.saveCompany(company);

            Thread.sleep(500);
        }
    }
    //companyId -> 회사의 StockAsBi 정보
    public StockAsBi getStockAsBi(long companyId) {
        Optional<StockAsBi> stock = stockAsBiRepository.findById(companyId);
        stock.orElseThrow(() -> new BusinessLogicException(ExceptionCode.STOCKASBI_NOT_FOUND));
        return stock.get();
    }

}
