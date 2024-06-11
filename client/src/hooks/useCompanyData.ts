import { useQuery } from 'react-query';
import axios from 'axios';

const BASE_URL = 'http://ec2-13-125-246-160.ap-northeast-2.compute.amazonaws.com:8080';

//API로부터 받을 데이터의 형태
type CompanyData = {
  companyId: number;
  code: string;
  korName: string;
  stockInfResponseDto: {
    stck_prpr: string;
    prdy_vrss: string;
    prdy_ctrt: string;
  };
};

// 커스텀 훅 정의 
function useCompanyData(startCompanyId: number, endCompanyId: number) {

  //데이터 가져오는 함수
  const fetchData = async (companyId: number) => {
    const url = `${BASE_URL}/companies/${companyId}`;
    const response = await axios.get<CompanyData>(url);
    return response.data;
  };

  // startCompanyId부터 endCompanyId까지의 범위에 있는 회사 ID 배열을 생성
  const companyIds = Array.from({ length: endCompanyId - startCompanyId + 1 }, (_, index) => startCompanyId + index);

  // 리액트-쿼리의 useQuery 훅 사용
  //companyIds 배열을 순회하며 fetchData 함수를 호출, 모든 호출이 완료될 때까지 기다림
  const { data, isLoading, isError } = useQuery<CompanyData[]>(
    ['companyData', startCompanyId, endCompanyId],
    async () => {
      const promises = companyIds.map((companyId) => fetchData(companyId));
      return Promise.all(promises);
    }
  );

  // 필요한 데이터 추출 및 저장
  const extractedData = data?.map((company) => {
    return {
      companyId: company.companyId,
      code: company.code,
      korName: company.korName,
      stockPrice: company.stockInfResponseDto.stck_prpr,
      stockChangeAmount: company.stockInfResponseDto.prdy_vrss,
      stockChangeRate: company.stockInfResponseDto.prdy_ctrt,
    };
  });

  return {
    data: extractedData,
    isLoading,
    isError,
  };
}

export default useCompanyData;
