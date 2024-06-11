import { useQuery } from 'react-query';

type StockAsBiResponseDto = {
  stockAsBiId: number;
  companyId: number;
  askp1: string;
  askp2: string;
  // ... 나머지 필드들
};

type StockInfResponseDto = {
  stockInfId: number;
  companyId: number;
  stck_prpr: string;
  prdy_vrss: string;
  prdy_ctrt: string;
  acml_vol: string;
  acml_tr_pbmn: string;
};

type CompanyResponseDto = {
  companyId: number;
  code: string;
  korName: string;
  stockAsBiResponseDto: StockAsBiResponseDto;
  stockInfResponseDto: StockInfResponseDto;
};

type StarDataItem = {
  starId: number;
  memberId: number;
  companyResponseDto: CompanyResponseDto;
};

type StarData = StarDataItem[];

const useGetStar = () => {
  return useQuery<StarData, Error>('starData', fetchStarData);
};

const fetchStarData = async (): Promise<StarData> => {
  const accessToken = localStorage.getItem('accessToken');
  const res = await fetch('http://ec2-13-125-246-160.ap-northeast-2.compute.amazonaws.com:8080/stars', {
    headers: {
      'Authorization': `${accessToken}`
    }
  });
  
  if (!res.ok) {
    const data = await res.json();
    throw new Error(data.message || 'Something went wrong');
  }

  return res.json();
};



export default useGetStar;